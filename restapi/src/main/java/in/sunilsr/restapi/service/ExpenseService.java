package in.sunilsr.restapi.service;

import in.sunilsr.restapi.dto.ExpenseDTO;

import java.util.List;
/**
 * Service Interface For Expense Module
 * @author  Sunil S R
 * */
public interface ExpenseService {

    /**
     * It will fetch the Expense from database
     * @author Sunil S R
     * */
    List<ExpenseDTO> getAllExpenses();
}
