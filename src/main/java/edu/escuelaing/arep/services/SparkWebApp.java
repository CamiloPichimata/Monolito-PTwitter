package edu.escuelaing.arep.services;

import edu.escuelaing.arep.entities.Feed;
import edu.escuelaing.arep.entities.Post;
import edu.escuelaing.arep.entities.RegisteredUsers;
import edu.escuelaing.arep.entities.User;
import com.google.gson.Gson;
import java.util.concurrent.atomic.AtomicReference;

import static spark.Spark.*;

public class SparkWebApp {

	 public static void main(String[] args) {
		 Feed feed = new Feed();
		 AtomicReference<String> actualUser = new AtomicReference<>();
		 // Inicialización de usuarios registrados
		 User user1 = new User("User1", "password1");
		 User user2 = new User("User2", "password2");
		 User user3 = new User("User3", "password3");
		 RegisteredUsers registeredUsers = new RegisteredUsers();
		 registeredUsers.AddNewUser(user1);
		 registeredUsers.AddNewUser(user2);
		 registeredUsers.AddNewUser(user3);

		 System.out.println("Initiating server... READY");
		 port(getPort());
		 get("/hello", (req, res) -> "Hello there");

		 get("/getPosts", (req, res) -> {
			 res.type("application/json");
		 return new Gson().toJson(feed.getPosts());
		 });


		 get("/login/:user/:password", (req,res)->{
			 System.out.println("Ingrese al login ");
			 System.out.println("User "+ req.params(":user"));
			 System.out.println("Password "+ req.params(":password"));
			 boolean found = registeredUsers.IsRegistered(req.params(":user"),req.params(":password"));
			 if(found) actualUser.set(req.params(":user"));
		 return found;
		 });

		 post("/post",(req,res)->{
			 System.out.println("Ingrese al post del post ");
			 System.out.println("Body " + req.body());
			 feed.addNewPost(new Post(req.body(), actualUser));
			 res.status(200);
			return "Post registrado";
		 });

	 }
	 
	 static int getPort() {
		 if (System.getenv("PORT") != null) {
		 return Integer.parseInt(System.getenv("PORT"));
		 }
		 return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
	}
}