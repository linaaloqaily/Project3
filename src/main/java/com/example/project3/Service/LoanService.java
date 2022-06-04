package com.example.project3.Service;

import com.example.project3.Model.Loan;
import com.example.project3.Repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;


    public List<Loan> getLoans() {
       return loanRepository.findAll();
    }

    public void addLoan(Loan loan) throws IllegalAccessException {
        loanRepository.save(loan);
    }

}
