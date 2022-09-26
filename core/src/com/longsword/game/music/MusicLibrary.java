package com.longsword.game.music;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class MusicLibrary {

    private Music gameMusic;

    public MusicLibrary () {
        gameMusic = Gdx.audio.newMusic(Gdx.files.internal("music/game_stage_7.mp3"));
    }

    public Music getGameMusic() {
        return gameMusic;
    }

    public void setGameMusic(Music gameMusic) {
        this.gameMusic = gameMusic;
    }
}
