package kafka.client.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import kafka.demo.model.Department;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "empId")
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long empId;
	String empName;
	@ManyToOne
	@JoinColumn(name = "depId", updatable = false)
//	@JsonBackReference
	DepartmentEntity department;

	

	public Long getEmpId() {
		return empId;
	}



	public void setEmpId(Long empId) {
		this.empId = empId;
	}



	public String getEmpName() {
		return empName;
	}



	public void setEmpName(String empName) {
		this.empName = empName;
	}



	public DepartmentEntity getDepartment() {
		return department;
	}



	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}



	@Override
	public String toString() {
		return "Employee [id=" + empId + ", name=" + empName + ", department=" + department + "]";
	}

}
