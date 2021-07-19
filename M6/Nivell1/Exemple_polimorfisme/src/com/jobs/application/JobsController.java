package com.jobs.application;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private final EmployeeRepository repository = new EmployeeRepository();
	
	public JobsController(){
		
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employee);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		// TODO Auto-generated method stub
		Employee managerEmployee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateManager());
		repository.addMember(managerEmployee);
	}


	public void payAllEmployeers() {
		// TODO Auto-generated method stub
		for (AbsStaffMember member : repository.getAllMembers()) {
			member.pay();
		}
	}

	public String getAllEmployees() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for (AbsStaffMember member : repository.getAllMembers())
			if(member instanceof Employee){
				sb.append("Emp [name=").append(member.getName()).append(", address=").append(member.getAddress()).append(", phone=").append(member.getPhone()).append(", salaryPerMonth=").append(member.getSalaryPerMonth()).append(", totalP=").append(member.getTotalPaid()).append("]\n");
			} else {
				sb.append("Vol [name=").append(member.getName()).append(", address=").append(member.getAddress()).append(", phone=").append(member.getPhone()).append(", descripcio=").append(member.getDescription()).append(", totalP=").append(member.getTotalPaid()).append("]\n");
			}


		return sb.toString();
	}

	public void createVolunteer(String name, String address, String phone, String description) throws Exception {
		// TODO Auto-generated method stub
		Volunteer volunteer = new Volunteer(name, address, phone, description);
		repository.addMember(volunteer);
	}
	
	
	
}
