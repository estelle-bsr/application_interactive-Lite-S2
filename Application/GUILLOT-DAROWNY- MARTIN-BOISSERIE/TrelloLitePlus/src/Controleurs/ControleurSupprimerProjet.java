package Controleurs;

import java.awt.event.*;

import javax.swing.*;
/**
 * Cette classe est la classe controleur de ControleurSupprimerProjet. 
 * Elle permet de réaliser les évènements de la suppression d'un projet.
 * @author Antonin Guillot
 *
 */
public class ControleurSupprimerProjet implements ActionListener{
	/******************
	 ** ATTRIBUTS **
	 ******************/
	private JPanel asupprimer;



	/******************
	 ** CONSTRUCTEUR **
	 ******************/
	/**
	 * Ce constructeur permet de créer une instance de la classe ControleurSupprimerProjet
	 * @param sup Le projet a supprimer
	 */
	public ControleurSupprimerProjet(JPanel sup) {
		asupprimer = sup;
	}



	/******************
	 ** METHODES **
	 ******************/
	/**
	 * Supprime le projet et retire son affichage
	 * @param un click
	 */
	public void actionPerformed(ActionEvent e) {
		asupprimer.setVisible(false);
	}
}
