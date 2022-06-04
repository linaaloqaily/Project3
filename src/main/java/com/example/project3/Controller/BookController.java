package com.example.project3.Controller;

import com.example.project3.DTO.API;
import com.example.project3.Model.Book;
import com.example.project3.Model.User;
import com.example.project3.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/book")
public class BookController {

    private final BookService bookService;
    Logger logger = LoggerFactory.getLogger(BookController.class);


    @GetMapping("/getBooks")
    public ResponseEntity<List<Book>> getBooks(){
        logger.info("Get Books");
        return ResponseEntity.status(200).body(bookService.getBooks());
    }

    @PostMapping("/addBook")
    public ResponseEntity<API> addBook(@Valid @RequestBody Book book) throws IllegalAccessException{
        bookService.addBook(book);
        logger.info("Add Books");
        return ResponseEntity.status(201).body(new API("Book is added !",201));
    }

    @PostMapping("/lendBook")
    public ResponseEntity<API> lendBookToUser(@Valid @PathVariable Integer bookid, @Valid @PathVariable Integer userid ) {
        logger.info("User lend book");
        return ResponseEntity.status(200).body(new API("User lend book",200));
    }

    @GetMapping("check/{id}")
    public ResponseEntity<API> checkBookId(@PathVariable Integer id){
        bookService.checkBookId(id);
        return ResponseEntity.status(200).body(new API("Valid book",200));}
}
