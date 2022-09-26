package com.longsword.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.longsword.game.LongSword;
import com.longsword.game.StoryDialog1;
import com.longsword.game.title.TapActor;

public class StoryScreen implements Screen {

    private final LongSword game;
    private Stage stage;
    private StoryDialog1 storydialog1;
    private TapActor tapActor;

    private boolean dialogEnded = false;
    private float continueTextElapsedTime = 0.0f;

    public StoryScreen(final LongSword game) {
        this.game = game;
        stage = new Stage(new FitViewport(800, 480));
        storydialog1 = new StoryDialog1(game);
        tapActor = new TapActor(game);
        tapActor.setPosition(200, 50);
        storydialog1.resetDialogBox();
        storydialog1.setDialog();
        stage.addActor(storydialog1);
        stage.addActor(tapActor);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        continueTextElapsedTime+=Gdx.graphics.getDeltaTime();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();

        storydialog1.setText(storydialog1.getDialog(0));

        if (continueTextElapsedTime > 2f) {
            if ((Gdx.input.isTouched() || Gdx.input.isKeyPressed(Input.Keys.ENTER))) {
                game.setScreen(new GameScreen(game));
            }
        }


    }

    @Override
    public void resize(int width, int height) {

        stage.getViewport().update(width, height, true);
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
        stage.dispose();
    }
}
