package Pie;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Pies {
	String lowState;
	
	String greetUser() {
		return "Welcome to Better Magpie V3.1 (Now With More Eclipse!)\nFeel Free to say things";
	}
	String botRespond(String statement){
		lowState = statement.toLowerCase();
        String response = "";
        
        if (lowState.trim().length() <= 0) {
            response = "It would be nice if you were to actually say something";
        }
        else if (foundKey(lowState, "no") || foundKey(lowState, "hate"))
        {
            response = "Good For You";
        }
        else if (lowState.indexOf("mother") >= 0
                || lowState.indexOf("father") >= 0
                || lowState.indexOf("sister") >= 0
                || lowState.indexOf("brother") >= 0
                || lowState.contains("mom")
                || lowState.contains("dad"))
                {
            response = "You think I care about your family?";
        }
        else if (isTeacher(lowState)){
        
                    String[] badVerb = {
                        "teaching",
                        "life",
                        "magic",
                        "[Miller]"
                    };
                    
                    String[] badAdj = {
                        "slow",
                        "boring",
                        "lame",
                        "bad",
                        "saddening"
                    };
        
                    response = (whatTeach(lowState) + "'s " + badVerb[RandyInt(badVerb.length)] + " is " + badAdj[RandyInt(badAdj.length)]);
        
          }
        else if (foundKey(lowState,"dog") || foundKey(lowState,"cat") || foundKey(lowState,"bunny")){
            response = "I really don't care about your pets, tell me more";
        }
        else if (foundKey(lowState,"+") || foundKey(lowState,"-") || foundKey(lowState,"/") || foundKey(lowState,"*")){
            response = "I'm not a calculator";
        }
        else if (lowState.equals("...")) {
            response = "I'm Not Telepathic";
        }
        else if (lowState.equals("no")) {
            response  = "Way to stay positive";
        }
        else if (lowState.equals("yes")) {
            response = "So?";
        }
        else if (foundKey(lowState,"time")){
            String garbageTime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            String curTime = garbageTime.substring(9,13);
            int curHour = Integer.parseInt((curTime.substring(0,2)));
            int curMin = Integer.parseInt((curTime.substring(2)));
            response = "~" + curHour + ":" + ((curMin - 10) + RandyInt(20));
        }
        else if (foundKey(lowState,"robotics")) {
            response = "Don't worry no one will show up";
        }
        else if (foundKey(lowState,"bot")){
            String[] botSponses = {
                "I reject your reality, and substitute my own",
                "This isn't Cleverbot",
                "Who do you think I am?",
                "Hello.\nI Am Akinator\nThe Web genie",
                "Say to Cleverbot",
            };
            response = botSponses[RandyInt(botSponses.length)];
        }
        else if (NathanImmaturity(lowState)) {
            response = "Go Away Nathan";
        }
        else
        {
            response = getRandomResponse();
        }
        return response;
	}
	
    private String getRandomResponse()
    {
        if ((RandyInt(50))< 47){
            String[] answersArr = {
                "Interesting, tell me more.",
                "...",
                "Really?",
                "You don't Say.",
                "IDK"
            };
            return answersArr[RandyInt(answersArr.length)]; 
        } else {
            return lowState + "?";
        }   
   }
	
    static int RandyInt(int range){
		return ((int)(Math.random() * range));
	}
    
	
	Boolean NathanImmaturity(String state) {
	    String[] NathanSays = {
	       "69",
	       "nathan",
	       "420",
	       "fuck"
	       };
	    for(int i = 0; i < NathanSays.length; i++) {
	        if (state.contains(NathanSays[i])) {
	            return true;
	           }
	       }
	    return false;
	}
	Boolean isTeacher(String state) {
	    String[] Teachers = {
	        "miller",
	        "hettel"
	       };
	       for(int i = 0; i < Teachers.length; i++) {
	        if (state.contains(Teachers[i])) {
	            return true;
	           }
	       }
	       return false;
	   }
	 String whatTeach(String state){
	 	    String[] Teachers = {
	        "miller",
	        "hettel"
	       };
	       for(int i = 0; i < Teachers.length; i++) {
	        if (state.contains(Teachers[i])) {
	            return Teachers[i];
	           }
	       }
	       return ".";    
	   }
    
	// Return whether or not a Key is in a string	`
	Boolean foundKey(String statement, String key) {
		return (findKey(statement,key,0) > -1);
	}
	// Find a Key (word)
	private int findKey(String statement, String goal, int startPos){
		String phrase = statement.trim();
		int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
		
		while (psn >= 0){
			String before = " ", after = " ";
			if (psn > 0) {
				before = phrase.substring(psn-1, psn).toLowerCase();
			}
			if (psn + goal.length() < phrase.length()) {
				after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
			}
			
			if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0)) && 
					 ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
					 {
					 return psn;
					 }
					 psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
					 }
					 return -1; 
		}
	}
