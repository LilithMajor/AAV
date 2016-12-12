package SacADoseArbre;
import java.util.ArrayList;
import java.util.Collections;

import SacADoseArbre.ObjetV;
import autre.Arbre;
import autre.Objet;

public class Trieur {
	private ArrayList<ObjetV> objets;
	private SacADos sac;
	
	public Trieur(ArrayList<ObjetV> obj, SacADos sac){
		objets = obj;
		this.sac = sac;
	}
	
	public ArrayList<ObjetV> tri(){
		double valeurMax = 11;
		ABR arbreTri = new ABR(new ArrayList<ObjetV>());//Logique
		arbreTri.initialize(objets);
		ArrayList<ObjetV> retour = new ArrayList<ObjetV>();
		System.out.println(arbreTri.tri(valeurMax, objets, retour, sac.getPoidsMax()));
		return arbreTri.tri(valeurMax, objets, retour, sac.getPoidsMax());
	}
	
	
	public ArrayList<ObjetV> getObjets(){
		return objets;
	}
	
	public SacADos getSac(){
		return sac;
	}
}
