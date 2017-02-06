/**
 * 
 */
package org.edtoktay.testproject.config;

import org.edtoktay.springtools.security.jwt.configure.JjwtProp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author deniz.toktay
 *
 */
@Configuration
@ComponentScan("org.edtoktay.springtools.security")
public class JwtConfiguration {
	@Value("${security.jjwt.token-expiration-time}")
	private int tokenExpirationTime;
	@Value("${security.jjwt.refresh-token-exp-time}")
	private int refreshTokenExpTime;
	@Value("${security.jjwt.token-issuer}")
	private String tokenIssuer;
	@Value("${security.jjwt.token-sign-key}")
	private String tokenSignKey;
	@Value("${security.jjwt.token-header}")
	private String tokenHeader;
	@Bean
	JjwtProp props(){
		JjwtProp jjwtProp = new JjwtProp();
		jjwtProp.setRefreshTokenExpTime(refreshTokenExpTime);
		jjwtProp.setTokenExpirationTime(tokenExpirationTime);
		jjwtProp.setTokenHeader(tokenHeader);
		jjwtProp.setTokenIssuer(tokenIssuer);
		jjwtProp.setTokenSignKey(tokenSignKey);
		return jjwtProp;
	}
}
