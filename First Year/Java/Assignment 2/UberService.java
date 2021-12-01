/* Richmond Arthur
 ARTRIC001
 06 August 2018
 Program to create a UberService class uses default constructor */
 
public class UberService
{
    public String name;
    public int costPerMin;
    public int costPerKM;
    public int baseFee;
    int cancellationFee;
    
    public void setDetails(String name,int costperminute,int costperkilometre,int basefee,int cancellationfee){
        this.name = name;
        costPerMin = costperminute;
        costPerKM = costperkilometre;
        baseFee = basefee;
        cancellationFee = cancellationfee;
    }
    public void setName(String x) {
        name = x;
    }
    
    public String getName() {
        return name;
    }
    
    public void setCostPerMinute(int y) {
        costPerMin = y;
    }
    
    public int getCostPerMinute() {
        return costPerMin;
    }
        
    public void setCostPerKilometre(int z) {
        costPerKM = z;
    }
    
    public int getCostPerKilometre() {
        return costPerKM;
    }
    
    public void setBaseFare(int cents) {
        baseFee = cents;
    }
    
    public int getBaseFare() {
        return baseFee;
    }
    
    public void setCancellationFee(int n) {
        cancellationFee = n;
    }
    
    public int getCancellationFee() {
        return cancellationFee;
    }
    
    public double calculateFare(double minutes, double distance) {
        double totalFare = baseFee + (costPerMin * minutes) + (costPerKM * distance);
        return totalFare;
    }
}   
