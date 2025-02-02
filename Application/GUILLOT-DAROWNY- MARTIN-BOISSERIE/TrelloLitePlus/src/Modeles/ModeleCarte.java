package Modeles;

import java.util.*;

/**
 * @author Cathy MARTIN
 *
 *         La classe ModeleCarte représente une carte dans le projet.
 *         Une carte a un nom, une description, une date d'échéance et un
 *         statut.
 *         Les cartes peuvent être jointes les unes aux autres.
 *         Le statut d'une carte peut être "pas commencer", "en cours" ou
 *         "fini".
 *         
 * Inspiré de @author Estelle BOISSERIE
 */

public class ModeleCarte {
	/******************
	 ** ATTRIBUTS **
	 ******************/
	private String nomCarte;
	private String descriptionCarte;
	private String dateEcheanceCarte;
	private String statutCarte; 
	private ArrayList<ModeleParticipe> participations = new ArrayList<ModeleParticipe>();
	private ArrayList<ModeleMembre> membres = new ArrayList<ModeleMembre>();
	private ArrayList<ModeleCommentaire> commentaires = new ArrayList<ModeleCommentaire>();
	public ArrayList<ModeleCarte> carteJointe = new ArrayList<ModeleCarte>();
	public static final String sPC = "pas commencer";
	public static final String sEC = "en cours";
	public static final String sF = "fini";

	/**********************
	 ** CONSTRUCTEUR **
	 **********************/

	/**
	 * Constructeur de la classe ModeleCarte.
	 * Crée une nouvelle instance de ModeleCarte avec le nom, la description, la
	 * date d'échéance et le statut spécifiés.
	 * Le statut de la carte par défaut est "pas commencer".
	 * 
	 * @param nom         Le nom/titre de la carte.
	 * @param description La description de la carte.
	 * @param date        La date d'échéance de la carte.
	 */
	public ModeleCarte(String nom, String description, String date) {
		this.nomCarte = nom;
		this.descriptionCarte = description;
		this.dateEcheanceCarte = date;
		this.statutCarte = "pas commencer";
	}

	/******************
	 ** METHODES **
	 ******************/

	/**
	 * Joint une carte à la liste des cartes jointes.
	 * 
	 * @param carte La carte à joindre.
	 */
	public void joindreCarte(ModeleCarte Carte) {
		carteJointe.add(Carte);
	}

	/**
	 * Ajouter une participation.
	 * @author Estelle BOISSERIE
	 * @param participation Ajoute une participation à la carte
	 */
	public void ajouterParticipation(ModeleParticipe participation) {
		participations.add(participation);
	}
	/**
	 * Ajouter un participant.
	 * @author Estelle BOISSERIE
	 * @param participant Ajoute un membre à la carte
	 */
	public void ajouterMembre(ModeleMembre membre) {
		membres.add(membre);
	}
	/**
	 * Ajouter un commentaire.
	 * @author Estelle BOISSERIE
	 * @param commentaire Ajoute un commentaire à la carte
	 */
	public void ajouterMembre(ModeleCommentaire commentaire) {
		commentaires.add(commentaire);
	}

	/******************
	 ** ACCESSEURS **
	 *******************/

	/**
	 * Définit le nom de la carte.
	 * 
	 * @param nomCarte Le nom de la carte.
	 */
	public void setNomCarte(String nomCarte) {
		this.nomCarte = nomCarte;
	}

	/**
	 * Récupère le nom de la carte.
	 * 
	 * @return Le nom de la carte.
	 */
	public String getNomCarte() {
		return nomCarte;
	}

	/**
	 * Définit la description de la carte.
	 * 
	 * @param descriptionCarte La description de la carte.
	 */
	public void setDescriptionCarte(String descriptionCarte) {
		this.descriptionCarte = descriptionCarte;
	}

	/**
	 * Récupère la description de la carte.
	 * 
	 * @return La description de la carte.
	 */
	public String getDescriptionCarte() {
		return descriptionCarte;
	}

	/**
	 * Définit la date d'échéance de la carte.
	 * 
	 * @param dateEcheanceCarte La date d'échéance de la carte.
	 */
	public void setDateEcheanceCarte(String dateEcheanceCarte) {
		this.dateEcheanceCarte = dateEcheanceCarte;
	}

	/**
	 * Récupère la date d'échéance de la carte.
	 * 
	 * @return La date d'échéance de la carte.
	 */
	public String getDateEcheanceCarte() {
		return dateEcheanceCarte;
	}

	/**
	 * Définit le statut de la carte.
	 * 
	 * @param statutCarte Le statut de la carte.
	 */
	public void setStatutCarte(String statutCarte) {
		this.statutCarte = statutCarte;
	}

	/**
	 * Récupère le statut de la carte.
	 * 
	 * @return Le statut de la carte.
	 */
	public String getStatutCarte() {
		return statutCarte;
	}

	public ArrayList<ModeleParticipe> getParticipations() {
		return participations;
	}

	public void setParticipations(ArrayList<ModeleParticipe> participations) {
		this.participations = participations;
	}

	public ArrayList<ModeleMembre> getMembres() {
		return membres;
	}

	public void setMembres(ArrayList<ModeleMembre> membres) {
		this.membres = membres;
	}

	public ArrayList<ModeleCommentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(ArrayList<ModeleCommentaire> commentaires) {
		this.commentaires = commentaires;
	}
	
}