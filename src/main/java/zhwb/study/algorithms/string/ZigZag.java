package zhwb.study.algorithms.string;

/**
 * @author jack.zhang
 * @since 2015/7/26 0026
 */
public class ZigZag {
    public String convert(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows-2; idx >= 1 && i < len; idx--) // middle char
                sb[idx].append(c[i++]);
        }
        //append from sb[0] to sb[row]
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }
    public static void main(String[] args) {
        System.out.println(new ZigZag().convert("ABCDEFG", 3));
        System.out.println(new ZigZag().convert("ABCDEFG", 5));
    }
}
