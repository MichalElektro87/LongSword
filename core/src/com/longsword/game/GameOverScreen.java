package com.longsword.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.longsword.game.music.MusicLibrary;
import com.longsword.game.title.EndGameTextActor;
import com.longsword.game.title.TapActor;

public class GameOverScreen implements Screen {

    private final LongSword game;
    private Stage stage;
    private EndGameTextActor endGameTextActor;
    private TapActor tapActor;
    private boolean tapActorAdded = false;

    public GameOverScreen (final LongSword game) {
        this.game = game;
        stage = new Stage(new FitViewport(800, 480));
        endGameTextActor = new EndGameTextActor(game);
        endGameTextActor.resetDialogBox();
        endGameTextActor.setDialog();
        tapActor = new TapActor(game);
        tapActor.setPosition(200, 50);
        stage.addActor(endGameTextActor);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();

        endGameTextActor.setText(endGameTextActor.getDialog(0));

        if (endGameTextActor.dialogEnded && !tapActorAdded) {
            stage.addActor(tapActor);
            tapActorAdded = true;
        }

        if ((Gdx.input.isTouched() || Gdx.input.isKeyPressed(Input.Keys.ENTER)) && tapActorAdded) {

            game.health = 100;
            game.score = 0;

            game.setScreen(new GameScreen(game));

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
