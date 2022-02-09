package com.yedam.myserver.emp.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.myserver.emp.mapper.EmployeeMapper;
import com.yedam.myserver.emp.vo.Employee;

@RestController
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeMapper employeeDao;

	// 사원검색
	@RequestMapping(value = "/empSelect")
	public List<Employee> selectDepartment() {
		return employeeDao.findEmployees();
	}

	// 부서와 직업 검색
	@RequestMapping(value = "/empDeptJob")
	public Map<String, Object> jobDeptList() {
		Map<String, Object> map = new HashMap<>();
		map.put("jobs", employeeDao.findJobs());
		map.put("depts", employeeDao.findDepartments());
		return map;
	}

	// 사원등록
	@RequestMapping(value = "/empInsert", method = RequestMethod.POST)
	public Employee insertEmployees(Employee bean, HttpServletResponse response) {
		employeeDao.persist(bean);
		return bean;
	}

	// 사원정보수정
	@RequestMapping(value = "/empUpdate", method = RequestMethod.POST)
	public Employee updateEmployees(Employee bean, HttpServletResponse response) {
		employeeDao.merge(bean);
		return bean;
	}

	// 사원삭제
	@RequestMapping(value = "/empDelete", method = RequestMethod.POST)
	public Employee deleteEmployees(Employee bean, HttpServletResponse response) {
		employeeDao.remove(bean);
		return bean;
	}

	// 사원조회
	@RequestMapping(value = "/empSelect/{id}", method = RequestMethod.GET)
	public Employee getEmp(@PathVariable String id, Employee emp) {
		return employeeDao.selectEmp(id);
	}

	// 사원정보변경.
	@RequestMapping(value = "/changeJobSal", method = RequestMethod.POST)
	public Map<String, Object> changeJobSal(@RequestBody Employee bean, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("employee_id", bean.getEmployee_id());
		map.put("job_id", bean.getJob_id());
		map.put("department_name", bean.getDepartment_name());
		map.put("salary", bean.getSalary());

		employeeDao.changeJobSal(map);

		return map;
	}

	@RequestMapping(value = "/getDept", method = RequestMethod.POST)
	public Map getDept(@RequestBody Employee bean, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(bean.getDepartment_id());
		map.put("dept_id", bean.getDepartment_id());

		employeeDao.getDept(map);

		return map;
	}

}
