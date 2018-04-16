package LaiOffer.Class21._MergeStones;
import java.util.*;

public class Solution {
    private class Cost {
        public final int[][] cost;

        public Cost(int i, int j) {
            cost = new int[i][j];
        }

        public int get(int i, int j) {
            return (i == j) ? 0 : cost[cost.length - 1 - i][cost.length - 1 - j];
        }

        public void set(int i, int j, int value) {
            if (i != j) {
                cost[cost.length - 1 - i][cost.length - 1 - j] = value;
            }
        }
    }

    public int minCost(int[] stones) {
        // Write your solution here
        Cost cost = new Cost(stones.length, stones.length);
        for (int end = 0; end < stones.length; ++end) {
            for (int start = end; start >= 0; --start) {
                if (start == end) {
                    cost.cost[start][end] = stones[start];
                    cost.set(start, end, 0);
                } else {
                    cost.cost[start][end] = cost.cost[start][end - 1] + stones[end];
                    cost.set(start, end, Integer.MAX_VALUE);
                    for (int i = start; i < end; ++i) {
                        cost.set(start, end, Math.min(cost.get(start, end), cost.get(start, i) + cost.get(i + 1, end) + cost.cost[start][end]));
                    }
                }
            }
        }
        return cost.get(0, stones.length - 1);
    }
}

/*
public class Solution {
    public int minCost(int[] stones) {
        // Write your solution here

        int[][] subSum = new int[stones.length][stones.length];
        int[][] cost = new int[stones.length][stones.length];

        for (int end = 0; end < stones.length; ++end) {
            for (int start = end; start >= 0; --start) {
                if (start == end) {
                    subSum[start][end] = stones[start];
                    cost[start][end] = 0;
                } else {
                    subSum[start][end] = subSum[start][end - 1] + stones[end];
                    cost[start][end] = Integer.MAX_VALUE;
                    for (int i = start; i < end; ++i) {
                        cost[start][end] = Math.min(cost[start][end], cost[start][i] + cost[i + 1][end] + subSum[start][end]);
                    }
                }
            }
        }
        return cost[0][stones.length - 1];
    }
}
*/
/*
public class Solution {
    private class DoubleLinkedListNode {
        public DoubleLinkedListNode left = null;
        public DoubleLinkedListNode right = null;
        public final int value;

        public DoubleLinkedListNode(int v) {
            value = v;
        }
    }

    private class WeightNode {
        public WeightNode left = null;
        public WeightNode right = null;
        public DoubleLinkedListNode leftNode = null;
        public DoubleLinkedListNode rightNode = null;
        public final int value;

        public WeightNode(int v) {
            value = v;
        }
    }

    public int minCost(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        PriorityQueue<WeightNode> pq = new PriorityQueue<>(new Comparator<WeightNode>() {
            @Override
            public int compare(WeightNode o1, WeightNode o2) {
                if (o1.value > o2.value) {
                    return 1;
                }
                if (o1.value < o2.value) {
                    return -1;
                }
                return 0;
            }
        });

        int ans = 0;
        Set<WeightNode> lazyDelete = new HashSet<>();
        initializeLinkedListNodesAndWeights(pq, stones);

        while (true) {
            WeightNode addWeight = null;
            while (addWeight == null || lazyDelete.remove(addWeight)) {
                addWeight = pq.poll();
            }
            ans += addWeight.value;
            DoubleLinkedListNode newNode = mergeNodes(addWeight.leftNode, addWeight.rightNode);
            mergeAll(addWeight, lazyDelete, pq, newNode);

            if (newNode.left == null && newNode.right == null) {
                return ans;
            }
        }
    }

    private void mergeAll(WeightNode addWeight, Set<WeightNode> lazyDelete, PriorityQueue<WeightNode> pq, DoubleLinkedListNode newNode) {

        WeightNode newLeftLeft = null;
        WeightNode newRightRight = null;
        WeightNode newLeft = null;
        WeightNode newRight = null;
        if (addWeight.left != null) {
            lazyDelete.add(addWeight.left);
            newLeftLeft = addWeight.left.left;
        }
        if (addWeight.right != null) {
            lazyDelete.add(addWeight.right);
            newRightRight = addWeight.right.right;
        }

        if (newNode.left != null) {
            newLeft = new WeightNode(newNode.value + newNode.left.value);
            newLeft.left = newLeftLeft;
            newLeft.leftNode = newNode.left;
            newLeft.rightNode = newNode;
        }

        if (newNode.right != null) {
            newRight = new WeightNode(newNode.value + newNode.right.value);
            newRight.right = newRightRight;
            newRight.rightNode = newNode.right;
            newRight.leftNode = newNode;
        }

        if (newLeft != null) {
            newLeft.right = newRight;
            pq.add(newLeft);
        }
        if (newRight != null) {
            newRight.left = newLeft;
            pq.add(newRight);
        }
    }

    private DoubleLinkedListNode mergeNodes(DoubleLinkedListNode left, DoubleLinkedListNode right) {
        DoubleLinkedListNode newNode = new DoubleLinkedListNode(left.value + right.value);
        newNode.left = left.left;
        newNode.right = right.right;

        if (left.left != null) {
            left.left.right = newNode;
        }
        if (right.right != null) {
            right.right.left = newNode;
        }
        return newNode;
    }

    private void initializeLinkedListNodesAndWeights(PriorityQueue<WeightNode> pq, int[] stones) {
        DoubleLinkedListNode root = null;
        WeightNode preWeights = null;

        for (int i = 0; i < stones.length; ++i) {
            if (i == 0) {
                root = new DoubleLinkedListNode(stones[i]);
                continue;
            }

            root.right = new DoubleLinkedListNode(stones[i]);
            DoubleLinkedListNode tmp = root;
            root = root.right;
            root.left = tmp;

            WeightNode weight = new WeightNode(root.value + root.left.value);
            weight.leftNode = root.left;
            weight.rightNode = root;

            if (preWeights != null) {
                preWeights.right = weight;
                weight.left = preWeights;
            }

            preWeights = weight;
            pq.add(weight);
        }
    }
}
*/
