package com.longsword.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Person extends Actor {

    private String name = "";
    private ObjectType objectType;
    private Array<Animation<TextureRegion>> animation;
    private int currentAnimation = 0;
    private int health = 100;
    private int damage = 10;
    private float elapsedTime = 0f;
    private boolean directionLeft = true;
    private boolean attackBlock = false;

    public Person(String name, ObjectType objectType, Array<Animation <TextureRegion>> animation, int health, int damage) {
        this.name = name;
        this.objectType = objectType;
        this.animation = animation;
        this.health = health;
        this.damage = damage;

        setVisible(true);
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

    @Override
    public void act(float delta) {
        super.act(delta);
        elapsedTime+= Gdx.graphics.getDeltaTime();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        if (isVisible()) {
            batch.draw(animation.get(currentAnimation).getKeyFrame(elapsedTime, true), getX(), getY(), getOriginX(), getOriginY(), animation.get(currentAnimation).getKeyFrame(elapsedTime).getRegionWidth(), animation.get(currentAnimation).getKeyFrame(elapsedTime).getRegionHeight(),getScaleX(),getScaleY(),getRotation());
        }
    }
}

