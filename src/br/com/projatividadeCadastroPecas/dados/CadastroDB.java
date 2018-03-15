
package br.com.projatividadeCadastroPecas.dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projatividadeCadastroPecas.entidade.Cadastro;
import br.com.projatividadeCadastroPecas.util.Conexao;

public class CadastroDB {

	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;

	public CadastroDB() {
		connection = Conexao.getConnection();
	}

	public boolean inserir(Cadastro cadastro) throws SQLException {

		try {

			PreparedStatement stmt = this.connection
					.prepareStatement("INSERT INTO AGENDA (id,nome,peso,tipo,datacadastro,valor) values (?, ?)");

			stmt.setInt(1, cadastro.getId());
			stmt.setString(1, cadastro.getNome());
			stmt.setDouble(2, cadastro.getPeso());
			stmt.setString(1, cadastro.getTipo());
			stmt.setString(1, cadastro.getDatacadastro());
			stmt.setDouble(1, cadastro.getValor());

			stmt.execute();
			return true;

		} catch (SQLException e) {
			System.err.println(e.toString());
		} finally {

			connection.close();

		}
		return false;
	}
	
	public boolean alterar(Cadastro cadastro) throws SQLException {

		try {

			PreparedStatement stmt = this.connection
					.prepareStatement("UPDATE AGENDA SET nome = ?, telefone = ? WHERE codigo = ?");

			stmt.setInt(1, cadastro.getId());
			stmt.setString(1, cadastro.getNome());
			stmt.setDouble(2, cadastro.getPeso());
			stmt.setString(1, cadastro.getTipo());
			stmt.setString(1, cadastro.getDatacadastro());
			stmt.setDouble(1, cadastro.getValor());
            
			stmt.execute();
			return true;

		} catch (SQLException e) {
			System.err.println(e.toString());
		} finally {

			connection.close();

		}
		return false;
	}

	public List<Cadastro> getAll() {

		List<Cadastro> lstCadastro = new ArrayList<>();
		try {
			ps = this.connection.prepareStatement("SELECT codigo, nome, telefone FROM AGENDA");
			rs = ps.executeQuery();

			while (rs.next()) {
				lstCadastro.add(new Cadastro(rs.getInt("id"), rs.getString("nome"), rs.getDouble("peso"),rs.getString("tipo"), rs.getString("datacadastro"), rs.getDouble("valor")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lstCadastro;
	}
	
	public boolean excluir(int codigo) throws SQLException {

		try {

			PreparedStatement stmt = this.connection
					.prepareStatement("DELETE FROM AGENDA WHERE CODIGO =?");

			stmt.setInt(1, codigo);

			stmt.execute();
			return true;

		} catch (SQLException e) {
			System.err.println(e.toString());
		} finally {

			connection.close();

		}
		return false;
	}
}

