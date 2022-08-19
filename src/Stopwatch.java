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
	
	Timer timer = new Timer(1000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			elapsedTime += 1000;
			hours = (elapsedTime/3600000);
			minutes = (elapsedTime/60000) % 60;
			seconds = (elapsedTime/1000) % 60;
			
			seconds_string = String.format("%02d", seconds);
			minutes_string = String.format("%02d", minutes);
			hours_string = String.format("%02d", hours);
			
			timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
		}
		
	}); //(how frequently, action listener)
	
	Stopwatch(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350,210);
		frame.setLayout(null);
		frame.setResizable(false);
		
		timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
		timeLabel.setBounds(85, 15, 150, 90);
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setFont(new Font("Verdana", Font.PLAIN, 30));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		
		//startButton.setSize(new Dimension(100,50));
		startButton.setFocusable(false);
		startButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
		startButton.setBounds(60, 110, 100, 50);
		startButton.setOpaque(true);
		startButton.setVerticalAlignment(JTextField.CENTER);
		startButton.addActionListener(this);
		
		resetButton.setBounds(160, 110, 100, 50);
		resetButton.setFocusable(false);
		resetButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
		resetButton.setOpaque(true);
		resetButton.addActionListener(this);
		
		frame.add(timeLabel);
		frame.add(startButton);
		frame.add(resetButton);
		
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == startButton) {
			if(started==false) {
				started = true;
				startButton.setText("STOP");
				start();
			}
			else {
				started = false;
				startButton.setText("START");
				stop();
			}
			
		}
		if(e.getSource() == resetButton) {
			started = false;
			startButton.setText("START");
			reset();
			}
	}
	
	void start() {
		timer.start();
	}
	
	void stop() {
		timer.stop();
	}
	
	void reset() {
		timer.stop();
		elapsedTime = 0;
		seconds = 0;
		minutes = 0;
		hours = 0;
		seconds_string = String.format("%02d", seconds);
		minutes_string = String.format("%02d", minutes);
		hours_string = String.format("%02d", hours);
		timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
	}
}
