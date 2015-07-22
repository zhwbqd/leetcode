package zhwb.study.algorithms.string;

import java.util.*;

/**
 * https://leetcode.com/problems/repeated-dna-sequences/
 * <p/>
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * <p/>
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * <p/>
 * For example,
 * <p/>
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * <p/>
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 *
 * @author jack.zhang
 * @since 2015/7/16 0016
 */
public class RepeatDNASeq {

    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> words = new HashSet<>();
        Set<Integer> doubleWords = new HashSet<>();
        List<String> rv = new ArrayList<>();
        char[] map = new char[26];
        //map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;

        for(int i = 0; i < s.length() - 9; i++) {
            int v = 0;
            for(int j = i; j < i + 10; j++) {
                v <<= 2;
                v |= map[s.charAt(j) - 'A'];
            }
            if(!words.add(v) && doubleWords.add(v)) {
                rv.add(s.substring(i, i + 10));
            }
        }
        return rv;
    }

    public List<String> findMemoryExceed(String s) {
        char[] chars = s.toCharArray();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length - 10; i++) {
            char[] tmp = new char[10];
            System.arraycopy(chars, i, tmp, 0, 10);
            String ten = new String(tmp);
            Integer count = map.get(ten);
            map.put(ten, count == null ? 1 : ++count);
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String t = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(new RepeatDNASeq().findRepeatedDnaSequences(t));
    }
}

