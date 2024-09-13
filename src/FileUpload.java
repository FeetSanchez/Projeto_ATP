import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FileUpload {
    public static void uploadFile(String filePath, String fileType) {
        String insertSQL = "INSERT INTO arquivos (nome_arquivo, tipo_arquivo, conteudo) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
             FileInputStream inputStream = new FileInputStream(filePath)) {

            preparedStatement.setString(1, filePath.substring(filePath.lastIndexOf("/") + 1));
            preparedStatement.setString(2, fileType);
            preparedStatement.setBlob(3, inputStream);

            preparedStatement.executeUpdate();
            System.out.println("Arquivo enviado com sucesso!");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        uploadFile("caminho/para/seu/arquivo.pdf", "PDF");
        uploadFile("caminho/para/sua/planilha.xlsx", "Excel");
    }
}
