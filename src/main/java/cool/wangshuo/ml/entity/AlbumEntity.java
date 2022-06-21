package cool.wangshuo.ml.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * 数据库实体类
 * @author wangsh
 * @date 2022/6/10 15:12
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumEntity {

    private static final long serialVersionUID = 677509646215560473L;
    /**
     * 相册编号 主键
     */
    private Integer albumId;
    /**
     * 用户编号
     */
    private Integer userId;
    /**
     * 相册名称
     */
    private String albumName;
    /**
     * 相册状态、1有效，0禁用 管理员设定
     */
    private Integer albumStatue;
    /**
     * 相册权限、1可访问，0不可访问 用户设定
     */
    private Integer albumRight;
    /**
     * 相册创建时间
     */
    private Timestamp albumTime;
    /**
     * 相册封面
     */
    private String albumFace;

}
