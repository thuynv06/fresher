CREATE KEYSPACE javasampleapproach
WITH replication = {
	'class' : 'SimpleStrategy',
	'replication_factor' : 1
};

CREATE TABLE user1 (
    userid int,
    email text,
    firstname text,
    lastname text,
    password text,
    phone int,
    username text,
    PRIMARY KEY ((username), userid)

) ;

select * from employee;
select * from user1 where 

CREATE TABLE role (
    roleid int,
    rolename text,
    username text,
    PRIMARY KEY ((username), roleid)
)


CREATE TABLE customer(
   id timeuuid PRIMARY KEY,
   name text,
   age int,
   active boolean
);

create table app_user(
user_id uuid,
username varchar,
password varchar,
enable boolean,
primary key (username,enable)
);
select * from app_user;
create table user_role(
id uuid,
user_id uuid,
role_id int,
primary key (user_id,role_id)
);

select role_id from user_role where user_id=361d8e70-59a6-11e8-97cc-8dc2153e86b0;

create table app_role(
role_id int,
role_name varchar,
primary key (role_id)
);
Delete  FROM employee WHERE user_id=361d8e70-59a6-11e8-97cc-8dc2153e86b0;
select * from app_user;
insert into app_user (user_id, username, password, enable)
values (now(), 'dbuser1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', true);

insert into app_user (user_id, username, password, enable)
values (now(), 'admin', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', true);

insert into app_role (role_id, role_name)
values (1, 'ROLE_ADMIN');

insert into app_role (role_id, role_name)
values (2, 'ROLE_USER');

insert into user_role (id,user_id, role_id)
values (now(), 886b5ff0-5a72-11e8-8a9a-e7aeb4327419, 1);
insert into user_role (id,user_id, role_id)
values (now(), 99fcc010-5a72-11e8-8a9a-e7aeb4327419, 2);



create table employee(
user_id uuid,
name varchar,
group_id bigint,
age int,
address varchar,
reference map<varchar,varchar>,
primary key (user_id,group_id)
);



insert into employee (user_id,name,group_id,age,address,reference)
values (now(),'Helen',1,22,'Ha Noi',{'parent_id':'null','child_id':'1'});
insert into employee (user_id,name,group_id,age,address,reference)
values (now(),'Michael',1,22,'Ha Noi',{'parent_id':'null','child_id':'1'});
insert into employee (user_id,name,group_id,age,address,reference)
values (now(),'Clover',1,22,'Ha Noi',{'parent_id':'null','child_id':'1'});
select * from employee;


create table group(
group_id int,
name varchar,
primary key (group_id)
);

insert into group (group_id,name) values (1,'Khối A');
insert into group (group_id,name) values (2,'Khối B');
insert into group (group_id,name) values (3,'Khối C');
select * from group;
	

create table project(
project_id uuid,
name varchar,
desciption text,
group_id int,
status boolean,
create_at date,
end_at date,
primary key (project_id,group_id)
);
insert into project (project_id,name,desciption,group_id,status,create_at) values (now(),'Project Internal','project a',1,false,'2018-05-02');
insert into project (project_id,name,desciption,group_id,status,create_at) values (now(),'Project External','project a',2,false,'2018-05-05');
insert into project (project_id,name,desciption,group_id,status,create_at) values (now(),'Project IOT','project a',1,false,'2018-05-11');
insert into project (project_id,name,desciption,group_id,status,create_at) values (now(),'Project App Mobile','project a',3,false,'2018-04-02');
select * from project;
select * from project limit 1;

create table allocated(
id uuid;
project_id uui,
user_id uuid,
month int,
status boolean,
completed float,
expect float,
create_at date,
end_at date,
primary key ((user_id,project_id),month)
);

insert into allocated (id,project_id,user_id,month,status,expect,create_at,end_at) values (now(),,, )

