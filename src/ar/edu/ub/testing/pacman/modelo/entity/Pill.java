package ar.edu.ub.testing.pacman.modelo.entity;

public abstract class Pill extends Structure
{
	@Override
	public int compare(Entity otherEntity)
	{
		return otherEntity.compare( this );
	}

	@Override
	protected int compare(Pacman aPacman)
	{
		return -1;
	}

	@Override
	protected int compare(Ghost aGhost)
	{
		return -1;
	}

	@Override
	protected int compare(Pill aPill)
	{
		// TODO Esto tiene que tirar una excepcion
		return 0;
	}

	@Override
	protected int compare(Wall aWall)
	{
		// TODO Esto tiene que tirar una excepcion
		return 0;
	}

}
