package com.kash.restapi.controller;


import com.kash.restapi.entity.Student;
import com.kash.restapi.model.request.CreateStudentRequest;
import com.kash.restapi.model.request.UpdateStudentRequest;
import com.kash.restapi.model.response.StudentResponse;
import com.kash.restapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
    public StudentResponse createStudent (@Valid @RequestBody CreateStudentRequest createStudentRequest){
        Student student = studentService.createStudent(createStudentRequest);
        return new StudentResponse(student);
    }

    @PutMapping("update")
    public StudentResponse updateStudent(@Valid @RequestBody UpdateStudentRequest updateStudentRequest){
        Student student = studentService.updateStudent(updateStudentRequest);
        return new StudentResponse(student);

    }

    @DeleteMapping("delete/{id}")
        public String deleteStudent(@PathVariable("id") long id){
        return studentService.deleteStudent(id);
   }
//    public String deleteStudent(@RequestParam long id){
//        return studentService.deleteStudent(id);
//    }
}
