package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.model.Pessoa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author aluno
 */
@Named
@ViewScoped
public class ExemploController implements Serializable {

    private Pessoa pessoa;
    private List<Pessoa> pessoas = new ArrayList<>();

    public ExemploController() {
        System.out.println("construtor.");
        this.pessoa = new Pessoa();
    }

    public void excluir() {
        int a = 300;
        if (pessoa != null && !pessoa.getNome().isEmpty())
 { 
     a = 0;
            for (Pessoa p : this.pessoas) {
                if (p.getNome().equals(pessoa.getNome())) {
                    pessoas.remove(pessoa);
                    addMessage(FacesMessage.SEVERITY_INFO, "Informação", "Pessoa excluida");
                    return;

                }

            }

            for (Pessoa p : this.pessoas) {
                if (p.getNome().equals(pessoa.getNome())) {
                    a++;
                }
            }
 

        }
        if (a < 300) {
            addMessage(FacesMessage.SEVERITY_INFO, "Informação", "Pessoa excluida");
        } else if (pessoa.getNome().equals("") && pessoas.isEmpty()) {
            addMessage(FacesMessage.SEVERITY_INFO, "Informação", "Selecione uma pessoa");
        }
        this.pessoas.remove(this.pessoa);

    }

    public void teste() {
        System.out.println("Executou o método teste.");
        System.out.println("Nome: " + this.pessoa.getNome());
    }

    public void adicionar() {
        System.out.println("adicionou pessoa na lista.");
        this.pessoas.add(pessoa);
        this.pessoa = new Pessoa();
        addMessage(FacesMessage.SEVERITY_INFO, "Informação", "Cadastro realizado.");

    }

    private void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

}
