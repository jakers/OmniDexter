package com.omnidex.pokemon;

import com.omnidex.damage.PokemonMath;
import com.omnidex.type.Type;

/**
 * @author jakers
 */
public class PokeStats implements Stats {

    private int maxHp;
    private int currHp;
    private int atk;
    private int def;
    private int spAtk;
    private int spDef;
    private int spe;
    private double accuracy;
    private double evasion;
    private int hpIv;
    private int atkIv;
    private int defIv;
    private int spAtkIv;
    private int spDefIv;
    private int speIv;
    private int hpEv;
    private int atkEv;
    private int defEv;
    private int spAtkEv;
    private int spDefEv;
    private int speEv;
    private int atkStage;
    private int defStage;
    private int spAtkStage;
    private int spDefStage;
    private int speStage;
    private int accuracyStage;
    private int evasionStage;
    private Nature nature;
    private int[] baseStats;
    private int level;
    private double atkRatio;
    private double defRatio;
    private double spAtkRatio;
    private double spDefRatio;
    private double speRatio;
    private int hiddenPowerBasePower;
    private Type hiddenPowerType;

    public PokeStats(Nature nature, int[] baseStats, int[] ivs,
            int[] evs) {
        this.nature = nature;
        this.baseStats = baseStats;
        this.level = 100;

        hpIv = ivs[MAX_HP];
        atkIv = ivs[ATK];
        defIv = ivs[DEF];
        spAtkIv = ivs[SPATK];
        spDefIv = ivs[SPDEF];
        speIv = ivs[SPE];

        hpEv = evs[MAX_HP];
        atkEv = evs[ATK];
        defEv = evs[DEF];
        spAtkEv = evs[SPATK];
        spDefEv = evs[SPDEF];
        speEv = evs[SPE];

        int[] stats = PokemonMath.calcPokemon(level, nature, baseStats, ivs,
                evs);
        reCalcStats();
        maxHp = stats[MAX_HP];
        currHp = maxHp;

        atk = stats[ATK];
        def = stats[DEF];
        spAtk = stats[SPATK];
        spDef = stats[SPDEF];
        spe = stats[SPE];

        atkStage = 0;
        defStage = 0;
        spAtkStage = 0;
        spDefStage = 0;
        speStage = 0;

        atkRatio = ZERO;
        defRatio = ZERO;
        spAtkRatio = ZERO;
        spDefRatio = ZERO;
        speRatio = ZERO;

        accuracy = 1.0;
        evasion = 1.0;
    }
  
    public PokeStats(int level, Nature nature, int[] baseStats, int[] ivs,
            int[] evs) {
        this.nature = nature;
        this.baseStats = baseStats;
        this.level = level;

        hpIv = ivs[MAX_HP];
        atkIv = ivs[ATK];
        defIv = ivs[DEF];
        spAtkIv = ivs[SPATK];
        spDefIv = ivs[SPDEF];
        speIv = ivs[SPE];

        hpEv = evs[MAX_HP];
        atkEv = evs[ATK];
        defEv = evs[DEF];
        spAtkEv = evs[SPATK];
        spDefEv = evs[SPDEF];
        speEv = evs[SPE];

        int[] stats = PokemonMath.calcPokemon(level, nature, baseStats, ivs,
                evs);
        reCalcStats();
        maxHp = stats[MAX_HP];
        currHp = maxHp;

        atk = stats[ATK];
        def = stats[DEF];
        spAtk = stats[SPATK];
        spDef = stats[SPDEF];
        spe = stats[SPE];

        atkStage = 0;
        defStage = 0;
        spAtkStage = 0;
        spDefStage = 0;
        speStage = 0;

        atkRatio = ZERO;
        defRatio = ZERO;
        spAtkRatio = ZERO;
        spDefRatio = ZERO;
        speRatio = ZERO;

        accuracy = 1.0;
        evasion = 1.0;
    }

