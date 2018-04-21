package ar.edu.ub.testing.consola.menu.exception;

public class ConsolaMenuItemsInvalidosException extends ConsolaMenuException
{

	private static final long serialVersionUID = 1L;

	public ConsolaMenuItemsInvalidosException()
	{
		super("El array de ConsolaMenuItem no pueden ser null, tener tamaño cero, tener items null, ni pueden estar repetidas las opciones de consola.");
	}

}
