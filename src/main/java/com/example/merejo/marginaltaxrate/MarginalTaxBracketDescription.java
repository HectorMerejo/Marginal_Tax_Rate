package com.example.merejo.marginaltaxrate;

public class MarginalTaxBracketDescription {
    private String bracket;
    private String calculateDescription;
    private float taxPaid = 0;

    //this is constructor and it returns itself
    public MarginalTaxBracketDescription(MarginalTaxBracket taxRule, float income){

        float range1 = taxRule.getRange1();
        float range2 = taxRule.getRange2() > income ? income : taxRule.getRange2();

        this.bracket = taxRule.getFormattedTaxRate() + " Bracket:";
        this.calculateDescription = "(" + range2 +  " - " + range1 + ") x " + taxRule.getFormattedTaxRate() + " ";
        this.taxPaid = (range2 - + range1) * taxRule.getTaxRate();
        this.calculateDescription = taxPaid < 0 ? "Not Applicable" : this.calculateDescription + " = " + taxPaid;

    }

    public float getTaxPaid() {
        return taxPaid;
    }

    public String getBracket() {
        return bracket;
    }

    public String getCalculateDescription() {
        return calculateDescription;
    }

    @Override
    public String toString() {
        return "MarginalTaxBracketDescription{" +
                "bracket='" + bracket + '\'' +
                ", calculateDescription='" + calculateDescription + '\'' +
                '}';
    }

    public static void main(String[] args) {

    }
}
