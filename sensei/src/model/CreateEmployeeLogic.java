package model;

import dao.EmployeeDAO;

public class CreateEmployeeLogic {
	public boolean execute(Employee emp) {
		EmployeeDAO dao = new EmployeeDAO();
		if (dao.create(emp)) {
			return true;
		}
		return false;
	}
}
