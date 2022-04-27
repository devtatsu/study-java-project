-- テスト用：部門
DROP TABLE IF EXISTS DEPT;

CREATE TABLE DEPT (
    ID IDENTITY NOT NULL PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL
);

-- 社員
DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
    employee_id INT NOT NULL PRIMARY KEY,
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    department VARCHAR(255)
);

-- プロフィール
DROP TABLE IF EXISTS profile;

CREATE TABLE profile (
    profile_id INT NOT NULL PRIMARY KEY,
    employee_id INT,
    address VARCHAR(255),
    age INT
);

-- スキル
DROP TABLE IF EXISTS skill;

CREATE TABLE skill (
    skill_id INT NOT NULL PRIMARY KEY,
    employee_id INT,
    skill_content VARCHAR(255)
);
