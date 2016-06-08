/**
 * 
 */
package com.xxx.training.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Transient;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

/**
 * Title: SpecificationUtil.java 
 * Description: 描述
 * @author Lai Zhen Wei
 * @created 2016-6-1 下午5:10:57
 */
public class SpecificationUtil {
	public static <T> Specification<T> byParam(final T domain) {
		return new Specification<T>() {
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query,
					CriteriaBuilder cb) {
				List<Predicate> pres = new ArrayList<Predicate>();
				Field[] fields = domain.getClass().getDeclaredFields();
				for (Field field : fields) {
                    Annotation[] array = field.getAnnotations();
                    for(Annotation annotation:array){
                        //注解判断还没测试
                       if(Transient.class== annotation.getClass()){
                           continue;
                       }
                    }
					try {
						field.setAccessible(true);
						if(null==field.get(domain)){continue;}
						pres.add(cb.equal(root.get(field.getName()),
								field.get(domain)));
					} catch (Exception e) {
						e.printStackTrace();
						throw new RuntimeException("属性查询,反射属性异常!");
					}
				}
				return cb.and(pres.toArray(new Predicate[] {}));
			}
		};
	}
}
