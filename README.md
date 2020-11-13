# LEETCODE_JAVA
### 2020.10.22 leetcode344反转字符串
收获：for和while都可以解决这个问题，熟悉一下语法，双指针遍历，一个从前往后，一个从后往前。

### 2020.10.25 leetcode129  求根到叶子节点数字之和
空间复杂度主要取决于递归调用的栈空间，递归栈的深度等于二叉树的高度，最坏情况下，二叉树的高度等于节点个数，

**方法一：** 使用深度优先遍历方法

首先定义一个sum为0，遍历从根结点开始计算dfs(root,sum)，当根节点为空返回，否则，将之前和*10加上现在节点的值，赋值给sum变量。当左右为空时候，返回sum，否则返回dfs(left,sum)+dfs(right,sum)

**方法二：** 使用广度优先遍历

使用java中队列 linkedlist的父类是queue队列：Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();用到了里面的offer和poll方法
### 2020.11.13 剑指offer02 单例模式
单例模式，写了7种实现方式
