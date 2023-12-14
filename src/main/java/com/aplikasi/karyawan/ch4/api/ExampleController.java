package com.aplikasi.karyawan.ch4.api;

import com.aplikasi.karyawan.ch4.samplemvc.entity.Karyawan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
class ExampleController {
    @RequestMapping("/hello-word")
    @ResponseBody
    public String hello()
    {
        // value kalian hadrcode .
        //response
        return   "Hello Spring Boot";
    }

    @RequestMapping("/karyawan")
    @ResponseBody
    public Karyawan karyawanObj1()
    {
        // value kalian hadrcode .
        //response
        Karyawan obj= new Karyawan() ;
        obj.setId(1L);
        obj.setNama("nama");
        return   obj;
    }

} 

/*
1. Jika Objek Karyawan Bagaimana ? id, nama,
 */