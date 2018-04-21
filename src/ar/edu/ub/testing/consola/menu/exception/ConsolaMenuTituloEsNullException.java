package ar.edu.ub.testing.consola.menu.exception;

public class ConsolaMenuTituloEsNullException extends ConsolaMenuException
{

	private static final long serialVersionUID = 1L;

	public ConsolaMenuTituloEsNullException()
	{
		super("El menuTitulo no puede ser null(pero puede ser vacio).");
	}

}
