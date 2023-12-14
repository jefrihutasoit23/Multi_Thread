package com.aplikasi.karyawan.controller;

import com.aplikasi.karyawan.entity.Employee;
import com.aplikasi.karyawan.repository.EmployeeRepository;
import com.aplikasi.karyawan.service.EmployeeService;
import com.aplikasi.karyawan.utils.Response;
import com.aplikasi.karyawan.utils.SimpleStringUtils;
import javax.persistence.criteria.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v2/employee")
@Slf4j
public class EmployeeV2Controller {
    @Autowired
    @Qualifier("employeeImplke2") // Specify the bean name
    public EmployeeService employeeService;

    @Autowired
    public SimpleStringUtils simpleStringUtils;

    @Autowired
    public Response response;

//    @Autowired
    public EmployeeRepository employeeRepository;

    public  EmployeeV2Controller (EmployeeRepository employeeRepository){
        this.employeeRepository= employeeRepository;
    }


    @PostMapping(value = {"/save", "/save/"})
    public ResponseEntity<Map> save(@RequestBody Employee request) {
        try {
            if (request.getName().isEmpty()) {
                return new ResponseEntity<Map>(response.Error("name is required."), HttpStatus.NOT_FOUND); // 500
            }
            return new ResponseEntity<Map>(employeeService.save(request), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<Map>(response.Error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR); // 500
        }
    }

    @PutMapping(value = {"/update", "/update/"})
    public ResponseEntity<Map> update(@RequestBody Employee request) {
        return new ResponseEntity<Map>(employeeService.update(request), HttpStatus.OK);
    }

    @DeleteMapping(value = {"/delete", "/delete/"})
    public ResponseEntity<Map> delete(@RequestBody Employee request) {
        return new ResponseEntity<Map>(employeeService.delete(request.getId()), HttpStatus.OK);
    }

    @GetMapping(value = {"/{id}", "/{id}/"})
    public ResponseEntity<Map> getById(@PathVariable("id") Long id) {
        // sekali panggil -> bisa digunakan oleh banyak ITEM -> logic
        return new ResponseEntity<Map>(employeeService.getByID(id), HttpStatus.OK);
    }

    @GetMapping(value = {"/list", "/list/"})
    public ResponseEntity<Map> listQuizHeader(
            @RequestParam() Integer page,
            @RequestParam(required = true) Integer size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String orderby,
            @RequestParam(required = false) String ordertype) {

        Pageable show_data = simpleStringUtils.getShort(orderby, ordertype, page, size);
        Page<Employee> list = null;

        if (name != null && !name.isEmpty()) {
            list = employeeRepository.getByLikeName("%" + name + "%", show_data);
        } else {
            list = employeeRepository.getALlPage(show_data);
        }
        Map map = new HashMap();
        map.put("data", list);
        return new ResponseEntity<Map>(map, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = {"/list-spec", "/list-spec/"})
    public ResponseEntity<Map> listQuizHeaderSpec(
            @RequestParam() Integer page,
            @RequestParam(required = true) Integer size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String orderby,
            @RequestParam(required = false) String ordertype) {
        Pageable show_data = simpleStringUtils.getShort(orderby, ordertype, page, size);

        Specification<Employee> spec =
                ((root, query, criteriaBuilder) -> {
                    List<Predicate> predicates = new ArrayList<>();
                    if (name != null && !name.isEmpty()) {
                        //      select  * from employee e where name like '%a%' ;
                        predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
                    }
                    if (address != null && !address.isEmpty()) {
                        // equal == select  * from employee e where  address ='jakarta'
                        predicates.add(criteriaBuilder.equal(root.get("address"), address));
                    }
                    if (status != null && !status.isEmpty()) {
                        // equal == select  * from employee e where  address ='jakarta'
                        predicates.add(criteriaBuilder.equal(root.get("status"), status));
                    }
                    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
                });

        Page<Employee> list = employeeRepository.findAll(spec, show_data);

        Map map = new HashMap();
        map.put("data", list);
        return new ResponseEntity<Map>(map, new HttpHeaders(), HttpStatus.OK);
    }

    /*
    bawan jpa dari spring boot
     */
    @GetMapping(value = {"/default-jpa", "/default-jpa/"})
    public ResponseEntity<?> defaultJPA() {
//        Map map = new HashMap();
//        return new ResponseEntity<>(employeeRepository.findById(3L), HttpStatus.OK);
//        return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
//        return new ResponseEntity<>(employeeRepository.findById(4L), HttpStatus.OK);
        Pageable show_data = simpleStringUtils.getShort("id", "desc", 0, 10);

        return new ResponseEntity<>(employeeRepository.findByNameAndStatusAndAddress("Novian", "active", "jakarta", show_data), HttpStatus.OK);

    } //

}
