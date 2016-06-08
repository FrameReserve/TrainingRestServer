package com.xxx.training.service.impl;

import com.xxx.training.dao.RolesDao;
import com.xxx.training.entity.domain.Roles;
import com.xxx.training.service.RolesClient;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by xxx on 2016-06-05.
 */
@Service
public class RolesClientImpl implements RolesClient {
    @Inject
    private RolesDao rolesDao;
    @Override
    public Roles save(Roles roles){return rolesDao.save(roles);}
    @Override
    public List<Roles> findRolesByUserName(String userName){return  rolesDao.findRolesByUserName(userName);}

    @Override
    public List<Roles> findAll() {
        return rolesDao.findAll();
    }
}
