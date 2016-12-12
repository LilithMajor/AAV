import java.util.ArrayList;

public class Arbre {
	private ArrayList<Objet> liste;
	private Arbre sousArbreGauche = null;
	private Arbre sousArbreDroit = null;

	public Arbre() {
	}

	public Arbre(ArrayList<Objet> liste) {
		this.liste = liste;
	}

	public Arbre(ArrayList<Objet> liste, Arbre l, Arbre r) {
		this.liste = liste;
		sousArbreGauche = l;
		sousArbreDroit = r;
	}

	public ArrayList<Objet> getListe() {
		return this.liste;
	}

	public Arbre getSousArbreGauche() {
		return this.sousArbreGauche;
	}

	public Arbre getSousArbreDroit() {
		return this.sousArbreDroit;
	}
	/*
	 * public void init(ArrayList<Objet> o, ArrayList<Objet> l, int compteur) {
	 * if (compteur < o.size()) { boolean present = false; if (compteur < 0)
	 * present = true; if (!present) for (int i = 0; i < l.size(); ++i) if
	 * (l.get(i) == o.get(compteur)) present = true; if (present) this.liste =
	 * l; else { l.add(o.get(compteur)); this.insertion(l); }
	 * this.sousArbreDroit.init(o, l, compteur + 1);
	 * this.sousArbreGauche.init(o, l, compteur); } }
	 */

	public void insertion(ArrayList<Objet> l) {
		if (this.liste.equals(l)) {
			if (this.getSousArbreGauche() != null)
				this.getSousArbreGauche().insertion(l);
			else
				this.sousArbreGauche = new Arbre(l);
		} else {
			if (this.getSousArbreDroit() != null)
				this.getSousArbreDroit().insertion(l);
			else
				this.sousArbreDroit = new Arbre(l);
		}
	}

	public void init2(ArrayList<Objet> o, ArrayList<Objet> l, int compteur) {
		if (compteur < o.size()) {
			this.insertion(l);
			System.out.println(l.equals(this.getListe()));
			System.out.println(o.get(compteur).toString() + " " + compteur);
			l.add(o.get(compteur));
			this.insertion(l);
			compteur++;
			this.sousArbreGauche.init2(o, this.sousArbreGauche.liste, compteur);
			// compteur = compteur - o.size();
			// System.out.println(compteur);
			this.sousArbreDroit.init2(o, this.sousArbreDroit.liste, compteur);
			compteur--;
		}
	}

	public void init(ArrayList<Objet> o) {
		if (o.size() > 0) {
			// System.out.println(o.size());
			ArrayList<Objet> nouveau = new ArrayList<Objet>(this.liste);// this.liste;
			nouveau.add(o.get(0));
			this.insertion(nouveau);
			this.insertion(this.liste);
			// o.remove(0);
			// compteur++;
			// if (o.size() > 0
			/*
			 * && this.sousArbreDroit!=null && this.sousArbreGauche!=null
			 */// ) {
			this.sousArbreGauche.init(this.getNewTab(o));
			this.sousArbreDroit.init(this.getNewTab(o));
			// System.out.println("ok");
			// }
		}
	}
/*
	public void initAvance(ArrayList<Objet> o) {
		// System.out.println(this.getPoidsListe());
		// System.out.println(this.surcharge(new Sac()));
		// System.out.println(o.get(0).getPoids());
		if (o.size() > 0 && !this.surcharge(new Sac())) {
			// System.out.println(o.size());
			ArrayList<Objet> nouveau = new ArrayList<Objet>(this.liste);// this.liste;
			nouveau.add(o.get(0));
			this.insertion(nouveau);
			this.insertion(this.liste);
			// o.remove(0);
			// compteur++;
			// if (o.size() > 0
			
			 //&& this.sousArbreDroit!=null && this.sousArbreGauche!=null
			 ) {
			this.sousArbreGauche.initAvance(this.getNewTab(o));
			this.sousArbreDroit.initAvance(this.getNewTab(o));
			// System.out.println("ok");
			// }
		}
	}*/

	public float getPoidsListe() {
		float poids = 0;
		for (int i = 0; i < this.liste.size(); ++i) {
			poids += this.liste.get(i).getPoids();
		}
		return poids;
	}

	public boolean surcharge(Sac sac) {
		return this.getPoidsListe() > sac.getPoidsMax();
	}

	public int nombreElement() {
		int nombre = 0;
		if (this.liste != null) {
			nombre += 1;
			if (this.getSousArbreDroit() != null)
				nombre += this.getSousArbreDroit().nombreElement();
			if (this.getSousArbreGauche() != null)
				nombre += this.getSousArbreGauche().nombreElement();
		}
		return nombre;
	}

	public ArrayList<Objet> getSolution(float inf, ArrayList<Objet> o, ArrayList<Objet> rep, float poidsMax) {
		float borneSup = 0;
		float val = 0;
		for (int i = 0; i < rep.size(); ++i)
			val += rep.get(i).getValeur();
		if (liste != null) {
			borneSup = this.getValeur();
			if(!this.liste.isEmpty()){
				for (int i = o.size()-this.hauteur(); i < o.size(); ++i) {
					borneSup += o.get(i).getValeur();
				}
			}
			else
				borneSup=inf;
			if (this.getValeur() > val && this.getPoidsListe()<=poidsMax) {
				rep = this.liste;
			}
			if (this.getValeur() > inf)
				inf = this.getValeur();
		}
		if (borneSup >= inf) {
			if (this.sousArbreGauche != null) {
				rep = this.sousArbreGauche.getSolution(inf, o, rep, poidsMax);
			}
			if (this.sousArbreDroit != null) {
				rep = this.sousArbreDroit.getSolution(inf, o, rep, poidsMax);
			}
		}
		return rep;
	}

	private float getValeur() {
		float val = 0;
		for (int i = 0; i < this.liste.size(); ++i) {
			val += liste.get(i).getValeur();
		}
		return val;
	}

	public int hauteur() {
		if (this.liste == null|| this.sousArbreDroit==null) {
			return 0;
		} else {
			return Math.max(this.sousArbreDroit.hauteur(), this.sousArbreGauche.hauteur()) + 1;
		}
	}

	public ArrayList<Objet> getNewTab(ArrayList<Objet> o) {
		ArrayList<Objet> nouv = new ArrayList<Objet>();
		nouv.addAll(o);
		nouv.remove(0);
		return nouv;
	}
}
