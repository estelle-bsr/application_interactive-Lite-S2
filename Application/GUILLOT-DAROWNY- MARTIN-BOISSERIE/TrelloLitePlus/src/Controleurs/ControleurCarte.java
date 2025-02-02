package Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import Modeles.*;
import Vues.*;

/**
 * @author Cathy MARTIN
 *
 *         La classe ControleurCarte gère la modification d'une carte.
 *         Elle affiche la fenêtre de modification de la carte et enregistre les
 *         choix effectués.
 * 
 * Après rendu universitaire : modifications apportées par @author Estelle BOISSERIE
 */

public class ControleurCarte {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private ModeleCarte Carte;
	private VueCarte VueInitiale;
	private VueModifierCarte VueModifie;
	public JFrame frnCarte = new JFrame("Modification de la carte");



	//---------------------------------
	// CONSTRUCTEUR
	//---------------------------------
	/**
	 * Constructeur de la classe ControleurCarte.
	 * 
	 * @param carte      la Carte à modifier
	 * @param vue        la vue de la carte initiale
	 * @param VueModifie la vue de modification de la carte
	 */
	public ControleurCarte(ModeleCarte carte, VueCarte vue, VueModifierCarte VueModifie) {
		Carte = carte;
		VueInitiale = vue;
		this.VueModifie = VueModifie;
	}



	//---------------------------------
	// METHODES
	//---------------------------------
	/**
	 * Affiche la vue permettant de modifier la carte.
	 * Configure la fenêtre et ajoute la vue de modification.
	 */
	public void modifierCarte() {
		// Configurer la fenêtre
		frnCarte.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		/**
		 * Evènement quand on clique sur le bouton "Enrgistrer".
		 **/
		VueModifie.btnEnregistrerClick(new ActionListener() {
			/**
			 *  Evènement quand on clique.
			 * @param e Evènement
			 **/
			public void actionPerformed(ActionEvent e) {
				enregistrement();
			}
		});
		/**
		 * Evènement quand on clique sur le bouton "Annuleré.
		 **/
		VueModifie.btnAnnulerClick(new ActionListener() {
			/**
			 *  Evènement quand on clique.
			 * @param e Evènement
			 **/
			public void actionPerformed(ActionEvent e) {
				annuler();
			}
		});
		// Ajouter la vue
		frnCarte.getContentPane().add(VueModifie);
		// Adapter de la taille de la fenêtre
		frnCarte.setExtendedState(JFrame.MAXIMIZED_BOTH);
		// Rendre visible la fenêtre
		frnCarte.setVisible(true);
	}

	/**
	 * Annuler.
	 */
	public void annuler() {
		frnCarte.dispose();
	}

	/**
	 * Enregistre les choix effectués lors de la modification de la carte.
	 * Met à jour les nouvelles valeurs de la carte et la vue initiale.
	 */
	public void enregistrement() {
		// Enregistrer les nouvelles valeures
		Carte.setNomCarte(VueModifie.getTitre());
		Carte.setDescriptionCarte(VueModifie.getDescription());
		Carte.setDateEcheanceCarte(VueModifie.getDateLimite());
		Carte.setStatutCarte(VueModifie.getStatut());
		// Afficher une fenêtre de dialogue
		int reponse = JOptionPane.showConfirmDialog(null,
				"Confirmez-vous vos modifications ?",
				"Confirmation", JOptionPane.YES_NO_OPTION);
		// Si le membre valide ses choix
		if (reponse == JOptionPane.YES_OPTION) {
			// Fermer la fenêtre
			frnCarte.dispose();
			// Mettre à jour la vue de la carte initiale
			VueInitiale.updateVueCarte();
		}
	}
}
