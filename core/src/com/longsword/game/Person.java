package com.longsword.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

public class Person extends Actor {

    private Stage stage;
    private String name = "";
    private ObjectType objectType;
    private Array<Animation<TextureRegion>> animation;
    private TextureRegion region;
    private Rectangle collisionRectangle;
    private int currentAnimation = 0;
    private int health = 100;
    private int damage = 10;
    private float elapsedTime = 0f;
    private float xVelocity = 1f;
    private float yVelocity = 1f;
    private boolean directionLeft = true;
    private boolean attackBlock = false;
    private boolean isAnimSet = false;
    private boolean isTextureSet = false;

    public Person(String name, ObjectType objectType, Array<Animation <TextureRegion>> animation, int health, int damage) {
        this.name = name;
        this.objectType = objectType;
        this.animation = animation;
        this.health = health;
        this.damage = damage;
        isAnimSet = true;
        collisionRectangle = new Rectangle();
        collisionRectangle.width = animation.get(0).getKeyFrame(0).getRegionWidth();
        collisionRectangle.height = animation.get(0).getKeyFrame(0).getRegionHeight();
        setSize(collisionRectangle.getWidth(), collisionRectangle.getHeight());
        setOrigin(getWidth() / 2,getHeight() / 2);

    }

    public Person(String name, ObjectType objectType, TextureRegion region, int health, int damage) {
        this.name = name;
        this.objectType = objectType;
        this.region = region;
        this.health = health;
        this.damage = damage;
        isTextureSet = true;
        setSize(region.getRegionWidth(),region.getRegionHeight());
        setOrigin(getWidth()/2,getHeight()/2);
        collisionRectangle = new Rectangle(getX(),getY(),getWidth(),getHeight());
    }

    public Person(String name, ObjectType objectType) {
        this.name = name;
        this.objectType = objectType;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getCurrentAnimation() {
        return currentAnimation;
    }

    public void setCurrentAnimation(int currentAnimation) {
        this.currentAnimation = currentAnimation;
    }

    public Array<Animation<TextureRegion>> getAnimation() {
        return animation;
    }

    public boolean isDirectionLeft() {
        return directionLeft;
    }

    public void setDirectionLeft(boolean directionLeft) {
        this.directionLeft = directionLeft;
    }

    public void setElapsedTime(float elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public float getElapsedTime() {
        return elapsedTime;
    }

    public boolean isAttackBlock() {
        return attackBlock;
    }

    public void setAttackBlock(boolean attackBlock) {
        this.attackBlock = attackBlock;
    }

    public void setStage (Stage stage) {
        this.stage = stage;
    }

    public Stage getStage () {
        return stage;
    }

    public float getXVelocity() {
        return xVelocity;
    }

    public void setXVelocity(float xVelocity) {
        this.xVelocity = xVelocity;
    }

    public float getYVelocity() {
        return yVelocity;
    }

    public void setYVelocity(float yVelocity) {
        this.yVelocity = yVelocity;
    }

    public Rectangle getCollisionRectangle() {
        return collisionRectangle;
    }

    public void setCollisionRectangle(Rectangle collisionRectangle) {
        this.collisionRectangle = collisionRectangle;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        elapsedTime+= Gdx.graphics.getDeltaTime();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        collisionRectangle.setPosition(getX(),getY());
        collisionRectangle.width = collisionRectangle.width * getScaleX();
        collisionRectangle.height = collisionRectangle.height * getScaleY();

        Color c = getColor();
        batch.setColor(c.r,c.g,c.b,c.a);

        if (isVisible()) {
            if (isAnimSet) {
                batch.draw(animation.get(currentAnimation).getKeyFrame(elapsedTime, true), getX(), getY(),
                        getOriginX(),getOriginY(),
                        animation.get(currentAnimation).getKeyFrame(elapsedTime).getRegionWidth(),
                        animation.get(currentAnimation).getKeyFrame(elapsedTime).getRegionHeight(),
                        getScaleX(),getScaleY(),getRotation());
            }
            else if (isTextureSet) {
               batch.draw(region,getX(),getY(),getOriginX(),getOriginY(), getWidth(),getHeight(),getScaleX(),
                       getScaleY(),getRotation());
            }
        }
    }
}

