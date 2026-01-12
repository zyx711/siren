package edu.hnzj.servlet;

import edu.hnzj.pojo.User;
import edu.hnzj.service.UserService;
import edu.hnzj.service.impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    //doPost () 方法，处理HTTP POST请求，提交、修改数据
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(username, password);
        if (userService.isLogin(user) > 0) {
            HttpSession session = req.getSession();
            session.setAttribute("user", "user");
            resp.sendRedirect("userManage");
        } else {
            resp.sendRedirect("login.html");
        }

    }
}

