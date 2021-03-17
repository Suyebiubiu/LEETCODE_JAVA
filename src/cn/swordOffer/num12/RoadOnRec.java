package cn.swordOffer.num12;

/**
 * @author GONG
 * @version 1.0
 * @date 2021/3/9 20:01
 * 用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 */
public class RoadOnRec {
    /**
     * 矩阵搜索问题
     * DFS+剪枝操作
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        //判断运行是否超过界限，上下左右的界限是固定的
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1) return false;
        //如果当前元素不等于word中第k个元素的话，直接看矩阵中下一个元素
        if (board[i][j] != words[k]) return false;

        //如果当前元素等于word中第k个元素，并且k已经到最后一个了，表示结束了，查找成功
        if (words.length - 1 == k) return true;
        board[i][j] = '\0';//将查找成功的那个元素设置为 "\0" ,目的是防止再次查找他

        // 当前元素查找成功之后，再上下左右查找下一个元素
        boolean res = dfs(board, words, i - 1, j, k + 1)
                || dfs(board, words, i + 1, j, k + 1)
                || dfs(board, words, i, j - 1, k + 1)
                || dfs(board, words, i, j + 1, k + 1);
        //用来进行回溯的，如果当前的节点不满足路径要求，
        // 需要撤回到上一个节点，
        // 然而上一个节点此时已经赋值为“/”，需要还原一下，继续探索
        board[i][j] = words[k];
        return res;
    }

    public static void main(String[] args) {
        char[][] arr = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(new RoadOnRec().exist(arr, word));
    }
}
