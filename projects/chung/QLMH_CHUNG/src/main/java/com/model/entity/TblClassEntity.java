package com.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "tbl_class", schema = "demo", catalog = "")
public class TblClassEntity {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)@Column(name = "id", nullable = false)
    private int id;
    @Basic@Column(name = "name", nullable = false, length = 255)
    private String name;

    //map voi Subject
    @ManyToOne
    @JoinColumn(name = "subject_id",nullable = false)
    private TblSubjectEntity tblSubjectEntity;


    //map với student

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "student_class",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<TblStudentEntity> tblStudentEntities = new HashSet<>(0);

    //map voi assistant
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "assistant_class",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "assistant_id")
    )
    private Set<TblAssistantEntity> tblAssistantEntities = new HashSet<>(0);

    //map voi teacher
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "teacher_class",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private Set<TblTeacherEntity> tblTeacherEntities = new HashSet<>(0);

    public TblClassEntity() {
    }
    public TblClassEntity(String name) {
        this.name = name;
    }
}
