create table contract_order
(
    oid          int auto_increment comment '唯一标识',
    custom_id    int  not null comment '用户id',
    house_userId int  not null comment '房东id',
    house_id     int  not null comment '房屋id',
    create_time  date not null comment '创建时间/开始时间',
    end_time     date not null comment '结束时间',
    constraint contract_order_oid_uindex
        unique (oid)
)
    comment '合同表';

alter table contract_order
    add primary key (oid);