    public PokeStats(Stats s) {
        this.nature = s.getNature();
        this.baseStats = s.getBaseStats();
        this.level = s.getLevel();

        hpIv = s.getHpIv();
        atkIv = s.getAtkIv();
        defIv = s.getDefIv();
        spAtkIv = s.getSpAtkIv();
        spDefIv = s.getSpDefIv();
        speIv = s.getSpeIv();

        hpEv = s.getHpEv();
        atkEv = s.getAtkEv();
        defEv = s.getDefEv();
        spAtkEv = s.getSpAtkEv();
        spDefEv = s.getSpDefEv();
        speEv = s.getSpeEv();

        reCalcStats();

        atkStage = s.getAtkStage();
        defStage = s.getDefStage();
        spAtkStage = s.getSpAtkStage();
        spDefStage = s.getSpDefStage();
        speStage = s.getSpeStage();

        atkRatio = determinePowerRatio(atkStage);
        defRatio = determinePowerRatio(defStage);
        spAtkRatio = determinePowerRatio(spAtkStage);
        spDefRatio = determinePowerRatio(spDefStage);
        speRatio = determinePowerRatio(speStage);

        accuracy = s.getAccuracy();
        evasion = s.getEvasion();
        this.currHp = s.getCurrHp();
    }

    @Override
    public void decrementAtk() {
        if (atkStage > STAGE_NEG_SIX) {
            atkStage--;
            atkRatio = determinePowerRatio(atkStage);
        }
    }

    @Override
    public void decrementDef() {
        if (defStage > STAGE_NEG_SIX) {
            defStage--;
            defRatio = determinePowerRatio(defStage);
        }
    }

    @Override
    public void decrementSpAtk() {
        if (spAtkStage > STAGE_NEG_SIX) {
            spAtkStage--;
            spAtkRatio = determinePowerRatio(spAtkStage);
        }
    }

    @Override
    public void decrementSpDef() {
        if (spDefStage > STAGE_NEG_SIX) {
            spDefStage--;
            spDefRatio = determinePowerRatio(spDefStage);
        }
    }

    @Override
    public void decrementSpe() {
        if (speStage > STAGE_NEG_SIX) {
            speStage--;
            speRatio = determinePowerRatio(speStage);
        }
    }

    @Override
    public void decrementAccuracy() {
        if (accuracyStage > STAGE_NEG_SIX) {
            accuracyStage--;
            accuracy = determineHittingRatio(accuracyStage);
        }
    }

    @Override
    public void decrementEvasion() {
        if (evasionStage > STAGE_NEG_SIX) {
            evasionStage--;
            evasion = determineHittingRatio(evasionStage);
        }
    }

    @Override
    public void decrementAtk(int decrease) {
        if (atkStage > STAGE_NEG_SIX) {
            atkStage = decrementStat(atkStage, decrease);
            atkRatio = determinePowerRatio(atkStage);
        }
    }

    @Override
    public void decrementDef(int decrease) {
        if (defStage > STAGE_NEG_SIX) {
            defStage = decrementStat(defStage, decrease);
            defRatio = determinePowerRatio(defStage);
        }
    }

    @Override
    public void decrementSpAtk(int decrease) {
        if (spAtkStage > STAGE_NEG_SIX) {
            spAtkStage = decrementStat(spAtkStage, decrease);
            spAtkRatio = determinePowerRatio(spAtkStage);
        }
    }

    @Override
    public void decrementSpDef(int decrease) {
        if (spDefStage > STAGE_NEG_SIX) {
            spDefStage = decrementStat(spDefStage, decrease);
            spDefRatio = determinePowerRatio(spDefStage);
        }
    }

    @Override
    public void decrementSpe(int decrease) {
        if (speStage > STAGE_NEG_SIX) {
            speStage = decrementStat(speStage, decrease);
            speRatio = determinePowerRatio(speStage);
        }
    }

    @Override
    public void decrementAccuracy(int decrease) {
        if (accuracyStage > STAGE_NEG_SIX) {
            accuracyStage = decrementStat(accuracyStage, decrease);
            accuracy = determineHittingRatio(accuracyStage);
        }
    }

    @Override
    public void decrementEvasion(int decrease) {
        if (evasionStage > STAGE_NEG_SIX) {
            evasionStage = decrementStat(evasionStage, decrease);
            evasion = determineHittingRatio(evasionStage);
        }
    }

    @Override
    public int getMaxHp() {
        return maxHp;
    }

    @Override
    public int getCurrHp() {
        return currHp;
    }

    @Override
    public double getAccuracy() {
        return accuracy;
    }

    @Override
    public double getEvasion() {
        return evasion;
    }

