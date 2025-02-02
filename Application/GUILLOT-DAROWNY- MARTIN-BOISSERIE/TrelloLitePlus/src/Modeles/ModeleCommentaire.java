package Modeles;

/**
 * La classe ModeleCommentaire est une classe permettant de créer des commentaires.
 * Les commentaires sont définit par un texte, un auteur et une carte.
 * 
 * @author Estelle BOISSERIE
 **/
public class ModeleCommentaire {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private String texteCommentaire;
	private ModeleMembre Auteur;
	private ModeleCarte Sujet;



	//---------------------------------
	// CONSTRUCTEUR
	//---------------------------------
	/**
	 * Constructeur de la class ModeleCommentaire
	 * Permet de créer une instance de ModeleCommentaire représentant un commentaire.
	 * 
	 * @param texte Le contenu du commentaire
	 * @param sujet La carte sujet du commentaire
	 * @param auteur Le membre étant auteur du commentaire.
	 **/
	public ModeleCommentaire(String texte, ModeleCarte sujet, ModeleMembre auteur) {
		texteCommentaire = texte;
		Auteur = auteur;
		Sujet = sujet;
	}



	//---------------------------------
	// ACCESSEURS
	//---------------------------------
	/**
	 * Avoir le texte d'un commentaire
	 * @return Le contenu du commentaire
	 **/
	public String gettexteCommentaire() {
		return texteCommentaire;
	}

	/**
	 * Avoir l'auteur 
	 * @return L'auteur
	 **/
	public ModeleMembre getAuteur() {
		return Auteur;
	}

	/**
	 * Avoir le nom de l'auteur 
	 * @return Le nom de l'auteur
	 **/
	public String getNomAuteur() {
		return Auteur.getNomMembre();
	}

	/**
	 * Avoir le prénom de l'auteur 
	 * @return Le prénom de l'auteur
	 **/
	public String getPrenomAuteur() {
		return Auteur.getPrenomMembre();
	}

	/**
	 * Avoir le sujet 
	 * @return Le sujet
	 **/
	public ModeleCarte getSujet() {
		return this.Sujet;
	}

	/**
	 * Modifier du texte à un commentaire
	 * @param texte Le nouveau texte du commentaire
	 **/
	public void settexteCommentaire(String texte) {
		this.texteCommentaire = texte;
	}

	/**
	 * Modifier un auteur à un commentaire
	 * @param ecrivain Le nouveau auteur du commentaire
	 **/
	public void setAuteur(ModeleMembre ecrivain) {
		this.Auteur = ecrivain;
	}

	/**
	 * Modifier le sujet 
	 * @param Le nouveau sujet
	 **/
	public void setSujet(ModeleCarte sujet) {
		this.Sujet = sujet;
	}
}