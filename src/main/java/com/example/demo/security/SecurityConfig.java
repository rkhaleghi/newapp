/**
 *
 */
package com.example.demo.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private OAuth2RestTemplate restTemplate;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

//    @Bean
//    public OpenIdConnectFilter myFilter() {
//        final OpenIdConnectFilter filter = new OpenIdConnectFilter("/oauth2/callback");
//        filter.setRestTemplate(restTemplate);
//        return filter;
//    }

    private final String ENTRY_POINT = "/oauth2/callback";

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new LoginUrlAuthenticationEntryPoint(ENTRY_POINT);
    }

    @Bean
    public OpenIdConnectFilter openIdConnectAuthenticationFilter() {
        return new OpenIdConnectFilter(ENTRY_POINT);
    }

    @Bean
    public OAuth2ClientContextFilter oAuth2ClientContextFilter() {
        return new OAuth2ClientContextFilter();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
//        http

//        http.cors().and().csrf().disable().authorizeRequests().antMatchers("/**").permitAll();
    	http.csrf().disable()
        .addFilterAfter(oAuth2ClientContextFilter(), AbstractPreAuthenticatedProcessingFilter.class)
        .addFilterAfter(openIdConnectAuthenticationFilter(), OAuth2ClientContextFilter.class)
        .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint())
        .and().authorizeRequests().anyRequest().authenticated();

//        .addFilterAfter(new OAuth2ClientContextFilter(), AbstractPreAuthenticatedProcessingFilter.class)
//        .addFilterAfter(myFilter(), OAuth2ClientContextFilter.class)
//        .httpBasic().authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/google-login"))
//        .and()
//        .authorizeRequests()
       // .antMatchers("/","/index*").permitAll()
//        .anyRequest().authenticated()
        ;

     // @formatter:on
    }
}