    @Override
    public int[] getCurrStats() {
        int[] result = new int[GEN_II_NUM_STATS];

        result[MAX_HP] = currHp;
        result[ATK] = (int) (atkRatio * atk);
        result[DEF] = (int) (defRatio * def);
        result[SPATK] = (int) (spAtkRatio * spAtk);
        result[SPDEF] = (int) (spDefRatio * spDef);
        result[SPE] = (int) (speRatio * spe);
        return result;
    }

    @Override
    public void setCurrHp(int currHp) {
        if (currHp < 0) {
            this.currHp = 0;
        } else if (currHp > maxHp) {
        	this.currHp = this.maxHp;
        } else {
            this.currHp = currHp;
        }
    }

    @Override
    public void setStats(int hp, int atk, int def, int spAtk, int spDef,
            int spe) {
        maxHp = hp;
        currHp = hp;
        this.atk = atk;
        this.def = def;
        this.spAtk = spAtk;
        this.spDef = spDef;
        this.spe = spe;
    }

    @Override
    public void setStats(int[] stats) {
        maxHp = stats[MAX_HP];
        currHp = maxHp;
        atk = stats[ATK];
        def = stats[DEF];
        spAtk = stats[SPATK];
        spDef = stats[SPDEF];
        spe = stats[SPE];
    }

    @Override
    public void incrementAtk() {
        if (atkStage < STAGE_SIX) {
            atkStage++;
            atkRatio = determinePowerRatio(atkStage);
        }
    }

    @Override
    public void incrementDef() {
        if (defStage < STAGE_SIX) {
            defStage++;
            defRatio = determinePowerRatio(defStage);
        }
    }

    @Override
    public void incrementSpAtk() {
        if (speStage < STAGE_SIX) {
            spAtkStage++;
            spAtkRatio = determinePowerRatio(spAtkStage);
        }
    }

    @Override
    public void incrementSpDef() {
        if (spDefStage < STAGE_SIX) {
            spDefStage++;
            spDefRatio = determinePowerRatio(spDefStage);
        }
    }

    @Override
    public void incrementSpe() {
        if (speStage < STAGE_SIX) {
            speStage++;
            speRatio = determinePowerRatio(speStage);
        }
    }

    @Override
    public void incrementAccuracy() {
        if (accuracyStage < STAGE_SIX) {
            accuracyStage++;
            accuracy = determineHittingRatio(accuracyStage);
        }
    }

    @Override
    public void incrementEvasion() {
        if (evasionStage < STAGE_SIX) {
            evasionStage++;
            evasion = determineHittingRatio(evasionStage);
        }
    }

    @Override
    public void incrementAtk(int increase) {
        if (atkStage < STAGE_SIX) {
            atkStage = incrementStat(atkStage, increase);
            atkRatio = determinePowerRatio(atkStage);
        }
    }

    @Override
    public void incrementDef(int increase) {
        if (defStage < STAGE_SIX) {
            defStage = incrementStat(defStage, increase);
            defRatio = determinePowerRatio(defStage);
        }
    }

    @Override
    public void incrementSpAtk(int increase) {
        if (spAtkStage < STAGE_SIX) {
            spAtkStage = incrementStat(spAtkStage, increase);
            spAtkRatio = determinePowerRatio(spAtkStage);
        }
    }

    @Override
    public void incrementSpDef(int increase) {
        if (spDefStage < STAGE_SIX) {
            spDefStage = incrementStat(spDefStage, increase);
            spDefRatio = determinePowerRatio(spDefStage);
        }
    }

    @Override
    public void incrementSpe(int increase) {
        if (speStage < STAGE_SIX) {
            speStage = incrementStat(speStage, increase);
            speRatio = determinePowerRatio(speStage);
        }
    }

    @Override
    public void incrementAccuracy(int increase) {
        if (accuracyStage < STAGE_SIX) {
            accuracyStage = incrementStat(accuracyStage, increase);
            accuracy = determineHittingRatio(accuracyStage);
        }
    }

    @Override
    public void incrementEvasion(int increase) {
        if (evasionStage < STAGE_SIX) {
            evasionStage = incrementStat(evasionStage, increase);
            evasion = determineHittingRatio(evasionStage);
        }
    }

