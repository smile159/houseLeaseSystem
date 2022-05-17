package com.xinxin.mapper;

import com.xinxin.bean.dto.ViewHouseRent;
import com.xinxin.bean.vo.FavoriteHouseRent;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author smile
 * @ClassName FavoriteMapper.java
 * @Description TODO
 * @createTime 2022年05月05日 17:23:00
 */
@Mapper
public interface FavoriteMapper {

    // 用户收藏出租信息
    // 根据uid和rid生成fid，返回fid
    @Insert("insert into favorite(fid,uid,rid) values (null,#{uid},#{rid})")
    //@SelectKey(statement = {"SELECT LAST_INSERT_ID()"}, keyProperty = "fid", before = false, resultType = FavoriteHouseRent.class)
    @Options(useGeneratedKeys = true, keyProperty = "fid", keyColumn = "fid")
    public int createUserFavorite(FavoriteHouseRent favoriteHouseRent);

    //删除fid
    @Delete("delete from favorite where fid=#{fid};")
    public int deleteUserFavorite(@Param("fid") int fid);

    // 查询用户的所有收藏
    public List<ViewHouseRent> getAllHouseRent(@Param("uid") int uid);

    /*
    * 查询是否存在收藏
    * */
    @Select("select * from favorite where uid=#{uid} and rid=#{rid}")
    public Integer queryIsAlreadyExist(FavoriteHouseRent favoriteHouseRent);

}
