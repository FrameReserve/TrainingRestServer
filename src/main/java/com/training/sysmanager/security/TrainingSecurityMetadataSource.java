package com.training.sysmanager.security;

import com.training.sysmanager.entity.AclResources;
import com.training.sysmanager.entity.AclRole;
import com.training.sysmanager.service.aclresources.AclResourcesService;
import com.training.sysmanager.service.aclrole.AclRoleService;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by Athos on 2016-07-06.
 */
public class TrainingSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private static Map<String,Collection<ConfigAttribute>> aclResourceMap = null;

    private AclRoleService aclRoleService;
    private AclResourcesService aclResourcesService;

    /**
     * 构造方法
     */
    //1
    public TrainingSecurityMetadataSource(AclRoleService aclRoleService, AclResourcesService aclResourcesService){
        this.aclRoleService=aclRoleService;
        this.aclResourcesService=aclResourcesService;
        loadResourceDefine();
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object)throws IllegalArgumentException{
        HttpServletRequest request=((FilterInvocation)object).getRequest();
        Iterator<String> ite = aclResourceMap.keySet().iterator();
        while (ite.hasNext()){
            String resURL = ite.next();
            RequestMatcher requestMatcher = new AntPathRequestMatcher(resURL);
            if(requestMatcher.matches(request)){
                return aclResourceMap.get(resURL);
            }
        }
        return null;
    }
    //4
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        System.out.println("metadata : getAllConfigAttributes");
        return null;
    }
    //3
    @Override
    public boolean supports(Class<?> clazz) {
        System.out.println("metadata : supports");
        return true;
    }


    private void loadResourceDefine(){
        List<AclRole> aclRoles = aclRoleService.selectAll();
        List<AclResources> aclResources = aclResourcesService.selectAll();
        aclResourceMap = new HashMap<String,Collection<ConfigAttribute>>();
        for (AclRole aclRole:aclRoles){
            ConfigAttribute ca = new SecurityConfig(aclRole.getRoleName());
            for(AclResources resources : aclResources){
                String url = resources.getUrl();
                if(aclResourceMap.containsKey(url)){
                    Collection<ConfigAttribute> value = aclResourceMap.get(url);
                    value.add(ca);
                    aclResourceMap.put(url,value);

                }else {
                    Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
                    atts.add(ca);
                    aclResourceMap.put(url,atts);
                }
            }
        }
    }


    public void setAclRoleService(AclRoleService aclRoleService) {
        this.aclRoleService = aclRoleService;
    }

    public void setAclResourcesService(AclResourcesService aclResourcesService) {
        this.aclResourcesService = aclResourcesService;
    }
}
