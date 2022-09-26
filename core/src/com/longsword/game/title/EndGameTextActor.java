package com.longsword.game.title;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.longsword.game.DialogBox;
import com.longsword.game.LongSword;

public class EndGameTextActor extends DialogBox {

    private LongSword game;
    public EndGameTextActor(LongSword game) {
        super(game);
        this.game = game;
        setPosition(10f, 300f);
        setSpeedLetterAppearance(0.1f);
        setFont(game.storyFont);
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {

        getFont().draw(batch, getText(), getX(), getY(), 800f - 20f,1,true);
    }

    public void setDialog() {
        getDialogArray().add("You have died\nThe city is now cold and dark.\nThe population has rapidly increased...");
        getDialogDuration(0);
    }

    @Override
    public void update() {

        if (getElapsedTime() > dialogDuration + 5f) {
            dialogEnded = true;
        }
    }
}

