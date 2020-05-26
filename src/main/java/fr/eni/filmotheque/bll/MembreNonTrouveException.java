package fr.eni.filmotheque.bll;

public class MembreNonTrouveException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -841669748695400068L;

	public MembreNonTrouveException() {
		super("Le compte n'existe pas");
	}

}
