package zhwb.study.array.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Description:
 * Given a collection of intervals, merge all overlapping intervals.
 * <p/>
 * Example:
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 *
 * @author jack.zhang
 * @since 2015/7/9 0009
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return Collections.emptyList();
        }
        //sort
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        //merge
        List<Interval> result = new ArrayList<>();
        Interval first = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (current.start <= first.end) {
                first = new Interval(first.start, Math.max(current.end, first.end));
            } else {
                result.add(first);
                first = current;
            }
        }
        result.add(first);
        return result;
    }

    public static void main(String[] args) {
        case1();
        case2();
        case3();
    }

    private static void case1() {
        List<Interval> origin = new ArrayList<>();
        origin.add(new Interval(1, 3));
        origin.add(new Interval(2, 6));
        origin.add(new Interval(8, 10));
        origin.add(new Interval(15, 18));
        List<Interval> merge = new MergeIntervals().merge(origin);
        System.out.println(merge);//[1,6],[8,10],[15,18]
    }

    private static void case2() {
        List<Interval> origin = new ArrayList<>();
        origin.add(new Interval(1, 4));
        origin.add(new Interval(0, 4));
        List<Interval> merge = new MergeIntervals().merge(origin);
        System.out.println(merge);//[0,4]
    }

    private static void case3() {
        List<Interval> origin = new ArrayList<>();
        origin.add(new Interval(1, 4));
        origin.add(new Interval(2, 3));
        List<Interval> merge = new MergeIntervals().merge(origin);
        System.out.println(merge);//[1,4]
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("start=").append(start);
        sb.append(", end=").append(end);
        sb.append('}');
        return sb.toString();
    }
}
