package com.epam.mjc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source     source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        //throw new UnsupportedOperationException("You should implement this method.");
        List<String> list = new ArrayList<>();
        int start = 0, end;

        while (start < source.length()) {
            end = source.length();
            for (String s : delimiters) {
                int index = source.indexOf(s, start);
                if (index != -1 && index < end) {
                    end = index;
                }
            }

            if (end != source.length()) {
                if(!source.substring(start, end).equals("")) {
                    list.add(source.substring(start, end));
                }
                start = end + 1;
            } else {
                if(!source.substring(start).equals("")) {
                    list.add(source.substring(start));
                }
                break;
            }
        }
        return list;
    }
}
