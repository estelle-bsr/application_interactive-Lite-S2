package Controleurs;

import java.awt.event.*;
import javax.swing.*;
import Modeles.*;
import Vues.*;

/**
 * 
 *
 *         La classe ControleurListe gère la modification d'une liste et la
 *         création de cartes.
 *         Elle affiche les vues de modification de liste et de création de
 *         carte, et enregistre les choix effectués.
 *         Elle crée également une nouvelle carte et l'affiche dans la liste.
 * @author MARTIN Cathy & DAROWNY Corentin
 * Après rendu universitaire : modifications apportées par @author Estelle BOISSERIE
 */

public class ControleurListe {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private ModeleListe Liste;
	private VueListe VueInitiale;
	private VueModifierListe VueModifie;
	private VueCreeCarte vueCreationCarte;
	public JFrame frnListe = new JFrame("Modifier liste");
	private JFrame frnListeCarte = new JFrame("Création carte");



	//---------------------------------
	// CONSTRUCTEURS
	//---------------------------------
	/**
	 * Constructeur de la classe ControleurListe.
	 * 
	 * @param liste      le modèle de liste
	 * @param vue        la vue de la liste initiale
	 * @param VueModifie la vue de modification de la liste
	 * @param VueCree    la vue de création de carte
	 */
	public ControleurListe(ModeleListe liste, VueListe vue, VueModifierListe VueModifie) {
		Liste = liste;
		VueInitiale = vue;
		this.VueModifie = VueModifie;
	}



	//---------------------------------
	// METHODES
	//---------------------------------
	/**
	 * Affiche la vue permettant de créer une carte.
	 * Crée une carte vide, configure la fenêtre et ajoute la vue de création.
	 * 
	 * @return la carte créée
	 */
	public ModeleCarte CreeCarte() {
		this.vueCreationCarte = new VueCreeCarte();
		// créé une carte vide
		ModeleCarte carte = new ModeleCarte("", "", "00/00/0000");
		// Configurer la fenêtre
		frnListeCarte.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		/**
		 *Cliquer sur le bouton "Modifier".
		 **/
		vueCreationCarte.btnCreeClick(new ActionListener() {
			/**
			 *  Evènement quand on clique.
			 * @param e Evènement
			 **/
			public void actionPerformed(ActionEvent e) {
				cree();
			}
		});	
		vueCreationCarte.btnAnnulerClick(new ActionListener() {
			/**
			 *  Evènement quand on clique.
			 * @param e Evènement
			 **/
			public void actionPerformed(ActionEvent e) {
				frnListeCarte.dispose();
			}
		});	

		// Réinitialiser le champ de texte avant d'afficher la vue
		this.vueCreationCarte.getTitre().setText("");
		this.vueCreationCarte.getDescription().setText("");
		this.vueCreationCarte.getDateLimite().setText("");

		// Supprimer l'ancien contenu et ajouter la nouvelle vue
		frnListeCarte.getContentPane().removeAll();
		frnListeCarte.getContentPane().add(this.vueCreationCarte);
		frnListeCarte.revalidate();
		frnListeCarte.repaint();


		// Adapter de la taille de la fenêtre
		frnListeCarte.setExtendedState(JFrame.MAXIMIZED_BOTH);
		// Rendre visible la fenêtre
		frnListeCarte.setVisible(true);
		// Vider le JTextField/Area
		vueCreationCarte.getTitre().setText("");
		vueCreationCarte.getDescription().setText("");
		vueCreationCarte.getDateLimite().setText("00/00/0000");
		return carte;
	}

