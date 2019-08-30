package control;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/my")
public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        JdbcTemplate jdbcTemplate = app.getBean(JdbcTemplate.class);
        String sql="select * from user";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql);
        System.out.println(map);
        System.out.println("aaa");
    }
}
