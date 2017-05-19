package ba.sema.enums;

public enum TipRole
{
	STANDARD("STANDARD"),
    DB_ADMIN("DB_ADMIN"),
    SYSTEM_ADMIN("SYSTEM_ADMIN");
	
    private String tipRole;
    
    private TipRole(String tipRole)
    {
    	this.tipRole = tipRole;
    }
    
    public String getTipRole()
    {
    	return tipRole;
    }
}
