CREATE TABLE `Spittle` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `message` varchar(300),
  `time` datetime DEFAULT CURRENT_TIMESTAMP ,
  `latitude` double precision,
  `longitude` double precision,
  PRIMARY KEY (`id`)
);

insert into Spittle values(null,'message',null,33,44);