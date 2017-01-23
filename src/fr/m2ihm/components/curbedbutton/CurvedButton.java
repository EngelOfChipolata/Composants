/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m2ihm.components.curbedbutton;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
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
public class CurvedButton  extends JComponent{
        private Color color;
    private PropertyChangeSupport support;
    private double fillProportion;
    private double startAngle;
    private double openAngle;
    
    
    public CurvedButton(){
        this(Color.PINK, 0.5, 0, 180);
    }
    
    public CurvedButton(Color color, double fillProportion, double startAngle, double endAngle){
        super();
        this.support = new PropertyChangeSupport(this);
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
        this.fillProportion = Math.max(0, Math.min(1, fillProportion));
    }

    public double getStartAngle() {
        return startAngle;
    }

    public void setStartAngle(double startAngle) {
        double angle = Math.min(360, Math.max(0, openAngle));
        this.startAngle = angle;
    }

    public double getOpenAngle() {
        return openAngle;
    }

    public void setOpenAngle(double openAngle) {
        double angle = Math.min(360, Math.max(0, openAngle));
        this.openAngle = angle;
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
        Area quarterCircle = new Area(new Arc2D.Double(0, 0, getWidth(), getHeight(), startAngle, openAngle, Arc2D.PIE));
        Area center = new Area(new Ellipse2D.Double(getWidth() / 2 - getWidth() / 2 * fillProportion, 
                getHeight() / 2 - getHeight() / 2 * fillProportion, 
                getWidth() * fillProportion, 
                getHeight() * fillProportion));
        
        quarterCircle.subtract(center);
        
        g2.setColor(getColor());
        g2.fill(quarterCircle);
        
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(5));
        g2.draw(quarterCircle);
        
        g2.setColor(oldColor);
    }

    @Override
    public boolean contains(int x, int y) {
        double a2 = Math.pow(this.getWidth()/2, 2);
        double b2 = Math.pow(this.getHeight()/2, 2);
        double bigEllipse = Math.pow(x - this.getWidth()/2, 2) / a2 + Math.pow(y - this.getHeight()/2, 2) / b2;
        double internalA2 = Math.pow(this.getWidth() * fillProportion / 2, 2);
        double internalB2 = Math.pow(this.getHeight() * fillProportion / 2, 2);
        double internalEllipse = Math.pow(x - this.getWidth()/2, 2) / internalA2 + Math.pow(y - this.getHeight()/2, 2) / internalB2;
        double angle = (Math.atan2(-y + this.getHeight() / 2, x - this.getWidth() / 2) * 180 / Math.PI + 360) % 360;
        
        return ((bigEllipse <= 1)
                && (internalEllipse > 1)
                && angle >= startAngle
                && angle <= (startAngle + openAngle) % 360);
    }
    
        @Override
    public Dimension getPreferredSize() {
        return new Dimension(150, 150);
    }
    
    
    
}
