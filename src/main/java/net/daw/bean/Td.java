/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.bean;

import com.google.gson.annotations.Expose;

/**
 *
 * @author rafa
 */
public class Td extends Element implements IElement {

    @Expose
    private String content = "";




    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Td() {
        super.setTag("td");
    }

}
