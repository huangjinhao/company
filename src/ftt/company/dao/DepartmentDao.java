package ftt.company.dao;

import java.util.List;

import ftt.company.domain.Department;

public class DepartmentDao extends BaseDao {
	public List<Department> getAll() {
		String hqlString = "FROM Department";
		return getSession().createQuery(hqlString).list();
	}
}
