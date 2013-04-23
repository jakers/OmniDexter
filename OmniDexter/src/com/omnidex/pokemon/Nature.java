package com.omnidex.pokemon;

/**
 * An enum containing all the natures a Pokemon could
 * have.
 * @author jakers
 */
public enum Nature {
		UNKNOWN("(unknown)",1.0,1.0,1.0,1.0,1.0),
		ADAMANT("Adamant",1.1,1.0,0.9,1.0,1.0),
		BASHFUL("Bashful",1.0,1.0,1.0,1.0,1.0),
		BOLD("Bold",0.9,1.1,1.0,1.0,1.0),
		BRAVE("Brave",1.1,1.0,1.0,1.0,0.9),
		CALM("Calm",0.9,1.0,1.0,1.1,1.0),
		CAREFUL("Careful",1.0,1.0,0.9,1.1,1.0),
		DOCILE("Docile",1.0,1.0,1.0,1.0,1.0),
		GENTLE("Gentle",1.0,0.9,1.0,1.1,1.0),
		HARDY("Hardy",1.0,1.0,1.0,1.0,1.0),
		HASTY("Hasty",1.0,0.9,1.0,1.0,1.1),
		IMPISH("Impish",1.0,1.1,0.9,1.0,1.0),
		JOLLY("Jolly",1.0,1.0,0.9,1.0,1.1),
		LAX("Lax",1.0,1.1,1.0,0.9,1.0),
		LONELY("Lonely",1.1,0.9,1.0,1.0,1.0),
		MILD("Mild",1.0,0.9,1.1,1.0,1.0),
		MODEST("Modest",0.9,1.0,1.1,1.0,1.0),
		NAIVE("Naive",1.0,1.0,1.0,0.9,1.1),
		NAUGHTY("Naughty",1.1,1.0,1.0,0.9,1.0),
		OTHER("Other",0.0,0.0,0.0,0.0,0.0),
		QUIET("Quiet",1.0,1.0,1.1,1.0,0.9),
		QUIRKY("Quirky",1.0,1.0,1.0,1.0,1.0),
		RASH("Rash",1.0,1.0,1.1,0.9,1.0),
		RELAXED("Relaxed" ,1.0,1.1,1.0,1.0,0.9),
		SASSY("Sassy", 1.0,1.0,1.0,1.1,0.9),
		SERIOUS("Serious",1.0,1.0,1.0,1.0,1.0),
		TIMID("Timid",0.9,1.0,1.0,1.0,1.1);	
		
		private String nature;
		private String mods;
		private double atkMod;
		private double defMod;
		private double spAtkMod;
		private double spDefMod;
		private double speMod;
		
        Nature(String nature, double atkMod, double defMod,
        	   double spAtkMod, double spDefMod, double speMod) {
        	
        	this.nature = nature;
        	this.atkMod = atkMod;
        	this.defMod = defMod;
        	this.spAtkMod = spAtkMod;
        	this.spDefMod = spDefMod;
        	this.speMod = speMod;
		}
        
        public static Nature findNatureByName(String name) {
	    	Nature nature = null;
	    	for (Nature n : Nature.values()) {
	    		if (n.toString().toLowerCase().equals(name.toLowerCase())) {
	    			nature = n;   			
	    			break;
	    		}
	    	}
	    	return nature;
	    }
        
        
        @Override
        public String toString() {
        	return nature;
        }
        public double getAtkMod() {
        	return atkMod;
        }
        public double getDefMod(){
        	return defMod;
        }
        public double getSpAtkMod(){
        	return spAtkMod;
        }
        public double getSpDefMod(){
        	return spDefMod;
        }
        public double getSpeMod(){
        	return speMod;
        }
        public double[] getStatMods() {
        	return new double[] {atkMod, defMod, spAtkMod, spDefMod, speMod};
        }
        public String getMods() {
        	return mods;
        }
	}
