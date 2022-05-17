create table house
(
    hid          int auto_increment comment '房屋唯一标识',
    uid          int          not null comment '房东id',
    house_name   varchar(20)  not null comment '房屋名称、类似备注',
    type         varchar(20)  not null comment '房屋类型',
    city         varchar(6)   not null comment '所在城市',
    address      varchar(100) not null comment '详细地址',
    area         int          not null comment '房屋面积',
    floor        int          not null comment '房屋所在楼层',
    max_floor    int          not null comment '房屋最大层数',
    direction    varchar(11)  not null comment '朝向',
    glance_count int          not null,
    constraint house_tid_uindex
        unique (hid),
    constraint house_fk_user
        foreign key (uid) references user (uid)
)
    comment '我的房屋';

INSERT INTO houselease.house (uid, house_name, type, city, address, area, floor, max_floor, direction, glance_count) VALUES (1, '成都一号房', '3室2厅1卫', '成都', '四川省成都市温江区天府街道柳台大道88号', 66, 10, 40, '朝南', 15);
INSERT INTO houselease.house (uid, house_name, type, city, address, area, floor, max_floor, direction, glance_count) VALUES (1, '成都二号房', '3室2厅2卫', '成都', '四川省成都市温江区天府街道柳台大道88号', 666, 5, 30, '朝南', 19);
INSERT INTO houselease.house (uid, house_name, type, city, address, area, floor, max_floor, direction, glance_count) VALUES (1, '成都三号房', '3室2厅3卫', '成都', '四川省成都市温江区天府街道柳台大道88号', 40, 18, 30, '朝南', 3);
INSERT INTO houselease.house (uid, house_name, type, city, address, area, floor, max_floor, direction, glance_count) VALUES (2, '北京一号房', '4室2厅4卫', '北京', '北京市朝阳区温馨小区', 60, 15, 36, '朝北', 2);
INSERT INTO houselease.house (uid, house_name, type, city, address, area, floor, max_floor, direction, glance_count) VALUES (1, '北京二号房', '4室3厅4卫', '北京', '北京市朝阳区温馨小区', 80, 8, 10, '朝北', 7);
INSERT INTO houselease.house (uid, house_name, type, city, address, area, floor, max_floor, direction, glance_count) VALUES (2, '北京二号房', '小别墅', '北京', '北京市朝阳区温馨小区', 150, 1, 2, '朝南', 1);
INSERT INTO houselease.house (uid, house_name, type, city, address, area, floor, max_floor, direction, glance_count) VALUES (2, '北京二号房', '小别墅', '北京', '北京市朝阳区温馨小区', 150, 1, 2, '朝南', 1);
INSERT INTO houselease.house (uid, house_name, type, city, address, area, floor, max_floor, direction, glance_count) VALUES (2, '北京二号房', '小别墅', '北京', '北京市朝阳区温馨小区', 150, 1, 2, '朝南', 1);
INSERT INTO houselease.house (uid, house_name, type, city, address, area, floor, max_floor, direction, glance_count) VALUES (2, '北京二号房', '小别墅', '北京', '北京市朝阳区温馨小区', 150, 1, 2, '朝南', 1);
INSERT INTO houselease.house (uid, house_name, type, city, address, area, floor, max_floor, direction, glance_count) VALUES (2, '北京二号房', '小别墅', '北京', '北京市朝阳区温馨小区', 150, 1, 2, '朝南', 1);
INSERT INTO houselease.house (uid, house_name, type, city, address, area, floor, max_floor, direction, glance_count) VALUES (2, '北京二号房', '小别墅', '北京', '北京市朝阳区温馨小区', 150, 1, 2, '朝南', 1);
INSERT INTO houselease.house (uid, house_name, type, city, address, area, floor, max_floor, direction, glance_count) VALUES (2, '北京二号房', '小别墅', '北京', '北京市朝阳区温馨小区', 150, 1, 2, '朝南', 1);