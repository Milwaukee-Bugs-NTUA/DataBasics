package gr.ntua.ece.databases.data.model;

public class UsersParentalTransactions {

    private Float percentageOfParents;
    private Float percentageOfNonParents;

    public UsersParentalTransactions(){

    }

    public Float getPercentageOfParents() {
        return percentageOfParents;
    }

    public void setPercentageOfParents(Float percentP){
        this.percentageOfParents = percentP;
    }

    public Float getPercentageOfNonParents() {
        return percentageOfNonParents;
    }

    public void setPercentageOfNonParents(Float percentNP){
        this.percentageOfNonParents = percentNP;
    }
    
    
}