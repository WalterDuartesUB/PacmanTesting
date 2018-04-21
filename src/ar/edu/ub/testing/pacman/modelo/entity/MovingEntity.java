package ar.edu.ub.testing.pacman.modelo.entity;

import ar.edu.ub.testing.pacman.modelo.entity.direction.DirectionEntity;

public abstract class MovingEntity extends Entity
{	
	private DirectionEntity direction;
	
	public abstract void tick();

	public DirectionEntity getDirection()
	{
		return direction;
	}

	public void setDirection(DirectionEntity direction)
	{
		this.direction = direction;
	}
	
}
