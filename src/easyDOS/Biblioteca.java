/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package easyDOS;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
	private final ArrayList<Object> _listaJuegosUsuario = new ArrayList<>(); //Usamos un arrayList para almacenas las rutas de imagenes de usuario

	public Biblioteca() {
		try {
			lectura_fichero();
		} catch (IOException ex) {
			Logger.getLogger(Biblioteca.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	void crearBiblioteca() {
		setLayout(new java.awt.GridLayout((int)_listaJuegos.size() / 2, 4)); //Establecemos la rejilla a size/4, 4
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("./img/AddGameUnknown.png").getPath());
		JLabel label = new JLabel(icon);
		Border border = label.getBorder();
		Border margin = new EmptyBorder(2, 2, 2, 2);
		label.setBorder(new CompoundBorder(border, margin));
		label.setToolTipText("Crear mi propia plantilla.");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				Juego g = new Juego();
				InfoJuego frame = new InfoJuego(g, false);
				frame.setVisible(true);
				frame.setTitle("Plantilla por defecto");
				frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		add(label);
		for (int i = 0; i < _listaJuegos.size(); ++i) {
			Juego g = (Juego) _listaJuegos.get(i);
			icon = new ImageIcon(getClass().getResource(g.getImagen()));
			label = new JLabel(icon);
			label.setBorder(new CompoundBorder(border, margin));
			label.setToolTipText("Plantilla para juego " + g.getNombre());
			//Permite abrir la información del juego añadiendo un eventListener
			label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent me) {
					InfoJuego frame = new InfoJuego(g, false);
					frame.setVisible(true);
					frame.setTitle("Información " + g.getNombre());
					frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					frame.addWindowListener(new WindowListener() {
						@Override
						public void windowClosed(WindowEvent e) {
							//Si se ha cerrado la ventana
							try {
								_listaJuegos.clear();
								_listaJuegosUsuario.clear();
								lectura_fichero();
								crearBiblioteca(); //Genero la biblioteca
								getParent().getParent().getParent().setVisible(false);
							} catch (IOException ex) {
								Logger.getLogger(Biblioteca.class.getName()).log(Level.SEVERE, null, ex);
							}
						}
						//Funciones de ventana no usadas para nuestro problema
						@Override
						public void windowIconified(WindowEvent e) {}
						@Override
						public void windowOpened(WindowEvent e) {}
						@Override
						public void windowClosing(WindowEvent e) {}
						@Override
						public void windowDeiconified(WindowEvent e) {}
						@Override
						public void windowActivated(WindowEvent e) {}
						@Override
						public void windowDeactivated(WindowEvent e) {}

					});
				}
			});
			add(label);
		}
		removeDuplicates();
	}

	void getMisJuegos() throws FileNotFoundException, IOException {
		setLayout(new java.awt.GridLayout((int)_listaJuegosUsuario.size() / 2, 4)); //Establecemos la rejilla a size/4, 4
		for (int i = 0; i < _listaJuegosUsuario.size(); ++i) {
			Juego g = (Juego) _listaJuegosUsuario.get(i);
			ImageIcon icon = new ImageIcon(getClass().getResource(g.getImagen()));

			JLabel label = new JLabel(icon);
			Border border = label.getBorder();
			Border margin = new EmptyBorder(2, 2, 2, 2);
			label.setBorder(new CompoundBorder(border, margin));

			//Permite abrir la información del juego añadiendo un eventListener
			label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent me) {
					InfoJuego frame = new InfoJuego(g, true);
					frame.setVisible(true);
					frame.setTitle("Información " + g.getNombre());
					frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				}
			});
			add(label);
		}
	}

	int hasGame(String nombreJuego, ArrayList listado) {
		for (int i = 0; i < listado.size(); i++) {
			Juego g = (Juego) listado.get(i);
			if (g.getNombre().equals(nombreJuego)) {
				return i;
			}
		}
		return -1;
	}

	void lectura_fichero() throws FileNotFoundException, IOException {
		//Lectura del fichero de listado de juegos
		String file = getClass().getClassLoader().getResource("./Juegos/listado_juegos.txt").getPath();
		file = file.substring(1, file.length()); //Eliminamos la /inicial que encontramos al obtener la ruta

		FileReader f = new FileReader(file);
		BufferedReader b = new BufferedReader(f);
		String cadena = b.readLine();
		int id = 0;
		while (cadena != null) {
			String Nombre = cadena;
			String Compania = b.readLine();
			String Desarrollador = b.readLine();
			String Tipo = b.readLine();
			String Descrip = b.readLine();
			String imagen = b.readLine();
			Juego game = new Juego(id, Nombre, Desarrollador, Compania, Tipo, Descrip, imagen);
			id++;
			_listaJuegos.add(game);
			cadena = b.readLine();
		}
		b.close();

		String[] division ;
		String NombreJuego, fileDefault = getClass().getClassLoader().getResource("./Juegos/default.txt").getPath();
		fileDefault = fileDefault.substring(1, fileDefault.length()); //Eliminamos la /inicial que encontramos al obtener la ruta
		f = new FileReader(fileDefault);
		b = new BufferedReader(f);
		while ((NombreJuego = b.readLine()) != null) {
			division = NombreJuego.split(",");
			int response = hasGame(division[0], _listaJuegos);
			if (response >= 0) {
				Juego game = (Juego) _listaJuegos.get(response);
				game.setUrl(division[1]);
				_listaJuegosUsuario.add(game);
			}
		}
		b.close();
		removeDuplicates();
	}

	void removeDuplicates() {
		ArrayList<Object> _listaAux = new ArrayList<>();
		//Elimino los juegos de la biblioteca que ya haya adquirido el usuario
		for (int j = 0; j < _listaJuegos.size(); j++) {
			Juego game = (Juego) _listaJuegos.get(j);
			if (hasGame(game.getNombre(), _listaJuegosUsuario) == -1) {
				_listaAux.add(game);
			}
		}
		//Limpio la lista y clono con la
		_listaJuegos.clear();
		_listaJuegos = (ArrayList<Object>) _listaAux.clone();
	}
}