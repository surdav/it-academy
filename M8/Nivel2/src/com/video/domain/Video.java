package com.video.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.video.validatedMethods.ResultActions.getDateDiff;

public class Video {

    enum State {
        UPLOADING,
        VERIFYING,
        PUBLIC
    }

    private String url;
    private String title;
    private Tag tags;

    // Aquí guardamos la fecha y la hora en que se sube el vídeo
    Date date = new Date();

    // El siguiente formato será aplicado: 09-8-2021 07:44:36
    SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
    String videoUploadDateTime = formatter.format(date);

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Tag getTags() {
        return tags;
    }

    public void setTags(Tag tags) {
        this.tags = tags;
    }

    public String getVideoUploadDateTime() {
        return videoUploadDateTime;
    }

    @Override
    public String toString() {
        long timeDiff = getDateDiff(date, new Date(), TimeUnit.MILLISECONDS);
        State myState = null;
        if(timeDiff < 60000) myState = State.UPLOADING;
        if(timeDiff > 60000 && timeDiff < 180000) myState = State.VERIFYING;
        if(timeDiff > 180000) myState = State.PUBLIC;

        return "Vídeo info: URL = '" + url + "', título = '" + title + "', tags: " + tags + ". La fecha y la hora de la subida del vídeo: '" + videoUploadDateTime + "'. Estado de subida de vídeo: " + (myState != null ? myState.name() : "Proceso de subida de video no iniciado");
    }
}
