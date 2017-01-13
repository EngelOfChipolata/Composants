/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m2ihm.components.curbedbutton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javafx.scene.shape.Circle;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author buisangu
 */
public class CurbedButton  extends JComponent{
    
    private JLabel label;
    private Color color;
    private PropertyChangeSupport support;
    private double fillProportion;
    private double startAngle;
    private double openAngle;
    
    
    public CurbedButton(){
        this("default", Color.PINK, 0.5, 0, 180);
    }
    
    public CurbedButton(String text, Color color, double fillProportion, double startAngle, double endAngle){
        super();
        this.support = new PropertyChangeSupport(this);
        this.label = new JLabel(text);
        this.color = color;
        this.fillProportion = fillProportion;
        this.startAngle = startAngle;
        this.openAngle = endAngle;
    }
    
    public final Color getColor(){
        return this.color;
    }
    
    public final void setColor(Color c){
        this.color = c;
    }

    public double getFillProportion() {
        return fillProportion;
    }

    public void setFillProportion(double fillProportion) {
        this.fillProportion = fillProportion;
        //this.fillProportion = Math.max(0, Math.min(1, fillProportion));
    }

    public double getStartAngle() {
        return startAngle;
    }

    public void setStartAngle(double startAngle) {
        this.startAngle = startAngle;
    }

    public double getOpenAngle() {
        return openAngle;
    }

    public void setOpenAngle(double openAngle) {
        this.openAngle = openAngle;
    }
    
    public void addPropertyChangeListener(PropertyChangeListener li){
        support.addPropertyChangeListener(li);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener li){
        support.removePropertyChangeListener(li);
    }
    
    @Override
    public void paint(Graphics g){
        
        Graphics2D g2 = (Graphics2D) g;
        
        Color oldColor = g.getColor();
        g2.setColor(getColor());
        Area quarterCircle = new Area(new Arc2D.Double(0, 0, getWidth(), getHeight(), startAngle, openAngle, Arc2D.PIE));
        Area center = new Area(new Ellipse2D.Double(getWidth() / 2 - getWidth() / 2 * fillProportion, 
                getHeight() / 2 - getHeight() / 2 * fillProportion, 
                getWidth() * fillProportion, 
                getHeight() * fillProportion));
        
        quarterCircle.subtract(center);
        
        g2.fill(quarterCircle);
        
        g2.setColor(oldColor);
    }

    @Override
    public boolean contains(int x, int y) {
        double internalA = getWidth() * fillProportion / 2;
        double internalB = getHeight() * fillProportion / 2;
        double angle = Math.atan2(y, x) * 180 / Math.PI;
        
        System.out.println((Math.pow(x / getWidth() / 2 - 1, 2) + Math.pow(y / getHeight() / 2 - 1, 2) <= 1) +" : " +
                (Math.pow((x - getWidth()) / internalA, 2) + Math.pow((y - getHeight()) / internalB, 2) > 1) + " : " +
                (angle >= startAngle) + " : " + (angle <= startAngle + openAngle));
        
        return ((Math.pow(x / getWidth() / 2 - 1, 2) + Math.pow(y / getHeight() / 2 - 1, 2) <= 1)
                && (Math.pow((x - getWidth()) / internalA, 2) + Math.pow((y - getHeight()) / internalB, 2) > 1)
                && angle >= startAngle
                && angle <= startAngle + openAngle);
    }
    
    
    
}
