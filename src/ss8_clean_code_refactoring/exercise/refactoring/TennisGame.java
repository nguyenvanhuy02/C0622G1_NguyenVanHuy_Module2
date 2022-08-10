package ss8_clean_code_refactoring.exercise.refactoring;


public class TennisGame {

    public static String getScore(int firstScorePlayer, int secondScorePlayer) {
        StringBuilder score = new StringBuilder();
        int tempScore;
        if (firstScorePlayer == secondScorePlayer) {
            switch (firstScorePlayer) {
                case 0:
                    score = new StringBuilder("Love-All");
                    break;
                case 1:
                    score = new StringBuilder("Fifteen-All");
                    break;
                case 2:
                    score = new StringBuilder("Thirty-All");
                    break;
                case 3:
                    score = new StringBuilder("Forty-All");
                    break;
                default:
                    score = new StringBuilder("Deuce");
                    break;

            }
        } else if (firstScorePlayer >= 4 || secondScorePlayer >= 4) {
            int result = firstScorePlayer - secondScorePlayer;
            if (result == 1) score = new StringBuilder("Advantage player1");
            else if (result == -1) score = new StringBuilder("Advantage player2");
            else if (result >= 2) score = new StringBuilder("Win for player1");
            else score = new StringBuilder("Win for player2");
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = firstScorePlayer;
                else {
                    score.append("-");
                    tempScore = secondScorePlayer;
                }
                switch (tempScore) {
                    case 0:
                        score.append("Love");
                        break;
                    case 1:
                        score.append("Fifteen");
                        break;
                    case 2:
                        score.append("Thirty");
                        break;
                    case 3:
                        score.append("Forty");
                        break;
                }
            }
        }
        return score.toString();
    }
}
