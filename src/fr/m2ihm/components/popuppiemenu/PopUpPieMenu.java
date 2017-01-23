/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m2ihm.components.popuppiemenu;

import fr.m2ihm.components.curbedbutton.CurvedButton;
import fr.m2ihm.components.curbedbuttontext.CurvedButtonText;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;

/**
 *
 * @author buisangu
 */
public class PopUpPieMenu extends JLayeredPane{
    private List<CurvedButtonText> buttons;
    
    public PopUpPieMenu(){
        this(new String[]{"1","2", "3"}, 0.5);
    }
    
    public PopUpPieMenu(String[] names, double fillProportion){
        buttons = new ArrayList<>();
        CurvedButtonText curvedButton;
        double incrementalAngle = 360/names.length;
        for (int i=0; i<names.length; i++){
            curvedButton = new CurvedButtonText(names[i], Color.yellow, fillProportion, i*incrementalAngle, (i+1)*incrementalAngle);
            buttons.add(curvedButton);
            this.add(curvedButton, PALETTE_LAYER);
        }
        setLayout(null);
    }
    
    public String[] getItems(){
        String[] itemsLabel = new String[buttons.size()];
        for (int i=0; i<buttons.size(); i++){
            itemsLabel[i] = buttons.get(i).getText();
        }
        return itemsLabel;
    }
    
    public void setItems(String[] names){
        double fillProportion = this.getFillProportion();
        this.removeAll();
        buttons.clear();
        CurvedButtonText curvedButton;
        double incrementalAngle = 360/names.length;
        for (int i=0; i<names.length; i++){
            curvedButton = new CurvedButtonText(names[i], Color.yellow, fillProportion, i*incrementalAngle, (i+1)*incrementalAngle);
            buttons.add(curvedButton);
            this.add(curvedButton, DEFAULT_LAYER);
        }
    }
    
    public double getFillProportion(){
        return buttons.get(0).getFillProportion();
    }
    
    public void setFillProportion(double prop){
        double proportion = Math.max(0, Math.min(1, prop));
        for (CurvedButtonText b: buttons){
            b.setFillProportion(proportion);
        }
    }
    
    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        for (CurvedButtonText b: buttons){
            b.setBounds(0, 0, width, height);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        int maxWidth = 0;
        int maxHeight = 0;
        for (CurvedButtonText b: buttons){
            System.out.println(b.getPreferredSize().width);
            maxWidth = Math.max(maxWidth, b.getPreferredSize().width);
            maxHeight = Math.max(maxHeight, b.getPreferredSize().height);
        }
        System.out.println(maxHeight);
        return new Dimension(maxWidth, maxHeight);
    }
}
