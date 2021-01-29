package file.io;
// Luyện tập đọc file text;

// Đọc file text chứa các số nguyên và tính tổng;

// Cho phép nhập vào đường dẫn file và hiển thị tổng các số chứa trong file;

// Nếu có exception( file không tồn tại/ chứa giá trị không phải số) thông báo lỗi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFileExample {
    // 1. Tạo Hàm đọc file text truyền vào đối số là đường dẫn file mà người dùng nhập vào;
    public void readFileText(String filePath) {
        try {
            //1.1 Đọc file theo đường dẫn;
            File file = new File(filePath);

            //1.2 Kiểm tra nếu file ko tồn taị thì ném ra ngoại lệ;
            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            //1.3 Đọc từng dòng của file và tiến hành cộng tổng lại;
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            br.close();

            //1.4 Hiển thị ra màn hình tổng các số nguyên trong file;
            System.out.println("Sum = " + sum);
        } catch (Exception e) {

            //1.5 Trường hợp file ko tồn taị/ nội dung file có lỗi sẽ hiển thị thông báo lỗi;
            System.out.println("File ko ton tai hoac noi dung co loi !");
        }
    }

    // 2. Tạo Hàm main cho người dùng nhập vào đường dẫn file mong muốn;
    public static void main(String[] args) {
        System.out.println("Nhap duong dan file : ");
        Scanner sc = new Scanner((System.in));

        String path = sc.nextLine();

        ReadFileExample readFileExample = new ReadFileExample();
        readFileExample.readFileText(path);
    }
}
