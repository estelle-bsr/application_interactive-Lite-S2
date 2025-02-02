package Controleurs;

import java.awt.event.*;
import javax.swing.*;
import Modeles.*;
import Vues.*;

/**
 * Cette classes est la classe ControleurVoirProjet. 
 * Elle permet de réaliser un évènement de la vue VueProjet.
 * L'évènement est voir un projet parmi ceux disponible dans la VueProjet.
 * 
 * @author Estelle BOISSERIE
 **/
public class ControleurVoirProjet implements ActionListener{
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private ModeleProjet Projet;



	//---------------------------------
	// CONSTRUCTEUR
	//---------------------------------
	/**
	 * Ce constructeur permet de créer une instance de la classe ControleurVoitProjet qui servira d'écouteur.
	 * @param projet Le projet qu'on souhaite affiché.
	 * @param vue La vue des projets.
	 **/
	public ControleurVoirProjet(ModeleProjet projet, VueProjet vue) {
		Projet = projet;
	}


	//---------------------------------
	// METHODES
	//---------------------------------
	/**
	 * Evènement quand on clique sur le bonton "Ouvrir Projet".
	 * @param e Evènement
	 **/
	public void actionPerformed(ActionEvent e) {
		// Créer une fenêtre
		JFrame fnrProjet = new JFrame(Projet.getNomProjet());

		// Cliquer sur la croix de la fenêtre ferme celle-ci
		fnrProjet.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Créer la vue
		VueGlobale Vue = new VueGlobale(Projet);

		// Créer un écouteur 
		ControleurGlobale ecouteur = new ControleurGlobale(Projet, Vue);

		/** 
		 * Cliquer sur le bouton dédié au membre connecté.
		 **/
		Vue.btnMembreClick(new ActionListener() { 
			/**
			 * Evènement quand on clique
			 * @param e Evènement
			 **/
			public void actionPerformed(ActionEvent e) { 
				ecouteur.afficherProfil(); 
			} 
		});
		/**
		 * Cliquer sur le bouton "Ajouter des participants".
		 * 
		 * @param un nouveau écouteur
		 */
		Vue.btnAjouterParticipantClick(new ActionListener() {
			/**
			 * Evènement quand on clique
			 * @param e Evènement
			 **/
			public void actionPerformed(ActionEvent e) { 
				ecouteur.ajouterParticipant(); 
			} 
		});
		/**
		 * Cliquer sur le bouton "Rafraîchir".
		 * 
		 * @param un nouveau écouteur
		 **/
		Vue.btnRafraichirClick(new ActionListener() {
			/**
			 * Evènement quand on clique
			 * @param e Evènement
			 **/
			public void actionPerformed(ActionEvent e) { 
				ecouteur.restructure(); 
			} 
		});
		/**
		 * Cliquer sur le bouton "+".
		 * 
		 * @param un nouveau écouteur
		 **/
		Vue.btnAjouterTableauClick(new ActionListener() {
			/**
			 * Evènement quand on clique
			 * @param e Evènement
			 **/
			public void actionPerformed(ActionEvent e) { 
				ecouteur.ajouterTableau(); 
			} 
		});
		/**
		 * Cliquer sur le bouton "Voir les participant".
		 * 
		 * @param un nouveau écouteur
		 **/
		Vue.btnVoirParticipantClick(new ActionListener() { 
			/**
			 * Evènement quand on clique
			 * @param e Evènement
			 **/
			public void actionPerformed(ActionEvent e) { 
				ecouteur.voirParticipant(); 
			} 
		});

		// Ajouter à la fenêtre
		fnrProjet.add(Vue);
		// Adapter de la taille de la fenêtre
		fnrProjet.setExtendedState(JFrame.MAXIMIZED_BOTH);
		// Centrer la fenêtre
		fnrProjet.setLocationRelativeTo(null);
		// Afficher la fenêtre
		fnrProjet.setVisible(true);
	}
}