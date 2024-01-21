import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.awt.*;


public class TicTacToeUI extends JFrame implements ActionListener{
    public JPanel centerPanel;
    public JPanel aiPanel = new JPanel();
    public JPanel themePanel = new JPanel();
    public JButton[][] buttons = new JButton[3][3];
    // public JButton playButton = new JButton("Play");
    public JButton startWithRandomAI = new JButton("Start With Random AI");
    public JButton startWithDefensiveAI = new JButton("Start With Defensive AI ");
    public JLabel statusLabel = new JLabel("");
    public   JButton classicButton;
    public JButton forrestButton;
    public  JButton highContrastButton;
    


    //theme selected
    public int highContrastThemeSelected= 0;
    public int classicThemeSelected=0;
    public int forrestThemeSelected =0;

    //Instantiate
   public RandomAi random =null;
   public DefensiveAi defensive =null;
    Design design =new Design();
    public ClassicTheme classicTheme =null;
    public ForestTheme forestTheme =null;
    public HIghContrastTheme highContrastTheme =null;
    public TicTacToeAI game = null;
    public int human = 0;
    public int computer = 0;
    public boolean isPlay = false;
    public String[] chars = new String[]{"", "X", "O"};

    public int x=0;
    public int o=0;
    public int  randomAiSelected=0;
    public int  defensiveAiselected=0;




    public TicTacToeUI() {

        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        centerPanel = new JPanel(new GridLayout(3, 3,2,2));

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton(" ");
                buttons[i][j].setFont(Design.font);
                buttons[i][j].addActionListener(this);

                buttons[i][j].setFocusable(false);
                centerPanel.add(buttons[i][j]);

            }

        startWithRandomAI.addActionListener(this);
        startWithDefensiveAI.addActionListener(this);

        JPanel northPanel = new JPanel();
        northPanel.add(statusLabel);

        JPanel southPanel = new JPanel();


        setButtonsEnabled(false);

        northPanel.setBorder(new EmptyBorder(20, 10, 20, 10));


        add(northPanel, "North");
        add(centerPanel, "Center");
        add(southPanel, "South");

        setSize(800, 800);
        setVisible(true);

        design.setAiPanel();
        aiPanel.add(startWithDefensiveAI);
        aiPanel.add(startWithRandomAI);

        //THEME PANEL

        classicButton = new JButton("Classic");
        forrestButton = new JButton("Forrest");
        highContrastButton = new JButton("High Contrast");

        classicButton.addActionListener(this);
        forrestButton.addActionListener(this);
        highContrastButton.addActionListener(this);

        themePanel.add(classicButton, BorderLayout.SOUTH);
        themePanel.add(forrestButton, BorderLayout.SOUTH);
        themePanel.add(highContrastButton);


        themePanel.setBorder(new EmptyBorder(20, 10, 20, 10));

        northPanel.add(aiPanel);
        southPanel.add(themePanel);


