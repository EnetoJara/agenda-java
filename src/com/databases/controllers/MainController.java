package com.databases.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.databases.views.MainView;

/**
 * Controlador principal. Esta clase sirve para orquestar los subcontroladores.
 * 
 * @author Goretti
 */
public class MainController {
	/**
	 * Vista principal.
	 */
	private MainView mainView;
	private ActionListener eventoBuscar;
	
	/**
	 * Crea la instancia del controlador principal y desplieaga la vista principal.
	 */
	public MainController () {
		this.setMainView(new MainView());
		this.getMainView().setVisible(true);
		
		this.eventoBuscar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				eventoBuscarHandler(arg0);
			}
		};
		
		this.mainView.get
	}

	/**
	 * 
	 * @param arg0
	 */
	private void eventoBuscarHandler(ActionEvent arg0) {
			
		
	}
	
	public MainView getMainView() {
		return mainView;
	}

	public void setMainView(MainView mainView) {
		this.mainView = mainView;
	}
	
	
}
