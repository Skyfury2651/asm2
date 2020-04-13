import java.sql.*;

public class EmployeeModel {
    public boolean register(Employee emp) throws SQLException {
            if (checkExistAccount(emp.getAccount())){
                return false;
            }


        String query = "";
        Connection connection = ConnectionHelper.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO `employees` (`name`, `address`, `email`, `account`, `password`, `createAt`, `updateAt`, `status`) "+
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1,emp.getName());
        preparedStatement.setString(2,emp.getAddress());
        preparedStatement.setString(3,emp.getEmail());
        preparedStatement.setString(4,emp.getAccount());
        preparedStatement.setString(5,emp.getPassword());
        preparedStatement.setDate(6,emp.getCreateAt());
        preparedStatement.setDate(7,emp.getUpdateAt());
        preparedStatement.setInt(8,emp.getStatus());
        preparedStatement.execute();
        return true;
    }

    public boolean checkExistAccount(String account) throws SQLException {
        Statement statement =  ConnectionHelper.getConnection().createStatement();
        ResultSet results = statement.executeQuery("SELECT * FROM employees");
        while (results.next()) {
            if (account.equals(results.getString("account"))){
                System.out.println("Tài khoản đã tồn tại ");
                return true;
            }
        }
        return false;
    }

    public Employee login(String account, String password) throws SQLException {
        Statement statement =  ConnectionHelper.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
        while (resultSet.next()){
            if (account.equals(resultSet.getString("account")) && password.equals(resultSet.getString("password"))){
                PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(
                        "SELECT * FROM `employees` WHERE `account` = ?");
               preparedStatement.setString(1,account);
               ResultSet resultSet1 = preparedStatement.executeQuery();
                resultSet1.next();
                System.out.println(resultSet1.getString("account"));
                System.out.println(resultSet1.getString(2));
                System.out.println(resultSet1.getString(3));
                System.out.println(resultSet1.getString(4));
                System.out.println(resultSet1.getString(5));
                System.out.println(resultSet1.getDate(6));
                System.out.println(resultSet1.getDate(7));
                System.out.println(resultSet1.getInt(8));
            }
        }
        return null;
    }
}
