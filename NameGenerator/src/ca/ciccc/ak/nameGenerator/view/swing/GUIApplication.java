package ca.ciccc.ak.nameGenerator.view.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;

import ca.ciccc.ak.nameGenerator.interfaces.View;

public class GUIApplication implements View{

	private JFrame frmNameGenerator;

	/**
	 * Create the application.
	 */
	public GUIApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNameGenerator = new JFrame();
		frmNameGenerator.setTitle("Name Generator");
		frmNameGenerator.setBounds(100, 100, 450, 300);
		frmNameGenerator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIApplication window = new GUIApplication();
					window.frmNameGenerator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	@Override
	public void setTaskProgress(long progress) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStatusText(String statusText) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addOutput(String text) {
		// TODO Auto-generated method stub
		
	}

}
