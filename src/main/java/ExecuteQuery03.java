import java.sql.*;

public class ExecuteQuery03 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres","postgres","Keret27");
        Statement st = con.createStatement();

        //1.Example: Find the company and number_of_employees whose number_of_employees is the second highest from the companies table
        //1. Way: By using OFFSET and FETCH NEXT
        String sql1 = "SELECT company, number_of_employees FROM companies ORDER BY number_of_employees DESC OFFSET 1 ROW FETCH NEXT 1 ROW ONLY";

        ResultSet resultSet1 = st.executeQuery(sql1);

        while (resultSet1.next()){

            System.out.println(resultSet1.getString("company")+"--"+resultSet1.getInt("number_of_employees"));
        }
    }
}

