package com.SOA.UserProfile.Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserProfile {
   private long ProId;
   private String FName;
   private String LName;
   private String Add;
   public UserProfile(){}
   
   public UserProfile(long Proid, String Fname, String Lname,String Add) {
      this.ProId = Proid;
      this.FName = Fname;
      this.LName = Lname;
      this.Add = Add;
   }
   public long getProId() {
      return ProId;
   }
   public void setProId(long ProId) {
      this.ProId = ProId;
   }
   public String getFName() {
      return FName;
   }
   public void setFName(String FName) {
      this.FName = FName;
   }
   public String getLName() {
      return LName;
   }
   public void setLName(String LName) {
      this.LName = LName;
   }
   public String getAdd() {
      return Add;
   }
   public void setAdd(String Add) {
      this.Add = Add;
   }
}