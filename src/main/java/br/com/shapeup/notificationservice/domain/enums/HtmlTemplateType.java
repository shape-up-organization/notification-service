package br.com.shapeup.notificationservice.domain.enums;

public enum HtmlTemplateType {

    CONFIRM_EMAIL_CODE_VERIFICATION("email-code-verification"),
    RESET_PASSWORD_CODE_VERIFICATION("reset-password-code-verification");

    private final String value;

    HtmlTemplateType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
