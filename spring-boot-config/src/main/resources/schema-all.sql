use jdbc;

create table teacher(
    id int primary key auto_increment comment 'id',
    name varchar(100) comment '名字',
    age int comment '年龄',
    hobby varchar(100) comment '爱好'
)character set utf8;