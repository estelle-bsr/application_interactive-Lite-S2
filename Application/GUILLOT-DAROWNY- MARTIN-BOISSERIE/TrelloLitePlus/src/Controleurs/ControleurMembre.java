package Controleurs;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;
import java.io.*;
import java.util.*;
import Modeles.*;
import Vues.*;

/**
 * La classe ControleurMembre est une classe qui représente le contrôleur des membres.
 * Elle permet l'action des boutons grâce aux méthodes codées.
 * Ici, ControleurMembre permet de modifier le profil d'un membre, de rafraîchir le profil 
 * du membre, de voir les commentaires écrit par le membre, et les projets et cartes où participe le membre.
 * 
 * @author Estelle BOISSERIE
 **/

public class ControleurMembre {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private ModeleMembre Membre;

	private VueMembre VueInitiale;
	private VueMembreModifie VueModifie;

	private JFrame fnrProfil = new JFrame("Modification Profil");



	//---------------------------------
	// CONSTRUCTEUR
	//---------------------------------
	/**
	 * Constructeur de la classe ControleurMembre. 
	 * Il créé une instance de ControleurMembre afin de l'utiliser comme écouteur des vues.
	 * 
	 * @param membre Le membre
	 * @param vue Le profil du membre
	 * @param VueModifie La vue de modification du profil du membre
	 **/
	public ControleurMembre(ModeleMembre membre, VueMembre vue, VueMembreModifie VueModifie) {
		Membre = membre;
		VueInitiale = vue;
		this.VueModifie = VueModifie;

	}



	//---------------------------------
	// METHODES
	//---------------------------------
	/**
	 * Afficher la vue de modification du profil.
	 **/
	public void modifierProfil() {
		// La fenêtre se ferme quand on appuit sur la croix
		fnrProfil.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Ajouter la vue
		fnrProfil.getContentPane().add(VueModifie);
		// Adapter de la taille de la fenêtre
		fnrProfil.pack();
		// Rendre visible la fenêtre
		fnrProfil.setVisible(true);
	}

	/**
	 * Enregistrer les nouvelles informations du membre.
	 **/
	public void enregistrement() {
		// Enregistrer les nouvelles valeures
		Membre.setNomMembre(VueModifie.getNomMembre());
		Membre.setPrenomMembre(VueModifie.getPrenomMembre());
		Membre.setMailMembre(VueModifie.getMailMembre());

		// Vérifier les mots de passe
		// Si le mot de passe entré est différent du mot de passe en stockage
		if (!(VueModifie.getAncienMotdepasse().equals(Membre.getMotdepasseMembre()))) {
			// Afficher une erreure
			JOptionPane.showMessageDialog(null, "ERREUR: Le mot de passe actuel saisie est incorrect.", "Avertissement",
					JOptionPane.WARNING_MESSAGE);
		}
		// Si le nouveau mot de passe est différent du mot de passe en confirmation
		else if (!(VueModifie.getNouveauMotdepasse().equals(VueModifie.getMotdepasseConfirme()))) {
			// Afficher une erreure
			JOptionPane.showMessageDialog(null,
					"ERREUR: Le nouveau mot de passe n'est pas saisie correctement lors de sa confirmation.", "Avertissement",
					JOptionPane.WARNING_MESSAGE);
		}
		// Si non
		else {
			// Modifier le mot de passe
			Membre.setMotdepasseMembre(VueModifie.getNouveauMotdepasse());
		}
		// Afficher une fenêtre de dialogue
		int reponse = JOptionPane.showConfirmDialog(null,
				"Confirmez vous vos modifications ? Si vous laissez des erreurs, les modifications ne seront pas effectuées.",
				"Confirmation", JOptionPane.YES_NO_OPTION);
		// Si le membre valide ses choix
		if (reponse == JOptionPane.YES_OPTION) {
			// Fermer la fenêtre
			fnrProfil.dispose();
			// Vider les cases de saisie texte
			VueModifie.viderCase();
		}
	}

	/**
	 * Mettre a jour le profil.
	 **/
	public void rafraichir() {
		VueInitiale.Redessiner(Membre);
	}

