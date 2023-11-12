package com.example.studentmanagement;

import com.example.studentmanagement.service.StudentService;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties(AppConfig.class)
public class StudentManagementApplication implements CommandLineRunner {
    private final StudentService studentService;
    private static final Logger log = LoggerFactory.getLogger(StudentManagementApplication.class);
    private final AppConfig appConfig;

    public StudentManagementApplication(StudentService studentService, AppConfig appConfig) {
        this.studentService = studentService;
        this.appConfig = appConfig;
    }

    public static void main(String[] args) {
//        SpringApplication.run(StudentManagementApplication.class, args);
            SpringApplication app = new SpringApplication(StudentManagementApplication.class);
            app.setBannerMode(Banner.Mode.OFF);
            System.out.println("STARTING A RUN METHOD");
            app.run(args);
            System.out.println("Application has started.");

    }

    @Override
    public void run(String... args) {
        System.out.println("STARTED A RUN METHOD");
        if (appConfig.isInitializeWithStudents()) {
            log.info("Initializing with default students...");
            // Включено добавление студентов по дефолту
            System.out.println("Adding of default students:");
            studentService.addStudent("Vasiliy", "Perkin", 20);
            studentService.addStudent("Sergey", "Savkin", 49);
            System.out.println("Finish of adding students:");
        }
        else{
            System.out.println("Problem");
        }
    }
}

