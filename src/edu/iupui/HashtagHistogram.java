/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iupui;


/**
 *
 * @author micky
 */
public class HashtagHistogram {
    public String[] normalizedTweets;
    public String tweetText;
    public int[] values;
    public HashtagHistogram(String[] tweets){
        this.normalizedTweets = normalizedTweets;}

    private void buildHistogram(){
        HashtagCounter hashtagCounter;
        hashtagCounter = new HashtagCounter(tweetText);
        int[] values = new int[9];
        
        for (int i = 0; i < normalizedTweets.length; i++){
        tweetText = normalizedTweets[i];
        int y = hashtagCounter.countHashtags();
        values[y] = values[y] + 1;}    
}
    public void printHistogram(){
        for(int x = 0; x <= 8; x++)
            System.out.println("There is/are " + values[x] + " tweets that have " + x + " hashtags.");
        
            
    }
        
    }
            

