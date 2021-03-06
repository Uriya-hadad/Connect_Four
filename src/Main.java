import javax.swing.*;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static Board pan = new Board();

    public static void main(String[] args) {
        boolean win = false;
        int player = 2;
        JFrame frame = new JFrame("4 in a row");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(pan);
        frame.pack();
        frame.setVisible(true);
        while (!win) {
            player = (player == 2) ? 1 : 2;
            takeTurn(player);
            win = pan.colorExists(player);
        }
        JOptionPane.showMessageDialog(pan, "player " + player + " is the winner");
        frame.dispose();
    }

    public static void takeTurn(int player) {
        boolean flag;
        int row;
        do {
            row = chackinput(player);
            flag = pan.ChackWhereEmpty(row - 1, player);
        } while (!flag);
    }

    private static int chackinput(int player) {
        int row;
        System.out.println("player " + player+", where do you want to put your disc?");
        row = in.nextInt();
        while (1 > row || row > 7) {
        System.out.println("choose a valid row!!");
            row = in.nextInt();
        }
        return row;
    }


}
