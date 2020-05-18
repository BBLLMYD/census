package record.practice.base;

import java.util.LinkedList;

/**
 * 有向无环图
 *
 * @author mqw
 * @create 2020-05-17-3:23 下午
 */
public class Graph {

        private int v; // 顶点的个数
        private LinkedList<Integer> adj[]; // 邻接表

        public Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for (int i=0; i<v; ++i) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t) { // s先于t，边s->t
            adj[s].add(t);
        }


}

