import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. Step: Registration to the driver (driver yukle)
        Class.forName("org.postgresql.Driver");

        //2. Step: Create connection with database  (baglanti olustur)
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres", "postgres", "Keret27");

        //3. Step: Create statement
        Statement st = con.createStatement();

        //4. Step: Execute the query
        /*
         execute() method can be used in DDL(Table creation, drop table, alter table) and DQL(Select,sorgulama)
         1)If you use execute() method in DDL you will get false everytime.
         2)If you use execute() method in DQL you will get false or true
          When you use execute() method in DQL, if you get ResultSet Object as return you will get true
          otherwise you will get false.
         */

        //1.Example: Create a workers table with the columns worker_id,worker_name, worker_salary
        String sql1 = "CREATE TABLE workers(worker_id VARCHAR(50), worker_name VARCHAR(20), worker_salary INT )";
        boolean sqlResult = st.execute(sql1);
        System.out.println(sqlResult);

        //2.Example: Alter table by adding worker_address column into the workers table
        String sql2 = "ALTER TABLE workers ADD worker_address VARCHAR(80)";
        st.execute(sql2);

        //3. Example: Drop the table
        String sql3 = "DROP TABLE workers";
        st.execute(sql3);

        //5. Step: Close the connection and statement
        con.close();
        st.close();
    }
}
import java.sql.*;

public class ExecuteQuery02 {

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

            }}}

