import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Map;

import javax.swing.JFrame;


public class MovingObjectsGameLauncher {

	public static void main(String[] args) {
		JFrame gameFrame = new JFrame();
		Map<String,String> environMap= System.getenv();
		System.out.println(environMap.keySet());
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		MovingObjectsPanel mop = new MovingObjectsPanel(d);
		gameFrame.setTitle("Centipede");
		gameFrame.add(mop);
		gameFrame.setVisible(true);
		gameFrame.setDefaultCloseOperation(gameFrame.EXIT_ON_CLOSE);
		gameFrame.setContentPane(mop);
		mop.setBackground(new Color(255, 255, 255));
		gameFrame.pack();
		
	}

}
