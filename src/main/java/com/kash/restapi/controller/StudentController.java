package com.kash.restapi.controller;


import com.kash.restapi.entity.Student;
import com.kash.restapi.request.CreateStudentRequest;
import com.kash.restapi.response.StudentResponse;
import com.kash.restapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/student/")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("getAll")
    public List<StudentResponse> getAllStudents () {
         List<Student> studentList = studentService.getAllStudents();
         List<StudentResponse>studentResponseList = new ArrayList<StudentResponse>();

         studentList.stream().forEach(student -> {
             studentResponseList.add(new StudentResponse(student));
         });
         return studentResponseList;
    }

    @PostMapping("create")
    public StudentResponse createStudent (@RequestBody CreateStudentRequest createStudentRequest){
        Student student = studentService.createStudent(createStudentRequest);
        return new StudentResponse(student);
    }
}
