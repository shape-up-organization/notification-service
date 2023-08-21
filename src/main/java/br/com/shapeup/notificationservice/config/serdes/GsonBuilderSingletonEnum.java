package br.com.shapeup.notificationservice.config.serdes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.time.LocalDateTime;

public enum GsonBuilderSingletonEnum {
    INSTANCE;

    private final GsonBuilder gsonBuilder;

    GsonBuilderSingletonEnum() {
        gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter());
    }

    public Gson getGsonBuilder() {
        return gsonBuilder.create();
    }
}
