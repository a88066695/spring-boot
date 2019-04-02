package com.boot.demo.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public Realm realm(){
        //这里只为测试
        //所以用的是SimpleAccountRealm
        //实际开发中，一般自定义Realm
        SimpleAccountRealm realm = new SimpleAccountRealm();
        realm.addAccount("user","123456","USER");
        realm.addAccount("admin","123456","ADMIN");
        return realm;
    }

    @Bean
    public SecurityManager securityManager(Realm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);

        shiroFilter.setLoginUrl("/auth/login");
        shiroFilter.setFilterChainDefinitionMap(getFilterChainDefinitionMap());
        return shiroFilter;
    }

    private Map<String,String> getFilterChainDefinitionMap(){
        Map<String,String> filterChainMap = new LinkedHashMap<>();
        filterChainMap.put("/auth/login","authc");
        filterChainMap.put("/auth/logout","logout");
        filterChainMap.put("/**","user");
        return filterChainMap;
    }
}
