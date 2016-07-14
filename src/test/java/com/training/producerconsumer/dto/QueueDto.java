package com.training.producerconsumer.dto;

import java.util.ArrayList;
import java.util.List;

public class QueueDto {

	public static Object signal = new Object();
	boolean bFull = false;
	private List<String> thingsList = new ArrayList<String>();

	/**
	 * 生产
	 * 
	 * @param thing
	 * @throws Exception
	 */
	public void product(String thing) throws Exception {
		synchronized (signal) {
			if (!bFull) {
				bFull = true;
				// 产生一些东西，放到 thingsList 共享资源中
				System.out.println("product");
				System.out.println("仓库已满，正等待消费...");
				thingsList.add(thing);
				signal.notify(); // 然后通知消费者
			}
			signal.wait(); // 然后自己进入signal待召队列

		}

	}

	/**
	 * 消费
	 * 
	 * @return
	 * @throws Exception
	 */
	public String consumer() throws Exception {
		synchronized (signal) {
			if (!bFull) {
				signal.wait(); // 进入signal待召队列，等待生产者的通知
			}
			bFull = false;
			// 读取buf 共享资源里面的东西
			System.out.println("consume");
			System.out.println("仓库已空，正等待生产...");
			signal.notify(); // 然后通知生产者
		}
		String result = "";
		if (thingsList.size() > 0) {
			result = thingsList.get(thingsList.size() - 1).toString();
			thingsList.remove(thingsList.size() - 1);
		}
		return result;
	}

}
