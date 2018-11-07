package tdt.algo;

public abstract class CompanyMgrList {
	
	protected notesList head;	// head of list
	protected notesList tail;	// tail	of list
	
	public CompanyMgrList()
	{
		head = null;
		tail = null;
	}
	
	void display()
	{
		if (checkPalindrome())
		{
			System.out.println("God saves the us!");
		}
		
		if (head == null)
			System.out.print("null");
		
		notesList tmp = head;
		while (tmp != null)
		{
			System.out.printf("%03d%02d%1d", tmp.getnProdID(), tmp.getnQuan(), tmp.getnType());
			tmp = tmp.getNext();
		}
		
		System.out.println();
	}
	
	public abstract boolean checkPalindrome();
	public abstract void storage(notesList theFirst, eventList pEvent);
}