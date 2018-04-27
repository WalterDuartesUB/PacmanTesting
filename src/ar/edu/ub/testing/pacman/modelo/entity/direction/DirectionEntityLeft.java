package ar.edu.ub.testing.pacman.modelo.entity.direction;

import ar.edu.ub.testing.pacman.modelo.entity.Posicion;

public class DirectionEntityLeft extends DirectionEntity
{

	@Override
	public Posicion getStep()
	{
		return new Posicion(-1,0);
	}

	@Override
	public DirectionEntity[] getOtherDirections()
	{
		return new DirectionEntity[] { DirectionEntity.DOWN, DirectionEntity.RIGHT, DirectionEntity.UP };
	}
	
	@Override
	public DirectionEntity getDireccionOpuesta() {
		
		return DirectionEntity.RIGHT;
	}



}
