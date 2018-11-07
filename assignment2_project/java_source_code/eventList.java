package tdt.algo;

public class eventList {
	public static final int  TERMINATE_EVENT =	    			0;
	public static final int  IMPORT_EVENT =         			1;
	public static final int  RESERVED_EVENT =      				2;
	public static final int  STAT_IMPORT_EVENT =    			3;
	public static final int  STAT_RESERVED_EVENT =   			4;
	public static final int  STAT_REST_EVENT =              	5;
	public static final int  MAX_REST_STAT_EVENT =				6;
	public static final int  REMOVE_INVALID_RESERVE_EVENT = 	8;
	
	private int nEventCode; 
	private eventList next;
	
	public eventList()
	{
		this(-1, null);
	}
	
	public eventList(int nEventCode, eventList next)
	{
		this.nEventCode = nEventCode;
		this.next = next;
	}
	
	public int getnEventCode()
	{
		return nEventCode;
	}
	
	public eventList getNext()
	{
		return next;
	}
	
	public void setnEventCode(int nEventCode)
	{
		this.nEventCode = nEventCode;
	}
	
	public void setNext(eventList next)
	{
		this.next = next;
	}
}