import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.stream.IntStream;


public class tic_tac_toe implements ActionListener{
private final JFrame frame;
private final JPanel panel;
private final JButton [] buttons = new JButton[9];
private boolean xTurn = true;
public  tic_tac_toe(){
    frame = new JFrame("Tic-Tac-Toe");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    panel = new JPanel();
    panel.setLayout(new GridLayout(3,3));
    panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    IntStream.range(0, 9).forEach(i -> {
        buttons[i] = new JButton();
        buttons[i].setFont(new Font("Arial", Font.PLAIN, 40));
        buttons[i].addActionListener(this);
        panel.add(buttons[i]);
    });
    frame.add(panel, BorderLayout.CENTER);
    frame.setSize(400,400);
    frame.setVisible(true);

}
    @Override
    public void actionPerformed(ActionEvent e) {
    JButton button = (JButton) e.getSource();
    if(xTurn){
        button.setText("X");
    }else{
        button.setText("O");
    }
    button.setEnabled(false);
    xTurn = !xTurn;
    checkWinner();
    }
    public void checkWinner(){
    for(int i=0; i<9; i+=3){
        if (buttons[i].getText().equals(buttons[i + 1].getText()) && buttons[i].getText().equals(buttons[i + 2].getText()) && !buttons[i].isEnabled()) {
          JOptionPane.showMessageDialog(frame, buttons[i].getText()+" wins!");
          reset();
          return;
        }
    }
    for (int i = 0; i<3; i++){
        if (buttons[i].getText().equals(buttons[i+3].getText()) && buttons[i].getText().equals(buttons[i+6].getText())&& !buttons[i].isEnabled()){
            JOptionPane.showMessageDialog(frame, buttons[i].getText() + " wins!");
            reset();
            return;
        }
    }
    if(buttons[0].getText().equals(buttons[4].getText()) &&
        buttons[0].getText().equals(buttons[8].getText()) &&
            !buttons[0].isEnabled()){
        JOptionPane.showMessageDialog(frame, buttons[0].getText() + " wins!");
        reset();
        return;
    }

        if(buttons[2].getText().equals(buttons[4].getText()) &&
                buttons[2].getText().equals(buttons[6].getText()) &&
                !buttons[2].isEnabled()){
            JOptionPane.showMessageDialog(frame, buttons[2].getText() + " wins!");
            reset();
            return;
        }
        boolean tie = true;
        for (int i=0; i<9; i++){
            if(buttons[i].isEnabled()){
                tie = false;
                break;
            }
        }
        if(tie){
            JOptionPane.showMessageDialog(frame, "Tie game!");
            reset();
        }
    }
    public void reset(){
    for(int i=0; i<9;i++){
        buttons[i].setText("");
        buttons[i].setEnabled(true);
    }
    xTurn = true;
    }

    public static void main(String[] args){
        new tic_tac_toe();
    }
}

