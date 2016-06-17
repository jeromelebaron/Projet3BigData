package fr.s2re.bigdata.test.business;

import fr.s2re.bigdata.business.CategorieBusiness;
import fr.s2re.bigdata.entity.Categorie;

public class CategorieBusinessTest {
	public static void main(String[] args) {
		
		/*for (int localI = 0; localI < 50; localI++) {
        Client client = ClientBusiness.getClient();
        System.out.println(client.getId());
	}*/
	for (int localI = 0; localI < 50; localI++) {
		Categorie cat = CategorieBusiness.getCategorie();
		System.out.println(cat.getId());
	}
		
	}

}