	/**
	 * Voir les commentaires écrit par le membre
	 **/
	public void voirCommentaire() {
		// Créer une fenêtre principale
		JFrame fnrCommentaire = new JFrame("Mes commentaires");

		// Créer un panneau principal avec un Layout flexible
		JPanel pnlCommentaire = new JPanel();
		pnlCommentaire.setLayout(new BoxLayout(pnlCommentaire, BoxLayout.Y_AXIS));

		// Vérifier s'il y a des commentaires
		if (Membre.getMesCommentaires().size() >= 1) {
			// Ajouter chaque commentaire dans la fenêtre
			for (int i = 0; i < Membre.getMesCommentaires().size(); i++) {
				// Créer la vue de la carte
				VueCommentaire commentaire = new VueCommentaire(Membre.getMesCommentaires().get(i));
				commentaire.setBorder(new CompoundBorder(
						new LineBorder(Color.GRAY, 1),
						new EmptyBorder(10, 10, 10, 10)
						));

				// Ajouter le commentaire au panneau
				pnlCommentaire.add(commentaire);

			}
		} else {
			// Si aucun commentaire, afficher un message dans la fenêtre
			JLabel lblAucunCommentaire = new JLabel("Aucun commentaire trouvé", JLabel.CENTER);
			lblAucunCommentaire.setFont(new Font("Open Sans Bold", Font.BOLD, 15));
			pnlCommentaire.add(lblAucunCommentaire);
		}

		// Ajouter un ScrollPane pour faire défiler si nécessaire
		JScrollPane scrollPane = new JScrollPane(pnlCommentaire);
		scrollPane.setPreferredSize(new Dimension(400, 300));  // Vous pouvez ajuster les dimensions
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		// Préparer et afficher la fenêtre
		fnrCommentaire.getContentPane().add(scrollPane);
		fnrCommentaire.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fnrCommentaire.pack();
		fnrCommentaire.setLocationRelativeTo(null);
		fnrCommentaire.setVisible(true);
	}

	/**
	 * Voir les projets dont le membre participe.
	 **/
	public void voirProjet() {
		// Si le membre participe à des projets
		if (Membre.getMesProjets().size() >= 1) {
			// Créer une fenêtre pour les projets
			JFrame fnrProjet = new JFrame("Mes projets");

			// Créer les labels pour la description du projet et la date d'échéance
			JLabel lblProjet = new JLabel("Mes projets :", JLabel.CENTER);
			JLabel lblDescription = new JLabel("Description :");
			JLabel lblDate = new JLabel("Date échéance :");
			JLabel lblDescriptionProjet = new JLabel();
			JLabel lblDateProjet = new JLabel();

			// Créer les panels
			JPanel pnlProjet = new JPanel(new GridLayout(1, 2));
			JPanel pnlDescription = new JPanel(new GridLayout(2, 1));
			JPanel pnlDate = new JPanel(new GridLayout(2, 1));
			JPanel pnlInfo = new JPanel(new GridLayout(1, 2));
			JPanel pnlGeneral = new JPanel(new BorderLayout());

			// Liste de projets
			DefaultListModel<String> TitreProjet = new DefaultListModel<>();
			ArrayList<ModeleProjet> Projet = new ArrayList<>();

			// Ajouter les projets à la liste
			for (int i = 0; i < Membre.getMesProjets().size(); i++) {
				ModeleProjet projet = Membre.getMesProjets().get(i);
				Projet.add(projet);
				TitreProjet.addElement(projet.getNomProjet());
			}

			// Créer une JList pour afficher les titres de projet
			JList<String> lstProjet = new JList<>(TitreProjet);
			lstProjet.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			lstProjet.setFont(new Font("Open Sans Semibold", Font.BOLD, 14));

			// Personnalisation de l'apparence des labels
			lblProjet.setFont(new Font("Open Sans Semibold", Font.BOLD, 20));
			lblProjet.setPreferredSize(new Dimension(300, 70));
			lblProjet.setForeground(Color.WHITE);

			// Personnalisation de la JList (couleur de fond et survol)
			lstProjet.setBackground(new Color(240, 240, 240));
			lstProjet.setSelectionBackground(new Color(51, 153, 255));
			lstProjet.setSelectionForeground(Color.WHITE);
			lstProjet.setFont(new Font("Open Sans Semibold", Font.BOLD, 16));

			// Personnalisation des panels
			pnlInfo.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
			pnlProjet.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

			// Ajouter des bordures avec couleurs sur les panels de description et de date
			pnlDescription.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(new Color(0, 78, 125), 2),    
					"Informations sur le projet", 
					TitledBorder.LEFT, 
					TitledBorder.TOP, 
					new Font("Open Sans Semibold", Font.BOLD, 14), new Color(0, 78, 125)));
			pnlDate.setBorder(BorderFactory.createTitledBorder(
					BorderFactory.createLineBorder(new Color(198, 11, 70), 2),    
					"Échéance", 
					TitledBorder.LEFT, 
					TitledBorder.TOP, 
					new Font("Open Sans Semibold", Font.BOLD, 14), new Color(198, 11, 70)));

			// Style de la description et de la date
			lblDescription.setForeground(new Color(0, 78, 125));
			lblDate.setForeground(new Color(198, 11, 70));

			// Pour rendre la fenêtre agréable visuellement, en utilisant un fond de fenêtre clair
			pnlGeneral.setBackground(new Color(99, 0, 60)); 

