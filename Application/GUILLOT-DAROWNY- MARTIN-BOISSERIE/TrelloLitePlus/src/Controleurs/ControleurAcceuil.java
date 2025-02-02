package Controleurs;

import java.awt.event.*;
import javax.swing.*;
import Modeles.*;
import Vues.*;

/**
 * Cette classe ControleurAcceuil est le controleur de la vue de lancement de l'application. 
 * Elle permet de réaliser les évènements. 
 * Ici, dans la classe ControleurAcceuil permet à l'utilisateur de se connecter à son compte
 * ou de créer un compte.
 * 
 * @author Estelle BOISSERIE
 **/
public class ControleurAcceuil {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private VueAcceuil Vue;



	//---------------------------------
	// CONSTRUCTEUR
	//---------------------------------
	/**
	 * Constructeur de la classe ControleurAcceuil.
	 * Il permet de créer une instance de ControleurAcceuil afin de l'utiliser comme écouteur.
	 * 
	 * @param vue La vue de lancement de l'application.
	 **/
	public ControleurAcceuil(VueAcceuil vue) {
		Vue = vue;
	}



	//---------------------------------
	// METHODES
	//---------------------------------
	/**
	 * Se connecter au compte du membre.
	 * 
	 * @param membre L'utilisateur souhaitant se connecter.
	 **/
	public void seConnecter(ModeleMembre membre) {
		// Si l'adresse mail saisie est différente de celle de l'utilisateur
		if (!(Vue.getMail().equals(membre.getMailMembre()))){
			// Afficher une erreur
			JOptionPane.showMessageDialog(null,
					"ERREUR: L'adresse mail est incorrecte.", "Avertissement",
					JOptionPane.WARNING_MESSAGE);
		}
		// Si le mot de passe saisit par l'utilisateur est différent de celui de l'utilisateur
		else if (!(Vue.getMotdepasse().equals(membre.getMotdepasseMembre()))) {
			System.out.println("La vue" + Vue.getMotdepasse());
			System.out.println(" Le modele" + membre.getMotdepasseMembre());
			// Afficher une erreure
			JOptionPane.showMessageDialog(null,"ERREUR: Le mot de passe est incorrecte.", "Avertissement",
					JOptionPane.WARNING_MESSAGE);
		}
		// Si tout est correcte
		else {
			// Fermer la vue
			Vue.fermerFenetre(); 
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
			ControleurProjet ecouteur = new ControleurProjet(membre, VueCreationProjet, VueProjet);
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
			 * Quand on clique sur le bouton "Enregistrer"
			 **/
			VueCreationProjet.btnEnregistrerClick(new ActionListener() {
				/**
				 * Evènement quand on clique
				 * @param e Evènement
				 **/
				public void actionPerformed(ActionEvent e) {
					ecouteur.enregistrerProjet();
					// Adapter de la taille de la fenêtre
					fnrProjet.setExtendedState(JFrame.MAXIMIZED_BOTH);
					// Rendre visible la fenêtre
					fnrProjet.setVisible(true);
				}
			});
			/**
			 * Quand on clique sur le bouton "Annuler"
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
			// Adapter de la taille de la fenêtre
			fnrProjet.setExtendedState(JFrame.MAXIMIZED_BOTH);
			// Rendre visible la fenêtre
			fnrProjet.setVisible(true);
		}
	}


	/**
	 * Créer un compte.
	 **/
	public void creerCompte() {
		// Créer une fenêtre
		JFrame fnrCreation = new JFrame("Créer un compte");
		// La fenêtre se ferme quand on appuit sur la croix
		fnrCreation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Créer la vue
		VueCreerMembre VueCreation = new VueCreerMembre();
		// Créer le contrôleur
		ControleurMembreCree ecouteur = new ControleurMembreCree(VueCreation);
		/**
		 * Cliquer sur le bouton "Créer".
		 **/
		VueCreation.btnCreerClick(new ActionListener() {
			/**
			 * Evènement quand on clique.
			 * @param e Evènement
			 **/
			public void actionPerformed(ActionEvent e) { 
				ecouteur.demarrerCompte(); 
			} 
		});
		/**
		 * Cliquer sur le bouton "Retour".
		 **/
		VueCreation.btnRetourClick(new ActionListener() {
			/**
			 * Evènement quand on clique.
			 * @param e Evènement
			 **/
			public void actionPerformed(ActionEvent e) { 
				ecouteur.back(); 
			} 
		});
		// Ajouter à la fenêtre
		fnrCreation.add(VueCreation);
		// Adapter de la taille de la fenêtre
		fnrCreation.setExtendedState(JFrame.MAXIMIZED_BOTH);
		// Centrer la fenêtre
		fnrCreation.setLocationRelativeTo(null);
		// Rendre visible la fenêtre
		fnrCreation.setVisible(true);
	}
}
