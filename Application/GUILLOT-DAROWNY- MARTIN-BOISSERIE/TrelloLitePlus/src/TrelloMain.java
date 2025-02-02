import javax.swing.*;
import java.awt.event.*;
import Vues.*;
import Controleurs.*;
import Modeles.*;

/**
 * Cette classe est la classe main de l'application. 
 * Elle permet de créer la première fenêtre du projet afin de lancer l'application.
 * 
 * @author Estelle BOISSERIE
 */
public class TrelloMain {
	/**
	 * Executer le main
	 * @param args une suite de String
	 */
	public static void main(String[] args) {
		// Créer la fenêtre de l'application
		JFrame fnrPrincipale = new JFrame ("TRELLO LITE+");


		// Créer la vue d'acceuil
		VueAcceuil Vue = new VueAcceuil();

		// Cliquer sur la croix de la fenêtre ferme celle-ci
		fnrPrincipale.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Créer un membre intiale
		ModeleMembre membre = new ModeleMembre("Boisserie","Estelle", "Sae", "estelle.boisserie@universite-paris-saclay.fr");

		// Créer un écouteur de la vue 
		ControleurAcceuil ecouteur = new ControleurAcceuil(Vue);

		// Execution des boutons
		/**
		 * Cliquer sur le bouton  "Connexion"
		 */
		Vue.btnConnexionClick(new ActionListener() {
			/**
			 * Evènement quand on clique
			 * @param e Evènement
			 **/
			public void actionPerformed(ActionEvent e) { 
				ecouteur.seConnecter(membre); 
			} 
		});
		/**
		 * Cliquer sur le bouton "Créer un compte"
		 */
		Vue.btnInscriptionClick(new ActionListener() {
			/**
			 * Evènement quand on clique
			 * @param e Evènement
			 **/
			public void actionPerformed(ActionEvent e) { 
				ecouteur.creerCompte(); 
			} 
		});

		// Ajouter la vue à la fenêtre
		fnrPrincipale.add(Vue);

		// Adapter de la taille de la fenêtre
		fnrPrincipale.setExtendedState(JFrame.MAXIMIZED_BOTH);

		// Afficher la fenetre
		fnrPrincipale.setVisible(true);



		//---------------------------------------------------------------------------------------------------------------
		//
		//		// Créer la fenetre du profil du membre 
		//		JFrame fnrProfil = new JFrame("Compte");
		//
		//		// Cliquer sur la croix de la fenêtre ferme celle-ci
		//		fnrProfil.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//
		//		// Créer un membre  
		//		ModeleMembre membre = new ModeleMembre("Estelle", "Boisserie", "mdp", "estelle.boisserie@universite-paris-saclay.fr");
		//
		//		// Créer une vue du profil du membre 
		//		VueMembre Profil = new VueMembre(membre);
		//
		//		// Créer une vue pour les modification du profil du membre 
		//		VueMembreModifie ProfilModifie = new VueMembreModifie(membre);
		//
		//		// Créer un controleur du membre 
		//		ControleurMembre ecouteurMembre = new ControleurMembre(membre, Profil, ProfilModifie);
		//
		//		// Créer des cartes 
		//		ModeleCarte carte = new ModeleCarte("Carte 1", "Permet de visualiser les cartes d'un membre", "05/06/2023"); 
		//		ModeleCarte carte2 = new ModeleCarte("Carte 2", "Test d'une deuxième", null);
		//
		//		// Créer les vues des cartes
		//		new VueCarte(carte); 
		//		new VueCarte(carte2);
		//
		//		// Créer une participation
		//		new ModeleParticipe(carte, membre, "chargé", true, true, true, true, true); 
		//		new ModeleParticipe(carte2, membre, "remplacant", true, false, true, false, true);
		//
		//		// Créer un commentaire
		//		ModeleCommentaire commentaire = new ModeleCommentaire("test", carte, membre);
		//		ModeleCommentaire commentaire2 = new ModeleCommentaire("deuxieme commentaire sur une meme carte test", carte, membre);
		//		ModeleCommentaire commentaire3 = new ModeleCommentaire("autre commentaire", carte2, membre);
		//
		//		// Créer les vues des commentaires
		//		VueCommentaire VueCommentaire1 = new VueCommentaire(commentaire); 
		//		VueCommentaire VueCommentaire2 = new VueCommentaire(commentaire2); 
		//		VueCommentaire VueCommentaire3 = new VueCommentaire(commentaire2);
		//
		//		// Créer des écouteur de commentaire
		//		ControleurCommentaire ecouteur = new ControleurCommentaire(commentaire, VueCommentaire1);
		//		ControleurCommentaire ecouteur2 = new ControleurCommentaire(commentaire2, VueCommentaire2);
		//		ControleurCommentaire ecouteur3 = new ControleurCommentaire(commentaire3, VueCommentaire3);
		//
		//		// Ajouter les commentaires au membre
		//		membre.ajouterCommentaire(commentaire);
		//		membre.ajouterCommentaire(commentaire2);
		//		membre.ajouterCommentaire(commentaire3);
		//
		//		// Execution des boutons
		//		/**
		//		 * Cliquer sur le bouton "Modifier"
		//		 **/
		//
		//		Profil.btnModifierClick(new ActionListener() {
		//			/**
		//			 * Evènement quand on clique
		//			 * 
		//			 * @param e Evènement
		//			 **/
		//
		//			public void actionPerformed(ActionEvent e) { ecouteurMembre.modifierProfil();
		//			} });
		//		/**
		//		 * Cliquer sur le bouton "Rafraîchir"
		//		 **/
		//
		//		Profil.btnRafraichirClick(new ActionListener() {
		//			/**
		//			 * Evènement quand on clique
		//			 * 
		//			 * @param e Evènement
		//			 **/
		//
		//			public void actionPerformed(ActionEvent e) { ecouteurMembre.rafraichir(); }
		//		});
		//		/**
		//		 * Cliquer sur le bouton "Voir mes commentaires"
		//		 **/
		//
		//		Profil.btnCommentaireClick(new ActionListener() {
		//			/**
		//			 * Evènement quand on clique
		//			 * 
		//			 * @param e Evènement
		//			 **/
		//
		//			public void actionPerformed(ActionEvent e) {
		//				ecouteurMembre.voirCommentaire(); } });
		//		/**
		//		 * Cliquer sur le bouton "Voir mes projets"
		//		 **/
		//
		//		Profil.btnProjetClick(new ActionListener() {
		//			/**
		//			 * Evènement quand on clique
		//			 * 
		//			 * @param e Evènement
		//			 **/
		//
		//			public void actionPerformed(ActionEvent e) { ecouteurMembre.voirProjet(); }
		//		});
		//		/**
		//		 * Cliquer sur le bouton "Modifier"
		//		 **/
		//
		//		Profil.btnCarteClick(new ActionListener() {
		//			/**
		//			 * Evènement quand on clique
		//			 * 
		//			 * @param e Evènement
		//			 **/
		//
		//			public void actionPerformed(ActionEvent e) { ecouteurMembre.voirCarte(); }
		//		});
		//		/**
		//		 * Cliquer sur le bouton "Sauvegarde"
		//		 **/
		//
		//		ProfilModifie.btnSauvegardeClick(new ActionListener() {
		//			/**
		//			 * Evènement quand on clique
		//			 * 
		//			 * @param e Evènement
		//			 **/
		//
		//			public void actionPerformed(ActionEvent e) { 
		//				ecouteurMembre.enregistrement();
		//			} 
		//		});
		//		/**
		//		 * Cliquer sur le bouton "Modifier"
		//		 **/
		//
		//		ProfilModifie.btnPhotoClick(new ActionListener() {
		//			/**
		//			 * Evènement quand on clique
		//			 * 
		//			 * @param e Evènement
		//			 **/
		//
		//			public void actionPerformed(ActionEvent e) { 
		//				ecouteurMembre.changerPhoto(); 
		//			}
		//		});
		//
		//		VueCommentaire1.btnProfilClick(new ActionListener() {
		//			public void actionPerformed(ActionEvent e) { 
		//				ecouteur.afficherProfil(); 
		//			} 
		//		});
		//		VueCommentaire2.btnProfilClick(new ActionListener() {
		//			public void actionPerformed(ActionEvent e) { 
		//				ecouteur2.afficherProfil(); 
		//			} 
		//		});
		//		VueCommentaire3.btnProfilClick(new ActionListener() {
		//			public void actionPerformed(ActionEvent e) { 
		//				ecouteur3.afficherProfil(); 
		//			} 
		//		});
		//
		//		// Ajouter la vue à la fenêtre 
		//		fnrProfil.add(Profil);
		//
		//		// Adapter la taille de la fenêtre 
		//		fnrProfil.pack();
		//
		//		// Centrer la fenêtre 
		//		fnrProfil.setLocationRelativeTo(null);
		//
		//		// Afficher la fenêtre 
		//		fnrProfil.setVisible(true);
	}
}
