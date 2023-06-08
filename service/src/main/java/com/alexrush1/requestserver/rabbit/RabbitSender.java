package com.alexrush1.requestserver.rabbit;

import com.alexrush1.requestserver.dto.response.RequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
@RequiredArgsConstructor
public class RabbitSender {

    protected String username = "guest";
    public static final String NOTIFICATION_ORCHESTRATOR_BINDING = "output-request";
    private final StreamBridge streamBridge;

    protected void sendMessage(RequestDto requestDto) {
        try {
            streamBridge.send(NOTIFICATION_ORCHESTRATOR_BINDING, createMessage(requestDto));
        } catch (Exception e) {
            log.error("Проблема при отправке сообщения", e);
        }
    }

    protected Message<RequestDto> createMessage(RequestDto requestDto) {

        return MessageBuilder
                .withPayload(requestDto)
                .setHeader(AmqpHeaders.USER_ID, username)
                .setHeader(AmqpHeaders.TIMESTAMP, new Date())
                .build();
    }
}
