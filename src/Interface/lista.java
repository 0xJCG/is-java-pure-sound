package Interface;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class lista extends JPanel implements Observer {

	/**
	 * Create the panel.
	 */
	public lista() {
		
		JLabel lblNombre = new JLabel("New label");
		add(lblNombre);

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
