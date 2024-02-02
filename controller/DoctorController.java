/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import menu.Menu;
import view.DoctorView;

/**
 *
 * @author 84898
 */
public class DoctorController extends Menu{
    public void menu(DoctorView dv)
    {
        String[] content = {"Add Doctor", "Update Doctor", "Delete Doctor", "Search Doctor", "Exit"};
        Menu m = new Menu("========= Doctor Management ==========", content) {
            @Override
            public void execute(int ch) {
                switch (ch)
                {
                    case 1: dv.add(); break;
                    case 2: dv.update(); break;
                    case 3: dv.delete(); break;
                    case 4: dv.find(); break;
                }
            }
        };
        m.run();
    }
    
    @Override
    public void execute(int ch) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
