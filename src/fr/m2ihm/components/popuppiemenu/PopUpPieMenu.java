/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m2ihm.components.popuppiemenu;

import fr.m2ihm.components.piemenuitem.PieMenuItem;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.Popup;
import javax.swing.PopupFactory;

/**
 *
 * @author buisangu
 */
public class PopUpPieMenu extends JLayeredPane{
    
    private enum State{
        HIDING,
        SHOWING
    }
    
    private State state;
    private List<PieMenuItem> items;
    private double fillProportion;
    private Popup popup;
    
    public PopUpPieMenu(){
        this(0.5);
    }
    
    public PopUpPieMenu(double fillProportion){
        if (fillProportion > 1 || fillProportion <=0){
            throw new RuntimeException("Cannot create a pie menu with a fill > 1 or <= 0 !");
        }
        this.fillProportion = 1-fillProportion;
        items = new ArrayList<>();
        state = State.HIDING;
        popup = null;
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
    
    public List<PieMenuItem> getMenuItems(){
        return items;
    }
    
    public void showPopup(JComponent parent, int x, int y){
        switch (state){
            case HIDING:
                popup = PopupFactory.getSharedInstance().getPopup(parent, this, x - getPreferredSize().width / 2, y - getPreferredSize().height / 2);
                popup.show();
                state = State.SHOWING;
                break;
            case SHOWING:
                popup.hide();
                popup = null;
                popup = PopupFactory.getSharedInstance().getPopup(parent, this, x - getPreferredSize().width / 2, y - getPreferredSize().height / 2);
                popup.show();
                state = State.SHOWING;
                break;
            default:
                throw new AssertionError(state.name());
            
        }        
    }
    
    public void hidePopup(){
        switch(state){
            case HIDING:
                //Rien
                break;
            case SHOWING:
                popup.hide();
                state = State.HIDING;
                break;
            default:
                throw new AssertionError(state.name());
            
        }
    }
    
    public boolean isShowing(){
        return (state == State.SHOWING);
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
            maxWidth = Math.max(maxWidth, b.getPreferredSize().width);
            maxHeight = Math.max(maxHeight, b.getPreferredSize().height);
        }
        return new Dimension(maxWidth, maxHeight);
    }
    
}
