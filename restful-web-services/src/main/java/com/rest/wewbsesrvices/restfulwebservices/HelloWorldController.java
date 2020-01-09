package com.rest.wewbsesrvices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rest.wewbsesrvices.restfulwebservices.domain.HelloWorldBean;

@RestController
public class HelloWorldController {

	@GetMapping( path= "/hello-world")
	public String helloWorld() {
		return "hello world" ;
	}
	
	@GetMapping( path= "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Usando Hello World beans");
	}
	
	@GetMapping( path= "/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
		return new HelloWorldBean( String.format("Hello  World, %s",  name));
	}

	
}
