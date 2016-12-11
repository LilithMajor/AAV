package progDynamique;
import java.util.ArrayList;
import java.util.Collections;

public class Trieur {

	private ArrayList<ObjetV> objets;
	private SacADos sac;
	private static final int nbrObjs = 4;
	
	public Trieur(ArrayList<ObjetV> obj, SacADos sac){
		objets = obj;
		this.sac = sac;
	}
	
	public ArrayList<ObjetV> tri(){
		int maxContenance = (int) (sac.getPoidsMax());
		double[][] matrice = new double[nbrObjs][maxContenance + 1];
		for(int j = 0; j < maxContenance; j++){
			if(sac.getObjets().get(0).getPoids() > j)
				matrice[0][j] = 0;
			else
				matrice[0][j] = sac.getObjets().get(0).getValeur();
		}
		for(int i = 1; i < maxContenance; i++){
			for(int j = 0; j < maxContenance; j++){
				if(sac.getObjets().get(i).getPoids() > j)
					matrice[i][j] = matrice[i-1][j];
				else
					matrice[i][j] = Math.max(matrice[i-1][j], matrice[i-1][(int) (j-sac.getObjets().get(i).getPoids())] + sac.getObjets().get(i).getValeur());
			}
		}
		int i = nbrObjs;
		int j = maxContenance;
		while(matrice[i][j] == matrice[i][j - 1]){
			j--;
		}
		while(j>0){
			while(i > 0 && matrice[i][j] == matrice[i - 1][j]){
				i--;
			}
			j = (int) (j - sac.getObjets().get(i).getPoids());
			if(j > 0)
				objets.add(sac.getObjets().get(i));
			i--;
		}
//Bon en gros j'ai traduit l'algo d'OC en java inchallah ça marche du premier coup
//		Collections.sort(objets);
		return objets;
	}
	

	public void remplissage(){
//		for(ObjetV o : objets){
//			if (sac.getPoids() + o.getPoids() <= sac.getPoidsMax()){
//				sac.ajouterObjets(o);
//			}
//			else{
//				System.out.println("Plus de place");
//				break;
//			}
//		}
	}
	
	public ArrayList<ObjetV> getObjets(){
		return objets;
	}
	
	public SacADos getSac(){
		return sac;
	}
}
