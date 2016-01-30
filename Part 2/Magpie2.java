import java.util.Calendar;
import java.text.SimpleDateFormat;
/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2
{
    String lowState;
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Welcome to the Passive Aggressive Bot. \nHow about No.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        lowState = statement.toLowerCase();
        String response = "";
        if (lowState.length() <= 0) {
            response = "It would be nice if you were to actually say something";
        }
        else if (lowState.contains("no") || lowState.contains("hate"))
        {
            response = "Good For You";
        }
        else if (lowState.indexOf("mother") >= 0
                || statement.indexOf("father") >= 0
                || statement.indexOf("sister") >= 0
                || statement.indexOf("brother") >= 0
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
        else if (lowState.contains("dog") || lowState.contains("cat") || lowState.contains("bunny")){
            response = "I really don't care about your pets, tell me more";
        }
        else if (lowState.contains("+") || lowState.contains("-") || lowState.contains("/") || lowState.contains("*")){
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
        else if (lowState.contains("time")){
            String garbageTime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            String curTime = garbageTime.substring(9,13);
            int curHour = Integer.parseInt((curTime.substring(0,2)));
            int curMin = Integer.parseInt((curTime.substring(2)));
            response = "~" + curHour + ":" + ((curMin - 10) + RandyInt(20));
        }
        else if (lowState.contains("robotics")) {
            response = "Don't worry no one will show up";
        }
        else if (lowState.contains("bot")){
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

    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
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
}
