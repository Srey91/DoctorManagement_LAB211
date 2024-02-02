/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

import java.util.ArrayList;
import validation.Validation;

/**
 *
 * @author 84898
 */
public abstract class Menu {
    private String title;
    private ArrayList choices;
    Validation v = new Validation();

    public Menu() {
        choices= new ArrayList();
    }

    public Menu(String title, String[] mchon){
        this.title = title;
        choices= new ArrayList<>();
        for(String m:mchon) choices.add(m);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getChoices() {
        return choices;
    }

    public void setChoices(ArrayList choices) {
        this.choices = choices;
    }
//----------------------------------------------------
    public void display(){
        System.out.println(title);
        System.out.println("-------------------");
        for(int i=0; i<choices.size();i++){
            System.out.println((i+1)+". "+choices.get(i));
        }
        System.out.println("-------------------");
    }
//----------------------------------------------------
    public int getSelected(){
        display();
        return v.getAnyInteger("your choice");
    }    
//----------------------------------------------------
    public abstract void execute(int ch);    
//----------------------------------------------------
    public void run(){
        while(true){
            int ch=getSelected();
            if(ch<choices.size()) execute(ch);
            else break;
        }
    }    
}