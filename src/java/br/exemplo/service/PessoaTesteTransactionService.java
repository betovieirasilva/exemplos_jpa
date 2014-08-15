/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.exemplo.service;

import br.exemplo.pojo.Pessoa;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.TransactionScoped;
//import javax.transaction.Transactional;

/**
 *
 * @author root
 */
@ApplicationScoped
public class PessoaTesteTransactionService {
    
    @PersistenceUnit(unitName = "ExemploApplicationUnit")
    private EntityManagerFactory emf;
    
    @TransactionScoped()
    public void pessoasAll(){
        System.out.println("==== SELECIONA TODOS OS DADOS DA TABELA (2) ======");
        EntityManager m = emf.createEntityManager();
        List<Pessoa> list = m.createNamedQuery("Pessoa.all",Pessoa.class).getResultList();
        for(Pessoa p: list){
            System.out.println("ALL >> " + p);   
        }
        
    
    }
    
}
