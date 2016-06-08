package com.xxx.training.service;

import com.xxx.training.entity.domain.Resources;

import java.util.List;

/**
 * Created by xxx on 2016-06-05.
 */
public interface ResourcesClient {
    List<Resources> findResourcesByType(Integer type);
    List<Resources> findAll();
}
