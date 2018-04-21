package ar.edu.ub.testing.consola.testingutil.exception;

public class ConsolaTecladoEmuladaNoHayInputsException extends ConsolaTecladoEmuladaException
{

	private static final long serialVersionUID = 1L;

	public ConsolaTecladoEmuladaNoHayInputsException()
	{
		super("La lista de inputs no puede ser null y tiene que tener tamaño mayor a 0");
	}

}
