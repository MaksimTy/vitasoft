package org.example.vitasoft.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class StringSorterService {


    public List<String> getSortedStrings(String[] strings) {
        List<String> sorted = new ArrayList<>();
        sort(strings);
        for (String string : strings
        ) {
            String item = String.format("(%d): %s", string.trim().length(), string.trim());
            sorted.add(item);
        }
        return sorted;
    }

    public static void sort(String[] strings) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int length = o1.length() - o2.length();
                return length != 0 ? length : o1.compareTo(o2);
            }
        });
    }
}
