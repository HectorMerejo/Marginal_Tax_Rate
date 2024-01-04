package com.example.merejo.marginaltaxrate;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

@Service
public class MarginalTaxRulesService {

    private MarginalTaxRulesRepository2019 repository = new MarginalTaxRulesRepository2019();
    private MarginalTaxRulesRepository2020 repository2020 = new MarginalTaxRulesRepository2020();
    private MarginalTaxRulesRepository2021 repository2021 = new MarginalTaxRulesRepository2021();
    private MarginalTaxRulesRepository2022 repository2022 = new MarginalTaxRulesRepository2022();
    private MarginalTaxRulesRepository2023 repository2023 = new MarginalTaxRulesRepository2023();
    private MarginalTaxRulesRepository2024 repository2024 = new MarginalTaxRulesRepository2024();

    private static Predicate<MarginalTaxRules> taxRules2019 = e -> true;
    private static Predicate<MarginalTaxRules> taxRules2020 = e -> true;
    private static Predicate<MarginalTaxRules> taxRules2021 = e -> true;
    private static Predicate<MarginalTaxRules> taxRules2022 = e -> true;
    private static Predicate<MarginalTaxRules> taxRules2023 = e -> true;
    private static Predicate<MarginalTaxRules> taxRules2024 = e -> true;

    public List<MarginalTaxRules> get2019TaxRules() {return repository.findAll(taxRules2019);}
    public List<MarginalTaxRules> get2020TaxRules() {return repository2020.findAll(taxRules2020);}
    public List<MarginalTaxRules> get2021TaxRules() {return repository2021.findAll(taxRules2021);}
    public List<MarginalTaxRules> get2022TaxRules() {return repository2022.findAll(taxRules2022);}
    public List<MarginalTaxRules> get2023TaxRules() {return repository2023.findAll(taxRules2023);}
    public List<MarginalTaxRules> get2024TaxRules() {return repository2024.findAll(taxRules2024);}

    public static void main(String[] args) {
        new MarginalTaxRulesService().get2020TaxRules()
                .forEach(System.out::println);

        System.out.println("Merejo, Hector " + new Date());
    }
}
