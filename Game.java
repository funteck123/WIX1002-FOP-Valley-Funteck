import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.FlowLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName, monsterHpLabel, monsterHpLabelNumber;
;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 20);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int playerHP, monsterHP, monsterDamage, playerDamage;
    String weapon, position;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("ADVENTURE");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);

        window.setVisible(true); 
    }

    public void createGameScreen() {
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);


        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("This is the main text area.");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.red);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        con.add(choiceButtonPanel);

        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);

        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(2, 4));
        playerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        con.add(playerPanel);

        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);
        weaponLabel = new JLabel(" | Weapon:");
        weaponLabel.setFont(normalFont);
      weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);
        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);



        monsterHpLabel = new JLabel(" | Monster HP:"); // New label for monster HP
          monsterHpLabel.setFont(normalFont);
          monsterHpLabel.setVisible(false);
        monsterHpLabel.setForeground(Color.white);
          playerPanel.add(monsterHpLabel);
          monsterHpLabelNumber = new JLabel(); // New label for monster HP number
              monsterHpLabelNumber.setVisible(false);
      monsterHpLabelNumber.setFont(normalFont);
          monsterHpLabelNumber.setForeground(Color.white);
          playerPanel.add(monsterHpLabelNumber);

        playerSetup();
    }

    public void playerSetup() {
        playerHP = 15;
        monsterHP = 20;
        weapon = "Knife";
        weaponLabelName.setText(weapon);
        hpLabelNumber.setText("" + playerHP);

        townGate();
    }

    public void townGate() {
        position = "townGate";
        mainTextArea.setText("You are at the gate of the town. \nA guard is standing in front of you. \n\nWhat do you do?");
        displayTownGateASCIIArt();

        choice1.setText("Talk to the guard");
        choice2.setText("Attack the guard");
        choice3.setText("Leave");
        choice4.setText("");
    }

    public void talkGuard() {
        position = "talkGuard";
        mainTextArea.setText("Guard: Hello stranger. \nI have never seen your face. \n\nI'm sorry but we cannot let a stranger enter our town.");
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void attackGuard() {
        position = "attackGuard";
        mainTextArea.setText("Guard: Hey don't be stupid.\n\nThe guard hit you so hard that you gave up.\n(You receive 3 damage)");
        playerHP = playerHP - 3;
        hpLabelNumber.setText("" + playerHP);
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void crossRoad() {
        position = "crossRoad";
        mainTextArea.setText("You are at a crossroad. If you go south, you will go back to the town.");
        playerHP = playerHP + 2;
        hpLabelNumber.setText("" + playerHP);
        choice1.setText("Go north");
        choice2.setText("Go south");
        choice3.setText("Go east");
        choice4.setText("Go west");
    }

    public void north() {
        position = "north";
        mainTextArea.setText("There is a river. \nYou drink the water and rest at the riverside. \n\n(You receive 2 health)");
        displayRiverASCIIArt();
        playerHP = playerHP + 2;
        hpLabelNumber.setText("" + playerHP);
        choice1.setText("Go south");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void south() {
        position = "south";
        mainTextArea.setText("You are returning to Town's Gate.");
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void east() {
        position = "east";
        mainTextArea.setText("You walked into a forest and found a Long Sword! \n\n(You obtained a Long Sword!)");
        displayLongSwordASCIIArt();
        weapon = "Long Sword";
        weaponLabelName.setText(weapon);
        choice1.setText("Go west");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void west() {
        position = "west";
        mainTextArea.setText("You encounter a goblin!");
        displayGoblinASCIIArt();
        choice1.setText("Fight");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");
    }

    public void fight() {
        position = "fight";
        mainTextArea.setText("Monster HP: " + monsterHP + "\n\nWhat do you do?");
        monsterHpLabelNumber.setText("" + monsterHP);

        
        choice1.setText("Attack");
        choice2.setText("Run");
        choice3.setText("");
        choice4.setText("");
    }

    public void playerAttack() {
        position = "playerAttack";
        monsterHpLabel.setVisible(true);
        monsterHpLabelNumber.setVisible(true);
      
        int playerDamage = 0;

        if (weapon.equals("Knife")) {
            playerDamage = new java.util.Random().nextInt(5);
        } else if (weapon.equals("Long Sword")) {
            playerDamage = new java.util.Random().nextInt(12);
        }

        mainTextArea.setText("You attacked the monster and gave " + playerDamage + " damage!");

        monsterHP = monsterHP - playerDamage;

        monsterHpLabelNumber.setText("" + monsterHP);
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    
    
    public void monsterAttack() {
        position = "monsterAttack";

        int monsterDamage = 0;

        monsterDamage = new java.util.Random().nextInt(6);

        mainTextArea.setText("The monster attacked you and gave " + monsterDamage + " damage!");

        playerHP = playerHP - monsterDamage;

        hpLabelNumber.setText("" + playerHP);

        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void win() {
        position = "win";
        monsterHpLabel.setVisible(false);
        mainTextArea.setText("You defeated the monster! \nThe monster dropped a ring! \n\n(You obtained a cool Ring!) \n\nCongrats on completing the game! \n\n--Credits-- \nFunteck123");

        playerHP += 999999;
        hpLabelNumber.setText("" + playerHP);

        choice1.setText("Go east");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void lose() {
        position = "lose";
        monsterHpLabel.setVisible(false);
        mainTextArea.setText("You are dead! \n\n<GAME OVER>");
        
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void displayTownGateASCIIArt() {
        mainTextArea.append("\n"); // Add some space
        mainTextArea.append("     _______\n");
        mainTextArea.append("    |       |\n");
        mainTextArea.append("    |       |\n");
        mainTextArea.append("    |_______|\n");
        mainTextArea.append("\n\n");
    }

    public void displayRiverASCIIArt() {
        mainTextArea.append("\n"); // Add some space
        mainTextArea.append("  ~~~~~~\\~~~~~~\n");
        mainTextArea.append("         \\~~~~~~\\~\n");
        mainTextArea.append("          \\~~~~~~\\~\n");
        mainTextArea.append("          /~~~~~~~\\~\n");
        mainTextArea.append("         /~~~~~~~~~\\~\n");
        mainTextArea.append("        /~~~~~~~~~~~\\~\n");
        mainTextArea.append("       /~~~~~~~~~~~~~\\~\n");
        mainTextArea.append("      /~~~~~~~~~~~~~~~\\~\n");
        mainTextArea.append("      |~~~~~~~~~~~~~~~|\n");
        mainTextArea.append("\n\n");
    }

    public void displayLongSwordASCIIArt() {
        mainTextArea.append("\n"); // Add some space
        mainTextArea.append("         )   (\n");
        mainTextArea.append("         /   \\\n");
        mainTextArea.append("        /     \\\n");
        mainTextArea.append("        |     |\n");
        mainTextArea.append("        |     |\n");
        mainTextArea.append("        |     |\n");
        mainTextArea.append("        |     |\n");
        mainTextArea.append("        |     |\n");
        mainTextArea.append("\n\n");
    }

    public void displayGoblinASCIIArt() {
        mainTextArea.append("\n"); // Add some space
        mainTextArea.append("      ,     ,\n");
        mainTextArea.append("     {i}   {i}\n");
        mainTextArea.append("      \"\"\"\"\"\"\"\n");
        mainTextArea.append("\n\n");
    }



















































  
    public class TitleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            createGameScreen();
        }
    }

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();
            switch (position) {
                case "townGate":
                    switch (yourChoice) {
                        case "c1":
                            talkGuard();
                            break;
                        case "c2":
                            attackGuard();
                            break;
                        case "c3":
                            crossRoad();
                            break;
                        case "c4":
                            break;
                    }
                    break;

                case "talkGuard":
                    switch (yourChoice) {
                        case "c1":
                            townGate();
                            break;
                    }
                    break;

                case "attackGuard":
                    switch (yourChoice) {
                        case "c1":
                            townGate();
                            break;
                    }
                    break;
                case "crossRoad":
                    switch (yourChoice) {
                        case "c1":
                            north();
                            break;
                        case "c2":
                            south();
                            break;
                        case "c3":
                            east();
                            break;
                        case "c4":
                            west();
                            break;
                    }
                    break;
                case "north":
                    switch (yourChoice) {
                        case "c1":
                            crossRoad();
                            break;
                        case "c2":
                            break;
                        case "c3":
                            break;
                        case "c4":
                            break;
                    }
                    break;
                case "south":
                    switch (yourChoice) {
                        case "c1":
                            townGate();
                            break;
                        case "c2":
                            break;
                        case "c3":
                            break;
                        case "c4":
                            break;
                    }
                    break;
                case "east":
                    switch (yourChoice) {
                        case "c1":
                            crossRoad();
                            break;
                        case "c2":
                            break;
                        case "c3":
                            break;
                        case "c4":
                            break;
                    }
                    break;
                case "west":
                    switch (yourChoice) {
                        case "c1":
                            fight();
                            break;
                        case "c2":
                            east();
                            break;
                        case "c3":
                            townGate();
                            break;
                        case "c4":
                            break;
                    }
                    break;
                case "fight":
                    switch (yourChoice) {
                        case "c1":
                            playerAttack();
                            break;
                        case "c2":
                            crossRoad();
                            break;
                        case "c3":
                            break;
                        case "c4":
                            break;
                    }
                    break;
                case "playerAttack":
                    switch (yourChoice) {
                        case "c1":
                            if ((monsterHP-playerDamage) < 1) {
                                win();
                            } else {
                                monsterAttack();
                            }
                            break;
                        case "c2":
                            break;
                        case "c3":
                            break;
                        case "c4":
                            break;
                    }
                    break;
                case "monsterAttack":
                    switch (yourChoice) {
                        case "c1":
                            if ((playerHP-monsterDamage) < 1) {
                                lose();
                                monsterHP = 20;
                            } else {
                                playerAttack();
                            }
                            break;
                        case "c2":
                            break;
                        case "c3":
                            break;
                        case "c4":
                            break;
                    }
                    break;
                case "win":
                    switch (yourChoice) {
                        case "c1":
                            crossRoad();
                            break;
                        case "c2":
                            break;
                        case "c3":
                            break;
                        case "c4":
                            break;
                    }
                    break;
                case "lose":
                switch (yourChoice) {
                    case "c1":
                        crossRoad();
                        break;
                    case "c2":
                        break;
                    case "c3":
                        break;
                    case "c4":
                        break;
                }
                    break;
            }
        }
    }
}
