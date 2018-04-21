package ar.edu.ub.testing.consola.testingutil;

import ar.edu.ub.testing.consola.Consola;
import ar.edu.ub.testing.consola.testingutil.exception.ConsolaTecladoEmuladaNoHayInputsException;
import ar.edu.ub.testing.consola.testingutil.exception.ConsolaTecladoEmuladaNoHayMasInputsException;

public class ConsolaTecladoEmulada extends Consola
{
	private String[] inputsEmulados;
	private Integer posicionInputEmulado;
	
	public ConsolaTecladoEmulada( String[] inputsEmulados )
	{
		if( !this.validarInputsEmulados ( inputsEmulados ) )
			throw new ConsolaTecladoEmuladaNoHayInputsException();
		
		this.setInputsEmulados(inputsEmulados);
		this.setPosicionInputEmulado( 0 );
	}

	private boolean validarInputsEmulados( String[] inputsEmulados )
	{
		if( inputsEmulados == null || inputsEmulados.length == 0 )
			return false;
		
		for( int posicion = 0; posicion < inputsEmulados.length; posicion++ )
		{
			if( inputsEmulados[posicion] == null )
				return false;
		}
		
		return true;
	}

	@Override
	public void limpiarPantalla()
	{
	}

	@Override
	public String nextLine()
	{
		
		if( this.getPosicionInputEmulado() == inputsEmulados.length )
			throw new ConsolaTecladoEmuladaNoHayMasInputsException();
		
		String inputEmulado = this.getInputsEmulados()[ this.getPosicionInputEmulado() ];
		
		this.setPosicionInputEmulado( this.getPosicionInputEmulado() + 1 );
		
		return inputEmulado;
	}

	@Override
	public void print(String s)
	{
	}

	@Override
	public void println()
	{
	}

	@Override
	public void println(String s)
	{
	}

	@Override
	public void finalizar()
	{
	}

	private String[] getInputsEmulados()
	{
		return inputsEmulados;
	}

	private void setInputsEmulados(String[] inputsEmulados)
	{
		this.inputsEmulados = inputsEmulados;
	}

	private Integer getPosicionInputEmulado()
	{
		return posicionInputEmulado;
	}

	private void setPosicionInputEmulado(Integer posicionInputEmulado)
	{
		this.posicionInputEmulado = posicionInputEmulado;
	}

}
