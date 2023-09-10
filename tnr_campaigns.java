package straycare_resource_optimiser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
5
A 500 12 0
B 1000 50 2
C 3000 130 5
D 200 5 0
E 5000 143 1
 */

//COLONY
class Colony
{
    private String name;
    private int residentPopulation;
    private int strayDogPopulation;
    private int incidentReports;

    public Colony(String name, int residentPopulation, int strayDogPopulation, int incidentReports) {
        this.name = name;
        this.residentPopulation = residentPopulation;
        this.strayDogPopulation = strayDogPopulation;
        this.incidentReports = incidentReports;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResidentPopulation() {
        return residentPopulation;
    }

    public void setResidentPopulation(int residentPopulation) {
        this.residentPopulation = residentPopulation;
    }

    public int getStrayDogPopulation() {
        return strayDogPopulation;
    }

    public void setStrayDogPopulation(int strayDogPopulation) {
        this.strayDogPopulation = strayDogPopulation;
    }

    public int getIncidentReports() {
        return incidentReports;
    }

    public void setIncidentReports(int incidentReports) {
        this.incidentReports = incidentReports;
    }
    
    @Override
    public String toString()
    {
    	return name+" "+residentPopulation+" "+strayDogPopulation+" "+incidentReports;
    }
}

//IMPACT VALUE
class ImpactValue 
{
    private String name;
    private double normalizedPopulationDensity;
    private double normalizedPublicInteraction;
    private double normalizedCommunityInput;

    public ImpactValue(String name, double normalizedPopulationDensity, double normalizedPublicInteraction, double normalizedCommunityInput) {
        this.name = name;
        this.normalizedPopulationDensity = normalizedPopulationDensity;
        this.normalizedPublicInteraction = normalizedPublicInteraction;
        this.normalizedCommunityInput = normalizedCommunityInput;
    }

    public double calculateOverallImpactValue()
    {
        return normalizedPopulationDensity + normalizedPublicInteraction + normalizedCommunityInput;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNormalizedPopulationDensity() {
        return normalizedPopulationDensity;
    }

    public void setNormalizedPopulationDensity(double normalizedPopulationDensity) {
        this.normalizedPopulationDensity = normalizedPopulationDensity;
    }

    public double getNormalizedPublicInteraction() {
        return normalizedPublicInteraction;
    }

    public void setNormalizedPublicInteraction(double normalizedPublicInteraction) {
        this.normalizedPublicInteraction = normalizedPublicInteraction;
    }

    public double getNormalizedCommunityInput() {
        return normalizedCommunityInput;
    }

    public void setNormalizedCommunityInput(double normalizedCommunityInput) {
        this.normalizedCommunityInput = normalizedCommunityInput;
    }
    
    @Override
    public String toString()
    {
    	return name+" "+normalizedPopulationDensity+" "+normalizedPublicInteraction+" "+normalizedCommunityInput;    	
    }
}

//ITEMS
class Item 
{
    private String name;
    private int weight; // Stray dog population
    private double value; // Impact value calculated from the ImpactValue class

    public Item(String name, int weight, double value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
    @Override
    public String toString()
    {
    	return name+" "+weight+" "+value;
    }
}

//TESTER CLASS
public class tnr_campaigns 
{
	static Scanner sc=new Scanner(System.in);
	
