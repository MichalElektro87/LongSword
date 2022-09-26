package com.longsword.game.title;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.longsword.game.LongSword;
import com.longsword.game.RadBall;


public class Letter extends Actor {

    private final LongSword game;
    private String textForLetter;
    private GlyphLayout glyphLayout;
    private RadBall radBall;
    private Rectangle rectangle;
    private boolean marked = false;

    public Letter (final LongSword game, String textForLetter, RadBall radBall) {
        this.game = game;
        this.textForLetter = textForLetter;
        glyphLayout = new GlyphLayout(game.titleFont,textForLetter);
        setSize(glyphLayout.width,glyphLayout.height);
        rectangle = new Rectangle(getX(),getY(), getWidth(),getHeight());
        this.radBall = radBall;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        rectangle.setPosition(getX(),getY());

        if (radBall.getCollisionRectangle().overlaps(rectangle)) {
            addAction(Actions.rotateBy(-90f, 0.5f));
            marked = true;
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        game.titleFont.draw(batch, textForLetter, getX(), getY());
    }

    public GlyphLayout getGlyphLayout () {
        return glyphLayout;
    }

    public String getTextForLetter () {
        return textForLetter;
    }
}
