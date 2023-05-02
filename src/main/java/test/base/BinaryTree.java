package test.base;


import org.junit.jupiter.api.Test;

import java.util.*;

public class BinaryTree {

    @Test
    public void testMain() {
        Integer[] treeArray = new Integer[] {3,9,20,null,null,15,7};
        TreeNode root = initBinaryTree(treeArray);
        System.out.println(minDepthBFS(root));
        traversalTree(root);
    }

    /**
     * 层序创建二叉树
     * @param treeArray
     * @return
     */
    public TreeNode initBinaryTree(Integer[] treeArray) {
        TreeNode root = new TreeNode(treeArray[0]);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode current = null;
        Integer value =null;
        int i=1;
        while (i<treeArray.length){
            current = queue.poll();
            value = treeArray[i++];
            if(value !=null) {
                TreeNode left = new TreeNode(value);
                current.left = left;
                queue.offer(left);
            }
            if(i ==treeArray.length) break;
            value= treeArray[i++];
            if(value!=null) {
                TreeNode right = new TreeNode(value);
                current.right = right;
                queue.offer(right);
            }
        }

        return root;
    }

    //层序遍历，Q102
    public void traversalTree(TreeNode root){
        if(root ==null) {
            System.out.println(new ArrayList<>());
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count =queue.size();
            List<Integer> list = new ArrayList<>();
            while (count>0) {
                TreeNode node =queue.poll();
                list.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right!=null) {
                    queue.add(node.right);
                }
                count--;
            }
            res.add(list);
        }
        System.out.println(res);
    }

    public int minDepthBFS(TreeNode root) {
        if(root== null) {
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        int depth =1;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for(int i=0;i<sz;i++) {
                TreeNode cur = queue.poll();
                if(cur.left == null && cur.right ==null) {
                    return depth;
                }
                if(cur.left !=null) {
                    queue.offer(cur.left);
                }
                if(cur.right!=null) {
                    queue.offer(cur.right);
                }
                depth++;
            }
        }
        return depth;
    }
}
