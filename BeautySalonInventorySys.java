import java.util.*;//import that is applicable to all objects

/**
 * 
 * @author Chiska
 */
public class BeautySalonInventorySys {//public class
    public static void main(String[] args) {//MAIN METHOD of the program
        //non static method so that it can only be specific to an object
        BeautySalonInventorySys ns=new BeautySalonInventorySys();
        Scanner in=new Scanner (System.in);//calling out the scanner 
        //attributes for ArrayList and LinkedList
        LinkedList <Integer> productID = new LinkedList<>();//LinkedList for Product ID 
        LinkedList <String> productName = new LinkedList<>();// and prduct Name for easy adding and removing elements
        /*the rest of the objects are in ArrayList since it is faster to use for retrieving and accessing elements*/
        ArrayList <String> category = new ArrayList<>();//ArrayList for category/despcription of an item
        ArrayList <Double> unitPrice = new ArrayList<>();//ArrayList for the price per piece/unit of an item that only accepts double values
        ArrayList <Integer> quantity = new ArrayList<>();//ArrayList for the number of item(s)
        ArrayList <String> dateCreatedOn = new ArrayList<>();//array list of date created or the specific date when a new inventory item was first added to the system
        ArrayList <String> status = new ArrayList<>();//ArrayList for the current state of a particular item in stock
        //global initialization for variables
        int choose;// this will be the variable for the user input in the menu
       
        do {//first do while loop
            //menu section
            choose = ns.displayMenu(in);//non static method of Menu that will be repeatedly show once the execution of 1-4/default cases is done
            //it has a return value of integer which will be inputted by the user 
            
            switch (choose){//first switch for easy access to the menu
                // Standard switch syntax for compatibility with Java 8+
                //switch will execute different blocks of code based on the value that the user typed
                case 1://case 1: method for adding new elements inside the attributes of the arrayList and linklist
                    ns.addNewItem(productID, productName, category, unitPrice, quantity, dateCreatedOn, status, in);/* to input new 
                    elements in the list, the actual parameter has the ff. attributes*/
                    break;//end of case 1
                case 2://case 2: method for removing elements inside attributes of the ArrayList and linklist
                    ns.removeItem(productID, productName, category, unitPrice, quantity, dateCreatedOn, status, in);/* to remove  
                    elements in the list, the actual parameter has the ff. attributes*/
                    break;//end of case 2
                case 3://cCase 3: method for udapting an item based on the user's desire 
                    ns.updateAnItem(productID, productName, category, unitPrice, quantity, dateCreatedOn, status, in);/* to remove  
                    elements in the list, the actual parameter has the ff. attributes in order for the user  to update an element w/o
                    modifying other attributes*/
                    break;//end of case 3
                case 4://Case 4: method for search an item based on product ID
                    ns.searchAnItem(productID, productName, category, unitPrice, quantity, dateCreatedOn, status, in);/* to search an  
                    element in the list, the actual parameter has the ff. attributes*/
                    break;//end of case 4
                case 5://if the user inputted 5 in the menu section
                    System.out.println("Exiting The Program...");//to the tell the user the execution is done
                    break;//end of case 5
                default://if the user type a wrong value it will excute this program
                    System.out.println("-------------------------------------------------------------");//border
                    System.out.println("Invalid choice! Please try again.");//telling the user that 
                    System.out.println("-------------------------------------------------------------");//border
                    break;//end of default value
            }//end of first switch method
        } while (choose!=5);//end of first do while loop. Loop continues until user chooses to exit if and only if the user input number 5
    }//end of MAIN METHOD
    
    public int displayMenu(Scanner in){//non-static method for DISPLAY MENU that has the return type of integer
        // Method to display the menu and get user's choice
        int choose;//global initialization
        System.out.println("*********** ARMAN'S BEAUTY SALON INVENTORY SYSTEM ***********");//introduction on what is this program for 
        System.out.println("\t\t1. Add New Product\n\t\t2. Remove Product\n\t\t3. Update Product\n\t\t4. Search a Product\n\t\t5. Log Out");/*this will help
        the user to decide on what action they will perform*/
        System.out.println("*************************************************************");//border design
        System.out.print("Enter Number of your Choice: ");
        choose=in.nextInt();//user input that accepts integer value only
        return choose;//it will return the inputted value by the user
    }//end of non-statis DISPLAY MENU
    
