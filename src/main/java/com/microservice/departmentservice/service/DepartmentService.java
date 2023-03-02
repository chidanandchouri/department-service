package com.microservice.departmentservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.departmentservice.entity.Department;
import com.microservice.departmentservice.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	public Department findDepartmrntById(long id) {	
		return departmentRepository.findByDeptId(id);
	}
	
	public List<Department> findAllDepartments() {	
		return departmentRepository.findAll();
	}

	public Department updateDepartment(Department dept) {
		return departmentRepository.save(dept);
	}

	public String deleteDept(Long id) {
		departmentRepository.deleteById(id);
		return "Record Deleted!!!";
	}
	
}
