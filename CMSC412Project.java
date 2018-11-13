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

public class CMSC412Project{

	public static void main(String[] args){

		//HashMap used to count number of times each word occurs in each category and subcategories
		//uses word as key and number of occurrence of word as the value
		HashMap<String, Integer> educational = new HashMap<String, Integer>();
		HashMap<String, Integer> culinary = new HashMap<String, Integer>();
		HashMap<String, Integer> sports = new HashMap<String, Integer>();
		HashMap<String, Integer> technology = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGames = new HashMap<String, Integer>();

		//HashMap for sports sub-categories
		HashMap<String, Integer> sportsBaseball = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBasketball = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsFootball = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsHockey = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsSoccer = new HashMap<String, Integer>();

		//HashMap to store occurence of all words from all videos
		HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
		//Hashmap used to store sorted values used for printing values in descending order
		Map<String, Integer> sorted;

		//storing name of texts files for categories
		String education = "Education.txt";
		String culi = "Food.txt";
		String sport = "Sports.txt";
		String tech = "Technology.txt";
		String games = "Video_Games.txt";

		//storing name of texts files for sports sub-categories
		String baseball = "Sports-Baseball.txt";
		String basketball = "Sports-Basketball.txt";
		String football = "Sports-Football.txt";
		String hockey = "Sports-Hockey.txt";
		String soccer = "Sports-soccer.txt";

		//creating the files
		File gameFile = new File(games);
		File culinaryFile = new File(culi);
		File sportsFile = new File(sport);
		File techFile = new File(tech);
		File educationalFile = new File(education);

		//creating files for sports sub-categories
		File baseballFile = new File(baseball);
		File basketballFile = new File(basketball);
		File footballFile = new File(football);
		File hockeyFile = new File(hockey);
		File soccerFile = new File(soccer);

		//record stores comments read in by the scanner
		String record;
		//string array to store each individual word in comments
		String[] words;
		//count used to count number of occurence of words
		Integer count;

		//reading in category files

		//reading in educational file
		try{

			//creating scanner object
			Scanner scanEdu = new Scanner(educationalFile);

			//looping through text files to read in comments
			while(scanEdu.hasNextLine()){

				//reading in line
				record = scanEdu.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//adding words into educational hashtable

					//checking number of occurence of words
					count = educational.get(words[i]);

					//if word doesn't exist, add into hashtable and increment count
					if(count == null){
						educational.put(words[i], 1);
					}
					//if it already exists, increment
					else{
						educational.put(words[i], count+1);
					}
					//adding words into wordCount hashtable
					count = wordCount.get(words[i]);
					//if word doesn't exist, add into hashtable and increment count
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

		//reading in culinary file
		try{

			//creating scanner object
			Scanner scanCul = new Scanner(culinaryFile);

			//looping through text file to read in comments
			while(scanCul.hasNextLine()){

				//reading in line
				record = scanCul.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into correct hashtable
				for(int i = 0; i < words.length; i++){
					//adding words to culinary hashtable
					count = culinary.get(words[i]);

					//if word doesnt exist, add to hashtable and make count = 1
					if(count == null){
						culinary.put(words[i], 1);
					}
					//if word exists then just increment
					else{
						culinary.put(words[i], count+1);
					}
					//adding words into wordCount hashtable
					count = wordCount.get(words[i]);
					//if word doesn't exist, add to hashtable and make count = 1
					if(count == null){
						wordCount.put(words[i], 1);
					}
					//if word exists then just increment
					else{
						wordCount.put(words[i], count+1);
					}
				}

			}
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in sports file
		try{

			//creating scanner object
			Scanner scanSport = new Scanner(sportsFile);

			//looping through text file to read in comments
			while(scanSport.hasNextLine()){

				//reading in each comment
				record = scanSport.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through words to store into hashtables
				for(int i = 0; i < words.length; i++){
					//adding words to sports hashtable
					count = sports.get(words[i]);

					//if word doesn't exist, then add word to table and make count = 1
					if(count == null){
						sports.put(words[i], 1);
					}
					//if word exists, then increment number of occurrence of word
					else{
						sports.put(words[i], count+1);
					}
					//adding words into wordCount hashtable
					count = wordCount.get(words[i]);
					//if word doesn't exists then add into hashtable and make occurrence = 1
					if(count == null){
						wordCount.put(words[i], 1);
					}
					//if word exists, then increment occurrence
					else{
						wordCount.put(words[i], count+1);
					}
				}
			}
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in technology file
		try{

			//creating scanner object
			Scanner scanTech = new Scanner(techFile);

			//looping through text file to store comments
			while(scanTech.hasNextLine()){

				//reading in each line
				record = scanTech.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word to store into hashtables
				for(int i = 0; i < words.length; i++){
					//adding words to technology hash table
					count = technology.get(words[i]);
					//if word doesn't exists then add into hashtable and make occurrence = 1
					if(count == null){
						technology.put(words[i], 1);
					}
					//if word does exists, then increment occurence
					else{
						technology.put(words[i], count+1);
					}
					//adding words into wordCount hashtable
					count = wordCount.get(words[i]);
					//if word doesn't exists then add into hashtable and make occurrence = 1
					if(count == null){
						wordCount.put(words[i], 1);
					}
					//if word does exists, then increment occurrence
					else{
						wordCount.put(words[i], count+1);
					}
				}
			}
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in game file
		try{

			//creating scanner object
			Scanner scanVid = new Scanner(gameFile);

			//looping through text file to get comments
			while(scanVid.hasNextLine()){

				//reading in comments
				record = scanVid.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through words to store into hashtables
				for(int i = 0; i < words.length; i++){
					//adding words to video game hash table
					count = videoGames.get(words[i]);
					//if word doesn't exist in hashtable, then add to hashtable and make its occurrence = 1
					if(count == null){
						videoGames.put(words[i], 1);
					}
					//if word exists, then increment occurrence
					else{
						videoGames.put(words[i], count+1);
					}
					//adding words into wordCount hashtable
					count = wordCount.get(words[i]);
					//if word doens't exist in hashtable, then add to hashtable and make its occurrence = 1
					if(count == null){
						wordCount.put(words[i], 1);
					}
					//if word exists, then increment occurrence
					else{
						wordCount.put(words[i], count+1);
					}
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}


		//reading in files for sub-categories for sports

		//reading in sports-baseball file
		try{

			//creating scanner object
			Scanner scanVid = new Scanner(baseballFile);

			//looping through text file to get comments
			while(scanVid.hasNextLine()){

				//reading in comments
				record = scanVid.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through words to store into hashtables
				for(int i = 0; i < words.length; i++){
					//adding words to video game hash table
					count = sportsBaseball.get(words[i]);
					//if word doesn't exist in hashtable, then add to hashtable and make its occurrence = 1
					if(count == null){
						sportsBaseball.put(words[i], 1);
					}
					//if word exists, then increment occurrence
					else{
						sportsBaseball.put(words[i], count+1);
					}
					//adding words into wordCount hashtable
					count = wordCount.get(words[i]);
					//if word doens't exist in hashtable, then add to hashtable and make its occurrence = 1
					if(count == null){
						wordCount.put(words[i], 1);
					}
					//if word exists, then increment occurrence
					else{
						wordCount.put(words[i], count+1);
					}
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in sports-basketball file
		try{

			//creating scanner object
			Scanner scanVid = new Scanner(basketballFile);

			//looping through text file to get comments
			while(scanVid.hasNextLine()){

				//reading in comments
				record = scanVid.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through words to store into hashtables
				for(int i = 0; i < words.length; i++){
					//adding words to video game hash table
					count = sportsBasketball.get(words[i]);
					//if word doesn't exist in hashtable, then add to hashtable and make its occurrence = 1
					if(count == null){
						sportsBasketball.put(words[i], 1);
					}
					//if word exists, then increment occurrence
					else{
						sportsBasketball.put(words[i], count+1);
					}
					//adding words into wordCount hashtable
					count = wordCount.get(words[i]);
					//if word doens't exist in hashtable, then add to hashtable and make its occurrence = 1
					if(count == null){
						wordCount.put(words[i], 1);
					}
					//if word exists, then increment occurrence
					else{
						wordCount.put(words[i], count+1);
					}
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in sports-Football file
		try{

			//creating scanner object
			Scanner scanVid = new Scanner(footballFile);

			//looping through text file to get comments
			while(scanVid.hasNextLine()){

				//reading in comments
				record = scanVid.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through words to store into hashtables
				for(int i = 0; i < words.length; i++){
					//adding words to video game hash table
					count = sportsFootball.get(words[i]);
					//if word doesn't exist in hashtable, then add to hashtable and make its occurrence = 1
					if(count == null){
						sportsFootball.put(words[i], 1);
					}
					//if word exists, then increment occurrence
					else{
						sportsFootball.put(words[i], count+1);
					}
					//adding words into wordCount hashtable
					count = wordCount.get(words[i]);
					//if word doens't exist in hashtable, then add to hashtable and make its occurrence = 1
					if(count == null){
						wordCount.put(words[i], 1);
					}
					//if word exists, then increment occurrence
					else{
						wordCount.put(words[i], count+1);
					}
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in sports-hockey file
		try{

			//creating scanner object
			Scanner scanVid = new Scanner(hockeyFile);

			//looping through text file to get comments
			while(scanVid.hasNextLine()){

				//reading in comments
				record = scanVid.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through words to store into hashtables
				for(int i = 0; i < words.length; i++){
					//adding words to video game hash table
					count = sportsHockey.get(words[i]);
					//if word doesn't exist in hashtable, then add to hashtable and make its occurrence = 1
					if(count == null){
						sportsHockey.put(words[i], 1);
					}
					//if word exists, then increment occurrence
					else{
						sportsHockey.put(words[i], count+1);
					}
					//adding words into wordCount hashtable
					count = wordCount.get(words[i]);
					//if word doens't exist in hashtable, then add to hashtable and make its occurrence = 1
					if(count == null){
						wordCount.put(words[i], 1);
					}
					//if word exists, then increment occurrence
					else{
						wordCount.put(words[i], count+1);
					}
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in sports-soccer file
		try{

			//creating scanner object
			Scanner scanVid = new Scanner(soccerFile);

			//looping through text file to get comments
			while(scanVid.hasNextLine()){

				//reading in comments
				record = scanVid.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through words to store into hashtables
				for(int i = 0; i < words.length; i++){
					//adding words to video game hash table
					count = sportsSoccer.get(words[i]);
					//if word doesn't exist in hashtable, then add to hashtable and make its occurrence = 1
					if(count == null){
						sportsSoccer.put(words[i], 1);
					}
					//if word exists, then increment occurrence
					else{
						sportsSoccer.put(words[i], count+1);
					}
					//adding words into wordCount hashtable
					count = wordCount.get(words[i]);
					//if word doens't exist in hashtable, then add to hashtable and make its occurrence = 1
					if(count == null){
						wordCount.put(words[i], 1);
					}
					//if word exists, then increment occurrence
					else{
						wordCount.put(words[i], count+1);
					}
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}


		//list of video categories to do comparisons for
		//educational
		//culinary
		//sports
		//technology
		//videogames

		//printing out cosine similarity of educational compared to all other video categories

		//printing out cosine similarity of educational vs culinary videos
		System.out.println("cosineSimilarity(educational, culinary) = " + cosineSimilarity(wordCount, educational, culinary));
		//printing out cosine similarity of educational vs sports videos
		System.out.println("cosineSimilarity(educational, sports) = " + cosineSimilarity(wordCount, educational, sports));
		//printing out cosine similarity of educational vs technology videos
		System.out.println("cosineSimilarity(educational, technology) = " + cosineSimilarity(wordCount, educational, technology));
		//printing out cosine similarity of educational vs videogames
		System.out.println("cosineSimilarity(educational, videoGames) = " + cosineSimilarity(wordCount, educational, videoGames));

		//printing out euclidean distance of educational compared to all other video categories

		//printing out euclidean distance of educational vs culinary
		System.out.println("euclideanDistance(educational, culinary) = " + euclideanDistance(wordCount, educational, culinary));
		//printing out euclidean distance of educational vs sports
		System.out.println("euclideanDistance(educational, sports) = " + euclideanDistance(wordCount, educational, sports));
		//printing out euclidean distance of educational vs technology
		System.out.println("euclideanDistance(educational, technology) = " + euclideanDistance(wordCount, educational, technology));
		//printing out euclidean distance of educational vs videoGames
		System.out.println("euclideanDistance(educational, videoGames) = " + euclideanDistance(wordCount, educational, videoGames));


		//printing out cosine similarity of culinary compared to all other video categories

		//printing out cosine similarity of culinary vs educational
		System.out.println("cosineSimilarity(culinary, educational) = " + cosineSimilarity(wordCount, culinary, educational));
		//printing out cosine similarity of culinary vs sports
		System.out.println("cosineSimilarity(culinary, sports) = " + cosineSimilarity(wordCount, culinary, sports));
		//printing out cosine similarity of culinary vs technology
		System.out.println("cosineSimilarity(culinary, technology) = " + cosineSimilarity(wordCount, culinary, technology));
		//printing out cosine similarity of culinary vs videogames
		System.out.println("cosineSimilarity(culinary, videoGames) = " + cosineSimilarity(wordCount, culinary, videoGames));

		//printing out euclidean distance of culinary compared to all other video categories

		//printing out euclidean distance of culinary vs educational
		System.out.println("euclideanDistance(culinary, educational) = " + euclideanDistance(wordCount, culinary, educational));
		//printing out euclidean distance of culinary vs sports
		System.out.println("euclideanDistance(culinary, sports) = " + euclideanDistance(wordCount, culinary, sports));
		//printing out euclidean distance of culinary vs technology
		System.out.println("euclideanDistance(culinary, technology) = " + euclideanDistance(wordCount, culinary, technology));
		//printing out euclidean distance of culinary vs videoGames
		System.out.println("euclideanDistance(culinary, videoGames) = " + euclideanDistance(wordCount, culinary, videoGames));

		//printing out cosine similarity of sports compared to all other video categories

		//printing out cosine similarity of sports vs educational
		System.out.println("cosineSimilarity(sports, educational) = " + cosineSimilarity(wordCount, sports, educational));
		//printing out cosine similarity of sports vs culinary
		System.out.println("cosineSimilarity(sports, culinary) = " + cosineSimilarity(wordCount, sports, culinary));
		//printing out cosine similarity of sports vs technology
		System.out.println("cosineSimilarity(sports, technology) = " + cosineSimilarity(wordCount, sports, technology));
		//printing out cosine similarity of sports vs videoGames
		System.out.println("cosineSimilarity(sports, videoGames) = " + cosineSimilarity(wordCount, sports, videoGames));

		//printing out euclidean distance of sports compared to all other video categories

		//printing out euclidean distance of sports vs educational
		System.out.println("euclideanDistance(sports, educational) = " + euclideanDistance(wordCount, sports, educational));
		//printing out euclidean distance of sports vs culinary
		System.out.println("euclideanDistance(sports, culinary) = " + euclideanDistance(wordCount, sports, culinary));
		//printing out euclidean distance of sports vs technology
		System.out.println("euclideanDistance(sports, technology) = " + euclideanDistance(wordCount, sports, technology));
		//printing out euclidean distance of sports vs videoGames
		System.out.println("euclideanDistance(sports, videoGames) = " + euclideanDistance(wordCount, sports, videoGames));

		//printing out cosine similarity of technology compared to all other video categories

		//printing out cosine similarity of technology vs educational
		System.out.println("cosineSimilarity(technology, educational) = " + cosineSimilarity(wordCount, technology, educational));
		//printing out cosine similarity of technology vs culinary
		System.out.println("cosineSimilarity(technology, culinary) = " + cosineSimilarity(wordCount, technology, culinary));
		//printing out cosine similarity of technology vs sports
		System.out.println("cosineSimilarity(technology, sports) = " + cosineSimilarity(wordCount, technology, sports));
		//printing out cosine similarity of technology vs videoGames
		System.out.println("cosineSimilarity(technology, videoGames) = " + cosineSimilarity(wordCount, technology, videoGames));

		//printing out euclidean distance of technology compared to all other video categories

		//printing out euclidean distance of technology vs educational
		System.out.println("euclideanDistance(technology, educational) = " + euclideanDistance(wordCount, technology, educational));
		//printing out euclidean distance of technology vs culinary
		System.out.println("euclideanDistance(technology, culinary) = " + euclideanDistance(wordCount, technology, culinary));
		//printing out euclidean distance of technology vs sports
		System.out.println("euclideanDistance(technology, sports) = " + euclideanDistance(wordCount, technology, sports));
		//printing out euclidean distance of technology vs videoGames
		System.out.println("euclideanDistance(technology, videoGames) = " + euclideanDistance(wordCount, technology, videoGames));		

		//printing out cosine similarity of videoGames compared to all other video categories

		//printing out cosine similarity of videoGames vs educational
		System.out.println("cosineSimilarity(videoGames, educational) = " + cosineSimilarity(wordCount, videoGames, educational));
		//printing out cosine similarity of videoGames vs culinary
		System.out.println("cosineSimilarity(videoGames, culinary) = " + cosineSimilarity(wordCount, videoGames, culinary));
		//printing out cosine similarity of videoGames vs sports
		System.out.println("cosineSimilarity(videoGames, sports) = " + cosineSimilarity(wordCount, videoGames, sports));
		//printing out cosine similairty of videoGames vs technology
		System.out.println("cosineSimilarity(videoGames, technology) = " + cosineSimilarity(wordCount, videoGames, technology));

		//printing out euclidean distance of videoGames compares to all other video categories

		//printing out euclidean distance of videoGames vs educational
		System.out.println("euclideanDistance(videoGames, educational) = " + euclideanDistance(wordCount, videoGames, educational));
		//printing out euclidean distance of videoGames vs culinary
		System.out.println("euclideanDistance(videoGames, culinary) = " + euclideanDistance(wordCount, videoGames, culinary));
		//printing out euclidean distance of videoGames vs sports
		System.out.println("euclideanDistance(videoGames, sports) = " + euclideanDistance(wordCount, videoGames, sports));
		//printing out euclidean distance of videoGames vs technology
		System.out.println("euclideanDistance(videoGames, technology) = " + euclideanDistance(wordCount, videoGames, technology));

		//printing all values from educational hashtable in descending order
		sorted = educational.entrySet()
							.stream()
							.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
							.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

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

		//printing all values from culinary hashtable in descending order
		sorted = culinary.entrySet()
							.stream()
							.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
							.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

		String culinaryOutput = "culinary_Values.txt";

		try{

			//creates writer to write data to file
			fileWrit = new FileWriter(culinaryOutput);
			buffWrit = new BufferedWriter(fileWrit);
			String lineOutput = "";

			for(String word : sorted.keySet()){
				lineOutput = word + ": " + culinary.get(word);
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

		//printing all values from sports hashtable in descending order
		sorted = sports.entrySet()
							.stream()
							.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
							.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

		String sportsOutput = "sports_Values.txt";

		try{

			//creates writer to write data to file
			fileWrit = new FileWriter(sportsOutput);
			buffWrit = new BufferedWriter(fileWrit);
			String lineOutput = "";

			for(String word : sorted.keySet()){
				lineOutput = word + ": " + sports.get(word);
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

		//printing all values from technology hashtable in descending order
		sorted = technology.entrySet()
							.stream()
							.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
							.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

		String technologyOutput = "technology_Values.txt";

		try{

			//creates writer to write data to file
			fileWrit = new FileWriter(technologyOutput);
			buffWrit = new BufferedWriter(fileWrit);
			String lineOutput = "";

			for(String word : sorted.keySet()){
				lineOutput = word + ": " + technology.get(word);
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

		//printing all values from videoGames hashtable in descending order
		sorted = videoGames.entrySet()
							.stream()
							.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
							.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

		String videoGamesOutput = "video_Games_Values.txt";

		try{

			//creates writer to write data to file
			fileWrit = new FileWriter(videoGamesOutput);
			buffWrit = new BufferedWriter(fileWrit);
			String lineOutput = "";

			for(String word : sorted.keySet()){
				lineOutput = word + ": " + videoGames.get(word);
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


	}

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