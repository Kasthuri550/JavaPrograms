package collections;

import java.util.Comparator;

public class CustomComparator implements Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {
        String str1, str2;
        
        if (o1 instanceof String) {
            str1 = (String) o1;
        } else if (o1 instanceof StringBuffer) {
            str1 = o1.toString();
        } else {
            throw new IllegalArgumentException("Invalid object type: " + o1.getClass());
        }

        if (o2 instanceof String) {
            str2 = (String) o2;
        } else if (o2 instanceof StringBuffer) {
            str2 = o2.toString();
        } else {
            throw new IllegalArgumentException("Invalid object type: " + o2.getClass());
        }

        int len1 = str1.length();
        int len2 = str2.length();
        

        if (len1 != len2) {
            return Integer.compare(len1, len2);
        }
        return str1.compareTo(str2);
    }
}