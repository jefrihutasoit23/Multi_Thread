package com.example.kossan.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/kosan")
public class KossanController {

    @GetMapping(value = {"/data", "/data/"})
    public ResponseEntity<Map> getById() {
        Map map = new HashMap();
        map.put("data","Kosan Availabel");
        map.put("status",200);
        map.put("message","success");
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }
}
