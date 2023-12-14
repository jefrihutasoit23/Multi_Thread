package com.aplikasi.karyawan.controller;

import com.aplikasi.karyawan.Config;
import com.aplikasi.karyawan.entity.Employee;
import com.aplikasi.karyawan.entity.Rekening;
import com.aplikasi.karyawan.repository.RekeningRepository;
import com.aplikasi.karyawan.service.RekeningService;
import com.aplikasi.karyawan.utils.Response;
import com.aplikasi.karyawan.utils.SimpleStringUtils;
import javax.persistence.criteria.Predicate;
import lombok.experimental.Delegate;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/v1/rekening")
public class RekeningController {

    @Autowired
    public RekeningService rekeningService;

    @Autowired
    public SimpleStringUtils simpleStringUtils;


    @Autowired
    public RekeningRepository rekeningRepository;

    @Autowired
    public Response response;

    @PostMapping(value = {"/save", "/save/"})
    public ResponseEntity<Map> save(@RequestBody Rekening request) {
        try {
            return new ResponseEntity<Map>(rekeningService.save(request), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Map>(response.Error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR); // 500
        }
    }

    @PutMapping(value = {"/update", "/update/"})
    public ResponseEntity<Map> update(@RequestBody Rekening request) {
        try {
            if(request.getId() ==null ){
                return new ResponseEntity<Map>(response.Error(Config.ID_REQUIRED), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<Map>(rekeningService.update(request), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Map>(response.Error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR); // 500
        }
    }

    @DeleteMapping(value = {"/delete", "/delete/"})
    public ResponseEntity<Map> delete(@RequestBody Rekening request) {
        try {
            return new ResponseEntity<Map>(rekeningService.delete(request), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Map>(response.Error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR); // 500
        }
    }

    @GetMapping(value = {"/{id}", "/{id}/"})
    public ResponseEntity<Map> getById(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<Map>(response.sukses(rekeningRepository.findById(id).get()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Map>(response.Error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR); // 500
        }
    }

    @GetMapping(value = {"/list", "/list/"})
    public ResponseEntity<Map> listQuizHeaderSpec(
            @RequestParam() Integer page,
            @RequestParam(required = true) Integer size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String orderby,
            @RequestParam(required = false) String ordertype) {
        Pageable show_data = simpleStringUtils.getShort(orderby, ordertype, page, size);

        Specification<Rekening> spec =
                ((root, query, criteriaBuilder) -> {
                    List<Predicate> predicates = new ArrayList<>();
                    if (name != null && !name.isEmpty()) {
                        //      select  * from employee e where name like '%a%' ;
                        predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("nama")), "%" + name.toLowerCase() + "%"));
                    }
                    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
                });

        Page<Rekening> list = rekeningRepository.findAll(spec, show_data);
        return new ResponseEntity<Map>(response.sukses(list), new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping(value = {"/transactinal-ex", "/transactinal-ex/"})
    public ResponseEntity<Map> transactionalEx(@RequestBody Rekening request) {
        try {
            if(request.getId() ==null ){
                return new ResponseEntity<Map>(response.Error(Config.ID_REQUIRED), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<Map>(rekeningService.deleteUpdateTransactional(request), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Map>(response.Error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR); // 500
        }
    }
}
