package io.dummy.websocket.message;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode()
@ToString
public class HelloMessage {
    @Getter @Setter private String name;
}
