package com;

import com.dao.StudentDAO;
import com.entity.Student;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        StudentDAO StudentDAO = new StudentDAO();
        StudentDAO.save(new Student("Kai", "Viet Nam"));
        StudentDAO.save(new Student("Thanos", "Viet Nam"));
        StudentDAO.save(new Student("Thor", "Asgard"));
        StudentDAO.save(new Student("Hulk", "USA"));
        StudentDAO.save(new Student("Iron Man", "USA"));

        System.out.println("all Student after insert:");
        List<Student> listStudent = StudentDAO.findAll();
        for (Student student :
                listStudent) {
            System.out.println(student.getName());
        }
        StudentDAO.close();
    }
}
