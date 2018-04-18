/**
 * This class checks to see if a user is old enough to run for office.
 * @author christopher.eckles
 * 
 */
public class OfficeEligibility {

    public static void main(String[] args) {
        int userAge;  //Initializing userAge variable of type int.
        userAge = 33; //Setting User age to 33

        if(userAge >= 30) { //is the user 30 or older? 
            System.out.println("You can run for the US Senate or US House");
        }//close if
        else if(userAge >= 25) {//is the user 24 or older?
            System.out.println("You can run for the US House of Representatives");
        } //close else if
        else { //the user is under 25
            System.out.println("You are not old enough for US Congress, sorry.");
        } //close else

    }//close main method
}//close OfficeEligibility class
