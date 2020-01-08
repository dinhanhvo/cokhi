CREATE TABLE `request` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `requestID` varchar(40) NOT NULL,
  `params` varchar(1000),
  `response` text(500000),
  `duration` int,
  `worker` int,
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `proxyHost` varchar(100),
  `proxyPort` varchar(100),
  `proxyUser` varchar(100),
  `proxyPass` varchar(100),
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table request
add worker int;

drop table request;
select * from request;
select id, requestID, duration, worker, created_at, proxyHost, response from request;
delete from request;


CREATE TABLE `items` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(1000),
  `description` text(5000),
  `imagepath` text(5000),
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `prices` int,
  `note` varchar(100),
  `type` varchar(100),
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200),
  `description` text(5000),
  `imagepath` text(1000),
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `price` bigint,
  `note` varchar(100),
  `from` varchar(100),
  `status` varchar(100),
  `unit` varchar(100),
  `type` varchar(100),
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

