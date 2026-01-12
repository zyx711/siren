package edu.hnzj.servlet;

import edu.hnzj.pojo.User;
import edu.hnzj.service.UserService;
import edu.hnzj.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/login")
public class EditUserServlet extends HttpServlet {
    private UserService userService =new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id =Integer.parseInt(req.getParameter("id"));
        String username=req.getParameter("username");
        String password=req.getParameter("password");

        int result= userService.updateUser(new User(id,username,password));
        if (result==1){
            resp.sendRedirect("userManage");
        }
    }
}
