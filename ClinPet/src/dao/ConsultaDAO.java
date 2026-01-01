package dao;

import connection.ConnectionFactory;
import model.Consulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ConsultaDAO {

    // ===============================
    // SALVAR CONSULTA
    // ===============================
    public void salvar(Consulta c) {

        String sql = """
            INSERT INTO consulta
            (dataHora, tutor, pet, medico, descricao)
            VALUES (?, ?, ?, ?, ?)
        """;

        try (
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, c.getDataHora());
            ps.setString(2, c.getNomeTutor());
            ps.setString(3, c.getNomePet());
            ps.setString(4, c.getNomeMedico());
            ps.setString(5, c.getObservacoes());

            ps.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Erro ao salvar consulta:\n" + e.getMessage());
        }
    }

    // ===============================
    // LISTAR CONSULTAS
    // ===============================
    public List<Consulta> listar() {

        List<Consulta> lista = new ArrayList<>();

        String sql = """
            SELECT idConsulta, dataHora, tutor, pet, medico, descricao
            FROM consulta
            ORDER BY dataHora
        """;

        try (
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {
                Consulta c = new Consulta();

                c.setIdConsulta(rs.getInt("idConsulta"));
                c.setDataHora(rs.getString("dataHora"));
                c.setNomeTutor(rs.getString("tutor"));
                c.setNomePet(rs.getString("pet"));
                c.setNomeMedico(rs.getString("medico"));
                c.setObservacoes(rs.getString("descricao"));

                lista.add(c);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Erro ao listar consultas:\n" + e.getMessage());
        }

        return lista;
    }

    // ===============================
    // EXCLUIR CONSULTA
    // ===============================
    public void excluir(int idConsulta) {

        String sql = "DELETE FROM consulta WHERE idConsulta = ?";

        try (
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setInt(1, idConsulta);
            ps.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Erro ao excluir:\n" + e.getMessage());
        }
    }
}