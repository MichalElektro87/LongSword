package com.longsword.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.longsword.game.music.MusicLibrary;
import com.longsword.game.sound.SoundLibrary;

public class GameScreen implements Screen {

    private final LongSword game;
    private Stage stage;
    private City city;
    private Reactor reactor;
    private LeftWall leftWall;
    private RightWall rightWall;
    private DownWall downWall;
    private UpWall upWall;
    private Player player;
    private RadBall radBall;
    private PlayerHealth playerHealth;
    private CityPower cityPower;
    private Score score;
    private AnimationOfActors animationOfActors;
    private SoundLibrary soundLibrary;
    private MusicLibrary musicLibrary;
    private boolean gameOverSequence = false;

    public GameScreen(final LongSword game) {
        this.game = game;
    }

    @Override
    public void show() {
        stage = new Stage(new FitViewport(800f, 480f));
        city = new City("City", ObjectType.NPC,
                new TextureRegion(new Texture(Gdx.files.internal("background/city.png"))), 0,0 );
        city.setPosition(201,220);
        reactor = new Reactor("Reactor", ObjectType.NPC,
                new TextureRegion(new Texture(Gdx.files.internal("background/reactor.png"))), 0,0);
        leftWall = new LeftWall("Left Wall", ObjectType.NPC,
                new TextureRegion(new Texture(Gdx.files.internal("background/leftWall.png"))), 0,0);
        rightWall = new RightWall("Right Wall", ObjectType.NPC,
                new TextureRegion(new Texture(Gdx.files.internal("background/rightWall.png"))), 0,0);
        rightWall.setPosition(800 - 15, 0);
        downWall = new DownWall("Down Wall", ObjectType.NPC,
                new TextureRegion(new Texture(Gdx.files.internal("background/downWall.png"))), 0,0);
        downWall.setPosition(15,0);
        upWall = new UpWall("Up Wall", ObjectType.NPC,
                new TextureRegion(new Texture(Gdx.files.internal("background/downWall.png"))), 0,0);
        upWall.setPosition(15,480-15);

        animationOfActors = new AnimationOfActors();
        player = new Player("Hero", ObjectType.PLAYER, animationOfActors.getPlayerAnimation(), 200,
                20);
        player.setStage(stage);
        player.setPosition(200f, -5f);

        radBall = new RadBall("RadBallYellow",ObjectType.ENEMY,
                new TextureRegion(new Texture(Gdx.files.internal("balls/rad_ball_1.png"))),100,
                5);
        radBall.setStage(stage);
        radBall.clearActions();
        radBall.setXVelocity(-5f);
        radBall.setYVelocity(-5f);
        playerHealth = new PlayerHealth(game);
        score = new Score(game);
        cityPower = new CityPower(game, radBall);
        soundLibrary = new SoundLibrary();
        musicLibrary = new MusicLibrary();
        musicLibrary.getGameMusic().setLooping(true);

        if (!musicLibrary.getGameMusic().isPlaying())
            musicLibrary.getGameMusic().play();

        stage.addActor(city);
        stage.addActor(reactor);
        stage.addActor(leftWall);
        stage.addActor(rightWall);
        stage.addActor(downWall);
        stage.addActor(upWall);
        stage.addActor(player);
        stage.addActor(radBall);
        stage.addActor(playerHealth);
        stage.addActor(score);
        stage.addActor(cityPower);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
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
                                radBall.setDirectionLeft(true);
                            } else {
                                soundLibrary.getHitSound().play();
                                game.score++;
                                radBall.addAction(Actions.rotateBy(360,0.3f));
                                radBall.setXVelocity(radBall.getXVelocity() - 1);
                            }
                        }
                    }
                }
                else {
                    if (player.getRightAttackRectangle().overlaps(radBall.getCollisionRectangle())) {
                        if (player.isCanAttack()) {
                            player.setCanAttack(false);
                            if (radBall.getXVelocity() < 0) {
                                radBall.setXVelocity(Math.abs(radBall.getXVelocity()));
                                radBall.setDirectionLeft(false);
                            } else {
                                soundLibrary.getHitSound().play();
                                game.score++;
                                radBall.addAction(Actions.rotateBy(-360,0.3f));
                                radBall.setXVelocity(radBall.getXVelocity() + 1);
                            }
                        }
                    }
                }
        }

        if (radBall.getCollisionRectangle().overlaps(leftWall.getCollisionRectangle())) {
            leftWall.addAction(Actions.sequence(Actions.color(Color.BLUE, 0.5f),
                    Actions.color(Color.WHITE,0.5f)));
        }

        if (radBall.getCollisionRectangle().overlaps(rightWall.getCollisionRectangle())) {
            rightWall.addAction(Actions.sequence(Actions.color(Color.BLUE, 0.5f),
                    Actions.color(Color.WHITE,0.5f)));
        }

        if (radBall.getCollisionRectangle().overlaps(upWall.getCollisionRectangle())) {
            upWall.addAction(Actions.sequence(Actions.color(Color.BLUE, 0.5f),
                    Actions.color(Color.WHITE,0.5f)));
        }

        if (radBall.getCollisionRectangle().overlaps(downWall.getCollisionRectangle())) {
            downWall.addAction(Actions.sequence(Actions.color(Color.BLUE, 0.2f),
                    Actions.color(Color.WHITE,0.2f)));
        }

        if (downWall.hasActions()) {
            if (!player.hasActions()) {
                if (player.getCollisionRectangle().overlaps(downWall.getCollisionRectangle())) {
                    player.addAction(Actions.rotateBy(360f, 0.5f));
                    game.health-=10;
                    soundLibrary.getDamageSound().play();
                }
            }
        }

        if (leftWall.hasActions()) {
            if (!player.hasActions()) {
                if (player.getCollisionRectangle().overlaps(leftWall.getCollisionRectangle())) {
                    player.addAction(Actions.rotateBy(360f, 0.5f));
                    game.health-=10;
                    soundLibrary.getDamageSound().play();
                }
            }
        }

        if (rightWall.hasActions()) {
            if (!player.hasActions()) {
                if (player.getCollisionRectangle().overlaps(rightWall.getCollisionRectangle())) {
                    player.addAction(Actions.rotateBy(360f, 0.5f));
                    game.health-=10;
                    soundLibrary.getDamageSound().play();
                }
            }
        }


        if (Math.abs(radBall.getXVelocity()) >= 5f) {
            city.addAction(Actions.alpha(1));
        }
        else if (Math.abs(radBall.getXVelocity()) == 4f) {
            city.addAction(Actions.alpha(0.8f));
        }
        else if (Math.abs(radBall.getXVelocity()) == 3f) {
            city.addAction(Actions.alpha(0.6f));
        }
        else if (Math.abs(radBall.getXVelocity()) == 2f) {
            city.addAction(Actions.alpha(0.4f));
        }
        else if (Math.abs(radBall.getXVelocity()) == 1f) {
            city.addAction(Actions.alpha(0.2f));
        }
        else if (Math.abs(radBall.getXVelocity()) == 0f) {
            city.addAction(Actions.alpha(0f));
        }

        if (radBall.getXVelocity() == 0  && !gameOverSequence) {
            gameOverSequence = true;
            radBall.addAction(Actions.scaleBy(50f,50f, 5f));
            radBall.addAction(Actions.after(Actions.run(new Runnable() {
                @Override
                public void run() {
                    musicLibrary.getGameMusic().stop();
                    game.setScreen(new GameOverScreen(game));
                }
            })));
        }


        if (game.health <= 0) {
            musicLibrary.getGameMusic().stop();
            game.setScreen(new GameOverScreen(game));
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
