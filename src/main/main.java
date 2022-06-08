package main;

import Controller.ManagerProduct;

public class main {
    public static void main(String[] args) {
        while (true) {
            ManagerProduct managerProduct = new ManagerProduct();
            managerProduct.menu();
        }
    }
}
