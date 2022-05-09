create table house_tag
(
    h_tid int auto_increment comment '唯一标识',
    name  varchar(5) not null comment '标签名',
    value varchar(6) not null comment '具体信息',
    hid   int        not null comment '和房屋关联',
    constraint house_tag_h_tid_uindex
        unique (h_tid)
);

alter table house_tag
    add primary key (h_tid);

INSERT INTO houselease.house_tag (h_tid, name, value, hid) VALUES (1, '冰箱', '1', 1);
INSERT INTO houselease.house_tag (h_tid, name, value, hid) VALUES (2, '电视', '2', 1);
INSERT INTO houselease.house_tag (h_tid, name, value, hid) VALUES (3, '沙发', '4', 1);
INSERT INTO houselease.house_tag (h_tid, name, value, hid) VALUES (4, '卫生间', '5', 2);
INSERT INTO houselease.house_tag (h_tid, name, value, hid) VALUES (5, '卧室', '6', 2);
INSERT INTO houselease.house_tag (h_tid, name, value, hid) VALUES (6, '客厅', '7', 2);
INSERT INTO houselease.house_tag (h_tid, name, value, hid) VALUES (7, '宽带', '1', 3);
INSERT INTO houselease.house_tag (h_tid, name, value, hid) VALUES (8, '暖气', '4', 3);
INSERT INTO houselease.house_tag (h_tid, name, value, hid) VALUES (9, '空调', '8', 3);
INSERT INTO houselease.house_tag (h_tid, name, value, hid) VALUES (10, '电梯', '9', 4);
INSERT INTO houselease.house_tag (h_tid, name, value, hid) VALUES (11, '燃气灶', '5', 4);
INSERT INTO houselease.house_tag (h_tid, name, value, hid) VALUES (12, '阳台', '2', 4);
INSERT INTO houselease.house_tag (h_tid, name, value, hid) VALUES (13, '衣柜', '7', 5);
INSERT INTO houselease.house_tag (h_tid, name, value, hid) VALUES (14, '床', '1', 5);
INSERT INTO houselease.house_tag (h_tid, name, value, hid) VALUES (15, '洗衣机', '2', 5);
INSERT INTO houselease.house_tag (h_tid, name, value, hid) VALUES (16, '智能门锁', '3', 6);
INSERT INTO houselease.house_tag (h_tid, name, value, hid) VALUES (17, '油烟机', '1', 6);
INSERT INTO houselease.house_tag (h_tid, name, value, hid) VALUES (18, '热水器', '4', 6);