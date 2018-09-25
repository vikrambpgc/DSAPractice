package com.vikrambpgc.Experiements;
import java.io.File;

public class MkDirs {
   public static void main(String[] args) {
      
      File f = null;
      boolean bool = false;
      
      /*
      try{      
         // returns pathnames for files and directory
    	 //Texts, TutorialsPoint, Java are all folders only.
         f = new File("Texts/TutorialsPoint/Java");     
         // create directories
         bool = f.mkdirs();        
         // print
         System.out.print("Directory created? "+bool);        
      }catch(Exception e){
         e.printStackTrace();
      } 
      
      f = null;
      try{
         // creates temporary file
         f = File.createTempFile("Personal/tmp", ".txt", new File("C:/Users/vikramc/Documents/"));
         // prints absolute path
         System.out.println("File path: "+f.getAbsolutePath());
         
         // deletes file when the virtual machine terminate
         //f.deleteOnExit();
         
         
      }catch(Exception e){
         e.printStackTrace();
      } */
      
      boolean x = false, y = true, z = false;
      
      z = x && y;
      System.out.println("z:" + z);
   }
}




