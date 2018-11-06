package help;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BDocBase 
{
	public HashMap<String,List>  getTables() {
		return tables;
	}

	public void setTables(HashMap<String,List>  tables) {
		this.tables = tables;
	}

	HashMap<String,List>  tables;
	

}
