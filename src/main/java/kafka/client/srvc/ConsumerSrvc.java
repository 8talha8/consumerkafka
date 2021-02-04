package kafka.client.srvc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import kafka.client.swagger.model.Department;
import kafka.client.swagger.model.Employee;

@Service
public class ConsumerSrvc {
	private final Logger logger = LoggerFactory.getLogger(ConsumerSrvc.class);

//	s@KafkaListener(topics = "departmentTopic", groupId = "group_id")
//	public void consume(Department message) {
//		logger.info(String.format(">>> Consumed Message for Department", message));
//	}
//	@KafkaListener(topics = "employeeTopic", groupId = "group_id")
//	public void consumeEmp(Employee message) {
//		logger.info(String.format(">>> Consumed Message for Employee", message));
//	}
	@KafkaListener(topics = "departmentTopicLst", groupId = "group_id")
	public void consumeLst(List<Department> message) {
		logger.info(String.format(">>> Consumed Message for Department", message));
	}
	@KafkaListener(topics = "employeeTopicLst", groupId = "group_id")
	public void consumeEmpLst(List<Employee> message) {
		logger.info(String.format(">>> Consumed Message for Employee", message));
	}
}