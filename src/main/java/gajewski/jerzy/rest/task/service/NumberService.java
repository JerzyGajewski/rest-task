package gajewski.jerzy.rest.task.service;

import gajewski.jerzy.rest.task.model.Numbers;
import gajewski.jerzy.rest.task.wrapper.NumberWrapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class NumberService {

    public Numbers sortNumbers(NumberWrapper numberWrapper){
        Numbers numbers = new Numbers();
        if (numberWrapper.getSorted().equalsIgnoreCase("desc")){
            numberWrapper.getNumberList().sort(Collections.reverseOrder());
            numbers.setNumbers(numberWrapper.getNumberList());

        } else {
            Collections.sort(numberWrapper.getNumberList());
            numbers.setNumbers(numberWrapper.getNumberList());
        }
        return numbers;
    }
}
