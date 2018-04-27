package ar.edu.ub.testing.pacman.modelo.entity.direction;

import ar.edu.ub.testing.pacman.modelo.entity.Posicion;

public class DirectionEntityUp extends DirectionEntity
{

	@Override
	public Posicion getStep()
	{
		return new Posicion(0,-1);
	}

	@Override
	public DirectionEntity[] getOtherDirections()
	{
		return new DirectionEntity[] { DirectionEntity.DOWN, DirectionEntity.LEFT, DirectionEntity.RIGHT };
	}

	@Override
	public DirectionEntity getDireccionOpuesta() {
		
		return DirectionEntity.DOWN;
	}

}
