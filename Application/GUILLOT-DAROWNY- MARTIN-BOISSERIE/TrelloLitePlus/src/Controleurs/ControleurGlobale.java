package Controleurs;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import Modeles.*;
import Vues.*;

/**
 * Cette classe ControleurGlobale est le controleur de la vue globale. 
 * Elle permet de réaliser les évènements. 
 * Ici, dans la classe ControleurGlobale permet d'afficher le profil du membre,
 * d'ajouter des participants, de voir les participants, de mettre à jour la vue, 
 * et d'ajouter des tableaux.
 * 
 * @author Estelle BOISSERIE
 **/
public class ControleurGlobale {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private ModeleProjet Projet;

	private VueGlobale Vue;

	private final static Font POLICETITRE = new Font("Open Sans Bold", Font.BOLD, 20     );
	private final static Font POLICECORPS = new Font("Open Sans Semibold", Font.PLAIN, 15);

	private final static Color COULEURTHEME = new Color(99, 00, 60);




	//---------------------------------
	// CONSTRUCTEUR
	//---------------------------------
	/**
	 * Constructeur de la classe ControleurGlobale.
	 * Il permet de créer une instance de ControleurGlobale afin de l'utiliser comme écouteur.
	 * 
	 * @param projet Le projet affiché.
	 * @param vue La vue du projet.
	 **/
	public ControleurGlobale(ModeleProjet projet, VueGlobale vue) {
		Projet = projet;
		Vue = vue;
	}



	//---------------------------------
	// METHODES
	//---------------------------------
	/**
	 * Afficher le profil du membre en charge du profil.
	 **/
	public void afficherProfil() {
		// Créer la fenetre du profil du membre
		JFrame fnrProfil = new JFrame("Compte");
		// Cliquer sur la croix de la fenêtre ferme celle-ci
		fnrProfil.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Créer le fichier de sérialisation
		//File Fichier = new File ("membres.dat");

		// Créer une vue du profil du membre
		VueMembre Profil = new VueMembre(Projet.getCreateurProjet());
		// Créer une vue pour les modification du profil du membre
		VueMembreModifie ProfilModifie = new VueMembreModifie(Projet.getCreateurProjet());

		// Créer un controleur du membre
		ControleurMembre ecouteurMembre = new ControleurMembre(Projet.getCreateurProjet(), Profil, ProfilModifie);

		// Sérialisation
		// Si le fichier de sérialisation n'existe pas
		/*if (!Fichier.exists()) {
			System.out.println ("Le fichier favoris.dat n'existe pas !");
			// Serialiser l'objet favoris : on le transforme en une SERIE d'octets qu'on écrit sur disque
			System.out.println ("Enregistrement de l'objet favoris sur disque");
			FileOutputStream fichier = new FileOutputStream("membres.dat");
			ObjectOutputStream flotObjet = new ObjectOutputStream(fichier);
			flotObjet.writeObject(Projet.getMembres());
			flotObjet.close();
		} 
		else {
			// Si le fichier favoris.dat existe déjà
			System.out.println ("Le fichier favoris.dat existe !");
			FileInputStream fichier = new FileInputStream("membres.dat");
			ObjectInputStream flotObjet = new ObjectInputStream(fichier);
			createur = (ModeleMembre) (flotObjet.readObject());
			flotObjet.close();;
		}
		 */

		/**
		 * Cliquer sur le bouton "Modifier".
		 **/
		Profil.btnModifierClick(new ActionListener() {
			/**
			 * Evènement quand on clique
			 * @param e Evènement
			 **/
			public void actionPerformed(ActionEvent e) {
				ecouteurMembre.modifierProfil();
			}
		});
		/**
		 * Cliquer sur le bouton "Rafraîchir".
		 **/
		Profil.btnRafraichirClick(new ActionListener() {
			/**
			 *  Evènement quand on clique.
			 * @param e Evènement
			 **/
			public void actionPerformed(ActionEvent e) {
				ecouteurMembre.rafraichir();
			}
		});
		/**
		 * Cliquer sur le bouton "Voir mes commentaires".
		 **/
		Profil.btnCommentaireClick(new ActionListener() {
			/**
			 *  Evènement quand on clique.
			 * @param e Evènement
			 **/
			public void actionPerformed(ActionEvent e) {
				ecouteurMembre.voirCommentaire();
			}
		});
		/**
		 * Cliquer sur le bouton "Voir mes projets".
		 **/
		Profil.btnProjetClick(new ActionListener() {
			/**
			 *  Evènement quand on clique.
			 * @param e Evènement
			 **/
			public void actionPerformed(ActionEvent e) {
				ecouteurMembre.voirProjet();
			}
		});
		/**
		 *Cliquer sur le bouton "Modifier".
		 **/
		Profil.btnCarteClick(new ActionListener() {
			/**
			 *  Evènement quand on clique.
			 * @param e Evènement
			 **/
			public void actionPerformed(ActionEvent e) {
				ecouteurMembre.voirCarte();
			}
		});
		/**
		 *Cliquer sur le bouton "Sauvegarde".
		 **/
		ProfilModifie.btnSauvegardeClick(new ActionListener() {
			/**
			 *  Evènement quand on clique.
			 * @param e Evènement
			 **/
			public void actionPerformed(ActionEvent e) {
				ecouteurMembre.enregistrement();
			}
		});
		/**
		 *Cliquer sur le bouton "Modifier".
		 **/
		ProfilModifie.btnPhotoClick(new ActionListener() {
			/**
			 *  Evènement quand on clique.
			 * @param e Evènement
			 **/
			public void actionPerformed(ActionEvent e) {
				ecouteurMembre.changerPhoto();
			}
		});

		// Ajouter la vue à la fenêtre
		fnrProfil.add(Profil);
		// Adapter la taille de la fenêtre
		fnrProfil.pack();
		// Centrer la fenêtre
		fnrProfil.setLocationRelativeTo(null); 
		// Afficher la fenêtre
		fnrProfil.setVisible(true);
	}


