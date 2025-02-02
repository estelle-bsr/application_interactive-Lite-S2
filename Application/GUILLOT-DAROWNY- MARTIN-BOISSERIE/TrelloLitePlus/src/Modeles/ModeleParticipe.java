package Modeles;

/**
 * La classe ModeleParticipe est une classe permettant de créer des participation à une carte.
 * En d'autre terme, cette classe permet de faire le lien entre un membre et une carte.
 * Une participation est définit par la carte ciblé, le participant visé, le rôle du participant, et ses permissions.
 * 
 * @author Corentin Darowny
 * @author Estelle BOISSERIE 
 *
 **/
public class ModeleParticipe {
	//---------------------------------
	// ATTRIBUTS
	//---------------------------------
	private ModeleCarte Carte;
	private ModeleMembre Participant;
	private String Role;
	private boolean PermissionAjouter;
	private boolean PermissionDeplacer;
	private boolean PermissionExclure;
	private boolean PermissionModifier;
	private boolean PermissionSupprimer;



	//---------------------------------
	// CONSTRUCTEUR
	//---------------------------------
	/**
	 * Constructeur de la classe ModeleParticipe.
	 * Ce constructeur permet de créer une instance de ModeleParticipe représentant une participation d'un membre à une carte.
	 * 
	 * @param carte La carte de participation
	 * @param membre Le membre qui participe à la carte
	 * @param role Le rôle du membre tel que l'éxecutif, le remplaçant, etc.
	 * @param ajout La permission d'ajouter des membres à une carte
	 * @param deplacement La permission de déplacer une carte
	 * @param exclusion La permission d'exclure un membre d'une carte
	 * @param modification La permission de modifier une carte
	 * @param suppression La permission de supprimer une carte
	 **/
	public ModeleParticipe(ModeleCarte carte, ModeleMembre membre, String role, boolean ajout, boolean deplacement, boolean exclusion,
			boolean modification, boolean suppression) {
		Carte = carte;
		Participant = membre;
		setRole(role);
		PermissionAjouter = ajout;
		PermissionDeplacer = deplacement;
		PermissionExclure = exclusion;
		PermissionModifier = modification;
		PermissionSupprimer = suppression;
		membre.ajouterCarte(carte);
		carte.ajouterMembre(membre);
	}



	//---------------------------------
	// ACCESSEURS
	//---------------------------------
	/**
	 * Savoir si le membre à la permission d'ajouter un membre à la carte
	 * @return vrai (si le membre a la permission) ou faux (si le membre n'a pas la permission)
	 **/
	public boolean getPermissionAjouter() {
		return PermissionAjouter;
	}
	/**
	 * Savoir si le membre à la permission de déplacer une carte
	 * @return vrai (si le membre a la permission) ou faux (si le membre n'a pas la permission)
	 **/
	public boolean getPermissionDeplacer() {
		return PermissionDeplacer;
	}
	/**
	 * Savoir si le membre à la permission d'exclure un autre membre d'une carte
	 * @return vrai (si le membre a la permission) ou faux (si le membre n'a pas la permission)
	 **/
	public boolean getPermissionExclure() {
		return PermissionExclure;
	}
	/**
	 * Savoir si le membre à la permission de modifier la carte
	 * @return vrai (si le membre a la permission) ou faux (si le membre n'a pas la permission)
	 **/
	public boolean getPermissionModifier() {
		return PermissionModifier;
	}
	/**
	 * Savoir si le membre à la permission de supprimer une carte
	 * @return vrai (si le membre a la permission) ou faux (si le membre n'a pas la permission)
	 **/
	public boolean getPermissionSupprimer() {
		return PermissionSupprimer;
	}
	/**
	 * Obtenir la carte sujet
	 * @return la carte
	 **/
	public ModeleCarte getCarte() {
		return Carte;
	}
	/**
	 * Obtenir le membre
	 * @return le membre
	 **/
	public ModeleMembre getMembre() {
		return Participant;
	}
	/**
	 * Obtenir le rôle du membre
	 * @return le role
	 **/
	public String getRole() {
		return Role;
	}
	/**
	 * Modifier un rôle à un membre
	 * @param role Le rôle du participant
	 **/
	public void setRole(String role) {
		Role = role;
	}
	/**
	 * Modifier la permission d'ajouter d'un participant 
	 * @param permission La permission d'ajouter un membre à une carte. True si oui. False si non.
	 **/
	public void setPermissionAjouter(boolean permission) {
		PermissionAjouter = permission;
	}
	/**
	 * Modifier la permission de déplacer une carte
	 * @param permission La permission de déplacer une carte. True si oui. False si non.
	 **/
	public void setPermissionDeplacer(boolean permission) {
		PermissionDeplacer = permission;
	}
	/**
	 * Modifier la permission d'exclure un membre.
	 * @param permission La permission d'exclure un membre. True si oui. False si non.
	 **/
	public void setPermissionExclure(boolean permission) {
		PermissionExclure = permission;
	}
	/**
	 * Modifier la permission de modifier une carte
	 * @param permission La permission de modifier une carte. True si oui. False si non.
	 **/
	public void setPermissionModifier(boolean permission) {
		PermissionModifier = permission;
	}
	/**
	 * Modifier la permission de supprimer une carte
	 * @param permission La permission de supprimer une carte. True si oui. False si non.
	 **/
	public void setPermissionSupprimer(boolean permission) {
		PermissionSupprimer = permission;
	}
}