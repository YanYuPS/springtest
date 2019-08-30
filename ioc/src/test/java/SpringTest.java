import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.SSMUserService;
import service.UserService;

import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
//@ContextConfiguration(classes={SpringConfiguration.class})
public class SpringTest {

    @Autowired
    private UserService userService;

//    @Autowired
//    private SSMUserService ssmUserService;

    private JdbcTemplate jdbcTemplate;

    @Test
    public void test01(){
        userService.out();

        String sql="select * from user";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql);
        System.out.println(map);
    }

    @Test
    public void test02(){
//        ssmUserService.findAll();
    }
}