    // Method to add a new item to the inventory
    public void addNewItem(LinkedList id, LinkedList name, ArrayList cg, ArrayList price, ArrayList qty,
    ArrayList date, ArrayList stat,Scanner in){/*non-static method for ADDING NEW ITEM in the array list and linked list. 
        in order for the list to have an elements, the attributes is called out in the formal paramter with its corresponding
        data structures*/
        //variables that will be helpful for the user's input as well as adding it to the list of data structure
        int productID, quantity;//integers variables that only accepts coutanble numbers
        double php;//double variables that accepts numbers with decimal, especially the price part
        String pName, category, dateReceived, action;//String variables tfor easy storing information
        char confirm=' ';//characters variables for confirmation
        
        do {//first do while loop which will help the user to input new elements if they type it wrong previously
            // allows user to retry entering data if necessary
            System.out.println("*************************************************************");//border that will seperate from the last action or the menu
            System.out.println("--- ADD NEW ITEM/PRODUCT ---");//start of adding new products
            System.out.print("Enter Product ID: ");//section where it tells the user to add new product ID
            productID=in.nextInt();//where the user will input the number of product ID
            
            if (id.contains(productID)) {/*if the user type a product ID that is already taken
                to an existing product ID, the code will print inside the if statement*/
                System.out.println("This Product ID is already taken");/*telling the user to try again typing new product ID
                that is not similar to an existing product ID, unless the previous product ID has been modified or change*/
                //this is the notice for the user, they can not put another similar ID because it mostly likely the program only search for the first occurance
            }//end of first if statement
            
            else {/*if the if statement is not satisfied, it will execute this else statement, wherein, the user can
                continue inputting the following information that is needed*/
                System.out.print("Enter Product Name: ");//informing the user to input the product name
                pName=in.nextLine();//there are some instances that the program go to the next line without the user's input
                pName=in.nextLine();//user's input that only accepts string values
                System.out.print("Enter Category: ");//informing the user to input the category for the product
                category=in.nextLine();//user's input that only accepts string values
                System.out.print("Enter Unit Price (PHP): ");//infroming the user to input the price/unit of the product
                php=in.nextDouble();//user's input that only accepts double values
                System.out.print("Enter Quantity: ");//infroming the user to input the quantity of the product
                quantity=in.nextInt();//user's input that only accepts integer values
                System.out.print("Enter Date Created On: ");//infroming the user to input the date that the item was received or added in the system
                dateReceived=in.nextLine();//user's input that only accepts string values
                dateReceived=in.nextLine();//line of code to avoid getting nto the next line without the input of the user
                System.out.print("Enter Status(in stock/low stock/out of stock/pending delivery): ");//informing the user to input the status of the product based on the label given
                action=in.nextLine();//user's input that only accepts string values
                System.out.println("*************************************************************");//end of inputting product's information
                System.out.println("-------------------------------------------------------------");//border
                /*once the user is done inputting all the required information, the system will print these information
                on what exatcly they have written, just like a receipt*/
                // Display confirmation details
                System.out.println("Product ID: "+productID);// it will show first the product ID
                System.out.println("Product Name: "+pName+"\t\t\tCategory: "+category);//product name and category
                System.out.println("Unit Price: PHP "+php+"\t\t\tQuantity: "+quantity);//price of the product and its quantity
                System.out.println("Created On: "+dateReceived+"\t\t\tStatus: "+action);//date is created on and status of the product
                
                // Ask for confirmation
                System.out.print("Confirm the product information above(Y/N): ");/*the system will now ask the user if the information
                they stored is correct by putting 'Y' or 'N' in the user's input*/
                confirm=in.next().toUpperCase().charAt(0);// this will determine if the whether the user/s are satisfied in what they typed

                if (confirm =='Y') {//once the userr inputted 'Y' in the confirmation:
                    //1. it will print out that the user have succesfully added the new elements in the linkedlist and arraylist
                    System.out.println("-------------------------------------------------------------");//border:)
                    System.out.println("Item Added Successfully!");//informing the user that they are done 
                    System.out.println("-------------------------------------------------------------");
                    //2. process of adding the information inputted by the user in the attributes of ArrayList and LinkedList respectively
                    id.add(productID); name.add(pName);//LinkedList items
                    cg.add(category); price.add(php); qty.add(quantity); date.add(dateReceived);stat.add(action);//arrayList items
                }
                else {//else if the user inputted 'N' or random character in the confirmation:
        //          1. it will print out that the new elements will be failed to be added in linkedlist and arraylist 
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Item is not added. Please try again.");//informing the user that they can retry again inputting an information
                    System.out.println("-------------------------------------------------------------");
                }//2. instead it will loop again
            }//end of the first else statement
        
        } while (confirm!='Y');//end of first do while loop
        // Loop continues until user chooses to exit
        //the do while loop will only stop if the user type 'Y', it is the confirmation that they are done and satisfied w/ the info they typed

        System.out.println("*************************************************************");//border
    }//end of non static method of adding new items/products in the list 
    
