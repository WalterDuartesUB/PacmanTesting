package ar.edu.ub.testing.pacman.modelo.entity.pacman;

import ar.edu.ub.testing.pacman.modelo.entity.Entity;
import ar.edu.ub.testing.pacman.modelo.entity.Ghost;

public class PacmanStateYellow implements PacmanState
{

	@Override
	public Entity compare(Ghost aGhost)
	{
		return aGhost;
	}

}
