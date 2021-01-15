package util;

import java.util.Random;
import java.util.Scanner;

import beans.Competitor;
import beans.User;
import config.Config;
import config.Initialization;

public class CompetitonUtil {

	
	private static Scanner sc;

	public static Competitor[] registerCompetitors(){
		System.out.println("How many competitor will be participated");
		sc = new Scanner(System.in);
		int competitorCounts=sc.nextInt();
		
		Competitor[] competitors=new Competitor[competitorCounts];
		for (int i = 0; i < competitorCounts; i++) {
			Competitor competitor= registerCompetitor();
			competitors[i]=competitor;
		}
		Initialization.config.setCompetitor(competitors);
		System.out.println("All competitors successfully registered!");
		return competitors;
	}
	
	public static Competitor[] registerCompetitorsAndAlert(){
		Competitor[] competitor=registerCompetitors();
		printCompetitors(Initialization.config.getCompetitor());
		return competitor;
	}
	
	public static Competitor registerCompetitor(){
		sc=new Scanner(System.in);
		System.out.println("Competitor name");
		String name=sc.nextLine();
		
		System.out.println("Competitor surname");
		String surname=sc.nextLine();
		
		System.out.println("Competitor age");
		int age=sc.nextInt();
		
		Competitor competitor =new Competitor(name, surname, age);
		return competitor;
		
	}
	
	public static void increaseCompetitors(){
		
		Competitor[] competitorOld=Initialization.config.getCompetitor();
		System.out.println("How many competitors would you like to add?");
		sc=new Scanner(System.in);
		int increasedCount=sc.nextInt();
		
		Competitor[] competitorNew=new Competitor[competitorOld.length+increasedCount];//1+2
	    for (int i = 0; i < competitorOld.length; i++) {
	    	competitorNew[i]=competitorOld[i];	
		}
		for (int i = competitorOld.length; i < competitorNew.length; i++) {
			competitorNew[i]=registerCompetitor();
		}
		
		Initialization.config.setCompetitor(competitorNew);
	}
	
	public static void printCompetitors(Competitor[] competitors){
		if (competitors==null || competitors.length==0) {
			return;
		}
		for (int i = 0; i < competitors.length; i++) {
			Competitor competitor=competitors[i];
			System.out.println(competitor);
		}
	}
	
	public static void printCompetitors(){
		printCompetitors(Initialization.config.getCompetitor());
	}
	
	
	public static boolean startCompetition(){
		int index=chooseWinner(Initialization.config.getCompetitor().length);
		System.out.println("Please Guess winner!");
		sc=new Scanner(System.in);
		int guessedWinner=sc.nextInt();
		if (guessedWinner==index) {
			increasePoint();
			System.out.println("You won! Your point increase to"+Initialization.config.getUser().getUserPoint());
			return true;
		}else{
			System.out.println("you failed!");
			return false;
		}
	}
	
	
	public static void increasePoint(){
		User user=Initialization.config.getUser();
		user.setUserPoint(user.getUserPoint()+10);
		Initialization.refreshConfig();
	}
	
	public static void showPoint(){	
		System.out.println("Your point"+Initialization.config.getUser().getUserPoint());
	}
	
	
	public static int chooseWinner(int number){
		Random random=new Random();
		int selectedNumber=random.nextInt(number);
		int res=((selectedNumber-1)+1)+1;
		return res;
	}
	
	
}
