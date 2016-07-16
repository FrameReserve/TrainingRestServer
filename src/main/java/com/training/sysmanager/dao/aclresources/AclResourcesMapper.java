package com.training.sysmanager.dao.aclresources;

import com.training.sysmanager.entity.AclResources;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by Athos on 2016-07-12.
 */
public interface AclResourcesMapper extends Mapper<AclResources> {

    /**
     *  查询所有类型是 请求 的资源
     *  返回包括{ROLE_MODULE_CRUD}
     *  为了方法级权限控制
     */
    @Select("SELECT resources.*,CONCAT('role_',CONCAT((SELECT pronoun FROM tbl_sysmgr_aclresources WHERE id = resources.parent_id),'_'),requesttype.pronoun) AS authority FROM tbl_sysmgr_aclresources AS resources LEFT JOIN tbl_sysmgr_aclrequesttype AS requesttype ON resources.request_type_id = requesttype.id WHERE resources.type = 'R'")
    @ResultMap("AclResourcesResultMap")
    List<AclResources> selectAclResourcesTypeOfRequest();

    /**
     *  根据类型查询资源
     *  返回不包括{ROLE_MODULE_CRUD}
     */
    @Select("SELECT * FROM tbl_sysmgr_aclresources WHERE type=#{type}")
    @ResultMap("AclResourcesResultMap")
    List<AclResources> selectAclResourcesByType(String type);

    /**
     * 根据 resourceIds 逗号间隔字符串 查询资源
     */
    @Select("SELECT resources.*,CONCAT('role_',CONCAT((SELECT pronoun FROM tbl_sysmgr_aclresources WHERE id = resources.parent_id),'_'),requesttype.pronoun) AS authority FROM tbl_sysmgr_aclresources AS resources LEFT JOIN tbl_sysmgr_aclrequesttype AS requesttype ON resources.request_type_id = requesttype.id WHERE resources.type = 'R' AND resources.id IN (#{resourceIds})")
    @ResultMap("AclResourcesResultMap")
    List<AclResources> selectAclResourcesByResourceIds(String resourceIds);
}
