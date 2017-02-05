/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m2ihm.components.popuppiemenu;

import fr.m2ihm.components.curbedbutton.CurvedButton;
import fr.m2ihm.components.piemenuitem.PieMenuItem;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.MenuItem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author buisangu
 */
public class PopUpPieMenu extends JLayeredPane{
    List<PieMenuItem> items;
    double fillProportion;
    
    public PopUpPieMenu(){
        this(0.5);
    }
    
    public PopUpPieMenu(double fillProportion){
        if (fillProportion > 1 || fillProportion <=0){
            throw new RuntimeException("Cannot create a pie menu with a fill > 1 or <= 0 !");
        }
        this.fillProportion = 1-fillProportion;
        items = new ArrayList<>();
    }

    public void add(PieMenuItem item){
        if (items.size() >= 8){
            throw new RuntimeException("Cannot Make PieMenu with more than 8 items.");
        }
        items.add(item);
        this.add(item, DEFAULT_LAYER);
        for (int i=0; i<items.size(); i++){
            PieMenuItem pi = items.get(i);
            pi.setStartAngle(i * 360 / items.size());
            pi.setOpenAngle(360 / items.size());
            pi.setFillProportion(this.fillProportion);
        }
        
    }
    
    public void remove(PieMenuItem item){
        items.remove(item);
        this.remove(item);
    }
    
    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        for (PieMenuItem b: items){
            b.setBounds(0, 0, width, height);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        int maxWidth = 0;
        int maxHeight = 0;
        for (PieMenuItem b: items){
            System.out.println(b.getPreferredSize().width);
            maxWidth = Math.max(maxWidth, b.getPreferredSize().width);
            maxHeight = Math.max(maxHeight, b.getPreferredSize().height);
        }
        System.out.println(maxHeight);
        return new Dimension(maxWidth, maxHeight);
    }
    
}
