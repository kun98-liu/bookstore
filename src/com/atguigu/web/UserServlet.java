package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author LIU JIANKUN
 * @create 2021-09-10 22:26
 */
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");

        User user = WebUtils.copyParaToBean(req.getParameterMap(), new User());

        if(userService.login(user) == null){
            req.setAttribute("msg", "输入的用户名或密码错误");
            req.setAttribute("username", user.getUsername());
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }else {
            User loginUser = userService.login(user);
            //保存用户登录之后的信息到Session
            req.getSession().setAttribute("user",loginUser);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);;

        }
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
       req.getSession().invalidate();



        //1.获取请求参数
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        String email = req.getParameter("email");
//        String code = req.getParameter("code");

        User user = WebUtils.copyParaToBean(req.getParameterMap(), new User());

        //2.验证验证码
        if(token != null && token.equalsIgnoreCase(req.getParameter("code"))){
            //验证成功
            if(userService.existsUsername(user.getUsername())){

                req.setAttribute("msg", "用户名已存在");
                req.setAttribute("username", user.getUsername());
                req.setAttribute("email", user.getEmail());
                //返回注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            }else{
                //调用service层的regist功能
                userService.registUser(user);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);

            }

        }else{
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username", user.getUsername());
            req.setAttribute("email", user.getEmail());
            //验证码错误，返回注册页面
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }


}
