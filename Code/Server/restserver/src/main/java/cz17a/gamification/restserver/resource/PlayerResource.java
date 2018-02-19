package cz17a.gamification.restserver.resource;

import java.util.Calendar;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import data.access.PlayerDAO;
import data.model.Player;
import data.model.User;

@Path("/players")
public class PlayerResource {
	private PlayerDAO dao = new PlayerDAO();

	@POST
	@Path("/register/{name}/{password}/{email}")
	public Response register(@PathParam("name") String name, @PathParam("password") String password,
			@PathParam("email") String email) {
		if (!dao.usernameExist(name) && !dao.emailExist(email)) {
			Player player = new Player(email, name, password);
			player.setRegistration(Calendar.getInstance());
			dao.addPlayer(player);
			if (dao.getPlayer(player.getId()) != null) {
				return Response.status(200).build();
			}
			return Response.status(400).build();
		}
		return Response.status(418).build();
	}

	@POST
	@Path("/login/{name}/{password}")
	public Response login(@PathParam("name") String name, @PathParam("password") String password) {
		Player player = dao.getPlayer(name);
		if (player == null) {
			player = dao.getPlayerByMail(name);
			if (player == null)
				return Response.status(418).build();
		}
		if (player.getPassword().equals(password)) {
			return Response.status(200).build(); // return ok --> successfully logged in
		} else {
			return Response.status(418).build(); // --> password is incorrect, reject login "IM A TEAPOT"
		}
	}
	
	@POST
	@Path("/logout/{name}")
	public Response logout(@PathParam("name") String name){
		Player player = dao.getPlayer(name);
		if(player != null) { //user does exist (and was logged in before, see todo in loginUser)
			return Response.status(200).build(); //for now just give the ok
		}
		else {
			return Response.status(400).build(); //user doesnt exist (or was not logged in before, see todo in loginUser), fail response
		}
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id) {
		Player player = dao.getPlayer(id);
		dao.deletePlayer(player);
		if (dao.getPlayer(player.getId()) == null) { // if the user was successfully deleted from DB, then return 200
			return Response.status(200).build();
		} else {
			return Response.status(400).build(); // fail return, user has not been deleted from DB
		}

	}
	
	@POST
	@Path("/forgotPassword/{name}")
	public Response sendPasswordToMail(@PathParam("name") String name){
		try { //sourround with try catch to check if mail sends correctly
			Player user = dao.getPlayer(name);
			String username = "cz17a"; //this is the username of our mail address
			String password = "swtcz17a"; //corresponding password
			String senderAddress ="cz17a@web.de";//our email-address
			String recipientsAddress = user.getMail(); //receivers email
			String subject = "Your Password for cz17a Quiz App";
			String text = user.getPassword();
			String smtpHost = "smtp.web.de"; //smtp host of web.de
			MailResource mail = new MailResource();
			mail.sendMail(smtpHost, username, password, senderAddress, recipientsAddress, subject, text);
		}
		catch(Exception ex) {
			ex.printStackTrace(System.err);
			return Response.status(400).build(); //if an exception occured while sending return fail code
		}
		finally {
			return Response.status(200).build();
		}
	}
}