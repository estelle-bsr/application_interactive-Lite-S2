package Vues;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Controleurs.*;
import Modeles.*;

/**
 * La classe VueGlobale est la représentation graphique de la gestion du projet. 
 * Elle permet à l'utilisateur d'accéder à son profil, aux participants du projet,
 * et de gérer les tableaux et cartes associées dans une interface ergonomique et moderne.
 * 
 * @author Estelle BOISSERIE
 */

public class VueGlobale extends JPanel {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private static final long serialVersionUID = 1L;

	private ModeleProjet modele;

	private DefaultListModel<String> TitreTableau = new DefaultListModel<>(	);
	private ArrayList<ModeleTableau> Tableau = new ArrayList<>(				);

	private JList<String> lstTableau;

	private JLabel lblLogo = new JLabel("Lite +");
	private JLabel lblTitreProjet;
	private JLabel lblPhotoMembre;

	private JButton btnMembre;
	private JButton btnAjouterParticipant = new JButton("Ajouter des participants"	);
	private JButton btnRafraichir = new JButton("Rafraîchir"						);
	private JButton btnAjouterTableau = new JButton("+"								);
	private JButton btnVoirParticipant = new JButton("Voir les participants"		);

	private JPanel pnlMembre = new JPanel(new GridLayout(1, 2)		);
	private JPanel pnlInformation = new JPanel(new GridLayout(1, 3)	);
	private JPanel pnlListeTableau = new JPanel(new BorderLayout()	);
	private JPanel pnlBoutons = new JPanel(new GridLayout(1, 3)		);
	private JPanel pnlBandeauBoutons = new JPanel(new BorderLayout());
	private JPanel pnlVueTableau = new JPanel(new FlowLayout()		);
	private JPanel pnlGeneral = new JPanel(new BorderLayout()		);

	private final static Border BORDERROUND = BorderFactory.createLineBorder(Color.WHITE, 2, true	);

	private final static Font POLICETITRE = new Font("Segoe UI Black", Font.BOLD, 40);
	private final static Font POLICECORPS = new Font("Segoe UI", Font.PLAIN, 20		);

	private final static Color COULEURTHEME = new Color(99, 00, 60);



