package com.omnidex.battlefield.team;

/**
 * @author jakers
 */
public class FieldScreen implements Screen {
    private boolean hasReflect;
    private boolean hasLightScreen;
    
    private int lightScreenCount;
    private int reflectScreenCount;

    public FieldScreen() {
        hasReflect = false;
        hasLightScreen = false;
        lightScreenCount = 0;
        reflectScreenCount = 0;
    }
    
    public FieldScreen(Screen screen) {
    	hasReflect = screen.hasRelfect();
    	hasLightScreen = screen.hasLightScreen();
    	lightScreenCount = screen.getLightScreenCount();
    	reflectScreenCount = screen.getReflectCount();
    }

    @Override
    public void setReflect(int duration) {
        hasReflect = true;
        reflectScreenCount = duration;
    }

    @Override
    public void setLightScreen(int duration) {
        hasLightScreen = true;
        lightScreenCount = duration;
    }

    @Override
    public void removeRelfect() {
        hasReflect = false;
    }

    @Override
    public void removeLightScreen() {
        hasLightScreen = false;
    }

    @Override
    public void removeBoth() {
        hasReflect = false;
        hasLightScreen = false;
    }

    @Override
    public boolean hasRelfect() {
        return hasReflect;
    }

    @Override
    public boolean hasLightScreen() {
        return hasLightScreen;
    }

	@Override
	public void decrementLightScreen() {
		if (lightScreenCount > 0) {
			lightScreenCount--;
			if (lightScreenCount == 0) {
				// TODO verify text string
				System.out.println("The light screen fades!");
			}
		}
	}

	@Override
	public void decrementRelfect() {
		if (reflectScreenCount > 0) {
			reflectScreenCount--;
			if (reflectScreenCount == 0) {
				// TODO verify text string
				System.out.println("The light screen fades!");
			}
		}
	}

	@Override
	public int getLightScreenCount() {
		return lightScreenCount;
	}

	@Override
	public int getReflectCount() {
		return reflectScreenCount;
	}
}
