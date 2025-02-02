package Vues;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Modeles.*;

/**
 * La classe VueMembre est la vue graphique d'un membre.
 * @author Estelle BOISSERIE
 */
public class VueMembre extends JPanel {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private static final long serialVersionUID = 1L;

	public static ModeleMembre modele;

	private JLabel lblNomMembre, lblPrenomMembre, lblMailMembre, lblMotdepasseMembre, lblPhoto;
	private JLabel lblNom = new JLabel("Nom : "					);
	private JLabel lblPrenom = new JLabel("Prénom : "			);
	private JLabel lblMail = new JLabel("Adresse mail : "		);
	private JLabel lblMotdepasse = new JLabel("Mot de passe : "	);

	private JButton btnModifier = new JButton("Modifier"				);
	private JButton btnRafraichir = new JButton("Rafraîchir"			);
	private JButton btnCommentaire = new JButton("Voir mes commentaires");
	private JButton btnProjet = new JButton("Voir mes projets"			);
	private JButton btnCarte = new JButton("Voir mes cartes"			);

	private JPanel pnlNom = new JPanel(new GridLayout(1, 2)			);
	private JPanel pnlPrenom = new JPanel(new GridLayout(1, 2)		);
	private JPanel pnlMail = new JPanel(new GridLayout(1, 2)		);
	private JPanel pnlMotdepasse = new JPanel(new GridLayout(1, 2)	);
	private JPanel pnlNomPrenom = new JPanel(new GridLayout(1, 2)	);
	private JPanel pnlGeneral = new JPanel(new GridLayout(5, 1)		);
	private JPanel pnlBoutons = new JPanel(new GridLayout(5, 1)		);
	private JPanel pnlImage = new JPanel(new FlowLayout()			);

	private final static Font POLICETITRE = new Font("Segoe UI Black", Font.BOLD, 20);
	private final static Font POLICECORPS = new Font("Segoe UI", Font.PLAIN, 15		);

	private final static Color COULEURBOUTON = new Color(99, 00, 60);

	private final static int MARGE = 20;



