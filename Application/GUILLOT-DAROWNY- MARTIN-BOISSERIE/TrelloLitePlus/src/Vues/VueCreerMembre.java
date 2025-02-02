package Vues;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Cette classe représente la vue graphique pour la création d'un compte.
 * Elle est affichée lorsqu'un membre souhaite créer un compte lors du lancement de l'application.
 * 
 * @author Estelle BOISSERIE
 **/
public class VueCreerMembre extends JPanel {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private static final long serialVersionUID = 1L;
	
	private JLabel lblTitre = new JLabel("Créer votre compte"							);
	private JLabel lblNom = new JLabel("Nom :"											);
	private JLabel lblPrenom = new JLabel("Prénom :"									);
	private JLabel lblMail = new JLabel("Adresse mail :"								);
	private JLabel lblMotdepasse = new JLabel("Votre mot de passe :"					);
	private JLabel lblMotdepasseConfirme = new JLabel("Confirmez votre mot de passe :"	);

	private JTextField txtNom = new JTextField(20	);
	private JTextField txtPrenom = new JTextField(20);
	private JTextField txtMail = new JTextField(20	);

	private JPasswordField txtMotdepasse = new JPasswordField(20		);
	private JPasswordField txtMotdepasseConfirme = new JPasswordField(20);

	private JButton btnCreer = new JButton("Créer"	);
	private JButton btnRetour = new JButton("Retour");

	private JPanel pnlFormulaire = new JPanel(	);
	private JPanel pnlBoutons = new JPanel(		);

	private final static Font POLICETITRE = new Font("Segoe UI Black", Font.BOLD, 40);
	private final static Font POLICECORPS = new Font("Segoe UI", Font.PLAIN, 20		);

	private final static Color COULEURBOUTON = new Color(99, 0, 60);



	//---------------------------------
	// CONSTRUCTEUR
	//---------------------------------
	public VueCreerMembre() {
		// Configuration globale
		setLayout(new BorderLayout());
		setBackground(COULEURBOUTON);

		// Configuration du titre
		lblTitre.setFont(POLICETITRE);
		lblTitre.setForeground(Color.WHITE);
		lblTitre.setHorizontalAlignment(SwingConstants.CENTER);

		// Configuration des labels
		lblNom.setFont(POLICECORPS);
		lblPrenom.setFont(POLICECORPS);
		lblMail.setFont(POLICECORPS);
		lblMotdepasse.setFont(POLICECORPS);
		lblMotdepasseConfirme.setFont(POLICECORPS);

		// Configuration des champs de saisie
		txtNom.setFont(POLICECORPS);
		txtPrenom.setFont(POLICECORPS);
		txtMail.setFont(POLICECORPS);
		txtNom.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		txtPrenom.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		txtMail.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		txtMotdepasse.setFont(POLICECORPS);
		txtMotdepasse.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		txtMotdepasseConfirme.setFont(POLICECORPS);
		txtMotdepasseConfirme.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		// Configuration des boutons
		btnCreer.setBackground(COULEURBOUTON);
		btnCreer.setForeground(Color.WHITE);
		btnCreer.setFont(POLICECORPS);
		btnCreer.setFocusPainted(false);
		btnCreer.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		btnCreer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnRetour.setBackground(new Color(49, 62, 72));
		btnRetour.setForeground(Color.WHITE);
		btnRetour.setFont(POLICECORPS);
		btnRetour.setFocusPainted(false);
		btnRetour.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		btnRetour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		// Construction des panels
		pnlFormulaire.setLayout(new GridBagLayout());
		pnlFormulaire.setBackground(Color.WHITE);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// Ajout des composants au formulaire
		gbc.gridy = 0; gbc.gridx = 0; gbc.weightx = 0.3; pnlFormulaire.add(lblNom, gbc);
		gbc.gridx = 1; gbc.weightx = 0.7; pnlFormulaire.add(txtNom, gbc);

		gbc.gridy = 1; gbc.gridx = 0; gbc.weightx = 0.3; pnlFormulaire.add(lblPrenom, gbc);
		gbc.gridx = 1; gbc.weightx = 0.7; pnlFormulaire.add(txtPrenom, gbc);

		gbc.gridy = 2; gbc.gridx = 0; gbc.weightx = 0.3; pnlFormulaire.add(lblMail, gbc);
		gbc.gridx = 1; gbc.weightx = 0.7; pnlFormulaire.add(txtMail, gbc);

		gbc.gridy = 3; gbc.gridx = 0; gbc.weightx = 0.3; pnlFormulaire.add(lblMotdepasse, gbc);
		gbc.gridx = 1; gbc.weightx = 0.7; pnlFormulaire.add(txtMotdepasse, gbc);

		gbc.gridy = 4; gbc.gridx = 0; gbc.weightx = 0.3; pnlFormulaire.add(lblMotdepasseConfirme, gbc);
		gbc.gridx = 1; gbc.weightx = 0.7; pnlFormulaire.add(txtMotdepasseConfirme, gbc);

		pnlBoutons.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		pnlBoutons.setBackground(Color.WHITE);
		pnlBoutons.add(btnRetour);
		pnlBoutons.add(btnCreer);

		// Ajouter les éléments au panneau principal
		add(lblTitre, BorderLayout.NORTH);
		add(pnlFormulaire, BorderLayout.CENTER);
		add(pnlBoutons, BorderLayout.SOUTH);
	}



	//---------------------------------
	// MÉTHODES
	//---------------------------------
	/**
	 * Ajouter un écouteur au bouton "Créer".
	 * @param ecouteur L'écouteur.
	 **/
	public void btnCreerClick(ActionListener ecouteur) {
		btnCreer.addActionListener(ecouteur);
	}

	/**
	 * Ajouter un écouteur au bouton "Retour".
	 * @param ecouteur L'écouteur.
	 **/
	public void btnRetourClick(ActionListener ecouteur) {
		btnRetour.addActionListener(ecouteur);
	}

	/**
	 * Fermer la fenêtre.
	 **/
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
	 * Avoir le nom saisit par l'utilisateur.
	 * @return le nom.
	 **/
	public String getNom() {
		return txtNom.getText();
	}

	/**
	 * Avoir le prenom saisit par l'utilisateur.
	 * @return le prenom.
	 **/
	public String getPrenom() {
		return txtPrenom.getText();
	}

	/**
	 * Avoir l'adresse mail saisit par l'utilisateur.
	 * @return l'adresse mail.
	 **/
	public String getMail() {
		return txtMail.getText();
	}

	/**
	 * Avoir le mot de passe saisit par l'utilisateur.
	 * @return le mot de passe.
	 **/
	public String getMotdepasse() {
		return new String(txtMotdepasse.getPassword());
	}

	/**
	 * Avoir le mot de passe de confirmation saisit par l'utilisateur.
	 * @return le mot de passe de confirmation.
	 **/
	public String getTxtMotdepasseConfirme() {
		return new String(txtMotdepasseConfirme.getPassword());
	}
}
