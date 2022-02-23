package girish.ws.rest;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import girish.ws.rest.beans.User;
import girish.ws.rest.service.UserService;


@Path("/Userdata") 
public class UserMain {
    UserService userService = new UserService();
	 @GET 
	 @Path("/users") 
	 @Produces(MediaType.APPLICATION_XML) 
	 public List<User> getUsers(){ 
	  
		   System.out.println("inside the getUsers()");
	      return userService.getUsers(); 
	   }
	 


	   @GET
	   @Path("/users/{userid}")
	   @Produces(MediaType.APPLICATION_XML)
	   public User getUser(@PathParam("userid") int userid){
	      return userService.getUser(userid);
	   }

	   @POST
	   @Path("/users")
	   @Produces(MediaType.APPLICATION_XML)
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	   public String createUser(@FormParam("id") int id,
	      @FormParam("name") String name,
	      @FormParam("profession") String profession,
	      @Context HttpServletResponse servletResponse) throws IOException{
	      User user = new User(id, name, profession);
	     return userService.addUser(user);

	   }

	   @PUT
	   @Path("/users")
	   @Produces(MediaType.APPLICATION_XML)
	   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	   public String updateUser(@FormParam("id") int id,
	      @FormParam("name") String name,
	      @FormParam("profession") String profession,
	      @Context HttpServletResponse servletResponse) throws IOException{
	      User user = new User(id, name, profession);
	     return userService.updateUser(user);

	   }

	   @DELETE
	   @Path("/users/{userid}")
	   @Produces(MediaType.APPLICATION_XML)
	   public String deleteUser(@PathParam("userid") int userid){
	      return userService.deleteUser(userid);
	
	   }

	   @OPTIONS
	   @Path("/users")
	   @Produces(MediaType.APPLICATION_XML)
	   public String getSupportedOperations(){
	      return "<operations>GET, PUT, POST, DELETE</operations>";
	   }
	

}
