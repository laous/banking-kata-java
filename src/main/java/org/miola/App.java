package org.miola;

import org.miola.models.Account;
import org.miola.models.Client;
import org.miola.models.Operation;
import org.miola.utils.CommandLineTable;
import org.miola.utils.OperationType;

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

        Client client = new Client(1,"Oussama Lamnaouer", "lmnouer59@gmail.com","HAHAHAHA");
        Account account = new Account(1,1,300);
        LinkedList<Operation> operations = new LinkedList<>();

        while(true){
            print(
                    "\nPlease choose an option  :\n"+
                            "1- Show your account informations\n"+
                            "2- Show your recent operations\n"+
                            "3- Make an operation\n"+
                            "4- Exit\n"
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
                    st2.addRow(client.getName(),client.getEmail(), String.valueOf(account.getBalance()));
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
                        OperationType type = OperationType.DEPOSIT;
                        print("Enter the amount: ");
                        float amount = sc.nextFloat();
                        account.setBalance(account.getBalance() + amount);
                    }else if(response.equals("2")){
                        OperationType type = OperationType.DEPOSIT;
                        print("Enter the amount: ");
                        float amount = sc.nextFloat();
                        account.setBalance(account.getBalance() - amount);
                    }
                    break;
                case "4":
                    System.exit(0);
                    break;
                default:
                    print("Unkown action!");
                    break;

            }


        }
    }

    public static void print(String str){
        System.out.println(str);
    }
}
