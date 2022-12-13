package academyapplication.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/salut")
    public ResponseEntity<String> salut(){
        return new ResponseEntity<>("Salut Monde!", HttpStatus.OK);
    }
}
