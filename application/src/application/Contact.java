package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Contact {
    private int id;
    private String nom;
    private String email;

    public Contact(int id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public static List<Contact> getContacts() {
        List<Contact> contacts = new ArrayList<Contact>();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Charger le driver JDBC Oracle
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Établir une connexion à la base de données Oracle
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "ranim");

            // Créer une requête SQL
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM contacts");

            // Récupérer les résultats de la requête et créer des objets Contact correspondants
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String email = rs.getString("email");
                Contact contact = new Contact(id, nom, email);
                contacts.add(contact);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return contacts;
    }
}