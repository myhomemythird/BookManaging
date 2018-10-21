
create table `book` (
       `id` varchar(10) NOT NULL,
       `title` varchar(100) NOT NULL,
       `auth` varchar(100),
       `description` varchar(255),
       `publish_date` datetime,
       `adding_date` datetime
);

insert into `book`(id, title, auth, description)
values
('TP10235', 'Spring in Action', 'John', 'Spring in action. It is a great book'),
('TP10245', 'JavaScript', 'Richard', 'A book about JavaScript'),
('TP10255', 'HTML 5', 'Beket', 'HTML 5, from 0 to expert');

alter table book add publish_date datetime;
alter table book add adding_date datetime;

alter table book modify id varchar(20) NOT NULL;

update book
set publish_date = '2018-10-01';

update book
set adding_date = '2018-10-01';
----------------------------------------------

create table `user` (
       `id` varchar(10) NOT NULL,
       `account` varchar(50) NOT NULL,
       `name` varchar(256) NOT NULL,
       `address` varchar(1024),
       `email` varchar(256),
       `password` varchar(50) NOT NULL,
       `role_id` varchar(10),
       `register_date` datetime NOT NULL,
);

insert into `user`(id, account, password, role_id)
values
('u00001', 'test@163.com', '123456789@qw', 'r01552'),
('u00002', '15987955412', 'abcd@123456', 'r01552'),
('u00003', 'test@test.net', 'tgb!@#ujm', 'r01553');

alter table user add name varchar(256) NOT NULL;
alter table user add address varchar(1024);
alter table user add email varchar(256);
alter table user add register_date datetime;

alter table user modify id varchar(20) NOT NULL;

update user
set name = 'Alex'
where id = 'u00001';

update user
set name = 'Richard'
where id = 'u00002';

update user
set name = 'John'
where id = 'u00003';

update user
set register_date = '2018-10-01';
----------------------------------------------

create table `role` (
       `id` varchar(10) NOT NULL,
       `name` varchar(50) NOT NULL,
       `description` varchar(255),
       `resource` varchar(1024)
);

insert into `role`(id, name, description, resource)
values
('r01552', 'Admin', 'Administation account', ''),
('r01553', 'user', 'User role', '');
----------------------------------------------

