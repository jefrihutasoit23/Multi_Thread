package com.aplikasi.karyawan.service.impl;

import com.aplikasi.karyawan.entity.Employee;
import com.aplikasi.karyawan.service.EmployeeService;
import com.aplikasi.karyawan.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Qualifier("employeeImplke2") // Specify the bean name
public class EmployeeV10 implements EmployeeService {
    @Autowired
    public Response response;
    @Override
    public Map save(Employee employee) {
        return response.sukses("Success");
    }

    @Override
    public Map update(Employee employee) {
        return null;
    }

    @Override
    public Map delete(Long employee) {
        return null;
    }

    @Override
    public Map getByID(Long employee) {
        return null;
    }

    @Override
    public String abc() {
        return null;
    }
}
