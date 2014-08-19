package br.exemplo.service;

import br.exemplo.pojo.Pessoa;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@ApplicationScoped
public class PessoaService {
    
    //não pode ser utilizado porque o container não está gerenciando (utilizado em EJBs)
    //@PersistenceContext
    //private EntityManager m;
    
    @PersistenceUnit(unitName = "ExemploApplicationUnit")
    private EntityManagerFactory emf;
    
    //@Resource
    //private UserTransaction tx;
    
    @Inject
    private PessoaTesteTransactionService testeTransactional;
    
    @Transactional(propagation = Propagation.SUPPORTS)
    public void salvar(Pessoa bean) throws Exception{
        System.out.println("INJECT_FACTORY (TX): " + bean.toString());
        
        //controla manualmente porque não está no contexto do EJB
        //TODO: Verificar se existe uma forma de forçar este controle utilizando beans.xml
        //tx.begin();
        EntityManager m = emf.createEntityManager();
        m.getTransaction().begin();
        
        
        m.persist(bean);
        /*
        System.out.println("==== SELECIONA TODOS OS DADOS DA TABELA ======");
        List<Pessoa> list = m.createNamedQuery("Pessoa.all",Pessoa.class).getResultList();
        for(Pessoa p: list){
            System.out.println("ALL >> " + p);   
        }*/
        
        testeTransactional.pessoasAll();
        
        m.getTransaction().commit();
        //tx.commit();
        
        
        
        
    }
}
