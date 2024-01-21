import javax.swing.*;
import java.awt.*;

public  class ClassicTheme extends TicTacToeUI{



    public void getClassicTheme(int i,int j){
//        buttons[i][j].setBackground(Color.WHITE);
   //     centerPanel.setBackground(Color.BLACK);
        buttons[i][j].setBackground(getClassicButton());
        centerPanel.setBackground(getClassicBackground());

        classicThemeSelected=1;
    }
    public Color getClassicButton(){
        return Color.WHITE;

    }

    public Color getClassicBackground(){
        return Color.BLACK;
    }
}
