package lotto.Domain;

public enum WinningPrize {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
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