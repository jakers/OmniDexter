package com.omnidex.pokemon;

import com.omnidex.type.Type;

/**
 * Stats are HP, ATK, DEF, SPATK, SPDEF, SPE, ACCURACY, EVASION
 * Methods here perform calculations and set
 * and retrieve stats.
 * 
 * @author jakers
 */
public interface Stats
{
    // constants for elements of arrays
    static final int CURR_HP = 1;
    static final int MAX_HP = 0;
    static final int ATK = 1;
    static final int DEF = 2;
    static final int SPATK = 3;
    static final int SPDEF = 4;
    static final int SPE = 5;
    static final int ACCURARY = 0;
    static final int EVASION = 1;
    
    // constants for increase/decrease factors
    // POWER indicates the stages for atk,def,spAtk,spDef,spe
    // HIT indicates the stages for accuracy and evasion
    static final double POWER_MINUS_SIX = 2/(double)8;
    static final double HIT_MINUS_SIX = 1/(double)3;
    static final double POWER_MINUS_FIVE = 2/(double)7;
    static final double HIT_MINUS_FIVE = 3/(double)8;
    static final double POWER_MINUS_FOUR = 2/(double)6;
    static final double HIT_MINUS_FOUR = 3/(double)7;
    static final double POWER_MINUS_THREE = 2/(double)5;
    static final double HIT_MINUS_THREE = 0.5;
    static final double POWER_MINUS_TWO = 1/(double)2;
    static final double HIT_MINUS_TWO = 3/(double)5;
    static final double POWER_MINUS_ONE = 2/(double)3;
    static final double HIT_MINUS_ONE = 0.75;
    static final double ZERO = 1.0;
    static final double POWER_PLUS_ONE = 1.5;
    static final double HIT_PLUS_ONE = 4/(double)3;
    static final double POWER_PLUS_TWO = 2.0;
    static final double HIT_PLUS_TWO = 5/(double)3;
    static final double POWER_PLUS_THREE = 2.5;
    static final double HIT_PLUS_THREE = 2.0;
    static final double POWER_PLUS_FOUR = 3.0;
    static final double HIT_PLUS_FOUR = 7/(double)3;
    static final double POWER_PLUS_FIVE = 3.5;
    static final double HIT_PLUS_FIVE = 8/(double)3;
    static final double POWER_PLUS_SIX = 4.0;
    static final double HIT_PLUS_SIX = 3.0;
    static final int GEN_II_NUM_STATS = 6;
    static final int STAGE_SIX = 6;
    static final int STAGE_FIVE = 5;
    static final int STAGE_FOUR = 4;
    static final int STAGE_THREE = 3;
    static final int STAGE_TWO = 2;
    static final int STAGE_ONE = 1;
    static final int STAGE_ZERO = 0;
    static final int STAGE_NEG_ONE = -1;
    static final int STAGE_NEG_TWO = -2;
    static final int STAGE_NEG_THREE = -3;
    static final int STAGE_NEG_FOUR = -4;
    static final int STAGE_NEG_FIVE = -5;
    static final int STAGE_NEG_SIX = -6;
    
    /**
     * Assigns the Pokemon the specified Nature
     *
     * @param nature a Nature enum for the 
     * Pokemon to have next
     */
    void setNature(Nature nature);
    
    /**
     * @return a Nature enum representing the
     * Pokemon's nature.
     */
    Nature getNature();

    /**
     * @return an int[] of all the
     * base stats for the pokemon in the following
     * order. hp, atk, def, spAtk, spDef, spe
     */
    int[] getBaseStats();
    
    /**
     * @param baseStats an int array of a Pokemon's
     * base states in the order: hp, atk, def, spAtk, spDef, spe
     */
    void setBaseStats(int[] baseStats);
    
    /**
     * Sets a Pokemon's evs to the specified values
     * in evs[].
     *
     * @param evs an int[] of all the evs
     * a Pokemon has earned. The order of
     * the evs are: hp, atk, def, spAtk, spDef, spe
     */
    void setEvs(int[] evs);
    
    /**
     * @return an int[] of the Pokemons current ivs.
     * The order of the ivs are: hp, atk, def,
     * spAtk, spDef, spe
     */
    int[] getIvs();
    
    /**
     * Sets the Pokemon's ivs to those specified in
     * ivs[].
     * @param ivs an int[] of ivs for the Pokemon. The
     * order of the ivs is: hp, atk, def, spAtk, spDef, spe
     */
    void setIvs(int[] ivs);
 
    /**
     * @return an int representing the pokemon's unmodified
     * attack stat.
     */
    int getAtk();
    
    /**
     * @return an int representing the pokemon's unmodified
     * defense stat.
     */
    int getDef();
    
    /**
     * @return an int representing the pokemon's unmodified
     * special attack stat.
     */
    int getSpAtk();

    /**
     * @return an int representing the pokemon's unmodified
     * special defense stat.
     */
    int getSpDef();
    
