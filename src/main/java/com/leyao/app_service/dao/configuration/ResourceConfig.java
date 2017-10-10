package com.leyao.app_service.dao.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("static.path")
public class ResourceConfig {
    private String prefix;
    private String audio;
    private String video;
    private String image;
    private String portrait;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }
}