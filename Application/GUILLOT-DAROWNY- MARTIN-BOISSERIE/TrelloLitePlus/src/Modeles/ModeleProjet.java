
package Modeles;

import java.util.*;

/**
 * Cette classe est la classe ModeleProjet elle permet de créer des projet et de les gérer.
 * Un projet est définit par son nom, son créateur, sa description , sa date d'échéance,
 *  ses participations, ses participants, et ses tableaux.
 * @author Antonin GUILLOT
 *
 */
public class ModeleProjet {
	/******************
	 ** ATTRIBUTS **
	 ******************/
	private String nomProjet;
	private ModeleMembre Createur;
	private String descriptionProjet;
	private String dateEcheanceProjet;
	private ArrayList <ModelePrend_par> participation;
	public ArrayList<ModeleMembre> membres;
	public ArrayList<ModeleTableau> tableaux;

	/**********************
	 ** CONSTRUCTEUR **
	 **********************/
	/**
	 * Ce constructeur permet de créer une instance de la classe
	 * @param nomProjet Le titre du projet
	 * @param createur Le membre qui a créer le projet
	 * @param descritptionProjet La description du projet
	 * @param dateEcheanceProjet La date d'échéance du projet
	 */
	public ModeleProjet(String nomProjet, ModeleMembre createur, String descritptionProjet, String dateEcheanceProjet) {
		this.nomProjet = nomProjet;
		Createur = createur;
		this.descriptionProjet = descritptionProjet;
		this.dateEcheanceProjet = dateEcheanceProjet;
		participation = new ArrayList<ModelePrend_par>();
		membres = new ArrayList<ModeleMembre>();
		tableaux = new ArrayList<ModeleTableau>();
	}



	/******************
	 ** METHODES **
	 ******************/
	// Modifier un projet
	public void editerProjet() {
		System.out.println("Que voulez-vous modifier ? (nom, description, date) ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		try {
			if (str == "nom") {
				System.out.println("Quel est le nouveau nom ?");
				str = sc.nextLine();
				setNomProjet(str);
			}
			if (str == "description") {
				System.out.println("Quel est la nouvelle description ?");
				str = sc.nextLine();
				setDescriptionProjet(str);
			}
			if (str == "date") {
				System.out.println("Quel est la nouvelle date ?");
				str = sc.nextLine();
				setDateEcheanceProjet(str);
			}
		} finally {
			sc.close();
		}
	}

	/*
	 * //Supprimer un projet de l'interface graphique
	 * public void supprimerProjet(Projet aProjet) {
	 * remove();
	 * setvisible(false);
	 * 
	 * }
	 */

	// Ajouter un Membre
	public void ajouterMembre(ModeleMembre m) {
		membres.add(m);
	}

	// Ajouter un tableau
	public void ajouterTableau(ModeleTableau t) {
		tableaux.add(t);
	}

	/******************
	 ** ACCESSEURS **
	 *******************/
	public String getNomProjet() {
		return nomProjet;
	}

	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}

	public String getDescriptionProjet() {
		return descriptionProjet;
	}

	public void setDescriptionProjet(String descriptionProjet) {
		this.descriptionProjet = descriptionProjet;
	}

	public String getDateEcheanceProjet() {
		return dateEcheanceProjet;
	}

	public void setDateEcheanceProjet(String dateEcheanceProjet) {
		this.dateEcheanceProjet = dateEcheanceProjet;
	}

	public ArrayList<ModeleMembre> getMembres() {
		return membres;
	}

	public ArrayList<ModeleTableau> getTableaux() {
		return tableaux;
	}



	public ArrayList<ModelePrend_par> getParticipation() {
		return participation;
	}



	public void setParticipation(ArrayList<ModelePrend_par> participation) {
		this.participation = participation;
	}



	public ModeleMembre getCreateurProjet() {
		return Createur;
	}



	public void setCreateur(ModeleMembre createur) {
		Createur = createur;
	}
}