    @Override
    public void setStats(Stats newStat) {
        //this.hpIv = newStat.getHpIv();
        this.atkIv = newStat.getAtkIv();
        this.defIv = newStat.getDefIv();
        this.spAtkIv = newStat.getSpAtkIv();
        this.spDefIv = newStat.getSpDefIv();
        this.speIv = newStat.getSpeIv();
        this.hpEv = newStat.getHpEv();
        this.atkEv = newStat.getAtkEv();
        this.defEv = newStat.getDefEv();
        this.spAtkEv = newStat.getSpAtkEv();
        this.spDefEv = newStat.getSpDefEv();
        this.speEv = newStat.getSpeEv();
        reCalcStats();
        this.atkStage = newStat.getAtkStage();
        this.defStage = newStat.getDefStage();
        this.spAtkStage = newStat.getSpAtkStage();
        this.spDefStage = newStat.getSpDefStage();
        this.speStage = newStat.getSpeStage();
        this.accuracyStage = newStat.getAccuracyStage();
        this.evasionStage = newStat.getEvasionStage();
    }

    @Override
    public int[] getIvs() {
        int[] result = new int[GEN_II_NUM_STATS];
        result[MAX_HP] = hpIv;
        result[ATK] = atkIv;
        result[DEF] = defIv;
        result[SPATK] = spAtkIv;
        result[SPDEF] = spDefIv;
        result[SPE] = speIv;
        reCalcStats();
        return result;
    }

    @Override
    public int getHpIv() {
        return hpIv;
    }

    @Override
    public int getAtkIv() {
        return atkIv;
    }

    @Override
    public int getDefIv() {
        return defIv;
    }

    @Override
    public int getSpAtkIv() {
        return spAtkIv;
    }

    @Override
    public int getSpDefIv() {
        return spDefIv;
    }

    @Override
    public int getSpeIv() {
        return speIv;
    }

    @Override
    public int[] getEvs() {
        int[] result = new int[GEN_II_NUM_STATS];
        result[MAX_HP] = hpEv;
        result[ATK] = atkEv;
        result[DEF] = defEv;
        result[SPATK] = spAtkEv;
        result[SPDEF] = spDefEv;
        result[SPE] = speEv;
        return result;
    }

    @Override
    public int getHpEv() {
        return hpEv;
    }

    @Override
    public int getAtkEv() {
        return atkEv;
    }

    @Override
    public int getDefEv() {
        return defEv;
    }

    @Override
    public int getSpAtkEv() {
        return spAtkEv;
    }

    @Override
    public int getSpDefEv() {
        return spDefEv;
    }

    @Override
    public int getSpeEv() {
        return speEv;
    }

    @Override
    public void setHpIv(int hpIv) {
        this.hpIv = hpIv;
        reCalcStats();
    }

    @Override
    public void setAtkIv(int atkIv) {
        this.atkIv = atkIv;
        reCalcStats();
    }

    @Override
    public void setDefIv(int defIv) {
        this.defIv = defIv;
        reCalcStats();
    }

    @Override
    public void setSpAtkIv(int spAtkIv) {
        this.spAtkIv = spAtkIv;
        reCalcStats();
    }

    @Override
    public void setSpDefIv(int spDefIv) {
        this.spDefIv = spDefIv;
        reCalcStats();
    }

    @Override
    public void setSpeIv(int speIv) {
        this.speIv = speIv;
        reCalcStats();
    }

    @Override
    public void setHpEv(int hpEv) {
        this.hpEv = hpEv;
        reCalcStats();
    }

    @Override
    public void setAtkEv(int atkEv) {
        this.atkEv = atkEv;
        reCalcStats();
    }

    @Override
    public void setDefEv(int defEv) {
        this.defEv = defEv;
        reCalcStats();
    }

    @Override
    public void setSpAtkEv(int spAtkEv) {
        this.spAtkEv = spAtkEv;
        reCalcStats();
    }

    @Override
    public void setSpDefEv(int spDefEv) {
        this.spDefEv = spDefEv;
        reCalcStats();
    }

    @Override
    public void setSpeEv(int speEv) {
        this.speEv = speEv;
        reCalcStats();
    }

    @Override
    public int getAtkStage() {
        return atkStage;
    }

    @Override
    public int getDefStage() {
        return defStage;
    }

    @Override
    public int getSpAtkStage() {
        return spAtkStage;
    }

    @Override
    public int getSpDefStage() {
        return spDefStage;
    }

    @Override
    public int getSpeStage() {
        return speStage;
    }

    @Override
    public int getAccuracyStage() {
        return accuracyStage;
    }

    @Override
    public int getEvasionStage() {
        return evasionStage;
    }

