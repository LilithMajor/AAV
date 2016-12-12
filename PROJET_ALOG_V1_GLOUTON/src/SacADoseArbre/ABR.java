package SacADoseArbre;

import java.util.ArrayList;

import javax.swing.tree.*;

import autre.Arbre;
import autre.Objet;

public class ABR {
	private ArrayList<ObjetV> valeur;
	private ABR sousArbreGauche;
	private ABR sousArbreDroit;
	
	public ABR(ArrayList<ObjetV> objets) {
		this.valeur = objets;
	}
	
	public ArrayList<ObjetV> getValeur(){
		return this.valeur;
	}
	
	public ABR getSousArbreGauche(){
		return this.sousArbreGauche;
	}
	
//	public void remplissage(ArrayList<ObjetV> objs, int i){
//		if (i < this.hauteur()-1){
//			sousArbreGauche.setValeur(valeur);
//			sousArbreGauche.remplissage(objs, i);
//			sousArbreDroit.setValeur(objs.get(i++));
//			sousArbreDroit.remplissage(objs, i);
//		}
//		else {
//			return;
//		}
//	}
	
	public void initialize(ArrayList<ObjetV> objets) {
		if (objets.size() > 0) {
			ArrayList<ObjetV> clone = new ArrayList<ObjetV>(this.valeur);// this.liste;
			clone.add(objets.get(0));
			this.insertion(clone);
			this.insertion(this.valeur);
	        this.sousArbreGauche.initialize(this.getNewTab(objets));
	        this.sousArbreDroit.initialize(this.getNewTab(objets));
		}
	}
	
	public ArrayList<ObjetV> getNewTab(ArrayList<ObjetV> o) {
		ArrayList<ObjetV> nouv = new ArrayList<ObjetV>();
		nouv.addAll(o);
		nouv.remove(0);
		return nouv;
	}
	
//	public ArrayList<Objet> getNewTab(ArrayList<Objet> o) {
//		ArrayList<Objet> nouv = new ArrayList<Objet>();
//		nouv.addAll(o);
//		nouv.remove(0);
//		return nouv;
//	}
	
	public ABR getSousArbreDroit(){
		return this.sousArbreDroit;
	}
	
	
	public void insertion(ArrayList<ObjetV> objets) {
		if (this.valeur.equals(objets)) {
			if (this.getSousArbreGauche() != null)
				this.getSousArbreGauche().insertion(objets);
			else
				this.sousArbreGauche = new ABR(objets);
		} else {
			if (this.getSousArbreDroit() != null)
				this.getSousArbreDroit().insertion(objets);
			else
				this.sousArbreDroit = new ABR(objets);
		}
	}
	
	public ArrayList<ObjetV> tri(double var, ArrayList<ObjetV> objets, ArrayList<ObjetV> retour, double poidsMax){
		double valeurHaute = 0;
		double valeur = 0;
		for (int i = 0; i < retour.size(); ++i)
			valeur += retour.get(i).getValeur();
		if (objets != null) {
			valeurHaute = this.getValeurObjets();
			if(!this.valeur.isEmpty()){
				for (int i = objets.size() - this.hauteur(); i < objets.size(); ++i) {
					valeurHaute += objets.get(i).getValeur();
				}
			}
			else
				valeurHaute = var;
			if (this.getValeurObjets() > valeur && this.getPoidsListe()<=poidsMax) {
				retour = this.valeur;
			}
			if (this.getValeurObjets() > var)
				var = this.getValeurObjets();
		}
		if (valeurHaute >= var) {
			if (this.sousArbreGauche != null) {
				retour = this.sousArbreGauche.tri(var, objets, retour, poidsMax);
			}
			if (this.sousArbreDroit != null) {
				retour = this.sousArbreDroit.tri(var, objets, retour, poidsMax);
			}
		}
		return retour;
	}
	
	private double getValeurObjets() {//A renommer (tu peux meme changer sa boucle for degueulasse par une for each
		double val = 0;
		for (int i = 0; i < this.valeur.size(); ++i) {
			val += valeur.get(i).getValeur();
		}
		return val;
	}
	
	public double getPoidsListe() {// idem
		double poids = 0;
		for (int i = 0; i < this.valeur.size(); ++i) {
			poids += this.valeur.get(i).getPoids();
		}
		return poids;
	}
	
	public int hauteur(){
		//
		if (this.valeur == null|| this.sousArbreDroit==null) {
			return 0;
		} else {
			return Math.max(this.sousArbreDroit.hauteur(), this.sousArbreGauche.hauteur()) + 1;
		}
	}
	
	public boolean estEquilibre(){
		if (this.valeur == null){
			return true;
		}
		else{
			return (Math.abs(sousArbreGauche.hauteur() - sousArbreDroit.hauteur()) <= 1 && sousArbreGauche.estEquilibre()
					&& sousArbreDroit.estEquilibre());
		}
	}
	
	/*public void rotationDroite(){
		float tv = getValeur();
		setValeur(sousArbreGauche.getValeur());
		sousArbreGauche.setValeur(tv);
		ABR ta = this.sousArbreGauche;
		sousArbreGauche = this.sousArbreGauche.sousArbreGauche;
		ta.sousArbreGauche = ta.sousArbreDroit;
		ta.sousArbreDroit = sousArbreDroit;
		sousArbreDroit = ta;
	}*/
	
	/*public void rotationGauche(){
		float tv = getValeur();
		setValeur(sousArbreDroit.getValeur());
		sousArbreDroit.setValeur(tv);
		ABR ta = this.sousArbreDroit;
		sousArbreDroit = this.sousArbreDroit.sousArbreDroit;
		ta.sousArbreDroit = ta.sousArbreGauche;
		ta.sousArbreGauche = sousArbreGauche;
		sousArbreGauche = ta;
	}*/

//	public void setValeur(ObjetV v) {
//		this.valeur = v;
//	}

	public String toString(){
		return this.toString("\t");
	}
	
	public String toString(String s){
		if (this.sousArbreGauche != null){
			if (this.sousArbreDroit != null){
				return (s+valeur+"\n"+this.sousArbreGauche.toString(s+"\t") + this.sousArbreDroit.toString(s+"\t"));
			}
			else {
				return (s+valeur+"\n"+sousArbreGauche.toString(s+"\t")+"\n");
			}
		}
		else {
			if (sousArbreDroit!=null){
				return (s+valeur+"\n"+sousArbreDroit.toString(s+"\t")+"\n");
			}
			else {
				return(s+valeur+"\n");
			}
		}
	}
	
	/*public void ajouterEq(float v){
		if(this.valeur == null){
			this.valeur = v;
			this.sousArbreGauche = new ABR();
			this.sousArbreDroit = new ABR();
		}
		else {
			if(v < this.valeur){
				this.sousArbreGauche.ajouterEq(v);
				if (!(estEquilibre())){
					if((sousArbreGauche.sousArbreGauche==null) || (sousArbreGauche.sousArbreGauche.hauteur() < sousArbreGauche.sousArbreDroit.hauteur())){
						sousArbreGauche.rotationGauche();
					}
					rotationDroite();
				}
			}
			else {
				this.sousArbreDroit.ajouterEq(v);
				if(!(estEquilibre())){
					if((sousArbreDroit.sousArbreDroit==null) || (sousArbreDroit.sousArbreDroit.hauteur() < sousArbreDroit.sousArbreGauche.hauteur())){
					sousArbreDroit.rotationDroite();
					}
					rotationGauche();
				}
			}
		}
	}*/
}
