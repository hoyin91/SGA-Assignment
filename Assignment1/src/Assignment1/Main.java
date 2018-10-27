package Assignment1;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Proj_Population pop = new Proj_Population(5,true);
        System.out.println("Initial earnings: "+pop.getFittest().getEarnings());
        GA myGA = new GA();
        for(int i = 0;i<10;i++) {
            pop = myGA.evolvePopulation(pop);
            System.out.println("fitness after"+i+" loops: "+pop.getFittest().getEarnings());
        }
        System.out.println("After evolution :"+pop.getFittest().getEarnings());
        System.out.println();
    }
}
