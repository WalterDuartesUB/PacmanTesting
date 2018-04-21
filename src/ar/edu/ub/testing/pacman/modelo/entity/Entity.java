package ar.edu.ub.testing.pacman.modelo.entity;

public abstract class Entity
{
	private Posicion	posicion;

	public Posicion getPosicion()
	{
		return posicion;
	}

	protected void setPosicion(Posicion posicion)
	{
		this.posicion = posicion;
	}
	
	public boolean estaEnLaMismaPosicionQue( Entity otraEntity )
	{
		return this.getPosicion().sonIguales( otraEntity.getPosicion() );
	}
	
	public boolean estaEnLaMismaPosicionQue( Entity[] otrasEntity )
	{
		for( Entity otraEntity : otrasEntity )
			if( this.getPosicion().sonIguales( otraEntity.getPosicion() ) )
				return true;
		
		return false;
	}
	
	public abstract String getDibujo();	
}
