package ar.edu.ub.testing.pacman.modelo.entity;

public class Wall extends Structure
{

	@Override
	public String getDibujo()
	{
		return "#";
	}

	@Override
	public Entity compare(Entity otherEntity)
	{
		return otherEntity.compare( this );
	}

	@Override
	protected Entity compare(Pacman aPacman)
	{
		return this;
	}

	@Override
	protected Entity compare(Ghost aGhost)
	{
		return this;
	}

	@Override
	protected Entity compare(Pill aPill)
	{
		//TODO esto tiene que dar una excepcion
		return null;
	}

	@Override
	protected Entity compare(Wall aWall)
	{
		// TODO esto tiene que dar una excepcion
		return null;
	}

}
