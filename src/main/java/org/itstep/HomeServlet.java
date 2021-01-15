package org.itstep;

import org.itstep.sql.Database;
import org.itstep.sql.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Database database = Database.getInstance();
        List<Post> posts = database.getPosts();
        req.setAttribute("posts", posts);
        req.getRequestDispatcher("WEB-INF/view/home.jsp").forward(req, resp);
    }
}
