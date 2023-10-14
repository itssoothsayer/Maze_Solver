import java.util.*;

public class BFS {

    static class Pair{
        int col;
        int row;
        Pair(int row, int col ){
            this.row = row;
            this.col = col;
        }
    }
    public static ArrayList bfs(int maze[][] , int i , int j){
        Queue<Pair> q = new LinkedList<>();
        Pair pre[][] = new Pair[maze.length][maze[0].length];
        //pre[i][j] = null;
        q.add(new Pair(i,j));
        maze[i][j] = 2;
        int[] dc = {0 , 1 , 0 , -1};
        int[] dr = {-1 , 0 , 1 , 0};
        Pair ans = null;
        while(q.size()!=0){
            Pair r = q.remove();
            for(int k=0 ; k < 4 ; k++){
                int newRow = r.row + dr[k];
                int newCol = r.col + dc[k];

                if(maze[newRow][newCol]==0){
                    q.add(new Pair(newRow , newCol));
                    pre[newRow][newCol] = new Pair(r.row , r.col);
                    maze[newRow][newCol]=2;
                }else if(maze[newRow][newCol]==9){
                    ans = new Pair(newRow , newCol);
                    pre[newRow][newCol] = new Pair(r.row , r.col);
                    break;
                }
            }
        }
        ArrayList<Integer> path = new ArrayList<>();
        if(ans == null) return path;

        while(ans!=null){
            path.add(ans.row);
            path.add(ans.col);
            ans = pre[ans.row][ans.col];
        }
        return path;
    }
}
