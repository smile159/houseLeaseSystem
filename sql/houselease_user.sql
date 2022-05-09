create table user
(
    uid       int auto_increment comment '用户唯一标识',
    user_name varchar(12) not null comment '用户名',
    password  varchar(18) not null comment '用户密码',
    identity  int         not null comment '用户身份',
    status    int         not null comment '账号状态',
    token     text        null comment '账号token',
    constraint user_uid_uindex
        unique (uid)
);

alter table user
    add primary key (uid);

INSERT INTO houselease.user (uid, user_name, password, identity, status, token) VALUES (1, 'smile', '123456', 1, 1, null);
INSERT INTO houselease.user (uid, user_name, password, identity, status, token) VALUES (2, '李四', '6666', 2, 1, null);
INSERT INTO houselease.user (uid, user_name, password, identity, status, token) VALUES (3, '王五', '77777', 3, 1, null);
INSERT INTO houselease.user (uid, user_name, password, identity, status, token) VALUES (5, '测试账号注册', '666666', 3, 1, null);
INSERT INTO houselease.user (uid, user_name, password, identity, status, token) VALUES (6, '测试哈哈哈哈', '999999', 3, 1, null);
INSERT INTO houselease.user (uid, user_name, password, identity, status, token) VALUES (7, '再次测试', '666666', 3, 1, null);
INSERT INTO houselease.user (uid, user_name, password, identity, status, token) VALUES (8, '哈哈哈哈哈哈哈', '888888', 3, 1, null);
INSERT INTO houselease.user (uid, user_name, password, identity, status, token) VALUES (9, '8888888', '88888888', 3, 1, null);
INSERT INTO houselease.user (uid, user_name, password, identity, status, token) VALUES (10, '7777777', '777777', 3, 1, null);
INSERT INTO houselease.user (uid, user_name, password, identity, status, token) VALUES (11, '111', '111111', 3, 1, null);