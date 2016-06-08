package com.xxx.training.service.impl;

import com.xxx.training.BaseTest;
import com.xxx.training.dao.BaseDao;
import com.xxx.training.entity.domain.Resources;
import com.xxx.training.service.ResourcesClient;
import org.junit.Test;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by xxx on 2016-06-05.
 */
public class ResourcesClientImplTest extends BaseTest {
    @Inject
    private ResourcesClient resourcesClient;
    @Test
    public void findResourcesUrlByType() throws Exception {
        List<Resources> list = resourcesClient.findResourcesByType(1);
        System.out.println(list.get(0).getUrl());
    }

    @Test
    public void findAll(){
       List<Resources> list = resourcesClient.findAll();
       System.out.println(list.get(0).getName());
    }
}
