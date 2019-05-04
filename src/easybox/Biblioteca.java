/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package easybox;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author josel
 */
public class Biblioteca extends JPanel {
    private ArrayList<Object> _listaJuegos = new ArrayList<>(); //Usamos un arrayList para almacenas las rutas de imagenes
    
    public Biblioteca() {        
        try {
            this.lectura_fichero();
        } catch (IOException ex) {
            Logger.getLogger(Biblioteca.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        setLayout(new java.awt.GridLayout(_listaJuegos.size()/3, 4)); //Establecemos la rejilla a size/4, 4
        for (int i = 0; i < _listaJuegos.size(); ++i) {           
            Juego g = (Juego) _listaJuegos.get(i);
            ImageIcon icon = new ImageIcon(getClass().getResource(g.getImagen()));
            
            JLabel label = new JLabel(icon);
            Border border = label.getBorder();
            Border margin = new EmptyBorder(1,1,1,1);
            label.setBorder(new CompoundBorder(border, margin));
            
            //Permite abrir la información del juego añadiendo un eventListener
            label.addMouseListener(new MouseAdapter() {
              public void mouseClicked(MouseEvent me) {
                InfoJuego frame = new InfoJuego(g);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);                 
              }
            });                        
            add(label);
        }

    }
    void lectura_fichero() throws FileNotFoundException, IOException{
        //Lectura del fichero de listado de juegos
        String file = getClass().getClassLoader().getResource("./Juegos/listado_juegos.txt").getPath();     
        file = file.substring(1, file.length()); //Eliminamos la /inicial que encontramos al obtener la ruta
        
        FileReader f = new FileReader(file);
        BufferedReader b = new BufferedReader(f);
        String cadena = b.readLine();
        int id = 0;
        while(cadena != null){
            String Nombre = cadena;
            String Compania = b.readLine();
            String Desarrollador = b.readLine();
            String Tipo = b.readLine();
            String Descrip = b.readLine();   
            String imagen = b.readLine();
            Juego game = new Juego(id, Nombre, Desarrollador, Compania, Tipo, Descrip, imagen);
            _listaJuegos.add(game);
            id++;
            cadena = b.readLine();
        }
        b.close();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(new Dimension(300, 300));
            frame.add(new Biblioteca());
            frame.setVisible(true);
        });
    }
}   