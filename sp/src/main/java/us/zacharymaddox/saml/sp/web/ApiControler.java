package us.zacharymaddox.saml.sp.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import us.zacharymaddox.saml.sp.domain.Greeting;

@RestController
@RequestMapping("/api")
public class ApiControler {

    @GetMapping(produces="application/json")
    public Greeting helloWorld() {
        return new Greeting("Hello World!");
    }

}