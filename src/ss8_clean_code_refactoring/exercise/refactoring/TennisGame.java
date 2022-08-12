package ss8_clean_code_refactoring.exercise.refactoring;


public class TennisGame {
    private static final int SCORE_0 = 0;
    private static final int SCORE_1 = 1;
    private static final int SCORE_2 = 2;
    private static final int SCORE_3 = 3;

    public static void getScore(int firstScorePlayer, int secondScorePlayer) {
        String score = "";
        if (firstScorePlayer == secondScorePlayer) {
            System.out.println(draw(firstScorePlayer));
        } else if (firstScorePlayer >= 4 || secondScorePlayer >= 4) {
            System.out.println(playWin(firstScorePlayer,secondScorePlayer));
        } else {
            System.out.println(playWin2(firstScorePlayer,secondScorePlayer));
        }
    }
    public static String draw(int firstScorePlayer){
        switch (firstScorePlayer) {
            case SCORE_0:
                return  "Love-All";
            case SCORE_1:
                return  "Fifteen-All";
            case SCORE_2:
                return  "Thirty-All";
            case SCORE_3:
                return  "Forty-All";
            default:
                return  "Deuce";

        }
    }

    public static String playWin(int firstScorePlayer, int secondScorePlayer){
        int minusResult = firstScorePlayer - secondScorePlayer;
        if (minusResult == 1)
           return  "Advantage player1";
        else if (minusResult == -1)
            return  "Advantage player2";
        else if (minusResult >= 2)
            return  "Win for player1";
        else
            return  "Win for player2";
    }

    public static String playWin2(int firstScorePlayer, int secondScorePlayer) {
        String score = "";
        int tempScore;
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
        return score;

    }

}