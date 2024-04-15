package entities;

import java.util.Scanner;

public class Excluir {
	
private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    // Declaração das variáveis
    int idProduto;
    String descricao;
    double vlcusto;
    double vlvenda;
    String categoria;

    // Leitura dos valores das variáveis
    System.out.print("Digite o ID do produto: ");
    idProduto = Integer.parseInt(scanner.nextLine());

    System.out.print("Digite a descrição do produto: ");
    descricao = scanner.nextLine();

    System.out.print("Digite o custo do produto: ");
    vlcusto = Double.parseDouble(scanner.nextLine());

    System.out.print("Digite o preço de venda do produto: ");
    vlvenda = Double.parseDouble(scanner.nextLine());

    System.out.print("Digite a categoria do produto: ");
    categoria = scanner.nextLine();

    // Exemplo de uso da função excluirInformacao
   /* excluirInformacao(idProduto);
    excluirInformacao(descricao);
    excluirInformacao(vlcusto);
    excluirInformacao(vlvenda);
    excluirInformacao(categoria);
*/
    System.out.println("Informações excluídas com sucesso!");
  }

  public static void excluirInformacao(Object informacao) {
    if (informacao instanceof Integer) {
      int valor = (int) informacao;
      valor = 0;
    } 
    else if (informacao instanceof Double) {
      double valor = (double) informacao;
      valor = 0.0;
    } 
    else if (informacao instanceof String) {
      String str = (String) informacao;
      str = "";
    } 
    else {
      System.out.println("Tipo de informação não suportado: " + informacao.getClass().getName());
    }
  }
}