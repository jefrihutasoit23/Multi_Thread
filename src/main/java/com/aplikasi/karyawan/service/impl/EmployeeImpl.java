package com.aplikasi.karyawan.service.impl;

import com.aplikasi.karyawan.Config;
import com.aplikasi.karyawan.entity.Employee;
import com.aplikasi.karyawan.repository.EmployeeRepository;
import com.aplikasi.karyawan.service.EmployeeService;
import com.aplikasi.karyawan.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Primary // Designate this as the primary bean
public class EmployeeImpl implements EmployeeService {

    // step 1 : koneksi ke database ?

//    @Autowired
//    public Config config;

    @Autowired
    public Response response;
    @Autowired
    public EmployeeRepository employeeRepository;

    @Override
    public Map save(Employee employee) {
        Map map = new HashMap();
        // insert into tabel rekening ,
        Employee doSave =     employeeRepository.save(employee);
//        map.put("data",doSave);
//        map.put("message","Success");
//        map.put("code",200);
        return response.Sukses(doSave);
    }

    @Override
    public Map update(Employee employee) {
        /*
        1. ngecek ke db base param ID
        2. jika ditemuakan baru di update
        3. jika tidak ditemukan: di tolak -return data notfound.
         */
        Map map = new HashMap();
        Employee chekData = employeeRepository.getById(employee.getId());
        if(chekData == null){
//            map.put("message","data not found");
            return response.error("data not found", Config.EROR_CODE_404);
        }
        //apa yang diupdate
        chekData.setAddress(employee.getAddress());
        chekData.setName(employee.getName());

        Employee doUpdate = employeeRepository.save(chekData);
//        map.put("data",doUpdate);
        return response.Sukses(doUpdate);
    }

    @Override
    public Map delete(Long employee) {
        /*
        1. chek data ke db
        2. jika ada, delete langsung
        hard delete  ?   permanent
        soft delete ?    deleted date status
         */
        Map map = new HashMap();
        Employee chekData = employeeRepository.getById(employee);
        if(chekData == null){
            map.put("message","data not found");
            return map;
        }
        chekData.setDeletedDate(new Date());
        Employee doDelete = employeeRepository.save(chekData);
        map.put("data",doDelete);

        // deleted permanent ?
//        employeeRepository.delete(chekData);
        return map;
    }

    @Override
    public Map getByID(Long employee) {
        Map map = new HashMap();
        Optional<Employee> getBaseOptional = employeeRepository.findById(employee);
        if(!getBaseOptional.isPresent()){
            map.put("message","data not found");
            return map;
        }
        map.put("data",getBaseOptional.get());
        return map;
    }

    @Override
    public String abc() {
        return null;
    }
}
