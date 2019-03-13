package com.example.alex.dissertation.Model;

public class InteractiveScore {
    private String Interactive_Score;
    private String User;
    private String Score;
    private String LessonId;
    private String LessonName;

    public InteractiveScore() {
    }

    public InteractiveScore(String interactive_Score, String user, String score, String lessonId, String lessonName) {
        Interactive_Score = interactive_Score;
        User = user;
        Score = score;
        LessonId = lessonId;
        LessonName = lessonName;
    }

    public String getInteractive_Score() {
        return Interactive_Score;
    }

    public void setInteractive_Score(String interactive_Score) {
        Interactive_Score = interactive_Score;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getScore() {
        return Score;
    }

    public void setScore(String score) {
        Score = score;
    }

    public String getLessonId() {
        return LessonId;
    }

    public void setLessonId(String lessonId) {
        LessonId = lessonId;
    }

    public String getLessonName() {
        return LessonName;
    }

    public void setLessonName(String lessonName) {
        LessonName = lessonName;
    }
}
