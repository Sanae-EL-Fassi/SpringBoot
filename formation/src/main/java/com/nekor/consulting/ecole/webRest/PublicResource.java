package com.nekor.consulting.ecole.webRest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/public")
public class PublicResource {


    @GetMapping
    public List<String> getAllContacts() {
        return Stream.of("value1", "value2").collect(Collectors.toList());

    }

}
