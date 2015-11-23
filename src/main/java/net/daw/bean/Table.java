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
public class Table extends Element implements IElement {

    @Expose
    ArrayList<Th> cabecera = null;
    @Expose
    ArrayList<Tr> cuerpo = null;


    public ArrayList<Th> getCabecera() {
        return cabecera;
    }

    public void setCabecera(ArrayList<Th> cabecera) {
        this.cabecera = cabecera;
    }

    public ArrayList<Tr> getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(ArrayList<Tr> cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Table() {
        super.setTag("table");
    }



}
