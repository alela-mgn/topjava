package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.util.MealsUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;


public class MealServlet extends HttpServlet {
    public static final Logger log = getLogger(MealServlet.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.info("get all meal");
        request.setAttribute("meals", MealsUtil.getAllList(MealsUtil.meals, 2000));
        request.getRequestDispatcher("meals.jsp").forward(request, response);
    }
}
