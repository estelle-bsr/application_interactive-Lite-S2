package Vues;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import Modeles.*;

/**
 * @author Cathy MARTIN
 * 
 * La classe VueCreeCarte représente une interface graphique pour la création d'une carte.
 * Elle contient des champs pour saisir le titre, la description et la date limite d'une carte.
 * L'utilisateur peut valider la création ou annuler l'opération via les boutons correspondants.
 * 
 * Après rendu universitaire : modifications apportées par @author Estelle BOISSERIE
 */
public class VueCreeCarte extends JPanel {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private static final long serialVersionUID = 1L;

	private JTextField txtTitre;
	private JTextArea txtDescription;
	private JTextField txtDateLimite;
	private JButton btnCree;
	private JButton btnAnnuler;

	private final static Font POLICETITRE = new Font("Segoe UI Black", Font.BOLD, 40);
	private final static Font POLICECORPS = new Font("Segoe UI", Font.PLAIN, 20		);
	private final static Font POLICESAISIE = new Font("Segoe UI", Font.ITALIC, 15   );

	private final static Color THEME = new Color(99, 00, 60);



	//---------------------------------
	// CONSTRUCTEUR
	//---------------------------------
	/**
	 * Constructeur de la classe VueCreeCarte.
	 * Initialise l'interface utilisateur pour la création d'une carte.
	 */
	public VueCreeCarte() {
		// Définition du layout et couleur de fond
		setLayout(new BorderLayout());
		setBackground(THEME);

		// Titre principal
		JLabel lblTitrePrincipal = new JLabel("Créer une carte");
		lblTitrePrincipal.setFont(POLICETITRE);
		lblTitrePrincipal.setForeground(Color.WHITE);
		lblTitrePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitrePrincipal, BorderLayout.NORTH);

		// Création du panneau principal
		JPanel pnlModif = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(10, 10, 10, 10);

		// Ajout du champ Titre
		JLabel lblTitre = new JLabel("Titre:");
		lblTitre.setFont(POLICECORPS);
		lblTitre.setForeground(Color.decode("#333333"));
		pnlModif.add(lblTitre, gbc);

		gbc.gridx = 1;
		txtTitre = new JTextField(20);
		txtTitre.setFont(POLICESAISIE);
		txtTitre.setBorder(BorderFactory.createLineBorder(Color.BLACK));  
		pnlModif.add(txtTitre, gbc);

		// Ajout du champ Description
		gbc.gridx = 0;
		gbc.gridy = 1;
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(POLICECORPS);
		pnlModif.add(lblDescription, gbc);

		gbc.gridx = 1;
		txtDescription = new JTextArea(5, 20);
		txtDescription.setFont(POLICESAISIE);
		txtDescription.setBorder(BorderFactory.createLineBorder(Color.black));
		JScrollPane scrollPane = new JScrollPane(txtDescription);
		pnlModif.add(scrollPane, gbc);

		// Ajout du champ Date limite
		gbc.gridx = 0;
		gbc.gridy = 2;
		JLabel lblDateLimite = new JLabel("Date limite:");
		lblDateLimite.setFont(POLICECORPS);
		pnlModif.add(lblDateLimite, gbc);

		gbc.gridx = 1;
		txtDateLimite = new JTextField(20);
		txtDateLimite.setFont(POLICESAISIE);
		txtDateLimite.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pnlModif.add(txtDateLimite, gbc);

		// Bouton "Créer"
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		btnCree = new JButton("Créer");
		btnCree.setFont(POLICECORPS);
		btnCree.setBackground(new Color(64, 183, 105));
		btnCree.setForeground(Color.WHITE);
		btnCree.setFocusPainted(false);
		btnCree.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		btnCree.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnlModif.add(btnCree, gbc);

		// Bouton "Annuler"
		gbc.gridy = 4;
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Arial", Font.BOLD, 16));
		btnAnnuler.setBackground(new Color(198, 11, 70)); 
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setFocusPainted(false);
		btnAnnuler.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		btnAnnuler.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnlModif.add(btnAnnuler, gbc);

		// Ajout du panneau principal à la vue
		add(pnlModif, BorderLayout.CENTER);
	}



	//---------------------------------
	// METHODES
	//---------------------------------
	/**
	 * Ajoute un écouteur pour l'action de cliquer sur le bouton "Annuler".
	 * @param ecouteur l'écouteur à ajouter
	 */
	public void btnAnnulerClick(ActionListener ecouteur) {
		btnAnnuler.addActionListener(ecouteur);
	}

	/**
	 * Ajoute un écouteur pour l'action de cliquer sur le bouton "Créer".
	 * @param ecouteur l'écouteur à ajouter
	 */
	public void btnCreeClick(ActionListener ecouteur) {
		btnCree.addActionListener(ecouteur);
	}



	//---------------------------------
	// ACCESSEURS
	//---------------------------------
	/**
	 * Récupère les informations saisies pour créer une nouvelle carte.
	 * @return Une instance de ModeleCarte contenant les données saisies.
	 */
	public ModeleCarte getCarteCree() {
		String titre = getTitre().getText().trim();
		String description = getDescription().getText().trim();
		String dateLimite = getDateLimite().getText().trim();
		return new ModeleCarte(titre, description, dateLimite);
	}

	/**
	 * Récupère le champ de saisie du titre.
	 * @return Le JTextField du titre de la carte.
	 */
	public JTextField getTitre() {
		return txtTitre;
	}

	/**
	 * Récupère le champ de saisie de la description.
	 * @return Le JTextArea de la description de la carte.
	 */
	public JTextArea getDescription() {
		return txtDescription;
	}

	/**
	 * Récupère le champ de saisie de la date limite.
	 * @return Le JTextField de la date limite de la carte.
	 */
	public JTextField getDateLimite() {
		return txtDateLimite;
	}
}