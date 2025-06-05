package in.sunilsr.restapi.service.impl;

import in.sunilsr.restapi.dto.ExpenseDTO;
import in.sunilsr.restapi.entity.ExpenseEntity;
import in.sunilsr.restapi.repository.ExpenseRepository;
import in.sunilsr.restapi.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
/**
 * Service Implementation For Expense Module
 * @author Sunil S R
 * */
@Service
@RequiredArgsConstructor
@Slf4j
public class ExpenseServiceImpl implements ExpenseService {

    private static final Logger log = LoggerFactory.getLogger(ExpenseServiceImpl.class);
    private final ExpenseRepository expenseRepository;
   private final ModelMapper modelMapper;

    @Override
    public List<ExpenseDTO> getAllExpenses() {
        List<ExpenseEntity>  list = expenseRepository.findAll();
        log.info("Printing the data from repository{}", list);

        List<ExpenseDTO> listOfExpenses = list.stream().map(expenseEntity -> mapToExpenseDTO(expenseEntity)).collect(Collectors.toList());


        return listOfExpenses;

    }

    private ExpenseDTO mapToExpenseDTO(ExpenseEntity expenseEntity) {

        return modelMapper.map(expenseEntity, ExpenseDTO.class);
    }
}