    public void removeItem(LinkedList id, LinkedList name, ArrayList cg, ArrayList price, ArrayList qty,
    ArrayList date, ArrayList stat,Scanner in){/*non-static method for REMOVING ITEM in the array list and linked list. 
        in order for the list to remove an elements, the attributes is called out in the formal parameter with its corresponding
        data structures*/
        //variables that will be helpful for the user's input as well as removing it to the list of data structure using the index
        int item, deleteIndex;//integer variables. wherein, item is use for finding the product ID 
        char confirm;//charater value for confirmation 
        
        System.out.println("*************************************************************");//border
        System.out.print("Enter Product ID to be Deleted: ");//informing the user on what product ID to delete
        item=in.nextInt();
        deleteIndex=id.indexOf(item);//while deleteIndex is use for allocating the index of that specific product ID (item)
        
        if (id.contains(item)) {//first if statement
            System.out.println("Product ID "+item+" is on the list");//telling the user the user that they id they are looking for is on the linkedlist
            System.out.println("--- ITEM INFORMATION ---");//item information on what they input in the menu 1
            System.out.println("Product ID: "+id.get(deleteIndex));//product ID and its corressponding information
            System.out.println("Product Name: "+name.get(deleteIndex)+"\t\tCategory: "+cg.get(deleteIndex));//name of the product and its category
            System.out.println("Unit Price: PHP "+price.get(deleteIndex)+"\t\tQuantity: "+qty.get(deleteIndex));//price of the product and its quantity
            System.out.println("Created On: "+date.get(deleteIndex)+"\t\t\tStatus: "+stat.get(deleteIndex));//date is created on and status of the product
            System.out.println("-------------------------------------------------------------");//second border
            System.out.print("Do you wish to permanently delete this item from the list? (Y/N): ");//confirmation if the user's want to delete the specfic product ID they input 
            confirm=in.next().toUpperCase().charAt(0);//user's input of 'Y' and 'N'
            
            if (confirm=='Y') {//second if statement
                System.out.println("-------------------------------------------------------------");//border
                System.out.println("The Product ID of "+item+" is successfully removed from the list!");// telling the user the product ID and its infomation now deleted entirely from the list
                //process of removing the ID and its information
                id.remove(deleteIndex); name.remove(deleteIndex); //removal of id and product name in the linkedList
                cg.remove(deleteIndex);price.remove(deleteIndex); qty.remove(deleteIndex); date.remove(deleteIndex); stat.remove(deleteIndex);//removal of cetagory, price, date, and status from ArrayList
            }//end of second if statement 
            else {//else statement inside the first if statement
                System.out.println("The Product ID of "+item+" is removed unsuccessfully");/*this tells the user that
                the product ID is not removed and it is still in the list if they input 'N' or random character in the program*/
            }//end of else statementr
           
        }//end of first if statement
        else{//first else statement
            System.out.println("-------------------------------------------------------------");//border
            System.out.println("The Product ID of "+item+"  can not be found on the list!");/*this will tell the user that the 
            product ID they are looking for is not on the list*/
        }//end of first else statement
         System.out.println("-------------------------------------------------------------");//end of seconf border
         System.out.println("*************************************************************");//end of first border, indicating they are done in case 2
    }//end of non-static method for REMOVING ITEM
    
