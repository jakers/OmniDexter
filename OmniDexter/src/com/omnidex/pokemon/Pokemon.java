package com.omnidex.pokemon;

import com.omnidex.ability.Ability;
import com.omnidex.item.Item;
import com.omnidex.move.Move;
import com.omnidex.move.MoveWithPP;
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

    static final int SWITCH_ONE = -1;
    static final int SWITCH_TWO = -2;
    static final int SWITCH_THREE = -3;
    static final int SWITCH_FOUR = -4;
    static final int SWITCH_FIVE = -5;

    Type getFirstType();

    Type getSecondType();

    Stats getStats();
    
    Status getStatus();
    
    boolean isType(Type type);
    
    Ability getAbility();
    String getGender();
    boolean hasAbility(Ability ability);
    void setAbility(Ability abillity);
    void setNickName(String nickname);
    String getNickName();
    Species getSpecies();
    boolean isGender(Gender gender);
    void setItem(Item item);
    Item getItem();
    MoveWithPP getMove(int moveSlot);
    void setMove(Move name, int moveSlot);
    boolean isShiny();
    void setShiny(boolean state);
    void setSpecies(Species forme);
    void setFriendship(int friendship);
    int getFriendship();
    boolean hasItem(Item item);
    boolean isSpecies(Species species);
    void setWeight(double weight);
    double getWeight();
    void damage(int damage);
    void heal(int addHp);
    boolean isGrounded();
}
