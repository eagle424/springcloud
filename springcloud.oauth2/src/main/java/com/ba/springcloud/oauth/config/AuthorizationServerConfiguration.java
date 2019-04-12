package com.ba.springcloud.oauth.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

/**
 * [/oauth/authorize]
 * [/oauth/token]
 * [/oauth/check_token]
 * [/oauth/confirm_access]
 * [/oauth/token_key]
 * [/oauth/error]
 * 
 * @author Administrator
 * @date 2019年4月8日
 * @version 1.0
 */
//@Configuration
//@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
	
	/**
	 * TokenStore
	 * @return
	 */
    @Bean
    public TokenStore tokenStore(){
    	TokenStore tokenStore = null; 
    	// Redis's TokenStore
    	// tokenStore = new RedisTokenStore(connectionFactory);
    	// InMemory TokenStore
    	tokenStore = new InMemoryTokenStore();
    	// JDBC TokenStore
//    	tokenStore = new JdbcTokenStore(dataSource);
        return tokenStore;
    }
    
    
    @Bean("jdbcTokenStore")
    public JdbcTokenStore getJdbcTokenStore() {
        return new JdbcTokenStore(dataSource);
    }
    
	@Autowired
    private AuthenticationManager authenticationManager;
    
//	@Autowired
//    private RedisConnectionFactory connectionFactory;
    
	@Autowired
    private DataSource dataSource;
	
	@Autowired
	private TokenStore tokenStore;
    


 

//    @Bean
//    public UserDetailsService userDetailsService(){
//        return new UserService();
//    }

    /*
    * 配置客户端详情信息(内存或JDBC来实现)
    *
    * */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //初始化 Client 数据到 DB
//        clients.jdbc(dataSource)
//       clients.inMemory()
//                .withClient("client_1")
//                .authorizedGrantTypes("client_credentials")
//                .scopes("all","read", "write")
//                .authorities("client_credentials")
//                .accessTokenValiditySeconds(7200)
//                .secret(passwordEncoder.encode("123456"))
//
//                .and()
//                .withClient("client_2")
//                .authorizedGrantTypes("password", "refresh_token")
//                .scopes("all","read", "write")
//                .accessTokenValiditySeconds(7200)
//                .refreshTokenValiditySeconds(10000)
//                .authorities("password")
//                .secret(passwordEncoder.encode("123456"))
//
//                .and()
//                .withClient("client_3")
//                .authorities("authorization_code","refresh_token")
//                .secret(passwordEncoder.encode("123456"))
//                .authorizedGrantTypes("authorization_code")
//                .scopes("all","read", "write")
//                .accessTokenValiditySeconds(7200)
//                .refreshTokenValiditySeconds(10000)
//                .redirectUris("http://localhost:8080/callback","http://localhost:8080/signin")
//
//                .and()
//                .withClient("client_test")
//                .secret(passwordEncoder.encode("123456"))
//                .authorizedGrantTypes("all flow")
//                .authorizedGrantTypes("authorization_code", "client_credentials", "refresh_token","password", "implicit")
//                .redirectUris("http://localhost:8080/callback","http://localhost:8080/signin")
//                .scopes("all","read", "write")
//                .accessTokenValiditySeconds(7200)
//                .refreshTokenValiditySeconds(10000);

            //https://github.com/spring-projects/spring-security-oauth/blob/master/spring-security-oauth2/src/test/resources/schema.sql
//    		clients.withClientDetails(new JdbcClientDetailsService(dataSource));
    	
    	
      clients.inMemory()
              .withClient("client01").secret("123456").scopes("read")
              .authorizedGrantTypes("authorization_code", "password","client_credentials", "refresh_token")
              .redirectUris("http://www.baidu.com")
              .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        endpoints
                .tokenStore(tokenStore)
                .authenticationManager(authenticationManager);

        
     // 配置TokenServices参数 可以考虑使用[DefaultTokenServices]，它使用随机值创建令牌
//        DefaultTokenServices tokenServices = new DefaultTokenServices();
//        tokenServices.setTokenStore(endpoints.getTokenStore());
//        tokenServices.setSupportRefreshToken(true);
//        tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
//        tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
//        tokenServices.setAccessTokenValiditySeconds( (int) TimeUnit.DAYS.toSeconds(30)); // 30天
//        endpoints.tokenServices(tokenServices);
           
           
    }

    /**
     * 允许表单验证，浏览器直接发送post请求即可获取tocken
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        //curl -i -X POST -H "Accept: application/json" -u "client_1:123456" http://localhost:5000/oauth/check_token?token=a1478d56-ebb8-4f21-b4b6-8a9602df24ec
        oauthServer.tokenKeyAccess("permitAll()")         //url:/oauth/token_key,exposes public key for token verification if using JWT tokens
                   .checkTokenAccess("isAuthenticated()") //url:/oauth/check_token allow check token
                   .allowFormAuthenticationForClients();
    	
    	
    	
    }

    /**
     * 使用非对称加密算法来对Token进行签名
     * @return
     */
//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        KeyPair keyPair = new KeyStoreKeyFactory(
//                new ClassPathResource("keystore.jks"), "foobar".toCharArray())
//                .getKeyPair("test");
//        converter.setKeyPair(keyPair);
//        return converter;
//    }
}
