package Controleurs;

import javax.swing.*;
import Modeles.*;
import Vues.*;

/**
 * La classe ControleurCommentaire est une classe qui représente le contrôleur des commentaires.
 * Elle permet l'action des boutons grâce aux méthodes codées.
 * Ici, ControleurCommentaire permet d'afficher le profil de l'auteur d'un commentaire.
 * 
 * @author Estelle BOISSERIE
 **/

public class ControleurCommentaire {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private ModeleCommentaire modele;
	JFrame frnProfil = new JFrame ("Profil de l'auteur");



	//---------------------------------
	// CONSTRUCTEUR
	//---------------------------------
	/**
	 * Constructeur de la classe ControleurCommentaire.
	 * Le constructeur permet de créer une instance de ControleurCommentaire afin de l'utiliser comme écouteur.
	 * 
	 * @param commentaire Le commentaire en représenter graphiquement
	 * @param vue La représentation graphique du commentaire
	 **/
	public ControleurCommentaire(ModeleCommentaire commentaire, VueCommentaire vue) {
		modele = commentaire;
	}



	//---------------------------------
	// METHODES
	//---------------------------------
	/**
	 * Afficher le profil du membre 
	 **/
	public void afficherProfil() {
		// Fermer la page quand on clique sur la croix
		frnProfil.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Créer la vue du profil de l'auteur
		VueMembre vue = new VueMembre(modele.getAuteur());
		// Ajoute à la fenêtre la vue
		frnProfil.add(vue);
		// Adapter la taille de la fenêtre
		frnProfil.pack();
		// Afficher la fenetre
		frnProfil.setVisible(true);
	}
}
