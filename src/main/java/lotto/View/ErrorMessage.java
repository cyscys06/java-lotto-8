package lotto.View;

public enum ErrorMessage {
    ERROR("[ERROR] "),
    EMPTYINPUT("빈 문자열을 입력할 수 없습니다."),
    NOTNUMBER("입력값에 숫자나 구분자 이외의 문자를 입력할 수 없습니다."),
    NEGATIVE("양수만 입력할 수 있습니다."),
    NOTUNIT("구매 금액은 1천원 단위로 입력해야 합니다."),
    NOTUNIQUE("중복 번호를 입력할 수 없습니다."),
    NOTINRANGE("1~45 사이의 숫자만 입력해야 합니다."),
    NOTPROPERCOUNT("로또 번호는 6개여야 합니다."),
    REQUESTAGAIN("다시 입력해 주십시오.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