	/**
	 * Ajouter des participants.
	 **/
	public void ajouterParticipant() {
		// Créer la fenêtre principale des membres
		JFrame fnrParticipant = new JFrame("Les personnes possibles");
		fnrParticipant.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Créer un label titre
		JLabel lblPermission = new JLabel("Donnez-vous la permission au membre d'agir sur le projet ?");
		lblPermission.setFont(POLICETITRE);
		lblPermission.setForeground(Color.BLACK);

		// Créer des checkboxes pour donner/ne pas donner la permission
		JCheckBox ChoixOui = new JCheckBox("Donner la permission");
		JCheckBox ChoixNon = new JCheckBox("Ne pas donner la permission");

		// Créer le bouton Ajouter
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBackground(COULEURTHEME);
		btnAjouter.setForeground(Color.WHITE);
		btnAjouter.setFocusPainted(false);
		btnAjouter.setFont(POLICECORPS);

		// Créer des membres
		ModeleMembre membre1 = new ModeleMembre("Boisserie", "Estelle", "mdp", "estelle.boisserie@universite-paris-saclay.fr");
		ModeleMembre membre2 = new ModeleMembre("Martin", "Cathy", "MDP", "cathy.martin@universite-paris-saclay.fr");
		ModeleMembre membre3 = new ModeleMembre("Guillot", "Antonin", "motdepasse", "antonin.guillot@universite-paris-saclay.fr");
		ModeleMembre membre4 = new ModeleMembre("Darowny", "Corentin", "MotDePasse", "corentin.darowny@universite-paris-saclay.fr");

		// Liste des membres
		ArrayList<ModeleMembre> Membres = new ArrayList<ModeleMembre>();
		Membres.add(membre1);
		Membres.add(membre2);
		Membres.add(membre3);
		Membres.add(membre4);

		// Liste des membres affichée
		DefaultListModel<String> membresListModel = new DefaultListModel<String>();
		membresListModel.addElement(membre1.getNomMembre() + " " + membre1.getPrenomMembre());
		membresListModel.addElement(membre2.getNomMembre() + " " + membre2.getPrenomMembre());
		membresListModel.addElement(membre3.getNomMembre() + " " + membre3.getPrenomMembre());
		membresListModel.addElement(membre4.getNomMembre() + " " + membre4.getPrenomMembre());

		// Créer la JList des membres
		JList<String> lstMembre = new JList<String>(membresListModel);
		lstMembre.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstMembre.setFont(POLICECORPS);
		lstMembre.setBackground(new Color(245, 245, 245));

		// Ajouter la liste des membres dans un JScrollPane pour une meilleure interaction
		JScrollPane scrollPane = new JScrollPane(lstMembre);
		scrollPane.setPreferredSize(new Dimension(300, 150));

		// Créer un panel principal pour l'interface
		JPanel pnlMain = new JPanel();
		pnlMain.setLayout(new BorderLayout());
		pnlMain.add(lblPermission, BorderLayout.NORTH);
		pnlMain.add(scrollPane, BorderLayout.CENTER);
		pnlMain.add(ChoixOui, BorderLayout.SOUTH);
		pnlMain.add(ChoixNon, BorderLayout.SOUTH);
		pnlMain.add(btnAjouter, BorderLayout.SOUTH);

		// Ajouter à la fenêtre principale
		fnrParticipant.add(pnlMain);

		// Mettre une taille et centrer la fenêtre
		fnrParticipant.setSize(400, 300);
		fnrParticipant.setLocationRelativeTo(null);
		fnrParticipant.setVisible(true);

		// Ajouter un écouteur au bouton Ajouter
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Vérifier si un membre a été sélectionné
				int selectedIndex = lstMembre.getSelectedIndex();
				if (selectedIndex != -1) {
					ModeleMembre membreSelectionne = Membres.get(selectedIndex);

					// Créer une fenêtre de dialogue pour la gestion des permissions
					JFrame fnrPermission = new JFrame("Choix de la permission");
					fnrPermission.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

					// Panel pour gérer les permissions
					JPanel pnlGeneral = new JPanel();
					pnlGeneral.setLayout(new BoxLayout(pnlGeneral, BoxLayout.Y_AXIS));
					pnlGeneral.add(lblPermission);
					pnlGeneral.add(ChoixOui);
					pnlGeneral.add(ChoixNon);

					// Ajouter à la fenêtre de permission
					fnrPermission.add(pnlGeneral, BorderLayout.CENTER);
					fnrPermission.add(btnAjouter, BorderLayout.SOUTH);
					fnrPermission.pack();
					fnrPermission.setLocationRelativeTo(null);
					fnrPermission.setVisible(true);

					// Fermer la première fenêtre (liste des membres) après avoir cliqué sur "Ajouter"
					fnrParticipant.dispose();

					// Gestion des checkboxes
					ChoixOui.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent e) {
							if (e.getStateChange() == ItemEvent.SELECTED) {
								// Demander confirmation avant d'ajouter la permission
								int reponse = JOptionPane.showConfirmDialog(fnrPermission,
										"Souhaitez-vous donner la permission à " + membreSelectionne.getNomMembre() + " ?",
										"Confirmation", JOptionPane.YES_NO_OPTION);
								if (reponse == JOptionPane.YES_OPTION) {
									// Ajouter la permission au membre sélectionné
									new ModelePrend_par(Projet, membreSelectionne, true);
									fnrPermission.dispose();
								}
							}
						}
					});

					// Gestion de l'option "Ne pas donner la permission"
					ChoixNon.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent e) {
							if (e.getStateChange() == ItemEvent.SELECTED) {
								// Demander confirmation avant de retirer la permission
								int reponse = JOptionPane.showConfirmDialog(fnrPermission,
										"Souhaitez-vous ne pas donner la permission à " + membreSelectionne.getNomMembre() + " ?",
										"Confirmation", JOptionPane.YES_NO_OPTION);
								if (reponse == JOptionPane.YES_OPTION) {
									// Enlever la permission du membre sélectionné
									new ModelePrend_par(Projet, membreSelectionne, false);
									fnrPermission.dispose();
								}
							}
						}
					});

				} else {
					JOptionPane.showMessageDialog(fnrParticipant, "Veuillez sélectionner un membre avant de continuer.");
				}
			}
		});
	}



	/**
	 * Met à jour la vue.
	 **/
	public void restructure() {
		Vue.miseAJourPhoto();
	}


	/**
	 * Ajouter un tableau.
	 **/
	public void ajouterTableau() {
		// Créer une fenêtre de dialogue
		JDialog fnrAjouterTableau = new JDialog();

		// Créer un label
		JLabel lblTitre = new JLabel("Comment souhaitez-vous intituler votre tableau ?");
		lblTitre.setFont(new Font("Open Sans Semibold", Font.PLAIN, 18));
		lblTitre.setForeground(Color.BLACK);

		// Créer une saisie de texte 
		JTextField txtTitre = new JTextField(20);
		txtTitre.setFont(new Font("Open Sans Semibold", Font.PLAIN, 14));
		txtTitre.setBackground(new Color(245, 245, 245));
		txtTitre.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
		txtTitre.setPreferredSize(new Dimension(200, 30));

		// Créer un bouton
		JButton btnCreer = new JButton("Créer");
		btnCreer.setFont(new Font("Open Sans Semibold", Font.PLAIN, 16));
		btnCreer.setBackground(new Color(99, 0, 60));
		btnCreer.setForeground(Color.WHITE);
		btnCreer.setFocusPainted(false);
		btnCreer.setPreferredSize(new Dimension(150, 40));

		// Créer un panel pour le texte et le champ de saisie
		JPanel pnlTitre = new JPanel();
		pnlTitre.setLayout(new BoxLayout(pnlTitre, BoxLayout.Y_AXIS));
		pnlTitre.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Ajouter le titre et le champ de texte au panel
		pnlTitre.add(lblTitre);
		pnlTitre.add(Box.createRigidArea(new Dimension(0, 10)));
		pnlTitre.add(txtTitre);
		pnlTitre.add(Box.createRigidArea(new Dimension(0, 20)));

		// Créer la fenêtre de dialogue avec une mise en page fluide
		fnrAjouterTableau.setLayout(new BorderLayout());
		fnrAjouterTableau.add(pnlTitre, BorderLayout.CENTER);
		fnrAjouterTableau.add(btnCreer, BorderLayout.SOUTH);

		btnCreer.setBackground(new Color(90, 0, 60)); 
		// Ajouter un écouteur au bouton
		btnCreer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCreer.setBackground(new Color(64, 183, 105));
				int Reponse = JOptionPane.showConfirmDialog(null,
						"Souhaitez-vous ajouter le tableau \"" + txtTitre.getText() + "\" ?",
						"Confirmation", JOptionPane.YES_NO_OPTION);

				if (Reponse == JOptionPane.YES_OPTION) {
					ModeleTableau NouveauTableau = new ModeleTableau(txtTitre.getText());
					Projet.ajouterTableau(NouveauTableau);
					Vue.miseAJourTableau(NouveauTableau);
					fnrAjouterTableau.dispose(); 
				}
			}
		});

		// Mettre un titre à la fenêtre 
		fnrAjouterTableau.setTitle("Création de Tableau");
		// Utiliser pack() pour ajuster la taille
		fnrAjouterTableau.pack();
		// Mettre une taille minimale pour garantir que le contenu soit toujours lisible
		fnrAjouterTableau.setMinimumSize(new Dimension(350, 250));
		// Bloquer l'interaction avec la fenêtre principale
		fnrAjouterTableau.setModal(true);
		// Centrer la fenêtre sur l'écran
		fnrAjouterTableau.setLocationRelativeTo(null);
		// Afficher la fenêtre
		fnrAjouterTableau.setVisible(true);
	}



	/**
	 * Voir les participants du projet.
	 **/
	public void voirParticipant() {
		// Fenêtre principale des participants
		JFrame fnrParticipant = new JFrame("Les participants");
		fnrParticipant.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Panel général et mise en page de la fenêtre
		JPanel pnlPrincipal = new JPanel();
		pnlPrincipal.setLayout(new BorderLayout(10, 10));
		pnlPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		// Créer une liste des modèles de participants
		ArrayList<ModeleMembre> Participants = new ArrayList<ModeleMembre>();

		// Créer la liste des noms des participants et leur permission
		DefaultListModel<String> participants = new DefaultListModel<String>();

		// Ajouter un bouton avec un design amélioré
		JButton btnModifierPermission = new JButton("Modifier la permission");
		btnModifierPermission.setFont(POLICECORPS);
		btnModifierPermission.setBackground(COULEURTHEME);
		btnModifierPermission.setForeground(Color.WHITE);
		btnModifierPermission.setFocusPainted(false);
		btnModifierPermission.setBorderPainted(false);
		btnModifierPermission.setPreferredSize(new Dimension(200, 30));

		// Créer un panel pour contenir la liste et le bouton avec disposition en colonnes
		JPanel pnlListeEtBouton = new JPanel();
		pnlListeEtBouton.setLayout(new BoxLayout(pnlListeEtBouton, BoxLayout.Y_AXIS));
		pnlListeEtBouton.setAlignmentX(Component.LEFT_ALIGNMENT);

		// Mise en place de la liste des participants
		JList<String> lstParticipant = new JList<String>(participants);
		lstParticipant.setFont(POLICECORPS);
		lstParticipant.setBackground(new Color(245, 245, 245));
		lstParticipant.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Ajouter un JScrollPane pour que la liste soit scrollable
		JScrollPane scrollPane = new JScrollPane(lstParticipant);
		scrollPane.setPreferredSize(new Dimension(400, 200));

		// Ajouter la liste et le bouton au panel principal
		pnlListeEtBouton.add(scrollPane);
		pnlListeEtBouton.add(Box.createRigidArea(new Dimension(0, 10)));
		pnlListeEtBouton.add(btnModifierPermission);

		// Ajouter le panel principal à la fenêtre
		pnlPrincipal.add(pnlListeEtBouton, BorderLayout.CENTER);

		// Liste des membres et permissions
		ArrayList<ModeleMembre> membres = Projet.getMembres();
		if (membres.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Aucun membre trouvé pour ce projet.", "Erreur", JOptionPane.ERROR_MESSAGE);
			return; // Sortir de la méthode si la liste est vide
		}

		// Continuer la boucle s'il y a des membres
		for (int i = 0; i < membres.size(); i++) {
			String nomPrenom = membres.get(i).getNomMembre() + " " + membres.get(i).getPrenomMembre();
			boolean permission = Projet.getParticipation().get(i).getPermissionCollabore();
			participants.addElement(nomPrenom + (permission ? " (Permission accordée)" : " (Permission refusée)"));
			Participants.add(membres.get(i));
		}

		// Mise en place des événements pour modifier la permission
		lstParticipant.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					int indice = lstParticipant.getSelectedIndex();
					if (indice >= 0) {
						// Fenêtre pour gérer les permissions
						JFrame fnrPermission = new JFrame("Gestion des permissions");
						fnrPermission.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						fnrPermission.setLayout(new BorderLayout());
						fnrPermission.setSize(300, 200);

						// Label et checkboxes
						JLabel lblPermission = new JLabel("Donner la permission au membre ?");
						lblPermission.setFont(POLICETITRE);
						lblPermission.setForeground(COULEURTHEME);

						JCheckBox ChoixOui = new JCheckBox("Donner la permission");
						JCheckBox ChoixNon = new JCheckBox("Ne pas donner la permission");

						// Panneau pour les checkboxes
						JPanel pnlChoix = new JPanel();
						pnlChoix.setLayout(new GridLayout(1, 2));
						pnlChoix.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
						pnlChoix.add(ChoixOui);
						pnlChoix.add(ChoixNon);

						// Ajout à la fenêtre
						fnrPermission.add(lblPermission, BorderLayout.NORTH);
						fnrPermission.add(pnlChoix, BorderLayout.CENTER);

						// Gérer l'événement des cases à cocher
						ChoixOui.addItemListener(e1 -> {
							if (e1.getStateChange() == ItemEvent.SELECTED) {
								int reponse = JOptionPane.showConfirmDialog(fnrPermission, "Voulez-vous vraiment accorder la permission ?", "Confirmer", JOptionPane.YES_NO_OPTION);
								if (reponse == JOptionPane.YES_OPTION) {
									Projet.getParticipation().get(indice).setPermissionCollabore(true);
									JOptionPane.showMessageDialog(fnrPermission, "Permission accordée avec succès.");
									fnrPermission.dispose();
									participants.setElementAt(participants.get(indice).replace("(Permission refusée)", "(Permission accordée)"), indice);
								}
							}
						});
						ChoixNon.addItemListener(e2 -> {
							if (e2.getStateChange() == ItemEvent.SELECTED) {
								int reponse = JOptionPane.showConfirmDialog(fnrPermission, "Voulez-vous vraiment retirer la permission ?", "Confirmer", JOptionPane.YES_NO_OPTION);
								if (reponse == JOptionPane.YES_OPTION) {
									Projet.getParticipation().get(indice).setPermissionCollabore(false);
									JOptionPane.showMessageDialog(fnrPermission, "Permission retirée avec succès.");
									fnrPermission.dispose();
									participants.setElementAt(participants.get(indice).replace("(Permission accordée)", "(Permission refusée)"), indice);
								}
							}
						});

						// Afficher la fenêtre
						fnrPermission.setLocationRelativeTo(fnrParticipant);
						fnrPermission.setVisible(true);
					}
				}
			}
		});

		// Configuration finale de la fenêtre principale
		fnrParticipant.add(pnlPrincipal);
		fnrParticipant.setSize(500, 300);
		fnrParticipant.setLocationRelativeTo(null);
		fnrParticipant.setVisible(true);
	}
}