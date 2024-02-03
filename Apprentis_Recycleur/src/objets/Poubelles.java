package objets;

public class Poubelles {
	public String nom;
	public int idType;
	public String image;
	
	public Poubelles(String nomPoubelle, int id) {
		this.nom = nomPoubelle;
		this.idType = id;
	}
	
	public Poubelles(String nomPoubelle, int id, String image) {
		this.nom = nomPoubelle;
		this.idType = id;
		this.image = image;
	}
}
