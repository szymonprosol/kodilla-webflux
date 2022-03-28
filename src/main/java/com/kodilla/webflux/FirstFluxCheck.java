package com.kodilla.webflux;

import reactor.core.publisher.Flux;

public class FirstFluxCheck {

    public static void main(String[] args) {
        Book b1 = new Book("Title1", "Author1", 2000);
        Book b2 = new Book("Title2", "Author2", 2001);
        Flux<Book> bookFlux = Flux.just(b1, b2);
        bookFlux = bookFlux.concatWith(Flux.error(new Exception("Test exception")));
        bookFlux.subscribe(System.out::println, FirstFluxCheck::handleException);

        BookDto bd1 = new BookDto("Title1", "Author1", 2000);
        BookDto bd2 = new BookDto("Title2", "Author2", 2001);
        Flux<BookDto> bookDtoFlux = Flux.just(bd1, bd2);
        bookDtoFlux = bookDtoFlux.concatWith(Flux.error(new Exception("Test exception")));
        bookDtoFlux.subscribe(System.out::println, FirstFluxCheck::handleException);
    }

    private static void handleException(Throwable e) {
        System.out.println("There was an error: " + e);
    }

}