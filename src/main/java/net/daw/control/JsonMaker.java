/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.control;

import java.util.ArrayList;
import net.daw.bean.Table;
import net.daw.bean.Td;
import net.daw.bean.Th;
import net.daw.bean.Tr;

public class JsonMaker {
    public Table getTable(int ancho, int alto) throws Exception {
        Table t = new Table();
        t.setTagClass("table table-responsive table-bordered table-hover table-striped table-condensed dataTable no-footer");
        ArrayList filah = new ArrayList<>();
        for (int contador3 = 1; contador3 <= ancho; contador3++) {
            Th th = new Th();
            th.setContent("Listado " + contador3);
            th.setId("cabecera" + contador3);
            filah.add(th);
        }
        t.setCabecera(filah);

        ArrayList filas = new ArrayList<>();
        t.setCuerpo(filas);
        for (int contador1 = 1; contador1 <= alto; contador1++) {
            Tr tr = new Tr();
            ArrayList fila = new ArrayList<>();
            tr.setGroup(fila);
            for (int contador2 = 1; contador2 <= ancho; contador2++) {
                Td td = new Td();
                td.setContent(TextGenerator.generaNombre());
                td.setId("cuerpo" + contador1 + contador2);
                fila.add(td);
            }
            filas.add(fila);
        }
        return t;
    }

}
