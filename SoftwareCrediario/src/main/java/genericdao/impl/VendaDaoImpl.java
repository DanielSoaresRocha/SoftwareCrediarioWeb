package genericdao.impl;

import genericdao.interfaces.IVendaDao;
import genericdao.interfaces.IVendedorDao;
import modelo.Venda;

public class VendaDaoImpl extends GenericDaoImpl<Venda, Integer> implements IVendaDao{

    public VendaDaoImpl() {
        super (Venda.class);
    }


 
}