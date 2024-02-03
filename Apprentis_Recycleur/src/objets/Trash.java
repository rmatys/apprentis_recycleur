package objets;

public class Trash {
	public String nom;
	public int idType;
	public String image; 
	
	public Trash(String nomTrash, int id) {
		this.nom = nomTrash;
		this.idType = id;
	}
	
	public Trash(String nomTrash, int id, String image) {
		this.nom = nomTrash;
		this.idType = id;
		this.image = image;
	}
}
