package cool.wangshuo.ml.mapper;

import com.alibaba.fastjson.JSONObject;
import cool.wangshuo.ml.entity.AlbumEntity;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;


/**
 * @author wangsh
 * @date 2022/6/10 15:12
 */

public interface AlbumMapper1 {

    int insertOne(AlbumEntity album);

    int insertBatch(@Param("entities") List<AlbumEntity> entities);

    AlbumEntity selectAlbum1(String albumId);

    HashMap selectAlbum2(String albumId);

    List<AlbumEntity> selectAll1();

    List<JSONObject>  selectAll2();

}
