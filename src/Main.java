package src;

public class Main {
    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();

        // Inserir produtos
        Produto p1 = new Produto("Informática", "Notebook Dell", 2.5, 10, "kg");
        Produto p2 = new Produto("Limpeza", "Detergente", 0.5, 20, "litro");
        Produto p3 = new Produto("Casa & Decoração", "Vaso de Flores", 1.2, 15, "kg");
        Produto p4 = new Produto("Informática", "Mouse Logitech", 0.1, 50, "kg");
        Produto p5 = new Produto("Limpeza", "Sabão em Pó", 2.0, 30, "kg");
        dao.inserirProduto(p1);
        dao.inserirProduto(p2);
        dao.inserirProduto(p3);
        dao.inserirProduto(p4);
        dao.inserirProduto(p5);

        // Alterar produtos
        p1.setDescricao("Notebook Dell Inspiron");
        p4.setDescricao("Mouse Logitech MX Master 3");
        dao.alterarProduto(p1);
        dao.alterarProduto(p4);

        // Excluir produto
        dao.excluirProduto(p3.getId());

        // Listar produtos
        System.out.println("Lista de Produtos:");
        for (Produto produto : dao.listarProdutos()) {
            System.out.println(produto);
        }

        // Exibir detalhes de produtos
        System.out.println("Detalhes do Produto 1:");
        System.out.println(dao.detalharProduto(p1.getId()));

        System.out.println("Detalhes do Produto 2:");
        System.out.println(dao.detalharProduto(p2.getId()));
    }
}
