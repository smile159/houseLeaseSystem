create table user_message
(
    mid         int auto_increment comment '唯一标识',
    uid         int          not null comment '留言人',
    rid         int          not null comment '留言时的出租信息',
    message     varchar(100) not null,
    create_time datetime     not null comment '留言时间',
    `read`      int          not null comment '0为未读，1为已读',
    constraint user_message_mid_uindex
        unique (mid)
)
    comment '用户留言';

alter table user_message
    add primary key (mid);

INSERT INTO houselease.user_message (uid, rid, message, create_time, `read`) VALUES (1, 5, '牛鼻啊，测试测试', '2022-05-09 10:36:27', 1);
INSERT INTO houselease.user_message (uid, rid, message, create_time, `read`) VALUES (1, 5, '测试提示音', '2022-05-09 10:53:27', 1);
INSERT INTO houselease.user_message (uid, rid, message, create_time, `read`) VALUES (1, 5, '666666', '2022-05-09 10:54:41', 1);
INSERT INTO houselease.user_message (uid, rid, message, create_time, `read`) VALUES (1, 5, '976786786', '2022-05-09 10:56:46', 1);
INSERT INTO houselease.user_message (uid, rid, message, create_time, `read`) VALUES (1, 5, '测试提示', '2022-05-09 10:58:02', 1);
INSERT INTO houselease.user_message (uid, rid, message, create_time, `read`) VALUES (1, 5, '测试留言提示音', '2022-05-09 11:09:34', 0);
INSERT INTO houselease.user_message (uid, rid, message, create_time, `read`) VALUES (1, 5, '7832783453453', '2022-05-09 11:10:14', 0);
INSERT INTO houselease.user_message (uid, rid, message, create_time, `read`) VALUES (1, 5, '4555555', '2022-05-09 11:10:33', 0);
INSERT INTO houselease.user_message (uid, rid, message, create_time, `read`) VALUES (1, 3, '66666666', '2022-05-09 02:05:08', 0);
INSERT INTO houselease.user_message (uid, rid, message, create_time, `read`) VALUES (1, 3, '11111111', '2022-05-09 02:05:16', 1);
INSERT INTO houselease.user_message (uid, rid, message, create_time, `read`) VALUES (1, 3, '9999999999', '2022-05-09 02:16:01', 0);
INSERT INTO houselease.user_message (uid, rid, message, create_time, `read`) VALUES (1, 14, '6666666', '2022-05-17 11:01:27', 0);