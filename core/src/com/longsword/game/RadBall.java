package com.longsword.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class RadBall extends Person {

    public RadBall(String name, ObjectType objectType, TextureRegion region, int health, int damage) {
        super(name, objectType, region, health, damage);
        setXVelocity(-5f);
        setYVelocity(-5f);
        setPosition(400, 200);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (Math.abs(getXVelocity()) == 0)
            setXVelocity(0);

        if (Math.abs(getYVelocity()) == 0)
            setYVelocity(0);


        moveBy(getXVelocity(), getYVelocity());

        if ((getX() + getWidth() > 800f) && !isDirectionLeft()) {
            setXVelocity(-getXVelocity());
            setXVelocity(getXVelocity()+1);
            setDirectionLeft(true);
        }

        if (getY() + getHeight() > 480f) {
            setYVelocity(-getYVelocity());
        }

        if ((getX() < 0) && isDirectionLeft()) {
            setXVelocity(Math.abs(getXVelocity()));
            setXVelocity(getXVelocity()-1);
            setDirectionLeft(false);

        }

        if (getY() < 0) {
            setYVelocity(Math.abs(getYVelocity()));
        }

    }
}
