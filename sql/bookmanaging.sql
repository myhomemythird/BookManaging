
create table `book` (
       `id` varchar(10) NOT NULL,
       `title` varchar(100) NOT NULL,
       `auth` varchar(100),
       `description` varchar(255)
);

insert into `book`(id, title, auth, description)
values
('TP10235', 'Spring in Action', 'John', 'Spring in action. It is a great book'),
('TP10245', 'JavaScript', 'Richard', 'A book about JavaScript'),
('TP10255', 'HTML 5', 'Beket', 'HTML 5, from 0 to expert');
----------------------------------------------

create table `user` (
       `id` varchar(10) NOT NULL,
       `account` varchar(50) NOT NULL,
       `password` varchar(50) NOT NULL,
       `role_id` varchar(10)
);

insert into `user`(id, account, password, role_id)
values
('u00001', 'test@163.com', '123456789@qw', 'r01552'),
('u00002', '15987955412', 'abcd@123456', 'r01552'),
('u00003', 'test@test.net', 'tgb!@#ujm', 'r01553');
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

alter table book add publish_date datetime;
alter table book add adding_date datetime;

update book
set publish_date = '2018-10-01';

update book
set adding_date = '2018-10-01';

