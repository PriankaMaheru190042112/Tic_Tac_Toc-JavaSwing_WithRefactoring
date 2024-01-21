import java.awt.*;

public class ForestTheme extends TicTacToeUI{

    public void getForestTheme(int i, int j){
        buttons[i][j].setBackground(getForestButton());
        centerPanel.setBackground(getForestBackground());

        forrestThemeSelected=1;
    }

    public Color getForestButton(){
     return Color.green;
    }

    public Color getForestBackground(){
        return  Design.color;
    }



}
