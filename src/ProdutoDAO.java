package src;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProdutoDAO {
    private Connection connection;

    public ProdutoDAO() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("src/resources/database.properties"));

            String url = props.getProperty("jdbc.url");
            String username = props.getProperty("jdbc.username");
            String password = props.getProperty("jdbc.password");

            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inserirProduto(Produto produto) {
        String sql = "INSERT INTO produtos (tipo, descricao, peso, quantidade, unidade) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, produto.getTipo());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPeso());
            stmt.setInt(4, produto.getQuantidade());
            stmt.setString(5, produto.getUnidade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterarProduto(Produto produto) {
        String sql = "UPDATE produtos SET tipo=?, descricao=?, peso=?, quantidade=?, unidade=? WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, produto.getTipo());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPeso());
            stmt.setInt(4, produto.getQuantidade());
            stmt.setString(5, produto.getUnidade());
            stmt.setInt(6, produto.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirProduto(int id) {
        String sql = "DELETE FROM produtos WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Produto> listarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getString("tipo"),
                        rs.getString("descricao"),
                        rs.getDouble("peso"),
                        rs.getInt("quantidade"),
                        rs.getString("unidade")
                );
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }

    public Produto detalharProduto(int id) {
        String sql = "SELECT * FROM produtos WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Produto(
                            rs.getString("tipo"),
                            rs.getString("descricao"),
                            rs.getDouble("peso"),
                            rs.getInt("quantidade"),
                            rs.getString("unidade")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
