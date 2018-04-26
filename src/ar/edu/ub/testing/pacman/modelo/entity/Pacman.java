package ar.edu.ub.testing.pacman.modelo.entity;

import ar.edu.ub.testing.pacman.modelo.entity.pacman.PacmanState;
import ar.edu.ub.testing.pacman.modelo.entity.pacman.PacmanStateBlue;
import ar.edu.ub.testing.pacman.modelo.entity.pacman.PacmanStateYellow;

public class Pacman extends MovingEntity
{
	private PacmanState	state = null;
	
	public Pacman()
	{
		this.setYellow();
		this.setPosicion(new Posicion(1,1));
	}
	
	@Override
	public void tick()
	{	
		System.out.println(this.getPosicion().getX());
		System.out.println(this.getPosicion().getY());
		this.setPosicion(this.getDirection().getNextPosition(this.getPosicion()));
		System.out.println(this.getPosicion().getX());
		System.out.println(this.getPosicion().getY());
	}

	@Override
	public String getDibujo()
	{
		return "P";
	}

	private PacmanState getState()
	{
		return state;
	}

	private void setState(PacmanState state)
	{
		this.state = state;
	}

	public void setYellow()
	{
		//El pacman pierde contra los fantasma
		this.setState( new PacmanStateYellow() );
	}
	
	public void setBlue()
	{
		//Ahora el pacman tiene que ganarle a los fantasmas
		this.setState( new PacmanStateBlue() );
	}

	@Override
	public Entity compare(Entity otherEntity)
	{
		return otherEntity.compare( this );
	}

	@Override
	protected Entity compare(Pacman aPacman)
	{
		// TODO tiene que tirar una excepcion
		return null;
	}

	@Override
	protected Entity compare(Ghost aGhost)
	{
		return this.getState().compare( aGhost );
	}

	@Override
	protected Entity compare(Pill aPill)
	{
		return this;
	}

	@Override
	protected Entity compare(Wall aWall)
	{
		return aWall.compare( this );
	}
}
