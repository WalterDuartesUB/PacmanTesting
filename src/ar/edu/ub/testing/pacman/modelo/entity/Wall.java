package ar.edu.ub.testing.pacman.modelo.entity;

public class Wall extends Structure
{

	@Override
	public String getDibujo()
	{
		return "#";
	}

	@Override
	public int compare(Entity otherEntity)
	{
		return otherEntity.compare( this );
	}

	@Override
	protected int compare(Pacman aPacman)
	{
		return 1;
	}

	@Override
	protected int compare(Ghost aGhost)
	{
		return 1;
	}

	@Override
	protected int compare(Pill aPill)
	{
		//TODO esto tiene que dar una excepcion
		return 1;
	}

	@Override
	protected int compare(Wall aWall)
	{
		// TODO esto tiene que dar una excepcion
		return 0;
	}

}
