import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.UserMapper;
import domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.apache.ibatis.io.Resources.*;

//@RunWith()
public class MybatisTest {

    private SqlSession sqlSession ;
    @Before
    public void before() throws IOException {
        InputStream inputStream = getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();

    }

    @Test
    public void test(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);//动态代理

        PageHelper.startPage(1,3);

        List<User> users = userMapper.findAll();
        System.out.println(users);

        PageInfo<User> pageInfo = new PageInfo<>(users);
        int pageNum = pageInfo.getPageNum();
        System.out.println(pageNum);

    }
}
