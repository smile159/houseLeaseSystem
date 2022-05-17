create table admin_user
(
    a_uid       int auto_increment comment '唯一标识',
    account     varchar(10)  not null comment '账号',
    password    varchar(100) not null comment '密码：md5加密',
    email       varchar(20)  null comment '邮箱',
    phone       varchar(11)  null comment '手机号码',
    identity    int          not null comment '身份：1开发者，2管理员',
    create_time datetime     not null comment '创建时间',
    active_time datetime     not null comment '上次活动时间',
    status      int          not null comment '账号状态：0封禁，1正常，2风险',
    constraint admin_user_a_uid_uindex
        unique (a_uid)
)
    comment '管理员';

alter table admin_user
    add primary key (a_uid);

INSERT INTO houselease.admin_user (account, password, email, phone, identity, create_time, active_time, status) VALUES ('smile', '123456', '1174139226@qq.com', '18833912185', 1, '2022-05-11 09:44:57', '2022-05-11 09:44:59', 1);