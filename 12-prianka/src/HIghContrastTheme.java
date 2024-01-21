import java.awt.*;

public class HIghContrastTheme extends TicTacToeUI{

    public void getHighContrastTheme(int i,int j){
        buttons[i][j].setBackground(getHighContrastButton());
        centerPanel.setBackground(getHighContrastBackground());
        highContrastThemeSelected=1;
    }

    public Color getHighContrastButton(){
        return Color.DARK_GRAY;
    }

    public Color getHighContrastBackground(){
        return Color.LIGHT_GRAY;
    }

}
