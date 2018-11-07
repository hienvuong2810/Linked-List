package tdt.algo;

import java.util.Scanner;
import java.io.File;

public class RunMgr {
	//read data from input file to corresponding variables
	private CompanyMgrList mgrList;
	private notesList theFirst;
	private eventList pEvent;
	
	public RunMgr()
	{
		mgrList = new MyCompanyMgrList();
		pEvent = null;
		theFirst = null;
	}
	
	void readFile(String fileName)
	{
		try
		{
			File file = new File(fileName);
			Scanner sc = new Scanner(file);
			int eventCode = sc.nextInt();
			theFirst = new notesList(eventCode / 10, eventCode % 10, 1);
			
			eventList tail = null;
			while(sc.hasNextInt())
			{
				eventCode = sc.nextInt();
				
				eventList current_event = new eventList(eventCode, null);

				if (pEvent == null)
					pEvent = current_event;

				if (tail != null)
					tail.setNext(current_event);
				tail = current_event;
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	
	public void runSimulation()
	{
		mgrList.storage(theFirst, pEvent);
		mgrList.display();
	}

	public static void main(String args[])
	{
		// initialize the input file
		RunMgr run = new RunMgr();
		run.readFile("input.txt");
		run.runSimulation();
	}
}
