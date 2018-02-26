/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package _2017.August2017.Aug10th2017._315CountOfSmallerNumbersAfterSelf;
import java.util.*;
import java.lang.*;
/**
 *
 * @author junhao.zhang.freddie
 */
public class Solution {
    class Node {
        Node left, right;
        int val, sum, dup = 1;
        public Node(int v, int s) {
            val = v;
            sum = s;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, ans, i, 0);
        }
        return Arrays.asList(ans);
    }
    private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
        if (node == null) {
            node = new Node(num, 0);
            ans[i] = preSum;
        } else if (node.val == num) {
            node.dup++;
            ans[i] = preSum + node.sum;
        } else if (node.val > num) {
            node.sum++;
            node.left = insert(num, node.left, ans, i, preSum);
        } else {
            node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
        }
        return node;
    }
}
/*
public class Solution {
    private class FreddieTreeNode{
        public int Left = -1;
        public int Right = 0;
        public FreddieTreeNode LeftNode = null;
        public FreddieTreeNode RightNode = null;
        public FreddieTreeNode Parent = null;
        public FreddieTreeNode GrandParent = null;
        private int index = -1;
        private int value = -1;
        public int Index(){
            return index;
        }
        public int Value(){
            return value;
        }
        public FreddieTreeNode(int i, int v){
            index = i;
            value = v;
        }
    }
    private class FreddieTree{
        private Stack roots = new Stack();
        private FreddieTreeNode root=null;
        public FreddieTree(){}
        private void InsertRightOf(FreddieTreeNode node, FreddieTreeNode n){
            if(node!=n){
                if(node.Value()>n.Value()){
                    if(node.LeftNode==null || node.LeftNode.Index()==-1)
                    {
                        if(n.LeftNode==null){
                            n.LeftNode=new FreddieTreeNode(-1,-1);
                        }
                        initNodeLeft(node,n);
                    }
                    else{
                        InsertRightOf(node.LeftNode, n);
                    }
                }
                else if(node.RightNode==null){
                    initNodeRight(node,n);
                }
                else{
                    InsertRightOf(node.RightNode, n);
                }
            }
        }
        public void Insert(FreddieTreeNode node){
            if(root == null){
                root = node;
                root.LeftNode = new FreddieTreeNode(-1,-1);
            }
            while(!roots.empty()&&(((FreddieTreeNode)roots.peek()).Value()>node.Value())){
                if(node.LeftNode==null){
                    node.LeftNode = new FreddieTreeNode(-1,-1);
                }
                FreddieTreeNode tmp = (FreddieTreeNode)roots.pop();
                initNodeLeft(tmp,node);
            }
            InsertRightOf(root, node);
            if(node.LeftNode==null && 
               !roots.empty()&&
               ((FreddieTreeNode)roots.peek()).GrandParent!=null &&
               node.Value() >= ((FreddieTreeNode)roots.peek()).GrandParent.Value()){
                node.LeftNode = new FreddieTreeNode(-1,-1);
            }
            if(node.LeftNode!=null){
                roots.add(node);
            }
        }
        private FreddieTreeNode Search(int index, int value){
            FreddieTreeNode current = root;
            while(current.Index()!=index){
                if(value<current.Value()){
                    current = current.LeftNode;
                }
                else{
                    current = current.RightNode;
                }
            }
            return current;
        }
        private void findLeftOf(FreddieTreeNode sub){
            if(sub.Left>=0 | sub.Index()==-1){
                return;
            }
            if(sub.LeftNode==null){
                findLeftOf(sub.Parent);
                sub.Left = sub.Parent.Left;
            }
            else{
                sub.Left = GetLeft(sub.LeftNode);
            }
        }
        private void findRightOf(FreddieTreeNode sub){
            if(sub.Right>0 || sub.RightNode==null){
                return;
            }
            findRightOf(sub.RightNode);
            sub.Right = 1+sub.RightNode.Right;
        }
        public int GetResult(int index, int value){
            FreddieTreeNode sub = Search(index,value);
            findRightOf(sub);
            findLeftOf(sub);
            return sub.Left;
        }
        public int GetLeft(FreddieTreeNode node){
            findRightOf(node);
            findLeftOf(node);
            return 1+node.Left+node.Right;
        }
        private void initNodeRight(FreddieTreeNode base, FreddieTreeNode derive){
            base.RightNode = derive;
            derive.Parent = base;
            if(derive.GrandParent==null){
                derive.GrandParent=base.GrandParent;
            }
        }
        private void initNodeLeft(FreddieTreeNode base, FreddieTreeNode derive){
            if(derive.LeftNode==null){
                derive.LeftNode=new FreddieTreeNode(-1,-1);
            }
            base.LeftNode = derive;
            if(derive.GrandParent==null){
                derive.GrandParent = base;
            }
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        FreddieTree tree = new FreddieTree();
        List<Integer> ans = new ArrayList<Integer>();
        for(int i =0; i < nums.length;++i){
            tree.Insert(new FreddieTreeNode(i, nums[i]));
        }
        for(int i =0; i < nums.length;++i){
            ans.add(tree.GetResult(i, nums[i]));
        }
        return ans;
    }
}
*/

