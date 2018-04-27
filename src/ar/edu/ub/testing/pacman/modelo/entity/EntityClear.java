package ar.edu.ub.testing.pacman.modelo.entity;

public class EntityClear extends Entity
{

	@Override
	public String getDibujo()
	{
		return " ";
	}

	@Override
	public int compare(Entity otherEntity)
	{
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	protected int compare(Pacman aPacman)
	{
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	protected int compare(Ghost aGhost)
	{
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	protected int compare(Pill aPill)
	{
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	protected int compare(Wall aWall)
	{
		// TODO Auto-generated method stub
		return -1;
	}

}
