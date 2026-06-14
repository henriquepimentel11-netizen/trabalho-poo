package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL =
        "jdbc:postgresql://dpg-d8bpofd7vvec73c48hp0-a.ohio-postgres.render.com:5432/trabalho_interdisciplinar";

    private static final String USER =
        "trabalho_interdisciplinar_user";

    private static final String PASSWORD =
        "KKj4RuaRg3VnUjKIVaMMs5N7b2auat16";

    public static Connection conectar() {

        try {
            return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
            );

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
