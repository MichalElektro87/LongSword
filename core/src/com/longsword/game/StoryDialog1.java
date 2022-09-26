package com.longsword.game;

import com.badlogic.gdx.graphics.g2d.Batch;

public class StoryDialog1 extends DialogBox {

    private LongSword game;
    public StoryDialog1(LongSword game) {
        super(game);
        this.game = game;
        setPosition(10f, 440f);
        setSpeedLetterAppearance(0.1f);
        setFont(game.storyFont);
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {

        getFont().draw(batch, getText(), getX(), getY(), 800f - 20f,1,true);
    }

    public void setDialog() {
        getDialogArray().add("The world resources have run out. Superpowers focused on colonizing moon to bring out " +
                "the hellium 3 to deliver new source of energy. Due to another space wars competition a terrible " +
                "nuclear war has broken out. Almost whole of the nuclear arsenal was used. The world has become a " +
                "inhospitable place to live. But there was hope... \n" +
                "On earth have formed strange radiation balls capable to deliver some energy to warm up and " +
                "light cities. The only issue with this ball was they must be in motion to do they work. If they stop " +
                "annihilation in approx 5 km happen...");
        getDialogDuration(0);
    }

    @Override
    public void update() {

        if (getElapsedTime() > dialogDuration + 5f) {
            dialogEnded = true;
        }
    }
}
