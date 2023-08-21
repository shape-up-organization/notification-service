package br.com.shapeup.notificationservice.config.serdes;

import com.google.gson.Gson;
import org.apache.kafka.common.serialization.Serializer;

public class GsonSerializer<T> implements Serializer<T> {
    private Gson gson = new Gson();

    @Override
    public byte[] serialize(String topic, T data) {
        return gson.toJson(data).getBytes();
    }
}
