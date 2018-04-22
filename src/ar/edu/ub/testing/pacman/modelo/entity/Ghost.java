package ar.edu.ub.testing.pacman.modelo.entity;

import ar.edu.ub.testing.pacman.modelo.entity.ghost.GhostState;
import ar.edu.ub.testing.pacman.modelo.entity.ghost.GhostStateInvisible;
import ar.edu.ub.testing.pacman.modelo.entity.ghost.GhostStateRunning;

public class Ghost extends MovingEntity
{

	private GhostState state = null;
	
	public Ghost()
	{
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
		
	}

	@Override
	public String getDibujo()
	{	
		return "G";
	}

	@Override
	public Entity compare(Entity otherEntity)
	{
		return otherEntity.compare( this );
	}

	@Override
	protected Entity compare(Pacman aPacman)
	{
		return this.getState().compare( aPacman );
	}

	@Override
	protected Entity compare(Ghost aGhost)
	{
		return this.getState().compare( aGhost );
	}

	@Override
	protected Entity compare(Pill aPill)
	{
		return this.getState().compare( aPill );
	}

	@Override
	protected Entity compare(Wall aWall)
	{
		// TODO aca "PODRIA" llegar a decidir el cambio de direccion
		return aWall;
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
