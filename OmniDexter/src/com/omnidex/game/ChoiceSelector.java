package com.omnidex.game;

import com.omnidex.battlefield.team.Team;
import com.omnidexter.battlefield.BattleField;

public abstract class ChoiceSelector {
	public abstract int getTurnChoice(Team self, Team opponent, BattleField bf);
}