	//---------------------------------
	// CONSTRUCTEUR
	//---------------------------------
	/**
	 * Constructeur de la classe VueMembre.
	 * Crée une instance de VueMembre pour visualiser et gérer le profil de l'utilisateur.
	 * 
	 * @param modele Le profil affiché
	 **/
	public VueMembre(ModeleMembre modele) {
		// Récupérer le membre
		VueMembre.modele = modele;

		// Créer les labels des informations du membre
		lblNomMembre = new JLabel(modele.getNomMembre());
		lblPrenomMembre = new JLabel(modele.getPrenomMembre());
		lblMailMembre = new JLabel(modele.getMailMembre());
		lblMotdepasseMembre = new JLabel(modele.getMotdepasseMembreMasque());

		// Appliquer les styles de police
		lblNom.setFont(POLICETITRE);
		lblNomMembre.setFont(POLICECORPS);
		lblPrenom.setFont(POLICETITRE);
		lblPrenomMembre.setFont(POLICECORPS);
		lblMail.setFont(POLICETITRE);
		lblMailMembre.setFont(POLICECORPS);
		lblMotdepasse.setFont(POLICETITRE);
		lblMotdepasseMembre.setFont(POLICECORPS);
		btnModifier.setFont(POLICETITRE);
		btnRafraichir.setFont(POLICETITRE);
		btnCommentaire.setFont(POLICETITRE);
		btnProjet.setFont(POLICETITRE);
		btnCarte.setFont(POLICETITRE);

		// Appliquer la couleur aux boutons
		btnModifier.setBackground(COULEURBOUTON);
		btnRafraichir.setBackground(COULEURBOUTON);
		btnCommentaire.setBackground(COULEURBOUTON);
		btnProjet.setBackground(COULEURBOUTON);
		btnCarte.setBackground(COULEURBOUTON);

		btnModifier.setForeground(Color.WHITE);
		btnCommentaire.setForeground(Color.WHITE);
		btnRafraichir.setForeground(Color.WHITE);
		btnCarte.setForeground(Color.WHITE);
		btnProjet.setForeground(Color.WHITE);

		// Adapter le curseur
		btnModifier.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCommentaire.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRafraichir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCarte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProjet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		// Ajouter des marges
		pnlBoutons.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, MARGE));
		pnlGeneral.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, MARGE));

		// Ajouter la photo de profil dans le label
		lblPhoto = new JLabel(modele.getImgProfil());

		// Appliquer des styles à l'image de profil
		lblPhoto.setPreferredSize(new Dimension(100, 100));
		lblPhoto.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		lblPhoto.setOpaque(true);

		// Ajouter les labels dans les panels
		pnlNom.add(lblNom);
		pnlNom.add(lblNomMembre);
		pnlPrenom.add(lblPrenom);
		pnlPrenom.add(lblPrenomMembre);
		pnlNomPrenom.add(pnlNom);
		pnlNomPrenom.add(pnlPrenom);
		pnlGeneral.add(pnlNomPrenom);
		pnlMail.add(lblMail);
		pnlMail.add(lblMailMembre);
		pnlMotdepasse.add(lblMotdepasse);
		pnlMotdepasse.add(lblMotdepasseMembre);

		// Ajouter les boutons dans leur panneau
		pnlBoutons.add(btnModifier);
		pnlBoutons.add(btnRafraichir);
		pnlBoutons.add(btnCommentaire);
		pnlBoutons.add(btnProjet);
		pnlBoutons.add(btnCarte);

		// Ajouter l'image et d'autres infos dans leur panneau
		pnlImage.add(lblPhoto);
		pnlGeneral.add(pnlImage);
		pnlGeneral.add(pnlNomPrenom);
		pnlGeneral.add(pnlMail);
		pnlGeneral.add(pnlMotdepasse);

		// Agencement final
		setLayout(new BorderLayout());
		add(pnlGeneral, BorderLayout.EAST);
		add(pnlBoutons, BorderLayout.WEST);
	}



	//---------------------------------
	// METHODES
	//---------------------------------
	/**
	 * Ajouter un écouteur au bouton "Modifier".
	 * @param ecouteur L'écouteur.
	 **/
	public void btnModifierClick(ActionListener ecouteur) {
		btnModifier.addActionListener(ecouteur);
	}

	/**
	 * Ajouter un écouteur au bouton "Rafraîchir".
	 * @param ecouteur L'écouteur.
	 **/
	public void btnRafraichirClick(ActionListener ecouteur) {
		btnRafraichir.addActionListener(ecouteur);
	}

	/**
	 * Ajouter un écouteur au bouton "Mes commentaires".
	 * @param ecouteur L'écouteur.
	 **/
	public void btnCommentaireClick(ActionListener ecouteur) {
		btnCommentaire.addActionListener(ecouteur);
	}

	/**
	 * Ajouter un écouteur au bouton "Mes projets".
	 * @param ecouteur L'écouteur.
	 **/
	public void btnProjetClick(ActionListener ecouteur) {
		btnProjet.addActionListener(ecouteur);
	}

	/**
	 * Ajouter un écouteur au bouton "Mes cartes".
	 * @param ecouteur L'écouteur.
	 **/
	public void btnCarteClick(ActionListener ecouteur) {
		btnCarte.addActionListener(ecouteur);
	}

	/**
	 * Raifraîchir la fenêtre. 
	 * @param membre Le membre.
	 **/
	public void Redessiner(ModeleMembre membre) {
		setNomMembre(membre.getNomMembre());
		setPrenomMembre(membre.getPrenomMembre());
		setMailMembre(membre.getMailMembre());
		setMotdepasseMembre(membre.getMotdepasseMembreMasque());
		setPhotoMembre(membre.getImgProfil());
	}



	//---------------------------------
	// ACCESSEURS
	//---------------------------------
	/**
	 * Récupérer le membre.
	 * @return Le membre.
	 **/
	public ModeleMembre getModelMembre() {
		return VueMembre.modele;
	}

	/**
	 * Modifier le nom du membre.
	 * @param nom Le nouveau nom.
	 **/
	public void setNomMembre(String nom) {
		this.lblNomMembre.setText(nom);
	}

	/**
	 * Modifier le prenom du membre.
	 * @param prenom Le nouveau prenom.
	 **/
	public void setPrenomMembre(String prenom) {
		this.lblPrenomMembre.setText(prenom);
	}

	/**
	 * Modifier l'adresse mail du membre.
	 * @param mail La nouvelle adresse mail.
	 **/
	public void setMailMembre(String mail) {
		this.lblMailMembre.setText(mail);
	}

	/**
	 * Modifier le mot de passe du membre.
	 * @param motdepasse Le nouveau mot de passe.
	 **/
	public void setMotdepasseMembre(String motdepasse) {
		this.lblMotdepasseMembre.setText(motdepasse);
	}

	/**
	 * Modifier la photo du membre.
	 * @param photo La nouvelle photo.
	 **/
	public void setPhotoMembre(ImageIcon photo) {
		lblPhoto.setIcon(photo);
	}
}
