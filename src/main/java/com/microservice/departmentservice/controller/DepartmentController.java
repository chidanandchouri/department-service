package com.microservice.departmentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.departmentservice.entity.Department;
import com.microservice.departmentservice.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;

	@GetMapping("getName")
	public String getName() {
		return "Chidanand";
	} 

	@PostMapping("/saveDepartment")
	public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
		log.info("Inside saveDepartment method");
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(departmentService.saveDepartment(department));
	}

	@GetMapping("/{Id}")
	public Department getDepartment(@PathVariable("Id") Long id) {
		log.info("Inside getDepartment method");
		return departmentService.findDepartmrntById(id);
	}

	@GetMapping()
	public List<Department> getAllDepartments(){
		log.info("Inside getAllDepartments method");
		return departmentService.findAllDepartments();
	}

	@GetMapping("/all")
	public ResponseEntity<List<Department>> getAllDepartmentsJson(){
		log.info("Inside getAllDepartments method");
		return ResponseEntity
				.status(HttpStatus.OK)
				.header("Header", "Passing")
				.body(departmentService.findAllDepartments());
		//return new ResponseEntity<>( departmentService.findAllDepartments(),null, HttpStatus.OK);
	}

	@PutMapping("/updateDept")
	public ResponseEntity<Department> updateDepartment(@RequestBody Department dept){
		log.info("Inside updateDepartment method");
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(departmentService.updateDepartment(dept));
	}

	@DeleteMapping("{Id}")
	public ResponseEntity<String> deleteDept(@PathVariable("Id") Long id){
		log.info("Inside deleteDept method");
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(departmentService.deleteDept(id));
	}

}
