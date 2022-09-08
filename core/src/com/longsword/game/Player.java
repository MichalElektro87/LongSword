package com.longsword.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.security.Key;

public class Player extends Person {
    public Player(String name, ObjectType objectType, Animation<TextureRegion> animation, int health, int damage) {
        super(name, objectType,animation, health, damage);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            moveBy(-1f, 0f);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            moveBy(1f, 0f);
        }

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }
}
