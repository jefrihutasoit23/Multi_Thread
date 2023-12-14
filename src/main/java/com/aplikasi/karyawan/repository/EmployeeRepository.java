package com.aplikasi.karyawan.repository;

import com.aplikasi.karyawan.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
//public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {
    public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {
    //JPA Query
    @Query(value = "select c from Employee c WHERE c.id = :idEmployee", nativeQuery = false)
    public Employee getById(@Param("idEmployee") Long idEmployee);

    //Native Query : menggunakan JPAQL
    @Query(value = "select  e from employee e where  id = :idEmployee;",nativeQuery = true)
    public Object getByIdNativeQuery(@Param("idEmployee") Long idEmployee);

    @Query(value = "select e from Employee e where LOWER(e.name) like LOWER(:nameParam)")
    public Page<Employee> getByLikeName(@Param("nameParam") String nameParam, Pageable pageable);

    @Query(value = "select e from Employee e ")
    public Page<Employee> getALlPage(Pageable pageable);

    //JPQ

    @Query(value = "select c from Employee c WHERE c.name = :name and c.address =:address", nativeQuery = false)
    public Employee findByNameAndNddressWithQuery(@Param("name") String name,@Param("address") String address);

    // select  * from employee e where name = 'Novian' and status='active' and address = 'jakarta' ;
    Page<Employee> findByNameAndStatusAndAddress(String name, String status, String address, Pageable pageable);

    @Query("select count(e) from Employee e where e.name = ?1")
    long countByName(String name);

    long count();

    @Query("select sum(e.id) from Employee e")
    long sumEmployee();


    //Store prosedure
    @Query(value = "select * from getemployee6()",nativeQuery = true)
    public List<Object> getListSP();

    @Modifying
    @Procedure("insert1")
    void saveEmployeeSP(@Param("resid") Long resid,@Param("rqnama") String rqnama);
    @Modifying
    @Procedure("update_employee")
    void updateEmployeeSP(@Param("resid") Long resid,@Param("rqnama") String rqnama);
    @Modifying
    @Procedure("deleted_employee1")
    void deleted_employee1(@Param("resid") Long resid);
    @Modifying
    @Procedure("getemployeebyid")
    Object getemployeebyid(@Param("resid") Long resid);
    @Modifying
    @Procedure("getemployee6")
    List<Object> getemployee6();






}
