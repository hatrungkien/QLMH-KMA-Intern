package com.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@Table(name = "tbl_subject",schema = "demo")
public class TblSubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "tblSubjectEntity")
    private Set<TblClassEntity> tblClassEntities = new HashSet<>(0);
}
