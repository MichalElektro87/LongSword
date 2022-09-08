package com.longsword.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import java.security.Key;

public class Player extends Person {

    private float elapsedAttackBlockTime = 0f;

    public Player(String name, ObjectType objectType, Array<Animation<TextureRegion>> animation, int health, int damage) {
        super(name, objectType,animation,health, damage);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (!isAttackBlock()) {

            if (!Gdx.input.isKeyPressed(Input.Keys.A) || !Gdx.input.isKeyPressed(Input.Keys.A) || !Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
                if (isDirectionLeft())
                    setCurrentAnimation(0);
                else
                    setCurrentAnimation(1);
            }

            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                setDirectionLeft(true);
                setCurrentAnimation(2);
                moveBy(-1f, 0f);
            }

            if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                setDirectionLeft(false);
                setCurrentAnimation(3);
                moveBy(1f, 0f);
            }
        }

        else {
            if (getElapsedTime() > getAnimation().get(4).getAnimationDuration()) {
                setAttackBlock(false);
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE) && !isAttackBlock()) {
            setAttackBlock(true);
            setElapsedTime(0f);
            if (isDirectionLeft())
                setCurrentAnimation(4);
            else
                setCurrentAnimation(5);
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }
}
