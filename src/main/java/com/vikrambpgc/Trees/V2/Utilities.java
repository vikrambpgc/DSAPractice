package com.vikrambpgc.Trees.V2;
public class Utilities {

    private Utilities() {}
    
    private static class SingletonHelper {
        private static final Utilities INSTANCE = new Utilities();
    }

    public static Utilities getInstance() {
        return SingletonHelper.INSTANCE;
    }
    
    public int maxDepth(TreeNode a) {
        if (a == null) return 0;
        return (Math.max(maxDepth(a.left),maxDepth(a.right)) + 1);
    }
}
