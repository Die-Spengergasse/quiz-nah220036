package at.spengergasse;

import at.spengergasse.entities.Answer;
import at.spengergasse.entities.Question;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private List<Question> questions;
    private Scanner scanner = new Scanner(System.in);
    int nextQuestion = 0;

    public Quiz() {
        EntityManager em = Persistence.createEntityManagerFactory("demo").createEntityManager();
        TypedQuery<Question> query = em.createQuery("SELECT q FROM Question q ", Question.class);
        List<Question> questions = query.getResultList();

    }

    public void QuentionsAndAnswers() {
        Question q = questions.get(nextQuestion);
        System.out.println(q.getText());
        List<Answer> answers = q.getAnswerList();
        for (int i = 0; i < answers.size(); i++) {
            Answer a = answers.get(i);
            System.out.println(a.getText());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose a answer " + answers.size());
        int userChoice = scanner.nextInt() - 1; // Umwandlung in 0-basierten Index

        if (userChoice >= 0 && userChoice < answers.size()) {
            Answer selectedAnswer = answers.get(userChoice);
            if (selectedAnswer.isCorrect()) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        } else {
            throw new IllegalArgumentException();
        }

        // Nächste Frage
        nextQuestion++;
    }
}
