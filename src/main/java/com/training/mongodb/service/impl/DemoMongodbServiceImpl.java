package com.training.mongodb.service.impl;

import org.springframework.stereotype.Service;

import com.training.core.service.impl.MongodbBaseServiceImpl;
import com.training.mongodb.entity.DemoMongodb;
import com.training.mongodb.service.DemoMongodbService;

@Service
public class DemoMongodbServiceImpl extends MongodbBaseServiceImpl<DemoMongodb> implements DemoMongodbService {

}
