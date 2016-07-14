package com.training.producerconsumer.dto;

public class ConsumerDto implements Runnable {

	private QueueDto obj;  
    
    public ConsumerDto(QueueDto tq){  
        this.obj=tq;  
    }  
  
    public void run() {               
        try {  
            for(int i=0;i<10;i++){  
                obj.consumer();  
            }
        } catch (Exception e) {  
            e.printStackTrace();  
        }
    } 
    
}
