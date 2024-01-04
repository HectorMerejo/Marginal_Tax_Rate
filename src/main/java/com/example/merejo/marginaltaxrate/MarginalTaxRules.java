package com.example.merejo.marginaltaxrate;

import edu.citytech.cst.helper.utility.NumberUtility;
import org.apache.poi.ss.usermodel.Row;

// This class appears to represent a set of rules for final marginal taxes,
// providing information about tax rates and salary thresholds for different
// filing statuses. The data seems to be read from an Excel Row object, and
// the class provides methods for accessing and displaying this information.

public class MarginalTaxRules {

    double taxRate;
    float salaryS, salaryMFJ, salaryHH;
    String formattedSalaryS, formattedSalaryMFJ,formattedSalaryHH, formattedTaxRate;

    public MarginalTaxRules(Row row) {
        this.taxRate = row.getCell(1).getNumericCellValue();
        this.salaryS = (float)row.getCell(2).getNumericCellValue();
        this.salaryMFJ = (float)row.getCell(3).getNumericCellValue();
        this.salaryHH = (float)row.getCell(4).getNumericCellValue();
        this.formattedSalaryS = NumberUtility.commaStyle(salaryS);
        this.formattedSalaryMFJ = NumberUtility.commaStyle(salaryMFJ);
        this.formattedSalaryHH = NumberUtility.commaStyle(salaryHH);
        this.formattedTaxRate = NumberUtility.percentStyle(taxRate);
    }

    public String getFormattedTaxRate() {
        return formattedTaxRate;
    }

    public String getFormattedSalaryS() {
        return formattedSalaryS;
    }

    public String getFormattedSalaryMFJ() {
        return formattedSalaryMFJ;
    }

    public String getFormattedSalaryHH() {
        return formattedSalaryHH;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public float getSalaryS() {
        return salaryS;
    }

    public float getSalaryMFJ() {
        return salaryMFJ;
    }

    public float getSalaryHH() {
        return salaryHH;
    }

    @Override
    public String toString() {
        return "MarginalTaxRules{" +
                "taxRate=" + taxRate +
                ", salaryS=" + salaryS +
                ", salaryMFJ=" + salaryMFJ +
                ", salaryHH=" + salaryHH +
                '}';
    }
}

