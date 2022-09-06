package com.longsword.game;

import com.badlogic.gdx.scenes.scene2d.Actor;

public class Person extends Actor {

    private String name = "";

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }

    private ObjectType objectType;
    private int health = 100;
    private int damage = 10;

    public Person(String name, ObjectType objectType, int health, int damage) {
        this.name = name;
        this.objectType = objectType;
        this.health = health;
        this.damage = damage;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
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
}
