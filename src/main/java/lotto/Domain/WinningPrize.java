package lotto.Domain;

public enum WinningPrize {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NONE(0, false, 0);

    private final int correctCount;
    private final boolean bonusNumber;
    private final int prize;

    WinningPrize(int correctCount, boolean bonusNumber, int prize) {
        this.correctCount = correctCount;
        this.bonusNumber = bonusNumber;
        this.prize = prize;
    }

    public static WinningPrize of(int correctNumberCount, boolean bonusNumberCorrect) {
        if (correctNumberCount == 6) {
            return FIRST;
        }
        if (correctNumberCount == 5 && bonusNumberCorrect) {
            return SECOND;
        }
        if (correctNumberCount == 5) {
            return THIRD;
        }
        if (correctNumberCount == 4) {
            return FOURTH;
        }
        if (correctNumberCount == 3) {
            return FIFTH;
        }
        return NONE;
    }

    public int getPrize() {
        return prize;
    }
}