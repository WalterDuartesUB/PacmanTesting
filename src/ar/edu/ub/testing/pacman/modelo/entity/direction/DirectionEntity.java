package ar.edu.ub.testing.pacman.modelo.entity.direction;

import ar.edu.ub.testing.pacman.modelo.entity.Posicion;
import ar.edu.ub.testing.pacman.modelo.maze.Maze;

public abstract class DirectionEntity
{
	public static final DirectionEntity LEFT = DirectionEntity.createLeft();  
	public static final DirectionEntity RIGHT = DirectionEntity.createRight();  
	public static final DirectionEntity DOWN = DirectionEntity.createDown();  
	public static final DirectionEntity UP = DirectionEntity.createUp();  
	public static final DirectionEntity NONE = DirectionEntity.createNone();
	
	private static DirectionEntity createRight()
	{
		return new DirectionEntityRight();
	}
	private static DirectionEntity createNone()
	{
		return new DirectionEntityNone();
	}
	private static DirectionEntity createUp()
	{
		return new DirectionEntityUp();
	}
	private static DirectionEntity createDown()
	{
		return new DirectionEntityDown();
	}
	private static DirectionEntity createLeft()
	{
		return new DirectionEntityLeft();
	}
	
	public Posicion getNextPosition(Posicion posicion)
	{
		return posicion.add( this.getStep() );
	}
	
	public abstract Posicion getStep();
	
	public abstract DirectionEntity[] getOtherDirections();
	
	public abstract DirectionEntity getDireccionOpuesta();
	
	public boolean sonIguales(DirectionEntity direction)
	{
		return this == direction;
	}
}
