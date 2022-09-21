package com.rulesservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import com.rulesservice.model.AppUser;
import com.rulesservice.model.AuthenticationResponse;




@FeignClient(name = "auth-service", url = "${feign.url-auth-service}")
@Component
public interface AuthorizationFeign {
	
	// Create Consumer 
	/**
	 * @param appUserCredentials
	 * @return ResponseEntity<?>
	 */
	@PostMapping(value = "/createUser")
	public ResponseEntity<?> createUser(@RequestBody AppUser appUserCredentials);
	
	//Customer login
	/**
	 * @param appUserloginCredentials
	 * @return ResponseEntity<?>
	 * @throws Exception
	 */
	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody AppUser appUserloginCredentials) throws Exception ;
	
	//Validating the jwt token
	/**
	 * @param token
	 * @return ResponseEntity<?>
	 */
	@GetMapping(value = "/validateToken")
	public AuthenticationResponse getValidity(@RequestHeader("Authorization") String token);
	
	//fetching the role from customerid
	/**
	 * @param id
	 * @return String
	 */
	@GetMapping("/role/{id}")
	public String getRole(@PathVariable("id") String id) ;
	



}
