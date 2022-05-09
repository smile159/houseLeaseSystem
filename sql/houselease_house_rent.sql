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
    house_status  int         null comment '当前出租状态:未出租、已出租、隐藏',
    create_time   datetime    not null comment '发布日期',
    update_time   datetime    not null comment '最后更新日期',
    constraint house_rent_rid_uindex
        unique (rid),
    constraint house_rent___fk_hid
        foreign key (hid) references house (hid)
)
    comment '房屋出租信息';

alter table house_rent
    add primary key (rid);

INSERT INTO houselease.house_rent (rid, hid, custom_uid, rent_title, rent_content, month, month_money, contact_name, contact_phone, house_status, create_time, update_time) VALUES (1, 1, 2, '合租-世界花园-4居室-C卧-666', '急租，可随时看房，电话联系，smile修改', 24, 1111, 'smile', '11011011011', 1, '2022-05-04 10:00:17', '2022-05-07 08:27:52');
INSERT INTO houselease.house_rent (rid, hid, custom_uid, rent_title, rent_content, month, month_money, contact_name, contact_phone, house_status, create_time, update_time) VALUES (2, 2, 3, '合租-桃园小区-4居室-C卧', '急租，可随时看房，电话联系', 6, 7777, '小何', '18228867837', 0, '2022-05-04 10:00:18', '2022-05-04 10:00:19');
INSERT INTO houselease.house_rent (rid, hid, custom_uid, rent_title, rent_content, month, month_money, contact_name, contact_phone, house_status, create_time, update_time) VALUES (3, 3, 8, '合租-龙腾虎跃-4居室-C卧', '急租，可随时看房，电话联系', 6, 8888, '小何', '18228867837', 1, '2022-05-04 10:00:19', '2022-05-04 10:00:20');
INSERT INTO houselease.house_rent (rid, hid, custom_uid, rent_title, rent_content, month, month_money, contact_name, contact_phone, house_status, create_time, update_time) VALUES (4, 4, 5, '合租-温馨小区-4居室-C卧', '急租，可随时看房，电话联系', 3, 5555, '小何', '18228867837', 0, '2022-05-04 10:00:20', '2022-05-04 10:00:21');
INSERT INTO houselease.house_rent (rid, hid, custom_uid, rent_title, rent_content, month, month_money, contact_name, contact_phone, house_status, create_time, update_time) VALUES (5, 5, 6, '合租-上城丽景-4居室-C卧', '急租，可随时看房，电话联系', 6, 4444, '小何', '18228867837', 1, '2022-05-04 10:00:21', '2022-05-04 10:00:22');
INSERT INTO houselease.house_rent (rid, hid, custom_uid, rent_title, rent_content, month, month_money, contact_name, contact_phone, house_status, create_time, update_time) VALUES (6, 6, 7, '合租-哈哈哈哈-4居室-C卧', '急租，可随时看房，电话联系', 0, 9999, '小何', '18228867837', 1, '2022-05-04 10:00:22', '2022-05-04 10:00:23');