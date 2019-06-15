package percistencia;

import org.hibernate.Session;

public class Conecta {

    public static void main(String[] args) {
        System.out.println("Passei por aqui");
        Session sessao = null;
        sessao = HibernateUtil.getSessionFactory().openSession();
        System.out.println("Conectou!");
        sessao.close();
    }

}
