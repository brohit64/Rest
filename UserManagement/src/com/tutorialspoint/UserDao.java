package com.tutorialspoint;  

import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException;  
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.util.ArrayList; 
import java.util.List;  

public class UserDao { 
   public List<User> getAllUsers(){ 
      
      List<User> userList = null; 
      try { 
         File file = new File("Users.dat"); 
         if (!file.exists()) { 
            User user = new User(1, "Mahesh", "Teacher"); 
            User user2 = new User(2, "Rohit", "Teacher"); 
            userList = new ArrayList<User>(); 
            userList.add(user); 
            userList.add(user2); 
            saveUserList(userList,"Users.dat"); 
         } 
         else{ 
            FileInputStream fis = new FileInputStream(file); 
            ObjectInputStream ois = new ObjectInputStream(fis); 
            userList = (List<User>) ois.readObject(); 
            ois.close(); 
         } 
      } catch (IOException e) { 
         e.printStackTrace(); 
      } catch (ClassNotFoundException e) { 
         e.printStackTrace(); 
      }   
      return userList; 
   } 
   
   public List<User> getAllUsers2(){ 
	      
	      List<User> userList = null; 
	      try { 
	         File file = new File("Users2.dat"); 
	         if (!file.exists()) { 
	            User user = new User(1, "Mahesh", "Teacher"); 
	            userList = new ArrayList<User>(); 
	            userList.add(user);  
	            saveUserList(userList, "Users2.dat"); 
	         } 
	         else{ 
	            FileInputStream fis = new FileInputStream(file); 
	            ObjectInputStream ois = new ObjectInputStream(fis); 
	            userList = (List<User>) ois.readObject(); 
	            ois.close(); 
	         } 
	      } catch (IOException e) { 
	         e.printStackTrace(); 
	      } catch (ClassNotFoundException e) { 
	         e.printStackTrace(); 
	      }   
	      return userList; 
	   } 
   
   
   private void saveUserList(List<User> userList, String name){ 
      try { 
         File file = new File(name); 
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
}
