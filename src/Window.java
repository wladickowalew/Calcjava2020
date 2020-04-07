import javax.swing.JFrame;

public class Window extends JFrame {
	
	public Window() {
		setResizable(false);
		setTitle("Calc");
		Panel panel = new Panel();
		getContentPane().add(panel);
		setBounds(20, 20, panel.getWidth()+6, panel.getHeight()+29);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
