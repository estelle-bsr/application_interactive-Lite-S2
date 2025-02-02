package Vues;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Cette classe est la VueProjet qui est la vue graphique des projets. 
 * Elle représente les données de ModeleProjet.
 * 
 * @author Antonin Guillot
 * @author Estelle BOISSERIE
 */
public class VueProjet extends JPanel {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private static final long serialVersionUID = 1L;

	private JLabel lblLogo = new JLabel("Mes projets");

	private JButton btnCreer = new JButton("+");

	private JPanel pnlProjet = new JPanel(					);
	private JPanel pnlGlobal = new JPanel(new BorderLayout());

	private final static Font POLICETITRE = new Font("Segoe UI Black", Font.BOLD, 40);

	private final static Color COULEURBOUTON = new Color(99, 00, 60);



	//---------------------------------
	// CONSTRUCTEUR
	//---------------------------------
	/**
	 * Constructeur de la classe VueProjet. 
	 * Il permet de créer une instance de VueProjet qui est la vue graphique des projets.
	 **/
	public VueProjet () {
		// Mise en page arrière
		setLayout(new BorderLayout());

		// Appliquer une police d'écriture et augmenter la taille du titre
		lblLogo.setFont(POLICETITRE);
		lblLogo.setForeground(Color.WHITE);

		// Appliquer la couleur du bouton
		btnCreer.setFont(POLICETITRE);
		btnCreer.setForeground(Color.WHITE);
		btnCreer.setBackground(COULEURBOUTON);
		btnCreer.setPreferredSize(new Dimension(200, 60));
		btnCreer.setFocusPainted(false);
		btnCreer.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		btnCreer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreer.setBackground(COULEURBOUTON);

		// Appliquer un fond
		setBackground(COULEURBOUTON);

		// Centrer le titre
		JPanel pnlTitle = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		pnlTitle.setOpaque(false);
		pnlTitle.add(lblLogo);

		// Centrer le bouton
		pnlProjet.setLayout(new BoxLayout(pnlProjet, BoxLayout.Y_AXIS));
		pnlProjet.setOpaque(true);

		pnlGlobal = new JPanel(new BorderLayout());
		pnlGlobal.setBorder(new EmptyBorder(30, 30, 30, 30));
		pnlGlobal.setOpaque(false);
		pnlGlobal.add(pnlTitle, BorderLayout.NORTH);
		pnlGlobal.add(pnlProjet, BorderLayout.CENTER);
		pnlGlobal.add(btnCreer, BorderLayout.SOUTH);

		// Ajout final du panel global
		add(pnlGlobal);
	}



	//---------------------------------
	// METHODES
	//---------------------------------
	/**
	 * Ajoute un écouteur au bouton "Créer" pour gérer le clic sur ce bouton.
	 *
	 * @param ecouteur L'écouteur d'événement à ajouter au bouton.
	 */
	public void btnCreerClick(ActionListener ecouteur) {
		btnCreer.addActionListener(ecouteur);
	}

	/**
	 * Rafraîchir la fenêtre.
	 */
	public void Redessiner() {
		repaint();
	}

	/**
	 * Fermer la fenêtre.
	 */
	public void fermerFenetre() {
		Window parentWindow = SwingUtilities.getWindowAncestor(this);
		if (parentWindow != null) {
			parentWindow.dispose();
		}
	}

	public void ajouterProjet(JPanel projetPanel) {
		pnlProjet.add(projetPanel);
		pnlProjet.revalidate();
		pnlProjet.repaint();
	}



	//---------------------------------
	// ACCESSEURS
	//---------------------------------
	/**
	 * Récupérer le panel global.
	 * @return JPanel le panel global.
	 */
	public JPanel getPnlGlobal() {
		return pnlGlobal;
	}

	/**
	 * Modifier le panel global.
	 * @param pnlGlobal Le panel global.
	 */
	public void setPnlGlobal(JPanel pnlGlobal) {
		this.pnlGlobal = pnlGlobal;
	}
}