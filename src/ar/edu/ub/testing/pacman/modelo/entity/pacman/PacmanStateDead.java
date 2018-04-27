package ar.edu.ub.testing.pacman.modelo.entity.pacman;

import ar.edu.ub.testing.pacman.modelo.entity.Ghost;

public class PacmanStateDead implements PacmanState{

	@Override
	public int compare(Ghost aGhost) {
		return 0;
	}
	
}
