package com.longsword.game;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class BigOrc extends Person {
    public BigOrc(String name, ObjectType objectType, Array<Animation<TextureRegion>> animation, int health, int damage) {
        super(name, objectType,animation, health, damage);
    }
}
