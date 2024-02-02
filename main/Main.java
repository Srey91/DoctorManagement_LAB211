/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import controller.DoctorController;
import view.DoctorView;

/**
 *
 * @author 84898
 */
public class Main {
    public static void main(String[] args) {
        DoctorView dv = new DoctorView();
        DoctorController dc = new DoctorController();
        dc.menu(dv);
    }
}
