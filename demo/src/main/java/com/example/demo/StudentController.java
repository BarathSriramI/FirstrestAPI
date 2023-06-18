package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
public class StudentController {
    // we use datastructures as Databases

    Map<Integer,Student > studentdb= new HashMap<>();

    // create a read / put API

    // create a method to return the student obj with input admin no


    // @ getmapping is used to make it as APi
    @GetMapping ("/getstudent")
    public Student getStudent(@RequestParam("adminno") int adminNo)
    {
       // if(studentdb.containsKey(adminNo))
        return studentdb.get(adminNo);
    }

// create a method to add student in the database

    @PostMapping("/add")
    public String addStudent(@RequestBody  Student student)
    {
        studentdb.put(student.getAdminNo(),student);
        return "Student succesfully added";
    }

     @GetMapping("/get/{id}")
    public Student  getstudentbypath(@PathVariable("id") int adminNo)
    {
        return studentdb.get(adminNo);
    }

   // delete a student

        @DeleteMapping("/delete/{adminNo}")
    public String delete( @PathVariable("adminNo") int adminNo) {
//        if(!studentdb.containsKey(adminNo))
//        {
//            throw new Exception("adminNo not present");
//        }
        studentdb.remove(adminNo);
        return "Student removed ";
    }
}
