create user 'dywlr'@'localhost' identified by '1111';

create database members default character set utf8;

grant select, insert, update, delete, create, drop, alter, on members.* to 'dywlr'@'localhost' identified by '1111';

grant select, insert, update, delete, create, drop, alter, on members.* to 'dywlr'@'%' identified by '1111';

create table imgdata(
img_id	int(10)	not null auto_increment primary key,
email 	varchar(30)	not null,
filename 	varchar(50)	not null,
realpath 	varchar(100) 	not null
);

create table memberlist(
email 	varchar(30)	not null	primary key,
password	varchar(20)	not null,
sexual	varchar(10) 	not null,
birth	varchar(10)	not null,
teloff	varchar(10)	not null,
phone	varchar(20)	not null,
name	varchar(10)	not null
);

create table profilelist(
email 	varchar(30)	not null	primary key,
categories	varchar(30),
locales		varchar(30),
universe		varchar(30),
attending		varchar(30),
title		varchar(30),
career		varchar(250),
teacher		varchar(250),
clas		varchar(250)
);