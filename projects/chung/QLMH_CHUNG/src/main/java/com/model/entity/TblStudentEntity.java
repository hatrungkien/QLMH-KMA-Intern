package com.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "tbl_student", schema = "demo")
public class TblStudentEntity {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "id", nullable = false)
    private int id;
    @Basic@Column(name = "name", nullable = false, length = 255)
    private String name;

    //map voi Class
    @ManyToMany(mappedBy = "tblStudentEntities")
    private Set<TblClassEntity> ClassEntities = new HashSet<>();



}

