package ar.edu.ub.testing.pacman.modelo.entity.direction;

import ar.edu.ub.testing.pacman.modelo.entity.Posicion;

public class DirectionEntityDown extends DirectionEntity
{

	@Override
	public Posicion getStep()
	{
		return new Posicion(0,-1);
	}

	@Override
	public DirectionEntity[] getOtherDirections()
	{
		// TODO Auto-generated method stub
		return null;
	}

	
}
