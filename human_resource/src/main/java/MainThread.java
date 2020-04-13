import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class MainThread {
    public static void main(String[] args) throws SQLException {
        boolean loop = true;
         int choose = 0;
        while (loop){
            //Tạo menu
            System.out.println("=====================================");
            System.out.println("=====Chào mừng đến với mục menu======");
            System.out.println("                                     ");
            System.out.println("1.Đăng ký tài khoản                  ");
            System.out.println("2.Đăng nhập                          ");
            System.out.println("3.Thoát                              ");
            System.out.println("                                     ");
            System.out.println("=====================================");
            Scanner scanner = new Scanner(System.in);
            try {
                choose = scanner.nextInt();scanner.nextLine();
            }catch (Exception e)
            {
                System.err.println(e);
                System.err.println("Hãy nhập chữ số trong phạm vi từ 1-3");
            }
            EmployeeModel emp = new EmployeeModel();
            //lựa chọn
            switch(choose) {
                case 1:
                    System.out.println("Bạn đã chọn đăng ký tài khoản");
                    System.out.println("Vui lòng điền đầy đủ thông tin mãu sau");
                    Employee employee = new Employee();

                    System.out.println("Nhập tên của bạn");
                    employee.setName(scanner.nextLine());

                    System.out.println("Nhập email của bạn");
                    employee.setEmail(scanner.nextLine());

                    System.out.println("Nhập địa chỉ của bạn");
                    employee.setAddress(scanner.nextLine());


                    System.out.println("Nhập tên tài khoản");
                    employee.setAccount(scanner.nextLine());

                    System.out.println("Nhập mật khẩu");
                    employee.setPassword(scanner.nextLine());

                    employee.setCreateAt(Date.valueOf(LocalDate.now()));
                    employee.setUpdateAt(Date.valueOf(LocalDate.now()));
                    System.out.println("Nhập trạng thái");
                    employee.setStatus(scanner.nextInt());
                    scanner.nextLine();
                    emp.register(employee);
                    System.out.println("\n\n\n\n\n\n");
                    System.out.println("Bạn có muống tiếp tục ?");
                    System.out.println("1-Tiếp tục");
                    System.out.println("2-Thoát");
                    choose = scanner.nextInt();scanner.nextLine();
                    switch (choose){
                        case 1:
                            loop = true;
                            break;
                        default:
                            System.out.println("Cảm ơn đã sử dụng dịch vụ của chúng tôi và hẹn gặp lại");
                            loop = false;
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Bạn đã chọn đăng nhặp");
                    System.out.println("Vui lòng nhập tên tài khoản");
                    String acc = scanner.nextLine();
                    System.out.println("Vui lòng nhập mật khẩu");
                    String pwd = scanner.nextLine();
                    emp.login(acc,pwd);
                    System.out.println("\n\n\n\n\n\n");
                    System.out.println("Bạn có muống tiếp tục ?");
                    System.out.println("1-Tiếp tục");
                    System.out.println("2-Thoát");
                     choose = scanner.nextInt();scanner.nextLine();
                     switch (choose){
                         case 1:
                             loop = true;
                             break;
                         default:
                             System.out.println("Cảm ơn đã sử dụng dịch vụ của chúng tôi và hẹn gặp lại");
                             loop = false;
                             break;
                     }
                    break;
                case 3:
                    System.out.println("Cảm ơn đã sử dụng dịch vụ của chúng tôi và hẹn gặp lại");
                    loop = false;
                    break;
                default:
                    System.out.println("Xin hãy chọn tử tế :)");
                    break;
            }

        }
    }
}
