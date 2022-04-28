package com.example.demo.employee;

import org.junit.Test;
import org.springframework.http.ResponseEntity;

import com.example.demo.base.RestApiBaseTest;

import com.example.demo.application.common.constants.AppServerServiceURI;
import com.example.demo.application.controller.request.EmployeePostRequest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.springframework.http.HttpStatus;

public class EmployeeApplicationTest
		extends RestApiBaseTest<EmployeeApplicationTest, EmployeePostRequest, Object> {

	@Override
	public void setProperty() {
		super.logCls = EmployeeApplicationTest.class;
	}

	@Test
	public void test0001() {

		int hireDate = 202204;
		String sql = "SELECT * FROM employee WHERE hire_date = %d AND serial_no = 3;";

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

}
