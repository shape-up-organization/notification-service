package br.com.shapeup.notificationservice.infrastructure.kafka;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Topic {
    FRIENDSHIP_REQUEST("tp-friendship-request");

    private final String name;
}
