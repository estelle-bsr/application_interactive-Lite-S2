package Vues;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Cette classe représente la vue pour la création d'un projet.
 * Elle permet à l'utilisateur de saisir un titre, une description et une date d'échéance pour créer un projet.
 * Elle contient deux boutons : un pour enregistrer le projet et l'autre pour annuler l'opération.
 * 
 * @author Antonin GUILLOT
 * @author Estelle BOISSERIE
 */
public class VueCreerProjet extends JPanel {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private static final long serialVersionUID = 1L;

	private JTextField txtTitre; 
	private JTextArea txtDescription; 
	private JTextField txtDateEcheance;

	private JButton btnEnregistrer;
	private JButton btnAnnuler;

	private final static Font POLICETITRE = new Font("Segoe UI Black", Font.BOLD, 40);
	private final static Font POLICECORPS = new Font("Segoe UI", Font.PLAIN, 20		);
	private final static Font POLICESAISIE = new Font("Segoe UI", Font.ITALIC, 15   );

	private final static Color THEME = new Color(99, 00, 60);



	//---------------------------------
	// CONSTRUCTEUR
	//---------------------------------
	/**
	 * Constructeur de la classe VueCreerProjet. 
	 * Initialise l'interface de création d'un projet avec un formulaire contenant 
	 * des champs de texte pour le titre, la description, la date d'échéance, et des boutons d'action.
	 */
	public VueCreerProjet() {
		// Appliquer la mise en page arrière
		setLayout(new BorderLayout());
		setBackground(THEME);

		// Titre principal
		JLabel lblTitrePrincipal = new JLabel("Créer votre projet");
		lblTitrePrincipal.setFont(POLICETITRE);
		lblTitrePrincipal.setForeground(Color.WHITE);
		lblTitrePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitrePrincipal, BorderLayout.NORTH);

		JPanel pnlCreation = new JPanel(new GridBagLayout());
		pnlCreation.setBackground(new Color(245, 245, 245)); 
		pnlCreation.setBorder(new EmptyBorder(20, 20, 20, 20)); 

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10); 

		// Titre
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		JLabel lblTitre = new JLabel("Titre :");
		lblTitre.setFont(POLICECORPS);
		pnlCreation.add(lblTitre, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		txtTitre = new JTextField();
		txtTitre.setFont(POLICESAISIE);
		txtTitre.setPreferredSize(new Dimension(250, 30));
		pnlCreation.add(txtTitre, gbc);

		// Description
		gbc.gridx = 0;
		gbc.gridy = 1;
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setFont(POLICECORPS);
		pnlCreation.add(lblDescription, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		txtDescription = new JTextArea(5, 20);
		txtDescription.setFont(POLICESAISIE);
		txtDescription.setLineWrap(true);
		txtDescription.setWrapStyleWord(true);
		txtDescription.setBorder(new LineBorder(Color.BLACK, 1)); 
		txtDescription.setBackground(Color.WHITE); 
		JScrollPane scrollPane = new JScrollPane(txtDescription);
		pnlCreation.add(scrollPane, gbc);

		// Date limite
		gbc.gridx = 0;
		gbc.gridy = 2;
		JLabel lblDateEcheance = new JLabel("Date échéance :");
		lblDateEcheance.setFont(POLICECORPS);
		pnlCreation.add(lblDateEcheance, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		txtDateEcheance = new JTextField();
		txtDateEcheance.setFont(POLICESAISIE);
		txtDateEcheance.setPreferredSize(new Dimension(250, 30));
		pnlCreation.add(txtDateEcheance, gbc);

		// Bouton Enregistrer
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2; 
		btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setFont(POLICECORPS);
		btnEnregistrer.setBackground(new Color(64, 183, 105));
		btnEnregistrer.setForeground(Color.WHITE);
		btnEnregistrer.setFocusPainted(false);
		btnEnregistrer.setPreferredSize(new Dimension(100, 40));
		btnEnregistrer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnlCreation.add(btnEnregistrer, gbc);

		// Bouton Annuler
		gbc.gridy = 4;
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(POLICECORPS);
		btnAnnuler.setBackground(new Color(198, 11, 70)); 
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setFocusPainted(false);
		btnAnnuler.setPreferredSize(new Dimension(100, 40));
		btnAnnuler.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnlCreation.add(btnAnnuler, gbc);

		// Ajout du panel principal au panel extérieur
		add(pnlCreation, BorderLayout.CENTER);
	}



	//---------------------------------
	// METHODES
	//---------------------------------
	/**
	 * Ajoute un écouteur au bouton "Enregistrer" pour gérer le clic sur le bouton.
	 *
	 * @param ecouteur L'écouteur d'événement à ajouter au bouton.
	 */
	public void btnEnregistrerClick(ActionListener ecouteur) {
		btnEnregistrer.addActionListener(ecouteur);
	}

	/**
	 * Ajoute un écouteur au bouton "Annuler" pour gérer le clic sur le bouton.
	 *
	 * @param ecouteur L'écouteur d'événement à ajouter au bouton.
	 */
	public void btnAnnulerClick(ActionListener ecouteur) {
		btnAnnuler.addActionListener(ecouteur);
	}

	/**
	 * Ferme la fenêtre contenant cette vue.
	 * Appelle la méthode dispose() sur la fenêtre parente.
	 */
	public void fermerFenetre() {
		Window parentWindow = SwingUtilities.getWindowAncestor(this);
		if (parentWindow != null) {
			parentWindow.dispose();
		}
	}



	//---------------------------------
	// ACCESSEURS
	//---------------------------------
	/**
	 * Retourne le titre saisi dans le champ de texte.
	 * 
	 * @return Le titre du projet.
	 */
	public String getTitre() {
		return txtTitre.getText();
	}

	/**
	 * Retourne la description saisie dans la zone de texte.
	 * 
	 * @return La description du projet.
	 */
	public String getDescription() {
		return txtDescription.getText();
	}

	/**
	 * Retourne la date d'échéance saisie dans le champ de texte.
	 * 
	 * @return La date d'échéance du projet.
	 */
	public String getDateEcheance() {
		return txtDateEcheance.getText();
	}

	/**
	 * Retourne la zone de texte pour la description.
	 * 
	 * @return Le composant JTextArea pour la description.
	 */
	public JTextArea getTxtDescription() {
		return txtDescription;
	}

	/**
	 * Permet de définir une nouvelle zone de texte pour la description.
	 *
	 * @param txtDescription La nouvelle zone de texte pour la description.
	 */
	public void setTxtDescription(JTextArea txtDescription) {
		this.txtDescription = txtDescription;
	}

	/**
	 * Retourne le champ de texte pour la date d'échéance.
	 * 
	 * @return Le composant JTextField pour la date d'échéance.
	 */
	public JTextField getTxtDateEcheance() {
		return txtDateEcheance;
	}

	/**
	 * Permet de définir un nouveau champ de texte pour la date d'échéance.
	 *
	 * @param txtDateEcheance Le nouveau champ de texte pour la date d'échéance.
	 */
	public void setTxtDateEcheance(JTextField txtDateEcheance) {
		this.txtDateEcheance = txtDateEcheance;
	}

	/**
	 * Retourne le champ de texte pour le titre.
	 * 
	 * @return Le composant JTextField pour le titre.
	 */
	public JTextField getTxtTitre() {
		return txtTitre;
	}

	/**
	 * Permet de définir un nouveau champ de texte pour le titre.
	 *
	 * @param txtTitre Le nouveau champ de texte pour le titre.
	 */
	public void setTxtTitre(JTextField txtTitre) {
		this.txtTitre = txtTitre;
	}
}
