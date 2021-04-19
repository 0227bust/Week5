create database if not exists MyShows;

use MyShows;

drop table if exists shows;

create table shows (
	id int(10) not null auto_increment,
    name varchar(50) not null,
    primary key(id)
);