/*
	MARK ARTHUR A. CARO III
	ICST214	N1
	03.10.16
	P3-Telephone-Number Word Generator

	Problem:
			Standard telephone keypads contain the digits zero
		through nine. The numbers two through nine each have three letters associated with them
		(Fig. 17.25). Many people find it difficult to memorize phone numbers, so they use the correspon-
		dence between digits and letters to develop seven-letter words that correspond to their phone num-
		bers. For example, a person whose telephone number is 686-2377 might use the correspondence
		indicated in Fig. 17.25 to develop the seven-letter word "NUMBERS." Every seven-letter word cor-
		responds to exactly one seven-digit telephone number. A restaurant wishing to increase its takeout
		business could surely do so with the number 825-3688 (i.e., "TAKEOUT").

			Every seven-letter phone number corresponds to many different seven-letter words, but most
		of these words represent unrecognizable juxtapositions of letters. It’s possible, however, that the
		owner of a barbershop would be pleased to know that the shop’s telephone number, 424-7288, cor-
		responds to "HAIRCUT." A veterinarian with the phone number 738-2273 would be pleased to
		know that the number corresponds to the letters "PETCARE." An automotive dealership would be
		pleased to know that the dealership number, 639-2277, corresponds to "NEWCARS."
		Write a program that, given a seven-digit number, uses a PrintStream object to write to a file
		every possible seven-letter word combination corresponding to that number. There are 2,187 (3 7 )
		such combinations. Avoid phone numbers with the digits 0 and 1.

	Algorithm:
		1. Declare a string 'filename' where the output will be written.
		2. Initialize a character array with each letter corresonding to one number in a telephone number.
		3. The user inputs a seven-digit telephone number then the program converts it into characters.
		4. Using nested for loops, the program will traverse through the phone number and will print the characters each number represents.
		5. If the user input is 1 or 0, the program will give an error message then exit.
		6. Then the character array is printed to the file created.

*/

import java.io.*;
import java.util.*;

public class Caro_P2
{
	final static String filename = "data.txt";
	private static ObjectOutputStream output; 
	
	public static void main(String[] args)
	{
		String phoneNumber;
		char numberLetters[][] = {
			{'0','0','0'},{'1','1','1'},{'A','B','C'},
			{'D','E','F'},{'G','H','I'},{'J','K','L'},
			{'M','N','O'},{'P','R','S'},{'T','U','V'},
			{'W','X','Y'}};
		Scanner in = new Scanner(System.in);
		PrintStream printStream;
		char[] word = new char[7];

		//prompt the user for a telephone number
		System.out.println("Please enter a 7-digit telephone number. Note: please avoid 0s and 1s in the number.");
		phoneNumber = in.next();

		//open the file
		try
		{
			output = new ObjectOutputStream(new FileOutputStream(filename));
		}
		catch(IOException io)
		{
			System.err.println("Error opening output file.");
		}

		//comparing the numbers and writing to the file
		try
		{
			int[] digit = new int[7];
			for (int i = 0; i < 7; i++)
			{
				digit[i] = Integer.parseInt(String.valueOf(phoneNumber.charAt(i)));
			}

			printStream = new PrintStream(output);
			for ( int level0 = 0; level0 < 3; level0 ++ )
	        {
	            word[0] = numberLetters[digit[0]][level0];

	            for ( int level1 = 0; level1 < 3; level1 ++ )
	            {
	                word[1] = numberLetters[digit[1]][level1];

	                for ( int level2 = 0; level2 < 3; level2 ++ )
	                {
	                    word[2] = numberLetters[digit[2]][level2];

	                    for ( int level3 = 0; level3 < 3; level3 ++ )
	                    {
	                        word[3] = numberLetters[digit[3]][level3];

	                        for ( int level4 = 0; level4 < 3; level4 ++ )
	                        {
	                            word[4] = numberLetters[digit[4]][level4];

	                            for ( int level5 = 0; level5 < 3; level5 ++ )
	                            {
	                                word[5] = numberLetters[digit[5]][level5];

	                                for ( int level6 = 0; level6 < 3; level6 ++ )
	                                {
	                                    word[6] = numberLetters[digit[6]][level6];
	                                    printStream.print(Arrays.toString(word) + "\n");
	                                }
	                            }
	                        }
	                    }
	                }
	            }
	        }
	    }
	    catch(Exception e)
	    {
	    	System.err.println("Error Writing to File");
	    }

        System.out.println("Results Successfully Written to the File.");
        try
        {
        	output.close();
        }
        catch(IOException io)
        {
        	System.err.println("Error closing the file.");
        }
	}
}