package com.atzj.xiaoyi.BFSANDDFS;

/**
 * 类描述：
 *
 * @author zhoujing129
 */
public class Test {
    public static void main(String[] args) {
        int Data[][] = { {1,2},{1,8},{2,1},{2,3},{3,2},
                {2,4},{4,2},{4,5},{4,6},{4,7}
                ,{5,4},{5,6},{6,4},{6,5},{6,7},{7,4},{7,6}
                ,{8,1},{8,9},{8,10},{9,8},{9,10},{10,9},{10,8}};
        int DataNum;
        int i,j;
        System.out.println("图形的邻接表内容为：");
        for(i=1;i<11;i++) {
            DFS.run[i] = 0;
            DFS.head[i] = new DFS();
            System.out.print("顶点" + i + "=>");
            for (j=0;j<Data.length;j++) {
                if(Data[j][0] == i) {
                    DataNum = Data[j][1];
                    DFS.head[i].insert(DataNum);
                }
            }
            DFS.head[i].print();
        }
        System.out.println("深度优先遍历顶点：");
        DFS.dfs(1);
        System.out.println("");

        for(i=1;i<11;i++) {
            BFS.run[i] = 0;
            BFS.head[i] = new BFS();
            for (j=0;j<Data.length;j++) {
                if(Data[j][0] == i) {
                    DataNum = Data[j][1];
                    BFS.head[i].insert(DataNum);
                }
            }
        }
        System.out.println("广度优先遍历顶点：");
        BFS.bfs(1);
        System.out.println("");

    }
}
