package DBCP;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

//dbcp实现BasicDataSource接口
public class DataSourceDemo {

    public static void main(String[] args) {
        BasicDataSource source=new BasicDataSource();
        //BaseDataSource方法,设置必要参数
        //设置驱动程序
        source.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        //设置数据库连接的URL
        source.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:oracle");
        //设置用户名和密码
        source.setUsername("emily");
        source.setPassword("abc");
        System.out.println(source);

        try{
            //调用对象方法获取数据库连接
            Connection con=source.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("数据库连接失败");

        }
    }

}
