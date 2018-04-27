import java.util.Stack;

public class TreeTravesal {
    public static void main(String[] args){
        TreeNode root=new TreeNode(10);
        TreeNode node1=new TreeNode(6);
        TreeNode node2=new TreeNode(14);
        TreeNode node3=new TreeNode(4);
        TreeNode node4=new TreeNode(8);
        TreeNode node5=new TreeNode(12);
        TreeNode node6=new TreeNode(16);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;
        postOrderTravesalC(root);
    }
    //先序遍历递归实现
    public static void firstTravesal(TreeNode node){
        if(node==null)return;
        System.out.println(node.val);
        if(node.left!=null){
            firstTravesal(node.left);
        }
        if(node.right!=null){
            firstTravesal(node.right);
        }
    }
    //先序遍历循环实现
    //使用栈实现循环遍历二叉树
    //维护一个栈，将根节点入栈，然后只要栈不为空，出站并访问，

    //注意定位当前节点以及操作过程程序化
    //Step1:访问节点node,并将节点node入栈
    //Step2:判断node的左节点是否为空。若为空，则将栈顶节点出栈，并将栈顶元素的右孩子设为当前的节点node，循环至stpe1
    //若不为空，则将p的左孩子设为当前节点node
    //Step3：直到node为null，并且栈为空，则遍历结束
    public static void firstTravasalC(TreeNode node){
        if(node==null) return;
        Stack<TreeNode> s=new Stack<>();
        while (node!=null||!s.isEmpty()){
            while(node!=null){
                System.out.println(node.val);
                s.push(node);  //先访问再入栈
                node=node.left;
            }
            node=s.pop();
            node=node.right; //如果是null，出栈并处理右子树
        }
    }
    //中序遍历二叉树，递归实现
    public static void inOrderTravesal(TreeNode node){
        if(node==null) return;
        inOrderTravesal(node.left);
        System.out.println(node.val);
        inOrderTravesal(node.right);
    }
    //中序遍历二叉树，非递归实现，栈实现
    //处理过程：
    //step1:若其左孩子不为空，则将node入栈，并将node的左孩子置为node，然后对当前节点node进行相同的处理
    //step2：若其左孩子为空，则取栈顶元素并进行出栈操作，访问该栈顶元素，然后将栈顶节点的右孩子置为当前节点node
    //step3:直到node为null并且栈为空
    public static void inOrderTravesalC(TreeNode node){
        if(node==null) return;
        Stack<TreeNode> stack=new Stack<>();
        while (node!=null||!stack.isEmpty()){
            while (node!=null){
                stack.push(node);
                node=node.left;
            }
            node=stack.pop();
            System.out.println(node.val);
            node=node.right;
        }
    }
    //后序遍历递归形式实现
    public static void postOrderTravesal(TreeNode node){
        if(node==null) return;
        postOrderTravesal(node.left);
        postOrderTravesal(node.right);
        System.out.println(node.val);
    }
    //后续遍历非递归实现
    //若node不存在左孩子和右孩子，则可以直接访问它，若node存在左孩子和右孩子，但是左孩子和右孩子都访问过，则可以直接访问该节点
    //若非上述两种情况，则将右孩子和左孩子依次入栈。
    public static void postOrderTravesalC(TreeNode node){
        if(node==null) return;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode pre=null;
        stack.push(node);
        while (!stack.isEmpty()){
            node=stack.peek();
            if((node.left==null&&node.right==null)||(pre!=null&&(node.left==pre||node.right==pre))){
                System.out.println(node.val);
                node=stack.pop();
                pre=node;
            }else{
                if(node.right!=null){
                    stack.push(node.right);
                }
                if(node.left!=null){
                    stack.push(node.left);
                }
            }
        }
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(){}
    public TreeNode(int val){
        this.val=val;
    }
}
