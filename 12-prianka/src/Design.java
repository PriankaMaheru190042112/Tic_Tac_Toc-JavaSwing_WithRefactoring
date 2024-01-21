import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Design {
    static Color color =new Color(0,102,0);
    static  Font font = new Font("Arial", Font.BOLD, 32);

    ImageIcon flowerIcon =new ImageIcon(getClass().getResource("flower.png"));
    ImageIcon fruitIcon =new ImageIcon(getClass().getResource("strawberry.png"));


    public JPanel aiPanel = new JPanel();
    public JPanel themePanel = new JPanel();


    public  void setAiPanel(){

        aiPanel.setSize(200, 200);
        aiPanel.setBorder(new EmptyBorder(20, 10, 20, 10));

    }



}
