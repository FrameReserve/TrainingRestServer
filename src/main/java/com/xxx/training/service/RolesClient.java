package com.xxx.training.service;


import com.xxx.training.entity.domain.Roles;
import java.util.List;

/**
 * Created by xxx on 2016-06-05.
 */
public interface RolesClient {
    Roles save(Roles roles);
    List<Roles> findRolesByUserName(String userName);
    List<Roles> findAll();
}
