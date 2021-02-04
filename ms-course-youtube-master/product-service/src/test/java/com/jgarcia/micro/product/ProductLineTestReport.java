package com.jgarcia.micro.product;

public class ProductLineTestReport {

    int uncheckedExcCnt;// contador de exceptions para las unchecked
    int checkedExcCnt;// contador de exceptions para las checked
    int otherExcCnt;// contador de exceptions para las other
    int correctCnt; // counter de las que no tienen exception

    public ProductLineTestReport(int uncheckedExcCnt, int checkedExcCnt, int otherExcCnt, int correctCnt) {
        this.uncheckedExcCnt = uncheckedExcCnt;
        this.checkedExcCnt = checkedExcCnt;
        this.otherExcCnt = otherExcCnt;
        this.correctCnt = correctCnt;
    }

    public ProductLineTestReport() {
    }
}