	//---------------------------------
	// CONSTRUCTEUR
	//---------------------------------
	/**
	 * Constructeur de la classe VueGlobale.
	 * Crée une instance de VueGlobale pour visualiser et gérer un projet donné.
	 * 
	 * @param modele Le projet affiché
	 **/
	public VueGlobale(ModeleProjet modele) {
		// Mémoriser le modèle
		this.modele = modele;

		// Initialisation des listes
		for (ModeleTableau tableau : modele.getTableaux()) {
			Tableau.add(tableau);
			TitreTableau.addElement(tableau.getNomTableau());
		}

		lstTableau = new JList<>(TitreTableau);
		lstTableau.setFont(POLICECORPS);
		lstTableau.setSelectionBackground(COULEURTHEME);
		lstTableau.setSelectionForeground(Color.WHITE);
		lstTableau.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					afficherTableau(lstTableau.getSelectedIndex());
				}
			}
		});

		// Initialisation des composants
		ImageIcon PhotoDeProfil = redimensionnerPhoto(modele.getCreateurProjet().getImgProfil().getImage());
		lblPhotoMembre = new JLabel(PhotoDeProfil);

		lblTitreProjet = new JLabel(modele.getNomProjet());
		lblTitreProjet.setFont(POLICETITRE);
		lblTitreProjet.setForeground(Color.WHITE);
		lblTitreProjet.setHorizontalAlignment(SwingConstants.CENTER);

		lblLogo.setForeground(Color.WHITE);
		lblLogo.setFont(POLICETITRE);

		btnMembre = new JButton(modele.getCreateurProjet().getNomMembre() + " " + modele.getCreateurProjet().getPrenomMembre());
		btnMembre.setFont(POLICECORPS);
		btnMembre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		configurerBoutons(btnMembre, btnAjouterParticipant, btnRafraichir, btnAjouterTableau, btnVoirParticipant);

		// Bandeau supérieur
		pnlMembre.add(btnMembre);
		pnlMembre.add(lblPhotoMembre);
		pnlMembre.setPreferredSize(new Dimension(150, 75));

		pnlInformation.setBackground(COULEURTHEME);
		pnlInformation.add(lblLogo);
		pnlInformation.add(lblTitreProjet);
		pnlInformation.add(pnlMembre);

		// Zone principale
		pnlListeTableau.add(new JScrollPane(lstTableau), BorderLayout.CENTER);
		pnlGeneral.add(pnlListeTableau, BorderLayout.WEST);
		pnlGeneral.add(pnlVueTableau, BorderLayout.CENTER);

		btnAjouterTableau.setPreferredSize(new Dimension(90, 75));
		btnAjouterTableau.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		// Bandeau inférieur
		pnlBoutons.add(btnAjouterParticipant);
		pnlBoutons.add(btnRafraichir);
		pnlBoutons.add(btnVoirParticipant);

		pnlBandeauBoutons.add(btnAjouterTableau, BorderLayout.WEST);
		pnlBandeauBoutons.add(pnlBoutons, BorderLayout.CENTER);
		pnlBandeauBoutons.setPreferredSize(new Dimension(90, 75));

		// Configuration principale
		setLayout(new BorderLayout());
		add(pnlInformation, BorderLayout.NORTH);
		add(pnlGeneral, BorderLayout.CENTER);
		add(pnlBandeauBoutons, BorderLayout.SOUTH);
	}



	//---------------------------------
	// METHODES
	//---------------------------------

	/**
	 * Affiche le tableau sélectionné dans la zone principale.
	 * 
	 * @param indice L'indice du tableau sélectionné
	 **/
	private void afficherTableau(int indice) {
		// Si l'indice est valide
		if (indice >= 0 && indice < Tableau.size()) {

			// Vider le panel
			pnlVueTableau.removeAll();

			// Récupérer le tableau
			ModeleTableau tableau = Tableau.get(indice);

			// Créer les vues du tableau
			VueTableau vueTableau = new VueTableau(tableau);
			VueModifierTableau vueModifier = new VueModifierTableau(tableau);

			// Créer le contrôleur du tableau
			ControleurTableau ecouteur = new ControleurTableau(tableau, vueTableau, vueModifier);

			/**
			 * Evènement qaund on clique sur le bouton "Modifier".
			 **/
			vueTableau.btnModifierTableauClick(new ActionListener() {
				/**
				 * Evènement quand on clique
				 * @param e Evènement
				 **/
				public void actionPerformed(ActionEvent e) {
					ecouteur.modifierTableau();
				}
			});
			/**
			 * Evènement quand on clique sur le bouton "Ajouter".
			 **/
			vueTableau.btnAjouterListeClick(new ActionListener() {
				/**
				 * Evènement quand on clique
				 * @param e Evènement
				 **/
				public void actionPerformed(ActionEvent e) {
					ecouteur.CreeListe();
				}
			});
			/**
			 * Evènement quand on clique sur le bouton "Supprimer".
			 */
			vueTableau.btnSupprimerClick(new ActionListener() {
				/**
				 * Evènement quand on clique
				 * @param e Evènement
				 **/
				public void actionPerformed(ActionEvent e) {
					// Si l'indice est valide
					if (indice >= 0 && indice < Tableau.size()) {
						// Supprimer le tableau
						Tableau.remove(indice);           
						TitreTableau.remove(indice);      
						lstTableau.setModel(TitreTableau);

						// Mise à jour de la vue
						pnlVueTableau.removeAll();
						pnlVueTableau.revalidate();
						pnlVueTableau.repaint();
					}
				}
			});

			// Mise en page du panel
			pnlVueTableau.setLayout(new BorderLayout()); 
			// Ajouter la vue du tableau dans le panel
			pnlVueTableau.add(vueTableau, BorderLayout.CENTER);

			// Mise à jour de l'affichage
			pnlVueTableau.revalidate();
			pnlVueTableau.repaint();
		}
	}

	/**
	 * Redimensionne une photo pour l'adapter à l'affichage du profil.
	 * 
	 * @param img L'image à redimensionner
	 * @return Une icône redimensionnée
	 **/
	private ImageIcon redimensionnerPhoto(Image img) {
		Image resizedImage = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		return new ImageIcon(resizedImage);
	}

	/**
	 * Configure les styles de base pour un ensemble de boutons.
	 * 
	 * @param boutons Les boutons à configurer
	 **/
	private void configurerBoutons(JButton... boutons) {
		for (JButton bouton : boutons) {
			bouton.setFont(POLICECORPS);
			bouton.setBackground(COULEURTHEME);
			bouton.setForeground(Color.WHITE);
			bouton.setBorder(BORDERROUND);
			bouton.setFocusPainted(false);
			bouton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
	}

	/**
	 * Mettre à jour la photo de profil dans la vue.
	 **/
	public void miseAJourPhoto() {
		// Récupérer la photo de profile
		ImageIcon imgProfil = modele.getCreateurProjet().getImgProfil();
		Image photoProfil;

		// S'il y a une image
		if (imgProfil != null) {
			// Afficher l'image
			photoProfil = imgProfil.getImage();
		} else {
			// Si non afficher l'image par défaut
			photoProfil = new ImageIcon("src/images/avatar_par_defaut.png").getImage();
		}

		// Afficher l'image
		Image photoRedimensionnee = photoProfil.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		lblPhotoMembre.setIcon(new ImageIcon(photoRedimensionnee));

		// Mise à jour de la vue
		revalidate();
		repaint();
	}

	/**
	 * Met à jour la liste des tableaux affichés avec un nouveau tableau.
	 * 
	 * @param nouveauTableau Le nouveau tableau à ajouter et afficher.
	 */
	public void miseAJourTableau(ModeleTableau nouveauTableau) {
		// Ajouter le titre et le tableau au modèle
		TitreTableau.addElement(nouveauTableau.getNomTableau());
		Tableau.add(nouveauTableau);

		// Mettre à jour la JList
		lstTableau.setModel(TitreTableau);

		// Actualiser l'affichage
		revalidate();
		repaint();
	}

	/**
	 * Ajoute un écouteur aux différents boutons pour les actions utilisateur.
	 * @param ActionListener L'écouteur.
	 **/
	public void btnMembreClick(ActionListener ecouteur) {
		btnMembre.addActionListener(ecouteur);
	}

	/**
	 * Ajoute un écouteur aux différents boutons pour les actions utilisateur.
	 * @param ActionListener L'écouteur.
	 **/
	public void btnAjouterParticipantClick(ActionListener ecouteur) {
		btnAjouterParticipant.addActionListener(ecouteur);
	}

	/**
	 * Ajoute un écouteur aux différents boutons pour les actions utilisateur.
	 * @param ActionListener L'écouteur.
	 **/
	public void btnRafraichirClick(ActionListener ecouteur) {
		btnRafraichir.addActionListener(ecouteur);
	}

	/**
	 * Ajoute un écouteur aux différents boutons pour les actions utilisateur.
	 * @param ActionListener L'écouteur.
	 **/
	public void btnAjouterTableauClick(ActionListener ecouteur) {
		btnAjouterTableau.addActionListener(ecouteur);
	}

	/**
	 * Ajoute un écouteur aux différents boutons pour les actions utilisateur.
	 * @param ActionListener L'écouteur.
	 **/
	public void btnVoirParticipantClick(ActionListener ecouteur) {
		btnVoirParticipant.addActionListener(ecouteur);
	}
}
