package glouton;
import java.util.Comparator;

public class ObjetV implements Comparable<ObjetV>{
	private static int numAuto = 1;
	private int num;
	private double poids;
	private double valeur;
	
	public ObjetV (double p, double v){
		setPoids(p);
		setValeur(v);
		num = numAuto++;
	}

	public int getNum() {
		return num;
	}


	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public double getValeur() {
		return valeur;
	}

	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
	
	public double getRatio(){
		return valeur/poids;
	}
	
	@Override
	public int compareTo(ObjetV o) {
		int resultat = 0;
	      if (this.getRatio() > o.getRatio())
	         resultat = -1;
	      if (this.getRatio() < o.getRatio())
	         resultat = 1;
	      if (this.getRatio() == o.getRatio())
	         resultat = 0;
	      return resultat;
	}
	
	class ObjetVComparator implements Comparator<ObjetV> {
		@Override
		public int compare(ObjetV arg0, ObjetV arg1) {
			return arg0.compareTo(arg1);
		}
	}
	
	@Override
	public String toString(){
		return "Num : " + num + " Val : " + valeur + " Poids : " + poids + " Ratio : " + getRatio();
	}
}
