
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

   
public class TableInfo {
	 
	JPanel tableInfoPanel = new JPanel ();
		       
	public JPanel construntTableInfo (String[] columnNames,Object[][] tableData) {
		  
		
		 
		JTable myTableInfo = new JTable(tableData,columnNames); 
		JScrollPane tableScrollPane = new JScrollPane(myTableInfo ) ;
		this.tableInfoPanel.add(tableScrollPane);
		return tableInfoPanel ;
	   
	} 

}
