package com.example.demo.application.domain.services;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.application.controller.request.EmployeePostRequest;
import com.example.demo.application.domain.models.Employee;
import com.example.demo.application.domain.repositories.EmployeeRepository;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    // 社員ID 連番 フォーマット
    private static final String SERIAL_NO_FORMAT_TMPL = "%04d";

    // 新社員ID
    private long newEmployeeId;
    // 新連番
    private int newSerialNo;

    @Transactional
    public void addData(EmployeePostRequest request) {

        // 社員ID生成
        createEmployeeId(request.getHiredate());

        // 登録
        Employee addRecord = new Employee();

        // 社員ID
        addRecord.setEmployeeId(this.newEmployeeId);
        // 氏名（姓）
        addRecord.setFirstname(request.getFirstname());
        // 氏名（名）
        addRecord.setLastname(request.getLastname());
        // 所属部署
        addRecord.setDepartment(request.getDepartment());
        // 入社日
        addRecord.setHireDate(request.getHiredate());
        // 連番
        addRecord.setSerialNo(this.newSerialNo);

        try {
            this.repository.save(addRecord);
        } catch (DataAccessException e) {
            logger.error("Error Message(DataAccessException):{}", e.getMessage());
        }

    }

    /**
     * 社員ID生成
     * 
     * @param hireDate 入社日
     */
    private void createEmployeeId(int hireDate) {

        List<Employee> resultList = new ArrayList<Employee>();

        if (hireDate == 0) {
            // 社員データ全件取得
            resultList = this.repository.findAll();
        } else {
            // 社員データ取得（入社日）
            resultList = this.repository.findByHireDate(hireDate);
        }

        setNewSerialNoAndEmployeeNo(resultList, hireDate);

    }

    /**
     * 社員ID、連番の生成とセット
     * 
     * @param employeeList 社員リスト
     * @param hireDate     入社日
     * 
     */
    private void setNewSerialNoAndEmployeeNo(List<Employee> employeeList, int hireDate) {

        Employee maxRecord = null;
        String newEmployeeNo = null;

        if (employeeList.size() <= 0) {
            maxRecord = new Employee();
            maxRecord.setHireDate(hireDate);
            this.newSerialNo = 1;
        } else {
            // 社員データの中から入社日が最新のデータを1件取得
            maxRecord = employeeList.stream().max(Comparator.comparing(Employee::getHireDate)).get();

            // 入社日でグルーピングして、それぞれのグループの最大連番を取得
            Map<Integer, Optional<Employee>> groupByMaxSerialNo = employeeList.stream().collect(
                    Collectors.groupingBy(
                            Employee::getHireDate,
                            Collectors.maxBy(Comparator.comparingLong(Employee::getSerialNo))));

            // 取得した最大連番をインクリメント
            this.newSerialNo = groupByMaxSerialNo.get(maxRecord.getHireDate()).get().getSerialNo() + 1;
        }

        newEmployeeNo = String.valueOf(maxRecord.getHireDate()) + formatSerialNo();
        this.newEmployeeId = Long.parseLong(newEmployeeNo);

    }

    /**
     * 連番フォーマット(4桁、0埋め)
     * 
     * @return フォーマットした連番
     * 
     */
    private String formatSerialNo() {
        return String.format(SERIAL_NO_FORMAT_TMPL, this.newSerialNo);
    }

}
