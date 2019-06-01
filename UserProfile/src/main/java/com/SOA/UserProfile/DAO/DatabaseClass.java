package com.SOA.UserProfile.DAO;

import com.SOA.UserProfile.Model.UserProfile;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {
   private static Map<Long,UserProfile> messages = new HashMap<Long,UserProfile>();
   public static Map<Long,UserProfile> getUsers() {
      return messages; 
      // Each time this method will return entire map as an instance of database
   }
}