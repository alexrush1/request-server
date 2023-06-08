package com.alexrush1.requestserver.rabbit;

import com.alexrush1.requestserver.service.RequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
@RequiredArgsConstructor
public class RabbitConsumer {

    private final RequestService requestService;

    @Bean
    public Consumer<String> input() {
        return message -> {
            log.debug("Получено сообщение из рэббита: '{}'", message);
        };
    }
}
