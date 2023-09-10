# Trap-Neuter-Return (TNR) Campaign Resource Optimizer

This Java program is designed to optimize the allocation of resources in Trap-Neuter-Return (TNR) campaigns using the 0/1 knapsack algorithm. It takes into account various factors such as population density, public interaction, and community input to select the optimal set of colonies for TNR campaigns while staying within a given budget.

## Getting Started

These instructions will help you run the program on your local machine.

### Prerequisites

- Java Development Kit (JDK)
- Java Integrated Development Environment (IDE) or command-line compiler

### Running the Program

1. Clone or download this repository to your local machine.

2. Open the project in your Java IDE or navigate to the project directory in the command line.

3. Compile and run the `tnr_campaigns.java` file.

4. Follow the on-screen prompts to enter the required data:
   - Number of records (colonies)
   - Weightage percentages for population density, public interaction, and community input
   - Details for each colony, including name, resident population, stray dog population, and incident reports
   - Total budget and cost per dog

5. The program will calculate and display the maximum impact value and the selected colonies for TNR campaigns.

## Input Data Example

Here is an example of the input data used in the program:

Enter no. of records:
5
Enter weightage of populationDensity, publicInteraction and communityInput (percentage):
55 35 10
Enter Colony name, residentPopulation, strayDogPopulation, no. of incidentReports:
A 500 12 0
B 1000 50 2
C 3000 130 5
D 200 5 0
E 5000 143 1
Enter total budget, cost per dog:
300 2


## Output Example

The program's output will include the maximum impact value and the selected colonies:

Maximum impact value: 75.617
Selected Colonies: [D 5 2.115, C 130 71.314, A 12 2.187]

![image](https://github.com/arayathegod/StrayCare-Resource-Optimiser/assets/95329258/0f2a0bfb-8fd7-4ae9-be57-9ab654c024d2)
![image](https://github.com/arayathegod/StrayCare-Resource-Optimiser/assets/95329258/320d6b44-1ee9-43a6-9681-e261843c56ab)



## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Acknowledgments

- This program was created as part of a term project for Algorithm Design-II (CSE 4131).
- Thanks to Prof. Satya Ranjan Das for guiding me on this project.
