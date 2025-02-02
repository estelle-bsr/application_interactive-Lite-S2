package Vues;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import Modeles.*;

/**
 * @author Cathy MARTIN
 *
 *         La classe VueCarte est une vue qui affiche les informations d'une
 *         carte.
 *         Elle permet également d'ajouter des écouteurs pour les actions de
 *         modification de la carte.
 * 
 *         Elle est utilisée pour afficher une carte dans la liste.
 * 
 * Après rendu universitaire : modifications apportées par @author Estelle BOISSERIE
 */

public class VueCarte extends JPanel {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private static final long serialVersionUID = 1L;

	private ModeleCarte carte;

	private JLabel lblNomCarte;
	private JLabel lblDescriptionCarte;
	private JLabel lblDateCarte;
	private JLabel lblStatutCarte;

	private JButton btnModifier;
	private JButton btnSupprimer;

	private final static Font POLICETITRE = new Font("Segoe UI Black", Font.BOLD, 20);
	private final static Font POLICECORPS = new Font("Segoe UI", Font.PLAIN, 15		);

	private final static Color COULEURFOND = new Color(149, 139, 195);



	//---------------------------------
	// CONSTRUCTEUR
	//---------------------------------
	/**
	 * Constructeur de la classe VueCarte.
	 * Crée une vue pour afficher les informations d'une carte.
	 * 
	 * @param carte la Carte à afficher
	 */
	public VueCarte(ModeleCarte Carte) {
		// Mémoriser le modèle sur lequel ce panel est une vue
		this.carte = Carte;

		// Appliquer un style en fond
		setLayout(new GridBagLayout());
		setBackground(Color.white);

		// Créer le panneau pour le titre de la carte
		JPanel pnlTitre = new JPanel(new GridBagLayout());
		lblNomCarte = new JLabel(carte.getNomCarte().toUpperCase());
		lblNomCarte.setFont(POLICETITRE);
		GridBagConstraints gbcTitre = new GridBagConstraints();
		gbcTitre.gridx = 0;
		gbcTitre.gridy = 0;
		gbcTitre.anchor = GridBagConstraints.CENTER;
		pnlTitre.add(lblNomCarte, gbcTitre);

		// Créer le panneau pour les informations de la carte
		JPanel pnlInfo = new JPanel(new GridBagLayout());
		lblDescriptionCarte = new JLabel(carte.getDescriptionCarte());
		lblDateCarte = new JLabel(carte.getDateEcheanceCarte());
		lblStatutCarte = new JLabel(carte.getStatutCarte());
		lblDescriptionCarte.setForeground(Color.WHITE);
		lblDateCarte.setForeground(Color.WHITE);
		lblStatutCarte.setForeground(Color.WHITE);
		GridBagConstraints gbcInfo = new GridBagConstraints();

		gbcInfo.gridx = 0;
		gbcInfo.gridy = 0;
		gbcInfo.anchor = GridBagConstraints.LINE_START;
		pnlInfo.add(new JLabel("Description: "), gbcInfo);

		gbcInfo.gridx = 1;
		gbcInfo.gridy = 0;
		pnlInfo.add(lblDescriptionCarte, gbcInfo);

		gbcInfo.gridx = 0;
		gbcInfo.gridy = 1;
		pnlInfo.add(new JLabel("Date limite: "), gbcInfo);

		gbcInfo.gridx = 1;
		gbcInfo.gridy = 1;
		pnlInfo.add(lblDateCarte, gbcInfo);

		gbcInfo.gridx = 0;
		gbcInfo.gridy = 2;
		pnlInfo.add(new JLabel("Statut: "), gbcInfo);

		gbcInfo.gridx = 1;
		gbcInfo.gridy = 2;
		pnlInfo.add(lblStatutCarte, gbcInfo);

		// Créer les boutons de la carte
		btnModifier = new JButton("Modifier");
		btnModifier.setBackground(new Color(0, 78, 125));
		btnModifier.setForeground(Color.WHITE);
		btnModifier.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		btnModifier.setFont(POLICECORPS);
		btnModifier.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBackground(new Color(198, 11, 70));
		btnSupprimer.setForeground(Color.WHITE);
		btnSupprimer.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		btnSupprimer.setFont(POLICECORPS);
		btnSupprimer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		// Créer un panneau pour les boutons et les aligner horizontalement
		JPanel pnlBoutons = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10)); // FlowLayout pour l'alignement horizontal
		pnlBoutons.add(btnModifier);
		pnlBoutons.add(btnSupprimer);

		pnlBoutons.setBackground(new Color(149, 139, 195));

		// Créer le panneau principal pour organiser les sous-panneaux
		JPanel pnlPanneau = new JPanel(new GridBagLayout());

		// Ajouter les sous-panneaux au panneau principal
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.insets = new Insets(10, 10, 10, 10);
		pnlPanneau.add(pnlTitre, gbc);
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		pnlPanneau.add(pnlInfo, gbc);

		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		pnlPanneau.add(pnlBoutons, gbc);

		// Appliquer des fond de couleur
		pnlTitre.setBackground(COULEURFOND);
		pnlInfo.setBackground(COULEURFOND);
		pnlPanneau.setBackground(COULEURFOND);
		add(pnlPanneau);
	}



	//---------------------------------
	// METHODES
	//---------------------------------
	/**
	 * Ajoute un écouteur pour l'action de cliquer sur le bouton "Modifier".
	 * 
	 * @param ecouteur l'écouteur à ajouter
	 */
	public void btnModifierClick(ActionListener ecouteur) {
		btnModifier.addActionListener(ecouteur);
	}

	/**
	 * Ajoute un écouteur pour l'action de cliquer sur le bouton "Annuler".
	 * 
	 * @param ecouteur l'écouteur à ajouter
	 */
	public void btnSupprimerClick(ActionListener ecouteur) {
		btnSupprimer.addActionListener(ecouteur);
	}

	/**
	 * Met à jour l'affichage de la vue de la carte avec les informations de la
	 * carte actuelle.
	 */
	public void updateVueCarte() {
		lblNomCarte.setText(carte.getNomCarte().toUpperCase());
		lblDescriptionCarte.setText(carte.getDescriptionCarte());
		lblDateCarte.setText(carte.getDateEcheanceCarte());
		lblStatutCarte.setText(carte.getStatutCarte());
	}
}
