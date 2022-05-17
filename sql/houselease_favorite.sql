create table favorite
(
    fid int auto_increment comment '唯一标识',
    uid int not null comment '收藏的用户id',
    rid int not null comment '收藏的房屋',
    constraint favorite_fid_uindex
        unique (fid),
    constraint favorite___fk_rid
        foreign key (rid) references house_rent (rid)
            on update cascade on delete cascade,
    constraint favorite___fk_uid
        foreign key (uid) references user (uid)
)
    comment '收藏房屋出租信息';

alter table favorite
    add primary key (fid);

INSERT INTO houselease.favorite (uid, rid) VALUES (1, 3);
INSERT INTO houselease.favorite (uid, rid) VALUES (1, 4);
INSERT INTO houselease.favorite (uid, rid) VALUES (1, 2);