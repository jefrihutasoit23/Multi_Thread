package com.aplikasi.karyawan.repository;

import com.aplikasi.karyawan.entity.DetailEmployee;
import com.aplikasi.karyawan.entity.Rekening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
//public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {
    public interface RekeningRepository extends JpaRepository<Rekening, Long>, JpaSpecificationExecutor<Rekening> {

    @Query(value = "select c from Rekening c WHERE c.id = :id", nativeQuery = false)
    public Rekening getById(@Param("id") Long id);


}
