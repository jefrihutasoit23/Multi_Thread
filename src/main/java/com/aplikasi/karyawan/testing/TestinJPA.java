package com.aplikasi.karyawan.testing;


import com.aplikasi.karyawan.entity.Employee;
import com.aplikasi.karyawan.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestinJPA {

    @Autowired
    public EmployeeRepository employeeRepository;

    @Before
    public void abc(){
    }
    @Test
    public  void getIDJPAQL(){
       Employee employee=  employeeRepository.getById(1L);
        System.out.println(employee.getId());
    }

    @Test
    public void countEmployee(){
        System.out.println("count="+employeeRepository.count());
    }
}
