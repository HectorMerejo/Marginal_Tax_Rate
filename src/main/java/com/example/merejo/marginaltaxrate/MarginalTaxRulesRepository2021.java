package com.example.merejo.marginaltaxrate;

import edu.citytech.cst.helper.dao.IQuery;
import edu.citytech.cst.helper.utility.Location;
import edu.citytech.cst.helper.utility.ReadExcelUtility;

import java.util.List;
import java.util.function.Predicate;

public class MarginalTaxRulesRepository2021 implements IQuery<MarginalTaxRules> {

    private List<MarginalTaxRules> finalmarginaltaxrules;

    public MarginalTaxRulesRepository2021(){

        {
            finalmarginaltaxrules = ReadExcelUtility
                    .processRange(Location.RESOURCE, "static/SimpleTaxRate.xlsx"
                            , "rules2021", "B2:E8", 4, MarginalTaxRules::new );
        }

    }

    @Override
    public MarginalTaxRules findById(Predicate<MarginalTaxRules> predicate) {
        return null;
    }

    //Returns data
    @Override
    public List<MarginalTaxRules> findAll(Predicate<MarginalTaxRules> predicate) {
        var currentList = this.finalmarginaltaxrules.stream()
                .filter(predicate).toList();

        return currentList;
    }

}
