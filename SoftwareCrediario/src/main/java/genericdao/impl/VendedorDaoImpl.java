package genericdao.impl;

import genericdao.interfaces.IVendedorDao;
import modelo.Vendedor;

public class VendedorDaoImpl extends GenericDaoImpl<Vendedor, Integer> implements IVendedorDao{

    public VendedorDaoImpl() {
        super (Vendedor.class);
    }


 
}
