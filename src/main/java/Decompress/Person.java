package Decompress;

public class Person {
	Person(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	String nom;
	String prenom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
