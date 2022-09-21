package com.longsword.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameScreen implements Screen {

    private final LongSword game;
    private Stage stage;
    private Player player;
    private RadBall radBall;
    private AnimationOfActors animationOfActors;

    public GameScreen(final LongSword game) {
        this.game = game;
    }

    @Override
    public void show() {
        stage = new Stage(new FitViewport(800f, 480f));
        animationOfActors = new AnimationOfActors();
        player = new Player("Hero", ObjectType.PLAYER, animationOfActors.getPlayerAnimation(), 200,
                20);
        player.setStage(stage);

        radBall = new RadBall("RadBallYellow",ObjectType.ENEMY,
                new TextureRegion(new Texture(Gdx.files.internal("balls/rad_ball_1.png"))),100,
                5);
        radBall.setStage(stage);
        radBall.addAction(Actions.forever(Actions.rotateBy(5f)));

        stage.addActor(player);
        stage.addActor(radBall);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();


        if (player.isAttackBlock()) {
                if (player.isDirectionLeft()) {
                    if (player.getLeftAttackRectangle().overlaps(radBall.getCollisionRectangle())) {
                        if (player.isCanAttack()) {
                            player.setCanAttack(false);
                            if (radBall.getXVelocity() > 0) {
                                radBall.setXVelocity(-radBall.getXVelocity());
                            } else {
                                radBall.setXVelocity(radBall.getXVelocity() - 1);
                            }
                        }
                    }
                }
                if (player.getRightAttackRectangle().overlaps(radBall.getCollisionRectangle())) {
                    if (player.isCanAttack()) {
                        player.setCanAttack(false);
                        if (radBall.getXVelocity() < 0) {
                            radBall.setXVelocity(Math.abs(radBall.getXVelocity()));
                        } else {
                            radBall.setXVelocity(radBall.getXVelocity() + 1);
                        }
                    }
                }
        }

    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
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
