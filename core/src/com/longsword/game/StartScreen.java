package com.longsword.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.longsword.game.title.Letter;
import com.longsword.game.title.TapActor;
import com.longsword.game.StoryScreen;

public class StartScreen implements Screen {

    private final LongSword game;
    private Stage stage;
    private Array<Letter> letters;
    private Letter r,a1,d,i1,a2,t,i3,o,n,space1,space2,b,a3,l1,l2;
    private RadBall radBall;
    private TapActor tapActor;
    private boolean tapActorAdded = false;


    public StartScreen (final LongSword game) {
        this.game = game;

    }

    @Override
    public void show() {

        radBall = new RadBall("RadBallYellow",ObjectType.ENEMY,
                new TextureRegion(new Texture(Gdx.files.internal("balls/rad_ball_1.png"))),100,
                5);
        stage = new Stage(new FitViewport(800, 480));
        letters = new Array<>();
        r = new Letter(game, "R",radBall);
        a1 = new Letter(game, "a", radBall);
        d = new Letter(game, "d",radBall);
        i1 = new Letter(game, "i",radBall);
        a2 = new Letter(game, "a",radBall);
        t = new Letter(game, "t",radBall);
        i3 = new Letter(game, "i",radBall);
        o = new Letter(game, "o",radBall);
        n = new Letter(game, "n",radBall);
        space1 = new Letter(game," ",radBall);
        space2 = new Letter(game," ",radBall);
        b = new Letter(game, "b",radBall);
        a3 = new Letter(game, "a",radBall);
        l1 = new Letter(game, "l",radBall);
        l2 = new Letter(game, "l",radBall);
        tapActor = new TapActor(game);

        letters.add(r);
        letters.add(a1);
        letters.add(d);
        letters.add(i1);
        letters.add(a2);
        letters.add(t);
        letters.add(i3);
        letters.add(o);
        letters.add(n);
        letters.add(space1);
        letters.add(space2);
        letters.add(b);
        letters.add(a3);
        letters.add(l1);
        letters.add(l2);
        game.titleFont.setFixedWidthGlyphs("l");

        for (int i = 0; i < letters.size; i++) {

            letters.get(i).setX(40);

            if (letters.get(i).getTextForLetter().compareTo("i") == 0) {
                letters.get(i).setPosition(letters.get(i).getX() + 50 * i + 10, letters.get(i).getY());
                stage.addActor(letters.get(i));
                continue;
            }
            letters.get(i).setPosition(letters.get(i).getX() + 50 * i , letters.get(i).getY());
            stage.addActor(letters.get(i));

        }

        for (int i = 0; i < letters.size; i ++) {
            if (i % 2 == 0) {
                letters.get(i).setY(-1000);
            }
            else {
                letters.get(i).setY(1000);
            }

            letters.get(i).addAction(Actions.moveTo(letters.get(i).getX(), 300 + game.titleFont.getLineHeight() / 2,
                    4f, Interpolation.swingOut));
        }

        tapActor.setPosition(200, 50);
        stage.addActor(radBall);

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();

        if (!letters.get(0).hasActions() && !tapActorAdded) {
            stage.addActor(tapActor);
            tapActorAdded = true;
        }

        if ((Gdx.input.isTouched() || Gdx.input.isKeyPressed(Input.Keys.ENTER)) && !letters.get(0).hasActions()) {
            game.setScreen(new StoryScreen(game));
        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
