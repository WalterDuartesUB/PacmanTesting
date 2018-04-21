package ar.edu.ub.testing.pacman.modelo.entity.direction;

import ar.edu.ub.testing.pacman.modelo.entity.Posicion;

public class DirectionEntityNone extends DirectionEntity
{



	@Override
	public DirectionEntity[] getOtherDirections()
	{
		return new DirectionEntity[] { DirectionEntity.LEFT, DirectionEntity.RIGHT, DirectionEntity.DOWN, DirectionEntity.UP };
	}

	@Override
	public Posicion getStep()
	{
		return new Posicion(0, 0);
	}

}
