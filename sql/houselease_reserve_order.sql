create table reserve_order
(
    r_oid        int auto_increment comment '预订id',
    rid          int         not null comment '出租信息的id',
    start_time   date        not null comment '入住日期',
    end_time     date        not null comment '退租日期',
    create_time  datetime    not null comment '预订的创建时间',
    reserve_name varchar(10) not null comment '预订人姓名、也就是点击预订的用户名',
    constraint reserve_order_r_oid_uindex
        unique (r_oid)
);

alter table reserve_order
    add primary key (r_oid);

INSERT INTO houselease.reserve_order (rid, start_time, end_time, create_time, reserve_name) VALUES (3, '2022-05-09', '2022-05-19', '2022-05-09 02:14:27', 'smile');
INSERT INTO houselease.reserve_order (rid, start_time, end_time, create_time, reserve_name) VALUES (3, '2022-05-09', '2022-05-07', '2022-05-09 02:15:08', 'smile');
INSERT INTO houselease.reserve_order (rid, start_time, end_time, create_time, reserve_name) VALUES (3, '2022-05-09', '2022-05-20', '2022-05-09 02:15:25', 'smile');
INSERT INTO houselease.reserve_order (rid, start_time, end_time, create_time, reserve_name) VALUES (3, '2022-05-09', '2022-05-01', '2022-05-09 02:15:33', 'smile');
INSERT INTO houselease.reserve_order (rid, start_time, end_time, create_time, reserve_name) VALUES (14, '2022-05-17', '2022-05-03', '2022-05-17 10:59:24', 'smile');