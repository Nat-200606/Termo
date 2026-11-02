import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class FrameBase extends JFrame implements KeyListener {
    int principal = 0;
    int linha = 0;
    int n = 5;
    FieldBase[][] caixa;
    Palavras palavra = new Palavras();
    String sorteada = palavra.sortear();
    char[] letras = new char[5];


    FrameBase() throws IOException, FontFormatException {
        this.setSize(530, 650);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocation(300,50);

        caixa = new FieldBase[n][n];

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                int posX = 10 + y * 100;         // coluna -> horizontal
                int posY = 10 + x * 120;         // linha  -> vertical
                caixa[x][y] = new FieldBase(posX, posY);
                caixa[x][y].addKeyListener(this);
                this.add(caixa[x][y]);
            }
        }


        habilitar();

        for (int x = 0; x < 5; x++){
            letras[x] = sorteada.charAt(x);
            System.out.println(letras[x]);
        }

        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

        e.consume();

        char c = e.getKeyChar();

        // Só aceita letras (ignora backspace, números, Enter, Tab...)
        if (!Character.isLetter(c)) {
            return;
        }

        caixa[linha][principal].setText(String.valueOf(c).toUpperCase());

        if (principal < 4) {
            principal++;
        }
        caixa[linha][principal].requestFocusInWindow();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            e.consume();

            if (caixa[linha][principal].getText().isEmpty() && principal > 0) {
                principal--;
            }
            caixa[linha][principal].setText("");
            caixa[linha][principal].requestFocusInWindow();
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            StringBuilder temp = new StringBuilder();
            for (int x = 0; x <5; x++) {
                temp.append(caixa[linha][x].getText());
            }
            if (!palavra.existe(temp.toString())){
                JOptionPane.showMessageDialog(null,"palavra nao existe");
            }else {
                int acertos = 0;
                for (int x = 0; x <5; x++){

                    for (int y = 0; y < 5; y++){
                        if (caixa[linha][x].getText().equals(String.valueOf(letras[y]))){
                            caixa[linha][x].setBackground(Color.ORANGE);
                        }
                    }

                    if (String.valueOf(letras[x]).equals(caixa[linha][x].getText())){
                        caixa[linha][x].setBackground(Color.GREEN);
                        caixa[linha][x].setForeground(Color.BLACK);
                        acertos++;
                    }

                }
                if (acertos == 5){
                    JOptionPane.showMessageDialog(null,"Ganhou!");
                    this.dispose();
                }
                linha++;
                principal = 0;
                if (linha > 4){
                    JOptionPane.showMessageDialog(null,"HAHA perdeu otario");
                    this.dispose();
                }
                caixa[linha][principal].requestFocus();
                habilitar();


            }
        }
    }



    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void habilitar(){
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                caixa[x][y].setEnabled(x == linha);

            }
        }
    }

}