    /**
     * @return an int representing the pokemon's unmodified
     * speed stat.
     */
    int getSpe();
    
    /**
     * Decreases the stage of accuracy by one. If the stage is -6 then accuracy
     * will not be lowered.
     */
    void decrementAccuracy();    
    
    /**
     * Decreases the stage of accuracy by the value of decrease.
     * If the stage of speed is already at -6 then accuracy will not be
     * decreased.
     *
     * @param decrease an int representing how much to decrease the value of 
     * accuracy by.
     */
    void decrementAccuracy(int decrease);

    /**
     * Decreases the stage of attack by one. If value is -6 then attack
     * will not be lowered.
     */
    void decrementAtk();
    
    /**
     * Decreases the stage of attack by the value of decrease. If the stage of
     * attack is already at -6 then attack will not be decreased.
     *
     * @param decrease an int representing how much to decrease the value of
     * attack by.
     */
    void decrementAtk(int decrease);

    /**
     * Decreases the stage of defense by one. If value is -6 then defense
     * will not be lowered.
     */
    void decrementDef();
    
    /**
     * Decreases the stage of defense by the value of decrease. If the stage of
     * defense is already at -6 then attack will not be decreased.
     *
     * @param decrease an int representing how much to decrease the value of
     * defense by.
     */
    void decrementDef(int decrease);
    
    /**
     * Decreases the stage of accuracy by one. If the stage is -6 then evasion
     * will not be lowered.
     */
    void decrementEvasion();

    /**
     * Decreases the stage of accuracy by the value of decrease.
     * If the stage of speed is already at -6 then evasion will not be
     * decreased.
     *
     * @param decrease an int representing how much to decrease the value of 
     * evasion by.
     */
    void decrementEvasion(int decrease);
    
    // TODO javadocs
    void setHpBase(int hpBase);
    void setAtkBase(int atkBase);
    void setDefBase(int defBase);
    void setSpAtkBase(int spAtkBase);
    void setSpDefBase(int spDefBase);
    void setSpeBase(int speBase);
    
    // TODO javadocs
    int getHpBase();
    int getAtkBase();
    int getDefBase();
    int getSpAtkBase();
    int getSpDefBase();
    int getSpeBase();
    
    /**
     * Decreases the stage of special attack by one. If value is -6 then
     * special attack will not be lowered.
     */
    void decrementSpAtk();

    /**
     * Decreases the stage of special defense by one. If value is -6 then
     * special defense will not be lowered.
     */
    void decrementSpDef();

    /**
     * Decreases the stage of speed by one. If value is -6 then
     * speed will not be lowered.
     */
    void decrementSpe();
    
    // TOOD javadocs
    void setLevel(int level);
    int getLevel();
    int getHpIv();
    int getAtkIv();
    int getDefIv();
    int getSpAtkIv();
    int getSpDefIv();
    int getSpeIv();
    int[] getEvs();
    int getHpEv();
    int getAtkEv();
    int getDefEv();
    int getSpAtkEv();
    int getSpDefEv();
    int getSpeEv();
    void setHpIv(int hpIv);
    void setAtkIv(int atkIv);
    void setDefIv(int defIv);
    void setSpAtkIv(int spAtkIv);
    void setSpDefIv(int spDefIv);
    void setSpeIv(int speIv);
    void setHpEv(int hpEv);
    void setAtkEv(int atkEv);
    void setDefEv(int defEv);
    void setSpAtkEv(int spAtkEv);
    void setSpDefEv(int spDefEv);
    void setSpeEv(int speEv);

    /**
     * Decreases the stage of special attack by the value of decrease.
     * If the stage of special attack is already at -6 then attack will not be
     * decreased.
     *
     * @param decrease an int representing how much to decrease the value of
     * special attack by.
     */
    void decrementSpAtk(int decrease);

    /**
     * Decreases the stage of special defense by the value of decrease.
     * If the stage of special defense is already at -6 then attack will not be
     * decreased.
     *
     * @param decrease an int representing how much to decrease the value of 
     * special defense by.
     */
    void decrementSpDef(int decrease);

    /**
     * Decreases the stage of speed by the value of decrease.
     * If the stage of speed is already at -6 then attack will not be
     * decreased.
     *
     * @param decrease an int representing how much to decrease the value of 
     * speed by.
     */
    void decrementSpe(int decrease);
    
   /**
     * @return an int representing the attack with stage modifier
     */
    int getCurrAtk();
    
    /**
     * @return an int representing the defense with stage modifier
     */
    int getCurrDef();
    
    /**
     * @return an int representing the current hit points.
     */
    int getCurrHp();

    /**
     * @return an int representing the special attack with stage modifier
     */
    int getCurrSpAtk();

    /**
     * @return an int representing the special defense with stage modifier
     */
    int getCurrSpDef();

    /**
     * @return an int representing the speed with stage modifier
     */
    int getCurrSpe();
    
    /**
     * @return an int representing the base power of the hidden power. 
     */
    int getHiddenPowerBasePower();
    
