import java.awt.event.*;
import java.awt.*;
import javax.swing.*;



public class Stopwatch implements ActionListener{
	
	JFrame frame =new JFrame();
	JButton startButton = new JButton("START");
	JButton resetButton = new JButton("RESET");
	JLabel timeLabel = new JLabel();
	int elapsedTime = 0;
	int seconds = 0;
	int minutes = 0;
	int hours = 0;
	boolean started = false;
	
	String seconds_string = String.format("%02d", seconds); // 2 digits
	String minutes_string = String.format("%02d", minutes);
	String hours_string = String.format("%02d", hours);
	
	Stopwatch(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350,210);
		frame.setLayout(null);
		frame.setResizable(false);
		
		timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
		timeLabel.setBounds(85, 15, 150, 90);
		timeLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		
		//startButton.setSize(new Dimension(100,50));
		startButton.setFocusable(false);
		startButton.setFont(new Font("Verdana", Font.PLAIN, 20));
		startButton.setBounds(60, 110, 100, 50);
		startButton.setOpaque(true);
		//startButton.setVerticalAlignment(JTextField.BOTTOM);
		//resetButton.setSize(new Dimension(100,50));
		resetButton.setBounds(160, 110, 100, 50);
		resetButton.setFocusable(false);
		resetButton.setFont(new Font("Verdana", Font.PLAIN, 20));
		resetButton.setOpaque(true);
		
		
		frame.add(timeLabel);
		frame.add(startButton);
		frame.add(resetButton);
		
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	void start() {
		
	}
	
	void stop() {
		
	}
	
	void reset() {
		
	}
}
