package br.com.projedata.iniflex.main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

import br.com.projedata.iniflex.models.Funcionario;

public class Principal {
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final NumberFormat FORMATO_MOEDA = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));

    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        // 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
        inserirFuncionarios(funcionarios,
                new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"),
                new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"),
                new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"),
                new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"),
                new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"),
                new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"),
                new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"),
                new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"),
                new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"),
                new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente")
            );

        // 3.2 – Remover o funcionário “João” da lista.
        removerFuncionario(funcionarios, "João");

        // 3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
        // • informação de data deve ser exibido no formato dd/mm/aaaa;
        // • informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.
        imprimirTodosFuncionarios(funcionarios);

        // 3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
        atualizarSalario(funcionarios, new BigDecimal("1.10"));

        // 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
        Map<String, List<Funcionario>> funcionariosPorFuncao = agruparPorFuncao(funcionarios);
        
        // 3.6 – Imprimir os funcionários, agrupados por função.
        imprimirAgrupadosPorFuncao(funcionariosPorFuncao);

        // 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
        imprimirAniversariantes(funcionarios, 10, 12);

        // 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
        imprimirFuncionarioMaisVelho(funcionarios);

        // 3.10 – Imprimir a lista de funcionários por ordem alfabética.
        imprimirEmOrdemAlfabetica(funcionarios);

        // 3.11 – Imprimir o total dos salários dos funcionários.
        imprimirTotalSalarios(funcionarios);

        // 3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
        imprimirSalariosMinimos(funcionarios, new BigDecimal("1212.00"));
    }

    // 3.1 – Insere funcionários na lista.
    private static void inserirFuncionarios(List<Funcionario> listaDeFuncionarios, Funcionario... funcionarios) {
        for (Funcionario f : funcionarios) {
            listaDeFuncionarios.add(f);
        }
    }

    // 3.2 – Remove funcionário da lista, por nome.
    private static void removerFuncionario(List<Funcionario> funcionarios, String nome) {
        funcionarios.removeIf(f -> f.getNome().equals(nome));
    }

    // 3.3 – Imprime todos os funcionários com todas suas informações.
    private static void imprimirTodosFuncionarios(List<Funcionario> funcionarios) {
        System.out.println("\n3.3 – Imprimir todos os funcionários com todas suas informações:");
        
        for (Funcionario f : funcionarios) {
            System.out.printf(
                "Nome: %s, Data Nascimento: %s, Salário: %s, Função: %s%n",
                f.getNome(),
                FORMATO_DATA.format(f.getDataNascimento()),
                FORMATO_MOEDA.format(f.getSalario()),
                f.getFuncao()
            );
        }
    }

    // 3.4 – Aplica aumento de salário e atualiza a lista de funcionários com novo valor.
    private static void atualizarSalario(List<Funcionario> funcionarios, BigDecimal fatorMultiplicativo) {
        funcionarios.forEach(f -> f.setSalario(f.getSalario().multiply(fatorMultiplicativo)));
    }

    // 3.5 – Agrupa os funcionários por função em um MAP.
    private static Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
    	Map<String, List<Funcionario>> funcionariosPorFuncao = new HashMap<>();

        for (Funcionario f : funcionarios) {
            String funcao = f.getFuncao();
            
            if (!funcionariosPorFuncao.containsKey(funcao)) {
            	funcionariosPorFuncao.put(funcao, new ArrayList<>());
            }
            
            funcionariosPorFuncao.get(funcao).add(f);
        }

        return funcionariosPorFuncao;
    }

    // 3.6 – Imprime os funcionários, agrupados por função.
    private static void imprimirAgrupadosPorFuncao(Map<String, List<Funcionario>> funcionariosPorFuncao) {
        System.out.println("\n3.6 – Imprimir os funcionários, agrupados por função:");
        
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("Função: " + funcao);
            lista.forEach(f -> System.out.println("- " + f.getNome()));
        });
    }
    
    // 3.8 – Imprime os funcionários que fazem aniversário nos meses selecionados.
    private static void imprimirAniversariantes(List<Funcionario> funcionarios, int... meses) {
        System.out.println("\n3.8 – Imprimir os funcionários que fazem aniversário no mês " + Arrays.toString(meses) + ":");
        
        Set<Integer> mesesAniversario = new HashSet<>();
        
        for (int mes : meses) {
            mesesAniversario.add(mes);
        }

        for (Funcionario f : funcionarios) {
            int mesNascimento = f.getDataNascimento().getMonthValue();
            
            if (mesesAniversario.contains(mesNascimento)) {
                System.out.printf("Nome: %s, Data Nascimento: %s%n",
                    f.getNome(),
                    f.getDataNascimento().format(FORMATO_DATA)
                );
            }
        }
    }

    // 3.9 – Imprime o funcionário com a maior idade.
    private static void imprimirFuncionarioMaisVelho(List<Funcionario> funcionarios) {
        System.out.println("\n3.9 – Imprimir o funcionário com a maior idade:");
        
        if (funcionarios.isEmpty()) {
            return;
        }

        Funcionario maisVelho = funcionarios.get(0);

        for (int i = 1; i < funcionarios.size(); i++) {
            Funcionario funcionarioAtual = funcionarios.get(i);
            
            if (funcionarioAtual.getDataNascimento().isBefore(maisVelho.getDataNascimento())) {
                maisVelho = funcionarioAtual;
            }
        }

        int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
        System.out.printf("Nome: %s, Idade: %d anos%n", maisVelho.getNome(), idade);
    }
    
    // 3.10 – Imprime a lista de funcionários por ordem alfabética.
    private static void imprimirEmOrdemAlfabetica(List<Funcionario> funcionarios) {
        System.out.println("\n3.10 – Imprimir a lista de funcionários por ordem alfabética:");
        
        List<Funcionario> funcionariosOrdenados = new ArrayList<>(funcionarios);
        
        funcionariosOrdenados.sort(Comparator.comparing(Funcionario::getNome)); 
        
        funcionariosOrdenados.forEach(f -> System.out.println(f.getNome()));
    }

    // 3.11 – Imprime o total dos salários dos funcionários.
    private static void imprimirTotalSalarios(List<Funcionario> funcionarios) {
        System.out.println("\n3.11 – Imprimir o total dos salários dos funcionários:");
        
        BigDecimal totalSalarios = BigDecimal.ZERO;
        
        for (Funcionario f : funcionarios) {
            totalSalarios = totalSalarios.add(f.getSalario());
        }
        
        System.out.println(FORMATO_MOEDA.format(totalSalarios));
    }

    // 3.12 – Imprime quantos salários mínimos ganha cada funcionário.
    private static void imprimirSalariosMinimos(List<Funcionario> funcionarios, BigDecimal salarioMinimo) {
        System.out.println("\n3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é " + FORMATO_MOEDA.format(salarioMinimo) + ":");
        
        for (Funcionario funcionario : funcionarios) {
            BigDecimal salariosMinimos = funcionario.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.printf("Nome: %s, Salários Mínimos: %s%n", funcionario.getNome(), salariosMinimos);
        }
    }
}
