package com.example.project3.Service;

import com.example.project3.Exception.InvalidIdException;
import com.example.project3.Model.Book;
import com.example.project3.Model.Loan;
import com.example.project3.Model.User;
import com.example.project3.Repository.BookRepository;
import com.example.project3.Repository.LoanRepository;
import com.example.project3.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    private final LoanRepository loanRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }


    public void addBook(Book book) throws IllegalAccessException {
        bookRepository.save(book);
    }

    public void lendBookToUser(Integer userId,Integer bookId){
        User user=userRepository.findById(userId).
                orElseThrow(() -> new InvalidIdException("Invaild user id"));
        Book book=bookRepository.findById(bookId).
                orElseThrow(() -> new InvalidIdException("Invaild book id"));
        Loan loan = new Loan(null,userId,bookId,null);
        loanRepository.save(loan);
    }


    public void checkBookId(Integer id) {
        Book book=bookRepository.findById(id)
                .orElseThrow(
                        ()->new InvalidIdException("Invalid id"));
    }

}
