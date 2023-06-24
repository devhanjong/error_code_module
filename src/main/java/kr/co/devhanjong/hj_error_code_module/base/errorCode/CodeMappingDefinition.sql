

DROP TABLE code_mapping_definition IF EXISTS;

CREATE TABLE `code_mapping_definition` (
`schema` VARCHAR(50) NOT NULL COLLATE 'utf8_general_ci',
`table` VARCHAR(50) NOT NULL COLLATE 'utf8_general_ci',
`column` VARCHAR(50) NOT NULL COLLATE 'utf8_general_ci',
`code` VARCHAR(50) NOT NULL COLLATE 'utf8_general_ci',
`code_han` VARCHAR(50) NOT NULL COLLATE 'utf8_general_ci',
`memo` TEXT NULL DEFAULT NULL COLLATE 'utf8_general_ci',
`use_yn` CHAR(1) NOT NULL DEFAULT 'Y' COLLATE 'utf8_general_ci',
`sort` INT(11) NULL DEFAULT NULL,
`mod_adm` INT(11) NULL DEFAULT NULL,
`reg_date` DATETIME NOT NULL,
`mod_date` DATETIME NULL DEFAULT NULL,
PRIMARY KEY (`schema`, `table`, `column`, `code`) USING BTREE
)
COMMENT='테이블별 코드와 코드의 한글명을 매핑한다.'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

DELETE FROM `code_mapping_definition` WHERE `schema`='upts' AND `table`='test_table' AND `column`='test_column' AND `code`='1';
INSERT INTO `code_mapping_definition` (`schema`, `table`, `column`, `code`, `code_han`, `memo`, `use_yn`, `sort`, `mod_adm`, `reg_date`, `mod_date`) VALUES ('upts', 'test_table', 'test_column', '1', '한국', NULL, 'Y', 1, 1, '2023-04-03 15:34:15', NULL);
DELETE FROM `code_mapping_definition` WHERE `schema`='upts' AND `table`='test_table' AND `column`='test_column' AND `code`='2';
INSERT INTO `code_mapping_definition` (`schema`, `table`, `column`, `code`, `code_han`, `memo`, `use_yn`, `sort`, `mod_adm`, `reg_date`, `mod_date`) VALUES ('upts', 'test_table', 'test_column', '2', '미국', NULL, 'Y', 1, 1, '2023-04-03 15:34:15', NULL);
