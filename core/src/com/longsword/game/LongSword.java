package com.longsword.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LongSword extends ApplicationAdapter {

	
	@Override
	public void create () {
		new GameScreen(this);
	}

	@Override
	public void render () {

	}
	
	@Override
	public void dispose () {

	}
}
