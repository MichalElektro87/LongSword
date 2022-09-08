package com.longsword.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class AnimationOfActors {

    private Array<TextureAtlas> playerTextureAtlas;
    private TextureAtlas bigOrcTextureAtlas [];
    private Array<Animation<TextureRegion>> playerAnimation;

    public AnimationOfActors() {
        playerTextureAtlas = new Array<>();
        playerAnimation = new Array<>();
        setPlayerTextureAtlas();
        setPlayerAnimation();
    }

    private void setPlayerTextureAtlas () {
        playerTextureAtlas.add(new TextureAtlas(Gdx.files.internal("player/animation/no_move_left/no_move_left.atlas")));
        playerTextureAtlas.add(new TextureAtlas(Gdx.files.internal("player/animation/no_move_right/no_move_right.atlas")));
        playerTextureAtlas.add(new TextureAtlas(Gdx.files.internal("player/animation/move_left/move_left.atlas")));
        playerTextureAtlas.add(new TextureAtlas(Gdx.files.internal("player/animation/move_right/move_right.atlas")));
        playerTextureAtlas.add(new TextureAtlas(Gdx.files.internal("player/animation/attack_left/attack_left.atlas")));
        playerTextureAtlas.add(new TextureAtlas(Gdx.files.internal("player/animation/attack_right/attack_right.atlas")));
    }

    private void setPlayerAnimation () {
        for (int i = 0; i < playerTextureAtlas.size; i++) {
            playerAnimation.add(new Animation<TextureRegion>(1/9f, playerTextureAtlas.get(i).getRegions()));
        }
    }

    public Array<Animation<TextureRegion>> getPlayerAnimation () {
        return playerAnimation;
    }

}
