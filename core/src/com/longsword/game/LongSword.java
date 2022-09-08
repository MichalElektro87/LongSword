package com.longsword.game;

import com.badlogic.gdx.Game;

public class LongSword extends Game {

	
	@Override
	public void create () {
		setScreen(new GameScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {

	}
}
