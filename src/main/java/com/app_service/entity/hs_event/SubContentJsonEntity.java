package com.app_service.entity.hs_event;

/**
 * { "url": "audio/a.mp3", "lyricist": "peter", "composer": "tom", "singer":
 * "linda" }
 * 
 * @author qjiang
 *
 */
public class SubContentJsonEntity {
    String url;
    String lyricist;
    String composer;
    String singer;

    public SubContentJsonEntity() {

    }

    public SubContentJsonEntity(String url, String lyricist, String composer, String singer) {
        this.url = url;
        this.lyricist = lyricist;
        this.composer = composer;
        this.singer = singer;

    }
    
    public SubContentJsonEntity(SubContentJsonEntityWithoutUrl subContentJsonEntityWithoutUrl){
        this.url=null;
        this.lyricist=subContentJsonEntityWithoutUrl.getLyricist();
        this.composer=subContentJsonEntityWithoutUrl.getComposer();
        this.singer=subContentJsonEntityWithoutUrl.getSinger();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public SubContentJsonEntityWithoutUrl toSubContentJsonEntityWithoutUrl() {
        return new SubContentJsonEntityWithoutUrl(lyricist, composer, singer);
    }
}
