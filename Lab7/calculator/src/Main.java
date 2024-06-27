//==============================================================================
//Calculator.java (S. Some)
//This program is largely based on  AwtCalc.java
//Author:  Ernest Criss Jr.
//==============================================================================
import javax.swing.*;
import javax.swing.JFrame;

public class Main {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
       public void run() {
          createAndShowGUI();
       }
    });
 }
 private static void createAndShowGUI() {
  JFrame frame =
  new CalCFrame("Calculator");
  frame.setSize(360,200);
  frame.setVisible(true);
 }
}