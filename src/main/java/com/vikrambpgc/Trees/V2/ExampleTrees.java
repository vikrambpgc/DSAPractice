package com.vikrambpgc.Trees.V2;
public class ExampleTrees {

    private ExampleTrees() {}
    
    private static class SingletonHelper {
        private static final ExampleTrees INSTANCE = new ExampleTrees();
    }

    public static ExampleTrees getInstance() {
        return SingletonHelper.INSTANCE;
    }
    
    public TreeNode getSimpleTree() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3= new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t4.right = t5;
        
        return t1;
        /*        1
            2        3
                   4
                     5*/
    }

}