    public void updateAnItem(LinkedList id, LinkedList name, ArrayList cg, ArrayList price, ArrayList qty,
    ArrayList date, ArrayList stat,Scanner in){/*non-static method for UPDATING AN ITEM of the specific attributes in the array list and linked list. 
        in order for the list to update an elements, the attributes is called out in the formal parameter with its corresponding
        data structures*/
        BeautySalonInventorySys ns=new BeautySalonInventorySys();//adding object for non-statis method for displaying Menu
        int itemID, update;//integer variables. wherein,these will be used in finding the product ID and index of that product ID
        char choose;//char variables for the usere to choose
        //variables for user input to make changes in their elements
        int newID, quantity;//integer variables for inputting new integers in ID and quantity of the product
        double php;//double variables for updating new decimal price of the product
        String pName, cat, created, status;//String variables for inputting change product name, category, status or to change the date
        
        System.out.println("*************************************************************");//border
        System.out.print("Enter Product ID to update: ");//the program will asked the user on what the product they want to change
        itemID=in.nextInt();// the user then will input on what product ID they want to update
        update=id.indexOf(itemID);//update variable will hold the index of that specific product id that the user want to change
        
        
        if (id.contains(itemID)) {//first if statement
            System.out.println("-------------------------------------------------------------");//border
            System.out.println("--- ITEM INFORMATION ---");/*once the program finds the product ID that the user
            is looking for, it will automatically present to the user the information about that specific product*/
            System.out.println("Item ID: "+id.get(update));//product ID and its corressponding information
            System.out.println("Product Name: "+name.get(update)+"\t\t\tCategory: "+cg.get(update));//name of the product and its category
            System.out.println("Unit Price: PHP "+price.get(update)+"\t\t\tQuantity: "+qty.get(update));//price of the product and its quantity
            System.out.println("Created On: "+date.get(update)+"\t\t\tStatus: "+stat.get(update));//date is created on and status of the product
            System.out.println("-------------------------------------------------------------");//border
            
            do {//first do while loop
                /*do while loop will present the menu and the attributes of the lists again and again. It has the purpose to help the users
                user to take their time in updating their items, until they are fully satisfied on what they input*/
                choose=ns.displayMenuToUpdate();/*the program will then present the user the menu that
                consists of attributes (from product ID - to status) and user will choose what attrtibute in 
                that specific product ID they want to update*/
                
                switch(choose){//first swtich. this will hell direct the user on what letter they choose
                    /*this will help the user on what SPECIFIC element(s) they want to change w/o modifying other attributes/elements*/
                    case 'A'://case for updating the product ID
                        System.out.print("Enter New Product ID: ");//informing the user the ID they will be updating
                        newID=in.nextInt();//only accepts integer
                        if (id.contains(newID)) {//second if statement
                            System.out.println("The ID is already taken. Please try again.");/*if the user inputted an existing product ID,
                            it will not be accepted by the pogram and will tell the user to try again inputting new product ID to not compromise 
                            the exisiting product ID*/
                        }//end of second if statement
                        else {//second else statement
                           id.set(update, newID);/*is the user input a non existing product ID, the program will automatically change the old product ID
                           into a new product ID desired by the user*/
                        }//end of second else statement
                        break;//end of case A
                    case 'B'://case for updating the product name
                        System.out.print("Enter New Product Name: ");//informing the user on what name they want to change
                        pName=in.nextLine();//there are some instances that the program go to the next line without the user's input
                        pName=in.nextLine();//accepts string value for the name
                        name.set(update, pName);// the program will proceed to change name of the product withour changing the index
                        break;//end of case B
                    case 'C'://case for updating the category of the product
                        System.out.print("Update Category: ");//informing the user to update the category
                        cat=in.nextLine();//user input that accepts string values
                        cg.set(update, cat);//the program will proceed to change category without changing the index
                        break;//end of case C
                    case 'D'://case for updating the price
                        System.out.print("Update Price: ");//informing the user to update the price
                        php=in.nextDouble();//user input that accepts double values
                        price.set(update, php);//the program will procees to change the price without changing the index
                        break;//end of case D
                    case 'E'://case for updating the quantity of the product
                        System.out.print("Update Quantity: ");//informing the user to update the quantity
                        quantity=in.nextInt();//user inpur that accepts integer values
                        qty.set(update, quantity);//the program will process to change the quantity of the product without changing the index
                        break;//end of case E
                    case 'F'://case for changing the date. it has purpose to modify the date if the user made mistakes in date while adding new product
                        System.out.print("Change Date: ");//informing the user to modify the date it was created on
                        created=in.nextLine();//there are some instances that the program go to the next line without the user's input
                        created=in.nextLine();//user input that accepts string values
                        date.set(update, created);//the program will process to change date it was creted on without changing the index
                        break;//end of case F
                    case 'G'://case for updating the status of the product
                        System.out.println("Label: in stock/low stock/out of stock/pending delivery");
                        /* this will print out to help the user to input the status of the object in the inventory
                        indicating whether it is readily available for use, on backorder, or completely unavailable*/
                        System.out.print("Update Status: ");//informing the user to cupdate the status of the product
                        status=in.nextLine();//user input based on the label
                        //once the user is done inputting the update status
                        stat.set(update, status);/* the program, on the other hand, will set the new element 
                        with its specific index number in the arraylist*/
                        break;//end of case G
                    case 'X'://case if the user is done
                        /*once the user is done updating the item in the specific attributes in the ArrayList/LinkedList, he/she
                        can enter X(done) to stop the do while loop or if they are done updating/modifying the attribute of the exisiting object*/
                        System.out.println("-------------------------------------------------------------");//border
                        System.out.println("--- UPDATED PRODUCT INFORMATION ---");//the program will automatically print out these new update product information
                        System.out.println("Item ID: "+id.get(update));// to tell the user that he/she have successfully updated certain elements in the arraylist/linkedList
                        System.out.println("Product Name: "+name.get(update)+"\t\t\tCategory: "+cg.get(update));//name of the product and its category
                        System.out.println("Unit Price: PHP "+price.get(update)+"\t\t\tQuantity: "+qty.get(update));//price of the product and its quantity
                        System.out.println("Created On: "+date.get(update)+"\t\t\tStatus: "+stat.get(update));//date is created on and status of the product
                        System.out.println("-------------------------------------------------------------");//border
                        break;
                    default://if the user input an invalid characer
                        System.out.println("Invalid Character! Please try again.");//the program will print this out
                        break;//end of default case
                }//end of first switch
            } while (choose != 'X');//the do while loop will stop if the user inputted 'X' or until they are satisfied with the elements they updated
        }//end of the first if statement
        else {//first else statement
            System.out.println("Product ID "+itemID+" is not on the list");/*if the user input a non existing product ID,
            it will print this out to inform the user the that the item they are looking for is not on the list*/
        }//end of the first else statement
    }//end of non-statis method for UPDATING AN ITEM
    
