package com.longsword.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameScreen implements Screen {

    private final LongSword game;
    private Stage stage;
    private Player player;
    private BigOrc bigOrc;
    private AnimationOfActors animationOfActors;

    public GameScreen(final LongSword game) {
        this.game = game;
    }

    @Override
    public void show() {
        stage = new Stage(new FitViewport(800f, 480f));
        animationOfActors = new AnimationOfActors();
        player = new Player("Hero", ObjectType.PLAYER, animationOfActors.getPlayerAnimation(),200, 20);
        //bigOrc = new BigOrc("BigOrc", ObjectType.ENEMY,300, 10);

        stage.addActor(player);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();


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
