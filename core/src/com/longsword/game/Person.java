package com.longsword.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Person extends Actor {

    private String name = "";
    private ObjectType objectType;
    private Animation <TextureRegion> animation;
    private int health = 100;
    private int damage = 10;
    private float elapsedTime = 0f;

    public Person(String name, ObjectType objectType, Animation <TextureRegion> animation, int health, int damage) {
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

    @Override
    public void act(float delta) {
        super.act(delta);
        elapsedTime+= Gdx.graphics.getDeltaTime();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        if (isVisible()) {
            batch.draw(animation.getKeyFrame(elapsedTime, true), getX(), getY(), getOriginX(), getOriginY(), animation.getKeyFrame(elapsedTime).getRegionWidth(), animation.getKeyFrame(elapsedTime).getRegionHeight(),getScaleX(),getScaleY(),getRotation());
        }
    }
}

