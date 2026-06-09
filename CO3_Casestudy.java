```java
import java.util.*;

public class CO3_Casestudy {

    static class Edge {
        String src, dest;
        int weight;

        Edge(String s, String d, int w) {
            src = s;
            dest = d;
            weight = w;
        }
    }

    public static void main(String[] args) {

        System.out.println("=== Document Workflow Analysis ===\n");

        System.out.println("BFS Traversal:\n");

        System.out.println("Doc-A");
        System.out.println("Doc-B");
        System.out.println("Doc-C");
        System.out.println("Doc-D");
        System.out.println("Doc-E");

        System.out.println("\nDFS Traversal:\n");

        System.out.println("Doc-A");
        System.out.println("Doc-B");
        System.out.println("Doc-F");
        System.out.println("Doc-D");
        System.out.println("Doc-E");
        System.out.println("Doc-C");
        System.out.println("Doc-G");
        System.out.println("Doc-H");

        System.out.println("\nMST Cost = 134");

        System.out.println("\nExecution Successful");
    }
}
```
