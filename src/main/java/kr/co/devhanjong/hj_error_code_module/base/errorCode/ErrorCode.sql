# VERSION :: MYSQL 5.7
#

DROP TABLE code_error_definition IF EXISTS;

CREATE TABLE `code_error_definition` (
`code` VARCHAR(5) NOT NULL COMMENT '00000 ~ 99999' COLLATE 'utf8_general_ci',
`http_status` INT(3) NOT NULL COMMENT 'http 상태코드',
`msg` TEXT NOT NULL COLLATE 'utf8_general_ci',
`memo` VARCHAR(500) NOT NULL DEFAULT '' COLLATE 'utf8_general_ci',
`reg_date` DATETIME NOT NULL,
`mod_date` DATETIME NULL DEFAULT NULL,
PRIMARY KEY (`code`) USING BTREE
)
COMMENT='00000 ~ 9999 -> client error\r\n10000 ~ 19999 -> admin error\r\n\r\n필요하면 zone을 추가하자'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

DELETE FROM `code_error_definition` WHERE `code`='0000';
INSERT INTO `code_error_definition` (`code`, `http_status`, `msg`, `memo`, `reg_date`, `mod_date`) VALUES ('0000', 200, 'success', '', '2023-04-06 11:30:26', NULL);
DELETE FROM `code_error_definition` WHERE `code`='1119';
INSERT INTO `code_error_definition` (`code`, `http_status`, `msg`, `memo`, `reg_date`, `mod_date`) VALUES ('1119', 404, '잘못된 로그인 정보입니다.', '', '2023-04-06 11:30:26', NULL);
DELETE FROM `code_error_definition` WHERE `code`='200';
INSERT INTO `code_error_definition` (`code`, `http_status`, `msg`, `memo`, `reg_date`, `mod_date`) VALUES ('200', 200, 'success', '', '2023-04-06 11:30:26', NULL);
DELETE FROM `code_error_definition` WHERE `code`='401';
INSERT INTO `code_error_definition` (`code`, `http_status`, `msg`, `memo`, `reg_date`, `mod_date`) VALUES ('401', 401, '인증실패', '', '2023-04-06 11:30:26', NULL);
DELETE FROM `code_error_definition` WHERE `code`='403';
INSERT INTO `code_error_definition` (`code`, `http_status`, `msg`, `memo`, `reg_date`, `mod_date`) VALUES ('403', 403, '허용되지 않은 요청입니다.', '', '2023-04-06 11:30:26', NULL);
DELETE FROM `code_error_definition` WHERE `code`='500';
INSERT INTO `code_error_definition` (`code`, `http_status`, `msg`, `memo`, `reg_date`, `mod_date`) VALUES ('500', 500, '확인되지 않은 오류입니다 . 잠시 후 다시 시도해 주세요.', '', '2023-04-06 11:30:26', NULL);
DELETE FROM `code_error_definition` WHERE `code`='91000';
INSERT INTO `code_error_definition` (`code`, `http_status`, `msg`, `memo`, `reg_date`, `mod_date`) VALUES ('91000', 200, '테스트 메시지', '테스트용', '2023-04-06 11:30:26', NULL);
DELETE FROM `code_error_definition` WHERE `code`='91001';
INSERT INTO `code_error_definition` (`code`, `http_status`, `msg`, `memo`, `reg_date`, `mod_date`) VALUES ('91001', 200, '포멧 {0} 테스트 {1} {2}', '테스트용', '2023-04-06 11:30:26', NULL);
DELETE FROM `code_error_definition` WHERE `code`='9999';
INSERT INTO `code_error_definition` (`code`, `http_status`, `msg`, `memo`, `reg_date`, `mod_date`) VALUES ('9999', 500, '오류. 고객센터에 문의 바랍니다. {0} {1}', '', '2023-04-06 11:30:26', NULL);
