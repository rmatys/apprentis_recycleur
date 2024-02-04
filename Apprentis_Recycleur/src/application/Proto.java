package application;

import objets.Poubelles;
import objets.Trash;

public class Proto {

	public static void main(String[] args) {
		Poubelles recyclage = new Poubelles("recyclage", Systems.TypePoubelle.BIO);
		Trash trash001 = new Trash("trash001", Systems.TypeDechet.BIO);

	}

}
