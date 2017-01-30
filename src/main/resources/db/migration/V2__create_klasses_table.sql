CREATE TABLE `klasses` (
  `id`         INT            NOT NULL  AUTO_INCREMENT,
  `version`    INT            NOT NULL  DEFAULT 0,
  `name`       VARCHAR(255)   NOT NULL,
  `semester`   DATE           NOT NULL,
  `credits`    INT            NOT NULL DEFAULT 1,
  `department` ENUM('SCIENCE', 'ENGINEERING', 'LITERATURE', 'PHILOSOPHY') NOT NULL,
  `fee`        DECIMAL(12, 2) NOT NULL,
  `created`    TIMESTAMP      NOT NULL  DEFAULT NOW(),
  `modified`   TIMESTAMP      NOT NULL  DEFAULT NOW(),
  PRIMARY KEY (`id`));



-- CREATE TABLE `klasses` (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `version` int(11) NOT NULL DEFAULT '0',
--   `name` varchar(255) NOT NULL,
--   `semester` date NOT NULL,
--   `credits` int(11) NOT NULL DEFAULT '1',
--   `department` enum('SCIENCE','ENGINEERING','LITERATURE','PHILOSOPHY') NOT NULL,
--   `fee` decimal(12,2) NOT NULL,
--   `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
--   `modified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
--   PRIMARY KEY (`id`),
--   CONSTRAINT `teacher_id` FOREIGN KEY (`id`) REFERENCES `teachers` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
-- ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
