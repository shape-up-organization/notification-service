package br.com.shapeup.notificationservice.infrastructure.kafka;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Group {
    USER_NOTIFICATION("gp-friendship-request");

    private final String name;
}