    /**
     * @return a Type representing the type of the hidden power's type. 
     */
    Type getHiddenPowerType();
    
    /**
     * @return an int representing the maximum hit points available when at
     * full health.
     */
    int getMaxHp();    
    int getAtkStage();
    int getDefStage();
    int getSpAtkStage();
    int getSpDefStage();
    int getSpeStage();

    /**
     * @return a double representing the accuracy stat.
     */
    double getAccuracy();

    // TODO javadocs
    int getAccuracyStage();

    /**
     * @return an array of ints with the format:
     * int[0] = maxHp
     * int[1] = atk
     * int[2] = def
     * int[3] = spAtk
     * int[4] = spDef
     * int[5] = spe
     * all stats excluding maxHp are including stage modifier
     */
    int[] getCurrStats();

    /**
     * @return a double representing the evasion stat.
     */
    double getEvasion();
    
    // TODO javadocs
    int getEvasionStage();

    /**
     * Increases the accuracy stage by one.
     */
    void incrementAccuracy();
    
    /**
     * Increases the accuracy stat by increase. If the old value plus increase
     * is > 6 then it will cap at 6.
     * @param increase an int representing how much to increase the accuracy
     * stat
     * by.
     * Requires: 0 <= increase <= 6
     */
    void incrementAccuracy(int increase);

    /**
     * Increases the atk stage by one.
     */
    void incrementAtk();    
    
    /**
     * Increases the attack stat by increase. If the old value plus increase
     * is > 6 then it will cap at 6.
     * @param increase an int representing how much to increase the atk stat
     * by.
     * Requires: 0 <= increase <= 6
     */
    void incrementAtk(int increase);

    /**
     * Increases the def stage by one.
     */
    void incrementDef();    

    /**
     * Increases the defense stat by increase. If the old value plus increase
     * is > 6 then it will cap at 6.
     * @param increase an int representing how much to increase the def stat
     * by.
     * Requires: 0 <= increase <= 6
     */
    void incrementDef(int increase);

    /**
     * Increase the evasion stage by one.
     */
    void incrementEvasion();    

    /**
     * Increases the evasion stat by increase. If the old value plus increase
     * is > 6 then it will cap at 6.
     * @param increase an int representing how much to increase the evasion stat
     * by.
     * Requires: 0 <= increase <= 6
     */
    void incrementEvasion(int increase);

    /**
     * Increases the spAtk stage by one.
     */
    void incrementSpAtk();    
    
    /**
     * Increases the special attack stat by increase. If the old value plus
     * increase is > 6 then it will cap at 6.
     * @param increase an int representing how much to increase the spAtk stat
     * by.
     * Requires: 0 <= increase <= 6
     */
    void incrementSpAtk(int increase);
    
    /**
     * Increases the spDef stage by one.
     */
    void incrementSpDef();
    
    /**
     * Increases the special defense stat by increase. If the old value plus
     * increase is > 6 then it will cap at 6.
     * @param increase an int representing how much to increase the spDef stat
     * by.
     * Requires: 0 <= increase <= 6
     */
    void incrementSpDef(int increase);
    
    /**
     * Increases the spe stage by one.
     */
    void incrementSpe();
    
    /**
     * Increases the speed stat by increase. If the old value plus increase
     * is > 6 then it will cap at 6.
     * @param increase an int representing how much to increase the speed stat
     * by.
     * Requires: 0 <= increase <= 6
     */
    void incrementSpe(int increase);

    // TODO javadocs
    void setAccuracyStage(int accuracyStage);
    void setAtkStage(int atkStage);

    /**
     * Sets the current Hit Points.
     * @param an int representing the new value of the current Hit Points
     */
    void setCurrHp(int currHp);    

    // TODO javadocs
    void setDefStage(int defStage);
    void setEvasionStage(int evasionStage);
    void setSpAtkStage(int spAtkStage);
    void setSpDefStage(int spDefStage);
    void setSpeStage(int speStage);

    /**
     * Sets all the stats at the same time.
     * @param stats an array of ints representing the stats in the following
     * order
     * int[0] = hp       int[3] = spAtk
     * int[1] = atk      int[4] = spDef
     * int[2] = def      int[5] = spe
     */
    void setStats(int[] stats);

    /**
     * Sets atk,def,spatk,spdef,spe,accuracy, evasion and stages for the
     * respective stats equals to those values from the newStats.
     * @param newStat a Stats object that that the current stats will be set to
     */
    void setStats(Stats newStat);

    /**
     * Sets all the stats at once.
     * @param hp an int representing the new maximum hit point stat
     * Ensures: that the current hit points equals the maximum hit points
     * @param atk an int representing the new attack stat
     * @param def an int representing the new defense stat
     * @param spAtk an int representing the new special attack stat
     * @param spDef an int representing the new special defense stat
     * @param spe an int representing the new speed stat
     */
    void setStats(int hp, int atk, int def, int spAtk, int spDef, int spe);
    String getStatAt(int position);
}
