package org.example.vitasoft.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class Months {

    private final Map<Integer, String> months = new HashMap<>() {{
        put(1, "январь");
        put(2, "февраль");
        put(3, "март");
        put(4, "апрель");
        put(5, "май");
        put(6, "июнь");
        put(7, "июль");
        put(8, "август");
        put(9, "сентябрь");
        put(10, "октябрь");
        put(11, "ноябрь");
        put(12, "декабрь");
    }};

    public Months() {
    }

    public Map<Integer, String> getMonths() {
        return months;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Months)) return false;
        Months months1 = (Months) o;
        return Objects.equals(getMonths(), months1.getMonths());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMonths());
    }

    @Override
    public String toString() {
        return "Months{" +
                "months=" + Arrays.toString(
                months.entrySet()
                        .stream()
                        .map(item -> (item.getKey() + " : " + item.getValue()))
                        .toArray()) +
                '}';
    }
}
