package ar.edu.ub.testing.pacman.modelo.entity.ghost;

import ar.edu.ub.testing.pacman.modelo.entity.Entity;
import ar.edu.ub.testing.pacman.modelo.entity.Ghost;
import ar.edu.ub.testing.pacman.modelo.entity.Pacman;
import ar.edu.ub.testing.pacman.modelo.entity.Pill;

public class GhostStateRunning implements GhostState
{

	@Override
	public int compare(Ghost aGhost)
	{
		// TODO VER COMO INDICAR QUE GANA EL FANTASMA
		return 1;
	}

	@Override
	public int compare(Pill aPill)
	{
		// TODO VER COMO INDICAR QUE GANA EL FANTASMA
		return 1;
	}

	@Override
	public int compare(Pacman aPacman)
	{
		Ghost aGhost = null;
		return aPacman.getState().compare(aGhost);
	}

}
