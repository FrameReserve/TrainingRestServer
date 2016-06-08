package com.xxx.training.dao;

import com.xxx.training.entity.domain.Roles;


import java.util.List;

/**
 * Created by xxx on 2016-06-05.
 */
public interface RolesDao extends BaseDao<Roles,Integer> {
    List<Roles> findRolesByUserName(String userName);
}
