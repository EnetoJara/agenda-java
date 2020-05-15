package com.databases.views;

import java.awt.HeadlessException;
import java.awt.MenuBar;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainView extends JFrame {
	private JMenu mContactos;
	private JMenuBar menuBar;
	private JMenuItem iAgregar;
	private JMenuItem iEditar;
	private JMenuItem iEliminar;
	private JMenuItem iBuscar;

	/**
	 * Create the frame.
	 */
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 900);
		getContentPane().setLayout(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mContactos = new JMenu("Contactos");
		menuBar.add(mContactos);
		
		iAgregar = new JMenuItem("Agregar");
		mContactos.add(iAgregar);
		
		iEditar = new JMenuItem("Editar");
		mContactos.add(iEditar);
		
		iEliminar = new JMenuItem("Eliminar");
		mContactos.add(iEliminar);
		
		iBuscar = new JMenuItem("Buscar");
		mContactos.add(iBuscar);	
	}
	
	public void agregarVista (JInternalFrame v) {
		this.getContentPane().add(v);
	}

	public JMenuItem getiAgregar() {
		return iAgregar;
	}

	public void setiAgregar(JMenuItem iAgregar) {
		this.iAgregar = iAgregar;
	}

	public JMenuItem getiEditar() {
		return iEditar;
	}

	public void setiEditar(JMenuItem iEditar) {
		this.iEditar = iEditar;
	}

	public JMenuItem getiEliminar() {
		return iEliminar;
	}

	public void setiEliminar(JMenuItem iEliminar) {
		this.iEliminar = iEliminar;
	}

	public JMenuItem getiBuscar() {
		return iBuscar;
	}

	public void setiBuscar(JMenuItem iBuscar) {
		this.iBuscar = iBuscar;
	}	
	
}
