package SacADoseArbre;

public class BTreeCA {
	protected Integer value ; // la valeur contenue a la racine si l’arbre est non vide
	protected BTreeCA leftTree ; // le sous - arbre gauche eventuel si l’arbre est non vide
	protected BTreeCA rightTree ; // le sous - arbre droit eventuel si l’arbre est non vide

	public BTreeCA (){
		/* constructeur d’arbre vide */
	}

	public BTreeCA ( int v){
		/* constructeur d’arbre contenant uniquement une racine */
		this . value = new Integer (v);
		this . leftTree = new BTreeCA ();
		this . rightTree = new BTreeCA ();
	}

	public BTreeCA ( int v, BTreeCA aLeftTree , BTreeCA aRightTree ){
		/* constructeur d’arbre par enracinement de deux sous - arbre sur une valeur racine */
		this . value = new Integer (v);
		this . leftTree = aLeftTree ;
		this . rightTree = aRightTree ;
	}

	public boolean isEmpty (){
		/* accesseur : renvoie vrai si l’arbre ne contient aucun element */
		return ( this . value == null );
	}

	public BTreeCA getRoot () throws Exception {
		/* accesseur : renvoie la racine de l’arbre */
		if ( this . isEmpty ()){
			throw new Exception (" Arbre vide : acces a la racine impossible ");
		}
		return this ;
	}

	public int getValue () throws Exception {
		/* accesseur : renvoie la valeur contenue a la racine de l’arbre */
		if ( this . isEmpty ()){
			throw new Exception (" Arbre vide : acces a la racine impossible ");
		}
		return this . value ;
	}

	public BTreeCA getLeftTree () throws Exception {
		/* accesseur : renvoie le sous - arbre gauche de l’arbre */
		if ( this . isEmpty ()){
			throw new Exception (" Arbre vide : acces au sous - arbre gauche impossible ");
		}
		return this . leftTree ;
	}
	
	public BTreeCA getRightTree () throws Exception {
		/* accesseur : renvoie le sous - arbre droit de l’arbre */
		if ( this . isEmpty ()){
			throw new Exception (" Arbre vide : acces au sous - arbre droit impossible ");
		}
		return this . rightTree ;
	}
	
	public BTreeCA getLeftValue () throws Exception {
		/* accesseur : renvoie la valeur de la racine du sous - arbre gauche */
		return this . getLeftTree (). getRoot ();
	}
	
	public int getRightValue () throws Exception {
		/* accesseur : renvoie la valeur de la racine du sous - arbre droit */
		return this . getRightTree (). getValue ();
	}
	
	public void setLeftTree ( BTreeCA aLeftTree ) throws Exception {
		/* modificateur : ajoute un sous - arbre gauche a la racine de l’arbre (si libre ) */
		if ( this . isEmpty ()){
			throw new Exception (" Arbre vide : ajout de sous - arbre gauche impossible ");
		}
		if ( this . leftTree != null ){
			throw new Exception ("Sous - arbre gauche deja existant ");
		}
		if ( aLeftTree == null ){
			throw new Exception (" Tentative d’ajout d’un sous - arbre non construit ");
		}
		this . leftTree = ( BTreeCA ) aLeftTree ;
	}
	
	public void setRightTree ( BTreeCA aRightTree ) throws Exception {
		/* modificateur : ajoute un sous - arbre gauche a la racine de l’arbre (si libre ) */
		if ( this . isEmpty ()){
			throw new Exception (" Arbre vide : ajout de sous - arbre gauche impossible ");
		}
		if ( this . rightTree != null ){
			throw new Exception ("Sous - arbre gauche deja existant ");
		}
		if ( aRightTree == null ){
			throw new Exception (" Tentative d’ajout d’un sous - arbre non construit ");
		}
		this . rightTree = ( BTreeCA ) aRightTree ;
	}
	
	public void setLeftValue ( int leftSubRoot ) throws Exception {
		/* modificateur : ajoute une valeur en fils gauche de la racine (si libre ) */
		this . setLeftTree ( new BTreeCA ( leftSubRoot ));
	}
	
	public void setRightValue (int rightSubRoot ) throws Exception {
		/* modificateur : ajoute une valeur en fils droit de la racine (si libre ) */
		this . setRightTree ( new BTreeCA ( rightSubRoot ));
	}
	
	public static void main ( String [] args ){
		/* tests unitaires */
		return ;
	}
}