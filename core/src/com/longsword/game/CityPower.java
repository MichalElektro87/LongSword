package com.longsword.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class CityPower extends Actor {

    private final LongSword game;
    private RadBall radBall;

    public CityPower (final LongSword game, RadBall radBall) {
        this.game = game;
        this.radBall = radBall;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        game.inGameFont.draw(batch, "City power: " + (Math.abs(radBall.getXVelocity() * 100)/5) + "%", 270, 460);
    }
}
