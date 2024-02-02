/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import model.Doctor;
import model.DoctorManagement;
import validation.Validation;

/**
 *
 * @author 84898
 */
public class DoctorView {
    DoctorManagement dm = new DoctorManagement();
    Validation v = new Validation();
    
    public void loadFile(String path)
    {
        File file = new File(path);
        FileReader fileReader = null;
        BufferedReader bufferedReader;
        boolean isDuplicatedId = false;
        
        if (file.exists() && file.isFile())
        {
            try
            {
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(fileReader);
                
                String line = bufferedReader.readLine();
                
                while (line != null)
                {
                    if (line.trim().length() != 0)
                    {
                        String[] data = line.split(",");

                        String code = data[0];
                        for (Doctor doctor : dm.getDoctorList())
                        {
                            if (doctor.getCode().equals(code))
                            {
                                isDuplicatedId = true;
                            }
                        }
                        String name = data[1];
                        String specialization = data[2];
                        int availability = Integer.parseInt(data[3]);

                        Doctor doctor = new Doctor(code, name, specialization, availability);
                        dm.getDoctorList().add(doctor);
                        
                        if (isDuplicatedId) throw new IOException("Id is duplicate!!!");
                    }
                    line = bufferedReader.readLine();    
                }
                System.out.println("Load file success!!!");
                    
            }catch (FileNotFoundException e)
            {
                System.out.println("File not found!!!");
            }catch (IOException e)
            {
                System.err.println("File close error!!!");
            }finally
            {
                try {
                    fileReader.close();
                } catch (IOException ex) {
                    System.out.println("File close error!!!");
                }
            }
        }
    }
    
    public void add()
    {
        System.out.println("--------- Add Doctor ----------");
        
        String code = v.getDoctorCode(dm.getDoctorList());
        String name = v.getString("Name");
        String specialization = v.getString("Specialization");
        int availability = v.getPositiveInteger("Avalability");
        
        Doctor doctor = new Doctor(code, name, specialization, availability);
        dm.getDoctorList().add(doctor);
        
        System.out.println("Add successful!!!");
    }
    
    public void update()
    {
        System.out.println("--------- Update Doctor -------");
        
        String code = v.getString("Code for update");
        boolean isExist = false;
        int index = 0;
        DoctorManagement update = new DoctorManagement();
        
        for (Doctor doctor : dm.getDoctorList())
        {
            if (code.equals(doctor.getCode()))
            {
                isExist = true;
                index = dm.getDoctorList().indexOf(doctor);
                update.getDoctorList().add(doctor);
            }
        }
        
        if (isExist)
        {
            display(update, "Update Doctor");
            System.out.println("Enter new information to update!!!");
            Doctor doctor = dm.getDoctorList().get(index);
            
            String name = dm.getDoctorList().get(index).getName();
            String nameUpdate = v.getStringUpdate("Name");
            if (nameUpdate.isEmpty()) nameUpdate = name;
            
            String specialization = dm.getDoctorList().get(index).getSpecialization();
            String specializationUpdate = v.getStringUpdate("Specialization");
            if (specializationUpdate.isEmpty()) specializationUpdate = specialization;
            
            int availabilityUpdate = v.getPositiveInteger("Availability"); 
            
            doctor.setName(nameUpdate); 
            doctor.setSpecialization(specializationUpdate); 
            doctor.setAvailability(availabilityUpdate);
            
            System.out.println("Update successful!!!");
        }else 
        {
            System.out.println("Doctor code does not exist!!!");
        }
    }
    
    public void delete()
    {
        System.out.println("--------- Delete Doctor -------");
        
        String code = v.getString("Code");
        boolean isExist = false;
        int index = 0;
        
        for (Doctor doctor : dm.getDoctorList())
        {
            if (code.equals(doctor.getCode()))
            {
                isExist = true;
                index = dm.getDoctorList().indexOf(doctor);
            }
        }
        
        if (isExist)
        {
            dm.getDoctorList().remove(dm.getDoctorList().get(index));
            System.out.println("Delete successful!!!");
        }else
        {
            System.out.println("Doctor not exist!!!");
        }
    }
    
    public void display(DoctorManagement doctorManagement, String string)
    {
        System.out.println("---------- " + string +" --------");
        rowBorder(7); rowBorder(25); rowBorder(20); rowBorder(15); System.out.println("|");

        System.out.printf("%-7s%-25s%-20s%-15s", "|Code", "|Name", "|Specialization", "|Availability");
        System.out.println("|");
        
        rowBorder(7); rowBorder(25); rowBorder(20); rowBorder(15); System.out.println("|");
        for (Doctor doctor: doctorManagement.getDoctorList())
        {
            doctor.outputFormat();
        }
 
        System.out.println("|");
        rowBorder(7); rowBorder(25); rowBorder(20); rowBorder(15); System.out.println("|");
    }
    
    public void find()
    {
        System.out.println("---------- Search Doctor --------");
        
        String text = v.getString("Text");
        boolean isExist = false;
        DoctorManagement search = new DoctorManagement();
        
        for (Doctor doctor : dm.getDoctorList())
        {
            if (doctor.getCode().contains(text) || doctor.getName().contains(text) || doctor.getSpecialization().contains(text))
            {
                isExist = true;
                search.getDoctorList().add(doctor);
            }
        }
        
        if (isExist)
        {
            display(search, "Search Doctor");
        }else
            System.out.println("Doctor not found!!!");
    }
    
    public void rowBorder(int number)
    {   
        System.out.print("|");
        for (int i = 0; i < number - 1; i++)
        {
            System.out.print("-");
        }
    }
  
}