/*
public class Solution {
    private class FreddieTreeNode{
        public int Left = -1;
        public int Right = 0;
        public FreddieTreeNode LeftNode = null;
        public FreddieTreeNode RightNode = null;
        public FreddieTreeNode Previous = null;
        public FreddieTreeNode GrandParent = null;
        private int index = -1;
        private int value = -1;
        public int Index(){
            return index;
        }
        public int Value(){
            return value;
        }
        public FreddieTreeNode(int i, int v){
            index = i;
            value = v;
        }
    }
    private class FreddieTree{
        private Stack roots = new Stack();
        private FreddieTreeNode root=null;
        public FreddieTree(){}
        private void InsertRightOf(FreddieTreeNode node, FreddieTreeNode n){
            if(node!=n){
                if(node.GrandParent!=null && n.Value()>=node.GrandParent.Value()){
                    if(n.LeftNode==null){
                        n.LeftNode=new FreddieTreeNode(-1,-1);
                    }
                    InsertRightOf(node.GrandParent, n);
                }
                else if(node.Value()>n.Value()){
                    if(node.LeftNode==null || node.LeftNode.Index()==-1)
                    {
                        initNodeLeft(node, n);
                    }
                    else{
                        InsertRightOf(node.LeftNode, n);
                    }
                }
                else if(node.RightNode==null){
                    initNodeRight(node, n);
                }
                else{
                    InsertRightOf(node.RightNode, n);
                }
            }
        }
        private void initNodeRight(FreddieTreeNode base, FreddieTreeNode derive){
            base.RightNode = derive;
            derive.Previous = base;
            if(derive.GrandParent==null){
                derive.GrandParent=base.GrandParent;
            }
        }
        private void initNodeLeft(FreddieTreeNode base, FreddieTreeNode derive){
            if(derive.LeftNode==null){
                derive.LeftNode=new FreddieTreeNode(-1,-1);
            }
            base.LeftNode = derive;
            if(derive.GrandParent==null){
                derive.GrandParent = base;
            }
        }
        public void Insert(FreddieTreeNode node){
            if(root == null){
                root = node;
                root.LeftNode = new FreddieTreeNode(-1,-1);
            }
            while(!roots.empty()&&(((FreddieTreeNode)roots.peek()).Value()>node.Value())){
                FreddieTreeNode tmp = (FreddieTreeNode)roots.pop();
                initNodeLeft(tmp, node);
            }
            if(!roots.empty()){
                InsertRightOf((FreddieTreeNode)roots.peek(), node);
            }
            if(node.LeftNode!=null){
                roots.add(node);
            }
        }
        private FreddieTreeNode Search(int index, int value){
            FreddieTreeNode current = root;
            while(current.Index()!=index){
                
                if(value<current.Value()){
                    current = current.LeftNode;
                }
                else if(value>current.Value()){
                    current = current.RightNode;
                }
                else{
                    if(current.RightNode!=null){
                        current = current.RightNode;
                    }
                    else{
                        current = current.LeftNode;
                    }
                }
                
            }
            return current;
        }
        private void findLeftOf(FreddieTreeNode sub){
            if(sub.Left>=0 | sub.Index()==-1){
                return;
            }
            if(sub.LeftNode==null){
                findLeftOf(sub.Previous);
                sub.Left = sub.Previous.Left;
            }
            else{
                sub.Left = GetLeft(sub.LeftNode);
            }
        }
        private void findRightOf(FreddieTreeNode sub){
            if(sub.Right>0 || sub.RightNode==null || sub.RightNode.LeftNode!=null){
                return;
            }
            findRightOf(sub.RightNode);
            sub.Right = 1+sub.RightNode.Right;
        }
        public int GetResult(int index, int value){
            FreddieTreeNode sub = Search(index,value);
            findRightOf(sub);
            findLeftOf(sub);
            return sub.Left;
        }
        public int GetLeft(FreddieTreeNode node){
            findRightOf(node);
            findLeftOf(node);
            return 1+node.Left+node.Right;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        FreddieTree tree = new FreddieTree();
        List<Integer> ans = new ArrayList<Integer>();
        for(int i =0; i < nums.length;++i){
            tree.Insert(new FreddieTreeNode(i, nums[i]));
        }
        for(int i =0; i < nums.length;++i){
            ans.add(tree.GetResult(i, nums[i]));
        }
        return ans;
    }
}
*/

