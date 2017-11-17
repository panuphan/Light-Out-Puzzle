import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by User on 11/6/2560.
 */
public class UI extends JPanel implements MouseListener {
    //Constants for game board - DONE
    public static final int rows = 5;
    public static final int cols = 5;

    //Constants for graphic drawing dimensions - DONE
    public static final int cellSize = 60; //cell width, height
    public static final int canvasWidth = cellSize * cols;
    public static final int canvasHeight = cellSize * rows;
    public static final int gridWidth = 4; //gridline width
    public static final int gridWidthHalf = gridWidth/2;

    //Constants for drawing symbols - DONE
    public static final int cellPadding = 4;
    public static final int symbolSize = cellSize - (cellPadding*2);
    public static final int symbolStrokeWidth = 8; //pen stroke width


    private int[][] board=new int[rows][cols];

    public UI() {
        this.setPreferredSize(new Dimension(canvasWidth,canvasHeight));
        addMouseListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        JFrame window=new JFrame();
        window.setLayout(new BorderLayout());
        window.setLocation(300,300);
        window.setBackground(Color.BLACK);
        window.setResizable(false);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(this,BorderLayout.CENTER);
        window.pack();

        init();

    }

    private void init() {
        board[0][0] = 1;
        board[0][1] = 1;
        board[0][2] = 1;
        board[0][3] = 1;
        board[0][4] = 0;
        board[1][0] = 0;
        board[1][1] = 0;
        board[1][2] = 0;
        board[1][3] = 0;
        board[1][4] = 0;
        board[2][0] = 0;
        board[2][1] = 0;
        board[2][2] = 0;
        board[2][3] = 1;
        board[2][4] = 0;
        board[3][0] = 1;
        board[3][1] = 0;
        board[3][2] = 0;
        board[3][3] = 0;
        board[3][4] = 1;
        board[4][0] = 0;
        board[4][1] = 1;
        board[4][2] = 0;
        board[4][3] = 1;
        board[4][4] = 0;
    }


    public void paint(Graphics g) {

        //Draw symbols in cells if not empty
        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(symbolStrokeWidth, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND));
        for(int row = 0; row < rows; ++row){
            for(int col = 0; col < cols; ++col){
                int x1 = col * cellSize + cellPadding;
                int y1 = row * cellSize + cellPadding;
                if(board[row][col] == 1){
                    g2d.setColor(Color.WHITE);
                    g2d.fillRect(x1, y1, symbolSize, symbolSize);
                }
                else if(board[row][col] == 0){
                    g2d.setColor(Color.BLACK);
                    g2d.fillRect(x1, y1, symbolSize, symbolSize);
                }
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        //Get row and col clicked
        int rowSelected = mouseY / cellSize;
        int colSelected = mouseX / cellSize;


        if(rowSelected >= 0 && rowSelected < rows && colSelected >= 0
                && colSelected < cols){
            //make move
            int r = rowSelected;
            int c = colSelected;
            if(board[r][c] == 1){board[r][c] = 0;}
            else{board[r][c] = 1;}
            if(r != 0){
                if(board[r-1][c] == 1){board[r-1][c] = 0;}
                else{board[r-1][c] = 1;}
            }
            if(c != (cols-1)){
                if(board[r][c+1] == 1){board[r][c+1] = 0;}
                else{board[r][c+1] = 1;}
            }
            if(r != (rows-1)){
                if(board[r+1][c] == 1){board[r+1][c] = 0;}
                else{board[r+1][c] = 1;}
            }
            if(c != 0){
                if(board[r][c-1] == 1){board[r][c-1] = 0;}
                else{board[r][c-1] = 1;}
            }

        }
        repaint();
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}


