package Vues;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Modeles.*;

/**
 * La classe VueTableau est une vue qui affiche les informations d'un tableau.
 * Elle permet également d'ajouter des écouteurs pour les actions de modification du tableau et d'ajout de liste.
 * 
 * @author Cathy
 * 
 * Après rendu universitaire : modifications apportées par @author Estelle BOISSERIE
 */
public class VueTableau extends JPanel {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private static final long serialVersionUID = 1L;

	private ModeleTableau tableau;

	private JLabel lblNomTableau;

	private JButton btnModifierTableau;
	private JButton btnAjouterListe;
	private JButton btnSupprimerTableau;

	public JPanel pnlPanneauTableau;
	public JPanel pnlListes = new JPanel();

	private final static Font POLICETITRE = new Font("Segoe UI Black", Font.BOLD, 20);
	private final static Font POLICECORPS = new Font("Segoe UI", Font.PLAIN, 15		);



	//---------------------------------
	// CONSTRUCTEUR
	//---------------------------------
	/**
	 * Constructeur de la classe VueTableau.
	 * Crée une vue pour afficher les informations d'un tableau.
	 * 
	 * @param Tableau le tableau à afficher
	 */
	VueTableau(ModeleTableau Tableau) {
		// Récupérer le tableau
		this.tableau = Tableau;

		setLayout(new BorderLayout());
		setBackground(new Color(149, 139, 195));

		// Panneau pour le titre
		JPanel pnlTitre = new JPanel(new GridBagLayout());
		pnlTitre.setBackground(new Color(149, 139, 195));  
		lblNomTableau = new JLabel(tableau.getNomTableau().toUpperCase());
		lblNomTableau.setFont(POLICETITRE); 
		lblNomTableau.setForeground(Color.WHITE);
		GridBagConstraints gbcTitre = new GridBagConstraints();
		gbcTitre.gridx = 0;
		gbcTitre.gridy = 0;
		gbcTitre.insets = new Insets(10, 10, 10, 10);
		pnlTitre.add(lblNomTableau, gbcTitre);

		// Panneau pour les listes 
		pnlListes.setLayout(new BoxLayout(pnlListes, BoxLayout.X_AXIS));
		pnlListes.setBackground(new Color(149, 139, 195));

		// Ajouter un JScrollPane avec défilement horizontal
		JScrollPane scrollPane = new JScrollPane(pnlListes);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(800, 300));

		// En cas d'espace insuffisant, ajustez l'auto-scroll pour la largeur
		scrollPane.setAutoscrolls(true);
		scrollPane.setBackground(new Color(149, 139, 195));
		scrollPane.setMinimumSize(new Dimension(600, 300));

		// Panneau pour les boutons
		JPanel pnlBoutons = new JPanel();
		pnlBoutons.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		pnlBoutons.setBackground(new Color(149, 139, 195));
		pnlBoutons.setBorder(new EmptyBorder(10, 10, 10, 10));

		// Bouton Modifier
		btnModifierTableau = new JButton("Modifier");
		btnModifierTableau.setFont(POLICECORPS);
		btnModifierTableau.setBackground(new Color(0, 123, 255));
		btnModifierTableau.setForeground(Color.WHITE);
		btnModifierTableau.setFocusPainted(false);
		btnModifierTableau.setPreferredSize(new Dimension(200, 40));

		// Bouton Ajouter une Liste
		btnAjouterListe = new JButton("Ajouter une liste");
		btnAjouterListe.setFont(POLICECORPS);
		btnAjouterListe.setBackground(new Color(40, 167, 69));
		btnAjouterListe.setForeground(Color.WHITE);
		btnAjouterListe.setFocusPainted(false);
		btnAjouterListe.setPreferredSize(new Dimension(200, 40));

		// Bouton Supprimer
		btnSupprimerTableau = new JButton("Supprimer");
		btnSupprimerTableau.setFont(POLICECORPS);
		btnSupprimerTableau.setBackground(new Color(220, 53, 69));
		btnSupprimerTableau.setForeground(Color.WHITE);
		btnSupprimerTableau.setFocusPainted(false);
		btnSupprimerTableau.setPreferredSize(new Dimension(200, 40));

		// Ajout des boutons dans le panneau des boutons
		pnlBoutons.add(btnModifierTableau);
		pnlBoutons.add(btnSupprimerTableau);
		pnlBoutons.add(btnAjouterListe);

		// Ajout des sous-panneaux au panneau principal
		add(scrollPane, BorderLayout.CENTER);
		add(pnlTitre, BorderLayout.NORTH);
		add(pnlBoutons, BorderLayout.SOUTH);
	}

	//---------------------------------
	// METHODES
	//---------------------------------
	/**
	 * Ajoute un écouteur pour l'action de cliquer sur le bouton "Modifier".
	 * 
	 * @param ecouteur l'écouteur à ajouter
	 */
	public void btnModifierTableauClick(ActionListener ecouteur) {
		btnModifierTableau.addActionListener(ecouteur);
	}

	/**
	 * Ajoute un écouteur pour l'action de cliquer sur le bouton "Ajouter une liste".
	 * 
	 * @param ecouteur l'écouteur à ajouter
	 */
	public void btnAjouterListeClick(ActionListener ecouteur) {
		btnAjouterListe.addActionListener(ecouteur);
	}

	/**
	 * Ajoute un écouteur pour l'action de cliquer sur le bouton "Supprimer".
	 *
	 * @param ecouteur l'écouteur à ajouter pour l'action de suppression
	 */
	public void btnSupprimerClick(ActionListener ecouteur) {
		btnSupprimerTableau.addActionListener(ecouteur);
	}

	/**
	 * Met à jour l'affichage de la vue du tableau avec les informations du tableau actuel.
	 */
	public void updateVueTableau() {
		lblNomTableau.setText(tableau.getNomTableau().toUpperCase());
	}
}