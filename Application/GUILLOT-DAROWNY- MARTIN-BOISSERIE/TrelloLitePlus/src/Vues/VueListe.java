package Vues;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import Modeles.*;

/**
 * La classe VueListe est une vue qui affiche les informations d'une liste.
 * Elle permet d'ajouter des écouteurs pour les actions de modification,
 * d'ajout de carte et de suppression de la liste.
 * 
 * Elle est utilisée pour afficher une liste dans le tableau.
 * 
 * @author Corentin DAROWNY
 * 
 * Après rendu universitaire : modifications apportées par @author Estelle BOISSERIE
 */
public class VueListe extends JPanel {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private static final long serialVersionUID = 1L;

	private ModeleListe liste;

	private JLabel lblNomListe;

	private JButton btnModifier;
	private JButton btnAjouterCarte;
	private JButton btnSupprimerListe;

	public JPanel pnlCartes;
	private JPanel pnlPanneau;

	private final static Font POLICETITRE = new Font("Segoe UI Black", Font.BOLD, 20);
	private final static Font POLICECORPS = new Font("Segoe UI", Font.PLAIN, 15		);

	private final static Color COULEURTHEME = new Color(99, 00, 60);



	//---------------------------------
	// CONSTRUCTEUR
	//---------------------------------
	/**
	 * Constructeur de la classe VueListe.
	 * Initialise l'affichage des informations d'une liste.
	 * 
	 * @param Liste la liste à afficher.
	 */
	public VueListe(ModeleListe Liste) {
		// Récupérer la liste
		this.liste = Liste;

		// Définition du layout principal
		setLayout(new BorderLayout());

		// Panneau principal avec un layout vertical
		pnlPanneau = new JPanel();
		pnlPanneau.setLayout(new BoxLayout(pnlPanneau, BoxLayout.Y_AXIS));
		pnlPanneau.setBackground(Color.WHITE);

		// Label du nom de la liste
		lblNomListe = new JLabel(liste.getNomListe().toUpperCase(), JLabel.CENTER);
		lblNomListe.setFont(POLICETITRE);
		pnlPanneau.add(lblNomListe);

		// Panneau des cartes (utilisation de GridLayout pour 2 cartes par ligne)
		pnlCartes = new JPanel();
		pnlCartes.setLayout(new GridLayout(0, 2, 10, 10));
		pnlCartes.setBackground(Color.WHITE);

		// Ajouter chaque carte à pnlCartes
		for (ModeleCarte carte : liste.getSesCartes()) {
			JButton btnCarte = new JButton(carte.getNomCarte());
			btnCarte.setFont(POLICECORPS);
			btnCarte.setFocusPainted(false);
			btnCarte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			pnlCartes.add(btnCarte);
		}

		// Si les cartes sont trop nombreuses, ajouter un défilement
		JScrollPane scrollPane = new JScrollPane(pnlCartes);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(500, 300));
		pnlPanneau.add(scrollPane);

		// Panneau des boutons
		JPanel pnlButtons = new JPanel();
		pnlButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		pnlButtons.setBackground(Color.WHITE);

		// Déclaration des boutons
		btnModifier = new JButton("Modifier");
		btnModifier.setFont(POLICECORPS);
		btnModifier.setBackground(COULEURTHEME);
		btnModifier.setForeground(Color.WHITE);
		btnModifier.setFocusPainted(false);
		btnModifier.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnlButtons.add(btnModifier);

		btnAjouterCarte = new JButton("Ajouter une carte");
		btnAjouterCarte.setFont(POLICECORPS);
		btnAjouterCarte.setBackground(new Color(40, 167, 69));
		btnAjouterCarte.setForeground(Color.WHITE);
		btnAjouterCarte.setFocusPainted(false);
		btnAjouterCarte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnlButtons.add(btnAjouterCarte);

		btnSupprimerListe = new JButton("Supprimer");
		btnSupprimerListe.setFont(POLICECORPS);
		btnSupprimerListe.setBackground(new Color(220, 53, 69));
		btnSupprimerListe.setForeground(Color.WHITE);
		btnSupprimerListe.setFocusPainted(false);
		btnSupprimerListe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnlButtons.add(btnSupprimerListe);

		pnlPanneau.add(pnlButtons);
		add(pnlPanneau, BorderLayout.CENTER);
	}

	//---------------------------------
	// METHODES
	//---------------------------------
	/**
	 * Ajoute un écouteur pour l'action de cliquer sur le bouton "Modifier".
	 * 
	 * @param ecouteur l'écouteur à ajouter.
	 */
	public void btnModifierClick(ActionListener ecouteur) {
		btnModifier.addActionListener(ecouteur);
	}

	/**
	 * Ajoute un écouteur pour l'action de cliquer sur le bouton "Ajouter une carte".
	 * 
	 * @param ecouteur l'écouteur à ajouter.
	 */
	public void btnAjouterCarteClick(ActionListener ecouteur) {
		btnAjouterCarte.addActionListener(ecouteur);
	}

	/**
	 * Ajoute un écouteur pour l'action de cliquer sur le bouton "Supprimer".
	 * 
	 * @param ecouteur l'écouteur à ajouter.
	 */
	public void btnSupprimerListeClick(ActionListener ecouteur) {
		btnSupprimerListe.addActionListener(ecouteur);
	}

	/**
	 * Met à jour l'affichage de la vue de la liste avec les informations actuelles.
	 */
	public void updateVueListe() {
		// Récupérer le nom de la liste
		lblNomListe.setText(liste.getNomListe().toUpperCase());

		// Vider le panel
		pnlCartes.removeAll();

		// Pour chaque carte de la liste
		for (ModeleCarte carte : liste.getSesCartes()) {
			// Créer un bouton de la carte
			JButton btnCarte = new JButton(carte.getNomCarte());
			btnCarte.setFont(POLICECORPS);
			btnCarte.setFocusPainted(false);
			btnCarte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			pnlCartes.add(btnCarte);
		}

		// Mise à jour de la vue
		revalidate();
		repaint();
	}
}