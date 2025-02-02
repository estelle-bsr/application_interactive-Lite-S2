package Vues;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Modeles.*;

/**
 * Cette classe est la classe VueMembreModifie.
 * Elle représente la vue graphique des modifications du profil d'un membre.
 * Elle affichée lorsque le membre va dans son profil, représenter par VueMembre, et clique sur le bouton "Modifier".
 * 
 * @author Estelle BOISSERIE
 *
 **/
public class VueMembreModifie extends JPanel {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private static final long serialVersionUID = 1L;

	private ModeleMembre modele;

	private JLabel lblNom = new JLabel("Nom : "													);
	private JLabel lblPrenom = new JLabel("Prénom : "											);
	private JLabel lblMail = new JLabel("Adresse mail : "										);
	private JLabel lblAncienMotdepasse = new JLabel("Mot de passe actuel : "					);
	private JLabel lblNouveauMotdepasse = new JLabel("Nouveau mot de passe : "					);
	private JLabel lblMotdepasseConfirme = new JLabel("Confirmer votre nouveau mot de passe : "	);

	private JTextField txtNomMembre = new JTextField(20							);
	private JTextField txtPrenomMembre = new JTextField(20						);
	private JTextField txtMailMembre = new JTextField(20						);
	private JTextField txtAncienMotdepasseMembre = new JTextField(20			);
	private JPasswordField txtNouveauMotdepasseMembre = new JPasswordField(20	);
	private JPasswordField txtMotdepasseConfirmeMembre = new JPasswordField(20	);

	private JButton btnSauvegarde = new JButton("Sauvegarder"			);
	private JButton btnPhoto = new JButton("Modifier la photo de profil");

	private JPanel pnlGeneral = new JPanel(		);
	private JPanel pnlNomPrenom = new JPanel(	);
	private JPanel pnlMotdepasses = new JPanel(	);
	private JPanel pnlPhoto = new JPanel(		);

	private final static Font POLICETITRE = new Font("Segoe UI Black", Font.BOLD, 40);
	private final static Font POLICECORPS = new Font("Segoe UI", Font.PLAIN, 20		);

	private final static Color COULEURBOUTON = new Color(99, 00, 60);



