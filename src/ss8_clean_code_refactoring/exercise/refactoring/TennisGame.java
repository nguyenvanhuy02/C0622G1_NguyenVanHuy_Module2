package ss8_clean_code_refactoring.exercise.refactoring;


public class TennisGame {
    private static final int SCORE_0 = 0;
    private static final int SCORE_1 = 1;
    private static final int SCORE_2 = 2;
    private static final int SCORE_3 = 3;

    public static String getScore(int firstScorePlayer, int secondScorePlayer) {
        String score = "";
        int tempScore;
        if (firstScorePlayer == secondScorePlayer) {
            switch (firstScorePlayer) {
                case SCORE_0:
                    score = "Love-All";
                    break;
                case SCORE_1:
                    score = "Fifteen-All";
                    break;
                case SCORE_2:
                    score = "Thirty-All";
                    break;
                case SCORE_3:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        } else if (firstScorePlayer >= 4 || secondScorePlayer >= 4) {
            int minusResult = firstScorePlayer - secondScorePlayer;
            if (minusResult == 1)
                score = "Advantage player1";
            else if (minusResult == -1)
                score = "Advantage player2";
            else if (minusResult >= 2)
                score = "Win for player1";
            else
                score = "Win for player2";
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1)
                    tempScore = firstScorePlayer;
                else {
                    score += "-";
                    tempScore = secondScorePlayer;
                }
                switch (tempScore) {
                    case SCORE_0:
                        score += "Love";
                        break;
                    case SCORE_1:
                        score += "Fifteen";
                        break;
                    case SCORE_2:
                        score += "Thirty";
                        break;
                    case SCORE_3:
                        score += "Forty";
                        break;
                }
            }
        }
        return score;
    }
}