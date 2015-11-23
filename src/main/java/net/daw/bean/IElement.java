/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.bean;

/**
 *
 * @author rafa
 */
public interface IElement {

    public String getId();

//    public String getName();

    public String getTag();

    public void setId(String id);

//    public void setName(String name);

    public void setTag(String tag);

    public String getTagClass();

    public void setTagClass(String class_);
}
