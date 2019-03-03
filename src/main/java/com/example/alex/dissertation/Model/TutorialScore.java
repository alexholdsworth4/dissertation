package com.example.alex.dissertation.Model;

public class TutorialScore {
    private String Tutorial_Score;
    private String User;
    private String Score;
    private String WalkthroughId;
    private String WalkthroughName;

    public TutorialScore() {
    }

    public TutorialScore(String tutorial_Score, String user, String score, String walkthroughId, String walkthroughName) {
        Tutorial_Score = tutorial_Score;
        User = user;
        Score = score;
        WalkthroughId = walkthroughId;
        WalkthroughName = walkthroughName;
    }

    public String getTutorial_Score() {
        return Tutorial_Score;
    }

    public void setTutorial_Score(String tutorial_Score) {
        Tutorial_Score = tutorial_Score;
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

    public String getWalkthroughId() {
        return WalkthroughId;
    }

    public void setWalkthroughId(String walkthroughId) {
        WalkthroughId = walkthroughId;
    }

    public String getWalkthroughName() {
        return WalkthroughName;
    }

    public void setWalkthroughName(String walkthroughName) {
        WalkthroughName = walkthroughName;
    }
}
