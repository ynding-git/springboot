package com.ynding.springboot.config;

import com.ynding.springboot.entity.Menu;
import com.ynding.springboot.entity.Role;
import com.ynding.springboot.web.data.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private MenuRepository menuRepository;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation)o).getRequestUrl();
        List<Menu> allMenu = menuRepository.findAll();
        for(Menu menu : allMenu){
            if(antPathMatcher.match(menu.getUrl(),requestUrl) && menu.getRoles().size() > 0){

                List<Role> roles = menu.getRoles();
                List<String> names = roles.stream().map(p -> p.getName()).collect(Collectors.toList());
                return SecurityConfig.createList((String[])names.toArray());
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
