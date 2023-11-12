package com.example.studentmanagement.listener;


import com.example.studentmanagement.event.StudentCreatedEvent;
import com.example.studentmanagement.event.StudentDeletedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StudentEventListener {

    @EventListener
    public void onStudentCreated(StudentCreatedEvent event) {
        System.out.println("Created: " + event.getStudent());
    }

    @EventListener
    public void onStudentDeleted(StudentDeletedEvent event) {
        System.out.println("Deleted student with id: " + event.getStudentId());
    }
}

