package ar.edu.ub.testing.pacman.modelo.entity.pacman;

import ar.edu.ub.testing.pacman.modelo.entity.Entity;
import ar.edu.ub.testing.pacman.modelo.entity.Ghost;

public interface PacmanState
{

	public Entity compare(Ghost aGhost);

}
