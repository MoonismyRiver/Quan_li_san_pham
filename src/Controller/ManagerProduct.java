package Controller;

import IO.ReadAndWriteProduct;
import Soft.SoftByPrice;
import model.Product;
import validate.Validate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerProduct {
    Scanner scanner = new Scanner(System.in);
    List<Product> arrayProduct = new ArrayList<>();
    Validate validate = new Validate();

    public void menu() {
        System.out.println("__________CHƯƠNG TRÌNH QUẢN LÍ SẢN PHẨM_________");
        System.out.println("Chọn chức năng theo số ( để tiếp tục)");
        System.out.println("1.Xem danh sách.");
        System.out.println("2.Thêm mới.");
        System.out.println("3.Chỉnh sửa.");
        System.out.println("4.Xóa.");
        System.out.println("5.Sắp xếp sản phẩm theo giá từ thấp đến cao.");
        System.out.println("6.Sản phẩm có giá cao nhất.");
        System.out.println("7.Đọc từ file.");
        System.out.println("8.Ghi vào file.");
        System.out.println("9.Thoát");
        System.out.println("Chọn chức năng:");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                showAll();
                break;
            case 2:
                add();
                break;
            case 3:
                editProduct();
                break;
            case 4:
                deleteProduct();
                break;
            case 5:
                softbyPrice();
                break;
            case 6:
                showMostExpensive();
                break;
            case 7:
                arrayProduct = ReadAndWriteProduct.read();
                System.out.println("Đọc thành công !");
                break;

            case 8:
               ReadAndWriteProduct.write(arrayProduct);
                System.out.println("Ghi thành công! ");
                break;
                break;
            case 9:
                System.exit(0);
                break;

        }
    }


    public void showAll() {
        for (int i = 0; i < arrayProduct.size(); i++) {
            if ((i + 1) % 5 == 0) {
                System.out.println(arrayProduct.get(i));
                scanner.nextLine();
            } else {
                System.out.println(arrayProduct.get(i));
            }

        }
    }

    public Product creatProduct() {
        int id = validate.validateID(arrayProduct);
        String name = validate.validateString("name");
        double price = validate.validatePrice();
        int amount = validate.validateAmount();
        return new Product(id, name, price, amount);

    }

    public void add() {
        arrayProduct.add(creatProduct());
    }

    public void editProduct() {
        System.out.println("nhập id cần sửa :");
        int id = scanner.nextInt();
        int index = validate.getIndexId(id,arrayProduct);
        if (index != -1) {
            arrayProduct.set(index, creatProduct());
        } else {
            System.err.println("id không tồn tại !");
        }
    }

    public void deleteProduct(){
        System.out.println("nhập id sản phẩm muốn xóa:");
    }
    public void softbyPrice(){
        arrayProduct.sort(new SoftByPrice());
        System.out.println("sắp xếp thành công !");
        showAll();
    }
    public void showMostExpensive(){

    }



}
