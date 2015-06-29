package ftt.company.service;

import java.util.List;

import ftt.company.domain.Department;

public class DepartmentService {
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	public List<Department> getAll() {
		return departmentService.getAll();
	}
}
