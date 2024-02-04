package application;

import java.util.ArrayList;

import objets.Poubelles;
import objets.Trash;

public class Systems {
	public static int nbrTrashAjouter = 0;
	
	public static void ajouterPoubelles(Panel pan, int nbrPoubelles) {
		for (int i = 0; i < nbrPoubelles; i++) {
			Poubelles poubelle = new Poubelles("poubelle" + i, i);
			pan.listPoubelles.add(poubelle);
		}
	}

	public static void ajouterTrash(Panel pan) {
		Trash trash = new Trash("trash" + nbrTrashAjouter, 0);
		pan.trashAJeter = trash;
		
		nbrTrashAjouter += 1;
		
	}
}
