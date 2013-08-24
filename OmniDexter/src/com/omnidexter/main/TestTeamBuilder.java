package com.omnidexter.main;

import com.omnidex.ability.Ability;
import com.omnidex.battlefield.team.DeepTeam;
import com.omnidex.battlefield.team.Team;
import com.omnidex.move.Move;
import com.omnidex.pokemon.InactivePokemon;
import com.omnidex.pokemon.Pokemon;
import com.omnidex.pokemon.Species;


/**
 * @author OmniDex
 */
public class TestTeamBuilder {

    public static Team getStarterTestTeam() {
        Team team = new DeepTeam();
        Pokemon t1P1 = new InactivePokemon();
        t1P1.setSpecies(Species.CHARMANDER);
        t1P1.setAbility(Ability.BLAZE);
        t1P1.setLevel(5);
        t1P1.setAtkEv(252);
        t1P1.setSpeEv(252);
        t1P1.setMove(Move.SCRATCH, 0);
        t1P1.setMove(Move.EMBER, 1);
        t1P1.setMove(Move.SCRATCH, 2);
        t1P1.setMove(Move.SCRATCH, 3);
        team.addTeamMate(t1P1);
        
        Pokemon t1P2 = new InactivePokemon();
        t1P2.setSpecies(Species.BULBASAUR);
        t1P2.setAbility(Ability.OVERGROW);
        t1P2.setLevel(5);
        t1P2.setAtkEv(252);
        t1P2.setSpeEv(252);
        t1P2.setMove(Move.TACKLE, 0);
        t1P2.setMove(Move.VINE_WHIP, 1);
        t1P2.setMove(Move.TACKLE, 2);
        t1P2.setMove(Move.TACKLE, 3);
        team.addTeamMate(t1P2);
        
        Pokemon t1P3 = new InactivePokemon();
        t1P3.setSpecies(Species.SQUIRTLE);
        t1P3.setAbility(Ability.TORRENT);
        t1P3.setLevel(5);
        t1P3.setAtkEv(252);
        t1P3.setSpeEv(252);
        t1P3.setMove(Move.TACKLE, 0);
        t1P3.setMove(Move.BUBBLE, 1);
        t1P3.setMove(Move.TACKLE, 2);
        t1P3.setMove(Move.TACKLE, 3);
        team.addTeamMate(t1P3); 
        
        return team;
    }

//    public static Team getStarterTestTeam2() {
//        Team team = new DeepTeam();
//        Pokemon t1P1 = new InactivePokemon();
//        t1P1.setSpecies(Species.CHARMANDER);
//        t1P1.setAbility(Ability.BLAZE);
//        t1P1.setLevel(5);
//        t1P1.setAtkEv(252);
//        t1P1.setSpeEv(252);
//        t1P1.setMove(Move.SCRATCH, 0);
//        t1P1.setMove(Move.EMBER, 1);
//        t1P1.setMove(Move.SCRATCH, 2);
//        t1P1.setMove(Move.SCRATCH, 3);
//        
//        
//        Pokemon t1P2 = new InactivePokemon();
//        t1P2.setSpecies(Species.BULBASAUR);
//        t1P2.setAbility(Ability.OVERGROW);
//        t1P2.setLevel(5);
//        t1P2.setAtkEv(252);
//        t1P2.setSpeEv(252);
//        t1P2.setMove(Move.TACKLE, 0);
//        t1P2.setMove(Move.VINE_WHIP, 1);
//        t1P2.setMove(Move.TACKLE, 2);
//        t1P2.setMove(Move.TACKLE, 3);
//        team.addTeamMate(t1P2);
//        
//        Pokemon t1P3 = new InactivePokemon();
//        t1P3.setSpecies(Species.SQUIRTLE);
//        t1P3.setAbility(Ability.TORRENT);
//        t1P3.setLevel(5);
//        t1P3.setAtkEv(252);
//        t1P3.setSpeEv(252);
//        t1P3.setMove(Move.TACKLE, 0);
//        t1P3.setMove(Move.BUBBLE, 1);
//        t1P3.setMove(Move.TACKLE, 2);
//        t1P3.setMove(Move.TACKLE, 3);
//        team.addTeamMate(t1P3); 
//        team.addTeamMate(t1P1);
//        return team;
//    }
//    
//    
//    public static Team getTestSquritle() {
//        Team team = new DeepTeam();
//        Pokemon t1P1 = new InactivePokemon();
//        t1P1.setSpecies(Species.SQUIRTLE);
//        t1P1.setAbility(Ability.TORRENT);
//        t1P1.setLevel(5);
//        t1P1.setHpEv(252);
//        t1P1.setDefEv(252);
//        t1P1.setMove(Move.TACKLE, 0);
//        t1P1.setMove(Move.U_TURN, 1);
//        t1P1.setMove(Move.ABSORB, 2);
//        t1P1.setMove(Move.AERIAL_ACE, 3);
//        team.addTeamMate(t1P1);
//        return team;
//    }
//
    public static Team getTestTeamOne() {
        Team team = new DeepTeam();

        Pokemon t1P1 = new InactivePokemon();

        t1P1.setSpecies(Species.AGGRON);
        t1P1.setAbility(Ability.STURDY);
        t1P1.setAtkEv(252);
        t1P1.setSpeEv(252);
        t1P1.setMove(Move.AQUA_TAIL, 3);
        t1P1.setMove(Move.EARTHQUAKE, 1);
        t1P1.setMove(Move.STONE_EDGE, 2);
        t1P1.setMove(Move.ICE_PUNCH, 0);
        team.addTeamMate(t1P1);

        Pokemon t1P2 = new InactivePokemon();
        t1P2.setSpecies(Species.SPIRITOMB);
        t1P2.setAbility(Ability.PRESSURE);
        t1P2.setHpEv(252);
        t1P2.setSpDefEv(252);

        t1P2.setMove(Move.SUCKER_PUNCH, 0);
        t1P2.setMove(Move.SHADOW_BALL, 1);
        t1P2.setMove(Move.WILL_O_WISP, 2);
        t1P2.setMove(Move.PAIN_SPLIT, 3);
        team.addTeamMate(t1P2);

        Pokemon t1P3 = new InactivePokemon();
        t1P3.setSpecies(Species.GYARADOS);
        t1P3.setAbility(Ability.INTIMIDATE);
        t1P3.setHpEv(252);
        t1P3.setAtkEv(252);
        t1P3.setSpeEv(4);

        t1P3.setMove(Move.WATERFALL, 0);
        t1P3.setMove(Move.ICE_FANG, 1);
        t1P3.setMove(Move.SUBSTITUTE, 2);
        t1P3.setMove(Move.DRAGON_DANCE, 3);
        team.addTeamMate(t1P3);
        return team;
    }
//
    public static Team getTestTeamTwo() {
        Team t2 = new DeepTeam();
        Pokemon t2P1 = new InactivePokemon();
        t2P1.setSpecies(Species.MAGMAR);
        t2P1.setAbility(Ability.FLAME_BODY);
        t2P1.setAtkEv(252);
        t2P1.setSpeEv(252);
        t2P1.setMove(Move.FIRE_BLAST, 0);
        t2P1.setMove(Move.FOCUS_BLAST, 1);
        t2P1.setMove(Move.THUNDERBOLT, 2);
        t2P1.setMove(Move.SOLARBEAM, 3);
        t2.addTeamMate(t2P1);
        Pokemon t2P2 = new InactivePokemon();
        t2P2.setSpecies(Species.HAUNTER);
        t2P2.setAbility(Ability.LEVITATE);
        t2P2.setAtkEv(252);
        t2P2.setSpeEv(252);

        t2P2.setMove(Move.SUCKER_PUNCH, 0);
        t2P2.setMove(Move.SHADOW_BALL, 1);
        t2P2.setMove(Move.WILL_O_WISP, 2);
        t2P2.setMove(Move.PAIN_SPLIT, 3);
        t2.addTeamMate(t2P2);

        Pokemon t2P3 = new InactivePokemon();
        t2P3.setSpecies(Species.BRONZONG);
        t2P3.setAbility(Ability.HEATPROOF);

        t2P3.setHpEv(252);
        t2P3.setSpDefEv(252);

        t2P3.setMove(Move.GYRO_BALL, 0);
        t2P3.setMove(Move.EARTHQUAKE, 1);
        t2P3.setMove(Move.HYPNOSIS, 2);
        t2P3.setMove(Move.THUNDER_WAVE, 3);
        t2.addTeamMate(t2P3);
        return t2;
    }
}
