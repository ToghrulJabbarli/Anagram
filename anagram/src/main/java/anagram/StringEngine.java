package anagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


@Path("/")
public class StringEngine {
	
	// TASK 3
	public static ArrayList<String> printPermutationsIterative(String string){
		ArrayList<String> myList = new ArrayList<String>();
        int [] factorials = new int[string.length()+1];
        factorials[0] = 1;
        for (int i = 1; i<=string.length();i++) {
            factorials[i] = factorials[i-1] * i;
        }

        for (int i = 0; i < factorials[string.length()]; i++) {
            String onePermutation="";
            String temp = string;
            int positionCode = i;
            for (int position = string.length(); position > 0 ;position--){
                int selected = positionCode / factorials[position-1];
                onePermutation += temp.charAt(selected);
                positionCode = positionCode % factorials[position-1];
                temp = temp.substring(0,selected) + temp.substring(selected+1);
            }
            
            myList.add(onePermutation);
        }
        
        return myList;
    }
	
	
	
	// TASK 4 
    
    /* function to check whether two  
    strings are anagram of each other */
    static boolean areAnagram(String str1, String str2) 
    { 
        // Create two count arrays and initialize  all values as 0 
        
        int[] count = new int[256]; 
        int i; 
  
        // For each character in input strings,  
        // increment count in the corresponding  
        // count array 
        for (i = 0; i < str1.length() && i < str2.length(); i++) 
        { 
            count[str1.charAt(i)]++;
            count[str2.charAt(i)]--; 
        } 
  
        // If both strings are of different length.It return false Cause anagram words should have the same character length
       
        if (str1.length() != str2.length()) 
          return false; 
  
        // See if there is any non-zero value in  count array 
         
        for (i = 0; i < 256; i++) 
            if (count[i] != 0) 
                return false; 
         return true; 
    } 
  
    // This function prints all anagram pairs in a  TWO PARAMETERS   given array of string
    static boolean findAllAnagrams(String word,String arr[])  // word compare with - arr[0] , arr[1] ....etc. arr[n]
    { 
    	String result = null;
        for (int i = 0; i < arr.length; i++) 
            for (int j = i; j < arr.length; j++) 
                if (areAnagram(word, arr[j]))
                {
                	  
                	  result = word +  
                              " is anagram of " + arr[j];
                	  return true;
                }
                  System.out.print(result + "\n");
                  return false;
    }
    
    
    
 /*This function prints all anagram pairs in a  given array of strings         !
    
    ONE PARAMETER Please DON't USE IT!!!!!!!!!!!!!!!! CAUTION!!!!!!!!!!!!!!!!!!!!!!!!! rapidapi.com is not free.I have 2500 request at all after they will charge me :))
  
  */
    
    
 /*   static void findAllAnagramsWithOneParam(String word) throws IOException
    {
    	boolean STOP = false;
    	String result = null;
    	
    	while(STOP != true)
    	{
    		String init_word = word;
        	
        	OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
            	.url("https://wordsapiv1.p.rapidapi.com/words/" + word + "/typeOf")
            	.get()
            	.addHeader("x-rapidapi-host", "wordsapiv1.p.rapidapi.com")
            	.addHeader("x-rapidapi-key", "cbe662e753mshd5ccefb663caecdp1d53b0jsn720e019158cc")
            	.build();

            Response response = client.newCall(request).execute();
            
            
        	
        	

        	if(response.body().string() != null)
        	{
        		if (areAnagram(init_word, word))
                {
                	  
                	  result = init_word +  
                              " is anagram of " + word;
                	  
                	  STOP = true;
                }
        	}
                    
                   
    	}
    	
    	   System.out.print(result + "\n");
    	
    }
  
   */
	
    // CALL BY LINK :
    @Path("findanagram")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getAnagram( @QueryParam("mixed") String mixed , @QueryParam("actual") String actual) throws IOException
    {
    	String res = AnagramCalling(mixed,actual);
    	return res;
    }
    
    @Path("findPermut")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getAnagram( @QueryParam("word") String word) throws IOException
    {
    	ArrayList<String> perums = printPermutationsIterative(word);
    	String res = "";
    	for(int i = 0; i < perums.size(); i++)
    	{
    		res = res + perums.get(i) + "\n\n";
    	}
    	return res;
    }
    
    public static String AnagramCalling(String string1, String string2) throws IOException
    {
    	
    		
    		
               OkHttpClient client = new OkHttpClient();

               Request request = new Request.Builder()
               	.url("https://wordsapiv1.p.rapidapi.com/words/" + string2 + "/typeOf")
               	.get()
               	.addHeader("x-rapidapi-host", "wordsapiv1.p.rapidapi.com")
               	.addHeader("x-rapidapi-key", "cbe662e753mshd5ccefb663caecdp1d53b0jsn720e019158cc")
               	.build();

               Response response = client.newCall(request).execute();
             
               
            String[] word1 = response.body().string().split(",");
       		String[] word2 = word1[0].split(":");
       		String[] word3 = word2[1].split("\"");
       		
       		   String arr[] = {word3[1], 
                    "Apple", "Life", "Mountains"  ,
                    "Weather","Bottle","Pen","Car"}; 
               
       		
              boolean isAnagram =  findAllAnagrams(string1,arr);  
               
               String meaning = "";
               for(int i = 1; i < word1.length; i++)
               {
            	   meaning = meaning + word1[i];
               }
               
               if(isAnagram)
               {
                   return "Word " + string2 + " is anagram of " + string1 + "\n\n<br></br>" +  word3[1] + "\n" + meaning + "]";

               }else
               {
                   return "Word " + string2 + " is not anagram of " + string1 + "\n\n<br></br>";

               }
            			   

               
    }
	
	public static void main(String[] args) throws IOException, NoSuchFieldException, SecurityException
	{	      
		//All permutations of string
    	//System.out.println(printPermutationsIterative("Toghrul"));
		
		
		String res = AnagramCalling("olve","love");
		System.out.print(res);
		
	
	}
}

