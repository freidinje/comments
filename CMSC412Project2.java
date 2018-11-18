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

public class CMSC412Project2{

	public static void main(String[] args){

		//HashMap to store occurence of all words from all videos
		HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
		//Hashmap used to store sorted values used for printing values in descending order
		Map<String, Integer> sorted;

		//HashMap used to count number of times each word occurs in each category and subcategories
		//uses word as key and number of occurrence of word as the value
		HashMap<String, Integer> culinary = new HashMap<String, Integer>();
		HashMap<String, Integer> educational = new HashMap<String, Integer>();
		HashMap<String, Integer> sports = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGames = new HashMap<String, Integer>();
		HashMap<String, Integer> technology = new HashMap<String, Integer>();

		//Hashmaps for subcategories of culinary
		HashMap<String, Integer> culinaryBreakfast = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryGrilling = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySavory = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySpicy = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySweet = new HashMap<String, Integer>();

		//Hashmaps for videos of culinary
		HashMap<String, Integer> culinaryBreakfast1 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryBreakfast2 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryBreakfast3 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryBreakfast4 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryBreakfast5 = new HashMap<String, Integer>();

		HashMap<String, Integer> culinaryGrilling1 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryGrilling2 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryGrilling3 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryGrilling4 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryGrilling5 = new HashMap<String, Integer>();

		HashMap<String, Integer> culinarySavory1 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySavory2 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySavory3 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySavory4 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySavory5 = new HashMap<String, Integer>();

		HashMap<String, Integer> culinarySpicy1 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySpicy2 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySpicy3 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySpicy4 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySpicy5 = new HashMap<String, Integer>();

		HashMap<String, Integer> culinarySweet1 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySweet2 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySweet3 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySweet4 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySweet5 = new HashMap<String, Integer>();


		//Hashmaps for subcategories for educational
		HashMap<String, Integer> educationalGeography = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalHistory = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalMath = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalPolitics = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalScience = new HashMap<String, Integer>();

		//Hashmaps for every video for educational
		HashMap<String, Integer> educationalGeography1 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalGeography2 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalGeography3 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalGeography4 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalGeography5 = new HashMap<String, Integer>();

		HashMap<String, Integer> educationalHistory1 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalHistory2 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalHistory3 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalHistory4 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalHistory5 = new HashMap<String, Integer>();

		HashMap<String, Integer> educationalMath1 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalMath2 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalMath3 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalMath4 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalMath5 = new HashMap<String, Integer>();

		HashMap<String, Integer> educationalPolitics1 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalPolitics2 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalPolitics3 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalPolitics4 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalPolitics5 = new HashMap<String, Integer>();

		HashMap<String, Integer> educationalScience1 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalScience2 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalScience3 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalScience4 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalScience5 = new HashMap<String, Integer>();

		//hashmap for subcategories of sports
		HashMap<String, Integer> sportsBaseball = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBasketball = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsFootball = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsHockey = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsSoccer = new HashMap<String, Integer>();

		//hashmap for videos of sports
		HashMap<String, Integer> sportsBaseball1 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBaseball2 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBaseball3 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBaseball4 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBaseball5 = new HashMap<String, Integer>();

		HashMap<String, Integer> sportsBasketball1 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBasketball2 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBasketball3 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBasketball4 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBasketball5 = new HashMap<String, Integer>();

		HashMap<String, Integer> sportsFootball1 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsFootball2 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsFootball3 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsFootball4 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsFootball5 = new HashMap<String, Integer>();

		HashMap<String, Integer> sportsHockey1 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsHockey2 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsHockey3 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsHockey4 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsHockey5 = new HashMap<String, Integer>();

		HashMap<String, Integer> sportsSoccer1 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsSoccer2 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsSoccer3 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsSoccer4 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsSoccer5 = new HashMap<String, Integer>();


		//hashmap for subcategories of video games
		HashMap<String, Integer> videoGames7Days = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesLol = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesMinecraft = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesOverwatch = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesRSix = new HashMap<String, Integer>();

		//hashmap for each video of video games
		HashMap<String, Integer> videoGames7Days1 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGames7Days2 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGames7Days3 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGames7Days4 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGames7Days5 = new HashMap<String, Integer>();

		HashMap<String, Integer> videoGamesLol1 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesLol2 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesLol3 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesLol4 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesLol5 = new HashMap<String, Integer>();

		HashMap<String, Integer> videoGamesMinecraft1 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesMinecraft2 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesMinecraft3 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesMinecraft4 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesMinecraft5 = new HashMap<String, Integer>();

		HashMap<String, Integer> videoGamesOverwatch1 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesOverwatch2 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesOverwatch3 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesOverwatch4 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesOverwatch5 = new HashMap<String, Integer>();

		HashMap<String, Integer> videoGamesRSix1 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesRSix2 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesRSix3 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesRSix4 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesRSix5 = new HashMap<String, Integer>();

		//hashmaps for subcategories of technology
		HashMap<String, Integer> technologyDIY = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyGadgets = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPC = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPhones = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyVR = new HashMap<String, Integer>();

		//hashmaps for technology videos
		HashMap<String, Integer> technologyDIY1 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyDIY2 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyDIY3 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyDIY4 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyDIY5 = new HashMap<String, Integer>();

		HashMap<String, Integer> technologyGadgets1 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyGadgets2 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyGadgets3 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyGadgets4 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyGadgets5 = new HashMap<String, Integer>();

		HashMap<String, Integer> technologyPC1 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPC2 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPC3 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPC4 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPC5 = new HashMap<String, Integer>();

		HashMap<String, Integer> technologyPhones1 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPhones2 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPhones3 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPhones4 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPhones5 = new HashMap<String, Integer>();

		HashMap<String, Integer> technologyVR1 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyVR2 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyVR3 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyVR4 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyVR5 = new HashMap<String, Integer>();


		//creating files to read in

		//culinary files
		File breakfast1 = new File("15 Easy And Delicious Breakfast Recipes Weekend Brunch Ideas French Toast Twisted.txt");
		File breakfast2 = new File("Breakfast Quesadillas.txt");
		File breakfast3 = new File("Easy 10 Breakfast Recipes.txt");
		File breakfast4 = new File("Meal Prep Breakfast For the Week.txt");
		File breakfast5 = new File("Slow Cooker Cooked Breakfast! MVK tries #8.txt");

		File grilling1 = new File("Fun Summer Grilling Recipes.txt");
		File grilling2 = new File("Grilled Chicken Wings - The Secrets to Grilling Perfect Crispy Chicken Wings.txt");
		File grilling3 = new File("Grilled Jalapeno Poppers Peppers by the BBQ Pit Boys.txt");
		File grilling4 = new File("The Art of Grilling How to Grill A Burger.txt");
		File grilling5 = new File("Top 10 Grilling Tips.txt");

		File savory1 = new File("8 Savory Recipes for Buffalo Lovers.txt");
		File savory2 = new File("Filipino Bacon (Tocino) Good Times with Jen.txt");
		File savory3 = new File("Joji and Rich Brian Make a Classic Japanese Street Food Feast Mansion.txt");
		File savory4 = new File("Murray's Cheese Makes The Best Grilled Cheese In NYC.txt");
		File savory5 = new File("Why Kobe Beef Is So Expensive.txt");

		File spicy1 = new File("6 Hot & Spicy Recipes.txt");
		File spicy2 = new File("Irish People Try Spicy American Beef Jerky (Carolina Reaper).txt");
		File spicy3 = new File("Schezwan Fried Rice Quick and Easy Chinese Fried Rice Recipe by Grandpa.txt");
		File spicy4 = new File("Spicy Big Mac (7 million scoville) - Epic Meal Time.txt");
		File spicy5 = new File("The Best SPICY KOREAN RICE CAKES (Tteokbokki) MUKBANG Eating Show.txt");

		File sweet1 = new File("7 Awesome Dessert Recipes You Can Make in 10 Minutes - How To Make Dessert.txt");
		File sweet2 = new File("Binging with Babish Cinnamon Rolls from Jim Gaffigan's Stand Up (sort of).txt");
		File sweet3 = new File("Pumpkin Bread - You Suck at Cooking (episode 81).txt");
		File sweet4 = new File("Tasty Texas Treats - Dessert Recipe Reviews.txt");
		File sweet5 = new File("We Tried To Make A 350-Year-Old Ice Cream Recipe.txt");

		//education files
		File geography1 = new File("Can You Make an Accurate Map.txt");
		File geography2 = new File("Continental Drift.txt");
		File geography3 = new File("Geography Now! MONACO.txt");
		File geography4 = new File("Learn the 50 states with Ms. Alexander.txt");
		File geography5 = new File("What can you do with geography.txt");

		File history1 = new File("H. H. Holmes - The Most Horrific Serial Killer in US History.txt");
		File history2 = new File("History of Britain in 20 Minutes.txt");
		File history3 = new File("Shamshi-Adad & the Old Assyrian Empire (2000-1750 BC) Ancient History Documentary.txt");
		File history4 = new File("Ten Minute History - The Fall of Rome (Short Documentary).txt");
		File history5 = new File("The Enron Scandal - A Simple Overview.txt");

		File math1 = new File("How the blockchain is changing money and business Don Tapscott.txt");
		File math2 = new File("How to Get Better at Math.txt");
		File math3 = new File("Math Videos How To Learn Basic Arithmetic Fast - Online Tutorial Lessons.txt");
		File math4 = new File("Tutoring Tips Mental Math Addition Tricks.txt");
		File math5 = new File("What is Calculus (Mathematics).txt");

		File politics1 = new File("POLITICAL SYSTEMS 101 Basic Forms of Government Explained.txt");
		File politics2 = new File("Political Parties Crash Course Government and Politics #40.txt");
		File politics3 = new File("The American Political System Explained in 10 Minutes.txt");
		File politics4 = new File("The Difference Between Socialism, Communism, and Marxism Explained by a Marxist.txt");
		File politcis5 = new File("What Happens if you Renounce Your Citizenship But Don't Belong to Another Country When You Do It.txt");

		File science1 = new File("Electricity Crash Course History of Science #27.txt");
		File science2 = new File("How A Massive Dam in China Slowed the Earth's Rotation.txt");
		File science3 = new File("Physics in 6 minutes.txt");
		File science4 = new File("Sigma and Pi Bonds Hybridization Explained!.txt");
		File science5 = new File("What is an atom and how do we know.txt");

		//sports files

		File baseball1 = new File("Adam Dunn had the weirdest career in MLB history Dorktown.txt");
		File baseball2 = new File("MLB High Baseball IQ Moments.txt");
		File baseball3 = new File("The Best Slider In the History Of Baseball.txt");
		File baseball4 = new File("The Hater's Guide to the 2018 MLB Postseason.txt");
		File baseball5 = new File("The Ugliest Plays In Baseball History.txt");

		File basketball1 = new File("BEST BASKETBALL VINES OF OCTOBER 2018 WEEK 2 SAUCY HIGHLIGHTS!.txt");
		File basketball2 = new File("NBA's Best Plays October 2018-19 NBA Season.txt");
		File basketball3 = new File("The New York Knicks Professional Basketball's Lolcow.txt");
		File basketball4 = new File("The Weirdest NBA Game You Probably Never Knew Existed!.txt");
		File basketball5 = new File("Troy State 253, DeVry 141 Pretty Good, Episode 12.txt");

		File football1 = new File("222-0. PRETTY GOOD, EPISODE 10..txt");
		File football2 = new File("Every NFL Score Ever Chart Party.txt");
		File football3 = new File("Kickers are Truly... One of a Kind.txt");
		File football4 = new File("TRANSFER PRANK NFL QB Jared Goff pranks unsuspecting college football team..txt");
		File football5 = new File("The New York Giants Professional Football's Sentient Derp.txt");

		File hockey1 = new File("GETTING CHIRPED IN THE DUSTIEST HOCKEY GEAR EVER.txt");
		File hockey2 = new File("GoPro Hockey BEER LEAGUERS VS. PRO.TXT");
		File hockey3 = new File("NHL Highlights Capitals vs Golden Knights, Game 5 - June 7, 2018.txt");
		File hockey4 = new File("One guy mercilessly trolled the NHL into creating a better rule book Weird Rules.txt");
		File hockey5 = new File("Watch the expansion of the NHL through the years.txt");

		File soccer1 = new File("100 KIDS vs 1 PRO Footballer In A Soccer Match.txt");
		File soccer2 = new File("A ref intentionally scored a goal and it counted Weird Rules.txt");
		File soccer3 = new File("Famous Dives Impossible To Forget.txt");
		File soccer4 = new File("Manchester United's Top 10 Premier League Comebacks Manchester United.txt");
		File soccer5 = new File("The highest scoring soccer match Unbreakable Records.txt");

		//video game files

		File 7days1 = new File("7 Days To Die - Ramblin Man EP1 (New Series).txt");
		File 7days2 = new File("7 Days to Die - JOURNEY'S END.txt");
		File 7days3 = new File("7 Days to Die - Prison Base - Is It Safe Against a Horde.txt");
		File 7days4 = new File("Big Surprise 7 Days To Die - The Wait For Alpha 17 Part 30.txt");
		File 7days5 = new File("Let's Play - 7 Days to Die for PC Part 1.txt");

		File lol1 = new File("1 MILLION IQ IN LEAGUE OF LEGENDS.txt");
		File lol2 = new File("Beginner's Guide to League of Legends.txt");
		File lol3 = new File("Most Viewed League of Legends Clips of ALL TIME!.txt");
		File lol4 = new File("SSG vs. SKT Finals Game 1 2017 World Championship Samsung Galaxy vs SK telecom T1.txt");
		File lol5 = new File("THE MOST MIRACULOUS SAVES IN LEAGUE OF LEGENDS.txt");

		File minecraft1 = new File("FORCING HACKERS TO PLAY THE DROPPER.txt");
		File minecraft2 = new File("How To Get Started With Tinkers' Construct Modded Minecraft.txt");
		File minecraft3 = new File("RageCraft - Minecraft Funny Moments, Rages and Fails.txt");
		File minecraft4 = new File("STEALING FROM THE RICHEST MANSIONS IN MINECRAFT!.txt");
		File minecraft5 = new File("The Killer Revealed - Minecraft - Clue Part 2 (#337) Let's Play.txt");

		File overwatch1 = new File("Bob Can't Do Something!! Overwatch Daily Moments Ep.586 (Funny and Random Moments).txt");
		File overwatch2 = new File("Overwatch Moments #181.txt");
		File overwatch3 = new File("Overwatch Season 13 BEST 7 HEROES! (Overwatch Guide).txt");
		File overwatch4 = new File("Overwatch World Cup USA 2018 - Day 1.txt");
		File overwatch5 = new File("THIS D.VA FAILS SO HARD! Overwatch Funny & Epic Moments 600.txt");

		File rSix1 = new File("How to INSTANTLY PULL MORE KILLS in Rainbow Six Siege Improve Your Game.txt");
		File rSix2 = new File("I'm A Mira Main - Rainbow Six Siege.txt");
		File rSix3 = new File("Massive News Update! Season 4! - Rainbow Six Siege.txt");
		File rSix4 = new File("NO FLEX ZONE Rainbow Six Siege w Wildcat & BasicallyIDoWrk.txt");
		File rSix5 = new File("One Man Army - Rainbow Six Siege.txt");

		//technology

		File diy1 = new File("7 Homemade Projects - 7 DIY Life Hacks.txt");
		File diy2 = new File("Building Custom DIY Portal Mirrors!.txt");
		File diy3 = new File("How to Make a Desk with Hidden Wireless Charging.txt");
		File diy4 = new File("Kill Mii Portable Wii in an Altoids Tin.txt");
		FIle diy5 = new File("William Osman Builds a Terrible Mechanical TV.txt");

		File gadgets1 = new File("10 Best Gaming Keyboards of 2018 (UNDER $50 + PREMIUM).txt");
		File gadgets2 = new File("5 Awesome Gadgets 2018 You Must Have in 2018.txt");
		File gadgets3 = new File("7 Best Laptop Accessories & Gadgets 2018 You Must Have.txt");
		File gadgets4 = new File("As Seen on TV Tech Gadgets TESTED!.txt");
		File gadgets5 = new File("Cool Tech Under $100 - October!.txt");

		File pc1 = new File("A $1300 Gaming PC That You Could Build for $1000.txt");
		File pc2 = new File("My $5,000 Gaming PC! Hotline 4K Benchmarks.txt");
		File pc3 = new File("Push, Pull and Push Pull setups for Radiators How to setup your fans.txt");
		File pc4 = new File("The Fastest Gaming PC I've Ever Built....txt");
		File pc5 = new File("The QUIETEST Gaming PC We've Ever Built!.txt");

		File phones1 = new File("Galaxy S9 Teardown - Variable Aperture Camera lens Revealed!.txt");
		File phones2 = new File("How We Added Wireless Charging to an iPhone - in China.txt");
		File phones3 = new File("Palm Phone hands-on an Android phone for your phone.txt");
		File phones4 = new File("Samsung Finally Showed Us Its First Foldable Phone — Future Blink.txt");
		File phones5 = new File("The ASUS ROG Phone is RIDICULOUS.txt");

		File vr1 = new File("Can you Game in VR on a Budget.txt");
		File vr2 = new File("Lenovo Mirage Solo VR Headset Review!.txt");
		File vr3 = new File("Oculus Go Review! The All-in-one VR Headset.txt");
		File vr4 = new File("Samsung Gear VR hands-on.txt");
		File vr5 = new File("TOP 5 Best VR Headset 2018.txt");


		//record stores comments read in by the scanner
		String record;
		//string array to store each individual word in comments
		String[] words;
		//count used to count number of occurence of words
		Integer count;

		//reading in category files


		//
		//reading in culinary videos
		//


		//reading in breakfast1 file
		try{

			//creating scanner object
			Scanner scanBreakfast1 = new Scanner(breakfast1);

			//looping through text files to read in comments
			while(scanBreakfast1.hasNextLine()){

				//reading in line
				record = scanBreakfast1.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(culinaryBreakfast1, words[i]);
					//add word to subcategory
					addWord(culinaryBreakfast, words[i]);
					//adding words into culinary hashtable
					addWord(culinary, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in breakfast2 file
		try{

			//creating scanner object
			Scanner scanBreakfast2 = new Scanner(breakfast2);

			//looping through text files to read in comments
			while(scanBreakfast2.hasNextLine()){

				//reading in line
				record = scanBreakfast2.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(culinaryBreakfast2, words[i]);
					//add word to subcategory
					addWord(culinaryBreakfast, words[i]);
					//adding words into culinary hashtable
					addWord(culinary, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in breakfast3 file
		try{

			//creating scanner object
			Scanner scanBreakfast3 = new Scanner(breakfast3);

			//looping through text files to read in comments
			while(scanBreakfast3.hasNextLine()){

				//reading in line
				record = scanBreakfast3.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(culinaryBreakfast3, words[i]);
					//add word to subcategory
					addWord(culinaryBreakfast, words[i]);
					//adding words into culinary hashtable
					addWord(culinary, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in breakfast4 file
		try{

			//creating scanner object
			Scanner scanBreakfast4 = new Scanner(breakfast1);

			//looping through text files to read in comments
			while(scanBreakfast4.hasNextLine()){

				//reading in line
				record = scanBreakfast4.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(culinaryBreakfast4, words[i]);
					//add word to subcategory
					addWord(culinaryBreakfast, words[i]);
					//adding words into culinary hashtable
					addWord(culinary, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in breakfast5 file
		try{

			//creating scanner object
			Scanner scanBreakfast5 = new Scanner(breakfast1);

			//looping through text files to read in comments
			while(scanBreakfast5.hasNextLine()){

				//reading in line
				record = scanBreakfast5.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(culinaryBreakfast5, words[i]);
					//add word to subcategory
					addWord(culinaryBreakfast, words[i]);
					//adding words into culinary hashtable
					addWord(culinary, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in grilling1 file
		try{

			//creating scanner object
			Scanner scanGrilling1 = new Scanner(grilling1);

			//looping through text files to read in comments
			while(scanGrilling1.hasNextLine()){

				//reading in line
				record = scanGrilling1.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(culinaryGrilling1, words[i]);
					//add word to subcategory
					addWord(culinaryGrilling, words[i]);
					//adding words into culinary hashtable
					addWord(culinary, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in grilling2 file
		try{

			//creating scanner object
			Scanner scanGrilling2 = new Scanner(grilling2);

			//looping through text files to read in comments
			while(scanGrilling2.hasNextLine()){

				//reading in line
				record = scanGrilling2.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(culinaryGrilling2, words[i]);
					//add word to subcategory
					addWord(culinaryGrilling, words[i]);
					//adding words into culinary hashtable
					addWord(culinary, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in grilling3 file
		try{

			//creating scanner object
			Scanner scanGrilling3 = new Scanner(grilling3);

			//looping through text files to read in comments
			while(scanGrilling3.hasNextLine()){

				//reading in line
				record = scanGrilling3.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(culinaryGrilling3, words[i]);
					//add word to subcategory
					addWord(culinaryGrilling, words[i]);
					//adding words into culinary hashtable
					addWord(culinary, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in grilling4 file
		try{

			//creating scanner object
			Scanner scanGrilling4 = new Scanner(grilling4);

			//looping through text files to read in comments
			while(scanGrilling4.hasNextLine()){

				//reading in line
				record = scanGrilling4.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(culinaryGrilling4, words[i]);
					//add word to subcategory
					addWord(culinaryGrilling, words[i]);
					//adding words into culinary hashtable
					addWord(culinary, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}


		//reading in grilling5 file
		try{

			//creating scanner object
			Scanner scanGrilling5 = new Scanner(grilling5);

			//looping through text files to read in comments
			while(scanGrilling5.hasNextLine()){

				//reading in line
				record = scanGrilling5.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(culinaryGrilling5, words[i]);
					//add word to subcategory
					addWord(culinaryGrilling, words[i]);
					//adding words into culinary hashtable
					addWord(culinary, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in savory1 file
		try{

			//creating scanner object
			Scanner scanSavory1 = new Scanner(savory1);

			//looping through text files to read in comments
			while(scanSavory1.hasNextLine()){

				//reading in line
				record = scanSavory1.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(culinarySavory1, words[i]);
					//add word to subcategory
					addWord(culinarySavory, words[i]);
					//adding words into culinary hashtable
					addWord(culinary, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}


		//reading in savory2 file
		try{

			//creating scanner object
			Scanner scanSavory2 = new Scanner(savory2);

			//looping through text files to read in comments
			while(scanSavory2.hasNextLine()){

				//reading in line
				record = scanSavory2.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(culinarySavory2, words[i]);
					//add word to subcategory
					addWord(culinarySavory, words[i]);
					//adding words into culinary hashtable
					addWord(culinary, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in savory3 file
		try{

			//creating scanner object
			Scanner scanSavory3 = new Scanner(savory3);

			//looping through text files to read in comments
			while(scanSavory3.hasNextLine()){

				//reading in line
				record = scanSavory3.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(culinarySavory3, words[i]);
					//add word to subcategory
					addWord(culinarySavory, words[i]);
					//adding words into culinary hashtable
					addWord(culinary, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in savory4 file
		try{

			//creating scanner object
			Scanner scanSavory4 = new Scanner(savory4);

			//looping through text files to read in comments
			while(scanSavory4.hasNextLine()){

				//reading in line
				record = scanSavory4.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(culinarySavory4, words[i]);
					//add word to subcategory
					addWord(culinarySavory, words[i]);
					//adding words into culinary hashtable
					addWord(culinary, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in savory5 file
		try{

			//creating scanner object
			Scanner scanSavory5 = new Scanner(savory5);

			//looping through text files to read in comments
			while(scanSavory5.hasNextLine()){

				//reading in line
				record = scanSavory5.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(culinarySavory5, words[i]);
					//add word to subcategory
					addWord(culinarySavory, words[i]);
					//adding words into culinary hashtable
					addWord(culinary, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}


		//reading in spicy1 file
		try{

			//creating scanner object
			Scanner scanSpicy1 = new Scanner(spicy1);

			//looping through text files to read in comments
			while(scanSpicy1.hasNextLine()){

				//reading in line
				record = scanSpicy1.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(culinarySpicy1, words[i]);
					//add word to subcategory
					addWord(culinarySpicy, words[i]);
					//adding words into culinary hashtable
					addWord(culinary, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in spicy2 file
		try{

			//creating scanner object
			Scanner scanSpicy2 = new Scanner(spicy2);

			//looping through text files to read in comments
			while(scanSpicy2.hasNextLine()){

				//reading in line
				record = scanSpicy2.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(culinarySpicy2, words[i]);
					//add word to subcategory
					addWord(culinarySpicy, words[i]);
					//adding words into culinary hashtable
					addWord(culinary, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}


		//reading in spicy3 file
		try{

			//creating scanner object
			Scanner scanSpicy3 = new Scanner(spicy3);

			//looping through text files to read in comments
			while(scanSpicy3.hasNextLine()){

				//reading in line
				record = scanSpicy3.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(culinarySpicy3, words[i]);
					//add word to subcategory
					addWord(culinarySpicy, words[i]);
					//adding words into culinary hashtable
					addWord(culinary, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in spicy4 file
		try{

			//creating scanner object
			Scanner scanSpicy4 = new Scanner(spicy4);

			//looping through text files to read in comments
			while(scanSpicy4.hasNextLine()){

				//reading in line
				record = scanSpicy4.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(culinarySpicy4, words[i]);
					//add word to subcategory
					addWord(culinarySpicy, words[i]);
					//adding words into culinary hashtable
					addWord(culinary, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in spicy5 file
		try{

			//creating scanner object
			Scanner scanSpicy5 = new Scanner(spicy5);

			//looping through text files to read in comments
			while(scanSpicy5.hasNextLine()){

				//reading in line
				record = scanSpicy5.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(culinarySpicy5, words[i]);
					//add word to subcategory
					addWord(culinarySpicy, words[i]);
					//adding words into culinary hashtable
					addWord(culinary, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in sweet1 file
		try{

			//creating scanner object
			Scanner scanSweet1 = new Scanner(sweet1);

			//looping through text files to read in comments
			while(scanSweet1.hasNextLine()){

				//reading in line
				record = scanSweet1.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(culinarySweet1, words[i]);
					//add word to subcategory
					addWord(culinarySweet, words[i]);
					//adding words into culinary hashtable
					addWord(culinary, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in sweet2 file
		try{

			//creating scanner object
			Scanner scanSweet2 = new Scanner(sweet2);

			//looping through text files to read in comments
			while(scanSweet2.hasNextLine()){

				//reading in line
				record = scanSweet2.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(culinarySweet2, words[i]);
					//add word to subcategory
					addWord(culinarySweet, words[i]);
					//adding words into culinary hashtable
					addWord(culinary, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in sweet3 file
		try{

			//creating scanner object
			Scanner scanSweet3 = new Scanner(sweet3);

			//looping through text files to read in comments
			while(scanSweet3.hasNextLine()){

				//reading in line
				record = scanSweet3.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(culinarySweet3, words[i]);
					//add word to subcategory
					addWord(culinarySweet, words[i]);
					//adding words into culinary hashtable
					addWord(culinary, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in sweet4 file
		try{

			//creating scanner object
			Scanner scanSweet4 = new Scanner(sweet4);

			//looping through text files to read in comments
			while(scanSweet4.hasNextLine()){

				//reading in line
				record = scanSweet4.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(culinarySweet4, words[i]);
					//add word to subcategory
					addWord(culinarySweet, words[i]);
					//adding words into culinary hashtable
					addWord(culinary, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in sweet5 file
		try{

			//creating scanner object
			Scanner scanSweet5 = new Scanner(sweet5);

			//looping through text files to read in comments
			while(scanSweet5.hasNextLine()){

				//reading in line
				record = scanSweet5.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(culinarySweet5, words[i]);
					//add word to subcategory
					addWord(culinarySweet, words[i]);
					//adding words into culinary hashtable
					addWord(culinary, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}


		//reading in educational files

		//reading in geography1 file
		try{

			//creating scanner object
			Scanner scanGeography1 = new Scanner(geography1);

			//looping through text files to read in comments
			while(scanGeography1.hasNextLine()){

				//reading in line
				record = scanGeography1.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(educationalGeography1, words[i]);
					//add word to subcategory
					addWord(educationalGeography, words[i]);
					//adding words into culinary hashtable
					addWord(educational, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in geography2 file
		try{

			//creating scanner object
			Scanner scanGeography2 = new Scanner(geography2);

			//looping through text files to read in comments
			while(scanGeography2.hasNextLine()){

				//reading in line
				record = scanGeography2.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(educationalGeography2, words[i]);
					//add word to subcategory
					addWord(educationalGeography, words[i]);
					//adding words into culinary hashtable
					addWord(educational, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in geography3 file
		try{

			//creating scanner object
			Scanner scanGeography3 = new Scanner(geography3);

			//looping through text files to read in comments
			while(scanGeography3.hasNextLine()){

				//reading in line
				record = scanGeography3.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(educationalGeography3, words[i]);
					//add word to subcategory
					addWord(educationalGeography, words[i]);
					//adding words into culinary hashtable
					addWord(educational, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in geography4 file
		try{

			//creating scanner object
			Scanner scanGeography4 = new Scanner(geography4);

			//looping through text files to read in comments
			while(scanGeography4.hasNextLine()){

				//reading in line
				record = scanGeography4.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(educationalGeography4, words[i]);
					//add word to subcategory
					addWord(educationalGeography, words[i]);
					//adding words into culinary hashtable
					addWord(educational, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in geography5 file
		try{

			//creating scanner object
			Scanner scanGeography5 = new Scanner(geography5);

			//looping through text files to read in comments
			while(scanGeography5.hasNextLine()){

				//reading in line
				record = scanGeography5.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(educationalGeography5, words[i]);
					//add word to subcategory
					addWord(educationalGeography, words[i]);
					//adding words into culinary hashtable
					addWord(educational, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}


		//reading in history1 file
		try{

			//creating scanner object
			Scanner scanHistory1 = new Scanner(history1);

			//looping through text files to read in comments
			while(scanHistory1.hasNextLine()){

				//reading in line
				record = scanHistory1.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(educationalHistory1, words[i]);
					//add word to subcategory
					addWord(educationalHistory, words[i]);
					//adding words into culinary hashtable
					addWord(educational, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in history2 file
		try{

			//creating scanner object
			Scanner scanHistory2 = new Scanner(history2);

			//looping through text files to read in comments
			while(scanHistory2.hasNextLine()){

				//reading in line
				record = scanHistory2.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(educationalHistory2, words[i]);
					//add word to subcategory
					addWord(educationalHistory, words[i]);
					//adding words into culinary hashtable
					addWord(educational, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in history3 file
		try{

			//creating scanner object
			Scanner scanHistory3 = new Scanner(history3);

			//looping through text files to read in comments
			while(scanHistory3.hasNextLine()){

				//reading in line
				record = scanHistory3.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(educationalHistory3, words[i]);
					//add word to subcategory
					addWord(educationalHistory, words[i]);
					//adding words into culinary hashtable
					addWord(educational, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in history4 file
		try{

			//creating scanner object
			Scanner scanHistory4 = new Scanner(history4);

			//looping through text files to read in comments
			while(scanHistory4.hasNextLine()){

				//reading in line
				record = scanHistory4.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(educationalHistory4, words[i]);
					//add word to subcategory
					addWord(educationalHistory, words[i]);
					//adding words into culinary hashtable
					addWord(educational, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in history5 file
		try{

			//creating scanner object
			Scanner scanHistory5 = new Scanner(history5);

			//looping through text files to read in comments
			while(scanHistory5.hasNextLine()){

				//reading in line
				record = scanHistory5.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(educationalHistory5, words[i]);
					//add word to subcategory
					addWord(educationalHistory, words[i]);
					//adding words into culinary hashtable
					addWord(educational, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in math1 file
		try{

			//creating scanner object
			Scanner scanMath1 = new Scanner(math1);

			//looping through text files to read in comments
			while(scanMath1.hasNextLine()){

				//reading in line
				record = scanMath1.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(educationalMath1, words[i]);
					//add word to subcategory
					addWord(educationalMath, words[i]);
					//adding words into culinary hashtable
					addWord(educational, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in math2 file
		try{

			//creating scanner object
			Scanner scanMath2 = new Scanner(math2);

			//looping through text files to read in comments
			while(scanMath2.hasNextLine()){

				//reading in line
				record = scanMath2.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(educationalMath2, words[i]);
					//add word to subcategory
					addWord(educationalMath, words[i]);
					//adding words into culinary hashtable
					addWord(educational, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in math3 file
		try{

			//creating scanner object
			Scanner scanMath3 = new Scanner(math3);

			//looping through text files to read in comments
			while(scanMath3.hasNextLine()){

				//reading in line
				record = scanMath3.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(educationalMath3, words[i]);
					//add word to subcategory
					addWord(educationalMath, words[i]);
					//adding words into culinary hashtable
					addWord(educational, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in math4 file
		try{

			//creating scanner object
			Scanner scanMath4 = new Scanner(math4);

			//looping through text files to read in comments
			while(scanMath4.hasNextLine()){

				//reading in line
				record = scanMath4.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(educationalMath4, words[i]);
					//add word to subcategory
					addWord(educationalMath, words[i]);
					//adding words into culinary hashtable
					addWord(educational, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in math5 file
		try{

			//creating scanner object
			Scanner scanMath5 = new Scanner(math5);

			//looping through text files to read in comments
			while(scanMath5.hasNextLine()){

				//reading in line
				record = scanMath5.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(educationalMath5, words[i]);
					//add word to subcategory
					addWord(educationalMath, words[i]);
					//adding words into culinary hashtable
					addWord(educational, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in Politics1 file
		try{

			//creating scanner object
			Scanner scanPolitics1 = new Scanner(politics1);

			//looping through text files to read in comments
			while(scanPolitics1.hasNextLine()){

				//reading in line
				record = scanPolitics1.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(educationalPolitics1, words[i]);
					//add word to subcategory
					addWord(educationalPolitics, words[i]);
					//adding words into culinary hashtable
					addWord(educational, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in Politics2 file
		try{

			//creating scanner object
			Scanner scanPolitics2 = new Scanner(politics2);

			//looping through text files to read in comments
			while(scanPolitics2.hasNextLine()){

				//reading in line
				record = scanPolitics2.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(educationalPolitics2, words[i]);
					//add word to subcategory
					addWord(educationalPolitics, words[i]);
					//adding words into culinary hashtable
					addWord(educational, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in Politics3 file
		try{

			//creating scanner object
			Scanner scanPolitics3 = new Scanner(politics3);

			//looping through text files to read in comments
			while(scanPolitics3.hasNextLine()){

				//reading in line
				record = scanPolitics3.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(educationalPolitics3, words[i]);
					//add word to subcategory
					addWord(educationalPolitics, words[i]);
					//adding words into culinary hashtable
					addWord(educational, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in Politics4 file
		try{

			//creating scanner object
			Scanner scanPolitics4 = new Scanner(politics4);

			//looping through text files to read in comments
			while(scanPolitics4.hasNextLine()){

				//reading in line
				record = scanPolitics4.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(educationalPolitics4, words[i]);
					//add word to subcategory
					addWord(educationalPolitics, words[i]);
					//adding words into culinary hashtable
					addWord(educational, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in Politics5 file
		try{

			//creating scanner object
			Scanner scanPolitics5 = new Scanner(politics5);

			//looping through text files to read in comments
			while(scanPolitics5.hasNextLine()){

				//reading in line
				record = scanPolitics5.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(educationalPolitics5, words[i]);
					//add word to subcategory
					addWord(educationalPolitics, words[i]);
					//adding words into culinary hashtable
					addWord(educational, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in Science1 file
		try{

			//creating scanner object
			Scanner scanScience1 = new Scanner(science1);

			//looping through text files to read in comments
			while(scanScience1.hasNextLine()){

				//reading in line
				record = scanScience1.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(educationalScience1, words[i]);
					//add word to subcategory
					addWord(educationalScience, words[i]);
					//adding words into culinary hashtable
					addWord(educational, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in Science1 file
		try{

			//creating scanner object
			Scanner scanScience1 = new Scanner(science1);

			//looping through text files to read in comments
			while(scanScience1.hasNextLine()){

				//reading in line
				record = scanScience1.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(educationalScience1, words[i]);
					//add word to subcategory
					addWord(educationalScience, words[i]);
					//adding words into culinary hashtable
					addWord(educational, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in Science2 file
		try{

			//creating scanner object
			Scanner scanScience2 = new Scanner(science2);

			//looping through text files to read in comments
			while(scanScience2.hasNextLine()){

				//reading in line
				record = scanScience2.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(educationalScience2, words[i]);
					//add word to subcategory
					addWord(educationalScience, words[i]);
					//adding words into culinary hashtable
					addWord(educational, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in Science3 file
		try{

			//creating scanner object
			Scanner scanScience3 = new Scanner(science3);

			//looping through text files to read in comments
			while(scanScience3.hasNextLine()){

				//reading in line
				record = scanScience3.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(educationalScience3, words[i]);
					//add word to subcategory
					addWord(educationalScience, words[i]);
					//adding words into culinary hashtable
					addWord(educational, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in Science4 file
		try{

			//creating scanner object
			Scanner scanScience4 = new Scanner(science4);

			//looping through text files to read in comments
			while(scanScience4.hasNextLine()){

				//reading in line
				record = scanScience4.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(educationalScience4, words[i]);
					//add word to subcategory
					addWord(educationalScience, words[i]);
					//adding words into culinary hashtable
					addWord(educational, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in Science5 file
		try{

			//creating scanner object
			Scanner scanScience5 = new Scanner(science5);

			//looping through text files to read in comments
			while(scanScience5.hasNextLine()){

				//reading in line
				record = scanScience5.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(educationalScience5, words[i]);
					//add word to subcategory
					addWord(educationalScience, words[i]);
					//adding words into culinary hashtable
					addWord(educational, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}


		//reading in sports files

		//reading in baseball1 file
		try{

			//creating scanner object
			Scanner scanBaseball1 = new Scanner(baseball1);

			//looping through text files to read in comments
			while(scanBaseball1.hasNextLine()){

				//reading in line
				record = scanBaseball1.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(sportsBaseball1, words[i]);
					//add word to subcategory
					addWord(sportsBaseball, words[i]);
					//adding words into culinary hashtable
					addWord(sports, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in baseball2 file
		try{

			//creating scanner object
			Scanner scanBaseball2 = new Scanner(baseball2);

			//looping through text files to read in comments
			while(scanBaseball2.hasNextLine()){

				//reading in line
				record = scanBaseball2.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(sportsBaseball2, words[i]);
					//add word to subcategory
					addWord(sportsBaseball, words[i]);
					//adding words into culinary hashtable
					addWord(sports, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in baseball3 file
		try{

			//creating scanner object
			Scanner scanBaseball3 = new Scanner(baseball3);

			//looping through text files to read in comments
			while(scanBaseball3.hasNextLine()){

				//reading in line
				record = scanBaseball3.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(sportsBaseball3, words[i]);
					//add word to subcategory
					addWord(sportsBaseball, words[i]);
					//adding words into culinary hashtable
					addWord(sports, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in baseball4 file
		try{

			//creating scanner object
			Scanner scanBaseball4 = new Scanner(baseball4);

			//looping through text files to read in comments
			while(scanBaseball4.hasNextLine()){

				//reading in line
				record = scanBaseball4.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(sportsBaseball4, words[i]);
					//add word to subcategory
					addWord(sportsBaseball, words[i]);
					//adding words into culinary hashtable
					addWord(sports, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in baseball5 file
		try{

			//creating scanner object
			Scanner scanBaseball5 = new Scanner(baseball5);

			//looping through text files to read in comments
			while(scanBaseball5.hasNextLine()){

				//reading in line
				record = scanBaseball5.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(sportsBaseball5, words[i]);
					//add word to subcategory
					addWord(sportsBaseball, words[i]);
					//adding words into culinary hashtable
					addWord(sports, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in basketball1 file
		try{

			//creating scanner object
			Scanner scanBasketball1 = new Scanner(basketball1);

			//looping through text files to read in comments
			while(scanBasketball1.hasNextLine()){

				//reading in line
				record = scanBasketball1.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(sportsBasketball1, words[i]);
					//add word to subcategory
					addWord(sportsBaskeyball, words[i]);
					//adding words into culinary hashtable
					addWord(sports, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in basketball2 file
		try{

			//creating scanner object
			Scanner scanBasketball2 = new Scanner(basketball2);

			//looping through text files to read in comments
			while(scanBasketball2.hasNextLine()){

				//reading in line
				record = scanBasketball2.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(sportsBasketball2, words[i]);
					//add word to subcategory
					addWord(sportsBaskeyball, words[i]);
					//adding words into culinary hashtable
					addWord(sports, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in basketball3 file
		try{

			//creating scanner object
			Scanner scanBasketball3 = new Scanner(basketball3);

			//looping through text files to read in comments
			while(scanBasketball3.hasNextLine()){

				//reading in line
				record = scanBasketball3.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(sportsBasketball3, words[i]);
					//add word to subcategory
					addWord(sportsBaskeyball, words[i]);
					//adding words into culinary hashtable
					addWord(sports, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in basketball4 file
		try{

			//creating scanner object
			Scanner scanBasketball4 = new Scanner(basketball4);

			//looping through text files to read in comments
			while(scanBasketball4.hasNextLine()){

				//reading in line
				record = scanBasketball4.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(sportsBasketball4, words[i]);
					//add word to subcategory
					addWord(sportsBaskeyball, words[i]);
					//adding words into culinary hashtable
					addWord(sports, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in basketball5 file
		try{

			//creating scanner object
			Scanner scanBasketball5 = new Scanner(basketball5);

			//looping through text files to read in comments
			while(scanBasketball5.hasNextLine()){

				//reading in line
				record = scanBasketball5.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(sportsBasketball5, words[i]);
					//add word to subcategory
					addWord(sportsBaskeyball, words[i]);
					//adding words into culinary hashtable
					addWord(sports, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in football1 file
		try{

			//creating scanner object
			Scanner scanFootball1 = new Scanner(football1);

			//looping through text files to read in comments
			while(scanFootball1.hasNextLine()){

				//reading in line
				record = scanFootball1.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(sportsFootball1, words[i]);
					//add word to subcategory
					addWord(sportsFootball, words[i]);
					//adding words into culinary hashtable
					addWord(sports, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in football2 file
		try{

			//creating scanner object
			Scanner scanFootball2 = new Scanner(football2);

			//looping through text files to read in comments
			while(scanFootball2.hasNextLine()){

				//reading in line
				record = scanFootball2.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(sportsFootball2, words[i]);
					//add word to subcategory
					addWord(sportsFootball, words[i]);
					//adding words into culinary hashtable
					addWord(sports, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in football3 file
		try{

			//creating scanner object
			Scanner scanFootball3 = new Scanner(football3);

			//looping through text files to read in comments
			while(scanFootball3.hasNextLine()){

				//reading in line
				record = scanFootball3.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(sportsFootball3, words[i]);
					//add word to subcategory
					addWord(sportsFootball, words[i]);
					//adding words into culinary hashtable
					addWord(sports, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in football4 file
		try{

			//creating scanner object
			Scanner scanFootball4 = new Scanner(football4);

			//looping through text files to read in comments
			while(scanFootball4.hasNextLine()){

				//reading in line
				record = scanFootball4.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(sportsFootball4, words[i]);
					//add word to subcategory
					addWord(sportsFootball, words[i]);
					//adding words into culinary hashtable
					addWord(sports, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in football5 file
		try{

			//creating scanner object
			Scanner scanFootball5 = new Scanner(football5);

			//looping through text files to read in comments
			while(scanFootball5.hasNextLine()){

				//reading in line
				record = scanFootball5.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(sportsFootball5, words[i]);
					//add word to subcategory
					addWord(sportsFootball, words[i]);
					//adding words into culinary hashtable
					addWord(sports, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in hockey1 file
		try{

			//creating scanner object
			Scanner scanHockey1 = new Scanner(hockey1);

			//looping through text files to read in comments
			while(scanHockey1.hasNextLine()){

				//reading in line
				record = scanHockey1.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(sportsHockey1, words[i]);
					//add word to subcategory
					addWord(sportsHockey, words[i]);
					//adding words into culinary hashtable
					addWord(sports, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in hockey2 file
		try{

			//creating scanner object
			Scanner scanHockey2 = new Scanner(hockey2);

			//looping through text files to read in comments
			while(scanHockey2.hasNextLine()){

				//reading in line
				record = scanHockey2.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(sportsHockey2, words[i]);
					//add word to subcategory
					addWord(sportsHockey, words[i]);
					//adding words into culinary hashtable
					addWord(sports, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in hockey3 file
		try{

			//creating scanner object
			Scanner scanHockey3 = new Scanner(hockey3);

			//looping through text files to read in comments
			while(scanHockey3.hasNextLine()){

				//reading in line
				record = scanHockey3.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(sportsHockey3, words[i]);
					//add word to subcategory
					addWord(sportsHockey, words[i]);
					//adding words into culinary hashtable
					addWord(sports, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in hockey4 file
		try{

			//creating scanner object
			Scanner scanHockey4 = new Scanner(hockey4);

			//looping through text files to read in comments
			while(scanHockey4.hasNextLine()){

				//reading in line
				record = scanHockey4.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(sportsHockey4, words[i]);
					//add word to subcategory
					addWord(sportsHockey, words[i]);
					//adding words into culinary hashtable
					addWord(sports, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in hockey5 file
		try{

			//creating scanner object
			Scanner scanHockey5 = new Scanner(hockey5);

			//looping through text files to read in comments
			while(scanHockey5.hasNextLine()){

				//reading in line
				record = scanHockey5.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(sportsHockey5, words[i]);
					//add word to subcategory
					addWord(sportsHockey, words[i]);
					//adding words into culinary hashtable
					addWord(sports, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in soccer1 file
		try{

			//creating scanner object
			Scanner scanSoccer1 = new Scanner(soccer1);

			//looping through text files to read in comments
			while(scanSoccer1.hasNextLine()){

				//reading in line
				record = scanSoccer1.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(sportsSoccer1, words[i]);
					//add word to subcategory
					addWord(sportsSoccer, words[i]);
					//adding words into culinary hashtable
					addWord(sports, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in soccer2 file
		try{

			//creating scanner object
			Scanner scanSoccer2 = new Scanner(soccer2);

			//looping through text files to read in comments
			while(scanSoccer2.hasNextLine()){

				//reading in line
				record = scanSoccer2.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(sportsSoccer2, words[i]);
					//add word to subcategory
					addWord(sportsSoccer, words[i]);
					//adding words into culinary hashtable
					addWord(sports, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in soccer3 file
		try{

			//creating scanner object
			Scanner scanSoccer3 = new Scanner(soccer3);

			//looping through text files to read in comments
			while(scanSoccer3.hasNextLine()){

				//reading in line
				record = scanSoccer3.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(sportsSoccer3, words[i]);
					//add word to subcategory
					addWord(sportsSoccer, words[i]);
					//adding words into culinary hashtable
					addWord(sports, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in soccer4 file
		try{

			//creating scanner object
			Scanner scanSoccer4 = new Scanner(soccer4);

			//looping through text files to read in comments
			while(scanSoccer4.hasNextLine()){

				//reading in line
				record = scanSoccer4.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(sportsSoccer4, words[i]);
					//add word to subcategory
					addWord(sportsSoccer, words[i]);
					//adding words into culinary hashtable
					addWord(sports, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in soccer5 file
		try{

			//creating scanner object
			Scanner scanSoccer5 = new Scanner(soccer5);

			//looping through text files to read in comments
			while(scanSoccer5.hasNextLine()){

				//reading in line
				record = scanSoccer5.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(sportsSoccer5, words[i]);
					//add word to subcategory
					addWord(sportsSoccer, words[i]);
					//adding words into culinary hashtable
					addWord(sports, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in 7days1 file
		try{

			//creating scanner object
			Scanner scan7days1 = new Scanner(7days1);

			//looping through text files to read in comments
			while(scan7days1.hasNextLine()){

				//reading in line
				record = scan7days1.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(videoGames7days1, words[i]);
					//add word to subcategory
					addWord(videoGames7days, words[i]);
					//adding words into culinary hashtable
					addWord(videoGames, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in 7days2 file
		try{

			//creating scanner object
			Scanner scan7days2 = new Scanner(7days2);

			//looping through text files to read in comments
			while(scan7days2.hasNextLine()){

				//reading in line
				record = scan7days2.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(videoGames7days2, words[i]);
					//add word to subcategory
					addWord(videoGames7days, words[i]);
					//adding words into culinary hashtable
					addWord(videoGames, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in 7days3 file
		try{

			//creating scanner object
			Scanner scan7days3 = new Scanner(7days3);

			//looping through text files to read in comments
			while(scan7days3.hasNextLine()){

				//reading in line
				record = scan7days3.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(videoGames7days3, words[i]);
					//add word to subcategory
					addWord(videoGames7days, words[i]);
					//adding words into culinary hashtable
					addWord(videoGames, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in 7days4 file
		try{

			//creating scanner object
			Scanner scan7days4 = new Scanner(7days4);

			//looping through text files to read in comments
			while(scan7days4.hasNextLine()){

				//reading in line
				record = scan7days4.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(videoGames7days4, words[i]);
					//add word to subcategory
					addWord(videoGames7days, words[i]);
					//adding words into culinary hashtable
					addWord(videoGames, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in 7days5 file
		try{

			//creating scanner object
			Scanner scan7days5 = new Scanner(7days5);

			//looping through text files to read in comments
			while(scan7days5.hasNextLine()){

				//reading in line
				record = scan7days5.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(videoGames7days5, words[i]);
					//add word to subcategory
					addWord(videoGames7days, words[i]);
					//adding words into culinary hashtable
					addWord(videoGames, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in lol1 file
		try{

			//creating scanner object
			Scanner scanLol1 = new Scanner(lol1);

			//looping through text files to read in comments
			while(scanLol1.hasNextLine()){

				//reading in line
				record = scanLol1.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(videoGamesLol1, words[i]);
					//add word to subcategory
					addWord(videoGamesLol, words[i]);
					//adding words into culinary hashtable
					addWord(videoGames, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in lol2 file
		try{

			//creating scanner object
			Scanner scanLol2 = new Scanner(lol2);

			//looping through text files to read in comments
			while(scanLol2.hasNextLine()){

				//reading in line
				record = scanLol2.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(videoGamesLol2, words[i]);
					//add word to subcategory
					addWord(videoGamesLol, words[i]);
					//adding words into culinary hashtable
					addWord(videoGames, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in lol3 file
		try{

			//creating scanner object
			Scanner scanLol3 = new Scanner(lol3);

			//looping through text files to read in comments
			while(scanLol3.hasNextLine()){

				//reading in line
				record = scanLol3.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(videoGamesLol3, words[i]);
					//add word to subcategory
					addWord(videoGamesLol, words[i]);
					//adding words into culinary hashtable
					addWord(videoGames, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in lol4 file
		try{

			//creating scanner object
			Scanner scanLol4 = new Scanner(lol4);

			//looping through text files to read in comments
			while(scanLol4.hasNextLine()){

				//reading in line
				record = scanLol4.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(videoGamesLol4, words[i]);
					//add word to subcategory
					addWord(videoGamesLol, words[i]);
					//adding words into culinary hashtable
					addWord(videoGames, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in lol5 file
		try{

			//creating scanner object
			Scanner scanLol5 = new Scanner(lol5);

			//looping through text files to read in comments
			while(scanLol5.hasNextLine()){

				//reading in line
				record = scanLol5.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(videoGamesLol5, words[i]);
					//add word to subcategory
					addWord(videoGamesLol, words[i]);
					//adding words into culinary hashtable
					addWord(videoGames, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in minecraft1 file
		try{

			//creating scanner object
			Scanner scanMinecraft1 = new Scanner(minecraft1);

			//looping through text files to read in comments
			while(scanMinecraft1.hasNextLine()){

				//reading in line
				record = scanMinecraft1.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(videoGamesMinecraft1, words[i]);
					//add word to subcategory
					addWord(videoGamesMinecraft, words[i]);
					//adding words into culinary hashtable
					addWord(videoGames, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in minecraft2 file
		try{

			//creating scanner object
			Scanner scanMinecraft2 = new Scanner(minecraft2);

			//looping through text files to read in comments
			while(scanMinecraft2.hasNextLine()){

				//reading in line
				record = scanMinecraft2.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(videoGamesMinecraft2, words[i]);
					//add word to subcategory
					addWord(videoGamesMinecraft, words[i]);
					//adding words into culinary hashtable
					addWord(videoGames, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in minecraft3 file
		try{

			//creating scanner object
			Scanner scanMinecraft3 = new Scanner(minecraft3);

			//looping through text files to read in comments
			while(scanMinecraft3.hasNextLine()){

				//reading in line
				record = scanMinecraft3.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(videoGamesMinecraft3, words[i]);
					//add word to subcategory
					addWord(videoGamesMinecraft, words[i]);
					//adding words into culinary hashtable
					addWord(videoGames, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in minecraft4 file
		try{

			//creating scanner object
			Scanner scanMinecraft4 = new Scanner(minecraft4);

			//looping through text files to read in comments
			while(scanMinecraft4.hasNextLine()){

				//reading in line
				record = scanMinecraft4.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(videoGamesMinecraft4, words[i]);
					//add word to subcategory
					addWord(videoGamesMinecraft, words[i]);
					//adding words into culinary hashtable
					addWord(videoGames, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in minecraft5 file
		try{

			//creating scanner object
			Scanner scanMinecraft5 = new Scanner(minecraft5);

			//looping through text files to read in comments
			while(scanMinecraft5.hasNextLine()){

				//reading in line
				record = scanMinecraft5.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(videoGamesMinecraft5, words[i]);
					//add word to subcategory
					addWord(videoGamesMinecraft, words[i]);
					//adding words into culinary hashtable
					addWord(videoGames, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in overwatch1 file
		try{

			//creating scanner object
			Scanner scanOverwatch1 = new Scanner(overwatch1);

			//looping through text files to read in comments
			while(scanOverwatch1.hasNextLine()){

				//reading in line
				record = scanOverwatch1.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(videoGamesOverwatch1, words[i]);
					//add word to subcategory
					addWord(videoGamesOverwatch, words[i]);
					//adding words into culinary hashtable
					addWord(videoGames, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in overwatch2 file
		try{

			//creating scanner object
			Scanner scanOverwatch2 = new Scanner(overwatch2);

			//looping through text files to read in comments
			while(scanOverwatch2.hasNextLine()){

				//reading in line
				record = scanOverwatch2.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(videoGamesOverwatch2, words[i]);
					//add word to subcategory
					addWord(videoGamesOverwatch, words[i]);
					//adding words into culinary hashtable
					addWord(videoGames, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in overwatch3 file
		try{

			//creating scanner object
			Scanner scanOverwatch3 = new Scanner(overwatch3);

			//looping through text files to read in comments
			while(scanOverwatch3.hasNextLine()){

				//reading in line
				record = scanOverwatch3.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(videoGamesOverwatch3, words[i]);
					//add word to subcategory
					addWord(videoGamesOverwatch, words[i]);
					//adding words into culinary hashtable
					addWord(videoGames, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in overwatch4 file
		try{

			//creating scanner object
			Scanner scanOverwatch4 = new Scanner(overwatch4);

			//looping through text files to read in comments
			while(scanOverwatch4.hasNextLine()){

				//reading in line
				record = scanOverwatch4.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(videoGamesOverwatch4, words[i]);
					//add word to subcategory
					addWord(videoGamesOverwatch, words[i]);
					//adding words into culinary hashtable
					addWord(videoGames, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in overwatch5 file
		try{

			//creating scanner object
			Scanner scanOverwatch5 = new Scanner(overwatch5);

			//looping through text files to read in comments
			while(scanOverwatch5.hasNextLine()){

				//reading in line
				record = scanOverwatch5.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(videoGamesOverwatch5, words[i]);
					//add word to subcategory
					addWord(videoGamesOverwatch, words[i]);
					//adding words into culinary hashtable
					addWord(videoGames, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in rSix1 file
		try{

			//creating scanner object
			Scanner scanRSix1 = new Scanner(rSix1);

			//looping through text files to read in comments
			while(scanRSix1.hasNextLine()){

				//reading in line
				record = scanRSix1.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(videoGamesRSix1, words[i]);
					//add word to subcategory
					addWord(videoGamesRSix, words[i]);
					//adding words into culinary hashtable
					addWord(videoGames, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in rSix2 file
		try{

			//creating scanner object
			Scanner scanRSix2 = new Scanner(rSix2);

			//looping through text files to read in comments
			while(scanRSix2.hasNextLine()){

				//reading in line
				record = scanRSix2.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(videoGamesRSix2, words[i]);
					//add word to subcategory
					addWord(videoGamesRSix, words[i]);
					//adding words into culinary hashtable
					addWord(videoGames, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in rSix3 file
		try{

			//creating scanner object
			Scanner scanRSix3 = new Scanner(rSix3);

			//looping through text files to read in comments
			while(scanRSix3.hasNextLine()){

				//reading in line
				record = scanRSix3.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(videoGamesRSix3, words[i]);
					//add word to subcategory
					addWord(videoGamesRSix, words[i]);
					//adding words into culinary hashtable
					addWord(videoGames, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in rSix4 file
		try{

			//creating scanner object
			Scanner scanRSix4 = new Scanner(rSix4);

			//looping through text files to read in comments
			while(scanRSix4.hasNextLine()){

				//reading in line
				record = scanRSix4.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(videoGamesRSix4, words[i]);
					//add word to subcategory
					addWord(videoGamesRSix, words[i]);
					//adding words into culinary hashtable
					addWord(videoGames, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

		//reading in rSix5 file
		try{

			//creating scanner object
			Scanner scanRSix5 = new Scanner(rSix5);

			//looping through text files to read in comments
			while(scanRSix5.hasNextLine()){

				//reading in line
				record = scanRSix5.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
				for(int i = 0; i < words.length; i++){
					//add word to video table
					addWord(videoGamesRSix5, words[i]);
					//add word to subcategory
					addWord(videoGamesRSix, words[i]);
					//adding words into culinary hashtable
					addWord(videoGames, words[i]);
					//adding words into wordCount hashtable
					addWord(wordCount, words[i]);
				}

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
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

	//function to add word to hashmap
	public static void addWord(HashMap<String, Integer> map, String word){

		Integer count;

		//gets count of word in map
		count = map.get(word);

		//if word doesn't exist then add it to the table
		if(count == null){
			map.put(word, 1);
		}
		//otherwise increment word occurrence
		else{
			map.put(word, count+1);
		}

	}

}