package DBCP;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

/*使用DBCP实现数据库的连接池
连接池自定义
*
* */
public class DBUtils {
    //创建出BasicDataSource类对象
    private static BasicDataSource dataSource=new BasicDataSource();

    //静态代码块,对象那个BasicDataSource对象中的配置,自定义
    static {
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:oracle");
        dataSource.setUsername("emily");
        dataSource.setPassword("abc");
        dataSource.setInitialSize(10);
        dataSource.setMaxActive(8);
        dataSource.setMinIdle(1);
        dataSource.setMinIdle(5);
    }
   //定义静态方法,返回BasicDataSource类的对象
    public static DataSource getDataSource(){
        return dataSource;
    }
}
