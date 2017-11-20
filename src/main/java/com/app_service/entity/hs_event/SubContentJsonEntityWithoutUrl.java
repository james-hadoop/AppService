package com.app_service.entity.hs_event;

/**
 * { "lyricist": "peter", "composer": "tom", "singer": "linda" }
 * 
 * @author qjiang
 *
 */
public class SubContentJsonEntityWithoutUrl {
    String lyricist;
    String composer;
    String singer;
    String song;
    String description;

    public SubContentJsonEntityWithoutUrl() {

    }

    public SubContentJsonEntityWithoutUrl(String lyricist, String composer, String singer, String song,
            String description) {
        this.lyricist = lyricist;
        this.composer = composer;
        this.singer = singer;
        this.song = song;
        this.description = description;
    }

    public SubContentJsonEntityWithoutUrl(String lyricist, String composer, String singer) {
        this.lyricist = lyricist;
        this.composer = composer;
        this.singer = singer;
        this.song = null;
        this.description = null;
    }

    public String getLyricist() {
        return lyricist;
    }

    public void setLyricist(String lyricist) {
        this.lyricist = lyricist;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }
}
