package com.training.producerconsumer.service;

import org.junit.Test;

import com.training.producerconsumer.dto.ConsumerDto;
import com.training.producerconsumer.dto.ProductDto;
import com.training.producerconsumer.dto.QueueDto;

public class ProducerConsumerServiceTest {

	@Test
	public void testpc() throws InterruptedException {
		QueueDto tq = new QueueDto();
		ProductDto tp = new ProductDto(tq);
		ConsumerDto tc = new ConsumerDto(tq);
		Thread t1 = new Thread(tp);
		Thread t2 = new Thread(tc);
		t1.start();
		t2.start();
		while (true) {
			
		}
	}

}
