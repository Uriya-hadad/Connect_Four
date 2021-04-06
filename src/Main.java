import javax.swing.*;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static Board pan = new Board();

    public static void main(String[] args) {
        boolean win = false;
        int player = 1;
        JFrame frame = new JFrame("4 in a row");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(pan);
        frame.pack();
        frame.setVisible(true);
        while (!win) {
            takeTurn(player);
            win = pan.colorExists(player);
            player = (player == 1) ? 2 : 1;
        }
        JOptionPane.showMessageDialog(pan, "player " + player + " is the winner");
    }


    public static void takeTurn(int player) {
        boolean flag;
        int row;
        do {
            row = chackinput();
            flag = pan.ChackWhereEmpty(row - 1, player);
        } while (!flag);
    }

    private static int chackinput() {
        int row;
        System.out.println("where do you want to put your disc?");
        row = in.nextInt();
        while (1 > row || row > 7) {
        System.out.println("choose a valid row!!");
            row = in.nextInt();
        }
        return row;
    }


}
