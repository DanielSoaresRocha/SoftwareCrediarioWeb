package genericdao.impl;

import genericdao.interfaces.ICredencialDao;
import modelo.Credencial;

public class CredencialDaoImpl extends GenericDaoImpl<Credencial, Integer> implements ICredencialDao{
    
    public CredencialDaoImpl() {
        super (Credencial.class);
    }
}


 

