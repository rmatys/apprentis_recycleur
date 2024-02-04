package application;

import java.util.ArrayList;

import objets.Poubelles;

public class System {
	
	public static void ajouterPoubelles(Panel pan, int nbrPoubelles) {
		for (int i = 0; i < nbrPoubelles; i++) {
			Poubelles poubelle = new Poubelles("poubelle" + i, i);
			pan.listPoubelles.add(poubelle);
		}
	}
}
