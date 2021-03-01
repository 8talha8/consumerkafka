package kafka.client.srvc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import kafka.client.model.DepartmentEntity;
import kafka.client.repo.DepartmentRepo;
import kafka.demo.model.Department;
import kafka.demo.model.Employee;



@Service
public class ConsumerSrvc {
	@Autowired
	DepartmentRepo departmentRepo;
	private final Logger logger = LoggerFactory.getLogger(ConsumerSrvc.class);

	@KafkaListener(topics = "departmentTopic", groupId = "group_id")
	public void consume(Department message) {
		logger.info(">>> Consumed Message for Department"+ message.getName());
	}
	@KafkaListener(topics = "employeeTopic", groupId = "group_id")
	public void consumeEmp(Employee message) {
		logger.info(">>> Consumed Message for Employee", message);
	}
	@KafkaListener(topics = "departmentTopicLst", groupId = "group_id")
	public void consumeLst(List<Department> message) {
		logger.info(">>> Consumed Message for Department List", message);
	}
	@KafkaListener(topics = "employeeTopicLst", groupId = "group_id")
	public void consumeEmpLst(List<Employee> message) {
		logger.info(">>> Consumed Message for Employee List", message);
	}
	
	@KafkaListener(topics = "departmentTopicLstBatch", groupId = "group_id")
	public void consumeDptLstBatch(Department d) {
		
//		message.stream().forEach(d->save(d));
		logger.info(">>> Consumed Message for Department batch List"+ d.getName());
		DepartmentEntity de = new DepartmentEntity();
		de.setId(d.getId());
		de.setName(d.getName());
		departmentRepo.save(de);
	}
	
	
}