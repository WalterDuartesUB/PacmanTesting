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
	
	/**
	 * Cada entidad debe saber quien gana cuando choca contra otra
	 * @param otherEntity entidad para comparar
	 * @return el Entity que gane, this en caso de empate
	 */
	//TODO VER QUE CONVIENE QUE DEVUELVA ESTE METODO
	public abstract int compare( Entity otherEntity );
	
	protected abstract int compare( Pacman aPacman );
	protected abstract int compare( Ghost aGhost );
	protected abstract int compare( Pill aPill );
	protected abstract int compare( Wall aWall );
}
