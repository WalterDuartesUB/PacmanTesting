package ar.edu.ub.testing.pacman.modelo.entity.pacman;

import ar.edu.ub.testing.pacman.modelo.entity.Entity;
import ar.edu.ub.testing.pacman.modelo.entity.Ghost;
import ar.edu.ub.testing.pacman.modelo.entity.Pacman;

public class PacmanStateBlue implements PacmanState
{

	@Override
	public Entity compare(Ghost aGhost)
	{
		Pacman pacman = new Pacman();
		return pacman;
	}

}