	/**
	 * Affiche la vue permettant de modifier la liste.
	 * Configure la fenêtre et ajoute la vue de modification.
	 */
	public void modifierListe() {
		// Configurer la fenêtre
		frnListe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		/**
		 *Cliquer sur le bouton "Modifier".
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
		VueModifie.btnAnnulerClick(new ActionListener() {
			/**
			 *  Evènement quand on clique.
			 * @param e Evènement
			 **/
			public void actionPerformed(ActionEvent e) {
				frnListe.dispose();
			}
		});

		// Ajouter la vue
		frnListe.getContentPane().add(VueModifie);
		// Adapter de la taille de la fenêtre
		frnListe.setExtendedState(JFrame.MAXIMIZED_BOTH);
		// Rendre visible la fenêtre
		frnListe.setVisible(true);
	}

	/**
	 * Enregistre les choix effectués lors de la modification de la liste.
	 * Met à jour le nouveau nom de la liste et le change aussi à la vue initiale.
	 */
	public void enregistrement() {
		// Enregistrer du nouveau nom
		Liste.setNomListe(VueModifie.getTitre());
		// Afficher une fenêtre de dialogue
		int reponse = JOptionPane.showConfirmDialog(null,
				"Confirmez-vous vos modifications ?",
				"Confirmation", JOptionPane.YES_NO_OPTION);
		// Si le membre valide ses choix
		if (reponse == JOptionPane.YES_OPTION) {
			// Fermer la fenêtre
			frnListe.dispose();
			// Mettre à jour la vue de la carte initiale
			VueInitiale.updateVueListe();
		}
	}

	/**
	 * Annule la création de la carte.
	 * Affiche une fenêtre de confirmation et ferme la fenêtre de création de carte.
	 */
	public void annuler() {
		// Afficher une fenêtre de dialogue
		int reponse = JOptionPane.showConfirmDialog(null,
				"Confirmez-vous l'annulation ?",
				"Confirmation", JOptionPane.YES_NO_OPTION);
		// Si le membre valide ses choix
		if (reponse == JOptionPane.YES_OPTION) {
			// Fermer la fenêtre
			frnListeCarte.dispose();
		}
	}

	/**
	 * Crée une nouvelle carte et l'affiche dans la liste.
	 * Affiche une fenêtre de confirmation, crée une carte vide, crée une instance
	 * de VueCarte avec la carte créée,
	 * crée une instance de VueModifierCarte, crée un écouteur et ajoute la vue de
	 * la carte à la fenêtre de la liste.
	 * Met à jour l'affichage de la fenêtre de la liste.
	 * L'utilisateur peut annulr la création de la carte.
	 * Et en modifiant la carte elle pourra être supprimer.
	 */
	public void cree() {
		// Afficher une fenêtre de dialogue
		int reponse = JOptionPane.showConfirmDialog(null,
				"Confirmez-vous la création de la carte ?",
				"Confirmation", JOptionPane.YES_NO_OPTION);
		// Si le membre valide ses choix
		if (reponse == JOptionPane.YES_OPTION) {
			// Créer une carte la carte
			ModeleCarte carte = this.vueCreationCarte.getCarteCree();

			// Ajouter la carte dans la liste
			Liste.sesCartes.add(carte);
			
			//carte.getMembres().add(VueMembre.modele);
			//VueMembre.modele.getMesCartes().add(carte);

			// Créer une instance de VueCarte avec la carte créée
			VueCarte vueCarte = new VueCarte(carte);

			// Créer une instance de VueModifierCarte
			VueModifierCarte vueModifierCarte = new VueModifierCarte(carte);

			// Création d'un écouteur
			ControleurCarte ecouteur = new ControleurCarte(carte, vueCarte, vueModifierCarte);

			/**
			 * Evènement quand on clique sur le bouton "Modifier"
			 */
			vueCarte.btnModifierClick(new ActionListener() {
				/**
				 *  Evènement quand on clique.
				 * @param e Evènement
				 **/
				public void actionPerformed(ActionEvent e) {
					ecouteur.modifierCarte();
				}
			});
			/**
			 * Evènement quand on clique sur le bouton "Supprimer"
			 */
			vueCarte.btnSupprimerClick(new ActionListener() {
				/**
				 *  Evènement quand on clique.
				 * @param e Evènement
				 **/
				public void actionPerformed(ActionEvent e) {
					// Supprimer la carte de la liste
					Liste.sesCartes.remove(carte);
					// Supprimer la vue de la carte à la fenêtre de la liste
					VueInitiale.pnlCartes.remove(vueCarte);
					// Actualiser l'affichage de la fenêtre de la liste
					VueInitiale.revalidate();
					VueInitiale.repaint();
				}
			});
			
			// Ajouter la vue de la carte à la fenêtre de la liste
			VueInitiale.pnlCartes.add(vueCarte);

			// Actualiser l'affichage de la fenêtre de la liste
			VueInitiale.revalidate();
			VueInitiale.repaint();

			// Fermer la fenêtre de création de carte
			frnListeCarte.dispose();

		}
	}

}
