package cool.wangshuo.ml;


import java.io.IOException;

/**
 * @author wangsh
 * @date 2022/6/10 18:02
 */

public interface CRUD {

    final String resource = "mybatis-config.xml";


    /**
     * 初始化 test 环境
     * @throws IOException
     */
    public void init()  throws IOException;

    public void selectOne1()  throws IOException;

    public void selectOne2()  throws IOException;

    public void selectList1()  throws IOException;

    public void selectList2() throws IOException;

    public void delete1() throws IOException;

    public void delete2()  throws IOException;

    public void delete3() throws IOException;


}
