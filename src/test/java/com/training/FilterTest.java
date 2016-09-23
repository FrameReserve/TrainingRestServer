package com.training;

import java.util.List;

import org.junit.Test;

import com.training.core.util.AssertUtils;
import com.training.core.util.StringUtil;

public class FilterTest {

	@Test
	public void testaa() {
		
		String filterStr = "id_L_3_EQ_OR,";
		String expReg = "([^\\_]*)_([^\\_]*)_([^\\_]*)_(.*?)_(.*?),";

		AssertUtils.isTrue(filterStr.matches(expReg), "错误的格式，请调整如下例：name_S_ch_LIKE__entity.entitySet,name_IC_ch_LIKE_OR_");
		
		List<String[]> exps = StringUtil.matchAll(filterStr, expReg);
		for (String[] singleExp : exps) {
			for (String str : singleExp) {
				System.out.println(str);
			}
		}
	}
	
}
