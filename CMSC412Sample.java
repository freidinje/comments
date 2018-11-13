import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;

public class CMSC412Sample{

	public static void main(String[] args){

		/*create hashmaps to store the comments, make 1 for each video
		 *the key is the word, number of occurrences is the value
		 *also make 1 hashmap to store all words from every video to use for comparisons when calculating cosine similarity and euclidean distance
		 *below are examples of how to do this
		*/
		HashMap<String, Integer> educational = new HashMap<String, Integer>();
		HashMap<String, Integer> culinary = new HashMap<String, Integer>();

		//HashMap to store occurence of all words from all videos
		HashMap<String, Integer> wordCount = new HashMap<String, Integer>();

		//this hashmap will be used later on to sort the hashmaps in descending order, with the highest word count being first
		//just make it for now, no need to do anything to it
		Map<String, Integer> sorted;


		//next step is to create the files so we can read in comments through scanner
		File educationalFile = new File("Education.txt");
		File culinaryFile = new File("Food.txt");


		//these are variables to help read in files from scanner

		//record stores each comments read in by the scanner
		String record;
		//string array to store each individual word in comments
		//we will split record by whitespace into this word array to store each word
		String[] words;
		//count used to count number of occurence of words
		//make sure it is Integer object and not int primitive or else code further below won't run
		Integer count;

		//next is reading in the files

		try{

			//creating scanner object
			Scanner scanEdu = new Scanner(educationalFile);

			//looping through text files to read in comments
			while(scanEdu.hasNextLine()){

				//reading in line
				record = scanEdu.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashmaps
				for(int i = 0; i < words.length; i++){
					//adding words into educational hashmap

					//checking number of occurence of words
					count = educational.get(words[i]);

					//if word doesn't exist, add into hashmap and increment count
					if(count == null){
						educational.put(words[i], 1);
					}
					//if it already exists, increment
					else{
						educational.put(words[i], count+1);
					}
					//adding words into wordCount hashmap
					count = wordCount.get(words[i]);
					//if word doesn't exist, add into hashmap and increment count
					if(count == null){
						wordCount.put(words[i], 1);
					}
					//if it already exists, increment
					else{
						wordCount.put(words[i], count+1);
					}
				}

			}


		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//to read in next file you can just copy previous code but replace file and hashmap with new file and hashmap
		try{

			//creating scanner object
			Scanner scanCul = new Scanner(culinaryFile);

			//looping through text files to read in comments
			while(scanCul.hasNextLine()){

				//reading in line
				record = scanCul.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashmaps
				for(int i = 0; i < words.length; i++){
					//adding words into educational hashmap

					//checking number of occurence of words
					count = culinary.get(words[i]);

					//if word doesn't exist, add into hashmap and increment count
					if(count == null){
						culinary.put(words[i], 1);
					}
					//if it already exists, increment
					else{
						culinary.put(words[i], count+1);
					}
					//adding words into wordCount hashmap
					count = wordCount.get(words[i]);
					//if word doesn't exist, add into hashmap and increment count
					if(count == null){
						wordCount.put(words[i], 1);
					}
					//if it already exists, increment
					else{
						wordCount.put(words[i], count+1);
					}
				}

			}


		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}


		//this next part is to sort the hashmaps in descending order
		//just copy this and replace educational with each hashmap you want to sort
		//also this doesn't sort the original hashmap, it just makes a sorted copy so make sure to print out hashmap before sorting the next one or else its not in order
		sorted = educational.entrySet()
							.stream()
							.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
							.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

		//next is to print the hashmaps to text files
		//you can just copy paste this and replace the hashmaps with the one you want to print out

		String educationalOutput = "educational_values.txt";
		BufferedWriter buffWrit = null;
		FileWriter fileWrit = null;

		try{

			//creates writer to write data to file
			fileWrit = new FileWriter(educationalOutput);
			buffWrit = new BufferedWriter(fileWrit);
			String lineOutput = "";

			for(String word : sorted.keySet()){
				lineOutput = word + ": " + educational.get(word);
				buffWrit.write(lineOutput);
				buffWrit.newLine();
			}

		}
		catch (IOException e){
			e.printStackTrace();
		}

		//close filewriter and bufferedwriter
		finally{
			try{
				if(buffWrit != null){
					buffWrit.close();
				}
				if(fileWrit != null){
					fileWrit.close();
				}
			}
			catch (IOException ex){
				ex.printStackTrace();
			}
		}

		//example of calculating cosine simlarity
		//printing out cosine similarity of educational vs culinary videos
		System.out.println("cosineSimilarity(educational, culinary) = " + cosineSimilarity(wordCount, educational, culinary));

	}



	//these are the methods for calculating cosine similarity and euclidean distance, it just returns the result so you can just system.out.println it
	//or print to text file
	//

	//method for calculating the cosine similarity of two hashtables
	public static double cosineSimilarity(HashMap wordCount, HashMap map1, HashMap map2){

		//stores number of occurrence of word from table 1
		Integer occ1 = 0;
		//stores number of occurrence of word from table 2
		Integer occ2 = 0;
		//value to store output
		double output = 0.0;
		//value storing value of top part of fraction
		double top = 0.0;
		//value storing value of bottom part of fraction
		double bot = 0.0;
		//stores sum of occurrences for table 1
		double sum1 = 0.0;
		//stores sum of occurrences for table 2
		double sum2 = 0.0;

		//looping through each word to calculate cosine similarity
		for (Object key : wordCount.keySet()) {

			//storing number of occurrence of current word in map1
			occ1 = (Integer)(map1.get(key));

			//storing number of occurrence of current word in map2
			occ2 = (Integer)(map2.get(key));

			//if word never occurs in map1 than make its value 0
			if(occ1 == null){
				occ1 = 0;
			}

			//if word never occurs in map2 than make its value 0
			if(occ2 == null){
				occ2 = 0;
			}

			//calculating cosine similarity

			//calculating sum of top half of fraction for cosine similarity
			top += (double)(occ1 * occ2);
			//summing up the squares of all occurrences of words in map1
			sum1 += (double)(occ1 * occ1);
			//summing up the squares of all occurrences of words in map2
			sum2 += (double)(occ2 * occ2); 

		}

		//final calculations for cosine similarity
		bot = Math.sqrt(sum1 * sum2);
		output = top / bot;

		//returns the cosine similarity between hashtable1 and hashtable2
		return output;

	}


	//method for calculating the euclidean distance of two HashMap
	public static double euclideanDistance(HashMap wordCount, HashMap map1, HashMap map2){

		//stores number of occurrence of word from map1
		Integer occ1 = 0;
		//stores number of occurrence of word from map2
		Integer occ2 = 0;
		//value to store output
		double output = 0.0;

		//looping through each word to calculate euclidean distance
		for(Object key : wordCount.keySet()){
			//Storing number of occurrence of current word in map1
			occ1 = (Integer)(map1.get(key));

			//Storing number of occurrence of current word in map2
			occ2 = (Integer)(map2.get(key));

			//if word never occurs in map1 than make its value 0
			if(occ1 == null){
				occ1 = 0;
			}

			//if word never occurs in map2 than make its value 0
			if(occ2 == null){
				occ2 = 0;
			}

			//calculating euclidean distance

			//adding up squared of the difference of word count of table 1 and table 2
			output += Math.pow((occ1 - occ2), 2);

		}

		//take square root for final euclidean distance
		output = Math.sqrt(output);

		return output;

	}



}