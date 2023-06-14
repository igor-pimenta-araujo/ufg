import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CandidatoRepository {

    private Connection conn;

    public CandidatoRepository() {
        try {
            this.conn = ConnectionDb.buildConnection();
        }
        catch (SQLException e) {
            System.out.println("Failed to connect to database");
        }
    }

    public ArrayList<Candidato> SelectCandidatos() {
        String sql = "SELECT codigo, nome, sexo, data_nasc, cargo_pretendido, texto_curriculo FROM candidato";
        ArrayList<Candidato> candidatos = new ArrayList<>();

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet dbQueryResult = statement.executeQuery();

            while(dbQueryResult.next()) {
                Candidato candidato = new Candidato();
                candidato.setCodigo(dbQueryResult.getInt("codigo"));
                candidato.setNome(dbQueryResult.getString("nome"));
                candidato.setSexo(dbQueryResult.getString("sexo").charAt(0));
                candidato.setDataNasc(dbQueryResult.getDate("data_nasc"));
                candidato.setCargoPretendido(dbQueryResult.getString("cargo_pretendido"));
                candidato.setTextoCurriculo(dbQueryResult.getString("texto_curriculo"));
                candidatos.add(candidato);
            }

            return candidatos;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void InsertCandidato(Candidato candidato) {
        String sql = "INSERT INTO candidato (nome, sexo, data_nasc, cargo_pretendido, texto_curriculo) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, candidato.getNome());
            statement.setString(2, String.valueOf(candidato.getSexo()));
            statement.setDate(3, candidato.getDataNasc());
            statement.setString(4, candidato.getCargoPretendido());
            statement.setString(5, candidato.getTextoCurriculo());
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
