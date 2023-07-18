package com.security.rs.web;

import java.util.Map;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(OAuth2Authentication authentication) {

        OAuth2AuthenticationDetails details
                = (OAuth2AuthenticationDetails) authentication.getDetails();
        Map mp = (Map) details.getDecodedDetails();

        mp.forEach((k, v) -> {
            //System.out.println("Key: " + k + ", Value: " + v);
            if (k.equals("generatedInZone")) {
                System.out.println("> generatedInZone: " + v);
            }
        });
        return "Hello!!! " + details.getDecodedDetails();
    }

}
