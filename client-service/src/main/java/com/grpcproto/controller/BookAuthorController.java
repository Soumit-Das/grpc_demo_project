package com.grpcproto.controller;

import com.google.protobuf.Descriptors;
import com.grpcproto.service.BookAuthorClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class BookAuthorController {

    BookAuthorClientService bookAuthorClientService;

    @GetMapping("/author/{authorId}")
    public Map<Descriptors.FieldDescriptor,Object> getauthor(@PathVariable String authorId){
        return bookAuthorClientService.getAuthor(Integer.parseInt(authorId));
    }

    @GetMapping("/book/{authorId}")
    public List<Map<Descriptors.FieldDescriptor, Object>> getBookByAuthor(@PathVariable String authorId) throws InterruptedException {

        return bookAuthorClientService.getBooksByAuthor(Integer.parseInt(authorId));

    }

    @GetMapping("/book")
    public Map<String,Map<Descriptors.FieldDescriptor, Object>> getExpensiveBook() throws InterruptedException {
        return bookAuthorClientService.getExpensiveBook();
    }

    @GetMapping("/book/author/{gender}")
    public List<Map<Descriptors.FieldDescriptor, Object>> getBookByAuthorGender(@PathVariable String gender) throws InterruptedException {

        return bookAuthorClientService.getBooksByAuthorGender(gender);

    }

}
