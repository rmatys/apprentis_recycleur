package application;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Cette classe contient des utilitaires pour le 
 * traitement des images. Elle sera enrichie au fil de la session.
 * Notez les m�thodes permettant de redimensionner une image.
 * 
 * @author Caroline Houle
 * @author Matys
 */
public class OutilsImage {

	/**
	 * Lit le fichier d'image donne en parametre et retourne
	 * un objet Image correspondant
	 * 
	 * @param nomFichier Le nom du fichier d'image
	 * @return Un objet Image pour cette image
	 */
	// Caroline Houle
	public static Image lireImage(String nomFichier) {
		Image img = null;
		URL urlFichier = OutilsImage.class.getClassLoader().getResource(nomFichier);
		if (urlFichier == null) {
			System.out.println("Fichier d'image introuvable: " + nomFichier);
		} 
		else {
			try {
				img = ImageIO.read(urlFichier);
			} 
			catch (IOException e) {
				System.out.println("Erreur de lecture du fichier d'image: " + nomFichier);
			}
		}
		return(img);
	}//fin methode
	
	/**
	 * Cherche et lit tous les fichiers .jpg dans le fichier source
	 * @return une liste de toutes les images
	 */
	// Matys
	public static HashMap<String, Image> lireImagesResources() {
		String[] nomsObjectsJPG = {"gazon_mc.jpg","beton.jpg","marble_stone.jpg","texture_gazon.jpg"};
		
		HashMap<String, Image> images = new HashMap<String, Image>();
		for (String nom : nomsObjectsJPG) {
			images.put(nom, lireImage(nom));
		}
		return images;
	}
	
	/**
	 * Lit le fichier d'image donne en parametre, redimensionne
	 * l'image en appliquant le meme facteur de redimensionnement en largeur et en hauteur
	 * (ce qui �vite toute distortion dans l'image).  
 	 *
	 * Retourne un objet Image correspondant.
	 *
	 * Voir aussi la deuxieme signature de cette methode, 
	 * qui permet de specifier des resolutions precises en largeur et hauteur. 
	 * 
	 * @param nomFichier Le nom du fichier d'image
	 * @param facteurZoom Facteur de redimensionnement (1 signifie ne rien changer)
	 * @return Un objet Image pour cette image redimensionnee
	 */
	// Caroline Houle
	public static Image lireImageEtRedimensionner(String nomFichier, double facteurZoom) {
		Image img = null;
		Image imgRedim = null;
		
		img = lireImage(nomFichier);
		if (img != null ) {
			imgRedim = img.getScaledInstance((int)(facteurZoom*img.getWidth(null)), 
					                         (int)(facteurZoom*img.getHeight(null)), 
					                          Image.SCALE_SMOOTH);
		}
		return( imgRedim );
	}//fin methode
	
	/**
	 * Lit le fichier d'image donne en parametre, redimensionne
	 * l'image a la nouvelles resolution desiree. 
	 *
	 * Retourne un objet Image correspondant
	 *
	 * Attention : si resoX et resoY ne sont pas proportionnels aux dimensions initiales de
	 * l'image, cela introduit une distortion (semblera plus etiree dans une direction)
	 * Voir aussi la deuxieme signature de cette methode qui permet plutot de donner un facteur de redimensionnement.
	 * 
	 * @param nomFichier Le nom du fichier d'image
	 * @param resoX Nouvelle largeur en pixels
	 * @param resoY Nouvelle hauteur en pixels
	 * @return Un objet Image pour cette image redimensionnee
	 */
	// Caroline Houle
	public static Image lireImageEtRedimensionner(String nomFichier, int resoX, int resoY) {
		Image img = null;
		Image imgRedim = null;
		
		img = lireImage(nomFichier);
		if (img != null ) {
			imgRedim = img.getScaledInstance(resoX, resoY, Image.SCALE_SMOOTH);
		}
		return( imgRedim );
	}//fin methode

	
	/**
	 * Associe une image a un bouton en redimensionnant l'image adequatement.
	 * @param nomFichier Le nom du fichier d'image
	 * @param leBouton Le bouton auquel on veut associer l'image.
	 */
	// Caroline Houle
	public static void lireImageEtPlacerSurBouton( String nomFichier, JButton leBouton ) {
		Image imgRedim=null;

		//lire et redimensionner l'image de la meme grandeur que le bouton
		imgRedim = lireImageEtRedimensionner(nomFichier, leBouton.getWidth(),  leBouton.getHeight() );

		if (imgRedim != null) {
			//au cas ou le fond de l�image serait transparent
			leBouton.setOpaque(false);
			leBouton.setContentAreaFilled(false);
			leBouton.setBorderPainted(false);

			//associer l'image au bouton
			leBouton.setText("");
			leBouton.setIcon( new ImageIcon(imgRedim) );

			//on se debarrasse de l'image de base
			imgRedim.flush();
		}
	}//fin methode

}
