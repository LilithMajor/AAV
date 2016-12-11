package SacADoseArbre;
import java.util.ArrayList;
import java.util.Collections;

import SacADoseArbre.ObjetV;

public class Trieur {
	private ABR arbe;
	private ArrayList<ObjetV> objets;
	private SacADos sac;
	
	public Trieur(ArrayList<ObjetV> obj, SacADos sac){
		arbe = new ABR(obj.size(), new ObjetV(0,0));
		objets = obj;
		this.sac = sac;
	}
	
	public ABR getArbe() {
		return arbe;
	}

	public void setArbe(ABR arbe) {
		this.arbe = arbe;
	}
	
	public ArrayList<ObjetV> tri(){
		Collections.sort(objets);
		return objets;
	}
	
	public void remplissage(){
		arbe.remplissage(objets, 0);
	}
	
	public ArrayList<ObjetV> getObjets(){
		return objets;
	}
	
	public SacADos getSac(){
		return sac;
	}
}
