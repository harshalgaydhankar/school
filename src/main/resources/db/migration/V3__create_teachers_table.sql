CREATE TABLE `teachers` (
  `id`         INT                           NOT NULL AUTO_INCREMENT,
  `version`    INT                           NOT NULL  DEFAULT 0,
  `name`       varchar(45)                   NOT NULL,
  `gender`     enum('Male','Female','Other') NOT NULL,
  `age`        INT                           NOT NULL,
  `created`    TIMESTAMP                     NOT NULL  DEFAULT NOW(),
  `modified`   TIMESTAMP                     NOT NULL  DEFAULT NOW(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
