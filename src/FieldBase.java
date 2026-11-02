import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FieldBase extends JTextField {
    FieldBase(int x, int y) throws IOException, FontFormatException {
        Font font = Font.createFont(Font.TRUETYPE_FONT, new File("Minecraft.ttf")).deriveFont(50f);

        this.setFont(font);
        this.setBackground(Color.GRAY);
        this.setSize(80,100);
        this.setHorizontalAlignment(CENTER);
        this.setLocation(x,y);
        this.setBorder(null);
        this.setEnabled(false);
    }
}
