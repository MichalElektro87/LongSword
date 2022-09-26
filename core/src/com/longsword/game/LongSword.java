package com.longsword.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class LongSword extends Game {

	public BitmapFont inGameFont, titleFont, tapFont, storyFont;
	public int score = 0;
	public int health = 100;
	
	@Override
	public void create () {
		inGameFont = new BitmapFont(Gdx.files.internal("fonts/inGameFont.fnt"));
		titleFont = new BitmapFont(Gdx.files.internal("fonts/titleFont.fnt"));
		tapFont = new BitmapFont(Gdx.files.internal("fonts/tapFont.fnt"));
		storyFont = new BitmapFont(Gdx.files.internal("fonts/storyFont.fnt"));

		this.setScreen(new StartScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {

	}
}