/*
public class Solution {
    private class FreddieTreeNode{
        public int Left = -1;
        public int Right = 0;
        public FreddieTreeNode LeftNode = null;
        public FreddieTreeNode RightNode = null;
        public FreddieTreeNode CanUse = null;
        public FreddieTreeNode Parent = null;
        public FreddieTreeNode GrandParent = null;
        private int index = -1;
        private int value = -1;
        public int Index(){
            return index;
        }
        public int Value(){
            return value;
        }
        public FreddieTreeNode(int i, int v){
            index = i;
            value = v;
        }
    }
    private class FreddieTree{
        private Stack roots = new Stack();
        private FreddieTreeNode root=null;
        public FreddieTree(){}
        private void InsertRightOf(FreddieTreeNode node, FreddieTreeNode n){
            if(node!=n){
                if(node.Value()>n.Value()){
                    if(node.LeftNode==null){
                        node.LeftNode = n;
                        if(node.Parent==null){
                            n.GrandParent = node;
                        }
                        else{
                            n.GrandParent = node.GrandParent;
                        }
                        if(node.CanUse==null || node.CanUse.Index()==-1)
                        {
                            if(n.CanUse==null){
                                n.CanUse=new FreddieTreeNode(-1,-1);
                            }
                            node.CanUse = n;
                            
                        }
                    }
                    else{
                        InsertRightOf(node.LeftNode, n);
                    }
                }
                else if(node.RightNode==null){
                    node.RightNode = n;
                    n.Parent = node;
                    n.GrandParent=node.GrandParent;
                }
                else{
                    InsertRightOf(node.RightNode, n);
                }
            }
        }
        public void Insert(FreddieTreeNode node){
            if(root == null){
                root = node;
                root.CanUse = new FreddieTreeNode(-1,-1);
            }
            while(!roots.empty()&&(((FreddieTreeNode)roots.peek()).Value()>node.Value())){
                if(node.CanUse==null){
                    node.CanUse = new FreddieTreeNode(-1,-1);
                }
                FreddieTreeNode tmp = (FreddieTreeNode)roots.pop();
                tmp.CanUse = node;
            }
            InsertRightOf(root, node);
            if(node.CanUse!=null){
                roots.add(node);
            }
        }
        private FreddieTreeNode Search(int index, int value){
            FreddieTreeNode current = root;
            while(current.Index()!=index){
                if(value<current.Value()){
                    current = current.LeftNode;
                }
                else{
                    current = current.RightNode;
                }
            }
            return current;
        }
        private void findLeftOf(FreddieTreeNode sub){
            if(sub.Left>=0 | sub.Index()==-1){
                return;
            }
            if(sub.CanUse==null){
                findLeftOf(sub.Parent);
                sub.Left = sub.Parent.Left;
            }
            else{
                sub.Left = GetLeft(sub.CanUse);
            }
        }
        private void findRightOf(FreddieTreeNode sub){
            if(sub.Right>0 || sub.RightNode==null||sub.RightNode.CanUse!=null){
                return;
            }
            findRightOf(sub.RightNode);
            sub.Right = 1+sub.RightNode.Right;
        }
        public int GetResult(int index, int value){
            FreddieTreeNode sub = Search(index,value);
            findRightOf(sub);
            findLeftOf(sub);
            return sub.Left;
        }
        public int GetLeft(FreddieTreeNode node){
            findRightOf(node);
            findLeftOf(node);
            return 1+node.Left+node.Right;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        FreddieTree tree = new FreddieTree();
        List<Integer> ans = new ArrayList<Integer>();
        for(int i =0; i < nums.length;++i){
            tree.Insert(new FreddieTreeNode(i, nums[i]));
        }
        for(int i =0; i < nums.length;++i){
            ans.add(tree.GetResult(i, nums[i]));
        }
        return ans;
    }
}
*/