/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weekB2;

import java.util.Scanner;

/**
 *
 * @author christopher.eckles
 */
public class PointOfSaleSystem {

    //tax in allegheny county
    private static final double TAX = .07;

    //beginning inventroy
    private static int numPizzaDoughOnHand = 40;
    private static int numBurgerPattiesOnHand = 100;
    private static int numCheeseSlicesOnHand = 100;
    private static int numLettuceOnHand = 20;

    //track ordering of items
    private static int numBurgersOrdered = 0;
    private static int numCheeseBurgersOrdered = 0;
    private static int numPizzasOrdered = 0;
    private static int numSaladsOrdered = 0;

    //prices
    private static double burgerPrice = 1.25;
    private static double cheeseBurgerPrice = 2.50;
    private static double pizzaPrice = 1.50;
    private static double saladPrice = .75;

    //cost of an order
    private static double totalCost = 0;

    //total revenue for the register's instance
    private static double totalRevenue = 0;

    public static void main(String[] args) {
        orderItems();
        System.out.println("Exiting Program.");
    }//close main

    public static void orderItems() {
        int choice = 0;
        int quantity = 0;
        while (choice != 9) {
            Scanner inputScanner = new Scanner(System.in);

            //tell user the options
            System.out.println("Order");
            System.out.println("1 - Pizza");
            System.out.println("2 - Hamburger");
            System.out.println("3 - Double Cheeseburger");
            System.out.println("4 - Salad");
            System.out.println("7 - ViewCart");
            System.out.println("8 - Checkout");
            System.out.println("10 - View Inventory");
            System.out.println("9 - To Exit");

            System.out.print("Type your choice and press enter: ");
            //get integer from user
            try {
                choice = inputScanner.nextInt();
                quantity = 0;
            } catch (Exception e) {
                choice = 0;

            }
            if (choice < 7) {
                Scanner inputScanner2 = new Scanner(System.in);

                System.out.print("(Hint: A negative quantity will remove items already added.) \n "
                        + "How many? ");
                //get integer from user
                try {
                    quantity = inputScanner2.nextInt();

                } catch (Exception e) {
                    choice = 0;
                }
            }
            switch (choice) {
                case 1:
                    orderPizza(quantity);
                    break;
                case 2:
                    orderBurger(quantity);
                    break;
                case 3:
                    orderCheeseBurger(quantity);
                    break;
                case 4:
                    orderSalad(quantity);
                    break;
                case 7:
                    viewCart();
                    break;
                case 8:
                    checkOut();
                    break;
                case 9:
                    break;
                case 10:
                    checkInventory();
                    break;

                default:
                    System.out.println("No valid input..");
                    choice = 0;
            }
            //sleep for 2 seconds
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Interuppted Exception: " + e);
            }
            System.out.println("\n\n\n");
        } //end while

    }//close orderItems

    private static void orderPizza(int quantity) {
        if (0 <= (numPizzaDoughOnHand - quantity)) {
            System.out.println("Ordering " + quantity + " Pizza" + ((quantity != 1) ? "s" : ""));
            if ((numPizzasOrdered + quantity) >= 0) {
                numPizzasOrdered = numPizzasOrdered + quantity;
                numPizzaDoughOnHand = numPizzaDoughOnHand - quantity;
            }
        } else {
            System.out.println("Not enough dough on hand to add this item");
            if (numPizzaDoughOnHand > 0) {
                System.out.println("Order a smaller quantity");
            }
        }

    }//close orderPizza

    private static void orderBurger(int quantity) {
        if (0 <= numBurgerPattiesOnHand - quantity) {
            System.out.println("Ordering " + quantity + " Burger" + ((quantity != 1) ? "s" : ""));
            if ((numBurgersOrdered + quantity) >= 0) {
                numBurgersOrdered = numBurgersOrdered + quantity;
                numBurgerPattiesOnHand = numBurgerPattiesOnHand - quantity;
            }
        } else {
            System.out.println("Not enough patties on hand to add this item");
            if (numBurgerPattiesOnHand > 0) {
                System.out.println("Order a smaller quantity");
            }
        }

    }//close orderBurger

    private static void orderSalad(int quantity) {
        if (0 <= numLettuceOnHand - quantity) {
            System.out.println("Ordering " + quantity + " Salad" + ((quantity != 1) ? "s" : ""));
            if ((numSaladsOrdered + quantity) >= 0) {
                numSaladsOrdered = numSaladsOrdered + quantity;
                numLettuceOnHand = numLettuceOnHand - quantity;
            }
        } else {
            System.out.println("Not enough lettuce on hand to add this item");
            if (numBurgerPattiesOnHand > 0) {
                System.out.println("Order a smaller quantity");
            }
        }
    } //close orderSalad

    private static void orderCheeseBurger(int quantity) {
        if (0 <= numBurgerPattiesOnHand - (quantity * 2) && 0 <= numCheeseSlicesOnHand - (quantity * 2)) {
            System.out.println("Ordering " + quantity + " CheeseBurger" + ((quantity != 1) ? "s" : ""));
            if ((numCheeseBurgersOrdered + quantity) >= 0) {
                numCheeseBurgersOrdered = numCheeseBurgersOrdered + quantity;
                numBurgerPattiesOnHand = numBurgerPattiesOnHand - (quantity * 2);
                numCheeseSlicesOnHand = numCheeseSlicesOnHand - (quantity * 2);
            }
        } else {
            System.out.println("Not enough patties or cheese on hand to add this item");
            if (numBurgerPattiesOnHand > 1 && numCheeseSlicesOnHand > 1) {
                System.out.println("Order a smaller quantity");
            }
        }

    } //close orderCheeseburger

    private static void viewCart() {
        totalCost = 0;
        if (numPizzasOrdered > 0) {
            printLineItem("Pizza", numPizzasOrdered, pizzaPrice);
        }
        if (numBurgersOrdered > 0) {
            printLineItem("Burger", numBurgersOrdered, burgerPrice);
        }
        if (numCheeseBurgersOrdered > 0) {
            printLineItem("Cheeseburger", numCheeseBurgersOrdered, cheeseBurgerPrice);
        }
        if (numSaladsOrdered > 0) {
            printLineItem("Salad", numSaladsOrdered, saladPrice);
        }
        System.out.println("Subtotal: $" + totalCost);

    } // close viewCart

    private static void checkOut() {
        System.out.println("******************************");
        System.out.println("******Every Pizza Place*******");
        viewCart();
        totalCost = totalCost * (1 + TAX);
        totalRevenue = totalRevenue + totalCost;
        System.out.println("Total with Tax: $" + totalCost);
        System.out.println("******************************");

        System.out.println("Thank You Come Again!!");
        clearCart();
        System.out.println("");
        System.out.println("Just so you know...");
        checkInventory();
        System.out.println("******************************");

        System.out.println("Next customer Please!");
    } //close checkOut

    private static void clearCart() {
        numBurgersOrdered = 0;
        numCheeseBurgersOrdered = 0;
        numPizzasOrdered = 0;
        numSaladsOrdered = 0;
        totalCost = 0;
    } //close clear cart

    private static void printLineItem(String item, int quantity, double cost) {
        System.out.println(quantity + " " + item + ((quantity != 1) ? "s" : "") + " @ $" + cost);
        totalCost = totalCost + (cost * quantity);
    } //close printLineItem

    private static void checkInventory() {
        System.out.println("******************************");
        printInventoryItem("Pizza Dough", numPizzaDoughOnHand);
        printInventoryItem("Burger", numBurgerPattiesOnHand);
        printInventoryItem("Cheese Slice", numCheeseSlicesOnHand);
        printInventoryItem("Lettuce Serving", numLettuceOnHand);
        System.out.println("******************************");

    } //close checkInventory

    private static void printInventoryItem(String item, int quantity) {
        System.out.print(quantity + " " + item + ((quantity != 1) ? "s" : "") + " remaining");
        if (quantity == 0) {
            System.out.println(" <-- You're out! Time to order more");
        } else if (quantity < 20) {
            System.out.println(" <-- Time to order more!");
        } else {
            System.out.println("  <-- You should have enough!");
        }

    }//close printInventoryItem

}//close PointOfSaleSystem
