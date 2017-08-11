package com.epam.bigdata.string_task;
import java.util.*;

public class TextParser {
	
	private String[] arrayOfSentences;
	private String inputText;
	
	public TextParser(String inputText) {
		this.inputText = inputText;
	}

	
	public void textToSentences() {
		System.out.println("==============================");
		System.out.println("Sentence split text:");
		arrayOfSentences = inputText.split("(?<=[.?!])\\s+(?=[a-zA-Z])");					
		for(String str : arrayOfSentences) {							
			System.out.println(str);
		}
	}
	
	public void wordsCount() {
		System.out.println("\n==============================");
		System.out.println("Counting words (lowercased):");
		
		Map<String, Integer> map = new LinkedHashMap<>();
		String[] arrayOfWords = inputText.replace(".", "").replace(",", "").replace("\"", "").replace("\'", "")
				.replace("?", "").replace("!","").replace(":","").replace(";","").toLowerCase().split(" ");
		
		for(String word : arrayOfWords){
			if((map.get(word)) == null){
				map.put(word, 1);
			}else{
				map.put(word, map.get(word)+1);
			}
		} 
		
		for (Map.Entry<String, Integer> entry : map.entrySet())
		{
		    System.out.printf("|"+entry.getKey() + " - " + entry.getValue() + "| ");
		}
		
		
		for (Map.Entry<String, Integer> entry : map.entrySet())
		{
		  if(entry.getValue().equals(1)) {
			  System.out.println("\nFirst unique word is: " + entry.getKey() + "\n");
			  break;
		  }
		}
	}
	
	
	public void shortWordsReplacement() {	 
		System.out.println("==============================");
		System.out.println("Shortest words replacement:");		
		for (String sentence: arrayOfSentences){
			List<String> sw = new ArrayList<>();
	        String lw="";
	        int s=sentence.length(), l=0;
	        String words[]=sentence.replace(",", "").split(" ");
	        for(String word:words)
	        {
	        	if(word.length() <= s)
	            {	                	
	        		sw.add(word);
	                s = word.length();          
	            }
	            if(word.length()>l)
	            {
	            	lw=word;
	                l = word.length();
	            }
	            
	            if(sw.get(sw.size()-1).length() < sw.get(0).length()) {
	            	sw.remove(0);
	            }                		
	        }
	        for(String shortest: sw) {
	        	 sentence = sentence.replaceAll("\\b"+shortest+"\\b", "{"+lw+"}");
	        }
	       
	        System.out.println("\nLONGEST WORD : "+lw);
	        System.out.println("SHORTEST WORD : "+sw);
	        System.out.println(sentence);
		}
	}
}