package org.miola;

import org.miola.models.Account;
import org.miola.models.Client;
import org.miola.models.Operation;
import org.miola.services.AccountService;
import org.miola.services.OperationService;
import org.miola.utils.CommandLineTable;
import org.miola.utils.OperationType;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc=new Scanner(System.in);

//        Client client = new Client(1,"Oussama", "lmnouer59@gmail.com");


        print("Enter your email");
        String email = sc.nextLine();
        print("Enter your password");
        String password = sc.nextLine();

        Client client = AccountService.login(email,password);

        if(client == null){
            print("Client not found!");
            System.exit(0);
        }

        Account account = AccountService.getAccountByClientId(client.getId());
        LinkedList<Operation> operations = OperationService.getAllOperations();

        while(true){
            print(
                    "\nPlease choose an option  :\n"+
                            "1- Show your account informations\n"+
                            "2- Show your recent operations\n"+
                            "3- Make an operation\n"+
                            "4- Exit"
            );

            String received = sc.nextLine();

            switch(received){
                case "1":
                    CommandLineTable st = new CommandLineTable();
                    st.setShowVerticalLines(true);
                    st.setHeaders("Name", "Email","Account Number" , "Balance");
                    st.addRow(client.getName(),client.getEmail(),String.valueOf(account.getId()), String.valueOf(account.getBalance()));
                    st.print();
                    break;
                case "2":
                    CommandLineTable st2 = new CommandLineTable();
                    st2.setShowVerticalLines(true);
                    st2.setHeaders("Operation", "Amount", "Date");
                    for(Operation op:operations){
                        st2.addRow(String.valueOf(op.getType()), String.valueOf(op.getAmount()), String.valueOf(op.getCreatedAt()));
                    }
                    st2.print();

                    break;
                case "3":
                    print(
                            "\nWhat kind of operation would you like to make?\n"+
                                    "1- Deposit\n"+
                                    "2- Withdraw\n"+
                                    "3- Return back\n"
                    );

                    String response = sc.nextLine();
                    if(response.equals("1")){
                        String type = "DEPOSIT";
                        print("Enter the amount: ");
                        float amount = sc.nextFloat();
                        Operation operation = new Operation(1,1,1,type,amount,String.valueOf(LocalDate.now()));
                        if(OperationService.deposit(operation , account.getBalance())){
                            account.setBalance(account.getBalance() + amount);
                            operations.add(operation);
                            print("Action performed successfully!");
                        }else {
                            print("An error has occured! Please try again!");
                        }
                    }else if(response.equals("2")){
                        String type = "WITHDRAW";
                        print("Enter the amount: ");
                        float amount = sc.nextFloat();
                        Operation operation = new Operation(1,1,1,type,amount,String.valueOf(LocalDate.now()));
                        if(OperationService.withdraw(operation , account.getBalance())){
                            account.setBalance(account.getBalance() - amount);
                            operations.add(operation);
                            print("Action performed successfully!");
                        }else {
                            print("An error has occured! Please try again!");
                        }
                    }
                    break;
                case "4":
                    System.exit(0);
                    break;

            }


        }
    }

    public static void print(String str){
        System.out.println(str);
    }
}
