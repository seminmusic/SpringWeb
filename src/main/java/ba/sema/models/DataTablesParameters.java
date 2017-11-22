package ba.sema.models;

public class DataTablesParameters
{
	// First record that should be shown (used for paging):
    private int iDisplayStart;
    
    // Number of records that should be shown in table:
    private int iDisplayLength;
    
    // Number of columns in table:
    private int iColumns;
    
    // Text used for filtering (Global search field):
    private String sSearch;
    
    // Individual column filter:
    private String sSearch_0;
    private String sSearch_1;
    private String sSearch_2;
    private String sSearch_3;
    private String sSearch_4;
    private String sSearch_5;
    private String sSearch_6;
    private String sSearch_7;
    private String sSearch_8;
    private String sSearch_9;
    private String sSearch_10;
    
    // True if the global filter should be treated as a regular expression for advanced filtering, false if not:
    private boolean bRegex;
    
    // Number of columns that are used in sorting:
    private int iSortingCols;
    
    // Index kolone za sortiranje:
    private String iSortCol_0;
    
    // Smjer sortiranja ("asc" ili "desc"):
    private String sSortDir_0;
    
    // Request sequence number sent by DataTable, same value must be returned in response:
    private String sEcho;
    
    
	public int getiDisplayStart()
	{
		return iDisplayStart;
	}
	public void setiDisplayStart(int iDisplayStart)
	{
		this.iDisplayStart = iDisplayStart;
	}
	
	public int getiDisplayLength()
	{
		return iDisplayLength;
	}
	public void setiDisplayLength(int iDisplayLength)
	{
		this.iDisplayLength = iDisplayLength;
	}
	
	public int getiColumns()
	{
		return iColumns;
	}
	public void setiColumns(int iColumns)
	{
		this.iColumns = iColumns;
	}
	
	public String getsSearch()
	{
		return sSearch;
	}
	public void setsSearch(String sSearch)
	{
		this.sSearch = sSearch;
	}
	
	public String getsSearch_0()
	{
		return sSearch_0;
	}
	public void setsSearch_0(String sSearch_0)
	{
		this.sSearch_0 = sSearch_0;
	}
	
	public String getsSearch_1()
	{
		return sSearch_1;
	}
	public void setsSearch_1(String sSearch_1)
	{
		this.sSearch_1 = sSearch_1;
	}
	
	public String getsSearch_2()
	{
		return sSearch_2;
	}
	public void setsSearch_2(String sSearch_2)
	{
		this.sSearch_2 = sSearch_2;
	}
	
	public String getsSearch_3()
	{
		return sSearch_3;
	}
	public void setsSearch_3(String sSearch_3)
	{
		this.sSearch_3 = sSearch_3;
	}
	
	public String getsSearch_4()
	{
		return sSearch_4;
	}
	public void setsSearch_4(String sSearch_4)
	{
		this.sSearch_4 = sSearch_4;
	}
	
	public String getsSearch_5()
	{
		return sSearch_5;
	}
	public void setsSearch_5(String sSearch_5)
	{
		this.sSearch_5 = sSearch_5;
	}
	
	public String getsSearch_6()
	{
		return sSearch_6;
	}
	public void setsSearch_6(String sSearch_6)
	{
		this.sSearch_6 = sSearch_6;
	}
	
	public String getsSearch_7()
	{
		return sSearch_7;
	}
	public void setsSearch_7(String sSearch_7)
	{
		this.sSearch_7 = sSearch_7;
	}
	
	public String getsSearch_8()
	{
		return sSearch_8;
	}
	public void setsSearch_8(String sSearch_8)
	{
		this.sSearch_8 = sSearch_8;
	}
	
	public String getsSearch_9()
	{
		return sSearch_9;
	}
	public void setsSearch_9(String sSearch_9)
	{
		this.sSearch_9 = sSearch_9;
	}
	
	public String getsSearch_10()
	{
		return sSearch_10;
	}
	public void setsSearch_10(String sSearch_10)
	{
		this.sSearch_10 = sSearch_10;
	}
	
	public boolean isbRegex()
	{
		return bRegex;
	}
	public void setbRegex(boolean bRegex)
	{
		this.bRegex = bRegex;
	}
	
	public int getiSortingCols()
	{
		return iSortingCols;
	}
	public void setiSortingCols(int iSortingCols)
	{
		this.iSortingCols = iSortingCols;
	}
	
	public String getiSortCol_0()
	{
		return iSortCol_0;
	}
	public void setiSortCol_0(String iSortCol_0)
	{
		this.iSortCol_0 = iSortCol_0;
	}
	
	public String getsSortDir_0()
	{
		return sSortDir_0;
	}
	public void setsSortDir_0(String sSortDir_0)
	{
		this.sSortDir_0 = sSortDir_0;
	}
	
	public String getsEcho()
	{
		return sEcho;
	}
	public void setsEcho(String sEcho)
	{
		this.sEcho = sEcho;
	}
}
