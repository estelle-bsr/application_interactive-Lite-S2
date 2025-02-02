package Modeles;

import java.util.*;


/**
 * Cette classe est la classe ModeleListe. 
 * Elle permet de stockée les liste créée.
 * Une liste est définit par son nom et sa liste de carte.
 * 
 * @author Corentin DAROWNY
 */
public class ModeleListe {
	/******************
	 ** ATTRIBUTS **
	 ******************/
	private String nomListe;
	public ArrayList<ModeleCarte> sesCartes = new ArrayList<ModeleCarte>();

	/**********************
	 ** CONSTRUCTEUR **
	 **********************/
	/**
	 * Constructeur de la classe Modele liste permettant de créer une instance de celle-ci.
	 * @param nom Le nom de la liste
	 */
	public ModeleListe(String nom) {
		this.nomListe = nom;
	}

	/******************
	 ** METHODES **
	 ******************/
	/**
	 * Ajouter une carte à la liste
	 * @param c La carte ajoutée
	 */
	// Ajouter une carte
	public void ajouterCarte(ModeleCarte c) {
		sesCartes.add(c);
	}

	/******************
	 ** ACCESSEURS **
	 *******************/
	public String getNomListe() {
		return nomListe;
	}

	public void setNomListe(String nomListe) {
		this.nomListe = nomListe;
	}

	public ArrayList<ModeleCarte> getSesCartes() {
		return sesCartes;
	}

	public void setSesCartes(ArrayList<ModeleCarte> sesCartes) {
		this.sesCartes = sesCartes;
	}

}
