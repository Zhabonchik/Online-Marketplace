package by.fpmibsu.OnlineMarketplace.controller;

import by.fpmibsu.OnlineMarketplace.controller.*;

import java.util.HashMap;
import java.util.Map;

public class ControllerMapper {
    private static Map<String, Controller> controllers;

    static {
        controllers = new HashMap<>();
        controllers.put("/marketplace/home", new HomePageController());
        controllers.put("/marketplace/registration", new RegistrationController());
        controllers.put("/marketplace/login", new LoginController());
        controllers.put("/marketplace/logout", new LogoutController());
        controllers.put("/marketplace/phone", new PhoneController());
        controllers.put("/marketplace/review", new ReviewsController());
        /*controllers.put("/marketplace/catalog", new CatalogController());*/
    }

    public static Controller getControllerByUri(String uri){
        Controller controller = controllers.get(uri);
        return controller;
    }
}
