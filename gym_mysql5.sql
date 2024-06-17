SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- Table structure for admin

DROP TABLE IF EXISTS admin;
CREATE TABLE admin  (
adminNo int NOT NULL AUTO_INCREMENT,
adminAccount varchar(255) NULL DEFAULT NULL,
adminPassword varchar(255) NULL DEFAULT NULL,
token varchar(255) NULL DEFAULT NULL,
PRIMARY KEY (adminNo) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 ROW_FORMAT = Dynamic;

-- Records of admin

INSERT INTO admin VALUES (1, 'admin', 'admin', '');

-- Table structure for checkin

DROP TABLE IF EXISTS checkin;
CREATE TABLE checkin  (
checkNo int NOT NULL AUTO_INCREMENT,
memberNo int NULL DEFAULT NULL,
checkDate datetime NULL DEFAULT NULL,
PRIMARY KEY (checkNo) USING BTREE,
INDEX memberNo(memberNo ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 ROW_FORMAT = Dynamic;

-- Records of checkin

INSERT INTO checkin VALUES (1, 1, '2023-06-20 00:00:00');
INSERT INTO checkin VALUES (2, NULL, '2023-06-29 00:00:00');

-- Table structure for course

DROP TABLE IF EXISTS course;
CREATE TABLE course  (
courseNo int NOT NULL AUTO_INCREMENT,
courseName varchar(255) NULL DEFAULT NULL,
courseTime datetime NULL DEFAULT NULL,
courseDuration varchar(255) NULL DEFAULT NULL,
coursePrice decimal(10, 2) NULL DEFAULT NULL,
courseDesc varchar(255) NULL DEFAULT NULL,
courseIntegral int NULL DEFAULT NULL,
employeeNo int NULL DEFAULT NULL COMMENT '教练员工编号',
managerNo int NULL DEFAULT NULL COMMENT '经理编号',
PRIMARY KEY (courseNo) USING BTREE,
INDEX employeeNo(employeeNo ASC) USING BTREE,
INDEX managerNo(managerNo ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 ROW_FORMAT = Dynamic;

-- Records of course

INSERT INTO course VALUES (1, '11', '2023-06-30 00:00:00', '11', 11.00, '11', 11, 1, 1);

-- Table structure for employee

DROP TABLE IF EXISTS employee;
CREATE TABLE employee  (
employeeNo int NOT NULL AUTO_INCREMENT,
employeeAge int NULL DEFAULT NULL,
employeeName varchar(255) NULL DEFAULT NULL,
employeeGender varchar(255) NULL DEFAULT NULL,
employeePhone varchar(255) NULL DEFAULT NULL,
employeeTime datetime NULL DEFAULT NULL,
employeeMessage text NULL,
employeeJob int NULL DEFAULT NULL COMMENT '1 教练 2前台 3保洁 4经理',
PRIMARY KEY (employeeNo) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 ROW_FORMAT = Dynamic;

-- Records of employee

INSERT INTO employee VALUES (1, 35, '橙灰', 'M', '15798645769', '2023-06-20 12:18:29', '冠军教练', 1);
INSERT INTO employee VALUES (2, 40, '小黄', 'M', '13568974568', '2023-06-29 09:38:48', '项目经理', 4);
INSERT INTO employee VALUES (3, 24, '小胡', 'F', '13598756985', '2023-06-29 10:09:15', NULL, 2);

-- Table structure for equipment

DROP TABLE IF EXISTS equipment;
CREATE TABLE equipment  (
equipmentNo int NOT NULL AUTO_INCREMENT,
equipmentName varchar(255) NULL DEFAULT NULL,
equipmentLocation varchar(255) NULL DEFAULT NULL,
equipmentState int NULL DEFAULT NULL,
equipmentMessage varchar(255) NULL DEFAULT NULL,
employeeJob varchar(255) NULL DEFAULT NULL,
PRIMARY KEY (equipmentNo) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 ROW_FORMAT = Dynamic;

-- Records of equipment

INSERT INTO equipment VALUES (1, '跑步机', '大厅', 1, '无', NULL);

-- Table structure for manager

DROP TABLE IF EXISTS manager;
CREATE TABLE manager  (
managerNo int NOT NULL AUTO_INCREMENT,
employeeNo int NULL DEFAULT NULL,
PRIMARY KEY (managerNo) USING BTREE,
INDEX employeeNo(employeeNo ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 ROW_FORMAT = Dynamic;

-- Records of manager

INSERT INTO manager VALUES (1, 2);

-- Table structure for member

DROP TABLE IF EXISTS member;
CREATE TABLE member (
memberNo INT NOT NULL AUTO_INCREMENT,
memberUsername VARCHAR(255) NULL DEFAULT NULL,
memberPassword VARCHAR(255) NULL DEFAULT NULL,
memberName VARCHAR(255) NULL DEFAULT NULL,
memberAge INT NULL DEFAULT NULL,
memberGender VARCHAR(255) NULL DEFAULT NULL,
memberPhone VARCHAR(255) NULL DEFAULT NULL,
cardTime DATETIME NULL DEFAULT NULL,
memberHeight DOUBLE NULL DEFAULT NULL,
memberWeight DOUBLE NULL DEFAULT NULL,
cardClass INT NULL DEFAULT NULL,
cardNextClass INT NULL DEFAULT NULL,
memberIntegral INT NULL DEFAULT NULL,
memberChange INT NULL DEFAULT NULL,
personalizedSignature VARCHAR(255) NULL DEFAULT NULL,
memberPower VARCHAR(255) NULL DEFAULT NULL,
token VARCHAR(255) NULL DEFAULT NULL,
PRIMARY KEY (memberNo),
UNIQUE INDEX memberPhone (memberPhone) COMMENT '手机号唯一'
) ENGINE = InnoDB AUTO_INCREMENT = 5 ROW_FORMAT = Dynamic;

-- Records of member

INSERT INTO member VALUES (1, 'admin', 'admin', 'admin', 18, 'F', '18470558967', '2023-06-20 12:12:01', 175, 60, 200, 150, 47, 39, 'hhh', '1', NULL);
INSERT INTO member VALUES (2, '0031023684', '123456', '1', 20, 'M', '18470668957', '2023-06-20 12:16:16', 180, 70, 50, 50, 20, 20, NULL, '2', NULL);
INSERT INTO member VALUES (3, 'admin', '', 'admin', 18, 'F', '18470558961', '2023-06-20 12:12:01', 175, 60, 200, 150, 51, 500, NULL, '1', NULL);

-- Table structure for recharge

DROP TABLE IF EXISTS recharge;
CREATE TABLE recharge (
rechargeNo INT NOT NULL AUTO_INCREMENT,
rechargeDate DATETIME NULL DEFAULT NULL,
rechargeMethod VARCHAR(255) NULL DEFAULT NULL,
rechargeStatus INT NULL DEFAULT NULL,
rechargeMoney DOUBLE NULL DEFAULT NULL,
memberNo INT NULL DEFAULT NULL,
PRIMARY KEY (rechargeNo),
INDEX memberNo (memberNo) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 ROW_FORMAT = Dynamic;

-- Records of recharge

INSERT INTO recharge VALUES (1, '2023-06-29 00:00:00', '在线充值', 1, 50, 1);

-- Table structure for register

DROP TABLE IF EXISTS register;
CREATE TABLE register (
registerNo INT NOT NULL AUTO_INCREMENT,
courseNo INT NULL DEFAULT NULL,
memberNo INT NULL DEFAULT NULL,
PRIMARY KEY (registerNo),
INDEX courseNo (courseNo) USING BTREE,
INDEX memberNo (memberNo) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 ROW_FORMAT = Dynamic;

-- Records of register

INSERT INTO register VALUES (1, 1, 2);
INSERT INTO register VALUES (2, 1, 1);

SET FOREIGN_KEY_CHECKS = 1;