        setLocationRelativeTo(null);


    }


    public void setGameStatus(String s) {
        statusLabel.setText(s);
    }

    public void setButtonsEnabled(boolean enabled) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(enabled);
                if (enabled){
                    buttons[i][j].setText(" ");
                }
            }
    }



    // play button clicked
    public void play () {

        game = new TicTacToeAI();
        random =new RandomAi();
        defensive =new DefensiveAi();
        human = TicTacToeAI.HUMAN;
        computer = TicTacToeAI.COMPUTER;
        setGameStatus("Your Turn");
        setButtonsEnabled(true);
        isPlay = true;


    }


    public void actionPerformed (ActionEvent event){
        //classic theme

        if(event.getSource()==classicButton){
            ClassicTheme classicTheme = new ClassicTheme();
            dispose();
            highContrastThemeSelected=0;
            forrestThemeSelected=0;
            System.out.println("classic theme selected");
            for (int i=0; i<3; i++){
                for(int j=0;j<3;j++){

                    classicTheme.getClassicTheme(i,j);
                }
            }


        }


        //forrest theme
        if (event.getSource()== forrestButton){
            ForestTheme forestTheme= new ForestTheme();
            dispose();
            classicThemeSelected=0;
            highContrastThemeSelected=0;
            System.out.println("Forrest theme selected");
            for (int i=0; i<3; i++){
                for(int j=0;j<3;j++){
                    forestTheme.getForestTheme(i,j);

                }
            }

        }
        //high contrast

        if (event.getSource()== highContrastButton){
            HIghContrastTheme highContrastTheme = new HIghContrastTheme();
            dispose();
            classicThemeSelected=0;
            forrestThemeSelected=0;
            System.out.println("High contrast theme selected");
            for (int i=0; i<3; i++){
                for(int j=0;j<3;j++){
                    highContrastTheme.getHighContrastTheme(i,j);

                }
            }

        }

        if (event.getSource() == startWithRandomAI) {

            play();
            defensiveAiselected=0;
            randomAiSelected=1;
        }


        else if (event.getSource() == startWithDefensiveAI) {

            play();
            randomAiSelected=0;
            defensiveAiselected =1;
        }

        else {
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    if (event.getSource() == buttons[i][j]) {

                        humanTurn(i, j);

                    }
        }

    }

    //player move
    public void humanTurn ( int i, int j){

        if (game.getBoardValue(i, j) == TicTacToeAI.EMPTY) {

            playerMoveTheme(i,j);

            if (randomAiSelected==1){
                random.setBoardValue(i,j,human);
            }
            else{
                defensive.setBoardValue(i, j, human);
            }


            checkState();
            if(randomAiSelected==1){

                randomAiTurn();
            }
            else if(defensiveAiselected==1){

                defensiveAiturn();
            }

        }
    }

    //random AI move
    public void randomAiTurn() {
        System.out.println("RANDOM AI MOVE");
        if (!isPlay)
            return;

        else {
            int[] pos = random.randomAiMove(computer);
            if (pos != null) {
                int i = pos[0];
                int j = pos[1];

                randomAiTheme(i,j);
            }
        }
        checkState();
    }

    //defensive AI
    public void defensiveAiturn(){
        System.out.println("DEFENSIVE AI MOVE");
        if (!isPlay)
            return;

        else {
            int[] pos = defensive.defensiveAiMove(computer);
            if (pos != null) {
                int i = pos[0];
                int j = pos[1];
                defensiveAiTheme(i,j);
            }

        }
        checkState();

    }


    public void checkState(){
        if( defensive.isWin(human)|| random.isWin(human)) {
            gameOver("Congratulations, You've Won!");
        }
        if(defensive.isWin(computer) || random.isWin(computer)) {
            gameOver("Sorry, You Lose!");
        }

       if(random.randomAiMove(human)==null && random.randomAiMove(computer)==null) {
            gameOver("Draw!");
        }
        if (defensive.defensiveAiMove(human)==null && defensive.defensiveAiMove(computer)==null){
            gameOver("Draw");
        }



    }



    // determine game is over or not
    public void gameOver (String s){
        setGameStatus(s);
        setButtonsEnabled(false);
        isPlay = false;

    }


    public void randomAiTheme(int i, int j){

        if (highContrastThemeSelected==1){
            buttons[i][j].setForeground(Color.black);
            buttons[i][j].setText(chars[computer]);

            buttons[i][j].setBackground(Color.white);
            o=1;
        }
        else if(classicThemeSelected==1){
            buttons[i][j].setText(chars[computer]);
            o=1;
        }
        else if(forrestThemeSelected==1){


            buttons[i][j].setIcon(design.fruitIcon);

            o=1;
        }
        random.setBoardValue(i, j, computer);

    }


    public void defensiveAiTheme(int i,int j) {


        if (highContrastThemeSelected == 1) {
            buttons[i][j].setText(chars[computer]);
            buttons[i][j].setBackground(Color.white);
            o = 1;
        }
        else if (classicThemeSelected == 1) {
            buttons[i][j].setText(chars[computer]);
            o = 1;
        }
        else if (forrestThemeSelected == 1) {


            buttons[i][j].setIcon(design.fruitIcon);

            o = 1;
        }


        defensive.setBoardValue(i, j, computer);

    }


    public void playerMoveTheme(int i, int j){
        if (highContrastThemeSelected==1){
            buttons[i][j].setForeground(Color.white);
            buttons[i][j].setText(chars[human]);
            buttons[i][j].setBackground(Color.black);
            x=1;
        }
        else if(classicThemeSelected==1){
            buttons[i][j].setText(chars[human]);
            x=1;
        }
        else if(forrestThemeSelected==1){


            buttons[i][j].setIcon(design.flowerIcon);

            x=1;
        }
    }



}


