package br.exemplo.managedbeans;

import br.exemplo.pojo.Pessoa;
import br.exemplo.service.PessoaService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "pessoa")
@SessionScoped
//@RequestScoped
public class PessoaMB implements Serializable {

    private Pessoa bean;
    
    @Inject
    private PessoaService service;
    
    
    /*
        Se a classe está como @SessionScoped o método init é executado apenas uma vez (mantém o estado e não instancia mais)
        Se a classe está como @RequestScoped o método init é executado todas as vezes que existir uma requisição para o server
    */
    @PostConstruct
    private void init(){
        if (bean == null) {
            System.out.println("== INIT >> null ==");
            bean = new Pessoa();
        }
    }
    
    public Pessoa getBean() {
        //System.out.println("GET_BEAN");
        return bean;
    }

    public void salvar() {
        service.salvar(bean);
    }

    public void excluir() {
    }

    public void consultar() {
    }
}
