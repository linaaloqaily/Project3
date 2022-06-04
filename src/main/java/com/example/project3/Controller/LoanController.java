package com.example.project3.Controller;

import com.example.project3.DTO.API;
import com.example.project3.Model.Book;
import com.example.project3.Model.Loan;
import com.example.project3.Service.LoanService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/loan")
public class LoanController {

    private final LoanService loanService;
    Logger logger = LoggerFactory.getLogger(LoanController.class);


    @GetMapping("/getLoans")
    public ResponseEntity<List<Loan>> getLoans(){
        logger.info("Get Loans");
        return ResponseEntity.status(200).body(loanService.getLoans());
    }

    @PostMapping("/addLoan")
    public ResponseEntity<API> addLoan(@Valid @RequestBody Loan loan) throws IllegalAccessException{
        loanService.addLoan(loan);
        logger.info("Add Loans");
        return ResponseEntity.status(201).body(new API("Loan is added !",201));
    }
}
