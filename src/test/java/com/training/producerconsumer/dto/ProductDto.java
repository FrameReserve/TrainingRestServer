package com.training.producerconsumer.dto;

public class ProductDto implements Runnable {

	private QueueDto obj;

	public ProductDto(QueueDto tq) {
		this.obj = tq;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				obj.product("test" + i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
