import java.util.*;
import java.io.*;

//Denna klass ärver Global så att man kan använda time och signalnamnen utan punktnotation


public class MainSimulation extends Global{

    public static void main(String[] args) throws IOException {
    	Random rand = new Random();
    	//Signallistan startas och actSignal deklareras. actSignal är den senast utplockade signalen i huvudloopen nedan.

    	Signal actSignal;
    	new SignalList();

    	//Här nedan skapas de processinstanser som behövs och parametrar i dem ges värden.
    	
    	//Uppgift 1 e)
//    	QS Q1 = new QS();
//    	QS Q2 = new QS();
//    	QS Q3 = new QS();
    	//Q1.sendTo = null;
    	
    	//Uppgift 1 f)
    	QS Q1 = new QS();
    	QS Q2 = new QS();
    	QS Q3 = new QS();
    	QS Q4 = new QS();
    	QS Q5 = new QS();

    	Gen Generator = new Gen();
    	Generator.lambda = 45; //Generator ska generera nio kunder per sekund
    	//De genererade kunderna ska skickas till kösystemet QS
    	
    	//Uppgift 1 e)
//    	Generator.sendTo = Q1;
//    	Q1.sendTo = Q2;
//    	Q2.sendTo = Q3;

    	//Här nedan skickas de första signalerna för att simuleringen ska komma igång.

    	SignalList.SendSignal(READY, Generator, time);
    	
    	//Uppgift 1 e)
//    	SignalList.SendSignal(MEASURE, Q1, time);
//    	SignalList.SendSignal(MEASURE, Q2, time);
//    	SignalList.SendSignal(MEASURE, Q3, time);
    	
    	//Uppgift 1 f)
    	SignalList.SendSignal(MEASURE, Q1, time);
    	SignalList.SendSignal(MEASURE, Q2, time);
    	SignalList.SendSignal(MEASURE, Q3, time);
    	SignalList.SendSignal(MEASURE, Q4, time);
    	SignalList.SendSignal(MEASURE, Q5, time);
    	

    	// Detta är simuleringsloopen:
    	int stepByStep = 1; // Uppgift 1 f) ii)
    	while (time < 100000){
    		actSignal = SignalList.FetchSignal();
    		time = actSignal.arrivalTime;
    		actSignal.destination.TreatSignal(actSignal);
    		
    	// Uppgift 1 f) i)
//    		int randomizer = rand.nextInt(5) + 1;
//    		if (randomizer == 1) {
//    			Generator.sendTo = Q1;
//    		} else if (randomizer == 2) {
//    			Generator.sendTo = Q2;
//    		} else if (randomizer == 3) {
//    			Generator.sendTo = Q3;
//    		} else if (randomizer == 4) {
//    			Generator.sendTo = Q4;
//    		} else if (randomizer == 5) {
//    			Generator.sendTo = Q5;
//    		}
    		
    	// Uppgift 1 f) ii)
//    		if (stepByStep == 1) {
//    			Generator.sendTo = Q1;
//    		} else if (stepByStep == 2) {
//    			Generator.sendTo = Q2;
//    		} else if (stepByStep == 3) {
//    			Generator.sendTo = Q3;
//    		} else if (stepByStep == 4) {
//    			Generator.sendTo = Q4;
//    		} else if (stepByStep == 5) {
//    			Generator.sendTo = Q5;
//    		} 
//    		stepByStep++;
//    		if (stepByStep == 6) {
//    			stepByStep = 1;
//    		}
    		
    	// Uppgift 1 f) iii)
    		int [] size = {Q1.numberInQueue, Q2.numberInQueue, Q3.numberInQueue, Q4.numberInQueue, Q5.numberInQueue};
    		ArrayList<Integer> sizeOfQueues = new ArrayList<Integer>();
    		
    		for(int i = 0; i < size.length; i++) {
    			sizeOfQueues.add(i);
    		}
    		Collections.sort(sizeOfQueues);
    		int smallestQueue = sizeOfQueues.get(0);
    		
    		if (smallestQueue == size[0]) {
    			Generator.sendTo = Q1;
    		} else if (smallestQueue == size[1]) {
    			Generator.sendTo = Q2;
    		} else if (smallestQueue == size[2]) {
    			Generator.sendTo = Q3;
    		} else if (smallestQueue == size[3]) {
    			Generator.sendTo = Q4;
    		} else if (smallestQueue == size[4]) {
    			Generator.sendTo = Q5;
    		}
    		
    	}

    	//Slutligen skrivs resultatet av simuleringen ut nedan:
    	
    	//Uppgift 1 e)
//    	System.out.println("Medelantal kunder i kösystem 1: " + 1.0*Q1.accumulated/Q1.noMeasurements);
//    	System.out.println("Medelantal kunder i kösystem 2: " + 1.0*Q2.accumulated/Q2.noMeasurements);
//    	System.out.println("Medelantal kunder i kösystem 3: " + 1.0*Q3.accumulated/Q3.noMeasurements);
    	
    	//Uppgift 1 f)
    	System.out.println("Medelantal kunder i kösystem 1: " + 1.0*Q1.accumulated/Q1.noMeasurements);
    	System.out.println("Medelantal kunder i kösystem 2: " + 1.0*Q2.accumulated/Q2.noMeasurements);
    	System.out.println("Medelantal kunder i kösystem 3: " + 1.0*Q3.accumulated/Q3.noMeasurements);
    	System.out.println("Medelantal kunder i kösystem 1: " + 1.0*Q4.accumulated/Q4.noMeasurements);
    	System.out.println("Medelantal kunder i kösystem 2: " + 1.0*Q5.accumulated/Q5.noMeasurements);
    }
}