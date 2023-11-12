package com.example.studentmanagement.shell;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.StudentService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.List;

@ShellComponent
public class StudentCommands {
    private final StudentService studentService;

    public StudentCommands(StudentService studentService) {
        this.studentService = studentService;
    }

    @ShellMethod("Displays all students.")
    public List<Student> showStudents() {
        return studentService.listStudents();
    }

    @ShellMethod("Adds a new student.")
    public Student addStudent(
            @ShellOption String firstName,
            @ShellOption String lastName,
            @ShellOption int age) {
        return studentService.addStudent(firstName, lastName, age);
    }

    @ShellMethod("Deletes a student by id.")
    public Student deleteStudent(@ShellOption Long id) {
        return studentService.deleteStudent(id);
    }

    @ShellMethod("Clears all students.")
    public String clearStudents() {
        studentService.clearStudents();
        return "All students have been cleared.";
    }
}

