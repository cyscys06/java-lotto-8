package lotto.Domain;

public enum LottoInfo {
    LOTTONUMBER_MIN(1),
    LOTTONUMBER_MAX(45),
    LOTTONUMBER_COUNT(6),
    UNIT(1000);
    private final int info;

    LottoInfo(int info) {
        this.info = info;
    }

    public int getInfo() {
        return info;
    }
}
