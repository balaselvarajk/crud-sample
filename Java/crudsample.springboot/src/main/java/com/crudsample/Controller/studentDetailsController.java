package com.crudsample.Controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudsample.exception.studentNotFoundException;
import com.crudsample.model.studentDetails;
import com.crudsample.repo.studentDetailsRepo;


//@CrossOrigin("*")
@RestController 
@RequestMapping("api/path1")
public class studentDetailsController {
    @Autowired
    private studentDetailsRepo studentDetailsRepo;

    @GetMapping("/studentDetails")
    public List<studentDetails> getAllStudent() {
        return studentDetailsRepo.findAll();
    }

    @GetMapping("/studentDetails/{id}")
    public ResponseEntity<studentDetails> getStudentById(@PathVariable(value = "id") Long studentId)
        throws studentNotFoundException {
    	studentDetails studentDetails = studentDetailsRepo.findById(studentId)
          .orElseThrow(() -> new studentNotFoundException("Student not found for this id :: " + studentId));
        return ResponseEntity.ok().body(studentDetails);
    }
    
    @PostMapping("/studentDetails")
    public studentDetails createStudent(@RequestBody studentDetails studentDetails) {
        return studentDetailsRepo.save(studentDetails);
    }

    

    @DeleteMapping("/studentDetails/{id}")
    public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") Long studentId)
         throws studentNotFoundException {
    	studentDetails studentDetails = studentDetailsRepo.findById(studentId)
       .orElseThrow(() -> new studentNotFoundException("Student not present for the id :: " + studentId));

        studentDetailsRepo.delete(studentDetails);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    @PutMapping("/studentDetails/{id}")
    public ResponseEntity<studentDetails> updateEmployee(@PathVariable(value = "id") Long studentId,
         @RequestBody studentDetails studentDetails) throws    studentNotFoundException {
    	studentDetails studDetails = studentDetailsRepo.findById(studentId)
        .orElseThrow(() -> new studentNotFoundException("Student not found for this id :: " + studentId));

    	studDetails.setEmail(studentDetails.getEmail());
    	studDetails.setLname(studentDetails.getLname());
    	studDetails.setFname(studentDetails.getFname());
    	studDetails.setCourse(studentDetails.getCourse());
    	studDetails.setPhone(studentDetails.getPhone());
        studentDetails updatedStudent = studentDetailsRepo.save(studDetails);
        return ResponseEntity.ok(updatedStudent);
    }
}
