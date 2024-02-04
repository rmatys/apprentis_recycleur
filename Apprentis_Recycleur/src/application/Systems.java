package application;

import java.util.ArrayList;

import objets.*;


public class Systems {
	
	DonneesJeu donnees = new DonneesJeu(0,5,25);
	
	public enum TypeDechet {
        BATTERIE, BIO, VERRE, CARTON, VETEMENTS, METAL, PAPIER, PLASTIQUE_DUR, ORDINATEUR, DECHET, PLASTIQUE_MOU, NOURRITURE_DECHET;
    }
	
	public enum TypePoubelle {
        BIO, VERRE, CARTON, PLASTIQUE, ELECTRONIQUE, METAL, DECHET;
    }
	
	public static int nbrTrashAjouter = 0;
	
	public static void ajouterPoubelles(Panel pan, int nbrPoubelles) {
		for(TypePoubelle type: TypePoubelle.values()) {
			Poubelles poubelle = new Poubelles("poubelle" + type.ordinal(), type);
			pan.listPoubelles.add(poubelle);
		}
	}

	public void verifierCompatibilite(Poubelles poubelle, Trash dechet) {
		
	}
	
	public void succes() {
		
	}
	
	public void echec() {
		
	}

	public static void ajouterTrash(Panel pan) {
		Trash trash = new Trash("trash" + nbrTrashAjouter, TypeDechet.BIO);
		pan.trashAJeter = trash;
		
	}
}