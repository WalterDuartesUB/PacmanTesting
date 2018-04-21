package ar.edu.ub.testing.consola.menu.exception;

public class ConsolaMenuItemDescripcionInvalidaException extends ConsolaMenuItemException
{
	private static final long serialVersionUID = 1L;

	public ConsolaMenuItemDescripcionInvalidaException()
	{
		super( "No se puede crear un item con descripcion que sea vacio o null." );
	}

}
