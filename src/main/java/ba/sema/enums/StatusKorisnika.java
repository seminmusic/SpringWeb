package ba.sema.enums;

public enum StatusKorisnika
{
	AKTIVAN("Aktivan"),
    NEAKTIVAN("Neaktivan"),
    IZBRISAN("Izbrisan"),
    ZAKLJUCAN("Zaključan");
	
	private String status;
	
    private StatusKorisnika(final String status)
    {
    	this.status = status;
    }
    
    public String getStatus()
    {
    	return this.status;
    }
    
    public String getName()
    {
    	return this.name();
    }
 
    @Override
    public String toString()
    {
    	return this.status;
    }
}
