/**
 * 
 */
package org.edtoktay.testproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author deniz.toktay
 *
 */
@SpringBootApplication
@EnableConfigurationProperties
public class Application {
	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}
}
