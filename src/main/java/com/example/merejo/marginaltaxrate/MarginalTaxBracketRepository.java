package com.example.merejo.marginaltaxrate;

import edu.citytech.cst.helper.dao.IQuery;
import edu.citytech.cst.helper.utility.ReadExcelUtility;

import java.util.List;
import java.util.function.Predicate;

// class serves as a repository for managing and querying tax brackets.
// It reads data from an Excel file during initialization and provides
// methods for querying tax brackets based on specified conditions

public class MarginalTaxBracketRepository implements IQuery<MarginalTaxBracket> {
    private List<MarginalTaxBracket> list;

    public MarginalTaxBracketRepository(){

        list = ReadExcelUtility
                .processFromResource("static/SimpleTaxRate.xlsx"
                        , "rulesForCode", 1, MarginalTaxBracket::new );
    }

    @Override
    public MarginalTaxBracket findById(Predicate<MarginalTaxBracket> predicate) {
        return null;
    }

    @Override
    public List<MarginalTaxBracket> findAll(Predicate<MarginalTaxBracket> predicate) {
        var currentList = this.list.stream()
                .filter(predicate).toList();

        return currentList;
    }

    public static void main(String[] args) {
        float salary = 100_000;
        new MarginalTaxBracketRepository().findAll(e -> e.getCode().equals("S") && e.getYear() == 2021
                && e.getRange1() < salary && e.getRange2() >= salary)
                .forEach(System.out::println);
    }
}
