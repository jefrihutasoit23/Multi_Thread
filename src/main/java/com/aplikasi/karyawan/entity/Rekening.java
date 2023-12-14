package com.aplikasi.karyawan.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "rekening")
@Where(clause = "deleted_date is null")
public class Rekening extends AbstractDate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "jenis")
    private String jenis;

    @Column(length = 100)
    private String rekening;

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_karyawan")
    @PrimaryKeyJoinColumn
    private Employee employee;

}
