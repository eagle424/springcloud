package com.ba.springcloud.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * ResourceServerConfigurerAdapter的默认实现是访问任何资源
 * 
 * @author Administrator
 * @date 2019年4月8日
 * @version 1.0
 */
@Configuration
@EnableResourceServer
//@Order(3)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter  {

//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//                // Since we want the protected resources to be accessible in the UI as well we need
//                // session creation to be allowed (it's disabled by default in 2.0.6)
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//                .and()
//                .requestMatchers().anyRequest()
//                .and()
//                .anonymous()
//                .and()
//                .authorizeRequests() 
////              .antMatchers("/product/**").access("#oauth2.hasScope('select') and hasRole('ROLE_USER')")
//                .antMatchers("/user/**").authenticated();//必须认证过后才可以访问
//    }


//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.requestMatchers().anyRequest()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/api/**").authenticated();
//    }
	
	/**
	 * 在这里如果以/free/**请求路径的，都允许直接访问。否则，都必须携带access_token才能访问。
	 */
//	@Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//                .and().authorizeRequests().antMatchers("/free/**").permitAll()
//                .and().authorizeRequests().anyRequest().authenticated()
//                .and().formLogin().permitAll();//必须认证过后才可以访问
//    }
	
	
}
