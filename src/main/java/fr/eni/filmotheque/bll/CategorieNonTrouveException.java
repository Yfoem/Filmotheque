package fr.eni.filmotheque.bll;

public class CategorieNonTrouveException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -841669748695400068L;

	public CategorieNonTrouveException() {
		super("la catégorie n'existe pas");
	}

}
