package com.longsword.game.sound;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class SoundLibrary {

    private Sound damageSound;
    private Sound hitSound;

    public SoundLibrary () {

        damageSound = Gdx.audio.newSound(Gdx.files.internal("sound/electricball.mp3"));
        hitSound = Gdx.audio.newSound(Gdx.files.internal("sound/pickaxe.mp3"));

    }

    public Sound getDamageSound() {
        return damageSound;
    }

    public void setDamageSound(Sound damageSound) {
        this.damageSound = damageSound;
    }

    public Sound getHitSound() {
        return hitSound;
    }

    public void setHitSound(Sound hitSound) {
        this.hitSound = hitSound;
    }



}
