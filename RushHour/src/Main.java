public class Main {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		 
		
		Board B = new Board();
		if(args[0].equals("print")) {
			if(args.length <= 1) {
		        B.buildBoard("  o aa|  o   |xxo   |ppp  q|     q|     q");
		        B.print();
		    }else {
		    	B.buildBoard(args[1].toString());
		    	B.print();
		    }
		}else if(args[0].equals("done")) {
			if(args.length <= 1) {
		        B.buildBoard("  o aa|  o   |xxo   |ppp  q|     q|     q");
		        B.done(B);
		    }else {
		    	B.buildBoard(args[1].toString());
		    	B.done(B);
		    }
		}else if(args[0].equals("next")) {
			if(args.length <= 1) {
		        B.buildBoard("  o aa|  o   |xxo   |ppp  q|     q|     q");
		        B.next();
		    }else {
		    	B.buildBoard(args[1].toString());
		    	B.next();
		    }
		}
		
		
		// done "  oaa |  o   |  o xx|  pppq|     q|     q"
		/*
		Board B = new Board();
		if(args.length <= 1) {
	        B.buildBoard("  o aa|  o   |xxo   |ppp  q|     q|     q");
	        //B.buildBoard("  ooo |ppp q |xx  qa|rrr qa|b c dd|b c ee");
	    }else {
	    	B.buildBoard(args[1].toString());
	    }
		*/
	}

}
