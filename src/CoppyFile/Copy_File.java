package CoppyFile;

// Luyện tập đọc/ghi file text với các lớp Reader/Writer;

// Viết chương trình cho phép người dùng sao chép các tập tin;

// Người sử dụng phải cung cấp 1 tập tin nguồn(source file)/đích(target file);

// Cho phép tập nguồn vào tệp đích và hiển thị số ký tự trong tệp;

// Cảnh báo nếu tệp nguồn ko tồn tại/ tệp đích đã tồn tại;

import java.io.*;
import java.util.Scanner;

public class Copy_File {
    // 1.1. Hàm đọc file(tham so 1 duong dan) và ném ra lỗi (nếu có);
    public static String readFile(String filePath) throws FileNotFoundException {
        File inFile = new File(filePath);

        FileReader reader = new FileReader(inFile);

        BufferedReader bufferedReader = new BufferedReader(reader);
        try {
            String data = bufferedReader.readLine();
            bufferedReader.close();
            return data;
        } catch (IOException e) {
            // 1.2. Gọi Hàm printStackTrace() thông báo lỗi đầu nguồn;
            e.printStackTrace();
            return "Error";
        }
    }

    // 2.1. Hàm viết file(tham số là đường dẫn, file input);
    public static void writeFile(String filePath, String data) throws IOException{
        FileWriter fileWriter = new FileWriter(filePath);

        BufferedWriter bWriter = new BufferedWriter(fileWriter);

        try {
            bWriter.write(data);

            // Đóng file để tối ưu bộ nhớ;
            bWriter.close();
        } catch (IOException e) {

            // 2.2. Gọi Hàm printStackTrace() thông báo lỗi đầu nguồn;
            e.printStackTrace();
        }
    }

    // 3. Hàm main throws IOEx(nếu có);
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

        // 3.1. Nhập vào file dẫn;
        System.out.println("Enter origin file path: ");
        String fileReadPath = sc.nextLine();

        // 3.2. Đọc file dẫn;
        String inputToCopy = readFile(fileReadPath);

        // 3.3. Lưu file đã đọc vào file mới;
        System.out.println("Enter destination file path: ");
        String fileDestinationPath = sc.nextLine();

        writeFile(fileDestinationPath, inputToCopy);

        sc.close();

    }
}
