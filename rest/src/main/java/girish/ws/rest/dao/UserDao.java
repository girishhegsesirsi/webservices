package girish.ws.rest.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import girish.ws.rest.beans.User;  

public class UserDao { 
   public List<User> getAllUsers(){ 
      
      List<User> userList = new ArrayList<User>(); 
      User user = new User(1,"Girish","Employee");
      userList.add(user);
		/*
		 * try { File file = new File("Users.dat"); if (!file.exists()) { User user =
		 * new User(1, "Mahesh", "Teacher"); userList = new ArrayList<User>();
		 * userList.add(user); saveUserList(userList); } else{ FileInputStream fis = new
		 * FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis);
		 * userList = (List<User>) ois.readObject(); ois.close(); } } catch (IOException
		 * e) { e.printStackTrace(); } catch (ClassNotFoundException e) {
		 * e.printStackTrace(); }
		 */      return userList; 
   } 
   private void saveUserList(List<User> userList){ 
      try { 
         File file = new File("Users.dat"); 
         FileOutputStream fos;  
         fos = new FileOutputStream(file); 
         ObjectOutputStream oos = new ObjectOutputStream(fos); 
         oos.writeObject(userList); 
         oos.close(); 
      } catch (FileNotFoundException e) { 
         e.printStackTrace(); 
      } catch (IOException e) { 
         e.printStackTrace(); 
      } 
   }
   public User getUser(int userId) {
	   return new User(1,"Girish","Employee");
   }
      public int addUser(User user) {
    	  return 1;
      }
   public int updateUser (User user) {
	 return 1;  
   } 
   public int deleteUser(int userid) {
	   return 1;
   }
}
