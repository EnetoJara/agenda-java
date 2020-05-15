package com.databases.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import com.databases.db.Connector;
import com.databases.models.Contacto;
import com.databases.views.AgregarContacto;

public class AgregarController {
	private AgregarContacto ag;
	
	private ActionListener eventoGuardar;

	public AgregarController () {
		this.ag = new AgregarContacto();
		this.eventoGuardar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				guardarContacto(arg0);
			}
		};
		
		this.ag.getBtnAgregar().addActionListener(this.eventoGuardar);
	}
	
	public JInternalFrame mostrarVista () {
		this.ag.setVisible(true);
		
		return this.ag;
	}
	
	private void guardarContacto (ActionEvent arg0) {
		Contacto con = new Contacto(
				this.ag.getTxtNombre().getText(),
				this.ag.getTxtApellido().getText(),
				this.ag.getTxtTelefono().getText(),
				this.ag.getTxtEmail().getText(), "");
		
		Connector connector = new Connector();
		Connection conn = connector.connectDatabase();
		
		connector.agregarContacto(conn, con);
		
		JOptionPane.showMessageDialog(null, "Contacto Guardado");
		
	}
}
