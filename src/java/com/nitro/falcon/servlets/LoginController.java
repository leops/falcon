package com.nitro.falcon.servlets;

import com.nitro.falcon.daos.UserDAO;
import com.nitro.falcon.models.User;
import com.nitro.falcon.services.UserService;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * LoginController
 * @author leops
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    @EJB
    private UserDAO userDAO;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/faces/login.xhtml").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String username = req.getParameter("username");
        final String password = req.getParameter("password");
        
        final User user = userDAO.findByName(username);
        if(user != null) {
            if(UserService.hashPassword(password, user.getSalt()).equals(user.getPassword())) {
                req.getSession().setAttribute("user", username);
                resp.sendRedirect(getServletContext().getContextPath());
                return;
            }
        }
        
        doGet(req, resp);
    }
}
