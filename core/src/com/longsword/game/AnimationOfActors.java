package com.longsword.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class AnimationOfActors {

    private Array<TextureAtlas> playerTextureAtlas;
    private TextureAtlas bigOrcTextureAtlas [];
    private Animation <TextureRegion> playerAnimation;

    public AnimationOfActors() {
        playerTextureAtlas = new Array<>();
        setPlayerTextureAtlas();
        setPlayerAnimation();
    }

    private void setPlayerTextureAtlas () {
        playerTextureAtlas.add(new TextureAtlas(Gdx.files.internal("player/animation/no_move_left/no_move_left.atlas")));
    }

    private void setPlayerAnimation () {
        playerAnimation = new Animation<TextureRegion>(1/9f, playerTextureAtlas.get(0).getRegions());
    }

    public Animation<TextureRegion> getPlayerAnimation () {
        return playerAnimation;
    }

}
