package Vues;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Cette classe est la vue de modification d'un projet.
 * Elle permet de modifier le titre, la description et la date d'échéance d'un projet existant.
 * Elle contient des boutons pour enregistrer les modifications ou annuler l'opération.
 * 
 * @author Antonin GUILLOT
 * 
 * Après rendu universitaire : modifications apportées par @author Estelle BOISSERIE
 */
public class VueModifierProjet extends JPanel {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private static final long serialVersionUID = 1L;

	private JTextField txtTitre;
	private JTextField txtDateEcheance;

	private JTextArea txtDescription;

	private JButton btnEnregistrer;
	private JButton btnAnnuler;

	private final static Font POLICETITRE = new Font("Segoe UI Black", Font.BOLD, 40);
	private final static Font POLICECORPS = new Font("Segoe UI", Font.PLAIN, 20		);
	private final static Font POLICESAISIE = new Font("Segoe UI", Font.ITALIC, 15   );

	private final static Color THEME = new Color(99, 0, 60					);
	private final static Color COULEURBOUTONVERT = new Color(64, 183, 105	);
	private final static Color COULEURBOUTONROUGE = new Color(198, 11, 70	);



	//---------------------------------
	// CONSTRUCTEUR
	//---------------------------------
	/**
	 * Constructeur de la classe VueModifierProjet.
	 * Initialise l'interface de modification d'un projet avec des champs de texte
	 * pour le titre, la description, la date d'échéance, et des boutons pour interagir.
	 */
	public VueModifierProjet() {
		// Mise en page arrière
		setLayout(new BorderLayout());
		setBackground(THEME);

		// Titre principal
		JLabel lblTitrePrincipal = new JLabel("Modifier votre projet");
		lblTitrePrincipal.setFont(POLICETITRE);
		lblTitrePrincipal.setForeground(Color.WHITE);
		lblTitrePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitrePrincipal, BorderLayout.NORTH);

		// Panneau principal pour les modifications
		JPanel pnlModification = new JPanel(new GridBagLayout());
		pnlModification.setBackground(Color.WHITE);
		pnlModification.setBorder(new EmptyBorder(20, 20, 20, 20));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0;

		// Label et champ titre
		JLabel lblTitre = new JLabel("Titre :");
		lblTitre.setFont(POLICECORPS);
		pnlModification.add(lblTitre, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		txtTitre = new JTextField();
		txtTitre.setFont(POLICESAISIE);
		txtTitre.setPreferredSize(new Dimension(250, 30));
		pnlModification.add(txtTitre, gbc);

		// Label et champ description
		gbc.gridx = 0;
		gbc.gridy = 1;
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setFont(POLICECORPS);
		pnlModification.add(lblDescription, gbc);

		gbc.gridx = 1;
		txtDescription = new JTextArea(5, 20);
		txtDescription.setFont(POLICESAISIE);
		txtDescription.setLineWrap(true);
		txtDescription.setWrapStyleWord(true);
		txtDescription.setBorder(new LineBorder(Color.BLACK, 1));
		JScrollPane scrollPane = new JScrollPane(txtDescription);
		pnlModification.add(scrollPane, gbc);

		// Label et champ date échéance
		gbc.gridx = 0;
		gbc.gridy = 2;
		JLabel lblDateEcheance = new JLabel("Date échéance :");
		lblDateEcheance.setFont(POLICECORPS);
		pnlModification.add(lblDateEcheance, gbc);

		gbc.gridx = 1;
		txtDateEcheance = new JTextField();
		txtDateEcheance.setFont(POLICESAISIE);
		txtDateEcheance.setPreferredSize(new Dimension(250, 30));
		pnlModification.add(txtDateEcheance, gbc);

		// Bouton Enregistrer
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setFont(POLICECORPS);
		btnEnregistrer.setBackground(COULEURBOUTONVERT);
		btnEnregistrer.setForeground(Color.WHITE);
		btnEnregistrer.setFocusPainted(false);
		btnEnregistrer.setPreferredSize(new Dimension(100, 40));
		btnEnregistrer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnlModification.add(btnEnregistrer, gbc);

		// Bouton Annuler
		gbc.gridy = 4;
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(POLICECORPS);
		btnAnnuler.setBackground(COULEURBOUTONROUGE);
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setFocusPainted(false);
		btnAnnuler.setPreferredSize(new Dimension(100, 40));
		btnAnnuler.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnlModification.add(btnAnnuler, gbc);

		// Ajout des modification au panel
		add(pnlModification, BorderLayout.CENTER);
	}



	//---------------------------------
	// METHODES
	//---------------------------------
	/**
	 * Ajoute un écouteur pour le bouton "Enregistrer".
	 *
	 * @param ecouteur L'écouteur à ajouter.
	 */
	public void btnEnregistrerClick(ActionListener ecouteur) {
		btnEnregistrer.addActionListener(ecouteur);
	}

	/**
	 * Ajoute un écouteur pour le bouton "Annuler".
	 *
	 * @param ecouteur L'écouteur à ajouter.
	 */
	public void btnAnnulerClick(ActionListener ecouteur) {
		btnAnnuler.addActionListener(ecouteur);
	}

	/**
	 * Fermer la fenêtre.
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
	 * Récupérer le titre du projet.
	 * @return le titre.
	 **/
	public String getTitre() {
		return txtTitre.getText();
	}

	/**
	 * Récupérer la description du projet.
	 * @return la description.
	 **/
	public String getDescription() {
		return txtDescription.getText();
	}

	/**
	 * Récupérer la date d'échéance du projet.
	 * @return la date d'échéance.
	 **/
	public String getDateEcheance() {
		return txtDateEcheance.getText();
	}

	/**
	 * Modifier le titre du projet.
	 * @param titre Le nouveau titre.
	 **/
	public void setTitre(String Titre) {
		txtTitre.setText(Titre);
	}

	/**
	 * Modifier la description du projet.
	 * @param description La nouvelle description.
	 **/
	public void setDescription(String description) {
		txtDescription.setText(description);
	}

	/**
	 * Modifier la date d'échéance du projet.
	 * @param date La nouvelle date d'échéance.
	 **/
	public void setDateEcheance(String date) {
		txtDateEcheance.setText(date);
	}
}