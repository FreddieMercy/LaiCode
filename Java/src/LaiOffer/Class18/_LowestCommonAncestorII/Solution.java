package LaiOffer.Class18._LowestCommonAncestorII;


class TreeNodeP {
    public int key;
    public TreeNodeP left;
    public TreeNodeP right;
    public TreeNodeP parent;

    public TreeNodeP(int key, TreeNodeP parent) {
        this.key = key;
        this.parent = parent;
    }
}

public class Solution {
    private int getHeight(TreeNodeP o){
        int i = 0;

        while (o!=null){
            i++;
            o = o.parent;
        }

        return i;
    }

    public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
        // Write your solution here.

        if(one==null||two==null){
            return null;
        }
        int a = getHeight(one);
        int b = getHeight(two);
        int diff;

        TreeNodeP longer;
        TreeNodeP lower;

        if(a>b){
            diff = a-b;
            longer = one;
            lower = two;
        }
        else{
            diff=b-a;
            longer = two;
            lower = one;
        }

        while (diff--!=0){
            longer = longer.parent;
        }

        while (longer!=lower){
            longer = longer.parent;
            lower = lower.parent;
        }
        return longer;
    }
}
