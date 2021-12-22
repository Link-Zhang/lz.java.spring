package cn.sh.lz.spring.framework.controllers;

import cn.sh.lz.spring.framework.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Link at 14:50 on 2021/12/22.
 * When I write, only God and I understand what I am doing.
 * Now, only God knows.
 */

@RestController
@RequestMapping(path = "/hello")
public class HelloController {
    private static Logger log = LoggerFactory.getLogger(Application.class);

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/greeting")
    public String greet() {
        log.info("Access hello /greeting");
        List<String> greetings = Arrays.asList("Hi, ", "Hello, ", "你好, ");
        Random rand = new Random();
        int randomNum = rand.nextInt(greetings.size());
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return greetings.get(randomNum) + username + "!";
    }

    @GetMapping("/")
    public String home() {
        log.info("Access hello /");
        return "Hi!";
    }
}
