package com.kodilla.webflux.controller;

import com.kodilla.webflux.BookDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class FluxController {

    @GetMapping(value = "/strings", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<BookDto> getStrings() {
        BookDto bd1 = new BookDto("Title1", "Author1", 2000);
        BookDto bd2 = new BookDto("Title2", "Author2", 2001);

        return Flux
                .just(bd1,bd2)
                .log();
    }
}
