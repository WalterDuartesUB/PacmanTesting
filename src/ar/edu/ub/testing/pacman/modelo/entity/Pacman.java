package ar.edu.ub.testing.pacman.modelo.entity;

import ar.edu.ub.testing.pacman.modelo.entity.pacman.PacmanState;
import ar.edu.ub.testing.pacman.modelo.entity.pacman.PacmanStateBlue;
import ar.edu.ub.testing.pacman.modelo.entity.pacman.PacmanStateDead;
import ar.edu.ub.testing.pacman.modelo.entity.pacman.PacmanStateYellow;

public class Pacman extends MovingEntity
{
	private PacmanState	state = null;
	
	public Pacman(int x, int y)
	{
		this.setYellow();
		this.setPosicion(new Posicion(x,y));
	}
	
	@Override
	public void tick()
	{	
		this.setPosicion(this.getDirection().getNextPosition(this.getPosicion()));
	}

	@Override
	public String getDibujo()
	{
		return "P";
	}
	
	public void isDead() {
		this.setState( new PacmanStateDead());
	}

	public PacmanState getState()
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
	public int compare(Entity otherEntity)
	{
		return otherEntity.compare( this );
	}

	@Override
	protected int compare(Pacman aPacman)
	{
		// TODO tiene que tirar una excepcion
		return 0;
	}

	@Override
	protected int compare(Ghost aGhost)
	{
		return this.getState().compare( aGhost );
	}

	@Override
	protected int compare(Pill aPill)
	{
		return 1;
	}

	@Override
	protected int compare(Wall aWall)
	{
		return aWall.compare( this );
	}
}
