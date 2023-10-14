import java.util.ArrayList;

public class DepthFirst {
    public static boolean dfs(int maze[][] , int i, int j , ArrayList<Integer> path){
        if(maze[i][j] == 9){
            path.add(i);
            path.add(j);
            return true;
        }
        if(maze[i][j]==0){
            maze[i][j] = 2;
            if(dfs(maze , i , j-1 , path)){
                path.add(i);
                path.add(j);
                return true;
            }
            if(dfs(maze , i , j + 1 , path )){
                path.add(i);
                path.add(j);
                return true;
            }if(dfs(maze , i-1 , j , path)){
                path.add(i);
                path.add(j);
                return true;
            }
            if(dfs(maze , i+1 , j , path )){
                path.add(i);
                path.add(j);
                return true;
            }
        }
        return false;
    }
}
