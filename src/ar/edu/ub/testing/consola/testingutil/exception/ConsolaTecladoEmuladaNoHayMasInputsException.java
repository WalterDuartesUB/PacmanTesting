package ar.edu.ub.testing.consola.testingutil.exception;

public class ConsolaTecladoEmuladaNoHayMasInputsException extends ConsolaTecladoEmuladaException
{
	private static final long serialVersionUID = 1L;

	public ConsolaTecladoEmuladaNoHayMasInputsException()
	{
		super( "No hay más inputs emulados para nextLine" );
	}

}
