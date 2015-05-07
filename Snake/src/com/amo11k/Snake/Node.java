package com.amo11k.Snake;

public class Node {
	private int col;
	private int row;

	public Node(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getNodeRow() {
		return row;
	}

	public int getNodeCol() {
		return col;
	}

	public void setNodeCol(int i) {
		col = i;
	}

	public void setNodeRow(int i) {
		row = i;
	}

	public void moveNodeCol(int i) {
		col = col + i;
	}

	public void moveNodeRow(int i) {
		row = row + i;
	}
}
