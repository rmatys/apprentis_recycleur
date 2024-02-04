package application;

import java.util.ArrayList;

import objets.Poubelles;

public class System {
	static ArrayList<Poubelles> listPoubelles = new ArrayList<Poubelles>();
	
	public static void ajouterPoubelles(Panel pan, int nbrPoubelles) {
		for (int i = 0; i < nbrPoubelles; i++) {
			Poubelles poubelle = new Poubelles("poubelle" + i, i);
			listPoubelles.add(poubelle);
		}
	}
}
