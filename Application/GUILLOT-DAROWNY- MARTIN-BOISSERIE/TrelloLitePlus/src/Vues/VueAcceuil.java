package Vues;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * La classe VuAcceuil est la vue graphique du lancement de l'application.
 * 
 * @author Estelle BOISSERIE
 **/

public class VueAcceuil extends JPanel {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private static final long serialVersionUID = 1L;
	private JLabel lblLogo = new JLabel("LITE +"                    		);
	private JLabel lblConnexion = new JLabel("Connexion"                    );
	private JLabel lblMail = new JLabel("Votre adresse mail :"              );
	private JLabel lblMotdepasse = new JLabel("Votre mot de passe :"        );
	private JLabel lblInscription = new JLabel("Vous n'avez pas de compte ?");

	private JTextField txtMail = new JTextField(10);

	private JPasswordField txtMotdepasse = new JPasswordField(10);

	private JButton btnConnexion = new JButton("Se connecter"     );
	private JButton btnInscription = new JButton("Créer un compte");

	private JPanel pnlConnexion = new JPanel(new GridLayout(6,1) 	);
	private JPanel pnlBoutons = new JPanel(new BorderLayout()   	);
	private JPanel pnlInscription = new JPanel(new BorderLayout()	);
	private JPanel pnlGeneral = new JPanel(new BorderLayout()		);

	private final static Font POLICETITRE = new Font("Segoe UI Black", Font.BOLD, 100);
	private final static Font POLICECORPS = new Font("Segoe UI", Font.PLAIN, 20		);
	private final static Font POLICESAISIE = new Font("Segoe UI", Font.ITALIC, 15   );

	private final static Color COULEURBOUTON = new Color(99, 00, 60);



	//---------------------------------
	// CONSTRUCTEUR
	//---------------------------------
	/**
	 * Constructeur de la classe VueAcceuil.
	 * Ce constructeur permet de créer une instance de VueAcceuil qui représente la vue d'ouverture de l'application.
	 **/
	public VueAcceuil() {
		// Appliquer le style d'écriture
		lblLogo.setFont(POLICETITRE);
		lblConnexion.setFont(POLICECORPS);
		lblMail.setFont(POLICECORPS);
		lblMotdepasse.setFont(POLICECORPS);
		lblInscription.setFont(POLICECORPS);
		btnConnexion.setFont(POLICECORPS);
		btnInscription.setFont(POLICECORPS);
		txtMail.setFont(POLICESAISIE);
		txtMotdepasse.setFont(POLICESAISIE);

		// Appliquer la couleur de fond
		btnInscription.setBackground(COULEURBOUTON);
		btnConnexion.setBackground(COULEURBOUTON);
		addButtonHoverEffect(btnInscription);
		addButtonHoverEffect(btnConnexion);
		pnlConnexion.setBackground(Color.WHITE);
		pnlBoutons.setBackground(Color.WHITE);
		pnlInscription.setBackground(COULEURBOUTON);
		pnlGeneral.setBackground(COULEURBOUTON);
		setBackground(COULEURBOUTON);

		// Appliquer la couleur de police
		lblLogo.setForeground(Color.WHITE);
		lblInscription.setForeground(Color.WHITE);
		btnInscription.setForeground(Color.WHITE);
		btnConnexion.setForeground(Color.WHITE);

		// Appliquer des marges
		pnlConnexion.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		lblLogo.setBorder(BorderFactory.createEmptyBorder(10, 20, 30, 20));
		pnlGeneral.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
		
		// Adapter le curseur
		btnInscription.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInscription.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		// Appliquer une mise en page à la fenêtre
		pnlGeneral.setLayout(new BorderLayout());

		// Ajouter aux panels
		pnlBoutons.add(btnConnexion, BorderLayout.EAST);
		pnlConnexion.add(lblConnexion);
		pnlConnexion.add(lblMail);
		pnlConnexion.add(txtMail);
		pnlConnexion.add(lblMotdepasse);
		pnlConnexion.add(txtMotdepasse);
		pnlConnexion.add(pnlBoutons);
		pnlInscription.add(lblInscription, BorderLayout.WEST);
		pnlInscription.add(btnInscription, BorderLayout.EAST);
		pnlGeneral.add(lblLogo, BorderLayout.NORTH);
		pnlGeneral.add(pnlConnexion, BorderLayout.CENTER);
		pnlGeneral.add(pnlInscription, BorderLayout.SOUTH);

		// Ajouter à la fenêtre
		add(pnlGeneral);
	}



	//---------------------------------
	// METHODES
	//---------------------------------
	/**
	 * Ajouter un écouteur au bouton "Se connecter".
	 * @param ecouteur L'écouteur.
	 **/
	public void btnConnexionClick(ActionListener ecouteur) {
		btnConnexion.addActionListener(ecouteur);
	}

	/**
	 * Ajouter un écouteur au bouton "Créer un compte".
	 * @param ecouteur L'écouteur.
	 **/
	public void btnInscriptionClick(ActionListener ecouteur) {
		btnInscription.addActionListener(ecouteur);
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



	//---------------------------------
	// ACCESSEURS
	//---------------------------------
	/**
	 * Avoir l'adresse mail saisie par l'utilisateur.
	 * @return L'adresse mail saisie.
	 **/
	public String getMail() {
		return txtMail.getText();
	}

	/**
	 * Avoir le mot de passe saisie par l'utilisateur.
	 * @return Le mot de passe saisie.
	 **/
	public String getMotdepasse() {
		char[] motdepasse = txtMotdepasse.getPassword();
		return new String(motdepasse);
	}

	/**
	 * Modifier le contenu de la case de saisie de l'adresse mail.
	 * @param mail Le nouveau contenu.
	 **/
	public void setMail(String mail) {
		txtMail.setText(mail);;
	}

	/**
	 * Modifier le contenu de la case de saisie du mot de passe.
	 * @param Motdepasse Le nouveau mot de passe.
	 **/
	public void setMotdepasse(String Motdepasse) {
		txtMotdepasse.setText(Motdepasse);
	}
}
