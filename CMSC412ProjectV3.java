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

public class CMSC412ProjectV3{

	public static void main(String[] args){

		//HashMap to store occurence of all words from all videos
		HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
		//Hashmap for ngrams
		HashMap<String, Integer> nGramCount = new HashMap<String, Integer>();

		//Hashmap used to store sorted values used for printing values in descending order
		Map<String, Integer> sorted;

		//HashMap used to count number of times each word occurs in each category and subcategories
		//uses word as key and number of occurrence of word as the value
		HashMap<String, Integer> culinary = new HashMap<String, Integer>();
		HashMap<String, Integer> educational = new HashMap<String, Integer>();
		HashMap<String, Integer> sports = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGames = new HashMap<String, Integer>();
		HashMap<String, Integer> technology = new HashMap<String, Integer>();

		//3gram pattern hashmaps for categories
		HashMap<String, Integer> culinaryPat = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalPat = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsPat = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesPat = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPat = new HashMap<String, Integer>();

		//Hashmaps for subcategories of culinary
		HashMap<String, Integer> culinaryBreakfast = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryGrilling = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySavory = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySpicy = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySweet = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryBreakfastPat = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryGrillingPat = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySavoryPat = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySpicyPat = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySweetPat = new HashMap<String, Integer>();


		//Hashmaps for videos of culinary
		HashMap<String, Integer> culinaryBreakfast1 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryBreakfast2 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryBreakfast3 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryBreakfast4 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryBreakfast5 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryBreakfastPat1 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryBreakfastPat2 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryBreakfastPat3 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryBreakfastPat4 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryBreakfastPat5 = new HashMap<String, Integer>();

		HashMap<String, Integer> culinaryGrilling1 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryGrilling2 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryGrilling3 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryGrilling4 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryGrilling5 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryGrillingPat1 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryGrillingPat2 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryGrillingPat3 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryGrillingPat4 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinaryGrillingPat5 = new HashMap<String, Integer>();

		HashMap<String, Integer> culinarySavory1 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySavory2 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySavory3 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySavory4 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySavory5 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySavoryPat1 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySavoryPat2 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySavoryPat3 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySavoryPat4 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySavoryPat5 = new HashMap<String, Integer>();

		HashMap<String, Integer> culinarySpicy1 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySpicy2 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySpicy3 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySpicy4 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySpicy5 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySpicyPat1 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySpicyPat2 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySpicyPat3 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySpicyPat4 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySpicyPat5 = new HashMap<String, Integer>();

		HashMap<String, Integer> culinarySweet1 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySweet2 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySweet3 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySweet4 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySweet5 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySweetPat1 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySweetPat2 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySweetPat3 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySweetPat4 = new HashMap<String, Integer>();
		HashMap<String, Integer> culinarySweetPat5 = new HashMap<String, Integer>();


		//Hashmaps for subcategories for educational
		HashMap<String, Integer> educationalGeography = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalHistory = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalMath = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalPolitics = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalScience = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalGeographyPat = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalHistoryPat = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalMathPat = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalPoliticsPat = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalSciencePat = new HashMap<String, Integer>();

		//Hashmaps for every video for educational
		HashMap<String, Integer> educationalGeography1 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalGeography2 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalGeography3 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalGeography4 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalGeography5 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalGeographyPat1 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalGeographyPat2 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalGeographyPat3 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalGeographyPat4 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalGeographyPat5 = new HashMap<String, Integer>();

		HashMap<String, Integer> educationalHistory1 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalHistory2 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalHistory3 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalHistory4 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalHistory5 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalHistoryPat1 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalHistoryPat2 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalHistoryPat3 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalHistoryPat4 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalHistoryPat5 = new HashMap<String, Integer>();

		HashMap<String, Integer> educationalMath1 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalMath2 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalMath3 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalMath4 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalMath5 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalMathPat1 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalMathPat2 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalMathPat3 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalMathPat4 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalMathPat5 = new HashMap<String, Integer>();


		HashMap<String, Integer> educationalPolitics1 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalPolitics2 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalPolitics3 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalPolitics4 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalPolitics5 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalPoliticsPat1 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalPoliticsPat2 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalPoliticsPat3 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalPoliticsPat4 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalPoliticsPat5 = new HashMap<String, Integer>();

		HashMap<String, Integer> educationalScience1 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalScience2 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalScience3 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalScience4 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalScience5 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalSciencePat1 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalSciencePat2 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalSciencePat3 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalSciencePat4 = new HashMap<String, Integer>();
		HashMap<String, Integer> educationalSciencePat5 = new HashMap<String, Integer>();


		//hashmap for subcategories of sports
		HashMap<String, Integer> sportsBaseball = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBasketball = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsFootball = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsHockey = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsSoccer = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBaseballPat = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBasketballPat = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsFootballPat = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsHockeyPat = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsSoccerPat = new HashMap<String, Integer>();

		//hashmap for videos of sports
		HashMap<String, Integer> sportsBaseball1 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBaseball2 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBaseball3 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBaseball4 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBaseball5 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBaseballPat1 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBaseballPat2 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBaseballPat3 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBaseballPat4 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBaseballPat5 = new HashMap<String, Integer>();

		HashMap<String, Integer> sportsBasketball1 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBasketball2 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBasketball3 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBasketball4 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBasketball5 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBasketballPat1 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBasketballPat2 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBasketballPat3 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBasketballPat4 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsBasketballPat5 = new HashMap<String, Integer>();

		HashMap<String, Integer> sportsFootball1 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsFootball2 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsFootball3 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsFootball4 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsFootball5 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsFootballPat1 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsFootballPat2 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsFootballPat3 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsFootballPat4 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsFootballPat5 = new HashMap<String, Integer>();

		HashMap<String, Integer> sportsHockey1 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsHockey2 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsHockey3 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsHockey4 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsHockey5 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsHockeyPat1 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsHockeyPat2 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsHockeyPat3 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsHockeyPat4 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsHockeyPat5 = new HashMap<String, Integer>();

		HashMap<String, Integer> sportsSoccer1 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsSoccer2 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsSoccer3 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsSoccer4 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsSoccer5 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsSoccerPat1 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsSoccerPat2 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsSoccerPat3 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsSoccerPat4 = new HashMap<String, Integer>();
		HashMap<String, Integer> sportsSoccerPat5 = new HashMap<String, Integer>();


		//hashmap for subcategories of video games
		HashMap<String, Integer> videoGames7Days = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesLol = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesMinecraft = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesOverwatch = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesRSix = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGames7DaysPat = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesLolPat = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesMinecraftPat = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesOverwatchPat = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesRSixPat = new HashMap<String, Integer>();

		//hashmap for each video of video games
		HashMap<String, Integer> videoGames7Days1 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGames7Days2 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGames7Days3 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGames7Days4 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGames7Days5 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGames7DaysPat1 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGames7DaysPat2 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGames7DaysPat3 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGames7DaysPat4 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGames7DaysPat5 = new HashMap<String, Integer>();

		HashMap<String, Integer> videoGamesLol1 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesLol2 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesLol3 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesLol4 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesLol5 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesLolPat1 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesLolPat2 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesLolPat3 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesLolPat4 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesLolPat5 = new HashMap<String, Integer>();

		HashMap<String, Integer> videoGamesMinecraft1 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesMinecraft2 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesMinecraft3 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesMinecraft4 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesMinecraft5 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesMinecraftPat1 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesMinecraftPat2 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesMinecraftPat3 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesMinecraftPat4 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesMinecraftPat5 = new HashMap<String, Integer>();

		HashMap<String, Integer> videoGamesOverwatch1 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesOverwatch2 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesOverwatch3 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesOverwatch4 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesOverwatch5 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesOverwatchPat1 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesOverwatchPat2 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesOverwatchPat3 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesOverwatchPat4 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesOverwatchPat5 = new HashMap<String, Integer>();

		HashMap<String, Integer> videoGamesRSix1 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesRSix2 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesRSix3 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesRSix4 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesRSix5 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesRSixPat1 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesRSixPat2 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesRSixPat3 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesRSixPat4 = new HashMap<String, Integer>();
		HashMap<String, Integer> videoGamesRSixPat5 = new HashMap<String, Integer>();

		//hashmaps for subcategories of technology
		HashMap<String, Integer> technologyDIY = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyGadgets = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPC = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPhones = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyVR = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyDIYPat = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyGadgetsPat = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPCPat = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPhonesPat = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyVRPat = new HashMap<String, Integer>();

		//hashmaps for technology videos
		HashMap<String, Integer> technologyDIY1 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyDIY2 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyDIY3 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyDIY4 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyDIY5 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyDIYPat1 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyDIYPat2 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyDIYPat3 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyDIYPat4 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyDIYPat5 = new HashMap<String, Integer>();

		HashMap<String, Integer> technologyGadgets1 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyGadgets2 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyGadgets3 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyGadgets4 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyGadgets5 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyGadgetsPat1 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyGadgetsPat2 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyGadgetsPat3 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyGadgetsPat4 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyGadgetsPat5 = new HashMap<String, Integer>();

		HashMap<String, Integer> technologyPC1 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPC2 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPC3 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPC4 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPC5 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPCPat1 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPCPat2 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPCPat3 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPCPat4 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPCPat5 = new HashMap<String, Integer>();

		HashMap<String, Integer> technologyPhones1 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPhones2 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPhones3 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPhones4 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPhones5 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPhonesPat1 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPhonesPat2 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPhonesPat3 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPhonesPat4 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyPhonesPat5 = new HashMap<String, Integer>();

		HashMap<String, Integer> technologyVR1 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyVR2 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyVR3 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyVR4 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyVR5 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyVRPat1 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyVRPat2 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyVRPat3 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyVRPat4 = new HashMap<String, Integer>();
		HashMap<String, Integer> technologyVRPat5 = new HashMap<String, Integer>();


		//creating files to read in

		//culinary files
		File breakfast1 = new File("comments/15 Easy And Delicious Breakfast Recipes  Weekend Brunch Ideas  French Toast  Twisted.txt");
      /*
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
		File politics5 = new File("What Happens if you Renounce Your Citizenship But Don't Belong to Another Country When You Do It.txt");

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

		File days1 = new File("7 Days To Die - Ramblin Man EP1 (New Series).txt");
		File days2 = new File("7 Days to Die - JOURNEY'S END.txt");
		File days3 = new File("7 Days to Die - Prison Base - Is It Safe Against a Horde.txt");
		File days4 = new File("Big Surprise 7 Days To Die - The Wait For Alpha 17 Part 30.txt");
		File days5 = new File("Let's Play - 7 Days to Die for PC Part 1.txt");

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
		File diy5 = new File("William Osman Builds a Terrible Mechanical TV.txt");

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
      */

		//reading in culinary files

		//reading in breakfast files
		readFile(nGramCount, culinaryPat, culinaryBreakfastPat, culinaryBreakfastPat1, breakfast1);
		readFile(nGramCount, cuilinaryPat, cuilnaryBreakfastPat, culinaryBreakfastPat2, breakfast2);
		readFile(nGramCount, culinaryPat, culinaryBreakfastPat, culinaryBreakfastPat3, breakfast3);
		readFile(nGramCount, culinaryPat, culinaryBreakfastPat, culinaryBreakfastPat4, breakfast4);
		readFile(nGramCount, culinaryPat, culinaryBreakfastPat, culinaryBreakfastPat5, breakfast5);

		//reading in grilling videos
		readFile(nGramCount, culinaryPat, culinaryGrillingPat, culinaryGrillingPat1, grilling1);
		readFile(nGramCount, culinaryPat, culinaryGrillingPat, culinaryGrillingPat2, grilling2);
		readFile(nGramCount, culinaryPat, culinaryGrillingPat, culinaryGrillingPat3, grilling3);
		readFile(nGramCount, culinaryPat, culinaryGrillingPat, culinaryGrillingPat4, grilling4);
		readFile(nGramCount, culinaryPat, culinaryGrillingPat, culinaryGrillingPat5, grilling5);

		//reading in savory videos
		readFile(nGramCount, culinaryPat, culinarySavoryPat, culinarySavoryPat1, savory1);
		readFile(nGramCount, culinaryPat, culinarySavoryPat, culinarySavoryPat2, savory2);
		readFile(nGramCount, culinaryPat, culinarySavoryPat, culinarySavoryPat3, savory3);
		readFile(nGramCount, culinaryPat, culinarySavoryPat, culinarySavoryPat4, savory4);
		readFile(nGramCount, culinaryPat, culinarySavoryPat, culinarySavoryPat5, savory5);

		//reading in spicy videos
		readFile(nGramCount, culinaryPat, culinarySpicyPat, culinarySpicyPat1, spicy1);
		readFile(nGramCount, culinaryPat, culinarySpicyPat, culinarySpicyPat2, spicy2);
		readFile(nGramCount, culinaryPat, culinarySpicyPat, culinarySpicyPat3, spicy3);
		readFile(nGramCount, culinaryPat, culinarySpicyPat, culinarySpicyPat4, spicy4);
		readFile(nGramCount, culinaryPat, culinarySpicyPat, culinarySpicyPat5, spicy5);

		//reading in sweet videos
		readFile(nGramCount, culinaryPat, culinarySweetPat, culinarySweetPat1, sweet1);
		readFile(nGramCount, culinaryPat, culinarySweetPat, culinarySweetPat2, sweet2);
		readFile(nGramCount, culinaryPat, culinarySweetPat, culinarySweetPat3, sweet3);
		readFile(nGramCount, culinaryPat, culinarySweetPat, culinarySweetPat4, sweet4);
		readFile(nGramCount, culinaryPat, culinarySweetPat, culinarySweetPat5, sweet5);

		//reading in education videos

		//reading in geography videos
		readFile(nGramCount, educationalPat, educationalGeographyPat, educationalGeographyPat1, geography1);
		readFile(nGramCount, educationalPat, educationalGeographyPat, educationalGeographyPat2, geography2);
		readFile(nGramCount, educationalPat, educationalGeographyPat, educationalGeographyPat3, geography3);
		readFile(nGramCount, educationalPat, educationalGeographyPat, educationalGeographyPat4, geography4);
		readFile(nGramCount, educationalPat, educationalGeographyPat, educationalGeographyPat5, geography5);

		//reading in history videos
		readFile(nGramCount, educationalPat, educationalHistoryPat, educationalHistoryPat1, history1);
		readFile(nGramCount, educationalPat, educationalHistoryPat, educationalHistoryPat2, history2);
		readFile(nGramCount, educationalPat, educationalHistoryPat, educationalHistoryPat3, history3);
		readFile(nGramCount, educationalPat, educationalHistoryPat, educationalHistoryPat4, history4);
		readFile(nGramCount, educationalPat, educationalHistoryPat, educationalHistoryPat5, history5);

		//reading in math videos
		readFile(nGramCount, educationalPat, educationalMathPat, educationalMathPat1, math1);
		readFile(nGramCount, educationalPat, educationalMathPat, educationalMathPat2, math2);
		readFile(nGramCount, educationalPat, educationalMathPat, educationalMathPat3, math3);
		readFile(nGramCount, educationalPat, educationalMathPat, educationalMathPat4, math4);
		readFile(nGramCount, educationalPat, educationalMathPat, educationalMathPat5, math5);

		//reading in politics videos
		readFile(nGramCount, educationalPat, educationalPoliticsPat, educationalPoliticsPat1, politics1);
		readFile(nGramCount, educationalPat, educationalPoliticsPat, educationalPoliticsPat2, politics2);
		readFile(nGramCount, educationalPat, educationalPoliticsPat, educationalPoliticsPat3, politics3);
		readFile(nGramCount, educationalPat, educationalPoliticsPat, educationalPoliticsPat4, politics4);
		readFile(nGramCount, educationalPat, educationalPoliticsPat, educationalPoliticsPat5, politics5);

		//reading in science videos
		readFile(nGramCount, educationalPat, educationalSciencePat, educationalSciencePat1, science1);
		readFile(nGramCount, educationalPat, educationalSciencePat, educationalSciencePat2, science2);
		readFile(nGramCount, educationalPat, educationalSciencePat, educationalSciencePat3, science3);
		readFile(nGramCount, educationalPat, educationalSciencePat, educationalSciencePat4, science4);
		readFile(nGramCount, educationalPat, educationalSciencePat, educationalSciencePat5, science5);

		//reading in sports videos

		//reading in baseball videos
		readFile(nGramCount, sportsPat, sportsBaseballPat, sportsBaseballPat1, baseball1);
		readFile(nGramCount, sportsPat, sportsBaseballPat, sportsBaseballPat2, baseball2);
		readFile(nGramCount, sportsPat, sportsBaseballPat, sportsBaseballPat3, baseball3);
		readFile(nGramCount, sportsPat, sportsBaseballPat, sportsBaseballPat4, baseball4);
		readFile(nGramCount, sportsPat, sportsBaseballPat, sportsBaseballPat5, baseball5);

		//reading in basketball videos
		readFile(nGramCount, sportsPat, sportsBasketballPat, sportsBasketballPat1, basketball1);
		readFile(nGramCount, sportsPat, sportsBasketballPat, sportsBasketballPat2, basketball2);
		readFile(nGramCount, sportsPat, sportsBasketballPat, sportsBasketballPat3, basketball3);
		readFile(nGramCount, sportsPat, sportsBasketballPat, sportsBasketballPat4, basketball4);
		readFile(nGramCount, sportsPat, sportsBasketballPat, sportsBasketballPat5, basketball5);

		//reading in football videos
		readFile(nGramCount, sportsPat, sportsFootballPat, sportsFootballPat1, football1);
		readFile(nGramCount, sportsPat, sportsFootballPat, sportsFootballPat2, football2);
		readFile(nGramCount, sportsPat, sportsFootballPat, sportsFootballPat3, football3);
		readFile(nGramCount, sportsPat, sportsFootballPat, sportsFootballPat4, football4);
		readFile(nGramCount, sportsPat, sportsFootballPat, sportsFootballPat5, football5);

		//reading in hockey videos
		readFile(nGramCount, sportsPat, sportsHockeyPat, sportsHockeyPat1, hockey1);
		readFile(nGramCount, sportsPat, sportsHockeyPat, sportsHockeyPat2, hockey2);
		readFile(nGramCount, sportsPat, sportsHockeyPat, sportsHockeyPat3, hockey3);
		readFile(nGramCount, sportsPat, sportsHockeyPat, sportsHockeyPat4, hockey4);
		readFile(nGramCount, sportsPat, sportsHockeyPat, sportsHockeyPat5, hockey5);

		//reading in soccer videos
		readFile(nGramCount, sportsPat, sportsSoccerPat, sportsSoccerPat1, soccer1);
		readFile(nGramCount, sportsPat, sportsSoccerPat, sportsSoccerPat2, soccer2);
		readFile(nGramCount, sportsPat, sportsSoccerPat, sportsSoccerPat3, soccer3);
		readFile(nGramCount, sportsPat, sportsSoccerPat, sportsSoccerPat4, soccer4);
		readFile(nGramCount, sportsPat, sportsSoccerPat, sportsSoccerPat5, soccer5);

		//reading in videoGames files

		//reading in days videos
		readFile(nGramCount, videoGamesPat, videoGames7Days, videoGames7Days1, days1);
		readFile(nGramCount, videoGamesPat, videoGames7Days, videoGames7Days2, days2);
		readFile(nGramCount, videoGamesPat, videoGames7Days, videoGames7Days3, days3);
		readFile(nGramCount, videoGamesPat, videoGames7Days, videoGames7Days4, days4);
		readFile(nGramCount, videoGamesPat, videoGames7Days, videoGames7Days5, days5);

		//reading in lol videos
		readFile(nGramCount, videoGamesPat, videoGamesLolPat, videoGamesLolPat1, lol1);
		readFile(nGramCount, videoGamesPat, videoGamesLolPat, videoGamesLolPat2, lol2);
		readFile(nGramCount, videoGamesPat, videoGamesLolPat, videoGamesLolPat3, lol3);
		readFile(nGramCount, videoGamesPat, videoGamesLolPat, videoGamesLolPat4, lol4);
		readFile(nGramCount, videoGamesPat, videoGamesLolPat, videoGamesLolPat5, lol5);

		//reading in minecraft videos
		readFile(nGramCount, videoGamesPat, videoGamesMinecraftPat, videoGamesMinecraftPat1, minecraft1);
		readFile(nGramCount, videoGamesPat, videoGamesMinecraftPat, videoGamesMinecraftPat2, minecraft2);
		readFile(nGramCount, videoGamesPat, videoGamesMinecraftPat, videoGamesMinecraftPat3, minecraft3);
		readFile(nGramCount, videoGamesPat, videoGamesMinecraftPat, videoGamesMinecraftPat4, minecraft4);
		readFile(nGramCount, videoGamesPat, videoGamesMinecraftPat, videoGamesMinecraftPat5, minecraft5);

		//reading in overwatch videos
		readFile(nGramCount, videoGamesPat, videoGamesOverwatchPat, videoGamesOverwatchPat1, overwatch1);
		readFile(nGramCount, videoGamesPat, videoGamesOverwatchPat, videoGamesOverwatchPat2, overwatch2);
		readFile(nGramCount, videoGamesPat, videoGamesOverwatchPat, videoGamesOverwatchPat3, overwatch3);
		readFile(nGramCount, videoGamesPat, videoGamesOverwatchPat, videoGamesOverwatchPat4, overwatch4);
		readFile(nGramCount, videoGamesPat, videoGamesOverwatchPat, videoGamesOverwatchPat5, overwatch5);

		//reading in rSix videos
		readFile(nGramCount, videoGamesPat, videoGamesRSixPat, videoGamesRSixPat1, rSix1);
		readFile(nGramCount, videoGamesPat, videoGamesRSixPat, videoGamesRSixPat2, rSix2);
		readFile(nGramCount, videoGamesPat, videoGamesRSixPat, videoGamesRSixPat3, rSix3);
		readFile(nGramCount, videoGamesPat, videoGamesRSixPat, videoGamesRSixPat4, rSix4);
		readFile(nGramCount, videoGamesPat, videoGamesRSixPat, videoGamesRSixPat5, rSix5);

		//reading in technology videos

		//reading in diy videos
		readFile(nGramCount, technologyPat, technologyDIYPat, technologyDIYPat1, diy1);
		readFile(nGramCount, technologyPat, technologyDIYPat, technologyDIYPat2, diy2);
		readFile(nGramCount, technologyPat, technologyDIYPat, technologyDIYPat3, diy3);
		readFile(nGramCount, technologyPat, technologyDIYPat, technologyDIYPat4, diy4);
		readFile(nGramCount, technologyPat, technologyDIYPat, technologyDIYPat5, diy5);

		//reading in gadgets videos
		readFile(nGramCount, technologyPat, technologyGadgetsPat, technologyGadgetsPat1, gadgets1);
		readFile(nGramCount, technologyPat, technologyGadgetsPat, technologyGadgetsPat2, gadgets2);
		readFile(nGramCount, technologyPat, technologyGadgetsPat, technologyGadgetsPat3, gadgets3);
		readFile(nGramCount, technologyPat, technologyGadgetsPat, technologyGadgetsPat4, gadgets4);
		readFile(nGramCount, technologyPat, technologyGadgetsPat, technologyGadgetsPat5, gadgets5);

		//reading in pc videos
		readFile(nGramCount, technologyPat, technologyPCPat, technologyPCPat1, pc1);
		readFile(nGramCount, technologyPat, technologyPCPat, technologyPCPat2, pc2);
		readFile(nGramCount, technologyPat, technologyPCPat, technologyPCPat3, pc3);
		readFile(nGramCount, technologyPat, technologyPCPat, technologyPCPat4, pc4);
		readFile(nGramCount, technologyPat, technologyPCPat, technologyPCPat5, pc5);

		//reading in phones videos
		readFile(nGramCount, technologyPat, technologyPhonesPat, technologyPhonesPat1, phones1);
		readFile(nGramCount, technologyPat, technologyPhonesPat, technologyPhonesPat2, phones2);
		readFile(nGramCount, technologyPat, technologyPhonesPat, technologyPhonesPat3, phones3);
		readFile(nGramCount, technologyPat, technologyPhonesPat, technologyPhonesPat4, phones4);
		readFile(nGramCount, technologyPat, technologyPhonesPat, technologyPhonesPat5, phones5);

		//reading in vr videos
		readFile(nGramCount, technologyPat, technologyVRPat, technologyVRPat1, vr1);
		readFile(nGramCount, technologyPat, technologyVRPat, technologyVRPat2, vr2);
		readFile(nGramCount, technologyPat, technologyVRPat, technologyVRPat3, vr3);
		readFile(nGramCount, technologyPat, technologyVRPat, technologyVRPat4, vr4);
		readFile(nGramCount, technologyPat, technologyVRPat, technologyVRPat5, vr5);


		//printing out hashmaps to txt files
		printHashMap(nGramCount, "nGrams_values.txt");

		//printing out culinary hashmaps
		printHashMap(culinaryPat, "culinaryPat_values.txt");
		printHashMap(culinaryBreakfastPat, "culinaryBreakfastPat_values.txt");
		printHashMap(culinaryBreakfastPat1, "culinaryBreakfastPat1_values.txt");
		printHashMap(culinaryBreakfastPat2, "culinaryBreakfastPat2_values.txt");
		printHashMap(culinaryBreakfastPat3, "culinaryBreakfastPat3_values.txt");
		printHashMap(culinaryBreakfastPat4, "culinaryBreakfastPat4_values.txt");
		printHashMap(culinaryBreakfastPat5, "culinaryBreakfastPat5_values.txt");

		printHashMap(culinaryGrillingPat, "culinaryGrillingPat_values.txt");
		printHashMap(culinaryGrillingPat1, "culinaryGrillingPat1_values.txt");
		printHashMap(culinaryGrillingPat2, "culinaryGrillingPat2_values.txt");
		printHashMap(culinaryGrillingPat3, "culinaryGrillingPat3_values.txt");
		printHashMap(culinaryGrillingPat4, "culinaryGrillingPat4_values.txt");
		printHashMap(culinaryGrillingPat5, "culinaryGrillingPat5_values.txt");

		printHashMap(culinarySavoryPat, "culinarySavoryPat_values.txt");
		printHashMap(culinarySavoryPat1, "culinarySavoryPat1_values.txt");
		printHashMap(culinarySavoryPat2, "culinarySavoryPat2_values.txt");
		printHashMap(culinarySavoryPat3, "culinarySavoryPat3_values.txt");
		printHashMap(culinarySavoryPat4, "culinarySavoryPat4_values.txt");
		printHashMap(culinarySavoryPat5, "culinarySavoryPat5_values.txt");

		printHashMap(culinarySpicyPat, "culinarySpicyPat_values.txt");
		printHashMap(culinarySpicyPat1, "culinarySpicyPat1_values.txt");
		printHashMap(culinarySpicyPat2, "culinarySpicyPat2_values.txt");
		printHashMap(culinarySpicyPat3, "culinarySpicyPat3_values.txt");
		printHashMap(culinarySpicyPat4, "culinarySpicyPat4_values.txt");
		printHashMap(culinarySpicyPat5, "culinarySpicyPat5_values.txt");

		printHashMap(culinarySweetPat, "culinarySweetPat_values.txt");
		printHashMap(culinarySweetPat1, "culinarySweetPat1_values.txt");
		printHashMap(culinarySweetPat2, "culinarySweetPat2_values.txt");
		printHashMap(culinarySweetPat3, "culinarySweetPat3_values.txt");
		printHashMap(culinarySweetPat4, "culinarySweetPat4_values.txt");
		printHashMap(culinarySweetPat5, "culinarySweetPat5_values.txt");

		//printing educational hashmap
		printHashMap(educationalPat, "educationalPat_values.txt");
		printHashMap(educationalGeographyPat, "educationalGeographyPat_values.txt");
		printHashMap(educationalGeographyPat1, "educationalGeographyPat1_values.txt");
		printHashMap(educationalGeographyPat2, "educationalGeographyPat2_values.txt");
		printHashMap(educationalGeographyPat3, "educationalGeographyPat3_values.txt");
		printHashMap(educationalGeographyPat4, "educationalGeographyPat4_values.txt");
		printHashMap(educationalGeographyPat5, "educationalGeographyPat5_values.txt");

		printHashMap(educationalHistoryPat, "educationalHistoryPat_values.txt");
		printHashMap(educationalHistoryPat1, "educationalHistoryPat1_values.txt");
		printHashMap(educationalHistoryPat2, "educationalHistoryPat2_values.txt");
		printHashMap(educationalHistoryPat3, "educationalHistoryPat3_values.txt");
		printHashMap(educationalHistoryPat4, "educationalHistoryPat4_values.txt");
		printHashMap(educationalHistoryPat5, "educationalHistoryPat5_values.txt");

		printHashMap(educationalMathPat, "educationalMathPat_values.txt");
		printHashMap(educationalMathPat1, "educationalMathPat1_values.txt");
		printHashMap(educationalMathPat2, "educationalMathPat2_values.txt");
		printHashMap(educationalMathPat3, "educationalMathPat3_values.txt");
		printHashMap(educationalMathPat4, "educationalMathPat4_values.txt");
		printHashMap(educationalMathPat5, "educationalMathPat5_values.txt");

		printHashMap(educationalPoliticsPat, "educationalPoliticsPat_values.txt");
		printHashMap(educationalPoliticsPat1, "educationalPoliticsPat1_values.txt");
		printHashMap(educationalPoliticsPat2, "educationalPoliticsPat2_values.txt");
		printHashMap(educationalPoliticsPat3, "educationalPoliticsPat3_values.txt");
		printHashMap(educationalPoliticsPat4, "educationalPoliticsPat4_values.txt");
		printHashMap(educationalPoliticsPat5, "educationalPoliticsPat5_values.txt");

		printHashMap(educationalSciencePat, "educationalSciencePat_values.txt");
		printHashMap(educationalSciencePat1, "educationalSciencePat1_values.txt");
		printHsahMap(educationalSciencePat2, "educationalSciencePat2_values.txt");
		printHashMap(educationalSciencePat3, "educationalSciencePat3_values.txt");
		printHashMap(educationalSciencePat4, "educationalSciencePat4_values.txt");
		printHashMap(educationalSciencePat5, "educationalSciencePat5_values.txt");

		//printing out sports hashmaps
		printHashMap(sportsPat, "sportsPat_values.txt");
		printHashMap(sportsBaseballPat, "sportsBaseballPat_values.txt");
		printHashMap(sportsBaseballPat1, "sportsBaseballPat1_values.txt");
		printHashMap(sportsBaseballPat2, "sportsBaseballPat2_values.txt");
		printHashMap(sportsBaseballPat3, "sportsBaseballPat3_values.txt");
		printHashMap(sportsBaseballPat4, "sportsBaseballPat4_values.txt");
		printHashMap(sportsBaseballPat5, "sportsBaseballPat5_values.txt");

		printHashMap(sportsBasketballPat, "sportsBasketballPat_values.txt");
		printHashMap(sportsBasketballPat1, "sportsBasketballPat1_values.txt");
		printHashMap(sportsBasketballPat2, "sportsBasketballPat2_values.txt");
		printHashMap(sportsBasketballPat3, "sportsBasketballPat3_values.txt");
		printHashMap(sportsBasketballPat4, "sportsBasketballPat4_values.txt");
		printHashMap(sportsBasketballPat5, "sportsBasketballPat5_values.txt");

		printHashMap(sportsFootballPat, "sportsFootballPat_values.txt");
		printHashMap(sportsFootballPat1, "sportsFootballPat1_values.txt");
		printHashMap(sportsFootballPat2, "sportsFootballPat2_values.txt");
		printHashMap(sportsFootballPat3, "sportsFootballPat3_values.txt");
		printHashMap(sportsFootballPat4, "sportsFootballPat4_values.txt");
		printHashMap(sportsFootballPat5, "sportsFootballPat5_values.txt");

		printHashMap(sportsHockeyPat, "sportsHockeyPat_values.txt");
		printHashMap(sportsHockeyPat1, "sportsHockeyPat1_values.txt");
		printHashMap(sportsHockeyPat2, "sportsHockeyPat2_values.txt");
		printHashMap(sportsHockeyPat3, "sportsHockeyPat3_values.txt");
		printHashMap(sportsHockeyPat4, "sportsHockeyPat4_values.txt");
		printHashMap(sportsHockeyPat5, "sportsHockeyPat5_values.txt");

		printHashMap(sportsSoccerPat, "sportsSoccerPat_values.txt");
		printHashMap(sportsSoccerPat1, "sportsSoccerPat1_values.txt");
		printHashMap(sportsSoccerPat2, "sportsSoccerPat2_values.txt");
		printHashMap(sportsSoccerPat3, "sportsSoccerPat3_values.txt");
		printHashMap(sportsSoccerPat4, "sportsSoccerPat4_values.txt");
		printHashMap(sportsSoccerPat5, "sportsSoccerPat5_values.txt");

		printHashMap(videoGamesPat, "videoGamesPat_values.txt");
		printHashMap(videoGames7DaysPat, "videoGames7DaysPat_values.txt");
		printHashMap(videoGames7DaysPat1, "videoGames7DaysPat1_values.txt");
		printHashMap(videoGames7DaysPat2, "videoGames7DaysPat2_values.txt");
		printHashMap(videoGames7DaysPat3, "videoGames7DaysPat3_values.txt");
		printHashMap(videoGames7DaysPat4, "videoGames7DaysPat4_values.txt");
		printHashMap(videoGames7DaysPat5, "videoGames7DaysPat5_values.txt");

		printHashMap(videoGamesLolPat, "videoGamesLolPat_values.txt");
		printHashMap(videoGamesLolPat1, "videoGamesLolPat1_values.txt");
		printHashMap(videoGamesLolPat2, "videoGamesLolPat2_values.txt");
		printHashMap(videoGamesLolPat3, "videoGamesLolPat3_values.txt");
		printHashMap(videoGamesLolPat4, "videoGamesLolPat4_values.txt");
		printHashMap(videoGamesLolPat5, "videoGamesLolPat5_values.txt");

		printHashMap(videoGamesMinecraftPat, "videoGamesMinecraftPat_values.txt");
		printHashMap(videoGamesMinecraftPat1, "videoGamesMinecraftPat1_values.txt");
		printHashMap(videoGamesMinecraftPat2, "videoGamesMinecraftPat2_values.txt");
		printHashMap(videoGamesMinecraftPat3, "videoGamesMinecraftPat3_values.txt");
		printHashMap(videoGamesMinecraftPat4, "videoGamesMinecraftPat4_values.txt");
		printHashMap(videoGamesMinecraftPat5, "vidoeGamesMinecraftPat5_values.txt");

		printHashMap(videoGamesOverwatchPat, "videoGamesOverwatchPat_values.txt");
		printHashMap(videoGamesOverwatchPat1, "videoGamesOverwatchPat1_values.txt");
		printHashMap(videoGamesOverwatchPat2, "videoGamesOverwatchPat2_values.txt");
		printHashMap(videoGamesOverwatchPat3, "videoGamesOverwatchPat3_values.txt");
		printHashMap(videoGamesOverwatchPat4, "videoGamesOverwatchPat4_values.txt");
		printHashMap(videoGamesOverwatchPat5, "videoGamesOverwatchPat5_values.txt");

		printHashMap(videoGamesRSixPat, "videoGamesRSixPat_values.txt");
		printHashMap(videoGamesRSixPat1, "videoGamesRSixPat1_values.txt");
		printHashMap(videoGamesRSixPat2, "videoGamesRSixPat2_values.txt");
		printHashMap(videoGamesRSixPat3, "videoGamesRSixPat3_values.txt");
		printHashMap(videoGamesRSixPat4, "videoGamesRSixPat4_values.txt");
		printHashMap(videoGamesRSixPat5, "videoGamesRSixPat5_values.txt");


		//printing technology hashmaps
		printHashMap(technologyPat, "technologyPat_values.txt");
		printHashMap(technologyDIYPat, "technologyDIYPat_values.txt");
		printHashMap(technologyDIYPat1, "technologyDIYPat1_values.txt");
		printHashMap(technologyDIYPat2, "technologyDIYPat2_values.txt");
		printHashMap(technologyDIYPat3, "technologyDIYPat3_values.txt");
		printHashMap(technologyDIYPat4, "technologyDIYPat4_values.txt");
		printHashMap(technologyDIYPat5, "technologyDIYPat5_values.txt");

		printHashMap(technologyGadgetsPat, "technologyGadgetsPat_values.txt");
		printHashMap(technologyGadgetsPat1, "technologyGadgetsPat1_values.txt");
		printHashMap(technologyGadgetsPat2, "technologyGadgetsPat2_values.txt");
		printHashMap(technologyGadgetsPat3, "technologyGadgetsPat3_values.txt");
		printHashMap(technologyGadgetsPat4, "technologyGadgetsPat4_values.txt");
		printHashMap(technologyGadgetsPat5, "technologyGadgetsPat5_values.txt");

		printHashMap(technologyPCPat, "technologyPCPat_values.txt");
		printHashMap(technologyPCPat1, "technologyPCPat1_values.txt");
		printHashMap(technologyPCPat2, "technologyPCPat2_values.txt");
		printHashMap(technologyPCPat3, "technologyPCPat3_values.txt");
		printHashMap(technologyPCPat4, "technologyPCPat4_values.txt");
		printHashMap(technologyPCPat5, "technologyPCPat5_values.txt");

		printHashMap(technologyPhonesPat, "technologyPhonesPat_values.txt");
		printHashMap(technologyPhonesPat1, "technologyPhonesPat1_values.txt");
		printHashMap(technologyPhonesPat2, "technologyPhonesPat2_values.txt");
		printHashMap(technologyPhonesPat3, "technologyPhonesPat3_values.txt");
		printHashMap(technologyPhonesPat4, "technologyPhonesPat4_values.txt");
		printHashMap(technologyPhonesPat5, "technologyPhonesPat5_values.txt");

		printHashMap(technologyVRPat, "technologyVRPat_values.txt");
		printHashMap(technologyVRPat1, "technologyVRPat1_values.txt");
		printHashMap(technologyVRPat2, "technologyVRPat2_values.txt");
		printHashMap(technologyVRPat3, "technologyVRPat3_values.txt");
		printHashMap(technologyVRPat4, "technologyVRPat4_values.txt");
		printHashMap(technologyVRPat5, "technologyVRPat5_values.txt");

		//Writing gml file for cosine similarity
		printNodeData("videoCosineSimilarity.gml");


	}

