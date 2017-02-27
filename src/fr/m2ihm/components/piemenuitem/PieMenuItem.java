/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m2ihm.components.piemenuitem;

import fr.m2ihm.components.curbedbutton.CurvedButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

/**
 *
 * @author buisangu
 */
public class PieMenuItem extends JLayeredPane implements MouseListener{
    private JLabel label;
    private CurvedButton button;
    private List<PieMenuItemListener> eventListeners;
    
    public static final double DEFAULT_FINAL_PROPORTION = 0.5;
    public static final double DEFAULT_START_ANGLE = 0;
    public static final double DEFAULT_OPEN_ANGLE = 90;
    public static final String DEFAULT_TEXT = "default";
    public static final Color DEFAULT_COLOR = Color.PINK;
    
    private enum State{
        IDLE,
        HOVERED
    }
    
    private State state;
    public PieMenuItem(){
        this(DEFAULT_TEXT);
    }
    
    public PieMenuItem(String text){
        this(text, DEFAULT_COLOR);
    }
    
    public PieMenuItem(String text, Color color){
        button = new CurvedButton(color, DEFAULT_FINAL_PROPORTION, DEFAULT_START_ANGLE, DEFAULT_OPEN_ANGLE);
        label = new JLabel(text);
        
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.LEFT);
        
        this.add(button, DEFAULT_LAYER);
        this.add(label, PALETTE_LAYER);
        setLayout(null);
        state = State.IDLE;
        addMouseListener(this);
        eventListeners = new ArrayList<>();
    }
    
    public String getText(){
        return label.getText();
    }
    
    public void setText(String text){
        this.label.setText(text);
        repaint();
    }
    
    public double getFillProportion(){
        return button.getFillProportion();
    }
    
    public void setFillProportion(double prop){
        button.setFillProportion(prop);
        repaint();
    }
    
    public double getOpenAngle(){
        return button.getOpenAngle();
    }
    
    public void setOpenAngle(double angle){
        button.setOpenAngle(angle);
        repaint();
    }
    
    public double getStartAngle(){
        return button.getStartAngle();
    }
    
    public void setStartAngle(double angle){
        button.setStartAngle(angle);
        repaint();
    }
    
    public void setColor(Color c){
        button.setColor(c);
        repaint();
    }
    
    public Color getColor(){
        return button.getColor();
    }
    
    public void addMouseListener(PieMenuItemListener li){
        eventListeners.add(li);
    }
    
    public void removeMouseListener(PieMenuItemListener li){
        eventListeners.remove(li);
    }
    
    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        label.setBounds((int)(width/2 - 6*label.getText().length() / 2 + (width/4 * (1+getFillProportion())) * Math.cos((getStartAngle() + getOpenAngle() / 2) * Math.PI / 180)),
                (int)(height/2 - height/4 * (1+getFillProportion()) * Math.sin((getStartAngle() + getOpenAngle() / 2) * Math.PI / 180)), 8*label.getText().length(), height);
        
        button.setBounds(0, 0, width, height);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Math.max(label.getPreferredSize().width, button.getPreferredSize().width), 
                Math.max(label.getPreferredSize().height, button.getPreferredSize().height));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch(state){
            case HOVERED:
                for (PieMenuItemListener li : eventListeners){
                    li.pieMenuItemClicked(new PieMenuItemEvent(this));
                    this.button.setColor(this.button.getColor().brighter());
                    state = State.IDLE;
                }
            break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        switch (state){
            case IDLE:
                state = State.HOVERED;
                this.button.setColor(this.button.getColor().darker());
                break;
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        switch (state){
            case HOVERED:
                state = State.IDLE;
                this.button.setColor(this.button.getColor().brighter());
                break;
        }    
    }
    
    @Override
    public boolean contains(int x, int y) {
        return button.contains(x, y);
    }
}
