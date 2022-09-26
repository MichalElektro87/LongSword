package com.longsword.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class PlayerHealth extends Actor {

    private final LongSword game;

    public PlayerHealth (final LongSword game) {
        this.game = game;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        game.inGameFont.draw(batch, "Health: " + game.health, 600, 460);
    }
}
