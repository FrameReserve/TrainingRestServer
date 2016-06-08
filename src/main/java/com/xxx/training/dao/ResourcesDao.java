package com.xxx.training.dao;


import com.xxx.training.entity.domain.Resources;

import java.util.List;

/**
 * Created by xxx on 2016-06-05.
 */
public interface ResourcesDao extends BaseDao<Resources,Integer> {
    List<Resources> findResourcesByType(Integer type);
}
