
public class NotaForaDoRangeException extends Exception{

	/**
	 * Excecao para quando a nota passada for fora do range de 0-10
	 */
	private static final long serialVersionUID = -1260182221743659163L;
	
	public NotaForaDoRangeException (String s) {
		super (s);
	}
	
	
}
