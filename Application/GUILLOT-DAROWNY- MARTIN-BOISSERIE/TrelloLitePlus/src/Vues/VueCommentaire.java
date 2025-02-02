package Vues;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Modeles.*;

/**
 * La classe VueCommentaire est la vue graphique des commentaires.
 * Elle permet à l'utilisateur de visualiser les fonctionnalités des commentaires.
 * 
 * @author Estelle BOISSERIE
 **/
public class VueCommentaire extends JPanel {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private static final long serialVersionUID = 1L;

	private JLabel lblTexte;
	private JLabel lblAuteur;
	private JLabel lblTexteTitre = new JLabel("Commentaire :"	);
	private JLabel lblAuteurTitre = new JLabel("Auteur :"		);

	private JButton btnProfil = new JButton("Profil");
	private JButton btnCarte = new JButton("Carte"	);

	private JPanel pnlAuteur = new JPanel(new GridLayout(1, 2)						);
	private JPanel pnlContenuCommentaire = new JPanel(								);
	private JPanel pnlCommentaire = new JPanel(new GridLayout(2, 1)					);
	private JPanel pnlGeneral = new JPanel(new GridLayout(2, 1)						);
	private JPanel pnlBoutons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

	private final static Font POLICETITRE = new Font("Segoe UI Black", Font.BOLD, 20);
	private final static Font POLICECORPS = new Font("Segoe UI", Font.PLAIN, 15		);

	private final static Color COULEURBOUTON = new Color(99, 00, 60);   

	
	
	//---------------------------------
	// CONSTRUCTEUR
	//---------------------------------
	/**
	 * Constructeur de la classe VueCommentaire.
	 * Ce constructeur permet de créer une instance de la classe qui servira à représenter la vue d'un commentaire.
	 * 
	 * @param modele Le commentaire représenté dans la vue graphique.
	 **/
	public VueCommentaire(ModeleCommentaire modele) {
		// Définir le contenu des labels
		lblAuteur = new JLabel(modele.getNomAuteur() + " " + modele.getPrenomAuteur());
		lblTexte = new JLabel("<html>" + modele.gettexteCommentaire().replace("\n", "<br>") + "</html>");

		// Appliquer les styles de police
		lblAuteurTitre.setFont(POLICETITRE);
		lblAuteur.setFont(POLICECORPS);
		lblTexteTitre.setFont(POLICETITRE);
		lblTexte.setFont(POLICECORPS);

		// Mise en page du contenu du commentaire
		lblTexte.setOpaque(true);
		pnlContenuCommentaire.setBackground(Color.WHITE);

		// Appliquer la couleur aux boutons
		btnProfil.setBackground(COULEURBOUTON);
		btnCarte.setBackground(COULEURBOUTON);
		btnProfil.setForeground(Color.WHITE);
		btnCarte.setForeground(Color.WHITE);

		// Appliquer le style de police aux boutons
		btnProfil.setFont(POLICECORPS);
		btnCarte.setFont(POLICECORPS);

		// Ajouter des effets visuels sur les boutons
		btnProfil.setFocusPainted(false);
		btnCarte.setFocusPainted(false);
		btnProfil.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		btnCarte.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

		// Ajouter des écouteurs pour les effets de survol
		addButtonHoverEffect(btnProfil);
		addButtonHoverEffect(btnCarte);

		// Mise en page de la vue
		setLayout(new BorderLayout());

		// Appliquer une couleur de fond
		lblTexte.setBackground(Color.WHITE);

		// Ajouter les éléments aux panels
		pnlContenuCommentaire.add(lblTexte);
		pnlCommentaire.add(lblTexteTitre);
		pnlCommentaire.add(pnlContenuCommentaire);
		pnlAuteur.add(lblAuteurTitre);
		pnlAuteur.add(lblAuteur);
		pnlGeneral.add(pnlAuteur);
		pnlGeneral.add(pnlCommentaire);
		pnlBoutons.add(btnProfil);
		pnlBoutons.add(btnCarte);

		// Ajouter les panels à la vue
		add(pnlGeneral, BorderLayout.NORTH);
		add(pnlBoutons, BorderLayout.SOUTH);
	}



	//---------------------------------
	// METHODES
	//---------------------------------
	/**
	 * Ajouter un écouteur au bouton "Profil".
	 * @param ecouteur L'écouteur.
	 **/
	public void btnProfilClick(ActionListener ecouteur) {
		btnProfil.addActionListener(ecouteur);
	}

	/**
	 * Ajouter un écouteur au bouton "Carte".
	 * @param ecouteur L'écouteur.
	 **/
	public void btnCarteClick(ActionListener ecouteur) {
		btnCarte.addActionListener(ecouteur);
	}

	/**
	 * Méthode pour ajouter des effets visuels (survol) aux boutons.
	 * @param bouton Le bouton à personnaliser.
	 **/
	private void addButtonHoverEffect(JButton bouton) {
		bouton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				bouton.setBackground(Color.BLACK);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
				bouton.setBackground(COULEURBOUTON);
			}
		});
	}
}
