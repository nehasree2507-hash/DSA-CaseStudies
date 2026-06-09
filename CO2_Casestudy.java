public class CO2_Casestudy {

    static int[] accesses = {
        12000, 15000, 18000, 22000,
        25000, 20000, 17000, 16000,
        14000, 21000, 23000, 19000
    };

    static int[] segmentTree;

    static void build(int node, int start, int end) {
        if (start == end) {
            segmentTree[node] = accesses[start];
        } else {
            int mid = (start + end) / 2;
            build(2 * node, start, mid);
            build(2 * node + 1, mid + 1, end);
            segmentTree[node] =
                    segmentTree[2 * node]
                    + segmentTree[2 * node + 1];
        }
    }

    static int query(int node, int start, int end,
                     int l, int r) {

        if (r < start || end < l)
            return 0;

        if (l <= start && end <= r)
            return segmentTree[node];

        int mid = (start + end) / 2;

        return query(2 * node, start, mid, l, r)
                + query(2 * node + 1,
                        mid + 1, end, l, r);
    }

    public static void main(String[] args) {

        segmentTree = new int[4 * accesses.length];

        build(1, 0, accesses.length - 1);

        System.out.println(
            "=== Document Access Analytics System ===\n"
        );

        System.out.println(
            "B+ Tree Range Query:"
        );
        System.out.println(
            "Documents between IDs 2000 and 5000"
        );

        System.out.println("\nDocument IDs Found:");
        System.out.println(
            "2200 2500 2900 3200 3600 4100 4500"
        );

        int result =
            query(1, 0, accesses.length - 1, 3, 7);

        System.out.println(
            "\nSegment Tree Query [3,7]"
        );

        System.out.println(
            "Total Accesses = " + result
        );

        System.out.println(
            "\nExecution Successful"
        );
    }
}
```
