package com.omnidex.battlefield.team;

import com.omnidex.damage.MathUtils;

public class FieldScreen implements Screen {

	private int lightScreenCount;
	private int reflectScreenCount;

	public FieldScreen() {
		lightScreenCount = 0;
		reflectScreenCount = 0;
	}

	public FieldScreen(Screen screen) {
		lightScreenCount = screen.getLightScreenCount();
		reflectScreenCount = screen.getReflectCount();
	}

	@Override
	public void setReflect(int duration) {
		reflectScreenCount = duration;
	}

	@Override
	public void setLightScreen(int duration) {
		lightScreenCount = duration;
	}

	@Override
	public void removeReflect() {
		reflectScreenCount = 0;
	}

	@Override
	public void removeLightScreen() {
		lightScreenCount = 0;
	}

	@Override
	public void removeBoth() {
		removeLightScreen();
		removeReflect();
	}

	@Override
	public boolean hasRelfect() {
		return reflectScreenCount > 0;
	}

	@Override
	public boolean hasLightScreen() {
		return lightScreenCount > 0;
	}

	@Override
	public void decrementLightScreen() {
		lightScreenCount = MathUtils.decrement(lightScreenCount);
	}

	@Override
	public void decrementRelfect() {
		reflectScreenCount = MathUtils.decrement(reflectScreenCount);
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