    @Override
    public void setAtkStage(int atkStage) {
        this.atkStage = keepWithInRange(atkStage);
    }

    @Override
    public void setDefStage(int defStage) {
        this.defStage = keepWithInRange(defStage);
    }

    @Override
    public void setSpAtkStage(int spAtkStage) {
        this.spAtkStage = keepWithInRange(spAtkStage);
    }

    @Override
    public void setSpDefStage(int spDefStage) {
        this.spDefStage = keepWithInRange(spDefStage);
    }

    @Override
    public void setSpeStage(int speStage) {
        this.speStage = keepWithInRange(speStage);
    }

    @Override
    public void setAccuracyStage(int accuracyStage) {
        this.accuracyStage = keepWithInRange(accuracyStage);
        accuracy = determineHittingRatio(accuracyStage);
    }

    @Override
    public void setEvasionStage(int evasionStage) {
        this.evasionStage = keepWithInRange(evasionStage);
        evasion = determineHittingRatio(this.evasionStage);
    }

    @Override
    public int getHiddenPowerBasePower() {
        return hiddenPowerBasePower;
    }

    @Override
    public Type getHiddenPowerType() {
        return hiddenPowerType;
    }

    private int keepWithInRange(int newValue) {
        int result = newValue;
        if (result > STAGE_SIX) {
            result = STAGE_SIX;
        } else if (result < STAGE_NEG_SIX) {
            result = STAGE_NEG_SIX;
        }
        return result;
    }

    private void reCalcStats() {
        int ivs[] = {hpIv, atkIv, defIv, spAtkIv, spDefIv, speIv};
        int evs[] = {hpEv, atkEv, defEv, spAtkEv, spDefEv, speEv};

        int[] stats = PokemonMath.calcPokemon(level, nature, baseStats, ivs,
                evs);

        hiddenPowerBasePower = PokemonMath.calcHiddenPowerBasePower(hpIv, atkIv,
                defIv, spAtkIv, spDefIv, speIv);
        hiddenPowerType = PokemonMath.calcHiddenPower(hpIv, atkIv, defIv,
                spAtkIv, spDefIv, speIv);
        
        // HACK for keeping hp saved
        if (currHp == maxHp) {
            maxHp = stats[MAX_HP];
            currHp = maxHp;
        }
        else {
            maxHp = stats[MAX_HP];
        }
        atk = stats[ATK];
        def = stats[DEF];
        spAtk = stats[SPATK];
        spDef = stats[SPDEF];
        spe = stats[SPE];
    }

    private int incrementStat(int old, int increase) {
        old += increase;
        if (old > STAGE_SIX) {
            old = STAGE_SIX;
        }
        return old;
    }

    private int decrementStat(int old, int decrease) {
        old -= decrease;
        if (old < STAGE_NEG_SIX) {
            old = STAGE_NEG_SIX;
        }
        return old;
    }

    private double determinePowerRatio(int stage) {
        double result = 1.0;

        if (stage == STAGE_NEG_SIX) {
            result = POWER_MINUS_SIX;
        } else if (stage == STAGE_NEG_FIVE) {
            result = POWER_MINUS_FIVE;
        } else if (stage == STAGE_NEG_FOUR) {
            result = POWER_MINUS_FOUR;
        } else if (stage == STAGE_NEG_THREE) {
            result = POWER_MINUS_THREE;
        } else if (stage == STAGE_NEG_TWO) {
            result = POWER_MINUS_TWO;
        } else if (stage == STAGE_NEG_ONE) {
            result = POWER_MINUS_ONE;
        } else if (stage == STAGE_ONE) {
            result = POWER_PLUS_ONE;
        } else if (stage == STAGE_TWO) {
            result = POWER_PLUS_TWO;
        } else if (stage == STAGE_THREE) {
            result = POWER_PLUS_THREE;
        } else if (stage == STAGE_FOUR) {
            result = POWER_PLUS_FOUR;
        } else if (stage == STAGE_FIVE) {
            result = POWER_PLUS_FIVE;
        } else if (stage == STAGE_SIX) {
            result = POWER_PLUS_SIX;
        }

        return result;
    }

