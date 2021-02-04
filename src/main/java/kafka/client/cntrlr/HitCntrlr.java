package kafka.client.cntrlr;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.fasterxml.jackson.databind.ObjectMapper;

import kafka.client.swagger.api.DepartmentCntrlrApi;
import kafka.client.swagger.api.EmployeeCntrlrApi;
import kafka.client.swagger.invoker.ApiClient;
import kafka.client.swagger.model.Department;
import kafka.client.swagger.model.Employee;
import kafka.client.swagger.model.Status;

@RestController
@RequestMapping("/hit")
public class HitCntrlr {
	@Autowired
	EmployeeCntrlrApi employeeCntrlrApi;
	@Autowired
	DepartmentCntrlrApi departmentCntrlrApi;
	@Autowired
	ApiClient apiClient;
	@Autowired
	ObjectMapper objectMapper;
	static Long i;
	static Long j;

	@PostConstruct
	public void init() {
		apiClient.setBasePath("http://localhost:8082");
		i = 0L;
		j=0L;
	}

	@GetMapping("/1")
	public ResponseEntity<Status> saveDep() {
		Department department = new Department();
		department.setName("Dep" + i++);
		return departmentCntrlrApi.saveUsingPOSTWithHttpInfo(department);
	}

	@GetMapping("/2")
	public ResponseEntity<List<Department>> getAllDep() {
		return departmentCntrlrApi.getAllUsingGETWithHttpInfo();
	}
	@GetMapping("/22")
	public ResponseEntity<Department> find() throws RestClientException, IOException {
		List<Department> department = departmentCntrlrApi.getAllUsingGET();
		return departmentCntrlrApi.findUsingGETWithHttpInfo(department.get(0).getId());
	}

	@GetMapping("/3")
	public ResponseEntity<Status> updateDep() throws RestClientException, IOException {
		List<Department> department = departmentCntrlrApi.getAllUsingGET();
		Department departmentToUpdate = department.get(0);
		departmentToUpdate.setName(departmentToUpdate.getName() + "." + i);
		return departmentCntrlrApi.updateUsingPUTWithHttpInfo(departmentToUpdate);
	}
	

	@GetMapping("/4")
	public ResponseEntity<Status> deleteDep() throws RestClientException, IOException {
		List<Department> department = departmentCntrlrApi.getAllUsingGET();
		return departmentCntrlrApi.deleteUsingDELETEWithHttpInfo(department.get(0).getId());
	}

	@GetMapping("/6")
	public ResponseEntity<Status> saveEmp() {
		Employee employee = new Employee();
		employee.setEmpName("Emp" + j++);
		Department dep = departmentCntrlrApi.getAllUsingGET().get(0);
		employee.setDepartment(dep);
		return employeeCntrlrApi.saveUsingPOST1WithHttpInfo(employee);
	}

	@GetMapping("/7")
	public ResponseEntity<List<Employee>> getAllEmp() {
		return employeeCntrlrApi.getAllUsingGET1WithHttpInfo();
	}
	@GetMapping("/77")
	public ResponseEntity<Employee> findEmp() throws RestClientException, IOException {
		List<Employee> employee = employeeCntrlrApi.getAllUsingGET1();
		return employeeCntrlrApi.findUsingGET1WithHttpInfo(employee.get(0).getEmpId());
	}

	@GetMapping("/8")
	public ResponseEntity<Status> updateEmp() throws RestClientException, IOException {
		List<Employee> employees = employeeCntrlrApi.getAllUsingGET1();
		Employee employeeToUpdate = employees.get(0);
		employeeToUpdate.setEmpName(employeeToUpdate.getEmpName() + "." + j);
		return employeeCntrlrApi.updateUsingPUT1WithHttpInfo(employeeToUpdate);
	}

	@GetMapping("/9")
	public ResponseEntity<Status> deleteEmp() throws RestClientException, IOException {
		List<Employee> employee = employeeCntrlrApi.getAllUsingGET1();
		return employeeCntrlrApi.deleteUsingDELETE1WithHttpInfo(employee.get(0).getEmpId());
	}

}
