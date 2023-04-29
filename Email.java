package TaskWorkStream7;

public class Email implements IEmail {
    private boolean isAccept;
    private String email;

    public Email() {
    }

    public Email(boolean consentNotification, String email) {
        this.isAccept = consentNotification;
        this.email = email;
    }

    @Override
    public boolean isAccept() {
        return isAccept;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setAccept(boolean accept) {
        this.isAccept = accept;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return " Email " + isAccept + ", " + email;
    }
}