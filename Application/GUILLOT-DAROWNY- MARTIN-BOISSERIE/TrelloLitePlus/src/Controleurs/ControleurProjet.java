package Controleurs;
import Modeles.*;

import Vues.*;
import java.awt.*;
import javax.swing.*;

/**
 * Cette classe est la classe controleur de ControleurProjet. 
 * Elle permet de réaliser les évènements de le vue graphique des projets.
 * @author Antonin Guillot
 * @author Estelle Boisserie
 */
public class ControleurProjet {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private ModeleMembre createur;
	private VueCreerProjet VueModif;
	private VueProjet VueInitiale;

	private JFrame fnrCreation = new JFrame ("Création d'un projet");

	private final static Font POLICECORPS = new Font("Open Sans Semibold", Font.PLAIN, 25);
	private final static Font POLICEBOUTON = new Font("Open Sans Semibold", Font.PLAIN, 15);



	//---------------------------------
	// CONSTRUCTEURS
	//---------------------------------
	/**
	 * Ce constructeur permet de créer une instance de la classe ControleurProjet
	 * @param Createur Le membre qui a créer le projet
	 * @param vueProjet La vue du projet quand on le créer
	 * @param VueInitiale La vue graphique du projet
	 */
	public ControleurProjet (ModeleMembre Createur, VueCreerProjet vueProjet, VueProjet VueInitiale) {
		createur = Createur;
		this.VueInitiale = VueInitiale;
		VueModif = vueProjet;
	}



	//---------------------------------
	// METHODES
	//---------------------------------
	/**
	 * Permet d'afficher la vue pour créer un projet
	 */
	public void creerProjet () {
		// La fenêtre se ferme quand on appuit sur la croix
		fnrCreation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Ajouter à la fenêtre
		fnrCreation.add(VueModif);
		// Adapter de la taille de la fenêtre
		fnrCreation.setExtendedState(JFrame.MAXIMIZED_BOTH);
		// Afficher la fenetre
		fnrCreation.setVisible(true);
	}

	/**
	 * Permet de fermer la fenêtre de création et de réinitialiser les textes
	 */
	public void annulerProjet () {
		// Réinitialiser les champs de saisit
		VueModif.getTxtTitre().setText("");
		VueModif.getTxtDateEcheance().setText("");
		VueModif.getTxtDescription().setText("");
		// Fermer la fenêtre
		fnrCreation.dispose();
	}

	/**
	 * Permet d'enregistrer un projet et d'afficher le titre avec deux boutons (Modifier, Supprimer et Ouvrir le projet)
	 * @author Antonin Guillot
	 * @author Estelle BOISSERIE
	 */
	public void enregistrerProjet() {
		// Créer le projet
		ModeleProjet Projet = new ModeleProjet(VueModif.getTitre(), createur, VueModif.getDescription(), VueModif.getDateEcheance());
		new ModelePrend_par(Projet, createur, true);

		// Créer les éléments la vue du projet qui sera dans un panel
		JLabel titre = new JLabel(VueModif.getTitre());

		JButton btnModif = new JButton("Modifier");
		JButton btnSuppr = new JButton("Supprimer");
		JButton btnVoir = new JButton("Ouvrir Projet");

		JPanel pnlProjet = new JPanel();

		// Ajouter des écouteurs aux boutons
		btnSuppr.addActionListener(new ControleurSupprimerProjet(pnlProjet));
		btnModif.addActionListener(new ControleurModifierProjet(Projet, VueInitiale));
		btnVoir.addActionListener(new ControleurVoirProjet(Projet, VueInitiale));

		// Ajouter les éléments au panel
		pnlProjet.add(titre);
		pnlProjet.add(btnVoir);
		pnlProjet.add(btnModif);
		pnlProjet.add(btnSuppr);

		// Appliquer la mise en page
		titre.setFont(POLICECORPS);
		btnModif.setFont(POLICEBOUTON);
		btnSuppr.setFont(POLICEBOUTON);
		btnVoir.setFont(POLICEBOUTON);
		btnModif.setForeground(Color.WHITE);
		btnSuppr.setForeground(Color.WHITE);
		btnVoir.setForeground(Color.WHITE);
		btnModif.setBackground(new Color(0, 78, 125));
		btnSuppr.setBackground(new Color(198, 11, 70));
		btnVoir.setBackground(new Color(243, 115, 32));

		// Ajout du projet à pnlGlobal
		VueInitiale.ajouterProjet(pnlProjet);

		// Mise à jour de l'affichage
		VueInitiale.getPnlGlobal().revalidate();
		VueInitiale.getPnlGlobal().repaint();

		// Effacer les champs du formulaire
		VueModif.getTxtTitre().setText("");
		VueModif.getTxtDateEcheance().setText("");
		VueModif.getTxtDescription().setText("");

		// Fermer la fenêtre de création
		fnrCreation.dispose();
	}
}