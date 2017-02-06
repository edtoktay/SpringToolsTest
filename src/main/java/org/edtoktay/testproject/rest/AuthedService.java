/**
 * 
 */
package org.edtoktay.testproject.rest;

import org.edtoktay.springtools.security.jwt.annotation.JwtSecured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author deniz.toktay
 *
 */
@RestController
public class AuthedService {
	@RequestMapping(value = "/api/auth/hello", method=RequestMethod.GET)
	@JwtSecured
	public String hello(){
		return "Hello World";
	}
	
	@RequestMapping(value = "/none/hello", method=RequestMethod.GET)
	@JwtSecured
	public String hello2(){
		return "Hello World2";
	}
	
	@RequestMapping(value = "/none/hello2", method=RequestMethod.GET)
	@JwtSecured(roles= {"ROLE_CLIENT"})
	public String hello3(){
		return "Hello World2";
	}
}
