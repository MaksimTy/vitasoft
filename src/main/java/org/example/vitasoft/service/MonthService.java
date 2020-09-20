package org.example.vitasoft.service;

import org.example.vitasoft.model.Months;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonthService {

    private final String INCORRECT_OUTPUT = "INCORRECT INPUT DATA";

    private Months months;

    @Autowired
    public void setMonths(Months months) {
        this.months = months;
    }

    private String getMonthName(Integer id) {
        return months.getMonthById(id);
    }

    public String getOutput(String monthsId) {
        Integer id;
        try {
            id = Integer.parseInt(monthsId);
            if (!months.containsMonthId(id))
                throw new NumberFormatException();
        } catch (NumberFormatException e) {
            return this.INCORRECT_OUTPUT;
        }
        return this.getOutputFormat(this.getMonthName(id));
    }

    private String getOutputFormat(String monthName) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = monthName.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            stringBuilder.append(chars[i]);
            if (i < chars.length - 1) {
                stringBuilder.append("-");
            }
        }
        return stringBuilder.toString().toUpperCase();
    }
}