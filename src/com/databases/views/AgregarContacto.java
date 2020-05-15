package com.databases.views;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AgregarContacto extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private JLabel lblTelefono;
	private JButton btnAgregar;

	public JTextField getTxtNombre() {
		return txtNombre;
	}



	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}



	public JTextField getTxtApellido() {
		return txtApellido;
	}



	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}



	public JLabel getLblEmail() {
		return lblEmail;
	}



	public void setLblEmail(JLabel lblEmail) {
		this.lblEmail = lblEmail;
	}



	public JTextField getTxtEmail() {
		return txtEmail;
	}



	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}



	public JTextField getTxtTelefono() {
		return txtTelefono;
	}



	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}



	public JLabel getLblTelefono() {
		return lblTelefono;
	}



	public void setLblTelefono(JLabel lblTelefono) {
		this.lblTelefono = lblTelefono;
	}



	public JButton getBtnAgregar() {
		return btnAgregar;
	}



	/**
	 * Create the frame.
	 */
	public AgregarContacto() {
		setTitle("Agregar Contacto");
		setBounds(100, 100, 520, 130);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre *");
		lblNombre.setBounds(12, 12, 70, 15);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(100, 10, 140, 19);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido *");
		lblApellido.setBounds(252, 12, 70, 15);
		getContentPane().add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(340, 12, 140, 19);
		getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		lblEmail = new JLabel("Email *");
		lblEmail.setBounds(12, 39, 70, 19);
		getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(100, 39, 140, 19);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(340, 37, 140, 19);
		getContentPane().add(txtTelefono);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(252, 37, 70, 19);
		getContentPane().add(lblTelefono);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(363, 61, 117, 25);
		getContentPane().add(btnAgregar);

	}
}
