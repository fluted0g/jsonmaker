/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.bean;

import com.google.gson.annotations.Expose;
import java.util.ArrayList;

/**
 *
 * @author rafa
 */
public class Tr extends Element implements IElement {

    @Expose
    ArrayList<Td> group = null;


    public ArrayList<Td> getGroup() {
        return group;
    }

    public void setGroup(ArrayList<Td> group) {
        this.group = group;
    }

    public Tr() {
        super.setTag("tr");
    }

   
}
