package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
    private Set<Skills> skillsHabilitadas = new HashSet<>();
    private Set<Bootcamp> listaBootcamps = new HashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        this.listaBootcamps.add(bootcamp);
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        if (conteudosInscritos.isEmpty()) {
            if (listaBootcamps.isEmpty()) {
                System.err.println("Você não está inscrito em nenhum bootcamp!");
            } else {
                System.err.println("Você já concluiu todos os conteúdos do bootcamp!");
            }
            return;
        }

        // Pega o primeiro conteúdo da lista de inscritos
        Conteudo conteudo = this.conteudosInscritos.stream().findFirst().get();

        // Marca o conteúdo como concluído e remove dos conteúdos inscritos
        this.conteudosConcluidos.add(conteudo);
        this.conteudosInscritos.remove(conteudo);
        System.out.println("Conteúdo " + conteudo.getTitulo() + " concluído.");

        // Verifica e adiciona novas skills se for o caso
        addNewSkill();
    }

    public void addNewSkill() {
        Set<Bootcamp> bootcampsConcluidos = new HashSet<>(); // Lista de bootcamps para remover depois da iteração

        for (Bootcamp bootcamp : listaBootcamps) {
            // Verifica se todos os conteúdos do bootcamp foram concluídos
            if (conteudosConcluidos.containsAll(bootcamp.getConteudos())) {
                // Verifica se o nome do bootcamp já existe nas skills habilitadas
                boolean skillJaHabilitada = skillsHabilitadas.stream()
                        .anyMatch(skill -> skill.getNome().equals(bootcamp.getNome()));

                // Adiciona a skill apenas se ainda não estiver habilitada
                if (!skillJaHabilitada) {
                    Skills novaSkill = new Skills();
                    novaSkill.setNome(bootcamp.getNome());
                    skillsHabilitadas.add(novaSkill);  // Adiciona a nova skill
                    bootcampsConcluidos.add(bootcamp); // Marca o bootcamp como concluído
                }
            }
        }

        // Remove todos os bootcamps concluídos da lista após a iteração
        listaBootcamps.removeAll(bootcampsConcluidos);
    }

    public double calcularTotalXp() {
        Iterator<Conteudo> iterator = this.conteudosConcluidos.iterator();
        double soma = 0;
        while(iterator.hasNext()){
            double next = iterator.next().calcularXp();
            soma += next;
        }
        return soma;

        /*return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();*/
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    public Set<Skills> getSkillsHabilitadas() {
        return skillsHabilitadas;
    }

    public Set<Bootcamp> getListaBootcamps() {
        return listaBootcamps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
