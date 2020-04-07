import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class Panel extends JPanel{
	
	private final int W = 400, H = 560;
	private JTextField field;
	private double v1;
	private int op = 0;
	
	public Panel() {
		setSize(W, H);
		setLayout(null);
		addLabel();
		addTextField();
		addButtons();
	}
	
	public void addLabel() {
		JLabel lbl = new JLabel("Калькулятор");
		lbl.setBounds(0, 0, W, 70);
		Font f = new Font("Arial", 1, 50);
		lbl.setFont(f);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbl);
	}
	
	public void addTextField() {
		field = new JTextField("0");
		field.setBounds(0, 80, W, 70);
		Font f = new Font("Arial", 1, 50);
		field.setFont(f);
		field.setEditable(false);
		add(field);
	}
	
	public void addButtons() {
		int r = W/4, h0 = 160;
		String[] names = {"1", "2", "3", "+",
						  "4", "5", "6", "-",
						  "7", "8", "9", "*",
						  "C", "0", "=", "/"};
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				JButton button = new JButton();
				button.setBounds(j*r, h0 + i*r, r, r);
				Font f = new Font("Arial", 1, 50);
				button.setFont(f);
				button.setText(names[4*i + j]);
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton b = (JButton) e.getSource();
						clickOnButton(b.getText());
					}
				});
				add(button);
			}
		}
	}

	public void clickOnButton(String command){
		System.out.println(command);
		switch (command){
			case "+": setOperation(1); break;
			case "-": setOperation(2); break;
			case "*": setOperation(3); break;
			case "/": setOperation(4); break;
			case "C": clear(); break;
			case "=": answer(); break;
			default: addNumber(command); break;
		}
	}

	public void addNumber(String number){
		field.setText(field.getText() + number);
	}

	public void clear(){
		op = 0;
		v1 = 0;
		field.setText("0");
	}

	public void answer(){
		double v2 = Double.parseDouble(field.getText().trim());
		switch (op){
			case 0: System.out.println("no v1 value"); break;
			case 1: field.setText(""+(v1+v2)); break;
			case 2: field.setText(""+(v1-v2)); break;
			case 3: field.setText(""+(v1*v2)); break;
			case 4:
				if (v2 == 0)
					field.setText("Divizion by Zero");
				else
					field.setText(""+(v1/v2));
				break;
		}
	}

	public void setOperation(int op){
		v1 = Double.parseDouble(field.getText().trim());
		this.op = op;
		field.setText("0");
	}


}
