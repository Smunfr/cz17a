package com.example.cz17a.quizclient;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by stein on 17.01.2018.
 * Edited by gerbert on 18.01.2018
 */

public class ServerCommunication {

        private String url_root = null;
        private String url_quiz = null;
        private String url_quest = null;
        private String url_answer = null;
        private String nudes = null;


    public JSONObject getQuizType() {
        String quizType = null;
        try {
            if(url_quiz != null && url_root != null) {
                URL url = new URL(url_root + url_quiz);
                HttpURLConnection connect = (HttpURLConnection) url.openConnection();
                connect.setRequestMethod("GET"); //throws ProtocolException
                connect.connect();

                if (connect.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code: " + connect.getResponseCode());
                }

                BufferedReader cIn = new BufferedReader(new InputStreamReader(connect.getInputStream()));
                while (cIn.readLine() != null) {
                    quizType += cIn;
                }

                connect.disconnect();

            }else{
                System.out.println("URL nicht gesetzt");
                return null;
            }
        } catch (IOException e) {

        }
        JSONObject jType = null;
        try {
            jType = new JSONObject(quizType);
        } catch (JSONException j) {
            System.out.println("invalid Data");
        }
        return jType;
    }

    public JSONObject getQuestions() {
        String quest = null;
        try {
            if(url_quest != null && url_root != null) {
                URL url = new URL(url_root + url_quest);
                HttpURLConnection connect = (HttpURLConnection) url.openConnection();
                connect.setRequestMethod("GET"); //throws ProtocolException
                connect.connect();

                if (connect.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code: " + connect.getResponseCode());
                }

                BufferedReader cIn = new BufferedReader(new InputStreamReader(connect.getInputStream()));
                while (cIn.readLine() != null) {
                    quest += cIn;
                }

                connect.disconnect();

            }else{
                System.out.println("URL nicht gesetzt");
                return null;
            }
        } catch (IOException e) {

        }
        JSONObject jType = null;
        try {
            jType = new JSONObject(quest);
        } catch (JSONException j) {
            System.out.println("invalid Data");
        }
        return jType;
    }

    public JSONObject getAnswers() {
        String answer = null;
        try {
            if(url_quest != null && url_root != null) {
                URL url = new URL(url_root + url_answer);
                HttpURLConnection connect = (HttpURLConnection) url.openConnection();
                connect.setRequestMethod("GET"); //throws ProtocolException
                connect.connect();

                if (connect.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code: " + connect.getResponseCode());
                }

                BufferedReader cIn = new BufferedReader(new InputStreamReader(connect.getInputStream()));
                while (cIn.readLine() != null) {
                    answer += cIn;
                }

                connect.disconnect();

            }else{
                System.out.println("URL nicht gesetzt");
                return null;
            }
        } catch (IOException e) {

        }
        JSONObject jType = null;
        try {
            jType = new JSONObject(answer);
        } catch (JSONException j) {
            System.out.println("invalid Data");
        }
        return jType;
    }

    public void sendNudes(){
        try{
            if(url_root != null && nudes != null){
                URL url = new URL(url_root + nudes);
                HttpURLConnection connect = (HttpURLConnection) url.openConnection();
                connect.setRequestMethod("POST"); //throws ProtocolException
                connect.connect();
    //            BufferedOutputStream usr_answer = new OutputStream(usr.getanswer()); //antwort des Users
                connect.disconnect();
            }else{
                System.out.println("URL nicht gesetzt");
                return;
            }
        }catch(IOException e){

        }
    }



    //dummi
   public String[] getTopicTitles(){
        String[] titles = new String[3];
        titles[0] = "Topic 0";
        titles[1] = "Topic 1";
        titles[2] = "Topic 2";
        return titles;

    }
    public int[] getTopicIDs(){
        int[] IDs = new int[3];
        for (int i = 0; i<3;i++){
            IDs[i] = i;
        }
        return IDs;
    }

    //todo getQuiz, getQuest, getAnswer?, giveAnswer



}