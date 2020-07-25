package org.example.vitasoft.domain;

public enum Months {

    JAN("январь"),
    FEB("февраль"),
    MAR("март"),
    APR("апрель"),
    MAY("май"),
    JUN("июнь"),
    JUL("июль"),
    AUG("август"),
    SEP("сентябрь"),
    OCT("октябрь"),
    NOV("ноябрь"),
    DEC("декабрь");

    private final String monthName;

    Months(String monthName) {
        this.monthName = monthName;
    }

    public static String getName(int number) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            char[] chars = Months.values()[number - 1].monthName.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                stringBuilder.append(chars[i]);
                if (i < chars.length - 1) {
                    stringBuilder.append("-");
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return "INCORRECT INPUT DATA";
        }
        return stringBuilder.toString().toUpperCase();
    }
}
