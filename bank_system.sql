create database bank_system;
use bank_system;

create table login(cardno varchar(20),pin varchar(5));

create table signup(name varchar(30),fname varchar(30),date varchar(5),month varchar(10),
					year varchar(5),gender varchar(7),email varchar(50), marital varchar(10), 
                    address varchar(50),city varchar(20),pincode varchar(10), state varchar(20),formno varchar(10));


create table signup2(formno varchar(10),religion varchar(15), category varchar(15),income varchar(15),
					 education varchar(20),occupation varchar(20),cnicno varchar(15),bisp varchar(20), 
					 senior varchar(5), existing varchar(5));

create table signup3(formno varchar(30), account varchar(40), cardno varchar(25),pin varchar(40), service_required varchar(200));


create table bank(pin varchar(10), deposit varchar(15), withdraw varchar(15), balance varchar(15)); 

drop table signup3;