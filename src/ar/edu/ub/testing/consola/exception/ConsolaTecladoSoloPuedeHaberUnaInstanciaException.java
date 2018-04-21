package ar.edu.ub.testing.consola.exception;

public class ConsolaTecladoSoloPuedeHaberUnaInstanciaException extends ConsolaException
{
	private static final long serialVersionUID = 1L;

	public ConsolaTecladoSoloPuedeHaberUnaInstanciaException()
	{
		super("Solo puede haber una instancia de Consola por ejecución.");
	}
}
