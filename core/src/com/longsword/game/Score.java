package com.longsword.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Score extends Actor {

    private final LongSword game;
    public Score (final LongSword game) {
        this.game = game;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        super.draw(batch, parentAlpha);
        game.inGameFont.draw(batch, "Score: " + game.score, 50, 460);
    }
}
