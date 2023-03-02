package com.microservice.departmentservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Dept_Id")
	private long deptId;
	@Column(name = "Dept_Name")
	private String deptName;
	@Column(name = "Dept_Adress")
	private String deptAdress;
	@Column(name = "Dept_Code")
	private String deptCode;
}
