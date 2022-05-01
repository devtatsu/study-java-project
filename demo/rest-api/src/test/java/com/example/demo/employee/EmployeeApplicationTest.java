package com.example.demo.employee;

import org.junit.Test;
import org.springframework.http.ResponseEntity;

import com.example.demo.base.RestApiBaseTest;

import com.example.demo.common.constants.AppServerServiceURI;
import com.example.demo.controller.request.EmployeePostRequest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.springframework.http.HttpStatus;

import org.mockito.InjectMocks;
import org.springframework.test.context.jdbc.Sql;
import com.example.demo.domain.services.EmployeeService;
import com.example.demo.jpa.domain.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeApplicationTest
		extends RestApiBaseTest<EmployeeApplicationTest, EmployeePostRequest, Object> {

	@InjectMocks
	private EmployeeService service;

	@Autowired
	private EmployeeRepository repository;

	@Override
	public void setProperty() {
		super.logCls = EmployeeApplicationTest.class;
	}

	@Test
	public void test0001() {

		int hireDate = 202204;
		String sql = "SELECT * FROM employee WHERE hire_date = %d AND serial_no = 1;";

		super.assertDataMap.put("firstname", "test-1-firstname");
		super.assertDataMap.put("lastname", "test-1-lastname");
		super.assertDataMap.put("hire_date", hireDate);
		super.assertDataMap.put("department", "test-Department");
		super.assertDataList.add(super.assertDataMap);

		super.param = new EmployeePostRequest();

		super.param.setDepartment(assertDataMap.get("department").toString());
		super.param.setFirstname(assertDataMap.get("firstname").toString());
		super.param.setLastname(assertDataMap.get("lastname").toString());
		super.param.setHiredate(hireDate);

		ResponseEntity<?> response = super.curlPost(AppServerServiceURI.POST_EMPLOYEE);

		assertThat(response.getStatusCode(), is(HttpStatus.OK));

		super.chkSql = String.format(sql, hireDate);

		super.chkAssertData();

	}

	@Test
	public void test0002() {

		int hireDate = 202206;
		String sql = "SELECT * FROM employee WHERE hire_date = %d;";

		super.assertDataMap.put("firstname", "test-2-firstname");
		super.assertDataMap.put("lastname", "test-2-lastname");
		super.assertDataMap.put("hire_date", hireDate);
		super.assertDataMap.put("department", "test-2-Department");
		super.assertDataList.add(super.assertDataMap);

		super.param = new EmployeePostRequest();

		super.param.setDepartment(assertDataMap.get("department").toString());
		super.param.setFirstname(assertDataMap.get("firstname").toString());
		super.param.setLastname(assertDataMap.get("lastname").toString());
		super.param.setHiredate(hireDate);

		ResponseEntity<?> response = super.curlPost(AppServerServiceURI.POST_EMPLOYEE);

		assertThat(response.getStatusCode(), is(HttpStatus.OK));

		super.chkSql = String.format(sql, hireDate);

		super.chkAssertData();

	}

	@Test
	public void test0003() {

		int hireDate = 202206;
		String sql = "SELECT * FROM employee WHERE hire_date = %d;";

		super.assertDataMap.put("firstname", "test-2-firstname");
		super.assertDataMap.put("lastname", "test-2-lastname");
		super.assertDataMap.put("hire_date", hireDate);
		super.assertDataMap.put("department", "test-2-Department");
		super.assertDataList.add(super.assertDataMap);

		super.param = new EmployeePostRequest();

		EmployeePostRequest request = new EmployeePostRequest();
		request.setDepartment(assertDataMap.get("department").toString());
		request.setFirstname(assertDataMap.get("firstname").toString());
		request.setLastname(assertDataMap.get("lastname").toString());
		request.setHiredate(hireDate);

		this.service = new EmployeeService(this.repository);

		// コメント
		// 異常系のエラーハンドリングをテストする場合、service層からのテストでは確認できない
		//
		// 理由は、エラーハンドリングクラスに定義している`@ExceptionHandler`は@Controllerもしくは@ControllerAdviceを付与したクラス内で定義可能であり、
		// コントローラ層でthrowされたExceptionのエラーをハンドリングする仕様であるため
		this.service.addData(request);

		super.chkSql = String.format(sql, hireDate);

		// super.chkAssertData();

	}

	/**
	 * 異常系
	 * 一意制約
	 */
	@Test
	@Sql(scripts = "/employee/setUpData.sql")
	public void test0004() {

		int hireDate = 202206;
		// String sql = "SELECT * FROM employee WHERE hire_date = %d;";

		super.assertDataMap.put("firstname", "test-2-firstname");
		super.assertDataMap.put("lastname", "test-2-lastname");
		super.assertDataMap.put("hire_date", hireDate);
		super.assertDataMap.put("department", "test-2-Department");
		super.assertDataList.add(super.assertDataMap);

		super.param = new EmployeePostRequest();

		super.param.setDepartment(assertDataMap.get("department").toString());
		super.param.setFirstname(assertDataMap.get("firstname").toString());
		super.param.setLastname(assertDataMap.get("lastname").toString());
		super.param.setHiredate(hireDate);

		ResponseEntity<?> response = super.curlPost(AppServerServiceURI.POST_EMPLOYEE);

		assertThat(response.getStatusCode(), is(HttpStatus.INTERNAL_SERVER_ERROR));

	}

}
