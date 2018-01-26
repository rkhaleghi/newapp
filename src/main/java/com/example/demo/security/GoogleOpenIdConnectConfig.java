/**
 *
 */
package com.example.demo.security;

import static java.util.Arrays.asList;
import static org.springframework.security.oauth2.common.AuthenticationScheme.header;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * @author RezaKhaleghi
 *
 */
@Configuration
@EnableOAuth2Client
public class GoogleOpenIdConnectConfig
{
	@Value("${google.clientId}")
	private String clientId;

	@Value("${google.clientSecret}")
	private String clientSecret;

	@Value("${google.accessTokenUri}")
	private String accessTokenUri;

	@Value("${google.userAuthorizationUri}")
    private String userAuthorizationUri;

//	@Value("${google.redirectUri}")
//    private String redirectUri;

	 @Autowired
	 private OAuth2ClientContext oAuth2ClientContext;

	@Bean
	public OAuth2ProtectedResourceDetails googleOpenId(){
//		 AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
//	        details.setClientId(clientId);
//	        details.setClientSecret(clientSecret);
//	        details.setAccessTokenUri(accessTokenUri);
//	        details.setUserAuthorizationUri(userAuthorizationUri);
//	        details.setScope(Arrays.asList("openid", "email"));
//	        details.setPreEstablishedRedirectUri(redirectUri);
//	        details.setUseCurrentUri(false);
//	        return details;

		AuthorizationCodeResourceDetails googleOAuth2Details = new AuthorizationCodeResourceDetails();
        googleOAuth2Details.setAuthenticationScheme(header);
        googleOAuth2Details.setClientAuthenticationScheme(header);
        googleOAuth2Details.setClientId(clientId);
        googleOAuth2Details.setClientSecret(clientSecret);
        googleOAuth2Details.setUserAuthorizationUri(userAuthorizationUri);
        googleOAuth2Details.setAccessTokenUri(accessTokenUri);
        googleOAuth2Details.setScope(asList("openid", "email"));
        return googleOAuth2Details;
	}

	@Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
    public OAuth2RestOperations googleOAuth2RestTemplate() {
        return new OAuth2RestTemplate(googleOpenId(), oAuth2ClientContext);
    }
}

/* ---------------------------------------------------------------------*
 * This software is the confidential and proprietary
 * information of Lhasa Limited
 * Granary Wharf House, 2 Canal Wharf, Leeds, LS11 5PS
 * ---
 * No part of this confidential information shall be disclosed
 * and it shall be used only in accordance with the terms of a
 * written license agreement entered into by holder of the information
 * with LHASA Ltd.
 * --------------------------------------------------------------------- */