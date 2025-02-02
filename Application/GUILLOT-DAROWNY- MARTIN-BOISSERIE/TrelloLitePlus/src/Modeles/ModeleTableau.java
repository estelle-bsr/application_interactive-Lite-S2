package Modeles;

import java.util.*;

/**
 * 
 *
 * La classe ModeleTableau représente un tableau ou il y aura des listes qui eux même contiendront des cartes dans le projet.
 * Un tableau a un nom.
 * @author Corentin DAROWNY
 */

public class ModeleTableau {
	/******************
	 ** ATTRIBUTS **
	 ******************/
	private String nomTableau;
	//private ModeleProjet sonProjet;
	public ArrayList<ModeleListe> sesListes = new ArrayList<ModeleListe>();

	/**********************
	 ** CONSTRUCTEUR **
	 **********************/

	/**
	 * Constructeur de la classe ModeleTableau.
	 * Crée une nouvelle instance de ModeleTableau avec un nom.
	 * @param nom Le nom/titre du tableau.
	 */
	public ModeleTableau(String nom) {
		this.nomTableau = nom;
	}

	/******************
	 ** METHODES **
	 ******************/

	/**
	 * Ajoute à la liste de ModeleListe du tableau une liste.
	 * @param l La liste à ajouter.
	 */
	public void ajouterListe(ModeleListe l) {
		sesListes.add(l);
	}

	/******************
	 ** ACCESSEURS **
	 *******************/

	/**
	 * Récupère le nom du tableau.
	 * @return Le nom du tableau.
	 */
	public String getNomTableau() {
		return nomTableau;
	}

	/**
	 * Définit le nom du tableau.
	 * @param nomTableau Le nom du tableau.
	 */
	public void setNomTableau(String nomTableau) {
		this.nomTableau = nomTableau;
	}

	/**
	 * Récupère la liste de ModeleListe du tableau.
	 * @return La liste de ModeleListe du tableau.
	 */
	public ArrayList<ModeleListe> getSesListes() {
		return sesListes;
	}

	/**
	 * Définit la liste de liste du tableau.
	 * @param sesListe Une liste de ModeleListe.
	 */
	public void setSesListes(ArrayList<ModeleListe> sesListes) {
		this.sesListes = sesListes;
	}
}


