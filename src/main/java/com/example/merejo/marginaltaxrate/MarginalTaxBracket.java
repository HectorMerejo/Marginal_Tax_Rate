package com.example.merejo.marginaltaxrate;
import edu.citytech.cst.helper.utility.NumberUtility;
import org.apache.poi.ss.usermodel.Row;

public class MarginalTaxBracket {

    private int year;
    private String code;
    private float taxRate;
    private float range1;
    private float range2;

    String formattedTaxRate, formattedRange1,formattedRange2 ;

    public MarginalTaxBracket(Row row){
        this.year = (int)row.getCell(0).getNumericCellValue();
        this.code = row.getCell(1).getStringCellValue();
        this.taxRate = (float)row.getCell(2).getNumericCellValue();
        this.range1 = (float)row.getCell(3).getNumericCellValue();
        this.range2 = (float)row.getCell(4).getNumericCellValue();
        this.formattedTaxRate = NumberUtility.percentStyle(taxRate);
        this.formattedRange1 = NumberUtility.percentStyle(range1);
        this.formattedRange2 = NumberUtility.percentStyle(range2);
    }

    public int getYear() {
        return year;
    }

    public String getCode() {
        return code;
    }

    public float getTaxRate() {
        return taxRate;
    }

    public float getRange1() {
        return range1;
    }

    public float getRange2() {
        return range2;
    }

    public String getFormattedTaxRate() {
        return formattedTaxRate;
    }

    public String getFormattedRange1() {
        return formattedRange1;
    }

    public String getFormattedRange2() {
        return formattedRange2;
    }

    @Override
    public String toString() {
        return "MarginalTaxRate{" +
                "year=" + year +
                ", code='" + code + '\'' +
                ", rate=" + taxRate +
                ", range1=" + range1 +
                ", range2=" + range2 +
                '}';
    }
}
