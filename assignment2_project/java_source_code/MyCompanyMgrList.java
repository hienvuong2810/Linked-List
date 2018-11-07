package tdt.algo;
public class MyCompanyMgrList extends CompanyMgrList {	
	public MyCompanyMgrList()
	{
		super();
	}

	/*********************************************************************************************/
	// you can add some more methods if you need.
	
	private int getEventCode(eventList pEvent)
	{
		int n = pEvent.getnEventCode();
		while(n>10) {
			n=n/10;
		}
		return n;
	}

	private int getProductId(int nEvent)
	{
		// code here
		return 0;
	}

	/**
	 * get quantity fron nEventCode of eventList
	 */
	private int getQuan(int nEvent)
	{
		notesList tmp = head;
		int exist = 0;
		int order = 0;
		while(tmp != null) {
			if(tmp.getnProdID() == nEvent && tmp.getnType() == 1) {
				exist+=tmp.getnQuan();
			}
			if(tmp.getnProdID() == nEvent && tmp.getnType() == 2) {
				order += tmp.getnQuan();
			}
			tmp = tmp.getNext();
		}
		int result = exist - order;
		if(result < 0) {
			result =0;
		}
		return result;
	}

	private void doImport(int nEventCode)
	{
			tail.setNext(new notesList((nEventCode-10000)/10,nEventCode%10,1));
			tail=tail.getNext();
		
	}
	private void addLast(notesList Node) {
		if(Node == null) {
			return;
		}
		else {
			if(head == null) {
				head = Node;
				tail = Node;
			}
			else {
				notesList temp = head;
				while (temp.getNext()!=null) {
					temp=temp.getNext();
				}
				temp.setNext(Node);
				tail=temp.getNext();
			}
		}
	}
	private void addFirst(notesList Node) {
		if (Node == null) {
			return;
		}
		else {
			if(head == null){
				Node.setNext(null);
				head = Node;
			}
			else {
				Node.setNext(head);
				head = Node;
			}
		}
	}
	/**
	 * add a new noteList add the end of linked-list notesList
	 * tail:  pointer to tail of head of notesList
	 * side-effec: tail point to the new node which is now the tail
	 */
	private void doReserve(int nEventCode)
	{
		
		tail.setNext(new notesList((nEventCode-20000)/10,nEventCode%10,2));
		tail=tail.getNext();
	}
	
	private void doStatImport(int nEventCode)
	{
		int YY=0;
		nEventCode = nEventCode - 3000;
		notesList tmpNode = head;
		notesList prev = null;
		while(tmpNode!=null) {
			if(tmpNode.getnProdID()==nEventCode&&tmpNode.getnType()==1) {
				YY+=tmpNode.getnQuan();
				if(tmpNode == head) {
					head = head.getNext();		
				}
				else {
					prev.setNext(tmpNode.getNext());
				}
			}
			else {
				prev=tmpNode;
			}
			tmpNode=tmpNode.getNext();
		}
		if(YY>99) {
			YY=YY%100;
		}
		if(YY>0) {
			addFirst(new notesList(nEventCode,YY,1));
		}
		if(YY==0) {
			addLast((new notesList(nEventCode,YY,1)));
		}
	}

	private void doStatReserve(int nEventCode)
	{
		int YY=0;
		nEventCode = nEventCode - 4000;
		notesList tmpNode = head.getNext();
		notesList prev = head;
		while(tmpNode!=null) {
			if(tmpNode.getnProdID()==nEventCode && tmpNode.getnType()==2) {
				YY+=tmpNode.getnQuan();
				prev.setNext(tmpNode.getNext());
			}
			else {
				prev=tmpNode;
			}
			tmpNode=tmpNode.getNext();
		}
		if(YY>99) {
			YY=YY%100;
		}
	
		if(YY<99) {
			addLast((new notesList(nEventCode,YY,2)));

		}
	}
	private void doStatRest(int nEventCode)
	{
		int exist=0;
		int order =0;
		nEventCode = nEventCode - 5000;
		notesList tmpNode = head;
		notesList prev = null;
		while(tmpNode!=null) {
			if(tmpNode.getnProdID()==nEventCode && tmpNode.getnType()==1) {
				exist+=tmpNode.getnQuan();
				if(tmpNode == head) {
					head = head.getNext();
				}
				else {
					prev.setNext(tmpNode.getNext());
				}
			}
			if(tmpNode.getnProdID() == nEventCode && tmpNode.getnType() ==2) {
				order += tmpNode.getnQuan();
				if(tmpNode == head) {
					head = head.getNext();
				}
				else {
					prev.setNext(tmpNode.getNext());
				}
			}
			prev = tmpNode;
			tmpNode = tmpNode.getNext();
		}
		int result = exist - order;
		if(result<0) {
			result =0;
		}
		if(result>99) {
			result = result % 100;
		}
		addLast(new notesList(nEventCode,result,1));
	}

	/**
	 *
	 * find Product with Max Rest in storage
	 */

	private void doMaxRestStat()
	{
		
	}

	private void doRemoveInvalidReserve()
	{
		// code here
	}
	
	public boolean checkPalindrome()
	{	
		return false;
	}

	public void storage (notesList theFirst, eventList pEvent)
	{
		// code here
		head = new notesList();
		head.setnProdID(theFirst.getnProdID());
		head.setnQuan(theFirst.getnQuan());
		head.setnType(theFirst.getnType());
		head.setNext(null);
		tail = head;
		while(pEvent != null)
		{
			switch(getEventCode(pEvent))
			{
				case eventList.TERMINATE_EVENT:
					return;
				case eventList.IMPORT_EVENT:
					doImport(pEvent.getnEventCode());
					break;
				case eventList.RESERVED_EVENT:
					doReserve(pEvent.getnEventCode());
					break;
				case eventList.STAT_IMPORT_EVENT:
					doStatImport(pEvent.getnEventCode());
					break;
				case eventList.STAT_RESERVED_EVENT:
					doStatReserve(pEvent.getnEventCode());
					break;
				case eventList.STAT_REST_EVENT:
					doStatRest(pEvent.getnEventCode());
					break;
				case eventList.MAX_REST_STAT_EVENT:
					doMaxRestStat();
					break;
				case eventList.REMOVE_INVALID_RESERVE_EVENT:
					doRemoveInvalidReserve();
					break;
				default:
			}
			pEvent = pEvent.getNext();
			if(head == null)
				break;
		}		
	}
}