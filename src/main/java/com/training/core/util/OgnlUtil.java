package com.training.core.util;

import java.util.StringTokenizer;

import ognl.Ognl;

/**
 * OgnlUtil
 * @author zeng yuanjin
 * @date 2012-11-1 上午10:59:11
 */
public class OgnlUtil {

	static public<T> void setValueOgl(String ognl, T templateObject, Object value) {
		if (null==templateObject||ValidateUtil.isEmpty(ognl)) {
			return;
		}
		try {
			Ognl.setValue(ognl, templateObject, value);
		}catch(Exception e) {
			throw new RuntimeException("setValueOgl " + e.getMessage());
		}
	}

	static public<T> Object evalOgl(String ogl, T templateObject) {
		if (ValidateUtil.isNull(templateObject)) {
			return null;
		}
		try {
			StringTokenizer st = new StringTokenizer(ogl,"."); 
		
			String waitToEval = "";
			while(st.hasMoreTokens()) {   
				String token = st.nextToken();
				waitToEval += waitToEval.isEmpty() ? token : ("."+token);
				Object ognlvalue = Ognl.getValue(waitToEval, templateObject);
				if (null==ognlvalue) {
					return null;
				}				
			}
			
			return Ognl.getValue(ogl, templateObject);
			
		} catch (Exception e){
			throw new RuntimeException(e);
		}
	}
	
}
