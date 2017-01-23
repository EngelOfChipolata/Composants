/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m2ihm.components.curbedbuttontext;

import fr.m2ihm.components.curbedbutton.CurvedButton;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 *
 * @author buisangu
 */
public class CurvedButtonText extends JLayeredPane{
    JLabel label;
    CurvedButton button;
    
    public CurvedButtonText(){
        this("default", Color.PINK, 0.5, 0, 90);
    }
    
    public CurvedButtonText(String text, Color color, double fillProportion, double startAngle, double openAngle){
        button = new CurvedButton(color, fillProportion, startAngle, openAngle);
        label = new JLabel(text);
        
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.LEFT);
        //label.setLocation((int)(getWidth() / 2 * (1 - fillProportion) * Math.sin(openAngle / 2 * Math.PI / 180)),
        //        (int)(getHeight()/ 2 * (1 - fillProportion) * Math.cos(openAngle / 2 * Math.PI / 180)));
        
        this.add(button, DEFAULT_LAYER);
        this.add(label, PALETTE_LAYER);
        setLayout(null);
        //label.setLocation(150, 150);
    }
    
    public String getText(){
        return label.getText();
    }
    
    public void setText(String text){
        this.label.setText(text);
    }
    
    public double getFillProportion(){
        return button.getFillProportion();
    }
    
    public void setFillProportion(double prop){
        button.setFillProportion(prop);
    }
    
    public double getOpenAngle(){
        return button.getOpenAngle();
    }
    
    public void setOpenAngle(double angle){
        button.setOpenAngle(angle);
    }
    
    public double getStartAngle(){
        return button.getStartAngle();
    }
    
    public void setStartAngle(double angle){
        button.setStartAngle(angle);
    }
    
    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        label.setBounds((int)(width/2 + width/2 * (1- getFillProportion()) * Math.cos((getStartAngle() + getOpenAngle() / 2) * Math.PI / 180)),
                (int)(height/2 - height/2 * (1-getFillProportion()/2) * Math.sin((getStartAngle() + getOpenAngle() / 2) * Math.PI / 180)), width, height);
        
        button.setBounds(0, 0, width, height);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Math.max(label.getPreferredSize().width, button.getPreferredSize().width), 
                Math.max(label.getPreferredSize().height, button.getPreferredSize().height));
    }
}
