package ar.edu.ub.testing.pacman.modelo.entity;

public abstract class Pill extends Structure
{
	@Override
	public Entity compare(Entity otherEntity)
	{
		return otherEntity.compare( this );
	}

	@Override
	protected Entity compare(Pacman aPacman)
	{
		return aPacman;
	}

	@Override
	protected Entity compare(Ghost aGhost)
	{
		return aGhost;
	}

	@Override
	protected Entity compare(Pill aPill)
	{
		// TODO Esto tiene que tirar una excepcion
		return null;
	}

	@Override
	protected Entity compare(Wall aWall)
	{
		// TODO Esto tiene que tirar una excepcion
		return null;
	}

}
