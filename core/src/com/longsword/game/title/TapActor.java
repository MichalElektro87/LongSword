package com.longsword.game.title;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.longsword.game.LongSword;

public class TapActor extends Actor {

    private final LongSword game;

    public TapActor (final LongSword game) {
        this.game = game;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        game.tapFont.draw(batch, "tap screen or press enter to power the city...", getX(), getY());
    }
}
