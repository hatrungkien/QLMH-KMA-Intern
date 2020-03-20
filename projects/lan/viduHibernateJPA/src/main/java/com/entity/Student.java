package com.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student")
public class Student implements Serializable{
        private static final long serialVersionUID = 1L;
        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @Column(name = "name")
        private String name;
        @Column(name = "address")
        private String address;

        // getter - setter


        public static long getSerialVersionUID() {
                return serialVersionUID;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public Student() {
        }
        public Student(String name, String address) {
                this.name = name;
                this.address = address;
        }
}
