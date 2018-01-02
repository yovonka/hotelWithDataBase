package first.database;

import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import javax.swing.*;

public class GUI implements ActionListener {
	
	JFrame window = new JFrame("RoomSearchTool");
	JButton clikSearch = new JButton("Search");
	JPanel panel = new JPanel();
	JComboBox<Integer> sizeBox, prizeBox;
	JTextArea resultField = new JTextArea(7,5);
	
	Integer[] sizeList = {1, 2, 3, 4, 5, 6};
	Integer[] prizeList = { 20, 30, 50, 100, 150, 200};
	
	
	void set() {
		
		sizeBox = new JComboBox<Integer>(sizeList);
		prizeBox = new JComboBox<Integer>(prizeList);
		
		resultField.setText("List of rooms that meet the requirements:");
		
		window.getContentPane().add(BorderLayout.NORTH,panel);
		window.getContentPane().add(BorderLayout.SOUTH,clikSearch);

		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		panel.add( new JLabel("Room for how many people: "));
		panel.add(sizeBox);
		panel.add( new JLabel("Maksimum prize for nigth [$] : "));
		panel.add(prizeBox);
		
		clikSearch.addActionListener(this);
		
		resultField.setLineWrap(false);
		resultField.setEditable(false);
		JScrollPane scrol = new JScrollPane(resultField);
		scrol.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrol.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrol);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(250, 250);
		window.setLocationRelativeTo(null); // at center
		window.setResizable(false);
		window.setVisible(true); 
	
	}
	
	public void actionPerformed(ActionEvent zdarzenie) {
		
		int prize =  (Integer) prizeBox.getSelectedItem();
		int size =  (Integer) sizeBox.getSelectedItem();
		
		SearchingTool tool = new SearchingTool();
		String myQuery = tool.createQuery(size, prize);
		LinkedList<Room> list = tool.executeSQLSelect(myQuery);
	
		for(Room element: list) {
			resultField.append("\n ~ room nr: "+element.id+" -- prize "+element.prize);
		}

	}

	
	
}
