import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Application {
/*
	// public static void lire() {
	public static void lire(ArrayList<Objet> listeItem) {
		try {
			File f = new File("items.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			try {
				String line = br.readLine();

				while (br.readLine() != null) {
					line = br.readLine();
					listeItem.add(new Objet(decoupe[0], Float.parseFloat(decoupe[1]), Float.parseFloat(decoupe[2])));

				}
				String[] decoupe = line.split(";");
				listeItem.add(new Objet(decoupe[0], Float.parseFloat(decoupe[1]), Float.parseFloat(decoupe[2])));
				br.close();
				fr.close();
			} catch (IOException exception) {
				System.out.println("Erreur lors de la lecture : " + exception.getMessage());
			}
		} catch (FileNotFoundException exception) {
			System.out.println("Le fichier n'a pas été trouvé");
		}
	}*/
	public static void main(String[] args) {
		long debut, fin;
		Sac sac = new Sac();
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrer le nom du fichier de la liste d'objets :");
		String liste = sc.next();
		//sac.init("items.txt");
		sac.init(liste);
		System.out.println("Entrer le poids maximal du sac :");
		float poidsMax = sc.nextFloat();
		sac.setPoidsMax(poidsMax);
		System.out.println("Comment voulez vous résoudre le probleme ?");
		System.out.println("gloutonne/dynamique/pse");
		String methode = sc.next();
		methode = methode.toLowerCase();
		methode = methode.trim();
		switch (methode) {
		case "gloutonne":
			System.out.println("Résolution par méthode gloutonne");
			debut = System.currentTimeMillis();
			float res = sac.methodeGloutone();
			fin = System.currentTimeMillis();
			System.out.println("la valeur du sac est : " + res);
			System.out.println("temps d'exécution : " + (fin - debut) + "ms");
			break;
		case "dynamique":
			System.out.println("Résolution par méthode dynamique");
			debut = System.currentTimeMillis();
			res = sac.methodeDynamique();
			fin = System.currentTimeMillis();
			System.out.println("la valeur du sac est : " + res);
			System.out.println("temps d'exécution : " + (fin - debut) + "ms");
			break;
		case "pse":
			debut = System.currentTimeMillis();
			res = sac.methodePSE();
			fin = System.currentTimeMillis();
			System.out.println("temps d'exécution : " + (fin - debut) + "ms");
			break;
		default:
			System.out.println("Methode inexistante");
		}
		/*
		Arbre test = new Arbre(new ArrayList<Objet>());
		ArrayList<Objet> nouveau = sac.getListeObjetPossible();
		// nouveau.add(sac.getListeObjetPossible().get(0));
		System.out.println(nouveau);
		test.init(nouveau);
		System.out.println("nombre d'element dans l'arbre : " + test.nombreElement());
		float inf = 0;
		ArrayList<Objet> res = new ArrayList<Objet>();
		res = test.getSolution(inf, sac.getListeObjetPossible(), res);
		float val = 0;
		for (int i = 0; i < res.size(); ++i) {
			val += res.get(i).getValeur();
		}
		System.out.println(val);*/
	}
}
