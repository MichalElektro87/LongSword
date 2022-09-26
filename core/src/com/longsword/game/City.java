package com.longsword.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class City extends Person {
    public City(String name, ObjectType objectType, TextureRegion region, int health, int damage) {
        super(name, objectType, region, health, damage);
    }
}
