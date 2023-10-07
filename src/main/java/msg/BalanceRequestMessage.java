package msg;

public class BalanceRequestMessage {
    private Integer customerId;
    private String userName;

    public BalanceRequestMessage(Integer customerId, String userName) {
        this.customerId = customerId;
        this.userName = userName;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
