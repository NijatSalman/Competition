package util;

import java.util.Scanner;

import beans.Competitor;

public class MenuUtil {

	public static int showMenu(){
		System.out.println("Please select menu");
		
		String menuStr="1. add competitiors\n"
					+ "2. start competition\n"
					+ "3. learn your score\n"
					+ "4. increase competitors counts"
					+ "5. show competitors\n"
					+ "6. logout";
		
		System.out.println(menuStr);
		Scanner sc=new Scanner(System.in);
		int selectMenu=sc.nextInt();
		
		if (selectMenu>0 && selectMenu<=6) {
			return selectMenu;
		}else{
			System.out.println("invalid menu selected");
			return -1;
		}
	}
	
	public static int showMenuInfinite(){
		while(true){
			int selectMenu=showMenu();
			if (selectMenu==1) {
				CompetitonUtil.registerCompetitorsAndAlert();
				}else if(selectMenu==2){
					CompetitonUtil.startCompetition();
				}else if(selectMenu==3){
					CompetitonUtil.showPoint();
				}else if(selectMenu==4){
					CompetitonUtil.increaseCompetitors();
				}else if(selectMenu==5){
					CompetitonUtil.printCompetitors();
				}else if(selectMenu==6){
					UserUtil.requiredInputsAndLogin(3, true);
				}
		}
	}
	
}
