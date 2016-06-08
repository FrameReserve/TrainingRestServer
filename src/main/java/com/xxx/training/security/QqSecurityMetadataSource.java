package com.xxx.training.security;

import com.xxx.training.entity.domain.Resources;
import com.xxx.training.entity.domain.Roles;
import com.xxx.training.service.ResourcesClient;
import com.xxx.training.service.RolesClient;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by xxx on 2016-06-05.
 */
public class QqSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private static Map<String,Collection<ConfigAttribute>> resourceMap = null;

    private RolesClient rolesClient;
    private ResourcesClient resourcesClient;

    /**
     * 构造方法
     */
    //1
    public QqSecurityMetadataSource(RolesClient rolesClient,ResourcesClient resourcesClient){
        this.rolesClient=rolesClient;
        this.resourcesClient=resourcesClient;
        loadResourceDefine();
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object)throws IllegalArgumentException{
        HttpServletRequest request=((FilterInvocation)object).getRequest();
        Iterator<String> ite = resourceMap.keySet().iterator();
        while (ite.hasNext()){
            String resURL = ite.next();
            RequestMatcher requestMatcher = new AntPathRequestMatcher(resURL);
            if(requestMatcher.matches(request)){
                return resourceMap.get(resURL);
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
//        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath*:spring-bean.xml","classpath*:spring-mvc.xml"});
//        SessionFactory sessionFactory=(SessionFactory)context.getBean("sessionFactory");
//        Session session=(Session)sessionFactory.openSession();
        List<Roles> roleses = rolesClient.findAll();
        List<Resources> resourceses = resourcesClient.findAll();
        resourceMap = new HashMap<String,Collection<ConfigAttribute>>();
        for (Roles roles:roleses){
            ConfigAttribute ca = new SecurityConfig(roles.getName());
            for(Resources resources : resourceses){
                 String url = resources.getUrl();
                if(resourceMap.containsKey(url)){
                    Collection<ConfigAttribute> value = resourceMap.get(url);
                    value.add(ca);
                    resourceMap.put(url,value);

                }else {
                    Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
                    atts.add(ca);
                    resourceMap.put(url,atts);
                }
            }
        }
    }

//    public RolesClient getRolesClient() {
//        return rolesClient;
//    }

    public void setRolesClient(RolesClient rolesClient) {
        this.rolesClient = rolesClient;
    }

//    public ResourcesClient getResourcesClient() {
//        return resourcesClient;
//    }

    public void setResourcesClient(ResourcesClient resourcesClient) {
        this.resourcesClient = resourcesClient;
    }
}
