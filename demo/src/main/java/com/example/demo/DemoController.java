package com.example.demo;

import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DemoController {

    @Value("${demo.name}")
    String name;

    @GetMapping("/test")
    DemoResult test() {
        log.info(">>>> " + name + " <<<");


        DemoResult demoResult = DemoResult.builder().info("Hello Demo!").build();
        return demoResult;
    }
}
