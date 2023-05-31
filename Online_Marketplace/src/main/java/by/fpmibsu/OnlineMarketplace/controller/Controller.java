package by.fpmibsu.OnlineMarketplace.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Controller {
    public void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    public void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
