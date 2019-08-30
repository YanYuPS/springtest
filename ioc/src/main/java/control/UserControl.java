package control;

import com.alibaba.druid.pool.DruidDataSource;
import dao.UserDao;
import domain.User;
import org.apache.commons.fileupload.FileItemFactory;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartFile;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

@Controller  //放到spring容器
//@RequestMapping("/user")
public class UserControl {

    //参数：必须有、参数不可为0 等一些简单表达式
//    @RequestMapping(value="/login",method = RequestMethod.GET,params = {"name","pass!0"})
    @RequestMapping(value="/login")
    public String login(){
        System.out.println("login");
        return "success";
    }

    @ResponseBody
    @RequestMapping("/user")
    public User getUser(){
        return new User();
    }

    @ResponseBody
    @RequestMapping("/file")
    public void file(String name, MultipartFile uploadFile) throws IOException {

        String fileName=uploadFile.getOriginalFilename();

        System.out.println(name);
        System.out.println(fileName);

        uploadFile.transferTo(new File("/Users/rainbow/Desktop/"+name+"_"+fileName));

    }

    @Test
    public void getDao() throws SQLException {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");

//        UserDao userDao = (UserDao) app.getBean("userDao");
//        userDao.out();

//        UserService userService = (UserService) app.getBean("userService");
//        userService.out();

//        DataSource dataSource = app.getBean(DataSource.class);
//        Connection connection = dataSource.getConnection();
//        System.out.println(connection);
//        connection.close();

//        WebApplicationContextUtils.getWebApplicationContext(this.get)
        JdbcTemplate jdbcTemplate = app.getBean(JdbcTemplate.class);
        String sql="select * from user";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql);
        System.out.println(map);

    }


}
