package com.gui;

import javax.swing.*;

import java.util.Random;

public class Main {
    private int rightAnswer = 0;
    private int round = 0;
    private int score = 0;
    private final int questionsCount = 5;
    private final Random random = new Random();
    private final QuizQuestion[] quizQuestions = new QuizQuestion[questionsCount];
    private JButton checkAnswerBtn;
    private JPanel panel;
    private JLabel questionLabel;
    private JTextField input;
    private JRadioButton RBSub;
    private JRadioButton RBDiv;
    private JRadioButton RBAdd;
    private JRadioButton RBMMulti;
    private JRadioButton RBEasy;
    private JRadioButton RBMedium;
    private JRadioButton RBHard;
    private final String[] rightAnswers = {
            "Sehr gut gemacht!",
            "Weiter so!",
            "Prima!",
            "Du bist ein GENIUS",
            "Du bist die Definition eines Lachsnackens!"
    };

    private final String[] wrongAnswers = {
            "Viel lernen du noch musst",
            "Das war falsch!",
            "Sehr sehr schwache leistung",
            "Das wird schon noch, irgendwann.",
            "Du bist es nicht würdig ein Lachsnacken zu sein!"
    };
    public Main() {
        ButtonGroup operands = new ButtonGroup();
        ButtonGroup level = new ButtonGroup();
        level.add(RBEasy);
        level.add(RBMedium);
        level.add(RBHard);
        operands.add(RBAdd);
        operands.add(RBMMulti);
        operands.add(RBSub);
        operands.add(RBDiv);

        
        checkAnswerBtn.addActionListener(e -> {
            boolean isAnswerRight = quizQuestions[rightAnswer].isAnswerRight(Integer.parseInt(input.getText()));
            int randomAnswer = random.nextInt((5 - 1) + 1) + 1;

            if (isAnswerRight) {
                JOptionPane.showMessageDialog(null, rightAnswers[randomAnswer - 1]);
                hasChoseRight();
                round++;
                score++;
            }
            else {
                JOptionPane.showMessageDialog(null, wrongAnswers[randomAnswer - 1]);
                round++;
            }
            if (round<questionsCount) {
                setQuestionLabel();
            }
            if (round==questionsCount) {
                JOptionPane.showMessageDialog(null,"Du hast " + score + " richtig geamcht", "Du bist fertig!",JOptionPane.PLAIN_MESSAGE);
                System.exit(1);
            }
            System.out.println(round + "/" + questionsCount + " :: " + score);
        });

        RBAdd.addActionListener(e -> generateQuestions('+'));
        RBMMulti.addActionListener(e -> generateQuestions('*'));
        RBSub.addActionListener(e -> generateQuestions('-'));
        RBDiv.addActionListener(e -> generateQuestions('/'));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MatheQuizGUI");
        frame.setContentPane(new Main().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public int getRandomNumber(int i) {
        if (RBEasy.isSelected()) {
            return (int)(10 * Math.random()) +1;
        }
        if (RBMedium.isSelected()){
            return (int)(80 * Math.random()) +1;
        }
        if (RBHard.isSelected()){
            return (int)(200 * Math.random()) +1;
        }
        return getRandomNumber(i);
    }

    public void hasChoseRight() {
        rightAnswer++;
    }

    public void setQuestionLabel() {
        questionLabel.setText("Was ergibt " + quizQuestions[rightAnswer].getNumbers()[0] + " " + quizQuestions[rightAnswer].getOperand() + " " + quizQuestions[rightAnswer].getNumbers()[1] + "?");
    }

    public void generateQuestions(char operand) {
        for (int i = 0; i < questionsCount; i++) {
            QuizQuestion quizQuestion = new QuizQuestion(getRandomNumber((int) (50 * Math.random()) + 1), getRandomNumber((int) (50 * Math.random()) + 1), operand);
            quizQuestions[i] = quizQuestion;
        }

        setQuestionLabel();
        checkAnswerBtn.setEnabled(true);
    }
}