package com.longsword.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class RadBall extends Person {

    public RadBall(String name, ObjectType objectType, TextureRegion region, int health, int damage) {
        super(name, objectType, region, health, damage);
        setXVelocity(3f);
        setYVelocity(3f);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        moveBy(getXVelocity(), getYVelocity());

        if (getX() + getWidth() > 800f) {
            setXVelocity(-getXVelocity());
            setDirectionLeft(true);
        }

        if (getY() + getHeight() > 480f) {
            setYVelocity(-getYVelocity());
        }

        if (getX() < 0) {
            setXVelocity(Math.abs(getXVelocity()));
            setDirectionLeft(false);
        }

        if (getY() < 0) {
            setYVelocity(Math.abs(getYVelocity()));
        }

    }
}
