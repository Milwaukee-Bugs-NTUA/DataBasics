package gr.ntua.ece.databases.data.model;

public class UsersMaritalTransactions {

    private Float percentageOfMarried;
    private Float percentageOfDivorced;
    private Float percentageOfSingle;
    private Float percentageOfInRelationship;

    public UsersMaritalTransactions(){

    }

    public Float getpercentageOfMarried() {
        return percentageOfMarried;
    }

    public void setpercentageOfMarried(Float percentM){
        this.percentageOfMarried = percentM;
    }

    public Float getpercentageOfDivorced() {
        return percentageOfDivorced;
    }

    public void setpercentageOfDivorced(Float percentD){
        this.percentageOfDivorced = percentD;
    }

    public Float getpercentageOfSingle() {
        return percentageOfSingle;
    }

    public void setpercentageOfSingle(Float percentS){
        this.percentageOfSingle = percentS;
    }

    public Float getpercentageOfInRelationship() {
        return percentageOfInRelationship;
    }

    public void setpercentageOfInRelationship(Float percentR){
        this.percentageOfInRelationship = percentR;
    }
    
}