/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m2ihm.components;

import fr.m2ihm.components.curbedbutton.CurvedButton;
import fr.m2ihm.components.curbedbuttontext.PieMenuItem;
import fr.m2ihm.components.popuppiemenu.PopUpPieMenu;
import fr.ups.m2ihm.bean.shape.Shape;
import fr.ups.m2ihm.bean.shape.ShapeLabel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.Popup;
import javax.swing.PopupFactory;

/**
 *
 * @author buisangu
 */
public class TestFrame extends javax.swing.JFrame {

    /**
     * Creates new form TestFrame
     */
    Popup shapeLabelPopup;

    public TestFrame() {
        initComponents();

        MouseListener popupListener = new PopupListener();
        addMouseListener(popupListener);
        shape1.addMouseListener(popupListener);
        shape2.addMouseListener(popupListener);
        shape3.addMouseListener(popupListener);
        curvedButton1.addMouseListener(popupListener);
        curvedButton2.addMouseListener(popupListener);
    }

    class PopupListener extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            if (shapeLabelPopup != null) {
                shapeLabelPopup.hide();
            }
            if (e.getButton() == MouseEvent.BUTTON3) {

                if (e.getSource() instanceof Shape) {
                    Shape source = (Shape) e.getSource();
                    PopUpPieMenu shapeLabelPieMenu = new PopUpPieMenu();
                    PieMenuItem item1 = new PieMenuItem("Bleu");
                    item1.addMouseListener((event) -> {
                        source.setColor(Color.BLUE);
                        shapeLabelPopup.hide();
                    });
                    shapeLabelPieMenu.add(item1);
                    PieMenuItem item2 = new PieMenuItem("Vert");
                    item2.addMouseListener((event) -> {
                        source.setColor(Color.GREEN);
                        shapeLabelPopup.hide();
                    });
                    shapeLabelPieMenu.add(item2);
                    PieMenuItem item3 = new PieMenuItem("Rouge");
                    item3.addMouseListener((event) -> {
                        source.setColor(Color.RED);
                        shapeLabelPopup.hide();
                    });
                    shapeLabelPieMenu.add(item3);
                    PieMenuItem item4 = new PieMenuItem("Jaune");
                    item4.addMouseListener((event) -> {
                        source.setColor(Color.YELLOW);
                        shapeLabelPopup.hide();
                    });
                    shapeLabelPieMenu.add(item4);
                    shapeLabelPopup = PopupFactory.getSharedInstance().getPopup(e.getComponent(), shapeLabelPieMenu, e.getXOnScreen() - shapeLabelPieMenu.getPreferredSize().width / 2, e.getYOnScreen() - shapeLabelPieMenu.getPreferredSize().height / 2);
                    shapeLabelPopup.show();
                }else if (e.getSource() instanceof CurvedButton){
                    CurvedButton source = (CurvedButton) e.getSource();
                    PopUpPieMenu shapeLabelPieMenu = new PopUpPieMenu();
                    PieMenuItem item2 = new PieMenuItem("45°");
                    item2.addMouseListener((event) -> {
                        source.setOpenAngle(45);
                        shapeLabelPopup.hide();
                    });
                    shapeLabelPieMenu.add(item2);
                    PieMenuItem item3 = new PieMenuItem("90°");
                    item3.addMouseListener((event) -> {
                        source.setOpenAngle(90);
                        shapeLabelPopup.hide();
                    });
                    shapeLabelPieMenu.add(item3);
                    PieMenuItem item4 = new PieMenuItem("135°");
                    item4.addMouseListener((event) -> {
                        source.setOpenAngle(135);
                        shapeLabelPopup.hide();
                    });
                    shapeLabelPieMenu.add(item4);
                    PieMenuItem item5 = new PieMenuItem("180°");
                    item5.addMouseListener((event) -> {
                        source.setOpenAngle(180);
                        shapeLabelPopup.hide();
                    });
                    shapeLabelPieMenu.add(item5);
                    PieMenuItem item6 = new PieMenuItem("225°");
                    item6.addMouseListener((event) -> {
                        source.setOpenAngle(225);
                        shapeLabelPopup.hide();
                    });
                    shapeLabelPieMenu.add(item6);
                    PieMenuItem item7 = new PieMenuItem("270°");
                    item7.addMouseListener((event) -> {
                        source.setOpenAngle(270);
                        shapeLabelPopup.hide();
                    });
                    shapeLabelPieMenu.add(item7);
                    PieMenuItem item8 = new PieMenuItem("315°");
                    item8.addMouseListener((event) -> {
                        source.setOpenAngle(315);
                        shapeLabelPopup.hide();
                    });
                    shapeLabelPieMenu.add(item8);
                    shapeLabelPopup = PopupFactory.getSharedInstance().getPopup(e.getComponent(), shapeLabelPieMenu, e.getXOnScreen() - shapeLabelPieMenu.getPreferredSize().width / 2, e.getYOnScreen() - shapeLabelPieMenu.getPreferredSize().height / 2);
                    shapeLabelPopup.show();
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        shape1 = new fr.ups.m2ihm.bean.shape.Shape();
        shape2 = new fr.ups.m2ihm.bean.shape.Shape();
        shape3 = new fr.ups.m2ihm.bean.shape.Shape();
        curvedButton1 = new fr.m2ihm.components.curbedbutton.CurvedButton();
        curvedButton2 = new fr.m2ihm.components.curbedbutton.CurvedButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(shape2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(shape3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(shape1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(curvedButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(curvedButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(3185, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(shape1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(curvedButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(curvedButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(shape3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)
                        .addComponent(shape2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(336, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestFrame().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private fr.m2ihm.components.curbedbutton.CurvedButton curvedButton1;
    private fr.m2ihm.components.curbedbutton.CurvedButton curvedButton2;
    private fr.ups.m2ihm.bean.shape.Shape shape1;
    private fr.ups.m2ihm.bean.shape.Shape shape2;
    private fr.ups.m2ihm.bean.shape.Shape shape3;
    // End of variables declaration//GEN-END:variables
}
