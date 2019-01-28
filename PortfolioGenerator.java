import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class PortfolioGenerator{



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String name = "";
        name = gatherStringInput(sc,"Please enter your name");
        int spaces= name.length();
        String email = "";
        email = gatherStringInput(sc,"email: ");
        String personalBackground = "";
        personalBackground = gatherStringInput(sc,"Personal background");

        ArrayList<String> programmingLang = PortfolioGenerator.gatherMultipleStringInput(sc, "please enter your programming language, enter done when finished ");
        ArrayList<String> achievements = PortfolioGenerator.gatherMultipleStringInput(sc, "please enter your achievements, enter done when finished ");

       String info= formatUserInfo( name, email, personalBackground, programmingLang,achievements) ;


       PortfolioGenerator.fileWriter(info);


    }

    public static String gatherStringInput(Scanner sc, String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }


    public static ArrayList<String> gatherMultipleStringInput(Scanner sc, String prompt) {
        ArrayList<String> programmingLanguage = new ArrayList<String>();
        boolean done = false;
        while (!done){
            System.out.println(prompt);
            String temp = "";
            temp = sc.nextLine();
            if(temp != null && temp.equalsIgnoreCase("done")){
                done = true;
            } else if (temp != null && !temp.equalsIgnoreCase("")) {
                programmingLanguage.add(temp);
            }
        }



        for(int i=0; i< programmingLanguage.size(); i++){
            System.out.println(i+1 + ". "+programmingLanguage.get(i));
        }
        return programmingLanguage;

    }

    public static String formatUserInfo(String name, String email, String personalBio, ArrayList<String> pmgList,ArrayList<String> achieve){
        StringBuffer sb = new StringBuffer();

        sb.append("*****************************************************\n");
        sb.append("\t\t\t\t\t"+name+"\n");
        sb.append("*****************************************************\nemail:");
        sb.append(email+"\n\n");
        sb.append("**Personal Background**\n\n");
        sb.append("\t"+personalBio+"\n");
        sb.append("**Programming Languages**\n");
        sb.append("<><><><><><><><><><><><><><><><>\n");
        for(int i=0; i< pmgList.size(); i++){
            sb.append(i+1 + ". "+pmgList.get(i)+"\n");
        }
        sb.append("<><><><><><><><><><><><><><><><>\n");
        sb.append("**Achievements**\n");
        sb.append("<><><><><><><><><><><><><><><><>\n");
        for(int i=0; i< achieve.size(); i++){
            sb.append(i+1 + ". "+achieve.get(i)+"\n");
        }
        sb.append("<><><><><><><><><><><><><><><><>\n");

        return sb.toString();
    }
    public static void fileWriter(String info)
    {
        String fileName = "AboutMe";
        try{
            PrintWriter file = new PrintWriter(fileName);
            /*file.println("*********************************************");
            file.println("\t\t\t\t\t"+name);
            file.println("*********************************************");
            file.println("email: "+email+"\n\n\n");
            file.println("**Personal Background**\n");
            file.println("\t"+personalBackground);
            file.println("**Programming Languages**");
            file.println("<><><><><><><><><><><><><><><><>");
            file.println(programmingLang);
            file.println("<><><><><><><><><><><><><><><><>");
            file.println(achievements);
            file.println("<><><><><><><><><><><><><><><><>");*/
            file.println(info);




            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
    }



}
