/*
 * To change this license header, userChoose License Headers in Project Properties.
 * To change this template file, userChoose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duchi
 */
public class Test implements Runnable {

    private Question[] questions;
    private int time;//secound
    private double score;
    private Set<Integer> userChoose = new HashSet<>();

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Test(int numq, HashMap<Integer, Question> data) {
        this.questions = new Question[numq];
        createdTestData(numq, data);
        this.time = 60 * numq;
        Thread thread = new Thread(this);
        thread.start();
    }

    private void createdTestData(int numq, HashMap<Integer, Question> data) {
        Random random = new Random();
        int index = 0;
        Set<Integer> hadGet = new HashSet<>();
        while (index < numq) {
            int q = random.nextInt(numq);
            if (!hadGet.contains(q)) {
                hadGet.add(q);
                questions[index] = data.get(q + 1);

                index++;
            }
        }
    }

    public Set<Integer> getUserChoose() {
        return userChoose;
    }

    public void setUserChoose(Set<Integer> userChoose) {
        this.userChoose = userChoose;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public double getScore() {
        double allCorrect = questions.length;
        double userCorrect = 0;
        for (Question question : questions) {
            boolean isTrueAns = true;
            for (Answer answer : question.getAnswers()) {
                if ((answer.isIsTrue()) && (!userChoose.contains(answer.getId()))) {
                    isTrueAns = false;
                }
                if ((!answer.isIsTrue()) && (userChoose.contains(answer.getId()))) {
                    isTrueAns = false;
                }

            }
            if (isTrueAns) {
                userCorrect++;
            }
        }
        time = 0;
        System.out.println(allCorrect + " " + userCorrect + " " + ((userCorrect / allCorrect) * 10));
        return score = ((double)Math.round(((userCorrect / allCorrect) * 10) * 100) / 100);
    }

    @Override
    public void run() {
        while (time > 0) {
            try {
                time = time - 1;

                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
