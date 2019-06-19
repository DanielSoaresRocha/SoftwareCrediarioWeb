package genericdao.impl;

import genericdao.interfaces.IClienteDao;
import modelo.Cliente;

public class ClienteDaoImpl extends GenericDaoImpl<Cliente, Integer> implements IClienteDao {

    public ClienteDaoImpl() {
        super(Cliente.class);
    }
}
