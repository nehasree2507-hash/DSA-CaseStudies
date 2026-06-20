import java.util.*;

public class CO6_GreedyDP {

    static class Activity {

        int start, finish;

        Activity(int s,int f){
            start=s;
            finish=f;
        }
    }

    static void activitySelection(){

        Activity[] arr={
                new Activity(1,3),
                new Activity(2,5),
                new Activity(4,7),
                new Activity(1,8),
                new Activity(8,9)
        };

        Arrays.sort(arr, Comparator.comparingInt(a -> a.finish));

        System.out.println("Selected Activities:");

        int last=-1;

        for(Activity a:arr){

            if(a.start>=last){

                System.out.println(a.start+" "+a.finish);
                last=a.finish;
            }
        }
    }

    static void knapsack(){

        int[] wt={2,3,4,5};
        int[] val={3,4,5,6};
        int W=5;

        int n=wt.length;

        int[][] dp=new int[n+1][W+1];

        for(int i=1;i<=n;i++){

            for(int w=1;w<=W;w++){

                if(wt[i-1]<=w)

                    dp[i][w]=Math.max(val[i-1]+dp[i-1][w-wt[i-1]],dp[i-1][w]);

                else

                    dp[i][w]=dp[i-1][w];
            }
        }

        System.out.println("\nKnapsack Value = "+dp[n][W]);
    }

    static void lcs(){

        String a="DOCUMENT";
        String b="DOCMNT";

        int[][] dp=new int[a.length()+1][b.length()+1];

        for(int i=1;i<=a.length();i++)
            for(int j=1;j<=b.length();j++)
                if(a.charAt(i-1)==b.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);

        System.out.println("LCS Length = "+dp[a.length()][b.length()]);
    }

    static void matrixChain(){

        int[] p={10,20,30,40};

        int n=p.length;

        int[][] m=new int[n][n];

        for(int L=2;L<n;L++){

            for(int i=1;i<n-L+1;i++){

                int j=i+L-1;

                m[i][j]=Integer.MAX_VALUE;

                for(int k=i;k<j;k++){

                    int q=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];

                    if(q<m[i][j])
                        m[i][j]=q;
                }
            }
        }

        System.out.println("Matrix Chain Cost = "+m[1][n-1]);
    }

    public static void main(String[] args){

        activitySelection();
        knapsack();
        lcs();
        matrixChain();
    }
}
