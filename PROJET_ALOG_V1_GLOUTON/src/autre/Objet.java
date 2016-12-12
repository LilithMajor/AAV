package autre;
public class Objet implements Comparable<Objet>{
	String nom;
	float valeur;
	float poids;
	float ratio;
	
	public Objet(String nom, float poids, float valeur){
		this.nom = nom;
		this.valeur = valeur;
		this.poids = poids;
		this.calculerRatio();
	}

	private float calculerRatio() {//void
		return valeur / poids;
	}

	public String getNom() {
		return this.nom;
	}

	@Override
	public int compareTo(Objet o) {
		if (this.calculerRatio() < o.calculerRatio())
			return -1;
		else
			if (this.calculerRatio() == o.calculerRatio())
				return 0;
		return 1;
	}
	
	public String toString(){
		return this.nom + ", " + this.poids +  ", " + this.valeur + ", " + this.ratio;
	}

	public float getPoids() {
		return this.poids;
	}
	
	public float getValeur() {
		return this.valeur;
	}
}
