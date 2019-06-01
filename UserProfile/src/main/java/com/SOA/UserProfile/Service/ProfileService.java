package com.SOA.UserProfile.Service;

import com.SOA.UserProfile.Model.UserProfile;
import com.SOA.UserProfile.DAO.DatabaseClass;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileService {
   private Map<Long,UserProfile> Userprofiles = DatabaseClass.getUsers();
   
   // Creating some predefine profile and populating the same in the map
   public ProfileService() {
      UserProfile m1 = new UserProfile(1L,"Tutorials1","Point1","TutorialsPoint.com");
      UserProfile m2 = new UserProfile(2L,"Tutorials2","Point2","TutorialsPoint.com2");
      UserProfile m3 = new UserProfile(3L,"Tutorials3","Point3","TutorialsPoint.com3");
      UserProfile m4 = new UserProfile(4L,"Tutorials4","Point4","TutorialsPoint.com4");
      
      Userprofiles.put(1L, m1);
      Userprofiles.put(2L, m2);
      Userprofiles.put(3L, m3);
      Userprofiles.put(4L, m4);
   }
   
   //Method to fetch all profile
   public List<UserProfile> getAllProfile() {
      List<UserProfile> list = new ArrayList<UserProfile>(Userprofiles.values());
      return list;
   }  // Method to fetch only one profile depending on the ID provided
   
   public UserProfile getProfile(long id) {
      return Userprofiles.get(id);
   }  //Method to add profile
   
   public UserProfile addProfile(UserProfile UserProfile) {
      UserProfile.setProId(Userprofiles.size()+1);
      Userprofiles.put(UserProfile.getProId(), UserProfile);
      return UserProfile;
   }  //method to update Profile

   public UserProfile UpdateProfile(UserProfile UserProfile) {
      if(UserProfile.getProId()<=0) { 
         return null;
      } else { 
         Userprofiles.put(UserProfile.getProId(), UserProfile);
         return UserProfile;
      }
   } //method to delete profile
   
   public void RemoveProfile(long Id) {
      Userprofiles.remove(Id);
   }
}