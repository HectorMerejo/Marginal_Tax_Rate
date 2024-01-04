package com.example.merejo.marginaltaxrate;

public class MarginalTaxRulesInput {

    private String status = "S", code = "ALL";
    private int year = 2024;
    private String salary = "150000";

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "MarginalTaxRulesInput{" +
                "status='" + status + '\'' +
                ", year=" + year +
                ", salary=" + salary +
                '}';
    }
}
