/**
 * 
 */
package com.xxx.training.entity.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.xxx.training.entity.domain.Qq;

/**
 * @author xxx
 * 如果一个LIST 要返回XML 就要写这么一个VO
 */
@XmlRootElement(name = "qqs")
public class Qqs {
	private int count;
	private List<Qq> qqs;

	public Qqs() {
	}

	public Qqs(List<Qq> qqs) {
		this.qqs = qqs;
		this.count = qqs.size();
	}

	/**
	 * @author xxx
	 * @created 2016-5-31 下午12:02:27
	 * @return type
	 */

	public int getCount() {
		return count;
	}

	/**
	 * @author xxx
	 * @created 2016-5-31 下午12:02:27
	 * @param count
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @author xxx
	 * @created 2016-5-31 下午12:02:27
	 * @return type
	 */
	@XmlElement(name="qq")
	public List<Qq> getQqs() {
		return qqs;
	}

	/**
	 * @author xxx
	 * @created 2016-5-31 下午12:02:27
	 * @param qqs
	 */
	public void setQqs(List<Qq> qqs) {
		this.qqs = qqs;
	}

}
