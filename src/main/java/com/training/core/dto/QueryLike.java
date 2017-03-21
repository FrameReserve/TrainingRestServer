package com.training.core.dto;

import org.springframework.data.mongodb.core.query.Criteria;

public class QueryLike {

	public final static String OPERATOR_AND = "and";
	
	public final static String OPERATOR_OR = "or";
	
	public QueryLike() {
		super();
	}
	
	
	/**
	 * 默认：String类型、like比较、and运算
	 */
	public QueryLike(String columnName, Object value) {
		super();
		this.columnName = columnName;
		this.likeMode = LikeMode.Like;
		this.columnType = ColumnType.String;
		this.value = value;
	}
	
	/**
	 * 默认：and运算
	 */
	public QueryLike(String columnName, LikeMode likeMode) {
		super();
		this.columnName = columnName;
		this.likeMode = likeMode;
	}
	
	/**
	 * 默认：String类型、and运算
	 */
	public QueryLike(String columnName, LikeMode likeMode, Object value) {
		super();
		this.columnName = columnName;
		this.likeMode = likeMode;
		this.columnType = ColumnType.String;
		this.value = value;
	}
	
	/**
	 * 默认：and运算
	 */
	public QueryLike(String columnName, LikeMode likeMode, ColumnType columnType, Object value) {
		super();
		this.columnName = columnName;
		this.likeMode = likeMode;
		this.columnType = columnType;
		this.value = value;
	}

	public QueryLike(String columnName, LikeMode likeMode, ColumnType columnType, Object value, String operator) {
		super();
		this.columnName = columnName;
		this.likeMode = likeMode;
		this.columnType = columnType;
		this.value = value;
		this.operator = operator;
	}
	
	// -------------------- 静态生成方法 ---------------------------
	public static QueryLike eq(String hqlName) {
		return new QueryLike(hqlName, LikeMode.Eq);
	}
	
	public static QueryLike like(String hqlName) {
		return new QueryLike(hqlName, LikeMode.Like);
	}
	
	public static QueryLike ne(String hqlName) {
		return new QueryLike(hqlName, LikeMode.Ne);
	}
	
	public static QueryLike gt(String hqlName) {
		return new QueryLike(hqlName, LikeMode.Gt);
	}
	
	public static QueryLike ge(String hqlName) {
		return new QueryLike(hqlName, LikeMode.Ge);
	}
	
	public static QueryLike lt(String hqlName) {
		return new QueryLike(hqlName, LikeMode.Lt);
	}
	
	public static QueryLike le(String hqlName) {
		return new QueryLike(hqlName, LikeMode.Le);
	}
	
	public static QueryLike isNull(String hqlName) {
		return new QueryLike(hqlName, LikeMode.IsNull);
	}
	
	public static QueryLike isNotNull(String hqlName) {
		return new QueryLike(hqlName, LikeMode.IsNotNull);
	}
	
	public static QueryLike between(String hqlName) {
		return new QueryLike(hqlName, LikeMode.Between);
	}
	
	// -------------------- 属性 ---------------------------
	/**
	 * 列名
	 */
	private String columnName;
	
	/**
	 * 比较模式（like：'%value%'  |  eq ： = 'value'  ）
	 */
	private LikeMode likeMode;
	
	/**
	 * 数据类型：（String）、（Integer）、（Long）、（Date）
	 */
	private ColumnType columnType;
	
	/**
	 * 值
	 */
	private Object value;
	
	/**
	 * 值2
	 */
	private Object value2;
	
	/**
	 * 自定义Mongodb Criteria
	 */
	private Criteria criteria;
	
	/**
	 * 运算符：and  or
	 */
	private String operator = "and";
	
	/**
	 * 是否包含transient注解
	 */
	private Boolean isTransient = false;
	
	public enum ColumnType {
		
		Integer("I"), 
		Long("L"),
		Float("F"),
		Double("D"),
		String("S"),
		Boolean("B"),
		Date("T");
		
		 // 比较模式值：<、>、=、
        private String value;

        // 构造方法
        private ColumnType(String value) {
            this.value = value;
        }
        
        private static ColumnType[] numberColumnTypes = new ColumnType[] {
    			ColumnType.Integer, ColumnType.Long, ColumnType.Float, ColumnType.Double, ColumnType.Boolean
    		};
        
        public static ColumnType[] getNumberColumnTypes() {
        	return numberColumnTypes;
        }

		public String getValue() {
			return value;
		}

		@Override
		public String toString() {
			return value;
		}
	}
	
	public enum LikeMode {
		
		Eq("eq", "="), 
		NotEq("noteq", "!="), 
		Like("like", "like"),
		LikeSta("likesta", "like"),
		LikeEnd("likeend", "like"),
		Ne("ne", "<>"), 
		Gt("gt", ">"),
		Ge("ge", ">="),
		Lt("lt", "<"),
		Le("le", "<="),
		IsNull("isnull", "isnull"),
		IsNotNull("isnotnull", "!isnull"),
//		In("in", "in"),
//		NotIn("notin", "not in"),
		Between("between", "between"),
		Custom("Custom", "");
		
		// 编码，Custom自定义sql
		private String code;
		
        // 运算符
        private String value;

        // 构造方法
        private LikeMode(String code, String value) {
        	this.code = code;
            this.value = value;
        }
        
        public String getCode() {
			return code;
		}

		public String getValue() {
			return value;
		}

	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public LikeMode getLikeMode() {
		return likeMode;
	}

	public void setLikeMode(LikeMode likeMode) {
		this.likeMode = likeMode;
	}

	public ColumnType getColumnType() {
		return columnType;
	}

	public void setColumnType(ColumnType columnType) {
		this.columnType = columnType;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getOperator() {
		return operator;
	}

	public QueryLike setOperator(String operator) {
		this.operator = operator;
		return this;
	}


	public Boolean getIsTransient() {
		return isTransient;
	}


	public void setIsTransient(Boolean isTransient) {
		this.isTransient = isTransient;
	}


	public Object getValue2() {
		return value2;
	}


	public void setValue2(Object value2) {
		this.value2 = value2;
	}


	public Criteria getCriteria() {
		return criteria;
	}


	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}
	
}
