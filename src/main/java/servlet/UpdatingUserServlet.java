package servlet;

import exception.DBException;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdatingUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            UserService userService = new UserService();

            String login = request.getParameter("login");
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            userService.updateUser(name, login, password);
            response.sendRedirect("/index.jsp");

            response.setStatus(HttpServletResponse.SC_OK);
        } catch (DBException e) {
            throw new IOException("ошибка при изменении пользователя");
        }
    }
}