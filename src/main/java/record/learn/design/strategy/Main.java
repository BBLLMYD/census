package record.learn.design.strategy;


public class Main {

	public static void main(String[] args) {
		if(args.length!=2){
			System.out.println("Usage: java Main randomseed1 randomseed2");
			System.out.println("EG: java Main 251 12");
			System.exit(0);
		}
		int seed1 = Integer.parseInt(args[0]);
		int seed2 = Integer.parseInt(args[1]);
		Player player1 = new Player("小李", new WinningStrategy(seed1));
		Player player2 = new Player("小王", new ProbStrategy(seed2));
		
		for(int i=0 ; i<10000; i++){
			Hand hand1 = player1.nextHand();
			Hand hand2 = player2.nextHand();
			if(hand1.isStrongThan(hand2)){
				System.out.println("winner: "+player1);
				player1.win();
				player2.lose();
			}else if(hand2.isStrongThan(hand1)){
				System.out.println("winner: "+player2);
				player1.lose();
				player2.win();
			}else{
				System.out.println("even ...");
				player1.even();
				player2.even();
			}
		}
		System.out.println("totle");
		System.out.println(player1.toString());
		System.out.println(player2.toString());
	}
	
}
