package ar.edu.ub.testing.pacman.modelo.entity.direction;

import ar.edu.ub.testing.pacman.modelo.entity.Posicion;

public class DirectionEntityRight extends DirectionEntity
{

	@Override
	public Posicion getStep()
	{
		return new Posicion(1,0);
	}

	@Override
	public DirectionEntity[] getOtherDirections()
	{
		return new DirectionEntity[] { DirectionEntity.DOWN, DirectionEntity.LEFT, DirectionEntity.UP };
	}
	
	@Override
	public DirectionEntity getDireccionOpuesta() {
		
		return DirectionEntity.LEFT;
	}



}