	//---------------------------------
	// CONSTRUCTEUR
	//---------------------------------
	/**
	 * Constructeur de la classe VueMembreModifie.
	 * Crée une instance de VueMembreModifie pour modifier le profil de l'utilisateur.
	 * 
	 * @param modele Le profil affiché
	 **/
	public VueMembreModifie(ModeleMembre modele) {
		// Récupérer l'utilisateur
		this.modele = modele;

		// Appliquer les styles de police
		lblNom.setFont(POLICETITRE);
		lblPrenom.setFont(POLICETITRE);
		lblMail.setFont(POLICETITRE);
		lblAncienMotdepasse.setFont(POLICETITRE);
		lblNouveauMotdepasse.setFont(POLICETITRE);
		lblMotdepasseConfirme.setFont(POLICETITRE);

		// Appliquer le style aux boutons
		btnSauvegarde.setFont(POLICETITRE);
		btnSauvegarde.setBackground(COULEURBOUTON);
		btnPhoto.setFont(POLICETITRE);
		btnPhoto.setBackground(COULEURBOUTON);
		btnSauvegarde.setForeground(Color.WHITE);
		btnPhoto.setForeground(Color.WHITE);

		// Appliquer le style de curseur
		btnSauvegarde.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPhoto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		// Appliquer le style aux champs de saisis
		txtNomMembre.setFont(POLICECORPS);
		txtPrenomMembre.setFont(POLICECORPS);
		txtMailMembre.setFont(POLICECORPS);
		txtAncienMotdepasseMembre.setFont(POLICECORPS);
		txtNouveauMotdepasseMembre.setFont(POLICECORPS);
		txtMotdepasseConfirmeMembre.setFont(POLICECORPS);

		// Utilisation du GroupLayout pour plus de flexibilité
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);

		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		// Organisation des composants
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(lblNom)
								.addComponent(lblPrenom)
								.addComponent(lblMail)
								.addComponent(lblAncienMotdepasse)
								.addComponent(lblNouveauMotdepasse)
								.addComponent(lblMotdepasseConfirme))
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(txtNomMembre)
								.addComponent(txtPrenomMembre)
								.addComponent(txtMailMembre)
								.addComponent(txtAncienMotdepasseMembre)
								.addComponent(txtNouveauMotdepasseMembre)
								.addComponent(txtMotdepasseConfirmeMembre)))
				.addGroup(layout.createSequentialGroup()
						.addComponent(btnSauvegarde)
						.addComponent(btnPhoto))
				);

		layout.setVerticalGroup(
				layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lblNom)
						.addComponent(txtNomMembre))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lblPrenom)
						.addComponent(txtPrenomMembre))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lblMail)
						.addComponent(txtMailMembre))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lblAncienMotdepasse)
						.addComponent(txtAncienMotdepasseMembre))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lblNouveauMotdepasse)
						.addComponent(txtNouveauMotdepasseMembre))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lblMotdepasseConfirme)
						.addComponent(txtMotdepasseConfirmeMembre))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(btnSauvegarde)
						.addComponent(btnPhoto))
				);

		// Customisation de la photo de profil
		pnlPhoto.add(btnPhoto);

		// Ajouter tous les panneaux à pnlGeneral
		pnlGeneral.setLayout(new BoxLayout(pnlGeneral, BoxLayout.Y_AXIS));
		pnlGeneral.add(pnlNomPrenom);
		pnlGeneral.add(pnlMotdepasses);
		pnlGeneral.add(pnlPhoto);
		add(pnlGeneral);
	}



	//---------------------------------
	// METHODES
	//---------------------------------
	/**
	 * Ajouter un écouteur au bouton "Sauvegarder".
	 * @param ecouteur L'écouteur.
	 **/
	public void btnSauvegardeClick(ActionListener ecouteur) {
		btnSauvegarde.addActionListener(ecouteur);
	}

	/**
	 * Ajouter un écouteur au bouton "Modifier photo".
	 * @param ecouteur L'écouteur.
	 **/
	public void btnPhotoClick(ActionListener ecouteur) {
		btnPhoto.addActionListener(ecouteur); 
	}

	/**
	 * Vider les cases de saisies de texte.
	 **/
	public void viderCase() {
		// Vider la case de saisie de nom
		setNomMembre("");
		// Vider la case de saisie de prénom
		setPrenomMembre("");
		// Vider la case de saisie d'adresse mail
		setMailMembre("");
		// Vider la case de saisie du mot de passe actuel
		setAncienMotdepasse("");
		// Vider la case de saise de nouveau mot de passe
		setNouveauMotdepasse("");
		// Vider la case de saisie de confirmation du nouveau mot de passe
		setMotdepasseConfirme("");
	}



	//---------------------------------
	// ACCESSEURS
	//---------------------------------
	/**
	 * Récupérer le membre.
	 * @return Le membre.
	 **/
	public ModeleMembre getModelMembre() {
		return this.modele;
	}

	/**
	 * Avoir le nom du membre.
	 * @return Le nom du membre.
	 **/
	public String getNomMembre() {
		return txtNomMembre.getText();
	}

	/**
	 * Avoir le prénom du membre.
	 * @return Le prénom du membre.
	 **/
	public String getPrenomMembre() {
		return txtPrenomMembre.getText();
	}

	/**
	 * Avoir le mail du membre.
	 * @return Le mail du membre.
	 **/
	public String getMailMembre() {
		return txtMailMembre.getText();
	}

	/**
	 * Avoir l'ancien mot de passe du membre.
	 * @return L'ancien mot de passe du membre.
	 **/
	public String getAncienMotdepasse() {
		return txtAncienMotdepasseMembre.getText().trim();
	}

	/**
	 * Avoir le nouveau mot de passe du membre.
	 * @return Le nouveau mot de passe du membre.
	 **/
	public String getNouveauMotdepasse() {
		char[] motdepasse = txtNouveauMotdepasseMembre.getPassword();
		return new String(motdepasse);
	}

	/**
	 * Avoir le mot de passe de confirmation du membre.
	 * @return Le mot de passe de confirmation  du membre.
	 **/
	public String getMotdepasseConfirme() {
		char[] motdepasse = txtMotdepasseConfirmeMembre.getPassword();
		return new String(motdepasse);
	}

	/**
	 * Modifier la case de saisie du nom d'un membre.
	 * @param nom Le nouveau contenu.
	 **/
	public void setNomMembre(String nom) {
		txtNomMembre.setText(nom);
	}

	/**
	 * Modifier la case de saisie du prénom d'un membre.
	 * @param prenom Le nouveau contenu.
	 **/
	public void setPrenomMembre(String prenom) {
		txtPrenomMembre.setText(prenom);
	}

	/**
	 * Modifier la case de saisie de l'adresse mail d'un membre.
	 * @param mail Le nouveau contenu.
	 **/
	public void setMailMembre(String mail) {
		txtMailMembre.setText(mail);
	}

	/**
	 * Modifier la case de saisie du mot de passe actuel d'un membre.
	 * @param motdepasse Le nouveau contenu.
	 **/
	public void setAncienMotdepasse(String motdepasse) {
		txtAncienMotdepasseMembre.setText(motdepasse);
	}

	/**
	 * Modifier la case de saisie du nouveau mot de passe d'un membre.
	 * @param motdepasse Le nouveau contenu.
	 **/
	public void setNouveauMotdepasse(String motdepasse) {
		txtNouveauMotdepasseMembre.setText(motdepasse);
	}

	/**
	 * Modifier la case de saisie du mot de passe de confirmation d'un membre.
	 * @param motdepasse Le nouveau contenu.
	 **/
	public void setMotdepasseConfirme(String motdepasse) {
		txtMotdepasseConfirmeMembre.setText(motdepasse);
	}
}