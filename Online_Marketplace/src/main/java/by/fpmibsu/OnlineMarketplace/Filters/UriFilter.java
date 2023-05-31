package by.fpmibsu.OnlineMarketplace.Filters;

import by.fpmibsu.OnlineMarketplace.controller.Controller;
import by.fpmibsu.OnlineMarketplace.controller.ControllerMapper;
import by.fpmibsu.OnlineMarketplace.util.JspHelper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebFilter("/marketplace/*")
public class UriFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(UriFilter.class);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        LOGGER.info("processing uri");
        String uri = httpRequest.getRequestURI();
        try {
            Controller controller = ControllerMapper.getControllerByUri(uri);
            httpRequest.setAttribute("controller", controller);
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            LOGGER.error("Didn't manage to create controller");
            httpRequest.setAttribute("error", String.format("Запрошенный адрес %s не может быть обработан сервером", uri));
            httpRequest.getServletContext().getRequestDispatcher(JspHelper.getPath("error")).forward(servletRequest, servletResponse);
        }
    }
}
