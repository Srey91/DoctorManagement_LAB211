/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validation;

import java.util.ArrayList;
import java.util.Scanner;
import model.Doctor;

/**
 *
 * @author 84898
 */
public class Validation {
    public String getString (String string)
   {
       Scanner sc = new Scanner(System.in);
       
       System.out.println("Enter " + string  + ": ");
       
       while (true)
       {
            String result = sc. nextLine();
           
           if (result.isEmpty())
           {
               System.out.println(string + " can't empty!!!");
               System.out.println("Enter " + string + " again: ");
           }else 
               return result;
       }
   }
    
    public String getStringUpdate (String string)
   {
       Scanner sc = new Scanner(System.in);
       
       System.out.println("Enter " + string  + ": ");
       
       while (true)
       {
            String result = sc. nextLine();
            return result;
       }
   }
    
    public int getAnyInteger (String string)
   {
       while (true)
       {
           try 
           {
                int number  = Integer.parseInt(getString(string)); 
                return number;
                
           }catch (NumberFormatException e)
           {
               System.out.println("Number invalid!!!");
           }
       }
   }
    
    public int getPositiveInteger (String string)
   {
       while (true)
       {
           try 
           {
                int number  = Integer.parseInt(getString(string));
                if (number >= 0)
                    return number;
                else
                    System.out.println(string +  "can't below zero");
           }catch (NumberFormatException e)
           {
               System.out.println("Number invalid!!!");
           }
       }
   }
    
    public String getDoctorCode(ArrayList<Doctor> doctorList)
   {
        boolean isExist;
        
        while (true) 
        {
            isExist = false;
            String code = getString("Code");//scannerNextLine
            
            for (Doctor doctor : doctorList) 
            {
                if (doctor.getCode().equals(code)) 
                {
                    System.out.println("Code is existed!!!");
                    isExist = true;
                }
            }
            if(isExist == false) return code;
        }
    }
}


