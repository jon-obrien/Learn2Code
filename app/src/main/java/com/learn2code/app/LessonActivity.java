package com.learn2code.app;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.learn2code.app.data.repository.AppRepository;

public class LessonActivity extends BaseActivity {
    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private TextView questionTextView;
    private TextView questionCodeView;
    private Button answer1Button;
    private Button answer2Button;
    private Button answer3Button;
    private Button answer4Button;
    private TextView scoreTextView;
    private Spinner languageSpinner;
    private long topicId;
    private String[] languages = {"Java", "Python", "C"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        topicId = getIntent().getLongExtra("TOPIC_ID", -1);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getIntent().getStringExtra("TOPIC_NAME"));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        questionTextView = findViewById(R.id.questionTextView);
        questionCodeView = findViewById(R.id.questionCodeView);
        answer1Button = findViewById(R.id.answer1Button);
        answer2Button = findViewById(R.id.answer2Button);
        answer3Button = findViewById(R.id.answer3Button);
        answer4Button = findViewById(R.id.answer4Button);
        scoreTextView = findViewById(R.id.scoreTextView);
        languageSpinner = findViewById(R.id.languageSpinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, languages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapter);

        String savedLanguage = getPrefsHelper().getProgrammingLanguage();
        int savedIndex = java.util.Arrays.asList(languages).indexOf(savedLanguage);
        languageSpinner.setSelection(savedIndex);

        languageSpinner.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(android.widget.AdapterView<?> parent, android.view.View view, int position, long id) {
                String selectedLanguage = languages[position];
                getPrefsHelper().setProgrammingLanguage(selectedLanguage);
                reloadQuestions(selectedLanguage);
            }

            @Override
            public void onNothingSelected(android.widget.AdapterView<?> parent) {
            }
        });

        loadQuestions(savedLanguage);

        View.OnClickListener answerClickListener = v -> {
            Button clickedButton = (Button) v;
            checkAnswer(clickedButton.getText().toString());
        };

        answer1Button.setOnClickListener(answerClickListener);
        answer2Button.setOnClickListener(answerClickListener);
        answer3Button.setOnClickListener(answerClickListener);
        answer4Button.setOnClickListener(answerClickListener);
    }

    private void loadQuestions(String language) {
        questions = AppRepository.getInstance(this).getQuestionsForTopicAndLanguage(topicId, language);
        currentQuestionIndex = 0;
        score = 0;

        if (!questions.isEmpty()) {
            displayQuestion(currentQuestionIndex);
        } else {
            Toast.makeText(this, R.string.no_questions, Toast.LENGTH_LONG).show();
            finish();
        }
    }

    private void reloadQuestions(String language) {
        questions = AppRepository.getInstance(this).getQuestionsForTopicAndLanguage(topicId, language);
        currentQuestionIndex = 0;
        score = 0;

        if (!questions.isEmpty()) {
            displayQuestion(currentQuestionIndex);
        } else {
            questionTextView.setText(R.string.no_questions);
            questionCodeView.setVisibility(View.GONE);
            answer1Button.setVisibility(View.INVISIBLE);
            answer2Button.setVisibility(View.INVISIBLE);
            answer3Button.setVisibility(View.INVISIBLE);
            answer4Button.setVisibility(View.INVISIBLE);
        }
    }

    private void displayQuestion(int index) {
        if (index < questions.size()) {
            Question question = questions.get(index);
            questionTextView.setText(question.getQuestionText());
            
            if (question.getQuestionCode() != null && !question.getQuestionCode().isEmpty()) {
                questionCodeView.setText(question.getQuestionCode());
                questionCodeView.setVisibility(View.VISIBLE);
            } else {
                questionCodeView.setVisibility(View.GONE);
            }

            List<String> answers = new ArrayList<>();
            answers.add(question.getCorrectAnswer());
            answers.add(question.getWrongAnswer1());
            answers.add(question.getWrongAnswer2());
            answers.add(question.getWrongAnswer3());
            Collections.shuffle(answers);

            answer1Button.setText(answers.get(0));
            answer2Button.setText(answers.get(1));
            answer3Button.setText(answers.get(2));
            answer4Button.setText(answers.get(3));

            String scoreText = getString(R.string.score_0_0);
            scoreTextView.setText(String.format(scoreText, score, questions.size()));
        } else {
            showFinalScore();
        }
    }

    private void checkAnswer(String selectedAnswer) {
        Question currentQuestion = questions.get(currentQuestionIndex);
        if (selectedAnswer.equals(currentQuestion.getCorrectAnswer())) {
            score++;
            Toast.makeText(this, R.string.correct_answer, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.incorrect_answer, Toast.LENGTH_SHORT).show();
        }

        currentQuestionIndex++;
        if (currentQuestionIndex < questions.size()) {
            displayQuestion(currentQuestionIndex);
        } else {
            showFinalScore();
        }
    }

    private void showFinalScore() {
        AppRepository.getInstance(this).insertQuizScore(topicId, score);

        Toast.makeText(this, "Quiz completed! Your score: " + score, Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}