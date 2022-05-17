create table user
(
    uid          int auto_increment comment '用户唯一标识',
    user_name    varchar(12) not null comment '用户名',
    password     varchar(18) not null comment '用户密码',
    identity     int         not null comment '用户身份',
    status       int         not null comment '账号状态',
    glance_count int         not null comment '浏览统计，此处指该用户的房屋租赁浏览',
    constraint user_uid_uindex
        unique (uid)
);

alter table user
    add primary key (uid);

INSERT INTO houselease.user (user_name, password, identity, status, glance_count) VALUES ('smile', '123456', 1, 1, 0);
INSERT INTO houselease.user (user_name, password, identity, status, glance_count) VALUES ('测试编辑66', '666666', 2, 1, 0);
INSERT INTO houselease.user (user_name, password, identity, status, glance_count) VALUES ('王五', '77777', 3, 1, 0);
INSERT INTO houselease.user (user_name, password, identity, status, glance_count) VALUES ('测试账号注册', '666666', 3, 0, 0);
INSERT INTO houselease.user (user_name, password, identity, status, glance_count) VALUES ('再次测试', '666666', 3, 1, 0);
INSERT INTO houselease.user (user_name, password, identity, status, glance_count) VALUES ('哈哈哈哈哈哈哈', '888888', 3, 1, 0);
INSERT INTO houselease.user (user_name, password, identity, status, glance_count) VALUES ('8888888', '88888888', 3, 1, 0);
INSERT INTO houselease.user (user_name, password, identity, status, glance_count) VALUES ('7777777', '777777', 3, 1, 0);