    public char displayMenuToUpdate(){/*non-static method for DISPLAYING MENE inside the updating an item.
        it has the return type of char which where the user will be input their choice*/
        Scanner in=new Scanner(System.in);//to help user input
        char choose;//initialization of variable
        System.out.println("-------------------------------------------------------------");//border
        System.out.println("Choose a letter to update");//inform the user to choose
        System.out.println("A. Product ID \t\t\tE. Quantity");//character A for product ID and B for name
        System.out.println("B. Product Name \t\tF. Date");//character C for category and d for price
        System.out.println("C. Category \t\t\tG. Status");//character E for quantity and F for date created
        System.out.println("D. Price \t\t\tX. Done");//character g for status and x when the person is done
        System.out.println("-------------------------------------------------------------");//border
        System.out.print("Enter letter to update: ");//inform the user to input here
        choose=in.next().toUpperCase().charAt(0);//user input that will only accepts the first character and will automatically put that character into uppercase letter
        //even of the person put a lowercase letter
        
        return choose;//it will return the user's input
    }
    
    public void searchAnItem(LinkedList id, LinkedList name, ArrayList cg, ArrayList price, ArrayList qty,
    ArrayList date, ArrayList stat,Scanner in){/*non-static method for SEARCHING AN ITEM in the array list and linked list. 
        in order for the list to search an elements, the attributes is called out in the formal parameter with its corresponding
        data structures*/
        int itemID, searchID;//initialization for user's input and finding its index
        
        System.out.println("*************************************************************");//border ito
        System.out.print("Enter Product ID to Search: ");//informing the user to input a product ID that they want to search
        itemID=in.nextInt();//user input that only accepts integer value (product ID)
        searchID=id.indexOf(itemID);//searchID holds the index of that specific product that the user is looking for 
            
        if (id.contains(itemID)) {//first if statemtent
            /*once the program finds the product ID that the user
            is looking for, it will automatically present to the user the information about that specific product*/
            System.out.println("Product ID "+itemID+" is on the list");//informing the user that the product they looking for is on the list
            System.out.println("--- ITEM INFORMATION ---");//item information
            System.out.println("Item ID: "+id.get(searchID));// it will show first the product ID
            System.out.println("Product Name: "+name.get(searchID)+"\t\t\tCategory: "+cg.get(searchID));//corresponding name of the product and its category
            System.out.println("Unit Price: PHP "+price.get(searchID)+"\t\t\tQuantity: "+qty.get(searchID));//price of the product and its quantity
            System.out.println("Created On: "+date.get(searchID)+"\t\t\tStatus: "+stat.get(searchID));//date the product is created on and current status of the product
        }//end of first if statement
        else {//first else statement
            System.out.println("The Prduct ID of "+itemID+" can not be found in the list");/*if the user search for a non existing product ID,
            it will print this out to inform the user the that the item they are looking for is not occupied*/
        }//end of firt else statement
        System.out.println("*************************************************************");//last border of the code
    }//end of non-static method of SEARCHING FOR AN ITEM/PRODUCT
}//end of the whole code

