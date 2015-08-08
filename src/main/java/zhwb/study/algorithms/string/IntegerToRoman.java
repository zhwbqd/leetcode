package zhwb.study.algorithms.string;

/**
 * https://leetcode.com/problems/integer-to-roman/
 * <p/>
 * Given an integer, convert it to a roman numeral.
 * <p/>
 * Input is guaranteed to be within the range from 1 to 3999.
 * <p/>
 * �������ֹ���7������I��1����V��5����X��10����L��50����C��100����D��500����M��1000����
 * ���������Ĺ�����Ա�ʾ��������������Ҫע���������������û�С�0�������λ���޹ء�һ����Ϊ��������ֻ�������������������㡣
 * <p/>
 * �ظ����Σ�һ�����������ظ����Σ��ͱ�ʾ������ļ�����
 * �Ҽ������
 * �ڽϴ���������ֵ��ұ߼��Ͻ�С���������֣���ʾ�����ּ�С���֡�
 * �ڽϴ���������ֵ���߼��Ͻ�С���������֣���ʾ�����ּ�С���֡�
 * ��������������ƣ�������I��X��C������45������д��VL��ֻ����XLV
 * ���ǣ����ʱ���ɿ�Խһ��λ�������磬99��������IC��100 - 1����ʾ��������XCIX��[100 - 10] + [10 - 1]����ʾ������ͬ�ڰ���������ÿλ���ֱַ��ʾ����
 * ������ֱ���Ϊһλ������8д��VIII������IIX��
 * �Ҽ����ֲ�������������λ������14д��XIV������XIIII�������·����������ơ�һ���
 * ���߳�ǧ��
 * ���������ֵ��Ϸ�����һ�����߻��߼����±��?����ʾ�����������1000������ԭ����1000����
 * ͬ������Ϸ����������ߣ�����ԭ����1000000��1000^{2}������
 * �������ƣ�
 * ͬһ�������ֻ�ܳ������Σ���40���ɱ�ʾΪXXXX����Ҫ��ʾΪXL��
 * ���⣺����IV�ǹ���������������أ���IVPITER����������ĸ��û��J��U�������֣������ʱ��IIII����IV��
 *
 * @author jack.zhang
 * @since 2015/8/5 0005
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        int remain = num;
        remain = handle(sb, remain, 1000, "M", 100, "C");
        remain = handle(sb, remain, 500, "D", 100, "C");
        remain = handle(sb, remain, 100, "C", 10, "X");
        remain = handle(sb, remain, 50, "L", 10, "X");
        remain = handle(sb, remain, 10, "X", 1, "I");
        remain = handle(sb, remain, 5, "V", 1, "I");
        handle(sb, remain, 1, "I", 0, "");
        return sb.toString();
    }

    private int handle(StringBuilder sb, int num, int dividend, String sign, int subDiv, String subSign) {
        int factor;
        int remainder;
        int temp = dividend - subDiv;
        if (num >= temp) {
            factor = num / dividend;
            remainder = num % dividend;
            for (int i = 0; i < factor; i++) {
                sb.append(sign);
            }
            if (remainder >= temp) {
                sb.append(subSign).append(sign);
                remainder -= temp;
            }
            return remainder;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new IntegerToRoman().intToRoman(29));
        System.out.println(new IntegerToRoman().intToRoman(24));
        System.out.println(new IntegerToRoman().intToRoman(26));
        System.out.println(new IntegerToRoman().intToRoman(20));
        System.out.println(new IntegerToRoman().intToRoman(1));
        System.out.println(new IntegerToRoman().intToRoman(9));
        System.out.println(new IntegerToRoman().intToRoman(40));
        System.out.println(new IntegerToRoman().intToRoman(41));//XLI
    }
}
