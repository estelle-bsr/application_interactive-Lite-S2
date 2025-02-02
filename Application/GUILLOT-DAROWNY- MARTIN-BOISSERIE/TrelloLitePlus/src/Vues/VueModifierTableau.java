package Vues;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Modeles.*;

/**
 * La classe VueModifierTableau représente une vue pour modifier un tableau.
 * Elle affiche le champ de modification pour le titre. Les utilisateurs
 * peuvent saisir la nouvelle valeur pour ce champ et enregistrer la
 * modification. Ils ont également la possibilité de supprimer le tableau.
 * 
 * @author Cathy MARTIN
 * 
 * Après rendu universitaire : modifications apportées par @author Estelle BOISSERIE
 */
public class VueModifierTableau extends JPanel {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private static final long serialVersionUID = 1L;

	private ModeleTableau tableau;

	private JTextField txtTitreTableau;

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
	 * Constructeur de la classe VueModifierTableau.
	 * Crée une vue pour pouvoir modifier un tableau.
	 * 
	 * @param tableau Le tableau à modifier.
	 */
	public VueModifierTableau(ModeleTableau tableau) {
		// Récupérer le tableau
		this.tableau = tableau;

		// Utilisation du BorderLayout pour organiser les composants
		setLayout(new BorderLayout());
		setBackground(THEME);

		// Panneau principal pour les modifications
		JPanel pnlModif = new JPanel(new GridBagLayout());
		pnlModif.setBorder(new EmptyBorder(20, 20, 20, 20));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0;

		// Titre principal centré en haut
		JLabel lblTitrePrincipal = new JLabel("Modifier votre tableau");
		lblTitrePrincipal.setFont(POLICETITRE);
		lblTitrePrincipal.setForeground(Color.WHITE);
		lblTitrePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitrePrincipal, BorderLayout.NORTH);

		// Titre de modification
		JLabel lblTitre = new JLabel("Titre :");
		lblTitre.setFont(POLICECORPS);
		pnlModif.add(lblTitre, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		txtTitreTableau = new JTextField(tableau.getNomTableau());
		txtTitreTableau.setFont(POLICESAISIE);
		txtTitreTableau.setPreferredSize(new Dimension(250, 30));
		pnlModif.add(txtTitreTableau, gbc);

		// Bouton Enregistrer
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setFont(POLICECORPS);
		btnEnregistrer.setBackground(new Color(64, 183, 105));
		btnEnregistrer.setForeground(Color.WHITE);
		btnEnregistrer.setFocusPainted(false);
		btnEnregistrer.setPreferredSize(new Dimension(100, 40));
		btnEnregistrer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnlModif.add(btnEnregistrer, gbc);

		// Bouton Supprimer
		gbc.gridy = 2;
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(POLICECORPS);
		btnAnnuler.setBackground(new Color(198, 11, 70));
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setFocusPainted(false);
		btnAnnuler.setPreferredSize(new Dimension(100, 40));
		btnAnnuler.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnlModif.add(btnAnnuler, gbc);

		// Ajout du panneau de modification au panneau principal
		add(pnlModif, BorderLayout.CENTER);
	}



	//---------------------------------
	// METHODES
	//---------------------------------
	/**
	 * Ajoute un écouteur pour l'action de cliquer sur le bouton "Enregistrer".
	 * 
	 * @param ecouteur l'écouteur à ajouter
	 */
	public void btnEnregistrerClick(ActionListener ecouteur) {
		btnEnregistrer.addActionListener(ecouteur);
	}

	/**
	 * Ajoute un écouteur pour l'action de cliquer sur le bouton "Supprimer".
	 * 
	 * @param ecouteur l'écouteur à ajouter pour l'action de suppression
	 */
	public void btnAnnulerClick(ActionListener ecouteur) {
		btnAnnuler.addActionListener(ecouteur);
	}



	//---------------------------------
	// ACCESSEURS
	//---------------------------------
	/**
	 * Récupère le tableau.
	 * 
	 * @return Le tableau.
	 */
	public ModeleTableau getTableau() {
		return this.tableau;
	}

	/**
	 * Récupère le titre saisi dans le champ de texte.
	 * 
	 * @return Le titre du tableau.
	 */
	public String getTitre() {
		return txtTitreTableau.getText();
	}
}