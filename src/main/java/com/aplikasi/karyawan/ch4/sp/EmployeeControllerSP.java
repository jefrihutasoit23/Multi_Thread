package com.aplikasi.karyawan.ch4.sp;

import com.aplikasi.karyawan.repository.EmployeeRepository;
import com.aplikasi.karyawan.service.EmployeeService;
import com.aplikasi.karyawan.utils.SimpleStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/employee/sp")
public class EmployeeControllerSP {
    @Autowired
    public EmployeeService employeeService;

    SimpleStringUtils simpleStringUtils = new SimpleStringUtils();
    @Autowired
    private DataSource dataSource;
    @Autowired
    public EmployeeRepository employeeRepository;

    @GetMapping(value = {"", "/"})
    public ResponseEntity<Map> getById() {
        Map map = new HashMap();
        map.put("list",employeeRepository.getListSP());
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }




}
