public class FinancialForecast {

    public static double futureValue(double initialValue, double rate, int years) {
        
        if (years == 0) {
            return initialValue;
        }
        return futureValue(initialValue, rate, years - 1) * (1 + rate);
    }

    public static void main(String[] args) {
        double initialValue = 10000;  
        double growthRate = 0.10;     
        int years = 5;                

        double futureVal = futureValue(initialValue, growthRate, years);
        System.out.printf("📈 Forecasted value after %d years: ₹%.2f\n", years, futureVal);
    }
}
