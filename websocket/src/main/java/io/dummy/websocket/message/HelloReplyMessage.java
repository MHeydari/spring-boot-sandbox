package io.dummy.websocket.message;

import lombok.*;

@EqualsAndHashCode()
@ToString
@AllArgsConstructor
public class HelloReplyMessage {
    @Getter @Setter private String content;
}
