package com.example;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

@Autowired	
public	 Studentres studentres;
	
		
		@GetMapping("/")
		public String index() {
			return "welcome";
		}
		
		@PostMapping("/savestudent")
		public Student savedata(@RequestBody Student student) {
			studentres.save(student);
			return student;
			
		}
		
		@GetMapping("/studentbro/{rollno}")
		public Student studentss(@PathVariable int rollno){
			Optional <Student> student=  studentres.findById(rollno);
			Student student1=student.get();
			return student1;
		}
		@GetMapping("/getallstudent")
		public List<Student> getAll(){
			//List<Student> studentlist = 
		List<Student> st= studentres.findAll();
	return st;
					
		}
		
		@DeleteMapping("/delete/{rollno}")
			public String deletestudent(@PathVariable int rollno) {
			
			Student student= studentres.findById(rollno).get();
				if(	studentres!=null){
					studentres.delete(student);
			
			}
			
			return"deleted!!";
			
			
			
		}
		
		@PutMapping("/update")
		public Student   updatedata(@RequestBody Student student) {
			studentres.save(student);

			return student;
		}
		
		
	
		

}