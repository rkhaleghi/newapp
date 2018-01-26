/**
 *
 */
package com.example.demo.security;

import static java.util.Optional.empty;
import static org.springframework.security.core.authority.AuthorityUtils.NO_AUTHORITIES;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import com.example.demo.model.UserInfo;
public class OpenIdConnectFilter extends AbstractAuthenticationProcessingFilter {

	@Autowired
	public OAuth2RestOperations restTemplate;

    public OpenIdConnectFilter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
        setAuthenticationManager(new NoopAuthenticationManager());
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

    	final ResponseEntity<UserInfo> userInfoResponseEntity = restTemplate.getForEntity("https://www.googleapis.com/oauth2/v2/userinfo", UserInfo.class);
        return new PreAuthenticatedAuthenticationToken(userInfoResponseEntity.getBody(), empty(), NO_AUTHORITIES);

//        OAuth2AccessToken accessToken;
//        try {
//            accessToken = restTemplate.getAccessToken();
//        } catch (final OAuth2Exception e) {
//            throw new BadCredentialsException("Could not obtain access token", e);
//        }
//        try {
//            final String idToken = accessToken.getAdditionalInformation().get("id_token").toString();
//            final Jwt tokenDecoded = (Jwt) JwtHelper.decode(idToken);
//            System.out.println("===== : " + ((org.springframework.security.jwt.Jwt) tokenDecoded).getClaims());
//
//            final Map<String, String> authInfo = new ObjectMapper().readValue(((org.springframework.security.jwt.Jwt) tokenDecoded).getClaims(), Map.class);
//
//            final OpenIdConnectUserDetails user = new OpenIdConnectUserDetails(authInfo, accessToken);
//            return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//        } catch (final InvalidTokenException e) {
//            throw new BadCredentialsException("Could not obtain user details from token", e);
//        }

    }

    public void setRestTemplate(OAuth2RestTemplate restTemplate2) {
        restTemplate = restTemplate2;

    }

    private static class NoopAuthenticationManager implements AuthenticationManager {

        @Override
        public Authentication authenticate(Authentication authentication) throws AuthenticationException {
            throw new UnsupportedOperationException("No authentication should be done with this AuthenticationManager");
        }

    }
}