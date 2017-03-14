import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class GIFTest {
	 public static void main(String[] args) throws MalformedURLException {

	        URL url = new URL("http://25.media.tumblr.com/tumblr_me4oxapEwX1ry10fwo1_250.gif");
	        Icon icon = new ImageIcon(url);
	        JLabel label = new JLabel(icon);

	        JFrame f = new JFrame("Animation");
	        f.getContentPane().add(label);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.pack();
	        f.setLocationRelativeTo(null);
	        f.setVisible(true);
	    }
}
