create table house_rent
(
    rid           int auto_increment comment '出租信息的唯一标识',
    hid           int         not null comment '出租的房屋id',
    custom_uid    int         null comment '租客id',
    rent_title    varchar(50) not null comment '出租标题',
    rent_content  text        null comment '出租的详细内容',
    month         int(2)      not null comment '出租月份',
    month_money   int(6)      not null comment '月价格',
    contact_name  varchar(10) not null comment '联系人',
    contact_phone varchar(11) not null comment '联系电话',
    house_status  int         null comment '当前出租状态:未出租、已出租',
    create_time   datetime    not null comment '发布日期',
    update_time   datetime    not null comment '最后更新日期',
    allow_hidden  int         not null comment '是否隐藏',
    allow_delete  int         not null comment '是否允许删除',
    constraint house_rent_rid_uindex
        unique (rid),
    constraint house_rent___fk_hid
        foreign key (hid) references house (hid)
            on update cascade on delete cascade
)
    comment '房屋出租信息';

alter table house_rent
    add primary key (rid);

INSERT INTO houselease.house_rent (hid, custom_uid, rent_title, rent_content, month, month_money, contact_name, contact_phone, house_status, create_time, update_time, allow_hidden, allow_delete) VALUES (2, 3, '合租-桃园小区-4居室-C卧', '急租，可随时看房，电话联系', 6, 7777, '小何', '18228867837', 0, '2022-05-04 10:00:18', '2022-05-04 10:00:19', 0, 0);
INSERT INTO houselease.house_rent (hid, custom_uid, rent_title, rent_content, month, month_money, contact_name, contact_phone, house_status, create_time, update_time, allow_hidden, allow_delete) VALUES (3, 8, '合租-龙腾虎跃-4居室-C卧', '急租，可随时看房，电话联系', 6, 8888, '小何', '18228867837', 1, '2022-05-04 10:00:19', '2022-05-04 10:00:20', 0, 1);
INSERT INTO houselease.house_rent (hid, custom_uid, rent_title, rent_content, month, month_money, contact_name, contact_phone, house_status, create_time, update_time, allow_hidden, allow_delete) VALUES (4, 5, '合租-温馨小区-4居室-C卧', '急租，可随时看房，电话联系', 3, 5555, '小何', '18228867837', 0, '2022-05-04 10:00:20', '2022-05-04 10:00:21', 0, 0);
INSERT INTO houselease.house_rent (hid, custom_uid, rent_title, rent_content, month, month_money, contact_name, contact_phone, house_status, create_time, update_time, allow_hidden, allow_delete) VALUES (6, 7, '合租-哈哈哈哈-4居室-C卧', '急租，可随时看房，电话联系', 0, 9999, '小何', '18228867837', 1, '2022-05-04 10:00:22', '2022-05-04 10:00:23', 0, 0);
INSERT INTO houselease.house_rent (hid, custom_uid, rent_title, rent_content, month, month_money, contact_name, contact_phone, house_status, create_time, update_time, allow_hidden, allow_delete) VALUES (6, 7, '合租-哈哈哈哈-4居室-C卧', '急租，可随时看房，电话联系', 0, 9999, '小何', '18228867837', 1, '2022-05-04 10:00:22', '2022-05-04 10:00:23', 0, 0);
INSERT INTO houselease.house_rent (hid, custom_uid, rent_title, rent_content, month, month_money, contact_name, contact_phone, house_status, create_time, update_time, allow_hidden, allow_delete) VALUES (6, 7, '合租-哈哈哈哈-4居室-C卧', '急租，可随时看房，电话联系', 0, 9999, '小何', '18228867837', 1, '2022-05-04 10:00:22', '2022-05-04 10:00:23', 0, 0);
INSERT INTO houselease.house_rent (hid, custom_uid, rent_title, rent_content, month, month_money, contact_name, contact_phone, house_status, create_time, update_time, allow_hidden, allow_delete) VALUES (6, 7, '合租-哈哈哈哈-4居室-C卧', '急租，可随时看房，电话联系', 0, 9999, '小何', '18228867837', 1, '2022-05-04 10:00:22', '2022-05-04 10:00:23', 0, 0);
INSERT INTO houselease.house_rent (hid, custom_uid, rent_title, rent_content, month, month_money, contact_name, contact_phone, house_status, create_time, update_time, allow_hidden, allow_delete) VALUES (6, 7, '合租-哈哈哈哈-4居室-C卧', '急租，可随时看房，电话联系', 0, 9999, '小何', '18228867837', 1, '2022-05-04 10:00:22', '2022-05-04 10:00:23', 0, 0);
INSERT INTO houselease.house_rent (hid, custom_uid, rent_title, rent_content, month, month_money, contact_name, contact_phone, house_status, create_time, update_time, allow_hidden, allow_delete) VALUES (6, 7, '合租-哈哈哈哈-4居室-C卧', '急租，可随时看房，电话联系', 0, 9999, '小何', '18228867837', 1, '2022-05-04 10:00:22', '2022-05-04 10:00:23', 0, 0);
INSERT INTO houselease.house_rent (hid, custom_uid, rent_title, rent_content, month, month_money, contact_name, contact_phone, house_status, create_time, update_time, allow_hidden, allow_delete) VALUES (6, 7, '合租-哈哈哈哈-4居室-C卧', '急租，可随时看房，电话联系', 0, 9999, '小何', '18228867837', 1, '2022-05-04 10:00:22', '2022-05-04 10:00:23', 0, 0);
INSERT INTO houselease.house_rent (hid, custom_uid, rent_title, rent_content, month, month_money, contact_name, contact_phone, house_status, create_time, update_time, allow_hidden, allow_delete) VALUES (1, 0, '测试的', '测试的', 12, 1111, '测试的', '452452452', 1, '2022-05-17 10:56:32', '2022-05-17 10:56:32', 1, 1);
INSERT INTO houselease.house_rent (hid, custom_uid, rent_title, rent_content, month, month_money, contact_name, contact_phone, house_status, create_time, update_time, allow_hidden, allow_delete) VALUES (2, 0, '再次测试', '再次测试再次测试', 66, 636543, '22222', '111111', 1, '2022-05-17 10:59:09', '2022-05-17 10:59:09', 1, 1);