    private double determineHittingRatio(int stage) {
        double result = 1.0;

        if (stage == STAGE_NEG_SIX) {
            result = HIT_MINUS_SIX;
        } else if (stage == STAGE_NEG_FIVE) {
            result = HIT_MINUS_FIVE;
        } else if (stage == STAGE_NEG_FOUR) {
            result = HIT_MINUS_FOUR;
        } else if (stage == STAGE_NEG_THREE) {
            result = HIT_MINUS_THREE;
        } else if (stage == STAGE_NEG_TWO) {
            result = HIT_MINUS_TWO;
        } else if (stage == STAGE_NEG_ONE) {
            result = HIT_MINUS_ONE;
        } else if (stage == STAGE_ONE) {
            result = HIT_PLUS_ONE;
        } else if (stage == STAGE_TWO) {
            result = HIT_PLUS_TWO;
        } else if (stage == STAGE_THREE) {
            result = HIT_PLUS_THREE;
        } else if (stage == STAGE_FOUR) {
            result = HIT_PLUS_FOUR;
        } else if (stage == STAGE_FIVE) {
            result = HIT_PLUS_FIVE;
        } else if (stage == STAGE_SIX) {
            result = HIT_PLUS_SIX;
        }

        return result;
    }

    @Override
    public void setHpBase(int hpBase) {
        baseStats[MAX_HP] = hpBase;
        reCalcStats();
    }

    @Override
    public void setAtkBase(int atkBase) {
        baseStats[ATK] = atkBase;
        reCalcStats();
    }

    @Override
    public void setDefBase(int defBase) {
        baseStats[DEF] = defBase;
        reCalcStats();
    }

    @Override
    public void setSpAtkBase(int spAtkBase) {
        baseStats[SPATK] = spAtkBase;
        reCalcStats();
    }

    @Override
    public void setSpDefBase(int spDefBase) {
        baseStats[SPDEF] = spDefBase;
        reCalcStats();
    }

    @Override
    public void setSpeBase(int speBase) {
        baseStats[SPE] = speBase;
        reCalcStats();
    }

    @Override
    public int getHpBase() {
        return baseStats[MAX_HP];
    }

    @Override
    public int getAtkBase() {
        return baseStats[ATK];
    }

    @Override
    public int getDefBase() {
        return baseStats[DEF];
    }

    @Override
    public int getSpAtkBase() {
        return baseStats[SPATK];
    }

    @Override
    public int getSpDefBase() {
        return baseStats[SPDEF];
    }

    @Override
    public int getSpeBase() {
        return baseStats[SPE];
    }

    @Override
    public void setNature(Nature nature) {
        this.nature = nature;
        reCalcStats();
    }

    @Override
    public Nature getNature() {
        return nature;
    }

    @Override
    public void setEvs(int[] evs) {
        hpEv = evs[MAX_HP];
        atkEv = evs[ATK];
        defEv = evs[DEF];
        spAtkEv = evs[SPATK];
        spDefEv = evs[SPDEF];
        speEv = evs[SPE];
        reCalcStats();
    }

    @Override
    public int[] getBaseStats() {
        return baseStats;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
        reCalcStats();
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setIvs(int[] ivs) {
        hpIv = ivs[MAX_HP];
        atkIv = ivs[ATK];
        defIv = ivs[DEF];
        spAtkIv = ivs[SPATK];
        spDefIv = ivs[SPDEF];
        speIv = ivs[SPE];
        reCalcStats();
    }

    @Override
    public int getAtk() {
        return atk;
    }

    @Override
    public int getDef() {
        return def;
    }

    @Override
    public int getSpAtk() {
        return spAtk;
    }

    @Override
    public int getSpDef() {
        return spDef;
    }

    @Override
    public int getSpe() {
        return spe;
    }

	@Override
	public void setBaseStats(int[] baseStats) {
		this.baseStats[CURR_HP] = baseStats[CURR_HP];
		this.baseStats[ATK] = baseStats[ATK];
		this.baseStats[DEF] = baseStats[DEF];
		this.baseStats[SPATK] = baseStats[SPATK];
		this.baseStats[SPDEF] = baseStats[SPDEF];
		this.baseStats[SPE] = baseStats[SPE];
	}

	@Override
	public String getStatAt(int position) {
		String stat = "Spe";
		if (position == 0) {
			stat = "HP";
		} else if (position == 1) {
			stat = "Atk";
		} else if (position == 2) {
			stat = "Def";
		}  else if (position == 3) {
			stat = "SAtk";
		}  else if (position == 4) {
			stat = "Atk";
		}
		return stat;
	}
}
