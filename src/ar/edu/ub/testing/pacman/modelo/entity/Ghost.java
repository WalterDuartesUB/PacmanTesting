package ar.edu.ub.testing.pacman.modelo.entity;

import ar.edu.ub.testing.pacman.modelo.entity.ghost.GhostState;
import ar.edu.ub.testing.pacman.modelo.entity.ghost.GhostStateInvisible;
import ar.edu.ub.testing.pacman.modelo.entity.ghost.GhostStateRunning;

public class Ghost extends MovingEntity
{

	private GhostState state = null;
	
	public Ghost(int x, int y)
	{
		this.setPosicion(new Posicion(x,y));
		this.setRunning();
	}
	
	public void setRunning()
	{
		this.setState( new GhostStateRunning() );		
	}
	
	public void setInvisible()
	{
		this.setState( new GhostStateInvisible() );		
	}

	@Override
	public void tick()
	{
		this.setPosicion(this.getDirection().getNextPosition(this.getPosicion()));
	}

	@Override
	public String getDibujo()
	{	
		return "G";
	}

	@Override
	public int compare(Entity otherEntity)
	{
		return otherEntity.compare( this );
	}

	@Override
	protected int compare(Pacman aPacman)
	{
		return this.getState().compare( aPacman );
	}

	@Override
	protected int compare(Ghost aGhost)
	{
		return this.getState().compare( aGhost );
	}

	@Override
	protected int compare(Pill aPill)
	{
		return this.getState().compare( aPill );
	}

	@Override
	protected int compare(Wall aWall)
	{
		// TODO aca "PODRIA" llegar a decidir el cambio de direccion
		return -1;
	}

	private GhostState getState()
	{
		return state;
	}

	private void setState(GhostState state)
	{
		this.state = state;
	}
}
