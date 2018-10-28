package Assignment1;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String file_name = "result.txt";

        for(int iteration = 0 ;iteration<20;iteration++) {
            try{
                FileWriter fw = new FileWriter(file_name,true);
                Proj_Population pop = new Proj_Population(5, true);
                fw.write("Interation : "+iteration+"\n");
                fw.write("Initial Fitness: " + pop.getFittest().getEarnings()+"\n");
                System.out.println("Initial Fitness: " + pop.getFittest().getEarnings()+"\n");
                GA myGA = new GA();
                for (int i = 0; i < 10; i++) {
                    pop = myGA.evolvePopulation(pop);
                    fw.write("fitness after" + i + " loops: " + pop.getFittest().getEarnings()+"\n");
                    System.out.println("fitness after" + i + " loops: " + pop.getFittest().getEarnings());
                }
                fw.write("After evolution :" + pop.getFittest().getEarnings()+"\n");
                System.out.println("After evolution :" + pop.getFittest().getEarnings());
                fw.write("Orientation of proj ");
                System.out.print("Orientation of proj ");
                for(int i = 0; i < pop.getFittest().getProjList().size();i++)
                {
                    fw.write(pop.getFittest().getProject(i).present+" ");
                    System.out.print(pop.getFittest().getProject(i).present+" ");
                }
                fw.write("\n-------------------------------------------------------\n");
                System.out.println(" ");
                System.out.println("----------------------------------------------------------------------------------------");
                fw.close();
            }
            catch(IOException ioe)
            { System.err.println("IOException "+ ioe.getMessage());
            }

        }
    }
}
