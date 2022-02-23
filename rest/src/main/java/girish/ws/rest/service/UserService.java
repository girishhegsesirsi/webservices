package girish.ws.rest.service;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import girish.ws.rest.beans.User;
import girish.ws.rest.dao.UserDao;  

public class UserService {  
	 UserDao userDao = new UserDao();
	   private static final String SUCCESS_RESULT="<result>success</result>";
	   private static final String FAILURE_RESULT="<result>failure</result>"; 

   public List<User> getUsers(){ 
	   System.out.println("inside the getUsers()");
      return userDao.getAllUsers(); 
   }  
   

   public User getUser(int userid){
      return userDao.getUser(userid);
   }


   public String createUser( User user) {
      int result = userDao.addUser(user);
      if(result == 1){
         return SUCCESS_RESULT;
      }
      return FAILURE_RESULT;
   }


   public String addUser( User user )  {

      int result = userDao.addUser(user);
      if(result == 1){
         return SUCCESS_RESULT;
      }
      return FAILURE_RESULT;
   }
   public String updateUser( User user )  {

	      int result = userDao.addUser(user);
	      if(result == 1){
	         return SUCCESS_RESULT;
	      }
	      return FAILURE_RESULT;
	   }
   public String deleteUser( int userid){
      int result = userDao.deleteUser(userid);
      if(result == 1){
          return SUCCESS_RESULT;
       }
       return FAILURE_RESULT;
    }


}