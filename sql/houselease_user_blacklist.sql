create table user_blacklist
(
    u_bid         int auto_increment comment '唯一id',
    operation_uid int          not null comment '操作用户',
    ban_id        int          not null comment '被封禁的用户',
    measure       int          not null comment '封禁措施：4000封号（不允许登录）、4001禁言',
    reason        varchar(100) not null comment '禁用原因',
    create_time   datetime     not null comment '封禁操作时间',
    start_time    datetime     not null comment '封禁开始时间',
    end_time      datetime     not null comment '封禁结束时间',
    status        int          not null comment '是否生效，0无效，1生效',
    constraint user_blacklist_u_bid_uindex
        unique (u_bid)
)
    comment '用户黑名单';

alter table user_blacklist
    add primary key (u_bid);

INSERT INTO houselease.user_blacklist (operation_uid, ban_id, measure, reason, create_time, start_time, end_time, status) VALUES (1, 2, 4000, '测试封号功能', '2022-05-11 16:34:33', '2022-05-11 16:34:28', '2022-05-30 00:00:00', 0);
INSERT INTO houselease.user_blacklist (operation_uid, ban_id, measure, reason, create_time, start_time, end_time, status) VALUES (1, 5, 4001, '测试禁言功能', '2022-05-11 21:09:22', '2022-05-11 21:09:19', '2022-05-31 00:00:00', 0);
INSERT INTO houselease.user_blacklist (operation_uid, ban_id, measure, reason, create_time, start_time, end_time, status) VALUES (1, 7, 4000, '633666', '2022-05-11 21:09:35', '2022-05-16 00:00:00', '2022-05-17 00:00:00', 0);