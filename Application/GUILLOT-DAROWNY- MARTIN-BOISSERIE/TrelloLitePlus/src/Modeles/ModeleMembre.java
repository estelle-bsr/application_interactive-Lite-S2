package Modeles;

import java.util.*;
import javax.swing.*;


/**
 * La classe ModeleMembre est une classe permettant de créer les membres de l'applications.
 * Elle permet de créer des objet membre représentant les membres présant sur LITE+.
 * Un membre est définit par son nom, son prénom, son mot de passe, et son adresse mail. 
 * Par défaut un membre n'a aucun projet, carte ni commentaire. 
 * Les projets, cartes et commentaires se rajouterons lorsque le membre participera et/ou écrira.
 * La photo de profil de l'utilisateur est par défaut une photo de profil vide.
 * 
 * @author Estelle BOISSERIE
 **/
public class ModeleMembre {
// public class ModeleMembre implements Serializable {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private String NomMembre;
	private String PrenomMembre;
	private String MotdepasseMembre;
	private String MailMembre;
	private ArrayList<ModeleProjet> mesProjets;
	private ArrayList<ModeleCarte> mesCartes;
	private ArrayList<ModeleCommentaire> mesCommentaires;
	private ImageIcon imgProfil;



	//---------------------------------
	// CONSTRUCTEUR
	//---------------------------------
	/**
	 * Constructeur de la classe ModeleMembre.
	 * Permet de créer une instance de ModeleMembre représentant le membre.
	 *
	 * La photo de profil est définit par défaut.
	 * Par défaut, la liste des commentaires, projets et carte est vide.
	 * 
	 * @param nom Le String représentant le nom du membre
	 * @param prenom Le String représentant le prénom du membre
	 * @param mdp Le String représentant le mot de passe du membre
	 * @param mail Le String représentant l'adresse mail du membre
	 **/
	public ModeleMembre(String nom, String prenom, String mdp, String mail) {
		NomMembre = nom;
		PrenomMembre = prenom;
		MotdepasseMembre = mdp;
		MailMembre = mail;
		mesProjets = new ArrayList<ModeleProjet>();
		mesCartes  = new ArrayList<ModeleCarte>();
		mesCommentaires  = new  ArrayList<ModeleCommentaire>();
		setImgProfil(new ImageIcon("..Images/Photo_de_profil.jpg"));
	}



	//---------------------------------
	// METHODES
	//---------------------------------
	/**
	 * Ajouter un projet auquel participe le membre
	 * @param  projet Un nouveau projet
	 **/
	public void ajouterProjet(ModeleProjet projet) {
		mesProjets.add(projet);
	}

	/**
	 * Ajouter une carte à laquelle participe le membre
	 * @param carte  Une nouvelle carte
	 **/
	public void ajouterCarte(ModeleCarte carte) {
		mesCartes.add(carte);
	}

	/**
	 * Ajouter un commentaire qu'a écrit le membre
	 * @param commentaire  Un nouveau commentaire
	 **/
	public void ajouterCommentaire(ModeleCommentaire commentaire) {
		mesCommentaires.add(commentaire);
	}

	/**
	 * Supprimer un projet où participait le membre
	 * @param projet Le projet ciblé
	 **/
	public void supprimerProjet(ModeleProjet projet) {
		mesProjets.remove(projet);
	}

	/**
	 * Supprimer une carte où participait le membre
	 * @param carte La carte ciblée
	 **/
	public void supprimerCarte(ModeleCarte carte) {
		mesCartes.remove(carte);
	}

	/**
	 * Supprimer un commentaire où participait le membre
	 * @param commentaire Le commentaire ciblé
	 **/
	public void supprimerCommentaire(ModeleCommentaire commentaire) {
		mesCommentaires.remove(commentaire);
	}



	//---------------------------------
	// ACCESSEURS
	//---------------------------------
	/**
	 * Modifier un nouveau nom au membre
	 * @param nom Un nouveau nom
	 **/
	public void setNomMembre(String nom) {
		NomMembre = nom;
	}
	/**
	 * Modifier un nouveau prénom au membre
	 * @param prenom Un nouveau prénom
	 **/
	public void setPrenomMembre(String prenom) {
		PrenomMembre = prenom;
	}
	/**
	 * Modifier un nouveau mot de passe au membre
	 * @param motdepasse Un nouveau mot de passe
	 **/
	public void setMotdepasseMembre(String motdepasse) {
		MotdepasseMembre = motdepasse;
	}
	/**
	 * Modifier un nouveau mail au membre
	 * @param mail Un nouveau mail
	 **/
	public void setMailMembre(String mail) {
		// Vérifier le format du mail (contient un @, ., etc.)
		// Si le format dumail est valide
		if (mail.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
			//Modifier le mail originel
			this.MailMembre = mail;
		} 
		// Si non 
		else {
			// Afficher un message d'erreur
			JOptionPane.showMessageDialog(null, "ERREUR: Veuillez entrer un format d'adresse mail valide.", "Avertissement",
					JOptionPane.WARNING_MESSAGE);
		}
	}
	/**
	 * Modifier la photo de profil du membre
	 * @param imgProfil La nouvelle photo de profil
	 **/
	public void setImgProfil(ImageIcon imgProfil) {
		this.imgProfil = imgProfil;
	}
	/**
	 * Obtenir le nom du membre
	 * @return Le nom du membre
	 **/
	public String getNomMembre() {
		return NomMembre;
	}
	/**
	 * Obtenir le prénom du membre
	 * @return Le prénom du membre
	 **/
	public String getPrenomMembre() {
		return PrenomMembre;
	}
	/**
	 * Obtenir le mot de passe du membre
	 * @return Le mot de passe du membre
	 **/
	public String getMotdepasseMembre() {
		return MotdepasseMembre.trim();
	}
	/**
	 * Obtenir le mot de passe masqué du membre
	 * @return Le mot de passe masqué du membre
	 **/
	public String getMotdepasseMembreMasque() {
		String MotdepasseCode = "";
		for (int i = 0; i < MotdepasseMembre.length(); i++) {
			MotdepasseCode += "*";
		}
		return MotdepasseCode;
	}
	/**
	 * Obtenir l'adresse mail du membre
	 * @return L'adresse mail du membre
	 **/
	public String getMailMembre() {
		return MailMembre;
	}
	/**
	 * Obtenir la liste de projets auxquels participe le membre
	 * @return La liste de projets où participe le membre
	 **/
	public ArrayList<ModeleProjet> getMesProjets() {
		return mesProjets;
	}
	/**
	 * Obtenir la liste de cartes auxquelles participe le membre
	 * @return La liste de carte où participe le membre
	 **/
	public ArrayList<ModeleCarte> getMesCartes() {
		return mesCartes;
	}
	/**
	 * Obtenir la liste de commentaires auxquels participe le membre
	 * @return La liste de commentaire dont le membre est l'auteur
	 **/
	public ArrayList<ModeleCommentaire> getMesCommentaires() {
		return mesCommentaires;
	}
	/**
	 * Obtenir l'image de profil du membre
	 * @return La photo de profil du membre
	 **/
	public ImageIcon getImgProfil() {
		return imgProfil;
	}
}