package com.aplikasi.karyawan.controller;

import com.aplikasi.karyawan.entity.Employee;
import com.aplikasi.karyawan.repository.EmployeeRepository;
import com.aplikasi.karyawan.service.EmployeeService;
import com.aplikasi.karyawan.utils.Response;
import com.aplikasi.karyawan.utils.SimpleStringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.Predicate;

import java.security.Principal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/v1/employee")
@Slf4j
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;

    @Autowired
    public SimpleStringUtils simpleStringUtils;

    @Autowired
    public Response response;

    @Autowired
    public EmployeeRepository employeeRepository;

    @PostMapping(value = {"/save", "/save/"}, produces = {"application/json"})
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

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);
    /*
    Penjelasan singkat mengenai contoh di atas:

ApiController: Kelas ini adalah controller Spring Boot yang menangani permintaan API. Endpoint /api/resource/{requestData} digunakan untuk mengakses sumber daya, dan metode getResource memulai thread menggunakan ExecutorService.

ExecutorService: Digunakan untuk membuat thread pool. Dalam contoh ini, digunakan newFixedThreadPool(10), yang berarti akan ada maksimal 10 thread yang dapat menjalankan tugas secara bersamaan.

processRequest: Metode ini mensimulasikan pemrosesan yang memakan waktu. Di dunia nyata, di sini Anda akan menempatkan logika pemrosesan data atau tugas yang memerlukan waktu.

Dengan menggunakan ExecutorService, Anda dapat mengelola thread secara efisien dan mencegah pembuatan thread yang tidak terbatas, yang dapat menyebabkan masalah kinerja. Pastikan untuk menyesuaikan konfigurasi ExecutorService sesuai dengan kebutuhan aplikasi Anda.
     */
    @GetMapping("/list-thread/{requestData}")
    public String getResource(@PathVariable String requestData) {
        // Menggunakan ExecutorService untuk menjalankan thread secara asinkron
        executorService.submit(() -> processRequest(requestData));

        return "Request is being processed asynchronously="+requestData;
    }

    private void processRequest(String requestData) {
        // Logika pemrosesan yang memakan waktu
        try {
            Thread.sleep(2000);
            System.out.println("Processed: " + requestData);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Qualifier("taskExecutor") // pemanggilan beans
    @Autowired
    private TaskExecutor taskExecutor;

    @GetMapping("/list-thread-v2/{requestData}")
    public String getResourcev2(@PathVariable String requestData) {
        // Menggunakan ExecutorService untuk menjalankan thread secara asinkron : backgro
        taskExecutor.execute(new Runnable() {
            @Override
            public void run() {
           //eksekusi
            }
        });
        return "Request is being processed asynchronously v2="+requestData;
    }

}
