package cool.wangshuo.ml;

import com.alibaba.fastjson.JSONObject;
import cool.wangshuo.ml.entity.AlbumEntity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;


/**
 * MyBatis 支持两种 SQL 语句和 接口的映射方法 <br> <br>
 * 1. 通过 xml 的方式。 详细：{@link CRUDCURDTest1} <br>
 * 2. 通过 dao 层接口上的方法。 详细：{@link CRUDCRUDTest2} <br> <br>
 * <hr>
 * 这里先来介绍第一种方式 通过 xml 的形式来完成  SQL语句和 接口的映射 <br> <br>
 *
 * 环境配置：创建数据库和其中的数据表
 * <pre>
 *  CREATE TABLE `album_db_album` (
 *     `albumId` int NOT NULL COMMENT '相册编号 主键',
 *     `userId` int DEFAULT NULL COMMENT '所属用户编号 外键',
 *     `albumName` varchar(100) DEFAULT NULL COMMENT '相册名称',
 *     `albumStatue` int DEFAULT NULL COMMENT '相册状态、1有效，0禁用',
 *     `albumRight` int DEFAULT NULL COMMENT '相册权限、1可访问，0不可访问',
 *     `albumTime` datetime DEFAULT NULL COMMENT '相册创建时间',
 *     `albumFace` varchar(100) DEFAULT NULL COMMENT '相册封面',
 *     PRIMARY KEY (`albumId`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='相册信息表';
 * </pre>
 * <hr>
 * 目录大纲如下：<br>
 * <ul>
 *     <li>插入数据
 *          <ul>
 *              <li>插入数据1</li>
 *              <li>批量插入数据</li>
 *          </ul>
 *     </li>
 *     <li>删除数据
 *          <ul>
 *              <li>删除数据1</li>
 *              <li>删除数据2</li>
 *              <li>删除数据3</li>
 *          </ul>
 *     </li>
 *     <li>修改数据</li>
 *     <li>查询数据
 *          <ul>
 *              <li>查询数据(返回 JSON 类型)</li>
 *              <li>查询数据(返回 Map 类型)</li>
 *              <li>连表查询数据</li>
 *              <li>分组查询查询数据</li>
 *              <li></li>
 *          </ul>
 *     </li>
 * </ul>
 *
 *
 * @author wangsh
 * @date 2022/6/10 16:10
 */


public class CRUDCURDTest1 implements CRUD {

    final String resource = "mybatis-config1.xml";


    private SqlSessionFactory sqlSessionFactory;
    private SqlSession session;

    /**
     * 这里使用了 @Before 注解，是用作资源的申请, 被 @Before 注解修饰的的方法会在测试方法之前自动执行 <br>
     * 这里定义了一个 init方法，去初始化这个创建对象的过程 <br>
     * @throws IOException
     */
    @Before
    @Override
    public void init() throws IOException {
        // 加载配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建出 SqlSessionFactory 实例。
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取 session
        session = sqlSessionFactory.openSession();
    }

    /**
     * 查询单条记录信息并打印输出 (返回一个自定义的 Bean)
     * @throws IOException
     */
    @Test
    @Override
    public void selectOne1() throws IOException {

        AlbumEntity album1 = (AlbumEntity) session.selectOne("cool.wangshuo.ml.mapper.AlbumMapper1.selectAlbum1", "1");
        System.out.println(album1);
    }

    /**
     * 查询多条信息并打印输出 (返回一个 Map 实例) <br>
     * 只需修改在 xml 中的 resultType
     * @throws IOException
     */
    @Test
    @Override
    public void selectOne2() throws IOException {

        HashMap album1 = (HashMap) session.selectOne("cool.wangshuo.ml.mapper.AlbumMapper1.selectAlbum2", "1");
        System.out.println(album1);
    }

    /**
     * 查询多条数据 返回一个 List 的实例 （元素是一个自定义的 Bean）
     * @throws IOException
     */
    @Test
    @Override
    public void selectList1() throws IOException {
        // 查询所有的相册信息
        List<AlbumEntity> albumList = session.selectList("cool.wangshuo.ml.mapper.AlbumMapper1.selectAll1");
        System.out.println(albumList.size());
    }

    /**
     * 查询多条数据 返回一个 List 的实例 （元素是一个 JSON 对象） 多用于复杂查询的的时候，如连表查询
     * @throws IOException
     */
    @Test
    @Override
    public void selectList2() throws IOException {

        // 查询所有的相册信息
        List<JSONObject> albumList = session.selectList("cool.wangshuo.ml.mapper.AlbumMapper1.selectAll2");
        System.out.println(albumList);
    }

    /**
     * 删除数据 删除所有数据
     */
    @Test
    @Override
    public void delete1(){

//        session.delete("");

    }

    /**
     * 删除数据 指定单个 条件删除 or
     */
    @Test
    @Override
    public void delete2(){

//        session.delete("");

    }

    /**
     * 删除数据 And
     */
    @Test
    @Override
    public void delete3(){

//        session.delete("");

    }

    @After
    public void close(){
        session.close();;
    }

}
