package progDynamique;
import java.util.ArrayList;
import java.util.Collections;

public class Trieur {

	private ArrayList<ObjetV> objets;
	private SacADos sac;
	
	public Trieur(ArrayList<ObjetV> obj, SacADos sac){
		objets = obj;
		this.sac = sac;
	}
	
	public ArrayList<ObjetV> tri(){
//		Collections.sort(objets);
		return objets;
	}
	
	public void remplissage(){
		int[lol;
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
