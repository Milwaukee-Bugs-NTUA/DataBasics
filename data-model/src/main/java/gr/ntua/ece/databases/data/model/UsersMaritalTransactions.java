package gr.ntua.ece.databases.data.model;

public class UsersMaritalTransactions {

    private Float percentage;
    private String maritalStatus;

    public UsersMaritalTransactions(){

    }

    public Float getPercentage() {
        return percentage;
    }
    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }
    public String getMaritalStatus() {
        return maritalStatus;
    }
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
    
}