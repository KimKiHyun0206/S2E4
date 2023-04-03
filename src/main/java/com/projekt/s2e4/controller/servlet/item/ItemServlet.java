package com.projekt.s2e4.controller.servlet.item;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name = "itemServlet", urlPatterns = "/item")
public class ItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        log.info("[System] Item do get");
        resp.getWriter().println("<html>");
        resp.getWriter().println("<header>");
        resp.getWriter().println("</header>");
        resp.getWriter().println("<body>");
        resp.getWriter().println("<h1>Hello " + getServletContext().getAttribute("name") + "</h1>");
        resp.getWriter().println("</body>");
        resp.getWriter().println("</html>");
    }

    @Override
    public void destroy() {
        log.info("[System] Item Servlet Destroy");
    }

    @Override
    public void init() {
        log.info("[System] Item Servlet Init");
    }
}