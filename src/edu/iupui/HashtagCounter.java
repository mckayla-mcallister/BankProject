package edu.iupui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author micky
 */
public class HashtagCounter {
     private String tweetText;
     public HashtagCounter(String tweetText) {
         this.tweetText = tweetText;
     }    
     public int countNumberSigns() {
         int count = 0;
             
for (int i = 0; i < tweetText.length(); i++) {            
    if (tweetText.charAt(i) == '#') {                
        count++;            
    }        
}        
return count;    
}    
        public int countHashtags() {
        int count = 0;
        for (int i = 0; i < tweetText.length(); i++) {
        if (tweetText.charAt(i) == '#' && i != tweetText.length() - 1) { 
              
        if (tweetText.charAt(i+1) != ' ') {                   
        if (i == 0) {                        
        count++;                    
        } else {                        
        if (tweetText.charAt(i-1) == ' ') { // follows a space                           
        count++;
        }                    
        }                
        }            
        }        
        }
     return count;
}}

