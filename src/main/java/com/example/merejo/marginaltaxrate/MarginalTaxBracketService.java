package com.example.merejo.marginaltaxrate;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

// This class appears to encapsulate the logic for retrieving tax bracket descriptions
// and performing calculations related to tax payments. The service follows the Spring
// framework conventions with the @Service annotation, indicating that it can be used
// as a bean within a Spring application context

@Service
public class MarginalTaxBracketService {

    static private MarginalTaxBracketRepository repository = new MarginalTaxBracketRepository();

    public List<MarginalTaxBracketDescription> getTaxBracketDescription(int taxYear, String taxStatus, float income){

        var list = repository.findAll(e -> e.getYear() == taxYear && e.getCode().equals(taxStatus))
                //this represents a taxRule as a parameter
                .stream()
                .map(e -> new MarginalTaxBracketDescription(e, income))
                .toList();

        return list;
    }

    public static void main(String[] args) {
        new MarginalTaxBracketService().getTaxBracketDescription(2021, "S", 150_000)
                .forEach(System.out::println);

        var total = new MarginalTaxBracketService().getTaxBracketDescription(2021, "S", 150_000)
                .stream()
                .mapToDouble(e -> e.getTaxPaid() < 0 ? 0 : e.getTaxPaid()).sum();

        System.out.println(total);

        System.out.println("Merejo, Hector " + new Date());
    }
}
