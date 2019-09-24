package com.ynding.springboot.config;

import com.ynding.springboot.web.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;
    @Autowired
    CustomMetadataSource metadataSource;
    @Autowired
    UrlAccessDecisionManager urlAccessDecisionManager;
    @Autowired
    AuthenticationAccessDeniedHandler deniedHandler;

    /**
     * 用户存储
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("index.html","static/**","login_p");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //任何请求会跳到登录界面
        http
                .authorizeRequests()
                   .antMatchers("/resources/**","/ws/**", "/","/h2-console/*","/**/register").permitAll()
                   .anyRequest().authenticated()
               /* .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(metadataSource);
                        o.setAccessDecisionManager(urlAccessDecisionManager);
                        return o;
                    }
                })*/
//                .and()
//                .formLogin()
//                .loginPage("/login_p")//登录页
//                .loginProcessingUrl("/login")//登录提交的处理Url
//                .usernameParameter("username") //form表单密码参数名
//                .passwordParameter("password")//form表单用户名参数名
//                .permitAll()////允许所有用户都有权限访问登录页面
//                .and()
//                .logout()
//                .permitAll()
//                .and()
//                .csrf().disable()
//                .exceptionHandling().accessDeniedHandler(deniedHandler)
                ;//启用HTTP Basic认证

    }
}
