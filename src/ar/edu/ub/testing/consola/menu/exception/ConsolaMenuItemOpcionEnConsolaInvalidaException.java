package ar.edu.ub.testing.consola.menu.exception;

public class ConsolaMenuItemOpcionEnConsolaInvalidaException extends ConsolaMenuItemException
{

	private static final long serialVersionUID = 1L;

	public ConsolaMenuItemOpcionEnConsolaInvalidaException()
	{
		super( "No se puede crear un item con opcion para la consola que sea vacio o null." );
	}

}
