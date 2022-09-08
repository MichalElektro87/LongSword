package com.longsword.game;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BigOrc extends Person {
    public BigOrc(String name, ObjectType objectType, Animation<TextureRegion> animation, int health, int damage) {
        super(name, objectType,animation, health, damage);
    }
}
