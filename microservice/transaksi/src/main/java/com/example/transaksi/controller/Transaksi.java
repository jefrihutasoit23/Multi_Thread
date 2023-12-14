package com.example.transaksi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/v1/transaksi")
public class Transaksi {

    //step 1: Inquiry chek Kos : tersedia atau tidak
    //step 2 : user availabiylyt ?

    /*
    rest template call api dari user dan kosan
    jika available, baru lakukan transaksi
     */

    @Autowired
    private RestTemplateBuilder restTemplate;

    @GetMapping(value = {"/data", "/data/"})
    public ResponseEntity<Map> getById() {

        Boolean chekUser = callApiUser();
        if(!chekUser){
            Map map = new HashMap();
//            map.put("data","User Eror");
            map.put("status",404);
            map.put("message","user eror");
        }


        Boolean chekKosan = callApiKosan();
        if(!chekKosan){
            Map map = new HashMap();
//            map.put("data","Kosan Eror");
            map.put("status",404);
            map.put("message","Kosan Eror");
        }

        Map map = new HashMap();
        map.put("data","Transaksi Availabel");
        map.put("status",200);
        map.put("message","success");
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }

    public Boolean callApiUser(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");


        ResponseEntity<String> exchange = restTemplate.build().exchange("http://localhost:8083/v1/user/data", HttpMethod.GET, null, String.class);
        System.out.println("response user  =" + exchange.getBody()); //JACKSON Parsing
        return true;
    }

    public Boolean callApiKosan(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");


        ResponseEntity<String> exchange = restTemplate.build().exchange("http://localhost:8085/v1/kosan/data", HttpMethod.GET, null, String.class);
        System.out.println("response user  =" + exchange.getBody()); //JACKSON Parsing
        return true;
    }
}
