package Vues;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;
import Modeles.*;
/**
 * La classe VueModifierListe représente une vue permettant de modifier une
 * liste.
 * Elle affiche un champ de modification pour le titre et des boutons pour
 * enregistrer ou supprimer la liste.
 * 
 * @author Darowny Corentin et Martin Cathy
 * 
 * Après rendu universitaire : modifications apportées par @author Estelle BOISSERIE
 */
public class VueModifierListe extends JPanel {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private static final long serialVersionUID = 1L;

	private ModeleListe liste;

	private JTextField txtTitreListe;

	private JButton btnEnregistrer;
	private JButton btnAnuler;

	private final static Font POLICETITRE = new Font("Segoe UI Black", Font.BOLD, 40);
	private final static Font POLICECORPS = new Font("Segoe UI", Font.PLAIN, 20		);
	private final static Font POLICESAISIE = new Font("Segoe UI", Font.ITALIC, 15   );

	private final static Color THEME = new Color(99, 0, 60				);
	private final static Color COULEURBOUTONVERT = new Color(64, 183, 105);
	private final static Color COULEURBOUTONROUGE = new Color(198, 11, 70);



	//---------------------------------
	// CONSTRUCTEUR
	//---------------------------------
	/**
	 * Constructeur de la classe VueModifierListe.
	 * Crée une instance de VueModifierListe pour modifier une liste.
	 * 
	 * @param liste La liste à modifier
	 **/
	public VueModifierListe(ModeleListe liste) {
		// Récupérer la liste
		this.liste = liste;

		// Mise en page arrière
		setLayout(new BorderLayout());
		setBackground(THEME);

		// Titre principal
		JLabel lblTitrePrincipal = new JLabel("Modifier votre liste");
		lblTitrePrincipal.setFont(POLICETITRE);
		lblTitrePrincipal.setForeground(Color.WHITE);
		lblTitrePrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitrePrincipal, BorderLayout.NORTH);

		// Panneau principal pour les modifications
		JPanel pnlModif = new JPanel(new GridBagLayout());
		pnlModif.setBorder(new EmptyBorder(20, 20, 20, 20));

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridx = 0;
		gbc.gridy = 0;

		// Titre de modification
		JLabel lblTitre = new JLabel("Titre :");
		lblTitre.setFont(POLICECORPS);
		pnlModif.add(lblTitre, gbc);

		gbc.gridx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		txtTitreListe = new JTextField(liste.getNomListe());
		txtTitreListe.setFont(POLICESAISIE);
		txtTitreListe.setPreferredSize(new Dimension(250, 30));
		pnlModif.add(txtTitreListe, gbc);

		// Bouton Enregistrer
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setFont(POLICECORPS);
		btnEnregistrer.setBackground(COULEURBOUTONVERT);
		btnEnregistrer.setForeground(Color.WHITE);
		btnEnregistrer.setFocusPainted(false);
		btnEnregistrer.setPreferredSize(new Dimension(100, 40));
		btnEnregistrer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnlModif.add(btnEnregistrer, gbc);

		// Bouton Supprimer
		gbc.gridy = 2;
		btnAnuler = new JButton("Annuler");
		btnAnuler.setFont(POLICECORPS);
		btnAnuler.setBackground(COULEURBOUTONROUGE);
		btnAnuler.setForeground(Color.WHITE);
		btnAnuler.setFocusPainted(false);
		btnAnuler.setPreferredSize(new Dimension(100, 40));
		btnAnuler.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnlModif.add(btnAnuler, gbc);

		// Ajout du panneau de modification au panneau principal
		add(pnlModif, BorderLayout.CENTER);
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
		btnAnuler.addActionListener(ecouteur);
	}



	//---------------------------------
	// ACCESSEURS
	//---------------------------------
	/**
	 * Récupérer la liste.
	 * @return la liste
	 **/
	public ModeleListe getListe() {
		return this.liste;
	}

	/**
	 * Récupérer le titre de la liste.
	 * @return le titre.
	 */
	public String getTitre() {
		return txtTitreListe.getText();
	}
}