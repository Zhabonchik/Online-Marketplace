package servlet;

import controller.Controller;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/page")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        JSONArray jsonArray = new JSONArray();
        try{
            jsonArray = Controller.getInstance().proceedRequest(req);
            printWriter.println(jsonArray);
        } catch (Exception e){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("exception", e.getMessage());
            printWriter.println(jsonObject);
        }
    }
}
