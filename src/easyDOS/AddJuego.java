/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyDOS;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.TransferHandler;

/**
 *
 * @author josel
 */
public class AddJuego extends javax.swing.JFrame {

    JFileChooser fc = new JFileChooser();
    String _urlJuego = "";
    Auxiliares aux = new Auxiliares();

    /**
     * Creates new form AddJuego
     */
    public AddJuego() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        initComponents();
        setResizable(false);
        modifyFile();
        btnAceptPath.setText("Add exe file");
        BufferedImage img = aux.loadImage("/img/exe.png");
        ImageIcon icon = new ImageIcon(img);
        btnAceptPath.setIcon(icon);
        btnAceptPath.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.pack();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dragZone = new javax.swing.JLabel();
        btnAceptPath = new keeptoo.KButton();
        btnSearch = new keeptoo.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Añadir nuevo juego");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        dragZone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dragZone.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Drag-Drop-macro.png"))); // NOI18N
        getContentPane().add(dragZone, java.awt.BorderLayout.CENTER);

        btnAceptPath.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Aceptar.png"))); // NOI18N
        btnAceptPath.setText("   Accept");
        btnAceptPath.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAceptPath.setkEndColor(new java.awt.Color(153, 0, 153));
        btnAceptPath.setkHoverEndColor(new java.awt.Color(153, 153, 255));
        btnAceptPath.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnAceptPath.setkHoverStartColor(new java.awt.Color(153, 153, 255));
        btnAceptPath.setkSelectedColor(new java.awt.Color(102, 102, 255));
        btnAceptPath.setkStartColor(new java.awt.Color(102, 204, 255));
        btnAceptPath.setMargin(new java.awt.Insets(14, 14, 2, 14));
        btnAceptPath.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptPathMouseClicked(evt);
            }
        });
        btnAceptPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptPathActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptPath, java.awt.BorderLayout.PAGE_END);

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnSearch.setText("   Search");
        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSearch.setkEndColor(new java.awt.Color(153, 0, 153));
        btnSearch.setkHoverEndColor(new java.awt.Color(153, 153, 255));
        btnSearch.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btnSearch.setkHoverStartColor(new java.awt.Color(153, 153, 255));
        btnSearch.setkSelectedColor(new java.awt.Color(102, 102, 255));
        btnSearch.setkStartColor(new java.awt.Color(102, 204, 255));
        btnSearch.setMargin(new java.awt.Insets(14, 14, 2, 14));
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void btnAceptPathMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptPathMouseClicked
            // TODO add your handling code here:
            String action = btnAceptPath.getText();
            if (action.equals("Accept")) {
                this.setTitle(_urlJuego);
                this.dispose();
            }
	}//GEN-LAST:event_btnAceptPathMouseClicked

	private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
            // TODO add your handling code here:
            this.setTitle("Error");
            this.dispose();
	}//GEN-LAST:event_formWindowClosing

	private void btnAceptPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptPathActionPerformed
            // TODO add your handling code here:
	}//GEN-LAST:event_btnAceptPathActionPerformed

	private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
            // TODO add your handling code here:
	}//GEN-LAST:event_btnSearchMouseClicked

	private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
            // TODO add your handling code here:
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File f = fc.getSelectedFile();
                String extension = aux.getFileExtension(f);
                checkFiles(extension, f);
            }
	}//GEN-LAST:event_btnSearchActionPerformed
    public void checkFiles(String extension, File f) {
        btnAceptPath.setVisible(true);
        if (extension.equals("exe") || extension.equals("EXE")) {
            BufferedImage img = aux.loadImage("/img/validate.png");
            ImageIcon validate = new ImageIcon(img);
            dragZone.setIcon(validate);
            btnAceptPath.setText("Accept");
            _urlJuego = f.toString();
            _urlJuego = _urlJuego.replace('\\', '/');
            BufferedImage aceptar = aux.loadImage("/img/Aceptar.png");
            ImageIcon icon = new ImageIcon(aceptar);
            btnAceptPath.setIcon(icon);
            btnAceptPath.setActionCommand("Validate");
        } else {
            btnAceptPath.setText("Exe not found");
            BufferedImage img = aux.loadImage("/img/notExe.png");
            ImageIcon validate = new ImageIcon(img);
            dragZone.setIcon(validate);
            img = aux.loadImage("/img/cross.png");
            ImageIcon icon = new ImageIcon(img);
            btnAceptPath.setIcon(icon);
        }
    }

    public final void modifyFile() {
        TransferHandler th = new TransferHandler() {
            @Override
            public boolean canImport(JComponent comp, DataFlavor[] trasferFlavors) {
                return true;
            }

            @Override
            public boolean importData(JComponent comp, Transferable t) {
                try {
                    List<File> files = (List<File>) t.getTransferData(DataFlavor.javaFileListFlavor);
                    if (files.size() == 1) {
                        File f = files.get(0);
                        String extension = aux.getFileExtension(f);//Obtenemos la extension del fichero
                        checkFiles(extension, f);
                    }
                } catch (UnsupportedFlavorException ex) {
                    System.out.println(ex);
                } catch (IOException ex) {
                    System.out.println(ex);
                }
                return true;
            }
        };
        dragZone.setTransferHandler(th);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KButton btnAceptPath;
    private keeptoo.KButton btnSearch;
    private javax.swing.JLabel dragZone;
    // End of variables declaration//GEN-END:variables
}
