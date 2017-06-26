#!/bin/sh
#Date:2017/06/05
#Version:1.0.0
#Author:daiwq

mysql -uquantil -pquantil@123456 -e "

CREATE DATABASE IF NOT EXISTS account DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
use account;
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS account;
CREATE TABLE account (
  id varchar(36) NOT NULL,
  tenant_id varchar(36) DEFAULT NULL,
  username varchar(32) NOT NULL,
  password varchar(128) NOT NULL,
  status int(11) NOT NULL,
  last_login_at datetime NOT NULL,
  last_login_ip varchar(20) NOT NULL,
  description varchar(512) DEFAULT NULL,
  deleted int(11) NOT NULL,
  created_at datetime NOT NULL,
  created_by varchar(36) NOT NULL,
  updated_at datetime NOT NULL,
  updated_by varchar(36) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO account VALUES ('beebf56c412811e7827f782bcb048924', 'rdc', 'quantil', '31dca14797d9399e92f3ca15bc531252', '1', '2017-06-07 10:27:17', '10.8.108.78', '', '1', '2017-05-26 10:44:53', '', '2017-06-07 10:27:17', '');
INSERT INTO account VALUES ('c9089f3a41bb11e7827f782bcb048924', 'e3c359de41be11e7827f782bcb048924', 'admin', '04ff3ec62783574b3c5f852bce270d83', '1', '2017-05-04 22:11:53', '', null, '1', '2017-05-26 10:44:56', '', '2017-05-26 10:37:53', null);
INSERT INTO account VALUES ('1c2f775a41bd11e7827f782bcb048924', 'gslb', 'zxf', '93085cf87395adc2e013fbe66de14b6f', '1', '2017-06-01 15:19:37', '127.0.0.1', null, '1', '2017-05-26 10:44:59', '', '2017-06-01 15:19:37', '');
INSERT INTO account VALUES ('208e460a41bd11e7827f782bcb048924', 'rdc', 'dwq', '9619710e52016759b0e0967610b18a81', '1', '2017-06-05 15:58:45', '127.0.0.1', null, '1', '2017-05-26 10:45:03', '', '2017-06-05 15:58:45', '');
INSERT INTO account VALUES ('f594f36e41bd11e7827f782b3b048724', 'gslb', 'quantil', '31dca14797d9399e92f3ca15bc531252', '1', '2017-06-01 16:02:07', '127.0.0.1', null, '1', '2017-05-29 21:51:11', '', '2017-06-01 16:02:07', '');

DROP TABLE IF EXISTS account_info;
CREATE TABLE account_info (
  id varchar(36) NOT NULL,
  account_id varchar(35) NOT NULL,
  nickname varchar(32) DEFAULT NULL,
  real_name varchar(64) DEFAULT NULL,
  email varchar(64) DEFAULT NULL,
  telephone varchar(32) DEFAULT NULL,
  corporation varchar(128) DEFAULT NULL,
  others text,
  deleted int(11) NOT NULL,
  description varchar(512) DEFAULT NULL,
  created_at datetime NOT NULL,
  created_by varchar(36) NOT NULL,
  updated_at datetime NOT NULL,
  updated_by varchar(36) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO account_info VALUES ('d1661ffa412911e7827f782bcb048924', 'beebf56c412811e7827f782bcb048924', '', '', '', '22', '222', '22', '0', '', '2017-04-21 18:33:26', 'c9089f3a41bb11e7827f782bcb048924', '2017-04-27 18:33:32', 'c9089f3a41bb11e7827f782bcb048924');
INSERT INTO account_info VALUES ('9cf8e87c41bc11e7827f782bcb048924', 'c9089f3a41bb11e7827f782bcb048924', null, null, null, null, null, null, '0', null, '2017-05-26 10:40:23', 'c9089f3a41bb11e7827f782bcb048924', '2017-05-26 10:48:31', 'c9089f3a41bb11e7827f782bcb048924');
INSERT INTO account_info VALUES ('a662a95641bd11e7827f782bcb048924', '1c2f775a41bd11e7827f782bcb048924', null, null, null, null, null, null, '0', null, '2017-05-26 10:48:10', 'c9089f3a41bb11e7827f782bcb048924', '2017-05-26 10:48:28', 'c9089f3a41bb11e7827f782bcb048924');
INSERT INTO account_info VALUES ('ab5c81de41bd11e7827f782bcb048924', '208e460a41bd11e7827f782bcb048924', null, null, null, null, null, null, '0', null, '2017-05-26 10:48:14', 'c9089f3a41bb11e7827f782bcb048924', '0000-00-00 00:00:00', 'c9089f3a41bb11e7827f782bcb048924');

DROP TABLE IF EXISTS account_role;
CREATE TABLE account_role (
  id varchar(36) NOT NULL,
  role_id varchar(36) NOT NULL,
  account_id varchar(36) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO account_role VALUES ('bc7ea36e412911e7827f782bcb048924', '3ceb389c412911e7827f782bcb048924', 'beebf56c412811e7827f782bcb048924');
INSERT INTO account_role VALUES ('60e5cefe41bc11e7827f782bcb048924', '6b3b229241bb11e7827f782bcb048924', 'c9089f3a41bb11e7827f782bcb048924');
INSERT INTO account_role VALUES ('754d494241be11e7827f782bcb048924', 'f88dec8241bc11e7827f782bcb048924', '1c2f775a41bd11e7827f782bcb048924');
INSERT INTO account_role VALUES ('6e7cab7c41bd11e7827f782bcb048924', 'f88dec8241bc11e7827f782bcb048924', '208e460a41bd11e7827f782bcb048924');
INSERT INTO account_role VALUES ('edacab7c41bd11e7827f782bcb06671', '3ceb389c412911e7827f782bcb048924', 'f594f36e41bd11e7827f782b3b048724');

DROP TABLE IF EXISTS account_tenant;
CREATE TABLE account_tenant (
  id varchar(36) NOT NULL,
  account_id varchar(36) NOT NULL,
  tenant_id varchar(36) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
INSERT INTO account_tenant VALUES ('dc38bdea41bd11e7827f782bcb048924', 'beebf56c412811e7827f782bcb048924', '03616e1a412a11e7827f782bcb048924');
INSERT INTO account_tenant VALUES ('e0f7947841bd11e7827f782bcb048924', 'beebf56c412811e7827f782bcb048924', '189a9666412b11e7827f782bcb048924');
INSERT INTO account_tenant VALUES ('f594c46e41bd11e7827f782bcb048924', '1c2f775a41bd11e7827f782bcb048924', '189a9666412b11e7827f782bcb048924');
INSERT INTO account_tenant VALUES ('594072d841be11e7827f782bcb048924', '208e460a41bd11e7827f782bcb048924', '03616e1a412a11e7827f782bcb048924');
INSERT INTO account_tenant VALUES ('15968fe441bf11e7827f782bcb048924', 'c9089f3a41bb11e7827f782bcb048924', 'e3c359de41be11e7827f782bcb048924');

DROP TABLE IF EXISTS role;
CREATE TABLE role (
  id varchar(36) NOT NULL,
  code varchar(64) DEFAULT NULL,
  name varchar(64) NOT NULL,
  description varchar(512) DEFAULT NULL,
  parent_id varchar(36) DEFAULT NULL,
  created_at time DEFAULT NULL,
  created_by varchar(36) DEFAULT NULL,
  updated_by varchar(36) DEFAULT NULL,
  updated_at datetime DEFAULT NULL,
  deleted int(11) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO role VALUES ('3ceb389c412911e7827f782bcb048924', null, 'admin', 'Administrator', null, null, null, null, null, '1');
INSERT INTO role VALUES ('6b3b229241bb11e7827f782bcb048924', null, 'root', 'Super administrator', null, null, null, null, null, '1');
INSERT INTO role VALUES ('f88dec8241bc11e7827f782bcb048924', null, 'user', 'Regular user', null, null, null, null, null, '1');

DROP TABLE IF EXISTS tenant;
CREATE TABLE tenant (
  id varchar(36) NOT NULL,
  name varchar(128) NOT NULL,
  description varchar(512) DEFAULT NULL,
  admin varchar(36) NOT NULL,
  deleted int(11) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO tenant VALUES ('rdc', 'rdc', null, 'beebf56c412811e7827f782bcb048924', '1');
INSERT INTO tenant VALUES ('gslb', 'gslb', null, 'beebf56c412811e7827f782bcb048924', '1');
INSERT INTO tenant VALUES ('e3c359de41be11e7827f782bcb048924', '#', null, 'c9089f3a41bb11e7827f782bcb048924', null);

"
