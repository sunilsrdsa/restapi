package in.sunilsr.restapi.controller;

import in.sunilsr.restapi.dto.ExpenseDTO;
import in.sunilsr.restapi.io.ExpenseResponse;
import in.sunilsr.restapi.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This is Controller class for Expense Module
 * @author  Sunil S R
 * */
@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*") // allow all request
public class ExpenseController {

    private static final Logger log = LoggerFactory.getLogger(ExpenseController.class);
    private final ExpenseService expenseService;

    private final ModelMapper modelMapper;

    /**
     * It will fetch the Expenses From Database
     * @return  list
     * */
    @GetMapping("/expenses")
    public List<ExpenseResponse> getExpenses() {
        // Call the Service Method
        //Convert the ExpenseDTO to Expense Response
        // return the List/response

        log.info("API GET /expenses called");

        List<ExpenseDTO> list = expenseService.getAllExpenses();
        log.info("Printing the data from service {}", list);
        List<ExpenseResponse> response =list.stream().map(expenseDTO -> mapToExpenseResponse(expenseDTO)).collect(Collectors.toList());
     //   return "Reading the expenses from database";
        return response;
    }
  /**
   * Mapper Method for converting Expense DTO object to Expense Response
   * @param
   * @return ExpenseResponse
   * */
    private ExpenseResponse mapToExpenseResponse(ExpenseDTO expenseDTO) {

        ExpenseResponse map = modelMapper.map(expenseDTO, ExpenseResponse.class);
        return map;
    }
}
