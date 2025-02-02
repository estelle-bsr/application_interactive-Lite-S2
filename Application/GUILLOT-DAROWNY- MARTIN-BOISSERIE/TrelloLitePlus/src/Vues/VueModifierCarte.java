package Vues;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Modeles.ModeleCarte;

/**
 * La classe VueModifierCarte permet de modifier les informations d'une carte,
 * notamment le titre, la description, la date limite et le statut.
 * L'utilisateur peut enregistrer les modifications ou supprimer la carte.
 *
 * @author Cathy MARTIN
 * 
 * Après rendu universitaire : modifications apportées par @author Estelle BOISSERIE
 */
public class VueModifierCarte extends JPanel {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private static final long serialVersionUID = 1L;

	private ModeleCarte carte;

	private JTextField txtTitre;
	private JTextField txtDateLimite;

	private JTextArea txtDescription;

	private JComboBox<String> cmbStatut;
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
	 * Constructeur de la classe VueModifierCarte.
	 * Crée une instance de VueModifierCarte pour modifier une carte.
	 * 
	 * @param carte La carte à modifier
	 **/
	public VueModifierCarte(ModeleCarte carte) {
		// Récupérer la carte
		this.carte = carte;

		// Mise en page arrière
		setLayout(new BorderLayout());

		// Titre principal
		JLabel lblTitrePrincipal = new JLabel("Modifier la carte", JLabel.CENTER);
		lblTitrePrincipal.setFont(POLICETITRE);
		lblTitrePrincipal.setOpaque(true);
		lblTitrePrincipal.setForeground(Color.WHITE);
		lblTitrePrincipal.setBackground(THEME);
		lblTitrePrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(lblTitrePrincipal, BorderLayout.NORTH);

		// Panneau de modification
		JPanel pnlModif = new JPanel(new GridBagLayout());
		pnlModif.setBackground(Color.WHITE);
		pnlModif.setBorder(new EmptyBorder(20, 20, 20, 20));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// Titre
		JLabel lblTitre = new JLabel("Titre :");
		lblTitre.setFont(POLICECORPS);
		gbc.gridx = 0;
		gbc.gridy = 0;
		pnlModif.add(lblTitre, gbc);

		txtTitre = new JTextField(carte.getNomCarte());
		txtTitre.setFont(POLICESAISIE);
		txtTitre.setPreferredSize(new Dimension(250, 30));
		txtTitre.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)));
		gbc.gridx = 1;
		pnlModif.add(txtTitre, gbc);

		// Description
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setFont(POLICECORPS);
		gbc.gridx = 0;
		gbc.gridy = 1;
		pnlModif.add(lblDescription, gbc);

		txtDescription = new JTextArea(carte.getDescriptionCarte(), 5, 20);
		txtDescription.setFont(POLICESAISIE);
		txtDescription.setLineWrap(true);
		txtDescription.setWrapStyleWord(true);
		txtDescription.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)));
		gbc.gridx = 1;
		pnlModif.add(new JScrollPane(txtDescription), gbc);

		// Date limite
		JLabel lblDateLimite = new JLabel("Date limite :");
		lblDateLimite.setFont(POLICECORPS);
		gbc.gridx = 0;
		gbc.gridy = 2;
		pnlModif.add(lblDateLimite, gbc);

		txtDateLimite = new JTextField(carte.getDateEcheanceCarte());
		txtDateLimite.setFont(POLICESAISIE);
		txtDateLimite.setPreferredSize(new Dimension(250, 30));
		txtDateLimite.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		gbc.gridx = 1;
		pnlModif.add(txtDateLimite, gbc);

		// Statut
		JLabel lblStatut = new JLabel("Statut :");
		lblStatut.setFont(POLICECORPS);
		gbc.gridx = 0;
		gbc.gridy = 3;
		pnlModif.add(lblStatut, gbc);

		String[] statuts = {"Pas commencé", "En cours", "Fini"};
		cmbStatut = new JComboBox<>(statuts);
		cmbStatut.setSelectedItem(carte.getStatutCarte());
		cmbStatut.setFont(POLICESAISIE);
		gbc.gridx = 1;
		pnlModif.add(cmbStatut, gbc);

		// Panneau des boutons
		JPanel pnlBoutons = new JPanel();

		btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setFont(POLICECORPS);
		btnEnregistrer.setBackground(COULEURBOUTONVERT);
		btnEnregistrer.setForeground(Color.WHITE);
		btnEnregistrer.setFocusPainted(false);
		btnEnregistrer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(POLICECORPS);
		btnAnnuler.setBackground(COULEURBOUTONROUGE);
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setFocusPainted(false);
		btnAnnuler.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		pnlBoutons.add(btnEnregistrer);
		pnlBoutons.add(btnAnnuler);

		pnlBoutons.setBackground(Color.WHITE);

		// Ajout des composants
		add(pnlModif, BorderLayout.CENTER);
		add(pnlBoutons, BorderLayout.SOUTH);
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
	 * Ajoute un écouteur pour le bouton "Supprimer".
	 *
	 * @param ecouteur L'écouteur à ajouter.
	 */
	public void btnAnnulerClick(ActionListener ecouteur) {
		btnAnnuler.addActionListener(ecouteur);
	}


	
	//---------------------------------
	// ACCESSEURS
	//---------------------------------
	/**
	 * Récupérer la carte.
	 * @return La carte.
	 **/
	public ModeleCarte getCarte() {
		return carte;
	}

	/**
	 * Récupérer le titre.
	 * @return le titre de la carte.
	 **/
	public String getTitre() {
		return txtTitre.getText();
	}

	/**
	 * Récupérer la description de la carte.
	 * @return la description.
	 **/
	public String getDescription() {
		return txtDescription.getText();
	}

	/**
	 * Récupérer la date limite de la carte.
	 * @return la date limite.
	 */
	public String getDateLimite() {
		return txtDateLimite.getText();
	}

	/**
	 * Récupérer le status de la carte.
	 * @return le status.
	 */
	public String getStatut() {
		return (String) cmbStatut.getSelectedItem();
	}
}