package pdf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author vera
 *
 * 21.11.2010 20:31:02
 */
public class AttachLogoUI implements ActionListener
{
	private JButton chooseFileButton;
	private JButton addLogoButton;
	private JLabel choosenFileLabel;
	private JLabel resultLabel;
	private JFileChooser fileChooser;
	private JPanel panel;

	public void create()
	{
		JFrame frame = new JFrame("LogoMaker");
		frame.setSize(300, 150);
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		frame.add(panel);

		chooseFileButton = new JButton("Choose PDF");
		chooseFileButton.addActionListener(this);
		choosenFileLabel = new JLabel("-");
		addLogoButton = new JButton("Add Logo");
		addLogoButton.addActionListener(this);
		resultLabel = new JLabel();

		fileChooser = new JFileChooser();

		panel.add(chooseFileButton);
		panel.add(choosenFileLabel);
		panel.add(addLogoButton);
		panel.add(resultLabel);
		frame.show();
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == addLogoButton)
		{
			String sourcePath = choosenFileLabel.getText();
			
			String desktopPath = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "newsletter.pdf";
			AttachLogo attachLogo = new AttachLogo(sourcePath, desktopPath, "/henneberger-partner.jpg");
			try
			{
				attachLogo.start();
				resultLabel.setText("Fertig");
			}
			catch (Exception e1)
			{
				e1.printStackTrace();
				resultLabel.setText("Fehler: "+e1.getMessage());
			}
		}
		else if (e.getSource() == chooseFileButton)
		{
			int returnValue = fileChooser.showDialog(panel, "OK");

			if(returnValue == JFileChooser.APPROVE_OPTION)
			{
				File file = fileChooser.getSelectedFile();
				choosenFileLabel.setText(file.getAbsolutePath());
			}
		}
	}
}
