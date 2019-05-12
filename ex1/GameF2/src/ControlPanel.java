import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.midi.Soundbank;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;

public class ControlPanel extends JPanel implements GameControlListener{
  private GameController gc;
  private JButton playButton;
  private JLabel playerLabel;

  public ControlPanel(){
    gc = GameController.getInstance();
    gc.addControlListener(this);

    JButton exitButton = new JButton("Exit");
    exitButton.setForeground(Color.RED);
    exitButton.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 6));
    try{
      Font myFont = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("src/Belwe.ttf"));
      myFont = myFont.deriveFont(Font.BOLD,36f);
      exitButton.setFont(myFont);



    }
    catch(Exception error){

    }
    exitButton.addActionListener(new ActionListener(){    
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(1);
      }
    });

    playButton = new JButton("Play");
    playButton.setForeground(Color.GREEN);
    playButton.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 6));
    
    try{
    
      Font myFont = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("src/Belwe.ttf"));
      myFont = myFont.deriveFont(Font.BOLD,36f);
      playButton.setFont(myFont);

      /*AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new FileInputStream("src/Dice_Shake_Multiple_9.wav"));
      Clip clip = AudioSystem.getClip();
      clip.open(audioInputStream);
      clip.start( );*/
    }
    catch(Exception error){

    }

    playButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        gc.takeTurn();
        //ControlPanel("Dice_Shake_Multiple_9.wav");
      }

      private void ControlPanel(String string) {
      }
    });

    playerLabel = new JLabel("", SwingConstants.CENTER);
    playerLabel.setForeground(Color.orange);
    playerLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 6));
    try{
      Font myFont = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("src/Belwe.ttf"));
      myFont = myFont.deriveFont(Font.BOLD, 36f);
      playerLabel.setFont(myFont);
    }
    catch(Exception error){
    }
    playerLabel.setFont(playerLabel.getFont().deriveFont(36.0f));
    updatePlayerLabel();
    setLayout(new GridLayout(0, 1));
    add(exitButton);
    add(playerLabel);
    add(playButton);    
  }

  public void changeGamePlayEnabled(boolean enabled){
    playButton.setEnabled(enabled);
    updatePlayerLabel();
  }

  private void updatePlayerLabel(){
    playerLabel.setText(gc.getCurrentPlayer().toString());
  }
}