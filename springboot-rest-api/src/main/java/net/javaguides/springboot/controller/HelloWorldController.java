package net.javaguides.springboot.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Controller
 * To make a Java class as a Spring MVC controller.
 *
 * @ResponseBody
 * The @ResponseBody annotation tells a controller that the object returned is
 * automatically serialized into JSON and passed back onto the HttpResponse object.
 */

@RestController
public class HelloWorldController {
    /**
     @GetMapping
     We use @GetMapping annotation to map HTTP GET request onto specific handler method.
     */
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World!";
    }
}