	//driver method
    public static void main(String[] args) 
    {

    	System.out.println("Enter no. of records: ");
    	int n=sc.nextInt();
    	
    	System.out.println("Enter weightage of populationDensity, publicInteraction and communityInput (percentage): ");
    	double pdWt=sc.nextDouble(), piWt=sc.nextDouble(), ciWt=sc.nextDouble();
    	double minPd=Integer.MAX_VALUE, maxPd=Integer.MIN_VALUE;
    	int minPi=Integer.MAX_VALUE, maxPi=Integer.MIN_VALUE, minCi=Integer.MAX_VALUE, maxCi=Integer.MIN_VALUE;
    	
    	Colony[] colonies=new Colony[n];
    	
    	for(int i=0;i<n;i+=1)
    	{
    		System.out.println("Enter Colony name, residentPopulation, strayDogPopulation, no. of incidentReports: ");
    		String name=sc.next();
			int residentPopulation=sc.nextInt();
			int strayDogPopulation=sc.nextInt();
     		int incidentReports=sc.nextInt();
     		
     		minPd=Math.min(minPd, 1.0*strayDogPopulation/residentPopulation);
     		maxPd=Math.max(maxPd, 1.0*strayDogPopulation/residentPopulation);
     		minPi=Math.min(minPi, residentPopulation);
     		maxPi=Math.max(maxPi, residentPopulation);
     		minCi=Math.min(minCi, incidentReports);
     		maxCi=Math.max(maxCi, incidentReports);
     		
     		colonies[i]=new Colony(name,residentPopulation,strayDogPopulation,incidentReports);
    	}
    	
    	System.out.println("Colonies: ");
    	for(Colony c: colonies)System.out.println(c);
    	
    	//create impact value array and pass normalized data into it
    	ImpactValue[] impactValues=new ImpactValue[n];
    	
    	for(int i=0;i<n;i+=1)
    	{
    		//normalised values
    		double pd=scaleValue(1.0*colonies[i].getStrayDogPopulation()/colonies[i].getResidentPopulation(), minPd, maxPd, 0, pdWt);
    		double pi=scaleValue(colonies[i].getResidentPopulation(), minPi, maxPi, 0, piWt);
    		double ci=scaleValue(colonies[i].getIncidentReports(), minCi, maxCi, 0, ciWt);
    		
    		impactValues[i]=new ImpactValue(colonies[i].getName(), pd, pi, ci);
    		
    	}
    	
    	System.out.println("\nImpactValues: ");
    	for(ImpactValue i: impactValues)System.out.println(i);
    	
    	//create items array
    	Item[] items=new Item[n];
    	
    	for(int i=0;i<n;i+=1)
    	{
    		double iv=impactValues[i].calculateOverallImpactValue();
    		items[i]=new Item(colonies[i].getName(), colonies[i].getStrayDogPopulation(), iv);
    	}
    	
    	System.out.println("\nItems: ");
    	for(Item i: items)System.out.println(i);
    	
    	//call 0/1 knapsack function
    	System.out.println("Enter total budget, cost per dog: ");
    	int budget=sc.nextInt(), cpd=sc.nextInt();
    	
    	List<Item> selectedItems=new ArrayList<>();
    	int capacity=budget/cpd;
    	
    	System.out.println("\nMaximum impact value: "+knapsack(items,capacity,selectedItems));
    	System.out.println("Selected Colonies: "+selectedItems);
    
    }

	//knapsack function
    public static double knapsack(Item[] items, int capacity, List<Item> selectedItems)
    {
        int n = items.length;
        double[][] dp = new double[n + 1][capacity + 1];

        // Build the dynamic programming table
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (items[i - 1].getWeight() <= w) {
                    dp[i][w] = Math.max(items[i - 1].getValue() + dp[i - 1][w - items[i - 1].getWeight()], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Trace back to find the selected items
        double maxValue = dp[n][capacity];
        int w = capacity;
        for (int i = n; i > 0 && maxValue > 0; i--) {
            if (maxValue != dp[i - 1][w]) {
                selectedItems.add(items[i-1]);
                maxValue -= items[i - 1].getValue();
                w -= items[i - 1].getWeight();
            }
        }

        return dp[n][capacity];
    }
    

	//normalisation function
	public static double scaleValue(double x, double oldMin, double oldMax, double newMin, double newMax)
	{
	    double newValue = (x - oldMin) * ((newMax - newMin) / (oldMax - oldMin)) + newMin;
	    return newValue;
	}

}

