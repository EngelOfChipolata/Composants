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
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
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
    PopUpPieMenu shapePieMenu;
    PopUpPieMenu jlabelPieMenu;

    Shape selectedShape;
    JLabel selectedJLabel;

    public TestFrame() {
        initComponents();

        MouseListener popupListener = new PopupListener();
        addMouseListener(popupListener);
        jPanel1.addMouseListener(popupListener);
        jLabel1.addMouseListener(popupListener);
        jLabel2.addMouseListener(popupListener);
        jLabel3.addMouseListener(popupListener);
        shape1.addMouseListener(popupListener);
        shape2.addMouseListener(popupListener);
        shape3.addMouseListener(popupListener);

        shapePieMenu = new PopUpPieMenu(0.8);
        PieMenuItem item1 = new PieMenuItem("Bleu", Color.BLUE);
        item1.addMouseListener((event) -> {
            selectedShape.setColor(Color.BLUE);
            shapePieMenu.hidePopup();
        });
        shapePieMenu.add(item1);
        PieMenuItem item2 = new PieMenuItem("Vert", Color.GREEN);
        item2.addMouseListener((event) -> {
            selectedShape.setColor(Color.GREEN);
            shapePieMenu.hidePopup();
        });
        shapePieMenu.add(item2);
        PieMenuItem item3 = new PieMenuItem("Rouge", Color.RED);
        item3.addMouseListener((event) -> {
            selectedShape.setColor(Color.RED);
            shapePieMenu.hidePopup();
        });
        shapePieMenu.add(item3);
        PieMenuItem item4 = new PieMenuItem("Jaune", Color.YELLOW);
        item4.addMouseListener((event) -> {
            selectedShape.setColor(Color.YELLOW);
            shapePieMenu.hidePopup();
        });
        shapePieMenu.add(item4);

        jlabelPieMenu = new PopUpPieMenu(0.8);
        PieMenuItem item5 = new PieMenuItem("\"Coucou\"");
        item5.addMouseListener((event) -> {
            selectedJLabel.setText("Bonjour");
            jlabelPieMenu.hidePopup();
        });
        jlabelPieMenu.add(item5);
        PieMenuItem item6 = new PieMenuItem("\"M2IHM\"");
        item6.addMouseListener((event) -> {
            selectedJLabel.setText("M2IHM FTW !");
            jlabelPieMenu.hidePopup();
        });
        jlabelPieMenu.add(item6);
        PieMenuItem item7 = new PieMenuItem("\"Nicolas\"");
        item7.addMouseListener((event) -> {
            selectedJLabel.setText("Nicolas Dzieciol");
            jlabelPieMenu.hidePopup();
        });
        jlabelPieMenu.add(item7);
        PieMenuItem item8 = new PieMenuItem("\"Guilhem\"");
        item8.addMouseListener((event) -> {
            selectedJLabel.setText("Guilhem Buisan");
            jlabelPieMenu.hidePopup();
        });
        jlabelPieMenu.add(item8);
        PieMenuItem item9 = new PieMenuItem("\"Tarte Menu\"");
        item9.addMouseListener((event) -> {
            selectedJLabel.setText("Miam");
            jlabelPieMenu.hidePopup();
        });
        jlabelPieMenu.add(item9);

    }

    class PopupListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (shapePieMenu.isShowing()) {
                shapePieMenu.hidePopup();
            }
            if (jlabelPieMenu.isShowing()) {
                jlabelPieMenu.hidePopup();
            }
            if (e.getButton() == MouseEvent.BUTTON3) {

                if (e.getSource() instanceof Shape) {
                    selectedShape = (Shape) (e.getSource());
                    selectedJLabel = null;
                    shapePieMenu.showPopup(selectedShape, e.getXOnScreen(), e.getYOnScreen());
                } else if (e.getSource() instanceof JLabel) {
                    selectedShape = null;
                    selectedJLabel = (JLabel)(e.getSource());
                    jlabelPieMenu.showPopup(selectedJLabel, e.getXOnScreen(), e.getYOnScreen());
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

        jPanel1 = new javax.swing.JPanel();
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3772, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(146, 146, 146)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(shape2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(shape1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(70, 70, 70)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(93, 93, 93)
                            .addComponent(shape3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addContainerGap(3214, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 678, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(87, 87, 87)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(48, 48, 48)
                                    .addComponent(shape2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel1))
                            .addGap(14, 14, 14)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(47, 47, 47)
                                    .addComponent(jLabel2))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addComponent(shape1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addComponent(shape3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(353, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private javax.swing.JPanel jPanel1;
    private fr.ups.m2ihm.bean.shape.Shape shape1;
    private fr.ups.m2ihm.bean.shape.Shape shape2;
    private fr.ups.m2ihm.bean.shape.Shape shape3;
    // End of variables declaration//GEN-END:variables
}
