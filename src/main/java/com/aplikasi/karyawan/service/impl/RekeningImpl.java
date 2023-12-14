package com.aplikasi.karyawan.service.impl;

import com.aplikasi.karyawan.Config;
import com.aplikasi.karyawan.entity.Employee;
import com.aplikasi.karyawan.entity.Rekening;
import com.aplikasi.karyawan.repository.EmployeeRepository;
import com.aplikasi.karyawan.repository.RekeningRepository;
import com.aplikasi.karyawan.service.EmployeeService;
import com.aplikasi.karyawan.service.RekeningService;
import com.aplikasi.karyawan.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class RekeningImpl implements RekeningService {

    @Autowired
    public Response response;

    @Autowired
    public RekeningRepository rekeningRepository;

    @Autowired
    public EmployeeRepository employeeRepository;

    @Override
    public Map save(Rekening request) {
        try {
            log.info("save rekening");
             /*
        validasi langsung
        lagnsung save
         */
            if(request.getNama().isEmpty()){
                return response.Error(Config.NAME_REQUIRED);
            }
            if(request.getEmployee() ==null && request.getEmployee().getId() == null){
                return response.Error(Config.EMPLOYEE_REQUIRED);
            }
            Optional<Employee> chekDataDB = employeeRepository.findById(request.getEmployee().getId());
            if(!chekDataDB.isPresent()){
                return response.Error(Config.EMPLOYEE_NOT_FOUND);
            }

            request.setEmployee(chekDataDB.get());

            return response.sukses(rekeningRepository.save(request));
        }catch (Exception e){
            log.error("save rekening eror: "+e.getMessage());
            return response.Error("Save Rekening ="+e.getMessage());
        }

    }

    @Override
    public Map update(Rekening request) {
        try {
            log.info("Update rekening");
            Optional<Rekening> chekDataDBRekening = rekeningRepository.findById(request.getId());
            if(!chekDataDBRekening.isPresent()){
                return response.Error(Config.REKENING_NOT_FOUND);
            }

            if(request.getEmployee() ==null && request.getEmployee().getId() == null){
                return response.Error(Config.EMPLOYEE_REQUIRED);
            }
            Optional<Employee> chekDataDB = employeeRepository.findById(request.getEmployee().getId());
            if(!chekDataDB.isPresent()){
                return response.Error(Config.EMPLOYEE_NOT_FOUND);
            }

            // apa yang ingin kalian update
            chekDataDBRekening.get().setRekening(request.getRekening());
            chekDataDBRekening.get().setEmployee(chekDataDB.get());
            chekDataDBRekening.get().setJenis(request.getJenis());

            // do save , balikin responya

            return response.sukses(rekeningRepository.save(chekDataDBRekening.get()));
        }catch (Exception e){
            log.error("Update rekening eror: "+e.getMessage());
            return response.Error("Update Rekening ="+e.getMessage());
        }
    }

    @Override
    public Map delete(Rekening request) {
        try {
            log.info("Delete rekening");
            if(request.getId() ==null ){
                return response.Error(Config.ID_REQUIRED);
            }
            Optional<Rekening> chekDataDBRekening = rekeningRepository.findById(request.getId());
            if(chekDataDBRekening.isEmpty()){
                return response.Error(Config.REKENING_NOT_FOUND);
            }
            // apa yang ingin kalian update
            chekDataDBRekening.get().setDeletedDate(new Date());
            // do save , balikin responya
            return response.sukses(Config.SUCCESS);
        }catch (Exception e){
            log.error("Delete rekening eror: "+e.getMessage());
            return response.Error("Delete Rekening ="+e.getMessage());
        }
    }

    @Transactional
    @Override
    public Map deleteUpdateTransactional(Rekening request) {
      try {
         // 1.pengecekan ke db
          Optional<Rekening> chekDataDBRekening = rekeningRepository.findById(request.getId());
          if(chekDataDBRekening.isEmpty()){
              return response.Error(Config.REKENING_NOT_FOUND);
          }
          //2. update -> deleted date
          chekDataDBRekening.get().setDeletedDate(new Date());
          rekeningRepository.save(chekDataDBRekening.get());

          //3. update eror : sengaja kita akan buatkan eror
          rekeningRepository.save(null);

          return response.sukses("Success");
      }catch (Exception e){
          return response.sukses("Eror="+e.getMessage());
      }
    }
}
