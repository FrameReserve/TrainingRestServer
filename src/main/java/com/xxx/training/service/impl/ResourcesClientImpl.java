package com.xxx.training.service.impl;

import com.xxx.training.dao.ResourcesDao;
import com.xxx.training.entity.domain.Resources;
import com.xxx.training.service.ResourcesClient;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by xxx on 2016-06-05.
 */
@Service
public class ResourcesClientImpl implements ResourcesClient {
    @Inject
    private ResourcesDao resourcesDao;
    @Override
    public List<Resources> findResourcesByType(Integer type) {
        return resourcesDao.findResourcesByType(type);
    }

    @Override
    public List<Resources> findAll() {
        return resourcesDao.findAll();
    }
}
