import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class Board extends JPanel {
    JButton[][] arrbtton;
    JLabel turnLabel = new JLabel("this is the turn of the:   ");
    JButton turnButton = new JButton();
    Color empty = Color.white, green = Color.GREEN, red = Color.RED;

    Board() {
        setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        arrbtton = new JButton[7][7];
        setPreferredSize(new Dimension(750, 750));
        for (int i = 0; i < arrbtton.length; i++) {
            for (int j = 0; j < arrbtton[i].length; j++) {
                arrbtton[i][j] = new JButton();
                arrbtton[i][j].setBackground(empty);
                if (i == 0) {
                    arrbtton[i][j].setContentAreaFilled(false);
                    arrbtton[i][j].setText(Integer.toString(j + 1));
                    arrbtton[i][j].setFont(new Font("Arial", Font.BOLD, 30));
                }
                arrbtton[i][j].setPreferredSize(new Dimension(100, 100));
                add(arrbtton[i][j]);
                add(turnLabel);
                turnButton.setPreferredSize(new Dimension(30,30));
                turnButton.setBackground(green);
                add(turnButton);
            }
        }
    }

    public boolean ChackWhereEmpty(int row, int player) {
        for (int i = 6; i > 0; i--) {
            if (arrbtton[i][row].getBackground() == empty) {
                arrbtton[i][row].setBackground((player == 1) ? green : red);
                turnButton.setBackground((player == 2) ? green : red);
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "can't put the disk because the row is full!");
        return false;

    }

    public boolean colorExists(int player) {
        boolean winner;
        Color current = (player == 1) ? green : red;
        for (int i = 1; i < arrbtton.length; i++) {
            for (int j = 0; j < arrbtton[i].length; j++) {
                if (arrbtton[i][j].getBackground() == current) {
                    winner = chackWin(i, j, current);
                    if (winner)
                        return winner;
                }
            }
        }
        return false;
    }

    private boolean chackWin(int row, int column, Color current) {
        int counter = 0;
        //column
        for (int i = 1; i < 7; i++) {
            if (arrbtton[i][column].getBackground() == current) {
                counter++;
                if (counter == 4) {
                    return true;
                }
            } else
                counter = 0;
        }
        counter = 0;
        //row
        for (int i = 0; i < 7; i++) {
            if (arrbtton[row][i].getBackground() == current) {
                counter++;
                if (counter == 4) {
                    return true;
                }
            } else
                counter = 0;
        }
        counter = 0;
        //slant
        int row_chack = row;
        int column_chack = column;
        while (row_chack != 6 && column_chack != 6) {
            row_chack++;
            column_chack++;
        }
        for (int i = row_chack, j = column_chack; j > 0 && i >= 0;
             j--, i--) {
            if (arrbtton[i][j].getBackground() == current) {
                counter++;
                if (counter == 4) {
                    return true;
                }
            } else
                counter = 0;
        }
        counter = 0;
        //slant_2

        while (row != 6 && column != 0) {
            row++;
            column--;
        }
        for (int i = row, j = column; j < 7 && i > 0;
             i--, j++) {
            if (arrbtton[i][j].getBackground() == current) {
                counter++;
                if (counter == 4) {
                    return true;
                }
            } else
                counter = 0;
        }
        return false;
    }
}
