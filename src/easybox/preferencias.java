/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package easybox;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;

/**
 *
 * @author Carlos
 */
public class preferencias extends javax.swing.JFrame {

    String fullscreen;
    int sensitivity;
    String core;
    String output;
    
    public preferencias() {
        initComponents();
        setTitle("Preferencias");
        setResizable(false);
        try {
            lectura_fichero();
        } catch (IOException ex) {
            Logger.getLogger(preferencias.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    void lectura_fichero() throws FileNotFoundException, IOException{
       
        String[] parts;
        
        String file = getClass().getClassLoader().getResource("./dosBOX/Data/settings/dosbox.conf").getPath();     
        file = file.substring(1, file.length()); //Eliminamos la /inicial que encontramos al obtener la ruta
        
        FileReader f = new FileReader(file);
        BufferedReader b = new BufferedReader(f);
        String cadena = b.readLine();
        while(cadena != null){
           parts = cadena.split("=");
            if( parts[0].equals("fullscreen"))
            {
                if(parts[1].equals("false"))
                {
                    btnFullScreenNo.setBackground(Color.green);
                    btnFullScreenYes.setBackground(Color.red);
                    fullscreen="false";
                }
                else
                {
                    btnFullScreenNo.setBackground(Color.red);
                    btnFullScreenYes.setBackground(Color.green);
                    fullscreen="true";
                }
            }
            
            if(parts[0].equals("sensitivity"))
            {
                if(parts[1].equals("50"))
                {
                    btnMouseSensivity50.setBackground(Color.green);
                    btnMouseSensivity100.setBackground(Color.red);
                    btnMouseSensivity150.setBackground(Color.red);
                    btnMouseSensivity200.setBackground(Color.red);
                    sensitivity=50;
                }
                else if(parts[1].equals("100"))
                {
                    btnMouseSensivity50.setBackground(Color.red);
                    btnMouseSensivity100.setBackground(Color.green);
                    btnMouseSensivity150.setBackground(Color.red);
                    btnMouseSensivity200.setBackground(Color.red);
                    sensitivity=100;
                }
                else if(parts[1].equals("150"))
                {
                    btnMouseSensivity50.setBackground(Color.red);
                    btnMouseSensivity100.setBackground(Color.red);
                    btnMouseSensivity150.setBackground(Color.green);
                    btnMouseSensivity200.setBackground(Color.red);
                    sensitivity=150;
                }
                else if(parts[1].equals("200"))
                {
                    btnMouseSensivity50.setBackground(Color.red);
                    btnMouseSensivity100.setBackground(Color.red);
                    btnMouseSensivity150.setBackground(Color.red);
                    btnMouseSensivity200.setBackground(Color.green);
                    sensitivity=200;
                }
            }
            if(parts[0].equals("core"))
            {
                if(parts[1].equals("auto"))
                {
                    btnCpuAuto.setBackground(Color.green);
                    btnCpuNormal.setBackground(Color.red);
                    btnCpuSimple.setBackground(Color.red);
                    btnCpuDina.setBackground(Color.red);
                    core="auto";
                }
                else if(parts[1].equals("normal"))
                {
                    btnCpuAuto.setBackground(Color.red);
                    btnCpuNormal.setBackground(Color.green);
                    btnCpuSimple.setBackground(Color.red);
                    btnCpuDina.setBackground(Color.red);
                    core="normal";
                }
                else if(parts[1].equals("simple"))
                {
                    btnCpuAuto.setBackground(Color.red);
                    btnCpuNormal.setBackground(Color.red);
                    btnCpuSimple.setBackground(Color.green);
                    btnCpuDina.setBackground(Color.red);
                    core="simple";
                }
                else if(parts[1].equals("dynamic"))
                {
                    btnCpuAuto.setBackground(Color.red);
                    btnCpuNormal.setBackground(Color.red);
                    btnCpuSimple.setBackground(Color.red);
                    btnCpuDina.setBackground(Color.green);
                    core="dynamic";
                }
            }
            if(parts[0].equals("output"))
            {
                if(parts[1].equals("surface"))
                {
                    btnRenderNormal.setBackground(Color.green);
                    btnRenderOpen.setBackground(Color.red);
                    btnRenderDir.setBackground(Color.red);
                    output="surface";
                }
                else if(parts[1].equals("opengl"))
                {
                    btnRenderNormal.setBackground(Color.red);
                    btnRenderOpen.setBackground(Color.green);
                    btnRenderDir.setBackground(Color.red);
                    output="opengl";
                }
                else if(parts[1].equals("ddraw"))
                {
                    btnRenderNormal.setBackground(Color.red);
                    btnRenderOpen.setBackground(Color.red);
                    btnRenderDir.setBackground(Color.green);
                    output="ddraw";
                }
            }
            cadena = b.readLine();
        }
        b.close();
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnFullScreenYes = new javax.swing.JButton();
        btnFullScreenNo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnMouseSensivity50 = new javax.swing.JButton();
        btnMouseSensivity100 = new javax.swing.JButton();
        btnMouseSensivity150 = new javax.swing.JButton();
        btnMouseSensivity200 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnCpuAuto = new javax.swing.JButton();
        btnCpuNormal = new javax.swing.JButton();
        btnCpuSimple = new javax.swing.JButton();
        btnCpuDina = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnRenderOpen = new javax.swing.JButton();
        btnRenderDir = new javax.swing.JButton();
        btnRenderNormal = new javax.swing.JButton();
        btnAcceptChanges = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("Preferencias");

        jLabel2.setText("Pantalla Completa");

        btnFullScreenYes.setText("SI");
        btnFullScreenYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFullScreenYesActionPerformed(evt);
            }
        });

        btnFullScreenNo.setText("NO");
        btnFullScreenNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFullScreenNoActionPerformed(evt);
            }
        });

        jLabel3.setText("Sensibilidad del ratón");

        btnMouseSensivity50.setText("50");
        btnMouseSensivity50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMouseSensivity50ActionPerformed(evt);
            }
        });

        btnMouseSensivity100.setText("100");
        btnMouseSensivity100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMouseSensivity100ActionPerformed(evt);
            }
        });

        btnMouseSensivity150.setText("150");
        btnMouseSensivity150.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMouseSensivity150ActionPerformed(evt);
            }
        });

        btnMouseSensivity200.setText("200");
        btnMouseSensivity200.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMouseSensivity200ActionPerformed(evt);
            }
        });

        jLabel4.setText("Tipo de CPU");

        btnCpuAuto.setText("AUTO");
        btnCpuAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCpuAutoActionPerformed(evt);
            }
        });

        btnCpuNormal.setText("NORMAL");
        btnCpuNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCpuNormalActionPerformed(evt);
            }
        });

        btnCpuSimple.setText("SIMPLE");
        btnCpuSimple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCpuSimpleActionPerformed(evt);
            }
        });

        btnCpuDina.setText("DINAMICA");
        btnCpuDina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCpuDinaActionPerformed(evt);
            }
        });

        jLabel5.setText("Renderizado");

        btnRenderOpen.setText("OPENGL");
        btnRenderOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRenderOpenActionPerformed(evt);
            }
        });

        btnRenderDir.setText("DIRECTX");
        btnRenderDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRenderDirActionPerformed(evt);
            }
        });

        btnRenderNormal.setText("NORMAL");
        btnRenderNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRenderNormalActionPerformed(evt);
            }
        });

        btnAcceptChanges.setText("ACEPTAR");
        btnAcceptChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptChangesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGap(153, 153, 153))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnCpuAuto)
                                        .addGap(2, 2, 2)))))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnFullScreenYes, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnFullScreenNo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnMouseSensivity50)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnMouseSensivity100)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnMouseSensivity150)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnMouseSensivity200))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCpuNormal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCpuSimple)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCpuDina)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRenderNormal)
                        .addGap(18, 18, 18)
                        .addComponent(btnRenderDir)
                        .addGap(18, 18, 18)
                        .addComponent(btnRenderOpen)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(btnAcceptChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnFullScreenYes)
                    .addComponent(btnFullScreenNo))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnMouseSensivity50)
                    .addComponent(btnMouseSensivity100)
                    .addComponent(btnMouseSensivity150)
                    .addComponent(btnMouseSensivity200))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btnCpuAuto)
                    .addComponent(btnCpuNormal)
                    .addComponent(btnCpuSimple)
                    .addComponent(btnCpuDina))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRenderOpen)
                        .addComponent(btnRenderDir)
                        .addComponent(btnRenderNormal)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnAcceptChanges)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFullScreenYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFullScreenYesActionPerformed
        btnFullScreenYes.setBackground(Color.green);
        btnFullScreenNo.setBackground(Color.red);
        fullscreen="true";
    }//GEN-LAST:event_btnFullScreenYesActionPerformed

    private void btnFullScreenNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFullScreenNoActionPerformed
        btnFullScreenYes.setBackground(Color.red);
        btnFullScreenNo.setBackground(Color.green);
        fullscreen="false";
    }//GEN-LAST:event_btnFullScreenNoActionPerformed

    private void btnMouseSensivity50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMouseSensivity50ActionPerformed
        btnMouseSensivity50.setBackground(Color.green);
        btnMouseSensivity100.setBackground(Color.red);
        btnMouseSensivity150.setBackground(Color.red);
        btnMouseSensivity200.setBackground(Color.red);
        sensitivity=50;
    }//GEN-LAST:event_btnMouseSensivity50ActionPerformed

    private void btnMouseSensivity100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMouseSensivity100ActionPerformed
        btnMouseSensivity50.setBackground(Color.red);
        btnMouseSensivity100.setBackground(Color.green);
        btnMouseSensivity150.setBackground(Color.red);
        btnMouseSensivity200.setBackground(Color.red);
        sensitivity=100;
    }//GEN-LAST:event_btnMouseSensivity100ActionPerformed

    private void btnMouseSensivity150ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMouseSensivity150ActionPerformed
        btnMouseSensivity50.setBackground(Color.red);
        btnMouseSensivity100.setBackground(Color.red);
        btnMouseSensivity150.setBackground(Color.green);
        btnMouseSensivity200.setBackground(Color.red);
        sensitivity=150;
    }//GEN-LAST:event_btnMouseSensivity150ActionPerformed

    private void btnMouseSensivity200ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMouseSensivity200ActionPerformed
        btnMouseSensivity50.setBackground(Color.red);
        btnMouseSensivity100.setBackground(Color.red);
        btnMouseSensivity150.setBackground(Color.red);
        btnMouseSensivity200.setBackground(Color.green);
        sensitivity=200;
    }//GEN-LAST:event_btnMouseSensivity200ActionPerformed

    private void btnCpuAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCpuAutoActionPerformed
        btnCpuAuto.setBackground(Color.green);
        btnCpuNormal.setBackground(Color.red);
        btnCpuSimple.setBackground(Color.red);
        btnCpuDina.setBackground(Color.red);
        core="auto";
    }//GEN-LAST:event_btnCpuAutoActionPerformed

    private void btnCpuNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCpuNormalActionPerformed
        btnCpuAuto.setBackground(Color.red);
        btnCpuNormal.setBackground(Color.green);
        btnCpuSimple.setBackground(Color.red);
        btnCpuDina.setBackground(Color.red);
        core="normal";
    }//GEN-LAST:event_btnCpuNormalActionPerformed

    private void btnCpuSimpleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCpuSimpleActionPerformed
        btnCpuAuto.setBackground(Color.red);
        btnCpuNormal.setBackground(Color.red);
        btnCpuSimple.setBackground(Color.green);
        btnCpuDina.setBackground(Color.red);
        core="simple";
    }//GEN-LAST:event_btnCpuSimpleActionPerformed

    private void btnCpuDinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCpuDinaActionPerformed
        btnCpuAuto.setBackground(Color.red);
        btnCpuNormal.setBackground(Color.red);
        btnCpuSimple.setBackground(Color.red);
        btnCpuDina.setBackground(Color.green);
        core="dynamic";
    }//GEN-LAST:event_btnCpuDinaActionPerformed

    private void btnRenderOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRenderOpenActionPerformed
        btnRenderNormal.setBackground(Color.red);
        btnRenderDir.setBackground(Color.red);
        btnRenderOpen.setBackground(Color.green);
        output="opengl";
    }//GEN-LAST:event_btnRenderOpenActionPerformed

    private void btnRenderDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRenderDirActionPerformed
        btnRenderNormal.setBackground(Color.red);
        btnRenderDir.setBackground(Color.green);
        btnRenderOpen.setBackground(Color.red);
        output="ddraw";
    }//GEN-LAST:event_btnRenderDirActionPerformed

    private void btnRenderNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRenderNormalActionPerformed
        btnRenderNormal.setBackground(Color.green);
        btnRenderDir.setBackground(Color.red);
        btnRenderOpen.setBackground(Color.red);
        output="surface";
    }//GEN-LAST:event_btnRenderNormalActionPerformed

    private void btnAcceptChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptChangesActionPerformed
        try {
            saveOpts();
        } catch (IOException ex) {
            Logger.getLogger(preferencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAcceptChangesActionPerformed

    private void saveOpts() throws FileNotFoundException, IOException
    {
       //FICHERO INICIAL
        String file = getClass().getClassLoader().getResource("./dosBOX/Data/settings/dosbox.conf").getPath();     
        file = file.substring(1, file.length()); //Eliminamos la /inicial que encontramos al obtener la ruta
        FileReader f = new FileReader(file);
        BufferedReader b = new BufferedReader(f);
        String cadena;
        
        //FICHERO AUXILIAR
           
        String url = getClass().getClassLoader().getResource("./dosBOX/Data/settings/").getPath();
        url = url + "temp.conf";
        url = url.substring(1, url.length());

            File file2 = new File(url);
            file2.createNewFile();
        
        FileWriter fw = new FileWriter(file2);
        
        String[] parts;
        
        while((cadena = b.readLine()) != null){
            
            parts=cadena.split("=");
            if(parts[0].equals("fullscreen"))
            {
                fw.append("fullscreen="+fullscreen+"\n");
            }
            else if(parts[0].equals("sensitivity"))
            {
                fw.append("sensitivity="+Integer.toString(sensitivity)+"\n");
            }
            else if(parts[0].equals("core"))
            {
                fw.append("core="+core+"\n");
            }
            else if(parts[0].equals("output"))
            {
                fw.append("output="+output+"\n");
            }
            else
            {
                fw.append(cadena+"\n");
            }
            
        }
        
        b.close();
        fw.close();
        
        File antiguo= new File(file);
        antiguo.delete();
        
        File nuevo = new File(url);
        boolean success = nuevo.renameTo(antiguo);

        
      
    }
    
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
            java.util.logging.Logger.getLogger(preferencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(preferencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(preferencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(preferencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new preferencias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bg;
    private javax.swing.JButton btnAcceptChanges;
    private javax.swing.JButton btnCpuAuto;
    private javax.swing.JButton btnCpuDina;
    private javax.swing.JButton btnCpuNormal;
    private javax.swing.JButton btnCpuSimple;
    private javax.swing.JButton btnFullScreenNo;
    private javax.swing.JButton btnFullScreenYes;
    private javax.swing.JButton btnMouseSensivity100;
    private javax.swing.JButton btnMouseSensivity150;
    private javax.swing.JButton btnMouseSensivity200;
    private javax.swing.JButton btnMouseSensivity50;
    private javax.swing.JButton btnRenderDir;
    private javax.swing.JButton btnRenderNormal;
    private javax.swing.JButton btnRenderOpen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
