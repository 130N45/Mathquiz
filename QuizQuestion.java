package com.gui;

public class QuizQuestion {
    private final int[] numbers = new int[2];
    private int answer;
    private final char operand;

    public QuizQuestion(int number1, int number2, char operand) {
        this.numbers[0] = number1;
        this.numbers[1] = number2;
        this.operand = operand;

        switch (operand) {
            case '+' -> this.answer = number1 + number2;
            case '-' -> this.answer = number1 - number2;
            case '*' -> this.answer = number1 * number2;
            case '/' -> this.answer = number1 / number2;
        }
    }

    public int[] getNumbers() {
        return this.numbers;
    }

    public char getOperand() {
        return this.operand;
    }

    public boolean isAnswerRight(int answer) {
        return this.answer == answer;
    }
}