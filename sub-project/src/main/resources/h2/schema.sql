DROP ALL OBJECTS;

/*-----------------------------------------------*/
DROP TABLE IF EXISTS `TEAM`;

CREATE TABLE TEAM
(
	id INT(11) NOT NULL AUTO_INCREMENT COMMENT 'team_id',
	name VARCHAR(32) NOT NULL COMMENT 'name',
	status CHAR NOT NULL COMMENT 'user state',
	created_at DATETIME NOT NULL COMMENT 'created time',
	updated_at DATETIME COMMENT 'update time',
	created_by VARCHAR(64) NOT NULL COMMENT 'created by user name',
	updated_by VARCHAR(64) COMMENT 'update by user name',
	PRIMARY KEY (id)
);
