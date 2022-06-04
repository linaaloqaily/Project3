package com.example.project3.Service;

import com.example.project3.Exception.InvalidIdException;
import com.example.project3.Model.Book;
import com.example.project3.Model.Loan;
import com.example.project3.Model.User;
import com.example.project3.Repository.BookRepository;
import com.example.project3.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;


    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) throws IllegalAccessException{
         userRepository.save(user);
    }

}
