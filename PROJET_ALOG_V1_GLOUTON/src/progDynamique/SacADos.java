package progDynamique;
import java.util.ArrayList;

public class SacADos {
	private ArrayList<ObjetV> objets = new ArrayList<ObjetV>();
	private double poids = 0;
	private double poidsMax;
	
	public SacADos(double poidsmax){
		this.poidsMax = poidsmax;
	}
	
	public void ajouterObjets(ObjetV obj){
		objets.add(obj);
		poids = poids + obj.getPoids();
	}
	
	public double getPoids(){
		return poids;
	}
	
	public double getPoidsMax(){
		return poidsMax;
	}
	
	public ArrayList<ObjetV> getObjets(){
		return objets;
	}
}

