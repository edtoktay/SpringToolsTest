/**
 * 
 */
package org.edtoktay.testproject.config;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author deniz.toktay
 *
 */
@Configuration
@ConfigurationProperties("oracle")
public class OracleProperties {
	@NotNull
	private String username;
	@NotNull
	private String password;
	@NotNull
	private String url;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
