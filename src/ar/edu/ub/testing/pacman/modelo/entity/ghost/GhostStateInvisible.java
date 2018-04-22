package ar.edu.ub.testing.pacman.modelo.entity.ghost;

import ar.edu.ub.testing.pacman.modelo.entity.Entity;
import ar.edu.ub.testing.pacman.modelo.entity.Ghost;
import ar.edu.ub.testing.pacman.modelo.entity.Pacman;
import ar.edu.ub.testing.pacman.modelo.entity.Pill;

public class GhostStateInvisible implements GhostState
{

	@Override
	public Entity compare(Ghost aGhost)
	{
		// TODO VER COMO INDICAR QUE GANA EL FANTASMA QUE SEA VISIBLE
		return null;
	}

	@Override
	public Entity compare(Pill aPill)
	{
		// TODO VER COMO INDICAR QUE GANA La Pastilla
		return null;
	}

	@Override
	public Entity compare(Pacman aPacman)
	{
		// TODO VER COMO INDICAR QUE GANA EL PACMAN
		return null;
	}

}
