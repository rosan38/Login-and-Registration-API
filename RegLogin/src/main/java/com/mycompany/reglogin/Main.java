/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reglogin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.model.Users;
import com.mycompany.service.UserServiceImp;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static spark.Spark.*;

/**
 *
 * @author rosan
 */
public class Main {

    private static ObjectMapper objmap = new ObjectMapper();
    private static Logger logger = LogManager.getLogger();
    private static UserServiceImp usi = new UserServiceImp();

    public static void main(String[] args) {
        port(8080);

        /* Reg new User */
        post("/reg", (request, response) -> {
            response.type("application/json");
            Users users = objmap.readValue(request.body(), Users.class);
            String result = usi.regUser(users);
            logger.info(result);
            return objmap.writeValueAsString(result);
        });

        /* login */
        get("/login", (request, response) -> {
            response.type("application/json");
            Users users = objmap.readValue(request.body(), Users.class);
            String result = usi.login(users);
            logger.info(result);
            return objmap.writeValueAsString(result);
        });
    }

}
