package itacademy.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HelloWorld {

	
	@GetMapping("/")
    public String helloWorld() {
        return "HELLO WORLD";
    }
	
	@GetMapping("/{name}")
    public String helloName(@PathVariable String name) {
        return "HELLO " + name.toUpperCase();
    }
}
