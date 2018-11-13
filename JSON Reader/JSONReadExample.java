import java.io.FileReader; 
import java.util.Iterator; 
import java.util.Map; 
  
import org.json.*; 
  
public class JSONReadExample  
{ 
    public static void main(String[] args) throws Exception  
    { 
      PrintWriter writer = new PrintWriter("read.txt");
        // parsing file "JSONExample.json" 
        Object obj = new JSONParser().parse(new FileReader("comments.json")); 
          
        // typecasting obj to JSONObject 
        JSONObject jo = (JSONObject) obj; 
        iterator itr = jo.iterator();
        while(itr.hasNext())
        {
        // getting firstName and lastName 
        String comment = (String) jo.get("commentText"); 
        
        writer.println(comment);
        }
    } 
} 