package ar.edu.ub.testing.pacman.modelo.entity.direction;

import ar.edu.ub.testing.pacman.modelo.entity.Posicion;

public class DirectionEntityDown extends DirectionEntity
{

	@Override
	public Posicion getStep()
	{
		return new Posicion(0,1);
	}

	@Override
	public DirectionEntity[] getOtherDirections()
	{
		return new DirectionEntity[] { DirectionEntity.LEFT, DirectionEntity.RIGHT, DirectionEntity.UP };
	}
	
	@Override
	public DirectionEntity getDireccionOpuesta() {
		
		return DirectionEntity.UP;
	}


	
}
