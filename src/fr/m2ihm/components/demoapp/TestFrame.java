/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.m2ihm.components.demoapp;

import fr.m2ihm.components.curbedbutton.CurvedButton;
import fr.m2ihm.components.piemenuitem.PieMenuItem;
import fr.m2ihm.components.popuppiemenu.PopUpPieMenu;
import fr.ups.m2ihm.bean.shape.Shape;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
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
        jLabel1.addMouseListener(popupListener);
        jLabel2.addMouseListener(popupListener);
        jLabel3.addMouseListener(popupListener);
        shape1.addMouseListener(popupListener);
        shape2.addMouseListener(popupListener);
        shape3.addMouseListener(popupListener);
    }

    class PopupListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (shapeLabelPopup != null) {
                shapeLabelPopup.hide();
            }
            if (e.getButton() == MouseEvent.BUTTON3) {

                if (e.getSource() instanceof Shape) {
                    Shape source = (Shape) e.getSource();
                    PopUpPieMenu shapeLabelPieMenu = new PopUpPieMenu(0.8);
                    PieMenuItem item1 = new PieMenuItem("Bleu", Color.BLUE);
                    item1.addMouseListener((event) -> {
                        source.setColor(Color.BLUE);
                        shapeLabelPopup.hide();
                    });
                    shapeLabelPieMenu.add(item1);
                    PieMenuItem item2 = new PieMenuItem("Vert", Color.GREEN);
                    item2.addMouseListener((event) -> {
                        source.setColor(Color.GREEN);
                        shapeLabelPopup.hide();
                    });
                    shapeLabelPieMenu.add(item2);
                    PieMenuItem item3 = new PieMenuItem("Rouge", Color.RED);
                    item3.addMouseListener((event) -> {
                        source.setColor(Color.RED);
                        shapeLabelPopup.hide();
                    });
                    shapeLabelPieMenu.add(item3);
                    PieMenuItem item4 = new PieMenuItem("Jaune", Color.YELLOW);
                    item4.addMouseListener((event) -> {
                        source.setColor(Color.YELLOW);
                        shapeLabelPopup.hide();
                    });
                    shapeLabelPieMenu.add(item4);
                    shapeLabelPopup = PopupFactory.getSharedInstance().getPopup(e.getComponent(), shapeLabelPieMenu, e.getXOnScreen() - shapeLabelPieMenu.getPreferredSize().width / 2, e.getYOnScreen() - shapeLabelPieMenu.getPreferredSize().height / 2);
                    shapeLabelPopup.show();
                }else if (e.getSource() instanceof JLabel){
                    JLabel source = (JLabel) e.getSource();
                    PopUpPieMenu shapeLabelPieMenu = new PopUpPieMenu(0.8);
                    PieMenuItem item1 = new PieMenuItem("\"Coucou\"");
                    item1.addMouseListener((event) -> {
                        source.setText("Bonjour");
                        shapeLabelPopup.hide();
                    });
                    shapeLabelPieMenu.add(item1);
                    PieMenuItem item2 = new PieMenuItem("\"M2IHM\"");
                    item2.addMouseListener((event) -> {
                        source.setText("M2IHM FTW !");
                        shapeLabelPopup.hide();
                    });
                    shapeLabelPieMenu.add(item2);
                    PieMenuItem item3 = new PieMenuItem("\"Nicolas\"");
                    item3.addMouseListener((event) -> {
                        source.setText("Nicolas Dzieciol");
                        shapeLabelPopup.hide();
                    });
                    shapeLabelPieMenu.add(item3);
                    PieMenuItem item4 = new PieMenuItem("\"Guilhem\"");
                    item4.addMouseListener((event) -> {
                        source.setText("Guilhem Buisan");
                        shapeLabelPopup.hide();
                    });
                    shapeLabelPieMenu.add(item4);
                    PieMenuItem item5 = new PieMenuItem("\"Tarte Menu\"");
                    item5.addMouseListener((event) -> {
                        source.setText("Miam");
                        shapeLabelPopup.hide();
                    });
                    shapeLabelPieMenu.add(item5);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        shape1 = new fr.ups.m2ihm.bean.shape.Shape();
        shape2 = new fr.ups.m2ihm.bean.shape.Shape();
        shape3 = new fr.ups.m2ihm.bean.shape.Shape();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(shape2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shape1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(93, 93, 93)
                        .addComponent(shape3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(3309, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(shape2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel1)))
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(shape1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(shape3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(446, Short.MAX_VALUE))
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private fr.ups.m2ihm.bean.shape.Shape shape1;
    private fr.ups.m2ihm.bean.shape.Shape shape2;
    private fr.ups.m2ihm.bean.shape.Shape shape3;
    // End of variables declaration//GEN-END:variables
}
