import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MazeSolver extends JFrame {
    int maze[][];
    ArrayList<Integer> path;
    public MazeSolver(int maze[][] ,ArrayList<Integer> path ){
        setTitle("Maze Solver");
        setSize(500 , 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.maze = maze;
        this.path = path;
    }
    @Override
    public void paint(Graphics g){
        g.translate(50,50);
        for(int i=0 ; i<maze.length ; i++){
            for(int j=0 ; j<maze[0].length ; j++) {
                Color color;
                if(i==0 || j==0 || i==maze.length-1 || j==maze[0].length-1){
                    color = Color.BLUE;
                }else {
                    if (maze[i][j] == 1) {
                        color = Color.BLACK;
                    } else if (maze[i][j] == 9) color = Color.RED;
                    else {
                        color = Color.WHITE;
                    }
                }
                if(i==1 && j==1) color = Color.GREEN;
                g.setColor(color);
                g.fillRect(j*30 , i*30 , 30 , 30);
                g.setColor(Color.RED);
                g.drawRect(j*30,i*30,30,30);
            }
        }
        Color color = Color.yellow;
        g.setColor(color);
        for(int i=path.size()-1 ; i >= 0 ; i=i-2){
            int x = path.get(i);
            int y = path.get(i-1);
            g.fillRect(x*30+5 , y*30+5 , 20 , 20);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int maze[][] = new int[m+2][n+2];
        for(int i=0 ; i<=n+1 ; i++){
            for(int j=0 ; j<=m+1 ; j++){
                if(i==0 || j==0 || i==maze.length-1 || j==maze[0].length-1){
                    maze[i][j] = 1;
                }else {
                    maze[i][j] = sc.nextInt();
                }
            }
        }
        ArrayList<Integer> path = BFS.bfs(maze , 1 , 1);
//        ArrayList<Integer> path = new ArrayList<>();
//        boolean check = DepthFirst.dfs(maze , 1 , 1 , path);
        MazeSolver view = new MazeSolver(maze ,path);
        view.setVisible(true);
    }
}
