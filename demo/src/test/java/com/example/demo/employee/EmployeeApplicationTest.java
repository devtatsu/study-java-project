package com.example.demo.employee;

import org.junit.Test;

import com.example.demo.base.RestApiBaseTest;

import java.util.List;
import java.util.Map;

import com.example.demo.application.common.constants.AppServerServiceURI;
import com.example.demo.application.controller.request.EmployeePostRequest;
import com.example.demo.application.controller.response.GreetingResponse;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class EmployeeApplicationTest
		extends RestApiBaseTest<EmployeeApplicationTest, EmployeePostRequest, GreetingResponse> {

	@Override
	public void setProperty() {
		super.logCls = EmployeeApplicationTest.class;
		super.responseCls = GreetingResponse.class;
	}

	@Test
	public void test0001() {

		super.param = new EmployeePostRequest();

		super.param.setDepartment("test-Department");
		super.param.setFirstname("test-firstname");
		super.param.setLastname("test-lastname");
		super.param.setHiredate(202204);

		super.curlPost(AppServerServiceURI.POST_EMPLOYEE);

	}

	@Test
	public void test0002() {

		super.param = new EmployeePostRequest();

		super.param.setDepartment("test-2-Department");
		super.param.setFirstname("test-2-firstname");
		super.param.setLastname("test-2-lastname");
		super.param.setHiredate(202206);

		super.curlPost(AppServerServiceURI.POST_EMPLOYEE);

		List<Map<String, Object>> getDataList = getData("SELECT * FROM employee;");

		// assertThat(resultNoticedUsers.size(), is(1));

		// assertThat(resultNoticedUsers.get(0).get("app_user_id"), is(notNullValue()));
		// assertThat(resultNoticedUsers.get(0).get("dcp_user_id"),
		// is(response.getDcpUserId()));
		// assertThat(resultNoticedUsers.get(0).get("dcp_user_token"),
		// is(response.getDcpUserToken()));
		// assertThat(resultNoticedUsers.get(0).get("cognito_user_id"),
		// is(request.getUsername()));
		// assertThat(resultNoticedUsers.get(0).get("resident_flg"), is(false));
		// assertThat(resultNoticedUsers.get(0).get("user_terminal_id"),
		// is(nullValue()));
		// assertThat(resultNoticedUsers.get(0).get("created_date"),
		// is(notNullValue()));
		// assertThat(resultNoticedUsers.get(0).get("created_by"),
		// is(ApiFunc.APP004.getId()));
		// assertThat(resultNoticedUsers.get(0).get("updated_date"),
		// is(notNullValue()));
		// assertThat(resultNoticedUsers.get(0).get("updated_by"),
		// is(ApiFunc.APP004.getId()));

		for (Map<String, Object> oneMap : getDataList) {
			logger.info("==== START ====");
			logger.info("employee_id:[{}]", oneMap.get("employee_id"));
			logger.info("firstname:[{}]", oneMap.get("firstname"));
			logger.info("lastname:[{}]", oneMap.get("lastname"));
			logger.info("department:[{}]", oneMap.get("department"));
			logger.info("hire_date:[{}]", oneMap.get("hire_date"));
			logger.info("serial_no:[{}]", oneMap.get("serial_no"));
			logger.info("==== END ====");

		}

	}

}
