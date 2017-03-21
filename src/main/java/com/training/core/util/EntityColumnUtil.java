package com.training.core.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Transient;

import com.training.core.dto.Pair;
import com.training.core.dto.QueryLike;
import com.training.core.dto.QueryLike.ColumnType;
import com.training.core.dto.QueryLike.LikeMode;
import com.training.core.entity.BaseEntity;
import com.training.core.entity.MongodbBaseEntity;

@SuppressWarnings("unchecked")
public class EntityColumnUtil {

	/**
	 * 根据实体，反射动态查询条件
	 */
	public static List<QueryLike> generateEntityQueryLike(MongodbBaseEntity entity) {
		return generateEntityQueryLike(entity, entity.getClass());
	}
	
	/**
	 * 根据反射 ManyToOne 实体
	 * Pair<属性名, Class>
	 */
	public static List<Pair<String, Class>> generateEntityManyToOne(Class cls) {
		
		List<Pair<String, Class>> list = new ArrayList<Pair<String, Class>>();
		try {
			// 获取实体类的所有属性，返回Field数组
			Field[] fields = cls.getDeclaredFields();
			for (Field field : fields) {
				
				if (0 == field.getGenericType().toString().indexOf("class")) {
					Class tempcls = Class.forName(field.getGenericType().toString().substring(6));
					if (BaseEntity.class.isAssignableFrom(tempcls)) {
						list.add(new Pair<String, Class>(field.getName(), tempcls));
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return list;
	}
	
	/**
	 * 反射设置对象属性
	 * @return 
	 */
	public static Annotation getEntityPropertyAnnotation(Class entityClass, String propertyName, Class annotationClass) {
		
		try {
			// 获取实体类的所有属性，返回Field数组
			Field[] fields = entityClass.getDeclaredFields();
			for (Field field : fields) {
				
				if (propertyName.equals(field.getName())) {
					return field.getAnnotation(annotationClass);
				}
				
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return null;
		
	}
	
	/**
	 * 反射设置对象属性
	 */
	public static void setEntityProperty(MongodbBaseEntity entity, String propertyName, Object value) {
		
		try {
			// 获取实体类的所有属性，返回Field数组
			Field[] fields = entity.getClass().getDeclaredFields();
			for (Field field : fields) {
				
				if (propertyName.equals(field.getName())) {
					Method method = entity.getClass().getDeclaredMethod("set" + getMethodName(field.getName()), value.getClass());
					method.invoke(entity, value);// 调用getter方法获取属性值
				}
				
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	/**
	 * 根据实体值，赋值queryLikes
	 */
	public static List<QueryLike> setEntityQueryLike(MongodbBaseEntity entity, List<QueryLike> queryLikes) {
		
		// <属性名, QueryLike>
		Map<String, QueryLike> map = new HashMap<String, QueryLike>();
		for (QueryLike queryLike : queryLikes) {
			map.put(queryLike.getColumnName(), queryLike);
		}
		
		List<Field> declaredFields = getClassAllFields(entity, entity.getClass());
		List<Field> queryLikeFields = new ArrayList<Field>();
		for (Field field : declaredFields) {
			if (map.containsKey(field.getName())) {
				queryLikeFields.add(field);
			}
		}
		
		List<QueryLike> queryLikeValues = generateEntityQueryLike(entity, entity.getClass(), queryLikeFields);
		Map<String, QueryLike> resultMap = new HashMap<String, QueryLike>();
		for (QueryLike queryLike : queryLikeValues) {
			resultMap.put(queryLike.getColumnName(), queryLike);
		}
		for (QueryLike queryLike : queryLikes) {
			if (!resultMap.containsKey(queryLike.getColumnName()) || !ValidateUtil.isEmpty(queryLike.getValue())) {
				continue;
			}
			QueryLike temp = resultMap.get(queryLike.getColumnName());
			queryLike.setColumnType(temp.getColumnType());
			queryLike.setValue(temp.getValue());
			if (LikeMode.Between.getCode().equals(queryLike.getLikeMode().getCode())) {
				queryLike.setValue(temp.getValue());
				queryLike.setValue2(ValidateUtil.format("end_"+temp.getColumnName(), entity));
			}
		}
		
		return queryLikes;
	}
	
	// 获取实体所有Field，排除静态变量
	private static List<Field> getClassAllFields(MongodbBaseEntity entity, Class cls) {
		
		if (Object.class.getName().equals(cls.getName())) {
			return new ArrayList<Field>();
		}
		
		Field[] declaredFields = cls.getDeclaredFields();
		List<Field> list = new ArrayList<Field>();
		for (Field field : declaredFields) {
			
			// 排除静态变量
			boolean isStatic = Modifier.isStatic(field.getModifiers());
			if (isStatic) {
				continue;
			}
			
			list.add(field);
		}
		
		list.addAll(getClassAllFields(entity, cls.getSuperclass()));
		return list;
	}
	
	private static List<QueryLike> generateEntityQueryLike(MongodbBaseEntity entity, Class cls) {
		
		// 获取实体类的所有属性，返回Field数组
		Field[] declaredFields = cls.getDeclaredFields();
		List<Field> fields = Arrays.asList(declaredFields);
		return generateEntityQueryLike(entity, cls, fields);
	}
	
	private static List<QueryLike> generateEntityQueryLike(MongodbBaseEntity entity, Class cls, List<Field> fields) {

		if (Object.class.getName().equals(cls.getName())) {
			return new ArrayList<QueryLike>();
		}
		
		List<QueryLike> list = new ArrayList<QueryLike>();
		try {
			
			for (Field field : fields) {
				
				// 排除静态变量
				boolean isStatic = Modifier.isStatic(field.getModifiers());
				if (isStatic) {
					continue;
				}
				
				Transient transientTemp = field.getAnnotation(Transient.class);
				boolean isTransient = false;
				if (null != transientTemp) {
					isTransient = true;
				}				
				
				// 如果type是类类型，则前面包含"class "，后面跟类名
				// String类型
				if (field.getGenericType().toString().equals("class java.lang.String")) { 
					// 拿到该属性的gettet方法
					Method method = (Method) cls.getMethod("get" + getMethodName(field.getName()));
					String value = (String) method.invoke(entity);// 调用getter方法获取属性值
					if (value != null) {
						QueryLike queryLike = new QueryLike(field.getName(), value);
						queryLike.setIsTransient(isTransient);
						list.add(queryLike);
					}
				}

				// 如果类型是Integer
				if (field.getGenericType().toString().equals("class java.lang.Integer")) {
					Method m = (Method) cls.getMethod("get" + getMethodName(field.getName()));
					Integer value = (Integer) m.invoke(entity);
					if (value != null) {
						QueryLike queryLike = new QueryLike(field.getName(), LikeMode.Eq, ColumnType.Integer, value.toString());
						queryLike.setIsTransient(isTransient);
						list.add(queryLike);
					}
				}
				
				// 如果类型是Integer
				if (field.getGenericType().toString().equals("class java.lang.Long")) {
					Method m = (Method) cls.getMethod("get" + getMethodName(field.getName()));
					Long value = (Long) m.invoke(entity);
					if (value != null) {
						QueryLike queryLike = new QueryLike(field.getName(), LikeMode.Eq, ColumnType.Long, value.toString());
						queryLike.setIsTransient(isTransient);
						list.add(queryLike);
					}
				}

				// 如果类型是Double
				if (field.getGenericType().toString().equals("class java.lang.Double")) {
					Method m = (Method) cls.getMethod("get" + getMethodName(field.getName()));
					Double value = (Double) m.invoke(entity);
					if (value != null) {
						QueryLike queryLike = new QueryLike(field.getName(), LikeMode.Eq, ColumnType.Double, value.toString());
						queryLike.setIsTransient(isTransient);
						list.add(queryLike);
					}
				}

				// 如果类型是Boolean 是封装类
				if (field.getGenericType().toString().equals("class java.lang.Boolean")) {
					Method m = (Method) cls.getMethod("get" + getMethodName(field.getName()));
					Boolean value = (Boolean) m.invoke(entity);
					if (value != null) {
						QueryLike queryLike = new QueryLike(field.getName(), LikeMode.Eq, ColumnType.Boolean, value ? "1" : "0");
						queryLike.setIsTransient(isTransient);
						list.add(queryLike);
					}
				}

				// 如果类型是boolean 基本数据类型不一样 这里有点说名如果定义名是 isXXX的 那就全都是isXXX的
				// 反射找不到getter的具体名
				if (field.getGenericType().toString().equals("boolean")) {
					Method m = (Method) cls.getMethod("is" + getMethodName(field.getName()));
					Boolean value = (Boolean) m.invoke(entity);
					if (value != null) {
						QueryLike queryLike = new QueryLike(field.getName(), LikeMode.Eq, ColumnType.Boolean, value ? "1" : "0");
						queryLike.setIsTransient(isTransient);
						list.add(queryLike);
					}
				}
				
				// 如果类型是Date
				if (field.getGenericType().toString().equals("class java.util.Date")) {
					Method m = (Method) cls.getMethod("get" + getMethodName(field.getName()));
					Date value = (Date) m.invoke(entity);
					if (value != null) {
						QueryLike queryLike = new QueryLike(field.getName(), LikeMode.Eq, ColumnType.Date, DateUtil.formatDate(value));
						queryLike.setIsTransient(isTransient);
						list.add(queryLike);
					}
				}
				
				// 如果类型是Short
				if (field.getGenericType().toString().equals("class java.lang.Short")) {
					Method m = (Method) cls.getMethod("get" + getMethodName(field.getName()));
					Short value = (Short) m.invoke(entity);
					if (value != null) {
						QueryLike queryLike = new QueryLike(field.getName(), LikeMode.Eq, ColumnType.Integer, value.toString());
						queryLike.setIsTransient(isTransient);
						list.add(queryLike);
					}
				}
			}
			
			list.addAll(generateEntityQueryLike(entity, cls.getSuperclass()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return list;

	}

	// 把一个字符串的第一个字母大写、效率是最高的
	private static String getMethodName(String fildeName) throws Exception {
		byte[] items = fildeName.getBytes();
		items[0] = (byte) ((char) items[0] - 'a' + 'A');
		return new String(items);
	}

}
