package Modeles;

/**
 * La classe ModelePrend_par est la classe permettant de créer les participations à des projets. 
 * Une participation est définie par le projet visé, le membre qui participe et sa permission.
 * 
 * @author Estelle BOISSERIE
 **/
public class ModelePrend_par {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private ModeleProjet Projet;
	private ModeleMembre Participant;
	private boolean PermissionCollabore;



	//---------------------------------
	// CONSTRUCTEUR
	//---------------------------------
	/**
	 * Constructeur de la classe ModelePrend_par.
	 * Ce constructeur permet de créer une instance de la classe ModelePrend_par qui représente le lien entre un projet et un membre.
	 * 
	 * @param projet Le projet ciblé
	 * @param membre Le participant
	 * @param permission La permission de si le membre peut apporter des modifications (supprimer, ajouter, créer, etc.) au projet
	 */
	public ModelePrend_par(ModeleProjet projet, ModeleMembre membre, boolean permission) {
		Projet = projet;
		Participant = membre;
		PermissionCollabore = permission;
		membre.ajouterProjet(projet);
		projet.ajouterMembre(membre);
	}



	//---------------------------------
	// ACCESSEURS
	//---------------------------------
	/**
	 * Avoir le projet sujet
	 * @return Le projet
	 **/
	public ModeleProjet getProjet() {
		return Projet;
	}
	/**
	 * Avoir le membre 
	 * @return Le participant
	 **/
	public ModeleMembre getMembre() {
		return Participant;
	}
	/**
	 * Savoir si le membre a la permission de modifier le projet 
	 * @return vrai (si le membre a la permission) ou faux (si le membre n'a pas la permission)
	 **/
	public boolean getPermissionCollabore() {
		return PermissionCollabore;
	}
	/**
	 * Présentation du membre
	 * @return La présentation du membre sous forme de String
	 **/
	public String getParticipant() {
		String membre = Participant.getNomMembre() + " " + Participant.getPrenomMembre() + 
				" " + PermissionCollabore + "\n";
		return membre;
	}
	/**
	 * Modifier la permission
	 * @param permissionCollabore La nouvelle permission du participant
	 **/
	public void setPermissionCollabore(boolean permissionCollabore) {
		PermissionCollabore = permissionCollabore;
	}
}