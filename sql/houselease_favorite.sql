create table favorite
(
    fid int auto_increment comment '唯一标识',
    uid int not null comment '收藏的用户id',
    rid int not null comment '收藏的房屋',
    constraint favorite_fid_uindex
        unique (fid),
    constraint favorite___fk_rid
        foreign key (rid) references house_rent (rid),
    constraint favorite___fk_uid
        foreign key (uid) references user (uid)
)
    comment '收藏房屋出租信息';

alter table favorite
    add primary key (fid);

INSERT INTO houselease.favorite (fid, uid, rid) VALUES (3348, 1, 2);
INSERT INTO houselease.favorite (fid, uid, rid) VALUES (3349, 1, 1);
INSERT INTO houselease.favorite (fid, uid, rid) VALUES (3350, 1, 3);
INSERT INTO houselease.favorite (fid, uid, rid) VALUES (3351, 1, 4);