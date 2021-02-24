import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;


public class TelaInicial extends JFrame{
	
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JPanel controlPanel;
	
	public TelaInicial() {
		prepararJanela();
	}
	 public static void main(String[] args){
	      TelaInicial j = new TelaInicial();     
	   }
	public void prepararJanela() {
		mainFrame = new JFrame("Varzeapp");
		mainFrame.setSize(400, 300);
		mainFrame.setLayout(new GridLayout(3,1));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		headerLabel = new JLabel("Bem vindo ao Varzeapp", JLabel.CENTER);
		
		JButton login = new JButton("Login");
		JButton signUp = new JButton("Sign-up");
		JButton sair = new JButton("Sair");
		
		login.setActionCommand("Login");
		signUp.setActionCommand("Sign-Up");
		sair.setActionCommand("Sair");
		
		login.addActionListener(new ButtonClickListener());
		
		
		controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(3,1));
		
		controlPanel.add(login);
		controlPanel.add(signUp);
		controlPanel.add(sair);

		
		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		
		mainFrame.setVisible(true);
		
	}
}
