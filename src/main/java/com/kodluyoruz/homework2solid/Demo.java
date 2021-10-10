package com.kodluyoruz.homework2solid;

import com.kodluyoruz.homework2solid.model.Product;
import com.kodluyoruz.homework2solid.model.Seller;
import com.kodluyoruz.homework2solid.model.cart.Cart;
import com.kodluyoruz.homework2solid.model.cart.CartItem;
import com.kodluyoruz.homework2solid.model.checkout.Bill;
import com.kodluyoruz.homework2solid.model.enums.BillWriterType;
import com.kodluyoruz.homework2solid.service.CheckoutService;
import com.kodluyoruz.homework2solid.service.discount.Buy2Take3Discount;
import com.kodluyoruz.homework2solid.service.discount.Discount;
import com.kodluyoruz.homework2solid.service.discount.PercentageDiscount;
import com.kodluyoruz.homework2solid.service.writer.BillWriter;
import com.kodluyoruz.homework2solid.service.writer.BillWriterFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class Demo implements CommandLineRunner {
    private final Scanner scanner;
    private final CheckoutService checkoutService;
    private final BillWriterFactory billWriterFactory;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Welcome to kodluyoruz shop");
        System.out.println("What’s your name?");

        String customerName = scanner.nextLine();
        System.out.println("Hi " + customerName + ". Please choose one of the following options:");
        System.out.println("");

        Cart cart = new Cart();

        while (true) {
            System.out.println("Enter 1 to buy a product");
            System.out.println("Enter 0 to checkout and proceed with the payment");

            int option = Integer.parseInt(scanner.nextLine());

            if (option == 0) {
                break;
            }

            System.out.print("Product name: ");
            String productName = scanner.nextLine();

            System.out.print("Seller: ");
            String sellerName = scanner.nextLine();


            System.out.print("Price: ");
            int price = Integer.parseInt(scanner.nextLine());
            System.out.print("How many: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            System.out.print("Discount (enter 0 if no discount applies): ");
            double discountAmount = Double.parseDouble(scanner.nextLine());

            System.out.print("Does Buy2Take3 apply? Y/N ");
            boolean isBuy2Take3Applied = isBuy2Take3Applied(scanner.nextLine());

            Seller seller = new Seller(sellerName);
            Product product = Product.builder()
                    .name(productName)
                    .price(price)
                    .build();

            if (discountAmount != 0 && isBuy2Take3Applied) {
                throw new IllegalArgumentException(""); // TODO: 10.10.2021 Mesajı düzenle
            }

            Discount discount = null;
            if (isBuy2Take3Applied) {
                discount = new Buy2Take3Discount();
            } else if (discountAmount != 0) {
                discount = new PercentageDiscount(discountAmount);
            }

            CartItem cartItem = CartItem.builder()
                    .discount(discount)
                    .product(product)
                    .seller(seller)
                    .quantity(quantity)
                    .build();

            cart.addItem(cartItem);
        }

        Bill bill = checkoutService.checkout(cart);

        System.out.println("Please choose a type " + Arrays.toString(BillWriterType.values()));
        BillWriterType type = BillWriterType.valueOf(scanner.nextLine());

        BillWriter billWriter = billWriterFactory.getBillWriter(type);
        billWriter.printBill(bill);

    }

    private boolean isBuy2Take3Applied(String input) {
        return input.equalsIgnoreCase("y");
    }

}
