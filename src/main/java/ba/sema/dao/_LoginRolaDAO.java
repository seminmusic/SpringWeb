package ba.sema.dao;

import java.util.List;

import ba.sema.entities._LoginRola;

public interface _LoginRolaDAO
{
	public _LoginRola findById(int id);
	public List<_LoginRola> sveRole();
}
