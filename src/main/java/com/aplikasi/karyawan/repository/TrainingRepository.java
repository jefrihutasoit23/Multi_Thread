package com.aplikasi.karyawan.repository;

import com.aplikasi.karyawan.entity.Rekening;
import com.aplikasi.karyawan.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
//public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {
    public interface TrainingRepository extends JpaRepository<Training, Long>, JpaSpecificationExecutor<Training> {

    @Query(value = "select c from Training c WHERE c.id = :id", nativeQuery = false)
    public Training getById(@Param("id") Long id);


}
