create table app_user(
user_id bigint,
username text,
password text,
status boolean,
primary key (username,status)
);

create table user_role(
id bigint,
user_id bigint,
role_id bigint,
primary key (user_id,role_id)
);

create table app_role(
role_id bigint,
role_name varchar,
primary key (role_id)
);

create table employee(
user_id bigint,
name varchar,
group_id bigint,
age int,
address varchar,
reference map<varchar,varchar>,
primary key (user_id,group_id)
);
insert into employee (user_id,name,group_id,age,address,reference)
values (1,'Helen',1,22,'Ha Noi',{'parent_id':'null','child_id':'1'});

select * from employee;


create table group(
group_id bigint,
name varchar,
primary key (group_id)
);

create table project(
project_id bigint,
name varchar,
desciption text,
group_id bigint,
status boolean,
create_at date,
end_at date,
primary key (project_id,group_id)
);

create table allocated(
project_id bigint,
user_id bigint,
month int,
status boolean,
completed float,
expect float,
create_at date,
end_at date,
primary key (project_id,month)
);
