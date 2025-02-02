package Controleurs;

import java.awt.event.*;

import javax.swing.*;

import Modeles.ModeleProjet;
import Vues.*;

/**
 * Cette classe est la classe controleur de ControleurModifierProjet. 
 * Elle permet de réaliser les évènements de le vue graphique de modifiaction d'un projet.
 * 
 * @author Antonin Guillot
 * 
 * Après rendu universitaire : modifications apportées par @author Estelle BOISSERIE
 */
public class ControleurModifierProjet implements ActionListener{
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private ModeleProjet Projet;
	private VueModifierProjet VueModif = new VueModifierProjet();
	private VueProjet VueInitiale;



	//---------------------------------
	// CONSTRUCTEUR
	//---------------------------------
	/**
	 * Constructeur de la classe ControleurModifierProjet.
	 * Il permet de créer une instance de ControleurModifierProjet afin de l'utiliser comme écouteur.
	 * 
	 * @param projet Le projet à modifier.
	 * @param vueProjet La vue du projet. 
	 */
	public ControleurModifierProjet (ModeleProjet projet, VueProjet vueProjet) {
		this.Projet = projet;
		this.VueInitiale = vueProjet;

	}



	//---------------------------------
	// METHODES
	//---------------------------------
	/**
	 * Reprend les données du projet et les affiche pour permettre de les modifier
	 * @param un click
	 */
	public void actionPerformed(ActionEvent e) {
		JFrame fnrModif = new JFrame ("Modification d'un projet");
		VueModif.setTitre(Projet.getNomProjet());
		VueModif.setDateEcheance(Projet.getDateEcheanceProjet());
		VueModif.setDescription(Projet.getDescriptionProjet());
		fnrModif.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fnrModif.add(VueModif);
		// Adapter de la taille de la fenêtre
		fnrModif.setExtendedState(JFrame.MAXIMIZED_BOTH);
		fnrModif.setVisible(true);

		/**
		 * Evènement quand on clique sur le bouton "Annuler".
		 */
		VueModif.btnAnnulerClick(new ActionListener() {
			/**
			 * Evènement quand on clique
			 * @param e Evènement
			 **/
			public void actionPerformed(ActionEvent e) {
				VueModif.fermerFenetre();
			}
		});
		/**
		 * Evènement quand on clique sur le bouton "Enregistrer".
		 */
		VueModif.btnEnregistrerClick(new ActionListener() {
			/**
			 * Evènement quand on clique
			 * @param e Evènement
			 **/
			public void actionPerformed(ActionEvent e) {
				// Enregister les nouvelles informations saisient
				Projet.setNomProjet(VueModif.getTitre());
				Projet.setDescriptionProjet(VueModif.getDescription());
				Projet.setDateEcheanceProjet(VueModif.getDateEcheance());
				// Mettre à jour
				VueInitiale.Redessiner();
				VueModif.fermerFenetre();
			}
		});
	}
}
