
package lab_task_2;

import java.util.Scanner;


public class Question7 {
	public static void main(String[] args) {
   	 
    
	Scanner input =new Scanner(System.in);
    
	int a;
	char x;
   a=input.nextInt();
   
   while(a!=0)
   {
 	x=input.next().charAt(0);
	 
	if ((x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z')) {
       	 
        	if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u'
                	|| x == 'A' || x == 'E' || x == 'I' || x == 'O' || x == 'U') {
            	System.out.println(x + " is a Vowel.");
        	} else {
            	System.out.println(x + " is a Consonant.");
        	}
    	} else if (x >= '0' && x <= '9') {
       	 
        	System.out.println(x + " is a Digit.");
    	} else {
      	 
        	System.out.println(x + " is a Special Character.");
    	}
    
	a--;
    	 
	 
	 
 	}
 	 
 	 
   }
   
	}
