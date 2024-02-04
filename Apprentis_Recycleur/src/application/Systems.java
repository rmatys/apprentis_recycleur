package application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import objets.*;


public class Systems {
	
	DonneesJeu donnees = new DonneesJeu(0,5,25);
	
	public int nbrTrashAjouter = 0;
	
	public ArrayList<Trash> dechetsTableau = new ArrayList<>(); 
	
    Path pathDatabase = Paths.get("..\\Apprentis_Recycleur\\src\\application\\Database.txt");
	String[] tableau;
    TypeDechet type;
	
	public enum TypeDechet {
        BATTERIE, BIO, VERRE, CARTON, VETEMENTS, METAL, PAPIER, PLASTIQUE_DUR, ORDINATEUR, DECHET, PLASTIQUE_MOU, NOURRITURE_DECHET;
    }
	
	public enum TypePoubelle {
		DECHET, BIO, VERRE, METAL, PLASTIQUE, CARTON, EWASTE;
    }
	
	public void creerDatabase() {
		try {
			List<String> DechetsStr = Files.readAllLines(pathDatabase);
		    for (String s : DechetsStr) {
		        tableau = s.split("\t");

		        switch(tableau[1]) {
		        case "BATTERIE":{
					type = TypeDechet.BATTERIE;
					break;
				}
		        case "VETEMENTS":{
					type = TypeDechet.VETEMENTS;
					break;
				}
		        case "PAPIER":{
					type = TypeDechet.PAPIER;
					break;
				}
		        case "NOURRITURE_DECHET":{
					type = TypeDechet.NOURRITURE_DECHET;
					break;
				}
				case "BIO":{
					type = TypeDechet.BIO;
					break;
				}
				case "VERRE":{
					type = TypeDechet.VERRE;
					break;
				}
				case "CARTON":{
					type = TypeDechet.CARTON;
					break;
				}
				case "PLASTIQUE_MOU":{
					type = TypeDechet.PLASTIQUE_MOU;
					break;
				}
				case "PLASTIQUE_DUR":{
					type = TypeDechet.PLASTIQUE_DUR;
					break;
				}
				case "ORDINATEUR":{
					type = TypeDechet.ORDINATEUR;
					break;
				}
				case "METAL":{
					type = TypeDechet.METAL;
					break;
				}
				case "DECHET":{
					type = TypeDechet.DECHET;
					break;
				}
				}

		        dechetsTableau.add(new Trash(tableau[0], type));
		    }

		}
		catch(IOException e) {
			System.out.println("Database pas trouvee");
	    }
	}
	
    
    
	public void ajouterPoubelles(Panel pan, int nbrPoubelles) {
		for(TypePoubelle type: TypePoubelle.values()) {
			Poubelles poubelle = new Poubelles("bin" + type.ordinal(), type);
			pan.listPoubelles.add(poubelle);
		}
	}

	public void verifierCompatibilite(Poubelles poubelle, Trash dechet) {
		TypePoubelle typePoubelle = poubelle.getId();
		TypeDechet typeDechet = dechet.getId();
		
		switch(typePoubelle) {
		case BIO:{
			if(typeDechet.equals(TypeDechet.BIO) || typeDechet.equals(TypeDechet.VETEMENTS)) {
				succes();
			}else {
				echec();
			}
		}
		case VERRE:{
			if(typeDechet.equals(TypeDechet.VERRE)) {
				succes();
			}else {
				echec();
			}
		}
		case CARTON:{
			if(typeDechet.equals(TypeDechet.CARTON) || typeDechet.equals(TypeDechet.PAPIER)) {
				succes();
			}else {
				echec();
			}
		}
		case PLASTIQUE:{
			if(typeDechet.equals(TypeDechet.PLASTIQUE_DUR) || typeDechet.equals(TypeDechet.PLASTIQUE_MOU)) {
				succes();
			}else {
				echec();
			}
		}
		case EWASTE:{
			if(typeDechet.equals(TypeDechet.BATTERIE) || typeDechet.equals(TypeDechet.ORDINATEUR)) {
				succes();
			}else {
				echec();
			}
		}
		case METAL:{
			if(typeDechet.equals(TypeDechet.METAL)) {
				succes();
			}else {
				echec();
			}
		}
		case DECHET:{
			if(typeDechet.equals(TypeDechet.DECHET) || typeDechet.equals(TypeDechet.NOURRITURE_DECHET)) {
				succes();
			}else {
				echec();
			}
		}
		}
			
	}
	
	public void succes() {
		donnees.incrementerScore(1);
		donnees.enleverDechet();
		donnees.sequence++;
		if(donnees.sequence==5) {
			donnees.setVies(donnees.getVies()+1);
		}
		if(donnees.sequence==10) {
			
		}
		if(donnees.sequence==15) {
		
		}
		if(donnees.sequence==20) {

		}
		if(donnees.sequence==25) {
		}
	}
	
	public void echec() {
		donnees.sequence=0;
		donnees.enleverVie();
		donnees.enleverDechet();
	}

	public  void ajouterTrash(Panel pan) {
		Trash trash = new Trash("trash" + nbrTrashAjouter, TypeDechet.BIO);
		pan.trashAJeter = trash;
		
		nbrTrashAjouter += 1;
		
	}
	
	public ArrayList<Trash> randomiser(){
		creerDatabase();
		ArrayList<Trash> dechetsAJeter = new ArrayList<>();
		int random = 0;
		int tailleTableau = 0;
		for(int i = 0; i < donnees.getRestants(); i++) {
			tailleTableau = dechetsTableau.size();
			Random rand = new Random();
			int randomNum = rand.nextInt((tailleTableau));
			dechetsAJeter.add(dechetsTableau.remove(randomNum));

		}
		
		return dechetsAJeter;
	}
}
