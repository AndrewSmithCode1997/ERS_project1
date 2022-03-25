import controllers.ReimbursementController;
import controllers.SessionController;
import controllers.UserController;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import static io.javalin.apibuilder.ApiBuilder.*;

public class MainDriver {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.addStaticFiles("/", Location.CLASSPATH);
        }).start(9000);

        UserController userController = new UserController();
        ReimbursementController reimbursementController = new ReimbursementController();
        SessionController sessionController = new SessionController();

        // :: method reference symbol
        /*app.post("/user", userController::createUser);
        app.post("/login", userController::login);

        app.get(" /user/{userId}/reimbursement", reimbursementController::displayAllReimbForUser);

        app.post("/user/{userId}/reimbursement", reimbursementController::createReimb);

        app.delete("/reimbursement/{reimbursementId}", reimbursementController::deleteReimbursement);

        app.put("/user/{userId}/{statusId}/{reimbId}", reimbursementController::processReimbursement);*/

        //app.get("/user/{userId}/all", reimbursementController::displayAllReimbursements);

        // --works
        app.routes(() -> {
            path("reimbursement", () -> {
                        post(reimbursementController::createReimb);
                        get(reimbursementController::displayAllReimbForUser);
                        path("{userId}", () -> {
                            delete(reimbursementController::deleteReimbursement);
                            patch(reimbursementController::processReimbursement);
                            path("all", () -> {
                                get(reimbursementController::displayAllReimbursements);
                            });
                        });
                    });
            path("session", () -> {
                post(sessionController::login);
                get(sessionController::checkSession);
                delete(sessionController::logout);
            });
            post("/user", userController::createUser);


            // UserDAO userDAO = new UserDAOImpl();

            //userDAO.createUser(new User("Andrew123", "pass123", "Andrew", "Smith", "andrew@email.com", 1));
            //System.out.println(userDAO.getByUsername("Andrew123"));
            //userDAO.createUser(new User("Nyko1", "pass123", "Nyko", "Smith", "nyko@yahoo.com", 2));
            //System.out.println(userDAO.getByUsername("Nyko1"));
            //Javalin app = Javalin.create().start(9000);
        });
    }
}