			// Gestion de la sélection des projets
			lstProjet.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					if (!e.getValueIsAdjusting()) {
						String projetSelectionne = lstProjet.getSelectedValue();
						int indice = lstProjet.getSelectedIndex();
						if (projetSelectionne != null) {
							ModeleProjet selectedProjet = Projet.get(indice);
							lblDescriptionProjet.setText(selectedProjet.getDescriptionProjet());
							lblDateProjet.setText(selectedProjet.getDateEcheanceProjet());
						}
					}
				}
			});

			// Ajouter les panneaux à pnlInfo
			pnlDescription.add(lblDescription);
			pnlDescription.add(lblDescriptionProjet);
			pnlDate.add(lblDate);
			pnlDate.add(lblDateProjet);
			pnlInfo.add(pnlDescription);
			pnlInfo.add(pnlDate);

			// Ajouter la liste de projets et les informations de projet
			pnlProjet.add(new JScrollPane(lstProjet));
			pnlProjet.add(pnlInfo);

			// Ajouter tout le contenu à la fenêtre
			pnlGeneral.add(lblProjet, BorderLayout.NORTH);
			pnlGeneral.add(pnlProjet, BorderLayout.CENTER);

			// Configurer la fenêtre
			fnrProjet.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			fnrProjet.getContentPane().add(pnlGeneral);
			fnrProjet.pack();
			fnrProjet.setLocationRelativeTo(null);
			fnrProjet.setVisible(true);

		} else {
			// Si aucun projet trouvé, afficher un message d'erreur stylisé
			JOptionPane.showMessageDialog(null,
					"ERREUR: Vous n'avez aucun projet.", "Avertissement",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
	 * Voir les cartes dont le membre participe.
	 **/
	public void voirCarte() {
		// Créer une fenêtre pour les cartes
		JFrame fnrCarte = new JFrame("Mes cartes");

		// Créer un panel principal pour accueillir les cartes
		JPanel pnlCarte = new JPanel();
		pnlCarte.setLayout(new GridLayout(0, 1, 10, 10));

		// Vérifier si le membre possède des cartes
		if (Membre.getMesCartes().size() >= 1) {
			// Pour chaque carte commentée par le membre
			for (int i = 0; i < Membre.getMesCartes().size(); i++) {
				// Créer la vue de la carte
				VueCarte carte = new VueCarte(Membre.getMesCartes().get(i));
				VueModifierCarte VueModifie = new VueModifierCarte(Membre.getMesCartes().get(i));
				ControleurCarte ecouteur = new ControleurCarte(Membre.getMesCartes().get(i), carte, VueModifie);
				// Ajouter l'écouteur pour le bouton "Créer" de la vue de création de carte
				carte.btnModifierClick(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ecouteur.modifierCarte();
					}
				});

				// Ajouter la carte au panel
				pnlCarte.add(carte);
			}

			// La fenêtre se ferme quand on appuie sur la croix
			fnrCarte.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			// Ajouter le panel des cartes à la fenêtre
			fnrCarte.getContentPane().add(new JScrollPane(pnlCarte));

			// Adapter la taille de la fenêtre
			fnrCarte.setSize(600, 400);
			fnrCarte.setLocationRelativeTo(null);
			fnrCarte.setVisible(true);
		} else {
			// Si l'utilisateur n'a pas de cartes, afficher une erreur stylisée
			JOptionPane.showMessageDialog(null,
					"ERREUR: Vous n'avez aucune carte.", "Avertissement",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
	 * Changer la photo de profil du membre
	 **/
	public void changerPhoto() {
		//Ouvrir l'explorateur de fichier
		JFileChooser ExplorateurDeFichier = new JFileChooser();
		// Afficher uniquement les fichiers d'images
		ExplorateurDeFichier.setFileFilter(new javax.swing.filechooser.FileFilter() {
			public boolean accept(File fichiers) {
				return fichiers.isDirectory() || fichiers.getName().toLowerCase().endsWith(".jpg")
						|| fichiers.getName().toLowerCase().endsWith(".png")
						|| fichiers.getName().toLowerCase().endsWith(".gif");
			}
			public String getDescription() {
				return "Fichiers d'images (*.jpg, *.png, *.gif)";
			}
		});
		// Afficher le sélecteur de fichiers
		int Resultat = ExplorateurDeFichier.showOpenDialog(VueModifie);
		// Si le fichier est sélectionné
		if (Resultat == JFileChooser.APPROVE_OPTION) {
			// Récupérer le fichier
			File FichierSelectionne = ExplorateurDeFichier.getSelectedFile();
			// Convertir le fichier en image
			ImageIcon PhotoSelectionnee = new ImageIcon(FichierSelectionne.getAbsolutePath());
			// Redimensionner l'image 
			Image Photo = PhotoSelectionnee.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			ImageIcon NouvellePhotoDeProfil = new ImageIcon(Photo);
			// Créer un label pour la photo
			JLabel lblApercu = new JLabel();
			// Ajouter la photo au label
			lblApercu.setIcon(NouvellePhotoDeProfil);
			// Enregistrer la nouvelle image
			Membre.setImgProfil(NouvellePhotoDeProfil);
			// Afficher un aperçu de l'image sélectionnée
			JOptionPane.showMessageDialog(null, lblApercu, "Image sélectionnée", JOptionPane.PLAIN_MESSAGE);
		}
	}
}
