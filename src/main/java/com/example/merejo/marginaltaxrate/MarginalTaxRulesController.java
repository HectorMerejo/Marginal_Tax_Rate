package com.example.merejo.marginaltaxrate;

import edu.citytech.cst.helper.utility.NumberUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.function.Supplier;

@Controller
public class MarginalTaxRulesController {

    @Autowired
    MarginalTaxRulesService service2019;
    @Autowired
    MarginalTaxRulesService service2020;
    @Autowired
    MarginalTaxRulesService service2021;
    @Autowired
    MarginalTaxRulesService service2022;
    @Autowired
    MarginalTaxRulesService service2023;
    @Autowired
    MarginalTaxRulesService service2024;
    @Autowired
    MarginalTaxBracketService serviceBracket;

    Map<Integer, Supplier<List<MarginalTaxRules>>> map = new HashMap<>();

    public void initialize (){
        System.out.print("Loading : " + new Date());
        map.put(2019, service2019::get2019TaxRules);
        map.put(2020, service2020::get2020TaxRules);
        map.put(2021, service2021::get2021TaxRules);
        map.put(2022, service2022::get2022TaxRules);
        map.put(2023, service2023::get2023TaxRules);
        map.put(2024, service2024::get2024TaxRules);

    }

    @RequestMapping({"/marginal-tax-rate", "marginal-tax-rate.html"}) //responsible for the url
    public String marginalTaxRate(@ModelAttribute MarginalTaxRulesInput formInput,
                                  Model model) {

        if (map.size() == 0) initialize();
        var year = formInput.getYear();
        var status = formInput.getStatus();
        var sSalary = formInput.getSalary();

        float salary = (float)NumberUtility.getNumberValue(sSalary).value;

        var filteredList = map.getOrDefault(year, () -> new ArrayList<>()).get();

        model.addAttribute("taxrules", filteredList);
        model.addAttribute("year", year);

        String statusDescription = "Status";

        if (formInput.getStatus().equals("S"))
        {
            statusDescription = "Single";
        }

        else if (formInput.getStatus().equals("MFJ")) {
            statusDescription = "Married File Jointly";
        }

        else if (formInput.getStatus().equals("HH"))
        {
            statusDescription = "Heads of Household";
        }

        model.addAttribute("status", statusDescription);
        model.addAttribute("salary", NumberUtility.commaStyle(salary));
        model.addAttribute("input", formInput);

        //Part B
        var getTaxBracket = serviceBracket.getTaxBracketDescription(year, status, salary);

        float total = (float)serviceBracket.getTaxBracketDescription(year, status, salary).stream().mapToDouble(e -> e.getTaxPaid() < 0 ? 0 : e.getTaxPaid()).sum();

        float percent = calcultotal(total,salary);

        model.addAttribute("taxBracket", getTaxBracket);
        model.addAttribute("total", total);
        model.addAttribute("percent", NumberUtility.percentStyle(percent));

        return"marginal-tax.jsp";
        }

        public float calcultotal(float total, float salary){
                float percent = total/salary;
                return percent;
        }

}
