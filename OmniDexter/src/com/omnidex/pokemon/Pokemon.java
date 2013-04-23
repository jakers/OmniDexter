package com.omnidex.pokemon;

import com.omnidex.ability.Ability;
import com.omnidex.item.Item;
import com.omnidex.move.Move;
import com.omnidex.type.Type;

/**
 * @author jakers
 */
public interface Pokemon extends Status, Stats{

    static final int MAX_IV_VALUE = 31;
    static final int MAX_LEVEL = 100;
    static final int MOVE_ONE = 0;
    static final int MOVE_TWO = 1;
    static final int MOVE_THREE = 2;
    static final int MOVE_FOUR = 3;

    /**
     * @return a Type enum representing the Pokemon's
     * first type.
     */
    Type getFirstType();

    /**
     * @return a Type enum representing the Pokemon's
     * second type.
     */
    Type getSecondType();

    /**
     * @return a Stat object representing the Pokemon's
     * current stats.
     */
    Stats getStats();
    
    /**
     * @return a Status object representing the Pokemon's
     * current status.
     */
    Status getStatus();
    
    /**
     * @param type a Type enum to check the type of against the
     * Pokemon's type(s)
     * @return true if type matchs either of the possible two types
     * the Pokemon has.
     */
    boolean isType(Type type);
    
    String getGender();
    Ability getAbility();
    void setAbility(Ability abillity);
    void setNickName(String nickname);
    String getNickName();
    Species getSpecies();

    void setItem(Item item);
    Item getItem();
    Move getMove(int moveSlot);
    void setMove(Move name, int moveSlot);
    boolean isShiny();
    void setShiny(boolean state);
    void setSpecies(Species forme);
    boolean hasFlashFireBoost();
    void setFlashFireBoost(boolean state);
    boolean hasDug();
    boolean hasDove();
    void setDove(boolean state);
    void setDug(boolean state);
    boolean hasNightmare();
    void setNightmare(boolean state);
    boolean hasRings();
    boolean hasRoots();
    boolean isCursed();
    boolean isSeeded();
    
    void setRings(boolean state);
    void setRoots(boolean state);
    void setCursed(boolean state);
    void setSeeded(boolean state);
    void decrementMagnetRise();
}
