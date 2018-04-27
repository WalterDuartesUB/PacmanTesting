package ar.edu.ub.testing.pacman.modelo.entity.ghost;

import ar.edu.ub.testing.pacman.modelo.entity.Ghost;
import ar.edu.ub.testing.pacman.modelo.entity.Pacman;
import ar.edu.ub.testing.pacman.modelo.entity.Pill;

public class GhostStateInvisible implements GhostState
{

	@Override
	public int compare(Ghost aGhost)
	{
		return -1;
	}

	@Override
	public int compare(Pill aPill)
	{
		// TODO VER COMO INDICAR QUE GANA La Pastilla
		return 1;
	}

	@Override
	public int compare(Pacman aPacman)
	{
		// TODO VER COMO INDICAR QUE GANA EL PACMAN
		return -1;
	}

}
