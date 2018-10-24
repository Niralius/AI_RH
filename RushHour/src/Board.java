import java.util.LinkedList;
import java.util.List;

public class Board implements Cloneable{
	
	String[][] RHboard = new String[6][6];
	List<String> known = new LinkedList<String>();
	List<Board> possibleMoves = new LinkedList<Board>();
	
	String OG;
	
	
	public void buildBoard(String newBoard) throws CloneNotSupportedException {
		
		OG = newBoard;
		String[] rows = new String[6];
		
		int i = 0;
		for(String retval : newBoard.split("\\|")) {
			rows[i] = retval;
			//System.out.println(rows[i]); //the entire row e.g. [__o_aa]
			i++;
		}
		
		for(int x = 0; x < rows.length; x++) { //6
			String[] a = rows[x].split("");
			for(int y = 0; y < a.length; y++) {	//6
					RHboard[x][y] = a[y];
					//System.out.println("(" + x +", " + y + ") " + RHboard[x][y]); //print letter w/coordinates
			}
		}
		
		/*
		for(String a : rows) {
			for(String b : a.split("")) {
				//System.out.println(b); //prints each letter individually
			}
		}
		*/
		
		//print();
		//next();
		//System.out.println(possibleMoves.size());
		//System.out.println(count("a"));
		//done();
	}
	
	public Board next_in_direction(int i, int j, int di, int dj, String s) throws CloneNotSupportedException {
		//System.out.println("s:" + s + " x:" + di + " y:" + dj);
		Board newBoard = (Board)this.clone();
		move(newBoard, s, di, dj);
		possibleMoves.add(newBoard);
		print();
		return newBoard;
	}
	
	public void next() throws CloneNotSupportedException {
		for(int x = 0; x < 6; x++) {
			for(int y = 0; y < 6; y++) {
				if(!this.RHboard[x][y].equals(" ")) {
					if(!known.contains(RHboard[x][y])) {
						known.add(RHboard[x][y]);
						int v = carLength(RHboard[x][y]);
						if(RHboard[x][y].equals(RHboard[x+1][y])) { //vertical
							if(((x+1) < 6) && ((x+v) < 6) && (RHboard[x+v][y]).equals(" ")) { 	//check if it would stay inside when moving it (+1,0) and going to an empty space
								next_in_direction(x,y,1,0,RHboard[x][y]);
							}else if(((x-1) > 0) && (RHboard[x-1][y]).equals(" ")) { //(-1,0)
								next_in_direction(x,y,-v,0,RHboard[x][y]);		// fix v
							}
						}else if(RHboard[x][y].equals(RHboard[x][y+1])) { //horizontal
							if(((y+1) < 6) && ((y+v) < 6) && (RHboard[x][y+v]).equals(" ")) { 	//(0,+1)
								//System.out.println("+y");
								next_in_direction(x,y,0,v,RHboard[x][y]);
							}else if(((y-1) > 0) && (RHboard[x][y-1]).equals(" ")){ //(0,-1)
								//System.out.println("moving -y");
								next_in_direction(x,y,0,-1,RHboard[x][y]);
							}
						}
					}
				}
			}
		}
	}
	
	public int carLength(String s) { //the length of a car
		int vLength = 0;
		for(int x = 0; x < 6; x++) {
			for(int y = 0; y < 6; y++) {
				if(this.RHboard[x][y].equals(s)) {
					vLength++;
				}
			}
		}
		return vLength;
	}
	
	public void move(Board b,String a,int di,int dj) {
		int skipped = 0;										 //how many times it moves
		int v = carLength(a);
		for(int x = 0; x < 6; x++) {
			for(int y = 0; y < 6; y++) {
				if(b.RHboard[x][y].equals(a)) {
					if(x+di < 6 && y+dj < 6 && b.RHboard[x+di][y+dj].equals(" ")) { //look at this
						//System.out.println("x:" + x + " dx:" + di + " y:" + y + " dy:" + dj);
						b.RHboard[x+di][y+dj] = a;
						b.RHboard[x][y] = " ";
					}else if(x+di < 6 && y+dj < 6 && b.RHboard[x+di][y+dj].equals(a)) {
						skipped++;
					}
				}
			}
		}
	}
	
	
	public void print() {
		System.out.print(" ------");
		for(int x = 0; x < 6; x++) {
			System.out.println("");
			System.out.print("|");
			for(int y = 0; y < 6; y++) {
				System.out.print(RHboard[x][y]);
				//System.out.println("(" + x +", " + y + ") " +RHboard[x][y]);
			}
			if(x != 2) {
				System.out.print("|");
			}
		}
		System.out.println("");
		System.out.println(" ------");
	}
	
	public void done(Board b) {
		//System.out.println(RHboard[2][5].toString());
		if(b.RHboard[2][5].equals("x")) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
	}
	
	
}
