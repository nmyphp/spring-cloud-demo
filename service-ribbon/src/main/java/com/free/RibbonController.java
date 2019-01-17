package com.free;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("ribbon")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/add")
    public Integer add(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        return restTemplate.getForObject("http://COMPUTE-SERVICE/computer/add?a={1}&b={2}", Integer.class, a, b);
    }
}
