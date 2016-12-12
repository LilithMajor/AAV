package SacADoseArbre;
import java.util.ArrayList;

import javax.swing.SingleSelectionModel;

import org.junit.Test;

import SacADoseArbre.ObjetV;

public class TestGlouton {

	@Test
	public void test() {
		SacADos sac = new SacADos(30);
		ArrayList<ObjetV> liste = new ArrayList<ObjetV>();
		liste.add(new ObjetV(13, 7));
		liste.add(new ObjetV(12, 4));
		liste.add(new ObjetV(8, 3));
		liste.add(new ObjetV(10, 3));
		Trieur tri1 = new Trieur(liste, sac);
		sac.setObjets(tri1.tri());
		System.out.println(tri1.getObjets());
		System.out.println(tri1.getSac().getObjets());
		
	}

}
