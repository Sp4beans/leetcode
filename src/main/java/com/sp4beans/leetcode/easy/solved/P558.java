package com.sp4beans.leetcode.easy.solved;

//        四叉树是一种树数据，其中每个结点恰好有四个子结点：topLeft、topRight、bottomLeft 和 bottomRight。四叉树通常被用来划分一个二维空间，递归地将其细分为四个象限或区域。
//
//        我们希望在四叉树中存储 True/False 信息。四叉树用来表示 N * N 的布尔网格。对于每个结点, 它将被等分成四个孩子结点直到这个区域内的值都是相同的。每个节点都有另外两个布尔属性：isLeaf 和 val。当这个节点是一个叶子结点时 isLeaf 为真。val 变量储存叶子结点所代表的区域的值。
//
//        例如，下面是两个四叉树 A 和 B：
//
//        A:
//        +-------+-------+   T: true
//        |       |       |   F: false
//        |   T   |   T   |
//        |       |       |
//        +-------+-------+
//        |       |       |
//        |   F   |   F   |
//        |       |       |
//        +-------+-------+
//        topLeft: T
//        topRight: T
//        bottomLeft: F
//        bottomRight: F
//
//        B:
//        +-------+---+---+
//        |       | F | F |
//        |   T   +---+---+
//        |       | T | T |
//        +-------+---+---+
//        |       |       |
//        |   T   |   F   |
//        |       |       |
//        +-------+-------+
//        topLeft: T
//        topRight:
//        topLeft: F
//        topRight: F
//        bottomLeft: T
//        bottomRight: T
//        bottomLeft: T
//        bottomRight: F
//         
//
//        你的任务是实现一个函数，该函数根据两个四叉树返回表示这两个四叉树的逻辑或(或并)的四叉树。
//
//        A:                 B:                 C (A or B):
//        +-------+-------+  +-------+---+---+  +-------+-------+
//        |       |       |  |       | F | F |  |       |       |
//        |   T   |   T   |  |   T   +---+---+  |   T   |   T   |
//        |       |       |  |       | T | T |  |       |       |
//        +-------+-------+  +-------+---+---+  +-------+-------+
//        |       |       |  |       |       |  |       |       |
//        |   F   |   F   |  |   T   |   F   |  |   T   |   F   |
//        |       |       |  |       |       |  |       |       |
//        +-------+-------+  +-------+-------+  +-------+-------+
//         
//
//        提示：
//
//        A 和 B 都表示大小为 N * N 的网格。
//        N 将确保是 2 的整次幂。
//        如果你想了解更多关于四叉树的知识，你可以参考这个 wiki 页面。
//        逻辑或的定义如下：如果 A 为 True ，或者 B 为 True ，或者 A 和 B 都为 True，则 "A 或 B" 为 True。

public class P558 {

    /*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/

    private class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }


//if(quadTree1.isLeaf && quadTree2.isLeaf){
//        return new Node(
//                quadTree1.val || quadTree2.val,
//                true,
//                null,
//                null,
//                null,
//                null
//        );
//    }
//    boolean hasTrue = quadTree1.isLeaf && quadTree1.val || quadTree2.isLeaf && quadTree2.val;
//        if(hasTrue){
//        return new Node(
//                true,
//                true,
//                null,
//                null,
//                null,
//                null
//        );
//    }
//        if((quadTree1.isLeaf || quadTree2.isLeaf)){
//        return quadTree1.isLeaf ? quadTree2 : quadTree1;
//    }
//    Node [] nodes = new Node[]{
//            this.intersect(quadTree1.topLeft, quadTree2.topLeft),
//            this.intersect(quadTree1.topRight, quadTree2.topRight),
//            this.intersect(quadTree1.bottomLeft, quadTree2.bottomLeft),
//            this.intersect(quadTree1.bottomRight, quadTree2.bottomRight)
//    };
//    boolean all_leaf = true;
//    boolean all_equal = true;
//        for (int i = 0; i < nodes.length; i++) {
//        if(!nodes[i].isLeaf){
//            all_leaf = false;
//            break;
//        }
//        if(i > 0){
//            if(nodes[i].val != nodes[i-1].val){
//                all_equal = false;
//            }
//        }
//    }
//        if(all_equal && all_leaf){
//        return new Node(
//                nodes[0].val,
//                true,
//                null,
//                null,
//                null,
//                null
//        );
//    }
//        return new Node(
//                false,
//                        false,
//                nodes[0],
//                nodes[1],
//                nodes[2],
//                nodes[3]
//    );


    private class Solution {
        public Node intersect(Node quadTree1, Node quadTree2) {
            if (null == quadTree1) return quadTree2;
            if (null == quadTree2) return quadTree1;
            if (quadTree1.isLeaf && quadTree2.isLeaf) {
                quadTree1.val = quadTree1.val || quadTree2.val;
                quadTree1.isLeaf = true;
            } else if (quadTree1.isLeaf && quadTree1.val || quadTree2.isLeaf && quadTree2.val) {
                quadTree1.val = true;
                quadTree1.isLeaf = true;
            } else if (quadTree1.isLeaf || quadTree2.isLeaf) {
                return quadTree1.isLeaf ? quadTree2 : quadTree1;
            } else {
                quadTree1.topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
                quadTree1.topRight = intersect(quadTree1.topRight, quadTree2.topRight);
                quadTree1.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
                quadTree1.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);

                boolean allLeaf = quadTree1.topLeft.isLeaf && quadTree1.topRight.isLeaf && quadTree1.bottomLeft.isLeaf && quadTree1.bottomRight.isLeaf;
                boolean allEqual = quadTree1.topLeft.val == quadTree1.topRight.val
                        && quadTree1.topLeft.val == quadTree1.bottomLeft.val
                        && quadTree1.topLeft.val == quadTree1.bottomRight.val;
                if (allLeaf && allEqual) {
                    quadTree1.val = quadTree1.topLeft.val;
                    quadTree1.isLeaf = true;
                } else {
                    quadTree1.val = false;
                    quadTree1.isLeaf = false;
                }
            }
            return quadTree1;
        }
    }
}
