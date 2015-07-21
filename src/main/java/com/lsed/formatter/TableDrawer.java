package com.lsed.formatter;

import java.io.StringWriter;
import java.util.List;

public class TableDrawer
{
	private StringWriter tableOutput;
	
	public TableDrawer()
	{
		clearOutput();
	}
	
	public String getOutput()
	{
		return tableOutput.toString();
	}
	
	public void clearOutput()
	{
		this.tableOutput = new StringWriter();
	}
	
	public void drawTable(int rows, int columns, List<String> values, String style)
	{
		clearOutput();
		startTable(style);
		writeTableContents(rows, columns, values);
		endTable();
	}
	
	private void startTable(String style)
	{
		String styleText = "";
		if (style != null)
			styleText = " style=\"" + style.toString() + "\"";
		tableOutput.write("<table");
		tableOutput.write(styleText);
		tableOutput.write(">\n");
	}
	
	private void writeTableContents(int rows, int columns, List<String> values)
	{
		int size = values.size();
		for (int rr = 0; rr < rows; rr++) {
			tableOutput.write("\t<tr>\n");
			for (int cc = 0; cc < columns; cc++) {
				if ((rr*columns + cc) < size) {
					String value = values.get(rr*columns + cc);
					tableOutput.write("\t\t<td><h5>");
					tableOutput.write(value);
					tableOutput.write("</h5></td>\n");
				} else {
					tableOutput.write("\t\t<td><h5>null</h5></td>\n");
				}
			}
			tableOutput.write("\t</tr>\n");
		}
	}
	
	private void endTable() {
		tableOutput.write("</table>");
	}
}
