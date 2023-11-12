package com.example.studentmanagement.service;


import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.event.StudentCreatedEvent;
import com.example.studentmanagement.event.StudentDeletedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    private final Map<Long, Student> students = new HashMap<>();
    private final ApplicationEventPublisher publisher;
    private long nextId = 1;

    public StudentService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public List<Student> listStudents() {
        return new ArrayList<>(students.values());
    }

    public Student addStudent(String firstName, String lastName, int age) {
        Student student = new Student(nextId++, firstName, lastName, age);
        students.put(student.getId(), student);
        publisher.publishEvent(new StudentCreatedEvent(this, student));
        return student;
    }

    public Student deleteStudent(Long id) {
        Student student = students.remove(id);
        if(student != null) {
            publisher.publishEvent(new StudentDeletedEvent(this, id));
        }
        return student;
    }

    public void clearStudents() {
        students.clear();
    }
}
