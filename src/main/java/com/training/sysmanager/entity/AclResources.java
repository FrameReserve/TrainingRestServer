package com.training.sysmanager.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.training.core.annotation.MapperClass;
import com.training.core.entity.BaseEntity;
import com.training.sysmanager.dao.aclresources.AclResourcesMapper;
import org.apache.ibatis.type.Alias;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by Athos on 2016-06-29.
 */
@NameStyle(value = Style.camelhumpAndLowercase)
@Table(name = "tbl_sysmgr_aclresources")
@Alias("AclResources")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@MapperClass(AclResourcesMapper.class)
public class AclResources extends BaseEntity {
    public AclResources(){}

    /**
     * 资源地址
     * 可以是一个模块的请求地址,或者是一个按钮的请求地址
     */
    @Column
    private String url;

    /**
     * 资源类型
     * 初期计划可以是 请求类型 模块 等等,统一定义为资源
     */
    @Column
    private String type;

    /**
     * 资源名称
     * 资源的中文名,为了友好显示
     */
    @Column
    private String name;
    /**
     * 资源代号
     * 实际上上是模块实体类的名字全小写,如果是按钮,可以是read query等
     */
    @Column
    private String pronoun;

    /**
     *  上级资源
     */
    @Column
    private Integer refId;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPronoun() {
        return pronoun;
    }

    public void setPronoun(String pronoun) {
        this.pronoun = pronoun;
    }

    public Integer getRefId() {
        return refId;
    }

    public void setRefId(Integer refId) {
        this.refId = refId;
    }
}
