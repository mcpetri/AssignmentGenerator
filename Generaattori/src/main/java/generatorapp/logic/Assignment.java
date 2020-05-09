/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatorapp.logic;

import java.util.Random;

/**
 *
 * @author petri
 */
public class Assignment {
    private static final int NUMBEROFFACTORS = 4;
    int variation = 10;
    Calculator calculator = new Calculator();
    Random rand = new Random();
    int difficulty = 1;
    String expression;
    double answer;
    /**
     * Luo lausekkeen määritellylä määrällä tekijöitä ja määritelyllä
     * tekijävaihtelulla sekä annetulla merkillä
     * 
     * @param character kutsujan määrittämä merkki, jolle luodaan tehtävä, voi olla +,-,*,/,random
     * 
     * @return vastaus luotuun tehtävään
     */
    public double createAssignment(final String character) {
        answer = 0;
        int number1 = rand.nextInt(variation) + 1;
        int number2 = rand.nextInt(variation) + 1;
        int number3 = rand.nextInt(variation) + 1;
        int number4 = rand.nextInt(variation) + 1;
        int number5 = rand.nextInt(variation) + 1;
        int[] numbers = new int[5];
        numbers[0] = number2; 
        numbers[1] = number1; //Helpompi tehdä 5 lukua suoraan kuin
        numbers[2] = number3; //luoda dynaamisesti enemmän lukuja
        numbers[3] = number4;
        numbers[4] = number5;
        String tempExpression = "";
        for (int i = 0; i <= difficulty; i++) {
            tempExpression += String.valueOf(numbers[i]);
            if (i == difficulty) {
                break;
            }
            if (character.equals("+")) {
                tempExpression += "+";
            }
            if (character.equals("-")) {
                tempExpression += "-";
            }
            if (character.equals("*")) {
                tempExpression += "*";
            }
            if (character.equals(":")) {
                tempExpression += "/";
            }
            if (character.equals("random")) {
                int randomizer = rand.nextInt(NUMBEROFFACTORS) + 1;
                if (randomizer == 1) {
                    tempExpression += "+";
                }
                if (randomizer == 2) {
                    tempExpression += "-";
                }
                if (randomizer == 3) {
                    tempExpression += "*";
                }
                if (randomizer == 4) {
                    tempExpression += "/";
                }
            }
        }
        expression = "Ratkaise x, kun \nx = " + tempExpression;
        answer = calculator.count(tempExpression);
        return answer;
    }
    /**
    *@return double nykyisen tehtävän vastaus
    */
    public double getAnswer() {
        return answer;
    }
    /**
     * @return String nykyisen tehtävän lauseke
     */
    public String getExpression() {
        return expression;
    }
    /**
     * Pyöristää nykyisen tehtävän vastauksen sadasosiin ja vertaa ehdotettua vastausta oikeaan
     * 
     * @param proposedAnswer ehdotettu vastaus nykyiseen tehtävään
     * @return true jos vastaus oikein false jos ei
     */
    public boolean check(String proposedAnswer) {
        double parse = Double.parseDouble(proposedAnswer);
        double roundedAnswer = Math.round(answer * 100.0) / 100.0;
        return parse == roundedAnswer;
    }
    /**
     * Asettaa uuden tekijöiden määrän 1=2 tekijää, 2=3 tekijää yms MAX 4
     * @param newDifficulty 
     */
    public void setDifficulty(int newDifficulty) {
        this.difficulty = newDifficulty;
    }
    /**
     * Asettaa uuden vaihtelun tekijöille, min 1, max newVariation
     * @param newVariation 
     */
    public void setVariation(int newVariation) {
        this.variation = newVariation;
    }
    /**
     * Palauttaa tekijöiden vaihtelun
     * @return 
     */
    public int getVariation() {
        return this.variation;
    }
    /**
     * Palauttaa tekijöiden lkm
     * @return 
     */
    public int getDifficulty() {
        return this.difficulty;
    }
}
