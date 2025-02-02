package Vues;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Modeles.*;

/**
 * La classe VueCreeListe représente une vue pour créer une nouvelle liste.
 * Elle affiche le champ de saisie pour le titre. Les utilisateurs peuvent 
 * remplir ce champ et créer une nouvelle liste en cliquant sur le bouton 
 * "Créer". Ils ont également la possibilité d'annuler la création en cliquant
 * sur le bouton "Annuler".
 * 
 * @author Cathy MARTIN
 * 
 * Après rendu universitaire : modifications apportées par @author Estelle BOISSERIE
 */
public class VueCreeListe extends JPanel {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private static final long serialVersionUID = 1L;

	private JTextField txtTitre;
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
	 * Constructeur de la classe VueCreeListe.
	 * Crée une vue pour pouvoir créer une liste.
	 */
	public VueCreeListe() {
		// Appliquer la mise en page de fond
		setLayout(new BorderLayout());
		setBackground(THEME);

		// Titre principal
		JLabel lblTitrePrincipal = new JLabel("Créer une liste");
		lblTitrePrincipal.setFont(POLICETITRE);
		lblTitrePrincipal.setForeground(Color.WHITE);
		lblTitrePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitrePrincipal, BorderLayout.NORTH);

		// Panneau de saisie pour le titre
		JPanel pnlModif = new JPanel(new GridBagLayout());
		pnlModif.setBorder(new EmptyBorder(20, 20, 20, 20));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0;

		// Titre de la vue
		JLabel lblTitreVue = new JLabel("Comment souhaitez-vous nommer votre nouvelle liste ?");
		lblTitreVue.setFont(POLICECORPS);
		gbc.gridwidth = 2;
		gbc.gridy = 0;
		pnlModif.add(lblTitreVue, gbc);

		// Label "Titre"
		JLabel lblTitre = new JLabel("Titre :");
		lblTitre.setFont(POLICECORPS);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		pnlModif.add(lblTitre, gbc);

		// Champ de saisie pour le titre
		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		txtTitre = new JTextField(20);
		txtTitre.setFont(POLICESAISIE);
		txtTitre.setPreferredSize(new Dimension(250, 30));
		pnlModif.add(txtTitre, gbc);

		// Bouton "Créer"
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		btnCree = new JButton("Créer");
		btnCree.setFont(POLICECORPS);
		btnCree.setBackground(new Color(64, 183, 105));
		btnCree.setForeground(Color.WHITE);
		btnCree.setFocusPainted(false);
		btnCree.setPreferredSize(new Dimension(100, 40));
		btnCree.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnlModif.add(btnCree, gbc);

		// Bouton "Annuler"
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(POLICECORPS);
		btnAnnuler.setBackground(new Color(198, 11, 70));
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setFocusPainted(false);
		btnAnnuler.setPreferredSize(new Dimension(100, 40));
		btnAnnuler.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		// Ajout du panneau de saisie et des boutons
		add(pnlModif, BorderLayout.CENTER);
		add(btnAnnuler, BorderLayout.SOUTH);
	}



	//---------------------------------
	// METHODES
	//---------------------------------
	/**
	 * Ajoute un écouteur pour l'action de cliquer sur le bouton "Annuler".
	 * 
	 * @param ecouteur l'écouteur à ajouter
	 */
	public void btnAnnulerClick(ActionListener ecouteur) {
		btnAnnuler.addActionListener(ecouteur);
	}

	/**
	 * Ajoute un écouteur pour l'action de cliquer sur le bouton "Créer".
	 * 
	 * @param ecouteur l'écouteur à ajouter
	 */
	public void btnCreeClick(ActionListener ecouteur) {
		btnCree.addActionListener(ecouteur);
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
	 * Récupère le titre saisi dans le champ de texte.
	 * 
	 * @return Le JTextField du titre de la liste.
	 */
	public JTextField getTxtTitre() {
		return txtTitre;
	}

	/**
	 * Récupère la liste créée avec l'information saisie dans le champ de texte.
	 * 
	 * @return La liste créée.
	 */
	public ModeleListe getListeCree() {
		String titre = getTxtTitre().getText();
		return new ModeleListe(titre);
	}
}