	//writes gml file for cosine similarity
	public static void printNodeData(String outputFile){


		BufferedWriter buffWrit = null;
      	FileWriter fileWrit = null;

		try{

			//creates writer to write data to file
			fileWrit = new FileWriter(outputFile);
			buffWrit = new BufferedWriter(fileWrit);
			String lineOutput = "graph\n";

			//25, 50, 75, 100, 125
			lineOutput += "[\n";
			for(int i = 0; i < 125; i++){
				lineOutput += "\tnode\n\t[\n";
				lineOutput += "\t\tid ";
				lineOutput += i;
				lineOutput += "\n\t\tCategory ";
				if(i < 25){
					lineOutput += "\"culinary\"\n";
				}
				if(i >= 25 && i < 50){
					lineOutput += "\"educational\"\n";
				}
				if(i >= 50 && i < 75){
					lineOutput += "\"sports\"\n";
				}
				if(i >= 75 && i < 100){
					lineOutput += "\"video games\"\n";
				}
				if(i >= 100 && i < 125){
					lineOutput += "\"technology\"\n";
				}
				lineOutput += "\t]\n";
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

	//function to add ngrams to hashmap
	public static void addNGram(HashMap<String, Integer> map, String[] words, int n){
		String pattern = "";
      Integer count;
		if(words.length > n){
			for(int i = 0; i < words.length; i++){
				if(i+3 < words.length){
					pattern += words[i] + " " + words[i+1] + " " + words[i+2];
						//gets count of word in map
            		count = map.get(pattern);
            
            		//if word doesn't exist then add it to the table
            		if(count == null){
            			map.put(pattern, 1);
            		}
            		//otherwise increment word occurrence
            		else{
            			map.put(pattern, count+1);
            		}
						pattern = "";
				}

			}
		}
	}


	//method to read in files and add to hashmaps
	public static void readFile(HashMap<String, Integer> nGramCount, HashMap<String, Integer> category, HashMap<String, Integer> subcategory, HashMap<String, Integer> videoMap, File videoFile){

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
			Scanner scan = new Scanner(videoFile);

			//looping through text files to read in comments
			while(scan.hasNextLine()){

				//reading in line
				record = scan.nextLine();
				//splitting comments into individual words
				words = record.split("\\s+");

				//looping through each word and storing them into the correct hashtables
					//add word to video table
				addNGram(videoMap, words, 3);
				//add word to subcategory
				addNGram(subcategory, words, 3);
				//adding words into culinary hashtable
				addNGram(category, words, 3);
				//adding words into wordCount hashtable
				addNGram(nGramCount, words, 3);

			}

		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}

	}

	public static void printHashMap(HashMap<String, Integer> map, String outputFile){


		//printing all values from map hashtable in descending order
		Map<String, Integer> sorted = map.entrySet()
							.stream()
							.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
							.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
                     
      BufferedWriter buffWrit = null;
      FileWriter fileWrit = null;

		try{

			//creates writer to write data to file
			fileWrit = new FileWriter(outputFile);
			buffWrit = new BufferedWriter(fileWrit);
			String lineOutput = "";

			for(String word : sorted.keySet()){
				lineOutput = word + ": " + map.get(word);
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