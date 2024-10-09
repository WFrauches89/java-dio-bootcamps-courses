import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());

        Curso curso3 = new Curso();
        curso3.setTitulo("curso java Avancado");
        curso3.setDescricao("descrição curso java Avancado");
        curso3.setCargaHoraria(16);

        Curso curso4 = new Curso();
        curso4.setTitulo("curso js Avancado");
        curso4.setDescricao("descrição curso js avancado");
        curso4.setCargaHoraria(16);

        Mentoria mentoria2 = new Mentoria();
        mentoria2.setTitulo("mentoria de js");
        mentoria2.setDescricao("descrição mentoria js");
        mentoria2.setData(LocalDate.now());

        /*System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);*/

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Full Stack Developer");
        bootcamp.setDescricao("Descrição Bootcamp Full Stack Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(curso3);
        bootcamp.getConteudos().add(curso4);
        bootcamp.getConteudos().add(mentoria);
        bootcamp.getConteudos().add(mentoria2);

        Bootcamp bootcamp2 = new Bootcamp();
        bootcamp2.setNome("Bootcamp Java Developer");
        bootcamp2.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp2.getConteudos().add(curso1);
        bootcamp2.getConteudos().add(mentoria);

        Bootcamp bootcamp3 = new Bootcamp();
        bootcamp3.setNome("Bootcamp JS Developer");
        bootcamp3.setDescricao("Descrição Bootcamp JS Developer");
        bootcamp3.getConteudos().add(curso2);
        bootcamp3.getConteudos().add(mentoria2);

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        System.out.println("Bootcamps Inscritos Cami:" + devCamila.getListaBootcamps());
        devCamila.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        System.out.println("Bootcamps Inscritos Cami:" + devCamila.getListaBootcamps().toString());
        devCamila.progredir();
        devCamila.progredir();
        devCamila.progredir();
        devCamila.progredir();
        devCamila.progredir();
        devCamila.progredir();
        devCamila.progredir();
        devCamila.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Camila:" + devCamila.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos Camila:" + devCamila.getConteudosConcluidos());
        System.out.println("Skills Camila:" + devCamila.getSkillsHabilitadas());
        System.out.println("XP:" + devCamila.calcularTotalXp());

        System.out.println("-------");

        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        System.out.println("Bootcamps Inscritos João:" + devJoao.getListaBootcamps());
        devJoao.inscreverBootcamp(bootcamp2);
        devJoao.inscreverBootcamp(bootcamp3);
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        System.out.println("Bootcamps Inscritos João:" + devJoao.getListaBootcamps().toString());

        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();

        System.out.println("-");
        System.out.println("Conteúdos Inscritos João:" + devJoao.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos João:" + devJoao.getConteudosConcluidos());
        System.out.println("Skills João:" + devJoao.getSkillsHabilitadas());
        System.out.println("XP:" + devJoao.calcularTotalXp());

    }

}
