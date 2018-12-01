package com.itheima.test;


import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    public static void main(String[] args) throws IOException {
        //1读取配置文件
        InputStream in = Resources.getResourceAsStream ("sqlMapConfig.xml");
        //2.创建sqlsessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder ();
        SqlSessionFactory factory = builder.build ( in );
        //3.使用工厂类sqlsession对象
        SqlSession session = factory.openSession ();
        //4.使用sqlsession创建Dao接口的代理对象
        IUserDao mapper = session.getMapper (IUserDao.class);
        //5.使用代理对象执行方法
        List<User>users = mapper.findAll ();
        for (User user : users) {
            System.out.println (user);
        }
        //6.释放资源
        session.close ();
        in.close ();
    }
}
