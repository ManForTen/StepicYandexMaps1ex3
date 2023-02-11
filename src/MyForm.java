import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class MyForm extends JFrame{

    private JPanel panel;
    private JButton button1;
    private JLabel label;

    MyForm() throws HeadlessException{
        super("Карта");
    }

    public void run() {
        addGui();
        addButtonActionListener();
    }

    public void addGui() {
        add(panel);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void addButtonActionListener() {
        button1.addActionListener(e -> {
            try {
                addImage();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public void addImage() throws IOException {
        Image image = ImageIO.read(new URL("https://static-maps.yandex.ru/1.x/?l=map&pl=c:ec473fFF,f:00FF00A0," + "-80.290556,25.793333,-66.057884,18.415753,-64.786408,32.293660,-80.290556,25.793333"));
        label.setIcon(new ImageIcon(image));
    }

    public static void main(String[] args) {
        new MyForm().run();
    }
}
