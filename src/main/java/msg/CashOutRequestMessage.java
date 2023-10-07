package msg;

public class CashOutRequestMessage {
    private Integer customerId;
    private Integer amount;

    public CashOutRequestMessage(Integer customerId, Integer amount) {
        this.customerId = customerId;
        this.amount = amount;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
