class AVLNode {
    int documentId;
    String documentName;
    AVLNode left, right;
    int height;

    AVLNode(int documentId, String documentName) {
        this.documentId = documentId;
        this.documentName = documentName;
        this.height = 1;
    }
}

public class CO1_Casestudy {

    AVLNode root;

    int height(AVLNode node) {
        return (node == null) ? 0 : node.height;
    }

    int getBalance(AVLNode node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        System.out.println("RR Rotation at " + y.documentId);
        return x;
    }

    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        System.out.println("LL Rotation at " + x.documentId);
        return y;
    }

    AVLNode insert(AVLNode node, int documentId, String documentName) {

        if (node == null)
            return new AVLNode(documentId, documentName);

        if (documentId < node.documentId)
            node.left = insert(node.left, documentId, documentName);
        else if (documentId > node.documentId)
            node.right = insert(node.right, documentId, documentName);
        else
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // LL
        if (balance > 1 && documentId < node.left.documentId)
            return rightRotate(node);

        // RR
        if (balance < -1 && documentId > node.right.documentId)
            return leftRotate(node);

        // LR
        if (balance > 1 && documentId > node.left.documentId) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL
        if (balance < -1 && documentId < node.right.documentId) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    void inorder(AVLNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.documentId + " ");
            inorder(node.right);
        }
    }

    public static void main(String[] args) {

        CO1_Casestudy tracker = new CO1_Casestudy();

        int[] ids = {
            1001, 1045, 1078, 1102, 1134,
            1167, 1203, 1240, 1289, 1310
        };

        String[] docs = {
            "ProjectProposal",
            "EmployeeReport",
            "BudgetSheet",
            "Invoice",
            "MeetingNotes",
            "ClientContract",
            "AuditReport",
            "ResearchPaper",
            "PolicyDocument",
            "FinalSubmission"
        };

        System.out.println("=== Document Tracker AVL Execution ===\n");

        System.out.println("Inserted:\n");

        for (int i = 0; i < ids.length; i++) {
            System.out.print(ids[i] + " ");
            tracker.root = tracker.insert(
                    tracker.root,
                    ids[i],
                    docs[i]
            );

            if ((i + 1) % 5 == 0)
                System.out.println();
        }

        System.out.println("\n\nIn-Order Traversal:\n");
        tracker.inorder(tracker.root);

        System.out.println("\n\nAVL Tree Height = "
                + tracker.height(tracker.root));

        System.out.println("\n\nExecution Successful");
    }
}
```
