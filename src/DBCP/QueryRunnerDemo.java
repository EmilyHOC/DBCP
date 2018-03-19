package DBCP;

/*
* 测试写好的工具类
* 提供的是一个DataSource接口的数据源
* QueryRunner类的构造方法,接收DataSource接口的实现类
* 后面调用方法update,query无需传递他们的Connection连接对象
* */

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import java.sql.SQLException;
import java.util.List;


public class QueryRunnerDemo {
    public static void main(String[] args) {
        //insert();
        search();
    }

    //定义两个方法,实现数据表的添加,数据表的查询
        //QueryRunner类对象,写在类的成员对象
        private static QueryRunner qr=new QueryRunner(DBUtils.getDataSource());
//数据表插入
    public static void insert(){
        String sql="insert into sort values (?,?,?,?)";
        Object [] params={11,"鞋子",200,"新款"};
        try {
            int row=qr.update(sql,params);
            System.out.println(row);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("数据库添加失败");
        }
    }
    //数据表查询
    public static void search(){
        String sql="select *from sort";
        try {
            List<Object[]> list=qr.query(sql,new ArrayListHandler());
            for (Object[] obj:list){
                for (Object objs:obj){
                    System.out.println(objs+"\t");
                }
                System.out.println();

            }
        } catch (SQLException e) {
            throw new RuntimeException("数据库查询失败");

        }
    }

}
