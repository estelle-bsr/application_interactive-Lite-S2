package Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import Modeles.*;
import Vues.*;

/**
 * Cette classe ControleurMembreCree est le controleur de la vue de création d'un compte. 
 * Elle permet de réaliser les évènements. 
 * Ici, dans la classe ControleurMembreCree permet à l'utilisateur de sauvegarder ses données et
 * créer un compte ainsi que faire ses premiers pas avec. Ou de faire retour en arrière.
 * 
 * @author Estelle BOISSERIE
 **/
public class ControleurMembreCree {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private VueCreerMembre Vue;



	//---------------------------------
	// CONSTRUCTEUR
	//---------------------------------
	/**
	 * Constructeur de la classe ControleurMembreCree.
	 * Il permet de créer une instance de ControleurMembreCree afin de l'utiliser comme écouteur.
	 * 
	 * @param vue La vue de lancement de l'application
	 **/
	public ControleurMembreCree(VueCreerMembre vue) {
		Vue = vue;
	}



	//---------------------------------
	// METHODES
	//---------------------------------
	/**
	 * Fermer la fenêtre.
	 **/
	public void back() {
		Vue.fermerFenetre();
	}

	/**
	 * Sauvegarder les données, créer un compte et démarrer sur l'application.
	 **/
	public void demarrerCompte() {
		// Si le mot de passe saisie et le mot de passe de confirmation saisie est différent
		if (!(Vue.getMotdepasse().equals(Vue.getTxtMotdepasseConfirme()))) {
			// Afficher une erreure
			JOptionPane.showMessageDialog(null,
					"ERREUR: Les mots de passe saisient sont différent.", "Avertissement",
					JOptionPane.WARNING_MESSAGE);
		}
		// Si ceux sont les mêmes
		else {
			// Créer le nouveau membre
			ModeleMembre NouveauMembre = new ModeleMembre(Vue.getNom(), Vue.getPrenom(), Vue.getMotdepasse(), Vue.getMail());

			// Créer une fenêtre
			JFrame fnrProjet = new JFrame("Mes projets");

			// La fenêtre se ferme quand on appuit sur la croix
			fnrProjet.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			// Créer une vue du projet
			VueProjet VueProjet = new VueProjet();

			// Créer une vue pour la création du projet
			VueCreerProjet VueCreationProjet = new VueCreerProjet();

			// Créer une vue pour la modification du projet
			new VueModifierProjet();

			// Créer un écouteur de la vue projet
			ControleurProjet ecouteur = new ControleurProjet(NouveauMembre, VueCreationProjet, VueProjet);

			// Exécutions des boutons
			/**
			 * Quand cliquer sur le bouton "Créer"
			 **/
			VueProjet.btnCreerClick(new ActionListener() {
				/**
				 * Evènement quand on clique
				 * @param e Evènement
				 **/
				public void actionPerformed(ActionEvent e) {
					ecouteur.creerProjet();
				}
			});
			/**
			 * Quand on clique sur le bouton "Enregistrer".
			 **/
			VueCreationProjet.btnEnregistrerClick(new ActionListener() {
				/**
				 * Evènement quand on clique
				 * @param e Evènement
				 **/
				public void actionPerformed(ActionEvent e) {
					ecouteur.enregistrerProjet();
					fnrProjet.pack();
				}
			});
			/**
			 * Quand on clique sur le bouton "Annuler".
			 **/
			VueCreationProjet.btnAnnulerClick(new ActionListener() {
				/**
				 * Evènement quand on clique
				 * @param e Evènement
				 **/
				public void actionPerformed(ActionEvent e) {
					ecouteur.annulerProjet();
				}
			});
			// Ajouter à la fenêtre
			fnrProjet.add(VueProjet);

			// Fermer la fenêtre
			Vue.fermerFenetre();

			// Adapter de la taille de la fenêtre
			fnrProjet.setExtendedState(JFrame.MAXIMIZED_BOTH);

			// Centrer la fenêtre
			fnrProjet.setLocationRelativeTo(null);

			// Rendre visible la fenêtre
			fnrProjet.setVisible(true);
		}
	}
}
