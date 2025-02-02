
package Controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Modeles.*;
import Vues.*;

/**
 * Cette classe est la classe controleur de ControleurTableau. 
 * Elle permet de réaliser les évènements de le vue graphique des tableaux.
 * @author Cathy MARTIN
 * Après rendu universitaire : modifications apportées par @author Estelle BOISSERIE
 */
public class ControleurTableau {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private ModeleTableau Tableau;
	private VueTableau VueInitiale;
	private VueModifierTableau VueModifie;
	private VueCreeListe VueCree;
	private JFrame frnTableau = new JFrame("Modifier tableau");
	private JFrame frnTableauListe = new JFrame("Création liste");



	//---------------------------------
	// CONSTRUCTEUR
	//---------------------------------
	/**
	 * Ce constructeur permet de créer une instance de la classe ControleurTableau
	 * @param membre Le tableau
	 * @param vue La vue graphique du tableau
	 * @param VueModifie La vue graphique de la modification du tableau
	 * @param VueCree La vue graphique de la création d'une liste
	 */
	public ControleurTableau(ModeleTableau tab, VueTableau vue, VueModifierTableau VueModifie) {
		Tableau = tab;
		VueInitiale = vue;
		this.VueModifie = VueModifie;
	}



	//---------------------------------
	// METHODES
	//---------------------------------
	/**
	 * Affiche la vue de création d'une liste.
	 * @return La nouvelle liste
	 **/
	public ModeleListe CreeListe() {
		// Créer une nouvelle instance
		this.VueCree = new VueCreeListe();

		// Créer une nouvelle liste vide
		ModeleListe liste = new ModeleListe("");

		/**
		 * Evènement quand on clique le bouton "Annuler".
		 **/
		this.VueCree.btnAnnulerClick(new ActionListener() {
			/**
			 * Evènement quand on clique
			 * @param e Evènement
			 **/
			public void actionPerformed(ActionEvent e) {
				annuler();
			}
		});
		/**
		 * 	Evènement quand on clique sur le bouton "Créer".
		 **/
		this.VueCree.btnCreeClick(new ActionListener() {
			/**
			 * Evènement quand on clique
			 * @param e Evènement
			 **/
			public void actionPerformed(ActionEvent e) {
				cree();
			}
		});

		// Réinitialiser le champ de texte avant d'afficher la vue
		this.VueCree.getTxtTitre().setText("");

		// Supprimer l'ancien contenu et ajouter la nouvelle vue
		frnTableauListe.getContentPane().removeAll();
		frnTableauListe.getContentPane().add(this.VueCree);
		frnTableauListe.revalidate();
		frnTableauListe.repaint();

		// Configurer la fenêtre
		frnTableauListe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frnTableauListe.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frnTableauListe.setVisible(true);

		return liste;
	}

	/**
	 * Afficher la vue de modification du tableau.
	 **/
	public void modifierTableau() {
		// Configurer la fenêtre
		frnTableau.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		/**
		 * Evènement quand on clique sur le bouton "Enregistrer".
		 **/
		VueModifie.btnEnregistrerClick(new ActionListener() {
			/**
			 * Evènement quand on clique
			 * @param e Evènement
			 **/
			public void actionPerformed(ActionEvent e) {
				enregistrement();
			}
		});
		/**
		 * Evènement quand on clique sur le bouton "Annuler".
		 **/
		VueModifie.btnAnnulerClick(new ActionListener() {
			/**
			 * Evènement quand on clique
			 * @param e Evènement
			 **/
			public void actionPerformed(ActionEvent e) {
				frnTableau.dispose();
			}
		});

		// Ajouter la vue
		frnTableau.getContentPane().add(VueModifie);
		// Adapter de la taille de la fenêtre
		frnTableau.setExtendedState(JFrame.MAXIMIZED_BOTH);
		// Rendre visible la fenêtre
		frnTableau.setVisible(true);
	}

	/**
	 * Enregistrer la modification du tableau
	 **/
	public void enregistrement() {
		// Enregistrer du nouveau nom
		Tableau.setNomTableau(VueModifie.getTitre());
		// Afficher une fenêtre de dialogue
		int reponse = JOptionPane.showConfirmDialog(null,
				"Confirmez-vous vos modifications ?",
				"Confirmation", JOptionPane.YES_NO_OPTION);
		// Si le membre valide ses choix
		if (reponse == JOptionPane.YES_OPTION) {
			// Fermer la fenêtre
			frnTableau.dispose();
			// Mettre à jour la vue du tableau initiale
			VueInitiale.updateVueTableau();
		}
	}

	/**
	 * Annuer la création de la liste.
	 **/
	public void annuler() {
		frnTableauListe.dispose();
	}

	/**
	 * Créer une nouvelle liste.
	 **/
	public void cree() {
		// Afficher une fenêtre de dialogue
		int reponse = JOptionPane.showConfirmDialog(null,
				"Confirmez-vous la création de la liste ?",
				"Confirmation", JOptionPane.YES_NO_OPTION);

		// Si le membre valide ses choix
		if (reponse == JOptionPane.YES_OPTION) {
			String titreListe = VueCree.getTxtTitre().getText(); 

			// Créer une nouvelle liste
			ModeleListe liste = new ModeleListe(titreListe);

			// Ajouter la liste au tableau
			Tableau.sesListes.add(liste);

			// Créer une instance de VueListe avec la liste créée
			VueListe vueListe = new VueListe(liste);


			// Créer une instance de VueModifierListe
			VueModifierListe vueModifierListe = new VueModifierListe(liste);

			// Création d'un écouteur
			ControleurListe controleurListe = new ControleurListe(liste, vueListe, vueModifierListe);

			/**
			 * Evènement quand on clique sur le bouton "Modifier".
			 **/
			vueListe.btnModifierClick(new ActionListener() {
				/**
				 * Evènement quand on clique
				 * @param e Evènement
				 **/
				public void actionPerformed(ActionEvent e) {
					controleurListe.modifierListe();
				}
			});
			/**
			 * Evènement lorsqu'on clique sur le bouton "Ajouter".
			 **/
			vueListe.btnAjouterCarteClick(new ActionListener() {
				/**
				 * Evènement quand on clique
				 * @param e Evènement
				 **/
				public void actionPerformed(ActionEvent e) {
					controleurListe.CreeCarte();
				}
			});
			/**
			 * Evènement lorsqu'on clique sur le bouton "Supprimer".
			 **/
			vueListe.btnSupprimerListeClick(new ActionListener() {
				/**
				 * Evènement quand on clique
				 * @param e Evènement
				 **/
				public void actionPerformed(ActionEvent e) {
					// Supprimer la liste du modèle
					Tableau.sesListes.remove(liste);
					// Supprimer la liste de la vue
					VueInitiale.pnlListes.remove(vueListe);

					// Mettre à jour la vue
					VueInitiale.pnlListes.revalidate();
					VueInitiale.pnlListes.repaint();
				}
			});


			// Ajouter la vue de la carte à la fenêtre de la liste
			VueInitiale.pnlListes.add(vueListe);
			// Actualiser l'affichage de la fenêtre de la liste
			VueInitiale.revalidate();
			VueInitiale.repaint();
			// Fermer la fenêtre de création de carte
			frnTableauListe.dispose();
		}
	}
}