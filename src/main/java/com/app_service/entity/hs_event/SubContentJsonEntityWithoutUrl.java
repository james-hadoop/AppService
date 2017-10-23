package com.app_service.entity.hs_event;

/**
 * { "lyricist": "peter", "composer": "tom", "singer":
 * "linda" }
 * 
 * @author qjiang
 *
 */
public class SubContentJsonEntityWithoutUrl {
    String lyricist;
    String composer;
    String singer;

    public SubContentJsonEntityWithoutUrl() {

    }

    public SubContentJsonEntityWithoutUrl(String lyricist, String composer, String singer) {
        this.lyricist = lyricist;
        this.composer = composer;
        this.singer = singer;

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
}
