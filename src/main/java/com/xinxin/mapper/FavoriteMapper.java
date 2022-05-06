package com.xinxin.mapper;

import com.xinxin.bean.vo.FavoriteHouseRent;
import org.apache.ibatis.annotations.*;

/**
 * @author smile
 * @ClassName FavoriteMapper.java
 * @Description TODO
 * @createTime 2022年05月05日 17:23:00
 */
@Mapper
public interface FavoriteMapper {

    // 根据uid和rid生成fid，返回fid
    @Insert("insert into favorite(fid,uid,rid) values (null,#{uid},#{rid})")
    //@SelectKey(statement = {"SELECT LAST_INSERT_ID()"}, keyProperty = "fid", before = false, resultType = FavoriteHouseRent.class)
    @Options(useGeneratedKeys = true, keyProperty = "fid", keyColumn = "fid")
    public int createUserFavorite(FavoriteHouseRent favoriteHouseRent);


    // 用户收藏出租信息
    @Update("update house_rent set fid=#{fid} where rid=#{rid}")
    public int favoriteHouseRent(@Param("rid") int rid,@Param("fid") int fid);
}
